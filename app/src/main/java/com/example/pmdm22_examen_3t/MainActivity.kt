package com.example.pmdm22_examen_3t

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pmdm22_examen_3t.ui.navigation.Navigation
import com.example.pmdm22_examen_3t.ui.state.ClientsViewModel
import com.example.pmdm22_examen_3t.ui.theme.Pmdm22examen3tTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pmdm22examen3tTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel : ClientsViewModel = viewModel()  // (1)
                    Navigation(viewModel)
                }
            }
        }
    }
}

/**
 * (1)
 * Creo el viewmodel aquí para pasarlo como parámetro y que sea común a los dos ejericicios
 * TODO: Lo creo con la librería de compose, pero ya que solo va a haber uno para toda la activity,
 *  podría intanciar un viewmodel con la librería básica de lifecicle, como se hacía antes.
 */