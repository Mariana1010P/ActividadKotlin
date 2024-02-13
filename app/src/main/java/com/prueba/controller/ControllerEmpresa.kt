package com.prueba.controller

import com.prueba.model.Dependencia
import com.prueba.model.Empleado
import com.prueba.model.Empresa

class ControllerEmpresa (var empresa: Empresa){

    fun calcularNomina(): Double{
        var nomina = 0.0
        for (empleado in empresa.getEmpleados()){
            nomina += empleado.getSalario()
        }
        return nomina
    }

    fun calcularNominaDependencia(dependencia: Dependencia): Double{
        var nomina = 0.0
        for (empleado in empresa.getEmpleados()){
            if (empleado.getDependencia().equals(dependencia)){
                nomina += empleado.getSalario()
            }
        }
        return nomina
    }

    fun obtenerClientesPorSexo(sexo:String): Double {
        var contador = 0
        for (clientes in empresa.getClientes()){
            if (clientes.getSexo().equals(sexo)){
                contador++
            }
        }
        return (contador.toDouble() / empresa.getClientes().size) * 100
    }

    fun obtenerEmpleadoPorCargo(nombreCargo: String): Int{
        var contador = 0
        for (empleado in empresa.getEmpleados()) {
            if (empleado.getCargo().getNombre().equals(nombreCargo)) {
                contador++
            }
        }
        return contador
    }

    fun obtenerEmpleadoPorTiempo():Empleado?{
        val empleados = empresa.getEmpleados()
        if (empleados.isEmpty()){
            return null
        }
        var aux : Empleado = empleados[0]
        val anio = 2024

        for (empleado in empleados){
            val tiempo1 = anio - empleado.getAnioIngreso()
            val tiempoAux = anio - aux.getAnioIngreso()

            if (tiempo1 > tiempoAux){
                aux = empleado
            }
        }
        return aux
    }

}