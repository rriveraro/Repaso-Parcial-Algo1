package Partido2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();

        // Agregar equipos al torneo
        torneo.agregarEquipo("Equipo A", 1000);
        torneo.agregarEquipo("Equipo B", 800);
        torneo.agregarEquipo("Equipo C", 500);

        // Agregar partidos al torneo
        torneo.agregarPartido("Equipo A", "Equipo B", LocalDate.of(2024, 10, 1), 2, 1);
        torneo.agregarPartido("Equipo B", "Equipo C", LocalDate.of(2024, 10, 2), 1, 1);
        torneo.agregarPartido("Equipo A", "Equipo C", LocalDate.of(2024, 10, 1), 3, 0);

        // Mostrar los partidos jugados en una fecha
        System.out.println("Partidos jugados el 2024-10-01:");
        torneo.partidosPorFecha(LocalDate.of(2024, 10, 1));

        System.out.println("Partidos jugados el 2024-10-02:");
        torneo.partidosPorFecha(LocalDate.of(2024, 10, 2));
    }
}
