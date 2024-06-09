/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagrafo;

/**
 *Clase para implementar setters y getters del nodo que va a contener la lista de la clase ListaNumVertices
 * @author veronicaluna
 */
public class NodoNumVertice {
    private int info;
    private NodoNumVertice next;
    
    public NodoNumVertice (int info) { 
        this.info = info; 
        this.next = null; 
    }

    /**
     * @return el nodo al cual apunta pNext del nodo actual
     */
    public NodoNumVertice getNext() {
        return next;
    }

    /**
     * @param next el nodo que se quiere settear al que apunta pNext del nodo actual
     */
    public void setNext(NodoNumVertice next) {
        this.next = next;
    }

    /**
     * @return la informacion que contiene o que guarda el nodo
     */
    public int getInfo() {
        return info;
    }

    /**
     * @param info la informacion que se quiere cambiar que contiene o que guarda el nodo
     */
    public void setInfo(int info) {
        this.info = info;
    }
}
