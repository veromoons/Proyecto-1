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
public class NodoMascara {
    private Vertice info;            //se le llamo nodo mascara ya que es como un nodo "externo" que guarda informacion expecial/adicional y temporal o momentanea para la funcion de busqueda BFS, no necesaria para el vertice en otro metodo o clase
    private NodoMascara next;
    private NodoMascara ancestor;
    private int contador;
    private int capa;
    
    public NodoMascara (Vertice info) { 
        this.info = info; 
        this.next = null; 
        this.ancestor=null;
        this.contador=1;
        this.capa=0;
    }

    /**
     * @return the next
     */
    public NodoMascara getNext() {
        return next;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoMascara next) {
        this.next = next;
    }

    /**
     * @return the info
     */
    public Vertice getInfo() {
        return info;
    }

    /**
     * @return the ancestor
     */
    public NodoMascara getAncestor() {
        return ancestor;
    }

    public void setAncestor(NodoMascara ancestor) {
        this.ancestor = ancestor;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getCapa() {
        return capa;
    }

    /**
     * @param info the info to set
     */
//    public NodoNumVertice setInfo(NodoNumVertice info) {
//        this.info = info;
//    }
}

