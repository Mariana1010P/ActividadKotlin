package com.prueba.model

class Empleado ( nombre: String , id: String, sexo: String ,
                 correo: String, private var cargo: Cargo,
                 private var salario : Double, private var anioIngreso : Int, private var dependencia: Dependencia,
                 private var subordinados: MutableList<Empleado> = mutableListOf()) : Persona(nombre, id, sexo, correo) {


    fun getSalario () : Double {
        return this.salario
    }

    fun getDependencia () : Dependencia {
        return this.dependencia
    }

    fun getSubordinados () : List<Empleado> {
        return this.subordinados
    }

    fun getCargo () : Cargo {
        return this.cargo
    }

    fun setAnioIngreso (anioIngreso : Int) {
        this.anioIngreso = anioIngreso
    }

    fun getAnioIngreso () : Int {
        return this.anioIngreso
    }

    fun setSalario (salario : Double) {
        this.salario = salario
    }

    fun setDependencia (dependencia: Dependencia) {
        this.dependencia = dependencia
    }

    fun setCargo (cargo: Cargo) {
        this.cargo = cargo
    }

    fun buscarSubordinado(id: String): Empleado?{
        for (subordinado in subordinados){
            if (subordinado.getDocumento().equals(id)){
                return subordinado
            }
        }
        return null
    }


    fun agregarSubordinado(empleado: Empleado): Boolean{
        val aux = this.buscarSubordinado(empleado.getDocumento())
        if (aux != null){
            return subordinados.add(empleado)
        }
        return false
    }

    fun eliminarSubordinado(id: String): Boolean{
        val subordinado = buscarSubordinado(id)
        if (subordinado != null){
            return subordinados.remove(subordinado)
        }
        return false
    }
}