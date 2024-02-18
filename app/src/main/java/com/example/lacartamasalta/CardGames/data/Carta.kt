package com.example.lacartamasalta.CardGames.data

import androidx.annotation.DrawableRes
//data class carta la cual guarda los datos de la carta
data class Carta(
    var palo: Palos,
    var nombre:Naipes,
    var puntos:Int,
    @DrawableRes var id:Int
)
