package Aseguradora;

import java.time.LocalDate;

public class PolizaVida extends Poliza {
    //Si se trata de una póliza de seguro de vida, el monto asegurado es definido por el cliente y el costo anual de la póliza sigue la siguiente lógica: - Si la edad del cliente es menor a 35 años al momento de inicio del seguro, el costo anual corresponde al 5% del monto asegurado. - De lo contrario, el costo anual corresponde al 10% del monto asegurado.
    private float costoAnual;
    private float montoAsegurado;
    private LocalDate fechaVigenciaInicial;
    private LocalDate fechaVigenciaFinal;

    public PolizaVida(float montoAsegurado, Cliente cliente, LocalDate fechaVigenciaFinal){
        super(cliente);
        this.fechaVigenciaInicial = LocalDate.now();
        this.fechaVigenciaFinal = fechaVigenciaFinal;
        if(cliente.getEdad()<35){
            this.costoAnual= (float) (montoAsegurado* (0.95));
        }else{
            this.costoAnual= (float) (montoAsegurado* (0.90));
        }
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
        return salida;
    }
}
