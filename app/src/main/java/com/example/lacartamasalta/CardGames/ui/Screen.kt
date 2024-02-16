package com.example.lacartamasalta.CardGames.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lacartamasalta.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun Principal(viewModel: ScreenViewModel) {
    val idCarta1: Int by viewModel.idCarta1.observeAsState(initial = R.drawable.bocaabajo)
    val idCarta2: Int by viewModel.idCarta2.observeAsState(initial = R.drawable.bocaabajo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        JugadorCarta("Jugador 1:", idCarta1)
        JugadorCarta("Jugador 2:", idCarta2)

        Botones(viewModel)
    }
}

@Composable
fun JugadorCarta(texto: String, idCarta: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = texto, color = Color.Black)

        Card(
            modifier = Modifier
                .width(150.dp)
                .height(228.dp)
        ) {
            Image(
                painter = painterResource(id = idCarta),
                contentDescription = "Carta",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun Botones(viewModel: ScreenViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { viewModel.reiniciar(viewModel.context) }, Modifier.padding(10.dp)) {
            Text(text = "Reiniciar")
        }
        Button(onClick = { viewModel.darCartas() }, Modifier.padding(10.dp)) {
            Text(text = "Dar Carta")
        }
    }
}
