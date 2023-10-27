package br.rh.repositorio;
///Es el package interface que contiene las interfaces que extienden de JPA
// para que estas clases se conecten a la base de datos. Estas gestionan
// información ya sea de buscar, borrar, actualizar o crear un registro
// en la base de datos.//

import br.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
///se agrega la entidad Empleado ///
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer > {
}
