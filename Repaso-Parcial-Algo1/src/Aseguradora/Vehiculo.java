package Aseguradora;

import java.time.LocalDate;
import java.time.Period;

public class Vehiculo {
    //El vehículo se identifica por un domino (patente), que simplificaremos es una cadena (no se pide validación de formato en este ejercicio), el año de fabricación y monto de compra.
    private String dominio;
    private LocalDate anioCompra;
    private float montoCompra;
    public String getMontoCompra;

    public Vehiculo(String dominio, LocalDate anioCompra, float montoCompra){
        this.dominio=dominio;
        this.anioCompra=anioCompra;
        this.montoCompra=montoCompra;
    }

    public int getAntiguedad(){
        LocalDate fechaActual = LocalDate.now();
        return Period.between(anioCompra, fechaActual).getYears();
    }

    public float getMontoCompra() {
        return montoCompra;
    }

    public String getdominio() {
        return dominio;
    }

    public LocalDate getAnioCompra() {
        return anioCompra;
    }

    

}
