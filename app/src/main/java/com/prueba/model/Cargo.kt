package com.prueba.model

class Cargo (private val nombre: String,
private var nivel: Int) {

    fun getNombre () : String {
        return this.nombre
    }

    fun getNivel () : Int {
        return this.nivel
    }

    fun setNivel (nivel: Int) {
        this.nivel = nivel
    }
}