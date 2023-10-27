
package br.rh.servicio;
///las clases donde se aplica la lógica.///

import br.rh.modelo.Empleado;
import br.rh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio {
////conexion al repositorio Empleado repositorio///
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    ///regresa una lista objetos de Empleado
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }
///buscar empleado por Id///
    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
       Empleado empleado =empleadoRepositorio.findById(idEmpleado).orElse(null);
    return empleado;
    }
//guarda empleado
    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
///elimina empleado////
    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
