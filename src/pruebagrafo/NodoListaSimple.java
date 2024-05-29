/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 *
 * @author berna
 */
public class NodoListaSimple {
    private String info;
    private NodoListaSimple next;

    public NodoListaSimple(String info) {
        this.info = info;
        this.next = null;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the next
     */
    public NodoListaSimple getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoListaSimple next) {
        this.next = next;
    }


}
