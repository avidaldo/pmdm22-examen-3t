package com.example.pmdm22_examen_3t.ui.screens.list_users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm22_examen_3t.R
import com.example.pmdm22_examen_3t.data.model.Client

@Composable
fun UserListItem(
    client: Client,
    onCheckedChange: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showPasswordRow by rememberSaveable { mutableStateOf(false) } // (1)

    Column(
        modifier = modifier
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .clickable { showPasswordRow = !showPasswordRow }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 20.dp, vertical = 14.dp),
            ) {
                Text(text = client.username, fontSize = 25.sp)
                Text(
                    text = client.email,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }
            Checkbox(
                checked = client.checked,
                onCheckedChange = { onCheckedChange() }
            )
            IconButton(onClick = onDelete) {
                Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.delete))
            }
        }
        if (showPasswordRow) PasswordRow(client.password)
    }
}

/**
 * (1)
 * Tiene sentido no estraer al ViewModel esta variable de estado ya que no nos importa mantener ese
 * estado. Cada vez que se vuelve a entrar en la lista las filas de contraseñas vuelven a estar ocultas.
 */


