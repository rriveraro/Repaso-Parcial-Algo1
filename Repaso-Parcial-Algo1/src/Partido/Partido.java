package Partido;

import java.time.LocalDate;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private LocalDate fecha;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo local, Equipo visitante, LocalDate fecha, int golesLocal, int golesVisitante){
        this.local = local;
        this.visitante = visitante;
        this.fecha=fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String mostrarResultado(){

        return fecha + ": " + local.getNombre() + " " + golesLocal + " - " + golesVisitante + visitante.getNombre();
    }

    
    private void calcularResultado(){
        if(golesLocal>golesVisitante){
            local.agregarPuntos(3);
        } else if(golesLocal<golesVisitante){
            visitante.agregarPuntos(3);
        }else {
            local.agregarPuntos(1);
            visitante.agregarPuntos(1);
        }
    }

}
