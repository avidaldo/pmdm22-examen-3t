package com.example.pmdm22_examen_3t.ui.screens.signin

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pmdm22_examen_3t.R

@Composable
fun ResultDialog(
    titleString: String,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier,
    confirmString: String = stringResource(R.string.ok),
) {
    AlertDialog(
        onDismissRequest = onConfirm,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = confirmString)
            }
        },
        modifier = modifier,
        title = { Text(text = titleString) },
    )
}

