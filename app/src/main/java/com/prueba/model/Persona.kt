package com.prueba.model

open class Persona ( private var nombre: String , private var id: String,
                     private var sexo: String , private var correo: String ){


    fun getNombre () : String {
        return this.nombre
    }

    fun getDocumento () : String {
        return this.id
    }

    fun getCorreo () : String {
        return this.correo
    }

    fun setNombre (nombre : String) {
        this.nombre = nombre
    }

    fun setCorreo (correo : String) {
        this.correo = correo
    }

    fun setSexo (sexo: String){
        this.sexo = sexo
    }

    fun getSexo() :String{
        return this.sexo
    }


}
