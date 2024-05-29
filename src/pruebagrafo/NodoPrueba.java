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
public class NodoPrueba {
    private int info;
    private NodoPrueba next;
    
    public NodoPrueba (int info) { 
        this.info = info; 
        this.next = null; 
    }

    /**
     * @return the next
     */
    public NodoPrueba getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoPrueba next) {
        this.next = next;
    }

    /**
     * @return the info
     */
    public int getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(int info) {
        this.info = info;
    }
}
