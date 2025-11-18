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