package com.example.pmdm22_examen_3t.ui.screens.list_users

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pmdm22_examen_3t.R
import com.example.pmdm22_examen_3t.ui.state.ClientsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientsListScreen(viewModel: ClientsViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title)) },
            )
        },
        floatingActionButton = {
            if (viewModel.clientList.any { it.checked }) {
                FloatingActionButton(onClick = { viewModel.removeCheckedProducts() }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(R.string.delete)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->
        UserLazyList(
            list = viewModel.clientList,
            onCheckedChange = { viewModel.changeChecked(it) },
            onRemoveClient = { viewModel.removeClient(it) },
            modifier = Modifier.padding(paddingValues),
        )
    }
}