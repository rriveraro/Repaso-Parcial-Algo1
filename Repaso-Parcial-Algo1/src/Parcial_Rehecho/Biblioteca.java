package Parcial_Rehecho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<Docente> docentes;
    private List<Libro> libros;
    private List<Prestamo> prestamos;
    
    public Biblioteca(String nombre){
        this.nombre=nombre;
        this.docentes = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        
    }
    //A la hora de registrar un usuario es importante verificar que este no esté registrado en el sistema (considerando el DNI).

    public Estudiante registrarEstudiante(String nombre, int dni){
        Estudiante estudiante = new Estudiante(nombre, dni);
        for(Estudiante otroEstudiante : estudiantes){
            if(estudiante.equals(otroEstudiante)){
                System.out.println("El estudiante " + estudiante.getNombre() + "ya existe en el sistema.");
                return null;
            }
        }
        estudiantes.add(estudiante);
        System.out.println("El estudiante ha sido creado exitosamente.");
        return estudiante;
    }

    public Docente registrarDocente(String nombre, int dni, LocalDate fechaIngreso){
        Docente docente = new Docente(nombre, dni, fechaIngreso);
        for(Docente otroDocente: docentes){
            if(docente.equals(otroDocente)){
                System.out.println("El docente " + docente.getNombre() + "ya existe en el sistema.");
                return null;
            }
        }
        docentes.add(docente);
        System.out.println("El docente ha sido creado exitosamente.");
        return docente;
    }

    //Para los libros es necesario registrar el título, el autor, si es único en el sistema y su estado (si está prestado o disponible). Cuando a la biblioteca le donan un libro es importante registrar si este es único o no (es decir si es el único libro con ese título y autor).

    public Libro donarLibro(String titulo, String autor){

        Libro libro = new Libro(titulo, autor);
        for(Libro otroLibro : libros){
            if(libro.equals(otroLibro)){
                otroLibro.agregarCopia();
                System.out.print("El libro ha sido donado con exito:");
                return otroLibro;
            }
        }
        libros.add(libro);
        System.out.print("El libro ha sido donado con exito:");
        return libro;
    }

    //A la hora de realizar un préstamo es importante que se valide si el usuario puede pedir otro préstamo según sus restricciones y si el libro está disponible. Si el préstamo es exitoso se debe notificar al usuario, estas notificaciones serán una impresión en consola.

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro){
        //¿Puede pedir otro prestamo?
        if(usuario.getPrestamosDisponibles() == 0){
            System.out.print("El usuario no puede pedir más prestamos");
            return null;
        }else{
            if(libro.getEstado() == "Disponible"){
                System.out.println("El usuario puede pedir prestamos y el libro esta disponible, se registra el prestamo.");
                Prestamo prestamo = new Prestamo(usuario, libro);
                libro.prestarCopia();
                prestamos.add(prestamo);
                return prestamo;
            }else{
                System.out.println("El usuario puede realizar prestamos pero el libro solicitado no esta disponible");
                return null;
            }
        }
    }

    public void devolverPrestamo(Prestamo prestamo){
        prestamo.devolverLibro();
        Libro libro = prestamo.getLibro();
        for(Libro libro2 : libros){
            if(libro.equals(libro2)){
                libro2.agregarCopia();
            }
        }
    }

    public void mostrarPrestamos(){
        for(Prestamo prestamo : prestamos){
            prestamo.toString();
        }
    }

    public void mostrarPrestamosActivos(){
        for(Prestamo prestamo : prestamos){
            if(prestamo.getEstado()=="Prestado"){
                prestamo.toString();
            }
        }
    }

    public void mostrarUsuariosConPrestamos(int cantidad){
        for (Estudiante estudiante : estudiantes) {
            long prestamosRealizados = 0;
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getUsuario().equals(estudiante)) {
                    prestamosRealizados++;
                }
            }
            if (prestamosRealizados >= cantidad) {
                System.out.println(estudiante.toString());
            }
        }
        for (Docente docente : docentes) {
            long prestamosRealizados = 0;
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getUsuario().equals(docente)) {
                    prestamosRealizados++;
                }
            }
            if (prestamosRealizados >= cantidad) {
                System.out.println(docente.toString());
            }
        }
    }
}
