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
    public void imprimir_lista(){
        if (this.iN == 1){
            System.out.println(getFirst().getInfo());}
        else{
            NodoListaSimple temp = getFirst();
            while (temp != null){
            System.out.println(temp.getInfo());
            temp = temp.getNext();
            }
    }
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
