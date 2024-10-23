package Partido2;

import java.util.Objects;

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

    // Sobreescribir equals para comparar equipos por su nombre
    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (otro == null || getClass() != otro.getClass()) {
            return false;
        }
        Equipo equipo = (Equipo) otro;
        return Objects.equals(nombre, equipo.nombre);
    }

    // Sobreescribir hashCode basado en el nombre del equipo
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    // Sobreescribir toString para una representación legible del equipo
    @Override
    public String toString() {
        return "Equipo: " + nombre + ", Fans: " + fans + ", Puntos: " + puntos;
    }
}

