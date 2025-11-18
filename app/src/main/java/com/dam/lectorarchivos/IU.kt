package com.dam.lectorarchivos

import android.text.Layout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IU(miViewModel: MyViewModel) {
    Interfaz(miViewModel)
}

@Composable
fun Interfaz(miViewModel: MyViewModel) {

    val progresoObtenido by miViewModel._progresoFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Progreso(progresoObtenido)
        }
    }

}


@Composable
fun Progreso(progreso: Int){
    Text(text = "progreso: $progreso")
}


@Preview(showBackground = true)
@Composable
fun IUPreview(){
    IU(miViewModel = MyViewModel())
}