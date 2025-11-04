import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun LoginFooter() {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)) {
            append(stringResource(id = R.string.use_fingerprint))
        }
        withStyle(style = SpanStyle(color = colorResource(id = R.color.main_green))) {
            append(stringResource(id = R.string.fingerprint))
        }
        withStyle(style = SpanStyle(color = Color.White)) {
            append(stringResource(id = R.string.to_access))
        }
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = annotatedString, style = AppTypography.bodyLarge)
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.or_sign_up_with), color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = stringResource(id = R.string.facebook_desc)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = stringResource(id = R.string.google_desc)
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.dont_have_account), color = Color.Gray)
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.sign_up), color = colorResource(id = R.color.main_green))
        }
    }
}