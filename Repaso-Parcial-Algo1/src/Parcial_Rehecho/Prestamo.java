package Parcial_Rehecho;

import java.time.LocalDate;

public class Prestamo {
    //Los préstamos se componen por un identificador único en todo el sistema, una fecha de solicitud, una fecha de devolución (inicialmente null) y un estado que indica si el libro ha sido devuelto o no. Además se registra qué usuario realizó el préstamo y sobre qué libro. A la hora de realizar un préstamo es importante que se valide si el usuario puede pedir otro préstamo según sus restricciones y si el libro está disponible. Si el préstamo es exitoso se debe notificar al usuario, estas notificaciones serán una impresión en consola.

    private int id;
    private LocalDate fechaSolicitud;
    private LocalDate fechaDevolucion;
    private String estado;
    private static int contadorId;
    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro){
        this.id = contadorId + 1;
        this.fechaSolicitud = LocalDate.now();
        this.fechaDevolucion = null;
        this.estado = "Prestado";
        this.usuario = usuario;
        this.libro = libro;
    }

    public void devolverLibro(){
        this.estado = "Devuelto";
        this.fechaDevolucion = LocalDate.now();

    }
    public Libro getLibro(){
        return libro;
    }

    @Override
    public String toString(){
        String salida ="Prestamo nro: " + this.getId() + ". Libro prestado: " + this.getLibro() + ". Al usuario: " + this.getUsuario() + ". Fecha de solicitud" + this.getFechaSolicitud() + ". Fecha de devolucion: " + this.getFechaDevolucion();
        return salida; 
    }

    public LocalDate getFechaSolicitud(){
        return fechaSolicitud;
    }
    public LocalDate getFechaDevolucion(){
        return fechaDevolucion;
    }
    public int getId(){
        return id;
    }
    public String getEstado(){
        return estado;
    }

    public Usuario getUsuario(){
        return usuario;
    }
    


}
