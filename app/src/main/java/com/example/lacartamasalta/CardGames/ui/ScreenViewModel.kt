package com.example.lacartamasalta.CardGames.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ScreenViewModel(application: Application): AndroidViewModel(application) {
    val context = MutableLiveData<Context>(getApplication<Application>().applicationContext)
}