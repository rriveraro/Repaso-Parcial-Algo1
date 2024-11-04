package Parcial_Rehecho;

import java.time.LocalDate;
import java.time.Period;

public class Docente extends Usuario {
    private int aniosDeAntiguedad;
    private int prestamosDisponibles;
    private int prestamosActivos;

    public Docente(String nombre, int dni, LocalDate fechaIngreso){
        super(nombre, dni);
        this.aniosDeAntiguedad = calcularAniosDeAntigueda(fechaIngreso);
        this.prestamosDisponibles = aniosDeAntiguedad;
        this.prestamosActivos = 0;
    }

    public int getAniosDeAntiguedad() {
        return aniosDeAntiguedad;
    }

    private int calcularAniosDeAntigueda(LocalDate fechaIngreso){
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaIngreso, fechaActual).getYears();
    }

    public int getPrestamosDisponibles(){
        return prestamosDisponibles;
    }
    public int setPrestamosDisponibles(){
        this.prestamosDisponibles = prestamosDisponibles-1;
        return prestamosDisponibles;
    }

    public int getPrestamosActivos(){
        return prestamosActivos;
    }

    public int setPrestamosActivos(){
        this.prestamosActivos = prestamosActivos + 1;
        return prestamosActivos;
    }

    @Override
    public String toString(){
        String salida = "Docente: " + this.getNombre() + ". Con DNI " + this.getDni() + ". Años de antiguedad: " + this.getAniosDeAntiguedad();
        return salida;
    }
    

}

