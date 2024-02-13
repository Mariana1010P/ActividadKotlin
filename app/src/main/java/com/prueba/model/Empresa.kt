package com.prueba.model

class Empresa (private var nombre: String, private var direccion :String,
    private var nit: Long, private var personas: MutableList<Persona> = mutableListOf()){

    init {
        personas.add(Empleado("Sebastian Arce", "1007438077", "Masculine","arce.sebas@gmail.com",
            Cargo("Jefe",6),6400.0,2018,Dependencia.GERENCIA))
    }

    fun getNombre () : String {
        return this.nombre
    }

    fun getNit () : Long {
        return this.nit
    }

    fun getDireccion () : String {
        return this.direccion
    }

    fun getPersonas () : List<Persona> {
        return this.personas
    }

    fun getEmpleados () : List<Empleado> {
        return this.personas.filterIsInstance<Empleado>()
    }

    fun getClientes () : List<Cliente> {
        return this.personas.filterIsInstance<Cliente>()
    }





    fun buscarPersona(id: String): Persona?{
        for (persona in personas){
            if (persona.getDocumento().equals(id)){
                return persona
            }
        }
        return null
    }

    fun buscarEmpleado(id: String): Empleado? {
        for (empleado in getEmpleados()){
            if (empleado.getDocumento().equals(id)){
                return empleado
            }
        }
        return null
    }
    fun registrarEmpleado (empleado: Empleado ): Boolean{
        val auxiliar = this.buscarPersona(empleado.getDocumento())
        if (auxiliar == null){
            personas.add(empleado)
            return true
        }
        return false
    }

    fun eliminarPersona (id: String): Boolean{
        val auxiliar : Persona? = this.buscarPersona(id)
        if (auxiliar!= null){
            personas.remove(auxiliar)
            return true
        }
        return false
    }

    fun editarEmpleado (empleado: Empleado): Boolean{
        if (empleado != null){
            val auxiliar = this.buscarEmpleado(empleado.getDocumento())
            if (auxiliar != null){
                auxiliar.setNombre(empleado.getNombre())
                auxiliar.setCorreo(empleado.getCorreo())
                auxiliar.setSexo(empleado.getSexo())
                auxiliar.setAnioIngreso(empleado.getAnioIngreso())
                auxiliar.setCargo(empleado.getCargo())
                auxiliar.setDependencia(empleado.getDependencia())
                auxiliar.setSalario(empleado.getSalario())
            }
            return true
        }
        return false
    }


    fun buscarCliente(id: String): Cliente? {
        for (cliente in getClientes()){
            if (cliente.getDocumento().equals(id)){
                return cliente
            }
        }
        return null
    }

    fun registrarCliente (cliente: Cliente ): Boolean{
        val auxiliar = this.buscarPersona(cliente.getDocumento())
        if (auxiliar == null){
            personas.add(cliente)
            return true
        }
        return false
    }

    fun editarCliente (cliente: Cliente): Boolean{
        if (cliente != null){
            val auxiliar = this.buscarCliente(cliente.getDocumento())
            if (auxiliar != null){
                auxiliar.setNombre(cliente.getNombre())
                auxiliar.setCorreo(cliente.getCorreo())
                auxiliar.setSexo(cliente.getSexo())
                auxiliar.setDireccion(cliente.getDireccion())
                auxiliar.setTelefono(cliente.getTelefono())
            }
            return true
        }
        return false
    }

    fun agregarSubordinados(idSubordinado:String, id: String): Boolean{
        if (id != idSubordinado){
            var empleadoAux = this.buscarEmpleado(id)
            var subordinado = this.buscarEmpleado(idSubordinado)
            if (empleadoAux != null && subordinado != null){
                return empleadoAux.agregarSubordinado(subordinado)
            }
        }
        return false
    }
}
