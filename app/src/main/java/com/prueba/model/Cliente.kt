package com.prueba.model

class Cliente (nombre: String , id: String, sexo: String ,
               correo: String, private var direccion : String,
               private var telefono: String) : Persona(nombre, id, sexo, correo) {

    fun getDireccion () : String {
        return this.direccion
    }

    fun getTelefono () : String {
        return this.telefono
    }

    fun setDireccion (direccion: String) {
        this.direccion = direccion
    }

    fun setTelefono (telefono: String) {
        this.telefono = telefono
    }
}