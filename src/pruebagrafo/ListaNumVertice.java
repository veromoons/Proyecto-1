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
public class ListaNumVertice {
    //Atributos
    private NodoNumVertice first;
    private int iN;

    //Constructor
    public ListaNumVertice() {             
        this.first = null;
        this.iN = 0;
    }
    
    public NodoNumVertice buscarUltimo(){

        NodoNumVertice aux = first;
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

    public NodoNumVertice primero(){ 
        return first;
    }

    public NodoNumVertice ultimo(){
        return null;
    }
    
    public void preinsertarPrimero(int numV){  //se le pasa la arista (que es la posicion del siguiente)
        NodoNumVertice nuevo = new NodoNumVertice(numV);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    public void insertarUltimo(int numV){              
        NodoNumVertice ultimo = buscarUltimo(); 
        NodoNumVertice nuevo = new NodoNumVertice(numV); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    public NodoNumVertice eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoNumVertice aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }
    

    
    
    
    
    

    /**
     * @return the first
     */
    public NodoNumVertice getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoNumVertice first) {
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
