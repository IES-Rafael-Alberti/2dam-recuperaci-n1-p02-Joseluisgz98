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
import androidx.compose.ui.unit.sp

@Composable
fun Principal(viewModel: ScreenViewModel) {
    val idCarta1: Int by viewModel.idCarta1.observeAsState(initial = R.drawable.bocaabajo)
    val idCarta2: Int by viewModel.idCarta2.observeAsState(initial = R.drawable.bocaabajo)
    val ganador: Int? by viewModel.ganador.observeAsState() // Observe ganador

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text ="Jugador 1", color = Color.Black)
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(228.dp)
            ) {
                Image(
                    painter = painterResource(id = idCarta1),
                    contentDescription = "CartaJugador1",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text ="Jugador 2", color = Color.Black)

            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(228.dp)
            ) {
                Image(
                    painter = painterResource(id = idCarta2),
                    contentDescription = "CartaJugador2",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { viewModel.reiniciar() }, Modifier.padding(10.dp)) {
                Text(text = "Reiniciar")
            }
            Button(onClick = { viewModel.pedirCarta() }, Modifier.padding(10.dp)) {
                Text(text = "Dar Carta")
            }
        }
        //Esta línea comprueba si la variable ganador es null. Si no es null, se ejecuta el bloque de código dentro de las llaves.
        ganador?.let {
            Text(text = "Ganador: Jugador $it", color = Color.Red, fontSize = 20.sp)
        }
    }
}


