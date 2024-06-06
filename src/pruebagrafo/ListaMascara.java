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
public class ListaMascara {
    //Atributos
    private NodoMascara first;              
    private int iN;

    //Constructor
    public ListaMascara() {             
        this.first = null;
        this.iN = 0;
    }
    
    public NodoMascara buscarUltimo(){

        NodoMascara aux = first;
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

    public NodoMascara primero(){ 
        return first;
    }

    public NodoMascara ultimo(){
        return null;
    }
    
    public void preinsertarPrimero(Vertice numV){  //se le pasa la arista (que es la posicion del siguiente)
        NodoMascara nuevo = new NodoMascara(numV);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    public void insertarUltimo(Vertice numV){              
        NodoMascara ultimo = buscarUltimo(); 
        NodoMascara nuevo = new NodoMascara(numV); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    public void insertarUltimoCreado(NodoMascara nuevo){              
        NodoMascara ultimo = buscarUltimo(); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    
    public NodoMascara eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoMascara aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }
    
    public void destructor(){
        NodoMascara temp;              
        while (first != null){
            temp = first;
            first = first.getNext();
            temp.setNext(null);
        }
        iN=0;
    }
    
    public void recorrer(){
        NodoMascara aux=first;
        while(aux!=null){          
            System.out.print(aux.getInfo()+", ");
            aux=aux.getNext();
        }
    }

    public NodoMascara getFirst() {
        return first;
    }

    public int getiN() {
        return iN;
    }
    
}
