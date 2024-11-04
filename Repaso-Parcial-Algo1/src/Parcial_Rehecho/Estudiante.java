package Parcial_Rehecho;
public class Estudiante extends Usuario {
    private int prestamosDisponibles;
    private int prestamosActivos;

    public Estudiante(String nombre, int dni){
        super(nombre, dni);
        this.prestamosActivos = 0;
        this.prestamosDisponibles = 2;
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

    public void setPrestamosActivos(){
        this.prestamosActivos = prestamosActivos + 1;
    }


    @Override
    public String toString(){
        String salida = "Estudiante: " + this.getNombre() + ". Con DNI " + this.getDni();
        return salida;
    }

    



}
