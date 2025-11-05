package com.ort.tp3parcialgrupo5.presentation.profile


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.profile.components.ProfileInfo
import com.ort.tp3parcialgrupo5.presentation.profile.components.ProfileMenuItem

@Composable
fun ProfileScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
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
                nameRes = R.string.profile_name
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileScreen()
    }
}