package Parcial_Rehecho;

public class Libro {
    //Para los libros es necesario registrar el título, el autor, si es único en el sistema y su estado (si está prestado o disponible). Cuando a la biblioteca le donan un libro es importante registrar si este es único o no (es decir si es el único libro con ese título y autor).
    private String titulo;
    private String autor;
    private int cantidadCopias;
    private String estado;
  
    

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadCopias = 1;
    }

    public void agregarCopia(){
        this.cantidadCopias= cantidadCopias +1;
    }

    public void prestarCopia(){
        this.cantidadCopias = cantidadCopias -1 ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro otroLibro = (Libro) obj;
        return this.titulo.equals(otroLibro.titulo) && this.autor.equals(otroLibro.autor);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(titulo, autor);
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    @Override
    public String toString(){
        String salida = this.getTitulo() + ", de " + this.getAutor();
        return salida;
    }

    public String getEstado(){
        if(cantidadCopias==0){
            estado = "Prestado";
        } else{
            estado="Disponible";
        }
        return estado;
    }




}
