package br.rh.controlador;
///Tiene clases con el objetivo principal de conectar el backend
// con las solicitudes que se hagan desde afuera de la aplicación
// (sistemas web, unirest, entre otros)

import br.rh.excepcion.RecursoNoEncontradoExcepcio;
import br.rh.modelo.Empleado;
import br.rh.servicio.EmpleadoServicio;
import br.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
//http://localhost:8080/rh-app/
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired

    private IEmpleadoServicio empleadoServicio;

//http://localhost:8080/rh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();

        ///instancia para ver en consola//
         empleados.forEach((empleado -> logger.info(empleado.toString())));
            return empleados;
    }

////metodo para  agregar un registro///
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
            logger.info("Empleado agregado con exito: " + empleado);
            return empleadoServicio.guardarEmpleado(empleado);
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id){
         Empleado empleado =  empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null)
            throw new RecursoNoEncontradoExcepcio("NO SE ENCONTRO EL EMPLEADO CON EL :" + id);
        return  ResponseEntity.ok(empleado);
    }

    ///metodo para modificar empelado////
    @PutMapping("/empleados/{id}")
    
    public ResponseEntity<Empleado> actualizarEmpleado
            (@PathVariable Integer id,
             @RequestBody Empleado empleadoReicibido ){
Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null)
            throw new RecursoNoEncontradoExcepcio("EL ID RECIBIDO NO EXISTE :" + id);
        empleado.setNombre(empleadoReicibido.getNombre());
        empleado.setDepartamento(empleadoReicibido.getDepartamento());
        empleado.setSueldo(empleadoReicibido.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
     public ResponseEntity<Map<String, Boolean>>
    eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id );

        if (empleado == null)
            throw new RecursoNoEncontradoExcepcio("EL ID RECIBIDO NO EXISTE :" + id);
        empleadoServicio.eliminarEmpleado(empleado);
        //muetra en JSON en postman {"eliminado": True}///
        Map<String, Boolean> respuesta = new  HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    
}
