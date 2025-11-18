package com.dam.lectorarchivos

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IU(miViewModel: MyViewModel) {
    Interfaz(miViewModel)
}

@Composable
fun Interfaz(miViewModel: MyViewModel) {

    val progresoObtenido by miViewModel._progresoFlow.collectAsState()
    val estadoObtenido by miViewModel._estadoFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Progreso(progresoObtenido)
            Estado(estadoObtenido)
            Boton(miViewModel, Colores.CLASE_ROJO)
        }
    }

}


@Composable
fun Progreso(progreso: Int){
    Text(text = "progreso: $progreso%")
}

@Composable
fun Estado(estado: Estados){
    Text(text = "estado: $estado")
}

@Composable
fun Boton(viewModel: MyViewModel, enum_color: Colores) {
    val estado = viewModel._estadoFlow.collectAsState().value
    Button(
        enabled = estado.start_activo,
        onClick = {
            Log.d("Juego", "Empieza la partida")
            viewModel.numeroRandom()
        }) {
        Text(text = "Start")
    }
}

@Preview(showBackground = true)
@Composable
fun IUPreview(){
    IU(miViewModel = MyViewModel())
}