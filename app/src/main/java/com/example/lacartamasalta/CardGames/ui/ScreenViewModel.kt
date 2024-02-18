package com.example.lacartamasalta.CardGames.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lacartamasalta.CardGames.data.Baraja
import com.example.lacartamasalta.CardGames.data.Carta
import com.example.lacartamasalta.R
class ScreenViewModel(application: Application) : AndroidViewModel(application) {

    // Use un contexto privado para operaciones esenciales
     val context = application.applicationContext

    private val _carta1 = MutableLiveData<Carta>()

    private val _carta2 = MutableLiveData<Carta>()

    private val _idCarta1 = MutableLiveData<Int>()
    val idCarta1: LiveData<Int> = _idCarta1

    private val _idCarta2 = MutableLiveData<Int>()
    val idCarta2: LiveData<Int> = _idCarta2

    private val _ganador = MutableLiveData<Int>()
    val ganador: LiveData<Int> = _ganador

    init {
        reiniciar()
    }

    /**
     * Funcion la cual reinicia la partida
     */
    fun reiniciar() {
        _idCarta1.value = R.drawable.bocaabajo
        _idCarta2.value = R.drawable.bocaabajo
        Baraja.NuevaBaraja(context)
        Baraja.barajar()
    }

    /**
     * Funcion que da carta a ambos jugadores
     */
    fun pedirCarta() {
        _carta1.value = Baraja.darCarta()
        _idCarta1.value = _carta1.value?.id
        _carta2.value = Baraja.darCarta()
        _idCarta2.value = _carta2.value?.id
        comprobarGanador()
    }

    /**
     * Funcion para comprobar quien es el ganador
     */
    private fun comprobarGanador() {
        val puntosJugador1 = _carta1.value?.puntos ?: 0
        val puntosJugador2 = _carta2.value?.puntos ?: 0

        _ganador.value = when {
            puntosJugador1 > puntosJugador2 -> 1
            puntosJugador1 < puntosJugador2 -> 2
            else -> null // Representa un empate
        }
    }
}
