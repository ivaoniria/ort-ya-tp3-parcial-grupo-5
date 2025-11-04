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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginTextField
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent

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
                .background(Color(0xFF0A2F2F), RoundedCornerShape(16.dp))
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
                    text = "New Category",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                LoginTextField(
                    label = "",
                    value = categoryName.value,
                    onValueChange = { categoryName.value = it },
                    placeholder = "Write...",
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
                        text = "Save",
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
                        containerColor = Color(0xFFE8F5E9)
                    ),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = "Cancel",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

