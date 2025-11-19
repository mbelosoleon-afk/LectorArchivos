package com.dam.lectorarchivos

import android.util.Log
import androidx.compose.animation.core.EaseInSine
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class MyViewModel(): ViewModel() {
    val _estadoFlow: MutableStateFlow<Estados> = MutableStateFlow(Estados.INICIO)

    val _progresoFlow = MutableStateFlow<Float>(0F)

    var numeroRandom = 0

    fun generarRandom(){
        numeroRandom = (1..10).random()
        Log.d("ViewModel", "$numeroRandom")
        descargar(numeroRandom)
    }

    fun descargar(numero: Int){
        viewModelScope.launch {
            _progresoFlow.value = 0F
            _estadoFlow.value = Estados.CARGANDO
            while(_progresoFlow.value < 100){
                _progresoFlow.value += 10
                delay(300*numero.toLong())
                Log.d("ViewModel","$_progresoFlow")
            }
            _estadoFlow.value = Estados.FINALIZANDO
        }
    }
}