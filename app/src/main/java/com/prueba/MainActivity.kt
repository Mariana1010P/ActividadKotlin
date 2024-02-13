package com.prueba

import com.prueba.model.Cargo
import com.prueba.model.Dependencia
import com.prueba.model.Empleado
import com.prueba.model.Empresa
import com.prueba.model.Persona

fun main(){
    val dividendo = 26
    val divisor = 2
    print(dividirPorRestasSucesivas(dividendo, divisor))

    var empresa : Empresa = Empresa("Arpo Shop","Las americas", 1234534)
    var persona1 :Empleado = Empleado("mariana","1010","Femenino","mariana@gmail.com", Cargo("Lider",2),5000.0,2022, Dependencia.RECURSOS_HUMANOS)

    val registro1 = empresa.registrarEmpleado(persona1)
    print("\n"+persona1.getNombre())
}

fun dividirPorRestasSucesivas (dividendo: Int, divisor: Int):Int {
    if(dividendo < divisor){
        return 0;
    }
    return 1 + dividirPorRestasSucesivas(dividendo - divisor, divisor);
}