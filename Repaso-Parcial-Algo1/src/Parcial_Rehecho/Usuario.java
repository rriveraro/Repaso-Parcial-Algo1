package Parcial_Rehecho;

public abstract class Usuario {
    private int dni;
    private String nombre;

    public Usuario(String nombre, int dni){
        this.nombre = nombre;
        this.dni= dni;
    }

    public int getDni(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Usuario usuario = (Usuario) obj; 
        return dni == usuario.dni; 
    }

    public abstract int getPrestamosDisponibles();




}
