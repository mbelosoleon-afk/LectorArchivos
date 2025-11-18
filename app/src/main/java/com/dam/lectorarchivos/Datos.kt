package com.dam.lectorarchivos

import androidx.compose.ui.graphics.Color

enum class Estados(val start_activo: Boolean, val boton_activo: Boolean) {
    INICIO(start_activo = true, boton_activo = false),
    CARGANDO(start_activo = false, boton_activo = false),
    FINALIZANDO(boton_activo = false, start_activo = false)
}

enum class Colores(val color: Color, val txt: String) {
    CLASE_ROJO(color = Color.Red, txt = "Rojo"),
}

enum class EstadosAuxiliares(val txt: String) {
    AUX1(txt = "aux1"),
    AUX2(txt = "aux2"),
    AUX3(txt = "aux3"),
}

object Datos {
    var numero = Int
}