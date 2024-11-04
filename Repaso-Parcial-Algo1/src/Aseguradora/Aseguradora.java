package Aseguradora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aseguradora {
    private List<Cliente> clientes;
    private List<Poliza> polizas;
    private List<Vehiculo> vehiculos;
    private String nombre;

    public Aseguradora(String nombre){
        this.nombre = nombre;
        this.clientes =new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.polizas = new ArrayList<>();
    }

    public Cliente registrarCliente(String nombre, String apellido, LocalDate fechaNacimiento){
        Cliente cliente = new Cliente(nombre, apellido, fechaNacimiento);
        return cliente;
    }

    public Vehiculo registrarVehiculo(String dominio, float montoCompra, LocalDate anioCompra){

        Vehiculo vehiculo = new Vehiculo(dominio, anioCompra, montoCompra);
        return vehiculo;
    }

    public Poliza generarPoliza(Cliente cliente, Vehiculo vehiculo, LocalDate fechaFinalizacion ){
        PolizaAuto poliza = new PolizaAuto(cliente, vehiculo, fechaFinalizacion);
        polizas.add(poliza);
        return poliza;
    }

    public Poliza generarPoliza(Cliente cliente, float montoAsegurado,LocalDate fechaFinalizacion ){
        PolizaVida poliza = new PolizaVida(montoAsegurado, cliente, fechaFinalizacion);
        polizas.add(poliza);
        return poliza;
    }

    public void mostrarPolizas(){
        for(Poliza poliza : polizas){
            System.out.println(poliza.impresion()); 
        }
    }



}
