package es.ies.puerto.model;
import java.util.Objects;

public class Empleado {
    String identificador;
    String nombre;
    long sueldo;

    /**Materancode */
    /*Constructor vacio */

    public Empleado(){}

    public Empleado(String identificador){
        this.identificador = identificador;
    }

    public Empleado(String identificador, String nombre, long sueldo){
        this.identificador = identificador;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public long getSueldo() {
        return this.sueldo;
    }

    @Override
    public String toString() {
        return getIdentificador() +"," + getNombre() + "," + getSueldo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    
}
