package ONG;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ong {
    private String nombre;
    private List<Donante> donantes;
    private List<Donacion> donaciones;
    private int proxIdDonante;

    //Constructor

    public Ong(String nombre){
        this.nombre=nombre;
        this.donantes= new ArrayList<>();
        this.donaciones=new ArrayList<>();
        this.proxIdDonante = 0;

    }

    public Donante registarDonante(String nombre, String apellido){
        Donante nuevo = new Donante(nombre, apellido, proxIdDonante);
        int indice = donantes.indexOf(nuevo);
        if(indice > -1){
            return donantes.get(indice);
        }
        proxIdDonante++;
        donantes.add(nuevo);
        return nuevo;
    }

    public Donacion cargarDonacion(Donante donante, LocalDate fecha, float monto){
        Donacion nueva = new Donacion(donante, fecha, monto);
        donaciones.add(nueva);
        return nueva;
    }

    public void mostrarDonantes(){
        String salida = "Listado de donantes de " + nombre;
        for (Donante donante: donantes){
            salida += "\n";
            salida += donante.toString();
        }
        System.out.println(salida);
    }
    public void mostrarDonaciones(){
        String salida = "Listado de donaciones de " + nombre;
        for (Donacion donacion :donaciones) {
            salida += "\n ";
            salida += donacion;
        }
        System.out.println(salida);
    }

    public void mostrarResultadoFecha(LocalDate limite){
        String salida = "Estado de Resultado de " + nombre + " al " + limite;
        int cobradas = 0;
        int rechazadas = 0;
        int pendientes = 0;
        float total = 0;
        float maximo = Float.MIN_VALUE;
        float minimo = Float.MAX_VALUE;

        for(Donacion donacion: donaciones){
            if(donacion.esPreviaA(limite)){
                if(donacion.estadoCobrada()){
                    cobradas +=1;
                    total+= donacion.getMonto();
                    if(maximo < donacion.getMonto()){
                        maximo = donacion.getMonto();
                    }
                    if(minimo>donacion.getMonto()){
                        minimo = donacion.getMonto();
                    }
                }
            }
            if(donacion.estaRechazada()){
                rechazadas += 1;
            }
            if(donacion.estaPendiente()){
                pendientes +=1;
            }
            
        }
        salida += "\n- Cobradas: " + cobradas;
        salida+= "\n- Rechazadas: " + rechazadas;
        salida += "\n- Pendientes: " + pendientes;
        if(cobradas > 0){
            salida += "\n- Monto total: " + total;
            salida+= "\n- Monto maximo: " + maximo;
            salida += "\n- Monto minimo: " + minimo;
            salida += "\n- Monto medio: " + total/cobradas;
        }
        System.out.println(salida);
    
    }
    


}
