package com.example.pmdm22_examen_3t.ui.screens.list_users

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmdm22_examen_3t.data.model.Client

@Composable
fun UserLazyList(
    list: List<Client>,
    onCheckedChange: (String) -> Unit,
    onRemoveClient: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier.padding(5.dp)) {
        items(items = list, key = { it.username }) { client ->
            UserListItem(client = client,
                onCheckedChange = { onCheckedChange(client.username) },
                onDelete = { onRemoveClient(client.username) })
        }
    }
}