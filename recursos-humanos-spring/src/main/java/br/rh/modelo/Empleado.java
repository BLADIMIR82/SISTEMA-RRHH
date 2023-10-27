package br.rh.modelo;
//Sera el package donde se almacenarán
// todos los objetos de la aplicación.
///clase  de ENTIDAD creacion de la tabla//
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//representa y crea la tabla de empleado en la base de datos ///
@Entity
///metodo que genera los gets y set por cada atributo automaticamente//
@Data
///contructores
@NoArgsConstructor
@AllArgsConstructor
///metodo para imprimir el objeto en consola //
@ToString
public class Empleado {
    ///creacion de la llave primaria///
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
     ///columnas de la base de datos
    Integer idEmpleado;
    String nombre;
    String departamento;
    Double sueldo;
   // @Lob
   // byte  [] imagen;
}
