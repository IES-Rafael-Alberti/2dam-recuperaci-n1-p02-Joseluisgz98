package com.example.lacartamasalta.CardGames.data

import androidx.annotation.DrawableRes
data class Carta(
    var palo: Palos,
    var nombre:Naipes,
    var puntos:Float,
    @DrawableRes var id:Int
)
