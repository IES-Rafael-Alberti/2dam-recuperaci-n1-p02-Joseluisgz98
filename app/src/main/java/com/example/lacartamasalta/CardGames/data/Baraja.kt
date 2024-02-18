package com.example.lacartamasalta.CardGames.data

import android.content.Context
import com.example.lacartamasalta.R

class Baraja {
    companion object{

        //variable mazo que esta compuesto por una array de cartas
        private val mazo: ArrayList<Carta> = ArrayList()

        /**
         *@param context proporciona información sobre el entorno de la aplicación y permite acceder a recursos como strings, drawables
         * funcion en la que creas una baraja
         */
        fun NuevaBaraja(context: Context){
            mazo.clear()
            var puntos:Int
            for (palo in 0..3){
                for (cont in 0..9){
                    when(cont){
                        else->{
                            puntos = cont
                        }
                    }
                    mazo.add(
                        Carta(
                            Palos.values()[palo],
                            Naipes.values()[cont],
                            puntos,
                            getIdDrawable(
                                context,
                                "${Palos.values()[palo].toString().lowercase()}${cont}")
                        )
                    )
                }
            }
        }

        /**
         * el error que te comente por el correo de que en ocasiones petaba es a raiz de que en ocasiones no encuentra la carta y nose porq
         * pero si encuentra el valor lo que no llega a encontrar es la carta drawble y nose a que es debido dicho error
         */
        private fun getIdDrawable(context: Context, nombreCarta: String): Int {
            val id = context.resources.getIdentifier(nombreCarta, "drawable", context.packageName)
            return if (id == 0) R.drawable.bocaabajo else id
        }
        /**
         * funcuion la cual te da una carta y si esta vacia te da una carta boca abajo
         */
        fun darCarta(): Carta {
            if (mazo.isEmpty()) {
                return Carta(Palos.PORTADA, Naipes.PORTADA, 0, R.drawable.bocaabajo)
            } else {
                return mazo.removeAt(mazo.lastIndex)
            }
        }

        /**
         * Funcion para barajar el mazo
         */
        fun barajar() {
            mazo.shuffle()
        }

    }
}
