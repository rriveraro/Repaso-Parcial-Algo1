package Aseguradora;

import java.time.LocalDate;

public class PolizaAuto extends Poliza {
    //Si se trata de una póliza de seguro de automotor, también tiene asociada un vehículo. El vehículo se identifica por un domino (patente), que simplificaremos es una cadena (no se pide validación de formato en este ejercicio), el año de fabricación y monto de compra. El monto asegurado de este tipo de póliza se determina por la cotización del vehículo al momento de inicial la póliza, la cual se calcula como el monto de compra original restándole el 5% de ese valor por cada año de antigüedad. Por ejemplo, si el vehículo tiene 3 años de antigüedad, su cotización será el 85% del monto de compra. El costo anual de una póliza de automotor se calcula de la siguiente manera: - Si la edad del cliente es menor a 30 años al momento de iniciar la póliza, el costo anual corresponde al 20% del monto asegurado. - Caso contrario, el costo anual corresponde al 10% del monto asegurado.
    private float costoAnual;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private float montoAsegurado;
    private LocalDate fechaVigenciaInicial;
    private LocalDate fechaVigenciaFinal;


    public PolizaAuto(Cliente cliente, Vehiculo vehiculo, LocalDate fechaVigenciaFinal){
        super(cliente);
        this.vehiculo=vehiculo;
        this.montoAsegurado = (float) (vehiculo.getMontoCompra() - (vehiculo.getAntiguedad() * (vehiculo.getMontoCompra() * 0.95)));
        if(cliente.getEdad()<30){
            this.costoAnual = (float) (montoAsegurado * 0.80);
        } else{
            this.costoAnual = (float) (montoAsegurado * 0.90);
        }
        this.fechaVigenciaInicial = LocalDate.now();
        this.fechaVigenciaFinal = fechaVigenciaFinal;
    }

    public boolean getVigencia(){
        LocalDate fechaActual = LocalDate.now();
        return (fechaVigenciaInicial.isBefore(fechaActual) || fechaVigenciaInicial.isEqual(fechaActual)) &&
               (fechaVigenciaFinal.isAfter(fechaActual) || fechaVigenciaFinal.isEqual(fechaActual));
    }

    public String impresion(){
        String salida = getCliente().toString();
        salida += "\nMonto asegurado: $" + montoAsegurado;
        salida+= "\nCosto anual: $"+costoAnual;
        salida+="\nFecha vigencia inicial: " + fechaVigenciaInicial;
        salida +="\nFecha vigencia final: " + fechaVigenciaFinal;
        salida += "\nVigencia: " + this.getVigencia();
        salida += "\nVehiculo con dominio "+ vehiculo.getdominio() + ". Año de compra: " + vehiculo.getAnioCompra() + ". Monto de compra: " + vehiculo.getMontoCompra;
        return salida;
    }
    
}
