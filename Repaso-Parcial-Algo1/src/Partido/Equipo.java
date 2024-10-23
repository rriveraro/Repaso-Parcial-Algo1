package Partido;

public class Equipo {
    private String nombre;
    private int fans;
    private int puntos;

    public Equipo(String nombre, int fans){
        this.nombre = nombre;
        this.fans = fans;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }



}
