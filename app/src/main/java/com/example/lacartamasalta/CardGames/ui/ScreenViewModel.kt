package com.example.lacartamasalta.CardGames.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lacartamasalta.CardGames.data.Baraja
import com.example.lacartamasalta.CardGames.data.Carta
import com.example.lacartamasalta.R

class ScreenViewModel(application: Application): AndroidViewModel(application) {

    val context = application.applicationContext

    val ganador = MutableLiveData<Any>()

    //Este LiveData se utiliza para observar y notificar cambios en la interfaz de usuario
    private val _idCarta1 = MutableLiveData<Int>()
    val idCarta1 : LiveData<Int> = _idCarta1
    private val _idCarta2 = MutableLiveData<Int>()
    val idCarta2 : LiveData<Int> = _idCarta2


    //Variable de las cartas de los jugadores
    var carta1 = MutableLiveData<Carta>()
    var carta2 = MutableLiveData<Carta>()

    init {
        reiniciar(context)
    }
    fun reiniciar(context: Context){
        _idCarta1.value = R.drawable.bocaabajo
        _idCarta2.value = R.drawable.bocaabajo
        Baraja.NuevaBaraja(context)
        Baraja.barajar()
    }
    fun pedirCarta(){
        carta1.value = Baraja.darCarta()
        _idCarta1.value = carta1.value?.id
        carta2.value = Baraja.darCarta()
        _idCarta2.value = carta2.value?.id
        comprobarGanador()
    }
    fun comprobarGanador(){
        val puntosJugador1 = carta1.value?.puntos ?: 0
        val puntosJugador2 = carta2.value?.puntos ?: 0

        if (puntosJugador1 > puntosJugador2) {
            ganador.value = 1
        } else if (puntosJugador1 < puntosJugador2) {
            ganador.value = 2
        } else {
            ganador.value = "Empate"
        }
    }
}
