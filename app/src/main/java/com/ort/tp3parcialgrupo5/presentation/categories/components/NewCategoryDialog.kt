package com.ort.tp3parcialgrupo5.presentation.categories.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginTextField
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.CategoryDialogBackground
import com.ort.tp3parcialgrupo5.ui.theme.CategoryButtonCancelColor

@Composable
fun NewCategoryDialog(
    onDismiss: () -> Unit,
    onSave: (String) -> Unit
) {
    val categoryName = remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = onDismiss,
        properties = androidx.compose.ui.window.DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Box(
            modifier = Modifier
                .background(CategoryDialogBackground, RoundedCornerShape(16.dp))
                .padding(24.dp)
                .width(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.new_category_title),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                LoginTextField(
                    label = "",
                    value = categoryName.value,
                    onValueChange = { categoryName.value = it },
                    placeholder = stringResource(R.string.new_category_placeholder),
                    isPassword = false
                )

                Button(
                    onClick = {
                        if (categoryName.value.isNotEmpty()) {
                            onSave(categoryName.value)
                            onDismiss()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CyanAccent,
                        disabledContainerColor = CyanAccent
                    ),
                    shape = RoundedCornerShape(50.dp),
                    enabled = categoryName.value.isNotEmpty()
                ) {
                    Text(
                        text = stringResource(R.string.new_category_save),
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CategoryButtonCancelColor
                    ),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.new_category_cancel),
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

