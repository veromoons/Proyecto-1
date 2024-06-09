/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagrafo;

/**
 *Clase para implementar metodos del nodo que va a contener la lista de la clase ListaMascara
 * Este es un noso como de una capa superficial que va a tener atributos especiales y unicos para el logro de la busqueda BFS
 * Entre ellos la capa que es la frontera actual y el ancestro de cada letra donde se hace el estilo de backtracking 
 * @author veronicaluna
 */
public class NodoMascara {
    private Vertice info;            //se le llamo nodo mascara ya que es como un nodo "externo" que guarda informacion expecial/adicional y temporal o momentanea para la funcion de busqueda BFS, no necesaria para el vertice en otro metodo o clase
    private NodoMascara next;
    private NodoMascara ancestor;
    private int capa;
    
    public NodoMascara (Vertice info) { 
        this.info = info; 
        this.next = null; 
        this.ancestor=null;
        this.capa=0;
    }

    /**
     * @return el nodo al cual apunta pNext del nodo actual
     */
    public NodoMascara getNext() {
        return next;
    }

    /**
     * @param capa la cual se quiere settear
     */
    public void setCapa(int capa) {
        this.capa = capa;
    }

    /**
     * @param next el nodo que se quiere settear al que apunta pNext del nodo actual
     */
    public void setNext(NodoMascara next) {
        this.next = next;
    }

    /**
     * @return la informacion que contiene o que guarda el nodo
     */
    public Vertice getInfo() {
        return info;
    }

    /**
     * @return el nodomascara ancestro (vertice ancestro para obtener la letra ancestro a medida que se va formando la palabra buscada)
     */
    public NodoMascara getAncestor() {
        return ancestor;
    }

    /**
     * @param ancestor el nodomascara ancestro que se quiere settear 
     */
    public void setAncestor(NodoMascara ancestor) {
        this.ancestor = ancestor;
    }
    
    /**
     * @return la capa o frontera en la que se evalua este nodo
     */
    public int getCapa() {
        return capa;
    }

    /**
     * @param info la informacion que se quiere cambiar que contiene o que guarda el nodo
     */
//    public NodoNumVertice setInfo(NodoNumVertice info) {
//        this.info = info;
//    }
}

