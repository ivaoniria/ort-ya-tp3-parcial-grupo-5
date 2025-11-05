package com.ort.tp3parcialgrupo5.presentation.profile

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.tp3parcialgrupo5.R
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
    onBell: (() -> Unit)? = null
) {
    val popupState by viewModel.popupState.collectAsState()

    // Pass arguments to ViewModel safely and only once.
    LaunchedEffect(key1 = userCreated, key2 = fromLogin) {
        viewModel.handleArguments(userCreated = userCreated, fromLogin = fromLogin)
    }


    HandlePopupState(popupState = popupState, onDismiss = viewModel::dismissPopup)

    BaseLayout(
        contentTop = {
            Header(
                title = stringResource(id = R.string.profile_title),
                onBack = onBack,
                onBell = onBell
            )
            Spacer(Modifier.height(18.dp))
            ProfileInfo(
                imageRes = R.drawable.profilephoto,
                nameRes = R.string.profile_name // Acá
            )
            Spacer(Modifier.height(10.dp))
        },
        contentBottom = {
            item {
                ProfileMenuItem(
                    iconRes = R.drawable.editprofile,
                    textRes = R.string.profile_edit
                )
            }
            item { Spacer(Modifier.height(12.dp)) }

            item {
                ProfileMenuItem(
                    iconRes = R.drawable.icon_security,
                    textRes = R.string.profile_security
                )
            }
            item { Spacer(Modifier.height(12.dp)) }

            item {
                ProfileMenuItem(
                    iconRes = R.drawable.icon_setting,
                    textRes = R.string.profile_setting
                )
            }
            item { Spacer(Modifier.height(12.dp)) }

            item {
                ProfileMenuItem(
                    iconRes = R.drawable.icon_help,
                    textRes = R.string.profile_help
                )
            }
            item { Spacer(Modifier.height(12.dp)) }

            item {
                ProfileMenuItem(
                    iconRes = R.drawable.icon_logout,
                    textRes = R.string.profile_logout
                )
            }
            item { Spacer(Modifier.height(90.dp)) }
        }
    )
}

@Composable
private fun HandlePopupState(popupState: PopupState, onDismiss: () -> Unit) {
    when (popupState) {
        is PopupState.UserCreated -> {
            InfoPopup(
                title = "User created successfully!",
                message = "username: ${popupState.username}\nemail: ${popupState.email}",
                onDismiss = onDismiss
            )
        }
        is PopupState.NoUser -> {
            InfoPopup(
                title = "No user has been created",
                message = "Please create a user in Sign Up.",
                onDismiss = onDismiss
            )
        }
        is PopupState.Hidden -> {
            // Don't show any popup
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
                Text("Accept")
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
