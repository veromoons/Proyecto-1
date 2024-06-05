/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 * Clase con primitivas de una lista simplemente enlazada
 * @author sofiagrateron
 */
public class ListaSimple {
    //Atributos
    private NodoListaSimple first;
    private int iN;

    //Constructor
    public ListaSimple() {             
        this.first = null;
        this.iN = 0;
    }
    /**
     * Metodo para revisar si la lista es vacia
     * @return verdadero si es vacia, falso si no lo es 
     */
    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo para insertar una palabra antes de la primera
     * @param palabra a insertar
     */
    public void preinsertarPrimero(String palabra){  
        NodoListaSimple nuevo = new NodoListaSimple(palabra);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    /**
     * Metodo para insertar al final de la lista
     * @param palabra a insertar
     */
    public void insertarUltimo(String palabra){  
        
        NodoListaSimple ult=buscarUltimo();                    
        NodoListaSimple nuevo = new NodoListaSimple(palabra); 
        if(ult == null){
           first = nuevo;
        }else{
            ult.setNext(nuevo);
        }
        iN++;   
    }
    /**
     * Metodo para guardar los elementos de la lista en un string
     * @return 
     */
    public String imprimir_lista(){
        String imprimir = "";
        if (this.iN == 1){
            imprimir += getFirst().getInfo() + "\n";
        }
        else{
            NodoListaSimple temp = getFirst();
            while (temp != null){
            imprimir += temp.getInfo() + "\n";
            temp = temp.getNext();
            }
    }
        return imprimir;
    }
    
    /**
     * Metodo para buscar el ultimo elemento de la lista
     * @return 
     */
    public NodoListaSimple buscarUltimo(){

        NodoListaSimple aux = first;
        if (first== null){
            return null;
        }
        while(aux.getNext()!= null){
                aux=aux.getNext();
        }
        return aux;
    }
    /**
     * Metodo para eliminar el primer elemento de la lista
     * @return el nodo eliminado
     */
    public NodoListaSimple eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoListaSimple aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }

       

    /**
     * Metodo para obtener el pimer elemento de la lista
     * @return the first
     */
    public NodoListaSimple getFirst() {
        return first;
    }

    /**Metodo para fijar el primer elemento de la lista
     * @param first the first to set
     */
    public void setFirst(NodoListaSimple first) {
        this.first = first;
    }

    /**
     * Metodo para obtener el tamaño de la lista
     * @return the iN, entero tamaño de la lista
     */
    public int getiN() {
        return iN;
    }

    /**
     * Metodo para fijar el tamaño de la lista
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }
}
