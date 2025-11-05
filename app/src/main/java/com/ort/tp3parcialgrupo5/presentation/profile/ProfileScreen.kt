package com.ort.tp3parcialgrupo5.presentation.profile

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.core.logMessage
import com.ort.tp3parcialgrupo5.core.showSnackbarMessage
import com.ort.tp3parcialgrupo5.core.showToastMessage
import com.ort.tp3parcialgrupo5.domain.model.Response
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.profile.components.ProfileInfo
import com.ort.tp3parcialgrupo5.presentation.profile.components.ProfileMenuItem

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    userCreated: Boolean = false,
    fromLogin: Boolean = false,
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null,
    onLoggedOut: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val resources = context.resources
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val popupState by viewModel.popupState.collectAsState()
    val username by viewModel.username.collectAsState()
    val logoutState by viewModel.logoutState.collectAsState()

    LaunchedEffect(userCreated, fromLogin) {
        viewModel.handleArguments(userCreated = userCreated, fromLogin = fromLogin)
        viewModel.loadProfileUser()
    }

    when (val state = popupState) {
        is PopupState.UserCreated -> {
            LaunchedEffect(state.username, state.email) {
                val msg = resources.getString(R.string.created_success)
                logMessage("UserCreated -> ${state.username} / ${state.email}")
                showToastMessage(context, msg)
                showSnackbarMessage(coroutineScope, snackbarHostState, msg)
            }
        }
        is PopupState.NoUser -> {
            LaunchedEffect(Unit) {
                val msg = resources.getString(R.string.no_user_created_message)
                logMessage(msg)
                showToastMessage(context, msg)
            }
        }
        is PopupState.Hidden -> Unit
    }

    when (val state = logoutState) {
        is Response.Idle -> {}
        is Response.Loading -> {}
        is Response.Success -> LaunchedEffect(Unit) {
            val msg = resources.getString(R.string.logout_success_message)
            logMessage("Logout success")
            showToastMessage(context, msg)
            showSnackbarMessage(coroutineScope, snackbarHostState, msg)
            viewModel.resetLogoutState()
            onLoggedOut?.invoke()
        }
        is Response.Failure -> state.e.message?.let { errorMessage ->
            LaunchedEffect(errorMessage) {
                logMessage("Logout error: $errorMessage")
                showToastMessage(context, resources.getString(R.string.logout_failure_message))
                showSnackbarMessage(
                    coroutineScope, snackbarHostState,
                    resources.getString(R.string.logout_failure_message)
                )
                viewModel.resetLogoutState()
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        contentWindowInsets = WindowInsets(0),
        containerColor = Color.Transparent
    ) { innerPadding: PaddingValues ->

        HandlePopupState(popupState = popupState, onDismiss = viewModel::dismissPopup)

        BaseLayout(
            contentTop = {
                Header(
                    title = stringResource(id = R.string.profile_title),
                    onBack = onBack,
                    onBell = onBell
                )

                ProfileInfo(
                    imageRes = R.drawable.profilephoto,
                    nameRes = R.string.profile_name,
                    nameOverride = username
                )

                Spacer(Modifier.height(10.dp))
            },
            contentBottom = {
                item { Spacer(Modifier.height(37.dp)) }

                item {
                    ProfileMenuItem(
                        iconRes = R.drawable.editprofile,
                        textRes = R.string.profile_edit,
                        iconWidth = 57.dp,
                        iconHeight = 53.dp,
                        gapIconText = 34.dp
                    )
                }
                item { Spacer(Modifier.height(12.dp)) }

                item { ProfileMenuItem(iconRes = R.drawable.icon_security, textRes = R.string.profile_security) }
                item { Spacer(Modifier.height(12.dp)) }

                item { ProfileMenuItem(iconRes = R.drawable.icon_setting, textRes = R.string.profile_setting) }
                item { Spacer(Modifier.height(12.dp)) }

                item { ProfileMenuItem(iconRes = R.drawable.icon_help, textRes = R.string.profile_help) }
                item { Spacer(Modifier.height(12.dp)) }

                item {
                    ProfileMenuItem(
                        iconRes = R.drawable.icon_logout,
                        textRes = R.string.profile_logout,
                        onClick = { viewModel.logout() }
                    )
                }
            }
        )
    }
}

@Composable
private fun HandlePopupState(popupState: PopupState, onDismiss: () -> Unit) {
    when (popupState) {
        is PopupState.UserCreated -> {
            InfoPopup(
                title = stringResource(id = R.string.created_success),
                message = stringResource(
                    id = R.string.created_success_message,
                    popupState.username,
                    popupState.email
                ),
                onDismiss = onDismiss
            )
        }
        is PopupState.Hidden -> Unit
        is PopupState.NoUser -> {
            InfoPopup(
                title = stringResource(id = R.string.attention_title),
                message = stringResource(id = R.string.no_user_created_message),
                onDismiss = onDismiss
            )
        }
    }
}

@Composable
private fun InfoPopup(title: String, message: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.accept))
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileScreen(userCreated = false, fromLogin = false)
    }
}
