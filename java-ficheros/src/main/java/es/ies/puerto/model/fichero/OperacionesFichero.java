package es.ies.puerto.model.fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.model.OperacionesInterface;
import es.ies.puerto.model.Empleado;

   /**Materancode */

public class OperacionesFichero implements OperacionesInterface {
    
    File fichero;
    String path ="";

    public OperacionesFichero(){
        fichero = new File(path);
        if (!fichero.exists() || !fichero.isFile()) {
            throw new IllegalArgumentException("El recurso no es de tipo fichero "+path);
            
        }
    }

    private boolean create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine(); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(fichero);
        if (empleados.contains(empleado)) {
            return false;
            
        }
        return create(empleado.toString(),fichero);
    }

    private Set<Empleado> read(File file) {
        Set<Empleado> empleados = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
               String[] arrayLine = line.split(",");
                Empleado empleado = new Empleado(arrayLine[0],arrayLine[1], Long.valueOf(arrayLine[2]));
                empleados.add(empleado);
            }
        } catch (IOException e) {
            return new HashSet<>();
        }

        return empleados;
    }

    @Override
    public boolean update(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(fichero);
        if (!empleados.contains(empleado)) {
              return false;
    }
    for (Empleado empleadoBuscar : empleados) {
        if (empleadoBuscar.equals(empleado)) {
            empleados.remove(empleadoBuscar);
            empleados.add(empleado);
        }
    }
    return true;
 }

 private boolean updateFile(Set<Empleado> empleados, File file) {
    String path = file.getAbsolutePath();

    try {
        file.delete();
        file.createNewFile();
    } catch (Exception e) {
        return false;
    }
    for (Empleado empleado : empleados) {
        create(empleado);
    }
    return true;
  
 }

    @Override
    public boolean delete(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(fichero);
        if (!empleados.contains(empleado)) {
              return false;
    }
    for (Empleado empleadoBuscar : empleados) {
        if (empleadoBuscar.equals(empleado)) {
            empleados.remove(empleadoBuscar);
        }
    }
    return true;
 }


    @Override
    public Empleado search(Empleado empleado) {

        if (empleado == null || empleado.getIdentificador() == null) {
            return empleado;
            
        }
        Set<Empleado> empleados = read(fichero);
        for (Empleado personaBuscar : empleados) {
            if (personaBuscar.equals(empleado)) {
            }
            return personaBuscar;
        }
       return empleado;
    }

    @Override
    public Empleado search(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return null;
        }
       Empleado empleado = new Empleado(identificador);
       return search(empleado);
    }
    
}
