//Una póliza de seguro tiene asociado un cliente, el cual tiene un nombre, apellido y fecha de nacimiento
package Aseguradora;

import java.time.LocalDate;
import java.time.Period;

public class Cliente{
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;

    }
    public int getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String toString(){
        String salida = "Cliente: " + nombre + ", " + apellido + " (" + this.getEdad() + ").";
        return salida;
    }
}