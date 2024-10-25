package Matriz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matriz<E> {
    private List<List<E>> matriz;
    
    //Crear vacia o desde un arreglo nativo E[][]
    public Matriz(){
        matriz = new ArrayList<>();
    }

    //crear una matriz desde un arreglo nativo
    public Matriz(E[][] matriz){
        this();

        inicializarColumnas(matriz[0].length);


        for(E[] fila : matriz){
            //convertir esta fila en una lista. List<E>
            List<E> nuevaFila = new ArrayList<>();
            Collections.addAll(nuevaFila, fila);
            agregarFila(nuevaFila);
            

        }
    }

    public void agregarColumnas(List<E> nuevaColumna){
        if(nuevaColumna.size()!=cantFilas()){
            throw new IllegalArgumentException("El tamaño de la columna debe ser igual al resto de las columnas");
        }
        matriz.add(nuevaColumna);
    }

    //Eliminar fila/columna por indice
    public void eliminarFila(int indice){
        if(!indiceFilaValido(indice)){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        for(int col= 0; col<cantColumnas();col++){
            matriz.get(col).remove(indice);
        }
    }

    public  void eliminarColumna(int indice){
        if(!indiceColumnaValido(indice)){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        matriz.remove(indice);
    }

    //Cambiar orden de filas/columnas

    public void cambiarOrdenFilas(int indice1, int indice2){
        if(!indiceFilaValido(indice1) || !indiceFilaValido(indice2)){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        for(List<E> columna : matriz){
            Collections.swap(columna, indice1, indice2);
        }
    }

    public void cambiarOrdenColumnas(int indice1, int indice2){
        if(!indiceColumnaValido(indice1) || !indiceColumnaValido(indice2)){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Collections.swap(matriz, indice1, indice2);
    }

    private boolean indiceFilaValido(int indice){
        return indice >= 0 && indice < cantFilas();
    }

    private boolean indiceColumnaValido(int indice){
        return indice >= 0 && indice < cantColumnas();
    }

    private int cantColumnas(){
        return matriz.size();
    }

    private int cantFilas(){
        return matriz.get(0).size();
    }


    private void inicializarColumnas(int cantColumnas) {
        for(int i=0; i<cantColumnas; i++){
            matriz.add(new ArrayList<>());
        }
    }

    private void agregarFila(List<E> nuevaFila) {
        if (nuevaFila.size() != matriz.size()){
            throw new IllegalArgumentException("El tamaño de la filadebe ser igual a la cantidfad de columnas");
        }
        for(int col=0; col < matriz.size() ; col++){
            matriz.get(col).add(nuevaFila.get(col));
        }
        
    }
}
