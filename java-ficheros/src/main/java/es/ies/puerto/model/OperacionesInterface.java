package es.ies.puerto.model;

    /**Materancode */

/**Las interfaces son solo para los metodos */
public interface OperacionesInterface {
    public boolean create(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(Empleado empleado);
    public Empleado search(Empleado empleado);
    public Empleado search(String identificador);
}
