package br.rh.servicio;

import br.rh.modelo.Empleado;

import java.util.List;

////Este package tiene las interfaces
// donde se declaran los métodos que contienen la lógica.
public interface IEmpleadoServicio {
    //metodo para mostrar el objeto de la entidad///
    public List<Empleado> listarEmpleados();
    ///metodo para buscar por ID///
    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    public Empleado guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
