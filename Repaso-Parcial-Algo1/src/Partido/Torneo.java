package Partido;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Torneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Torneo(){
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void agregarEquipo(String nombre, int fans){
        equipos.add(new Equipo(nombre, fans));
    }

   public void partidosPorFecha(LocalDate fecha){
    for(Partido partido : partidos){
        if( partido.getFecha().equals(fecha)){
            System.out.println(partido.mostrarResultado());
        }
    }
   }
   public Equipo buscarEquipo(String nombre){
    for(Equipo equipo: equipos){
        if(equipo.getNombre().equals(nombre)){
            return equipo;
        }
    }
    return null;
   }

    public void agregarPartido(String nombreLocal, String nombreVisitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        Equipo local = buscarEquipo(nombreLocal);
        Equipo visitante = buscarEquipo(nombreVisitante);

        if (local != null && visitante != null) {
            partidos.add(new Partido(local, visitante, fecha, golesLocal, golesVisitante));
        } else {
            System.out.println("Uno o ambos equipos no existen en el torneo.");
        }
    }


}
