package com.ort.tp3parcialgrupo5.core

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
const val TAG = "AppTag"
const val USER_TABLE = "user_table"

fun logMessage(
    message: String
) = Log.e(com.ort.tp3parcialgrupo5.core.TAG, message)

fun showToastMessage(
    context: Context,
    message: String
) = makeText(context, message, LENGTH_LONG).show()

fun showSnackbarMessage(
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    message: String
) = coroutineScope.launch {
    snackbarHostState.showSnackbar(message)
}