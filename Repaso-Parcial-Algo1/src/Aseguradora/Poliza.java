package Aseguradora;

import java.time.LocalDate;

public abstract class Poliza {

    // A su vez, la póliza especifica el monto asegurado, una fecha de inicio de la vigencia y una fecha de finalización del seguro.

    private Cliente cliente;

    public Poliza(Cliente cliente){
        this.cliente = cliente;
    }

    public abstract String impresion();

    public Cliente getCliente(){
        return cliente;
    }
}
