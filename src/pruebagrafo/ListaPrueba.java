/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagrafo;

/**
 *
 * @author verol
 */
public class ListaPrueba {
    //Atributos
    private NodoPrueba first;
    private int iN;

    //Constructor
    public ListaPrueba() {             
        this.first = null;
        this.iN = 0;
    }
    
    public NodoPrueba buscarUltimo(){

        NodoPrueba aux = first;
        if (primero()==null){
            return null;
        }
        while(aux.getNext()!=null){
                aux=aux.getNext();
        }
        return aux;
    }

    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }

    public NodoPrueba primero(){ 
        return first;
    }

    public NodoPrueba ultimo(){
        return null;
    }
    
    public void preinsertarPrimero(int numV){  //se le pasa la arista (que es la posicion del siguiente)
        NodoPrueba nuevo = new NodoPrueba(numV);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    public void insertarUltimo(int numV){              
        NodoPrueba ultimo = buscarUltimo(); 
        NodoPrueba nuevo = new NodoPrueba(numV); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    public NodoPrueba eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoPrueba aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }
    

    
    
    
    
    

    /**
     * @return the first
     */
    public NodoPrueba getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoPrueba first) {
        this.first = first;
    }

    /**
     * @return the iN
     */
    public int getiN() {
        return iN;
    }

    /**
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }
    
    
    
    
    
    
    
}
