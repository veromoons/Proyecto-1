/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 *Clase para implementar setters y getters del nodo que va a contener la lista de la clase ListaSimple
 * @author sofiagrateron
 */
public class NodoListaSimple {
    private String info;
    private NodoListaSimple next;
    /**
     * Constructor
     * @param info 
     */
    public NodoListaSimple(String info) {
        this.info = info;
        this.next = null;
    }

    /** Metodo para obtener la informacion del nodo
     * @return the info, palabra contenida en el nodo
     */
    public String getInfo() {
        return info;
    }

    /**
     * Metodo para fijar la informacion de un nodo
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Metodo para obtener el nodo siguiente al actual
     * @return the next
     */
    public NodoListaSimple getNext() {
        return next;
    }

    /**
     * Metodo para fijar el nodo siguiente al actual
     * @param next the next to set
     */
    public void setNext(NodoListaSimple next) {
        this.next = next;
    }


}
