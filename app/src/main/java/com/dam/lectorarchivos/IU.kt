package com.dam.lectorarchivos

import android.text.Layout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IU(myViewModel: MyViewModel){
    Interfaz(myViewModel)
}

@Composable
fun Interfaz(myViewModel: MyViewModel){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(Modifier.padding(16.dp)) {
            Row{
                MostrarEstado(myViewModel)
            }
            Row{
                Boton(myViewModel)
            }
            Row{
                MostrarPorcentaje(myViewModel)
            }
        }
    }
}

@Composable
fun Boton(myViewModel: MyViewModel){
    Button(
        onClick = {
            myViewModel.generarRandom()
        }
    ){
        Text(text = "Descarga")
    }
}

@Composable
fun MostrarEstado(myViewModel: MyViewModel){
    val estadoActual = myViewModel._estadoFlow.collectAsState().value
    Text(text = "Estado actual: $estadoActual")
}

@Composable
fun MostrarPorcentaje(myViewModel: MyViewModel){
    val porcentaje = myViewModel._progresoFlow.collectAsState().value
    LinearProgressIndicator(progress = porcentaje * 0.01F)
}

@Preview(showBackground = true)
@Composable
fun IUPreview(){
    IU(myViewModel = MyViewModel())
}