package com.dam.lectorarchivos

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
        viewModelScope.launch{
            delay(1500)
        }
    }


}