package ONG;

import java.time.LocalDate;

public class Donacion implements Comparable<Donacion> {
    enum EstadoDonacion {PENDIENTE, APROBADA, RECHAZADA}
    private Donante donante;
    private EstadoDonacion estado;
    private LocalDate fecha;
    private float monto;
    private int id;
    private static int ultimoId = 0;

    private static int getUltimoId(){
        int actual = ultimoId;
        ultimoId++;
        return actual;
    }

    public Donacion(Donante donante, LocalDate fecha, float monto){
        this.donante=donante;
        this.estado=EstadoDonacion.PENDIENTE;
        this.fecha=fecha;
        this.id=getUltimoId();
        this.monto=monto;
    }

    public void setCobrada(){
        this.estado=EstadoDonacion.APROBADA;
    }

    public void setRechazada(){
        this.estado = EstadoDonacion.RECHAZADA;
    }

    //Sobreescribimos el metodo toString
    @Override
    public String toString(){
        String salida = "";
        salida += "Donacion: " + id;
        salida+= "\n- Donante: " + donante;
        salida += "\n- Fecha: " + fecha;
        salida += "\n- Estado: " + estado;
        salida += "\n- Monto: " + monto;
        return salida; 
    }

    //Sobreescribimos el metodo compareTo()
    @Override
    public int compareTo(Donacion otro){
        return fecha.compareTo(otro.fecha);
    }

    public boolean esPreviaA(LocalDate limite){
        return fecha.isBefore(limite) || fecha.isEqual(limite);
    }

    public boolean estaRechazada(){
        return estado.equals(EstadoDonacion.RECHAZADA);
    }

    public boolean estadoCobrada(){
        return estado.equals(EstadoDonacion.APROBADA);
    }

    public boolean estaPendiente(){
        return estado.equals(EstadoDonacion.PENDIENTE);
    }

    public float getMonto(){
        return monto;
    }
}
