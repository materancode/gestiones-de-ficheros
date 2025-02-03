package es.ies.puerto;


import java.io.File;
import es.ies.puerto.model.Empleado;
import es.ies.puerto.model.fichero.OperacionesFichero;

   /**Materancode */

public class EjemploFile {
    
    public static void main(String[] args) {

        OperacionesFichero operaciones = new OperacionesFichero();
        
        Empleado empleado = new Empleado("00000000H", "dios", 10000);
        boolean insertar = operaciones.create(empleado);
        if (insertar) {
            System.out.println("Se ha insertado el elemento");
        } else {
            System.out.println("No se ha insertado el elemento");
        }
        Empleado buscarEmpleado = new Empleado("00000000H");
        buscarEmpleado = operaciones.search(buscarEmpleado);
        Empleado empleadoUpdate = new Empleado("65645678H","jUAN",20000);

    }    
}