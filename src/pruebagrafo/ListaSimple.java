/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 *
 * @author berna
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

    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }

    public NodoListaSimple primero(){ 
        return first;
    }

    public NodoListaSimple ultimo(){
        return null;
    }
    
    public void preinsertarPrimero(String palabra){  
        NodoListaSimple nuevo = new NodoListaSimple(palabra);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
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
    
    
    public NodoListaSimple buscarUltimo(){

        NodoListaSimple aux = first;
        if (first==ultimo()){
            return null;
        }
        while(aux.getNext()!=ultimo()){
                aux=aux.getNext();
        }
        return aux;
    }
    
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
     * @return the first
     */
    public NodoListaSimple getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoListaSimple first) {
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
