package Aseguradora;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creamos aseguradora");
        Aseguradora aseg = new Aseguradora("RR Seguros");
        System.out.println("Creamos cliente");
        Cliente cliente = aseg.registrarCliente("Rocio","Rivera", LocalDate.of(2000, 1, 1));
        System.out.println("Creamos vehiculo");
        Vehiculo vehiculo = aseg.registrarVehiculo("AD783ON" , 10000000, LocalDate.of(2019,01,01));
        System.out.println("Creamos poliza vida");
        Poliza polizaVida = aseg.generarPoliza(cliente, 100000, LocalDate.of(2030, 01, 01 ));
        System.out.println("Creamos poliza auto");
        Poliza polizaAuto = aseg.generarPoliza(cliente, vehiculo,  LocalDate.of(2000, 1, 01 ));
        System.out.println("Mostramos polizas");
        aseg.mostrarPolizas();

    
    }
    
}
