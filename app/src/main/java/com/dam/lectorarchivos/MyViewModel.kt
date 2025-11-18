package com.dam.lectorarchivos

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class MyViewModel(): ViewModel() {
    val _estadoFlow: MutableStateFlow<Estados> = MutableStateFlow(Estados.INICIO)

    val _progresoFlow = MutableStateFlow<Int>(0)

    val _resultadoFlow = MutableStateFlow<Int>(0)


    fun simularLectura(){
        viewModelScope.launch {
            // guardamos el estado auxiliar
            var estadoAux = EstadosAuxiliares.AUX1

            // hacemos un cambio a tres estados auxiliares
            Log.d("EstadoCorrutina", "estado (corutina): ${estadoAux}")
            delay(1500)
            estadoAux = EstadosAuxiliares.AUX2
            Log.d("EstadoCorrutina", "estado (corutina): ${estadoAux}")
            delay(1500)
            estadoAux = EstadosAuxiliares.AUX3
            Log.d("EstadoCorrutina", "estado (corutina): ${estadoAux}")
            delay(1500)
        }
    }

    fun numeroRandom(){
        _estadoFlow.value = Estados.CARGANDO
        Log.d("ViewModel","Estado generando")
        _progresoFlow.value = (0..10).random()
        Log.d("ViewModel","Número random generado: $_progresoFlow")
        sumaNumero(_progresoFlow.value)
    }

    fun sumaNumero(numero: Int){
        Log.d("ViewModel","Actualizando el numero")
        for(n in numero..100 step 10)
        _progresoFlow.value = numero
        _estadoFlow.value = Estados.CARGANDO
    }

}