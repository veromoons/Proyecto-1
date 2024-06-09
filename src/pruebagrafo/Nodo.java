
package pruebagrafo;

/**
 *Clase para implementar setters y getters del nodo que va a contener la lista de la clase Lista (lista de adyacencia, stos son los nodos adyacentes)
 * @author veronicaluna
 */
public class Nodo {
    
    private Arista info;  //el nodo contiene objetos de tipo Arista que son a su vez enteros que indican el numero de vertice o indice (numVertice) del vertice adyacente (destino)
    private Nodo next;

    public Nodo(Arista info) {
        this.info = info;
        this.next = null;
    }

    /**
     * @return el nodo al cual apunta pNext del nodo actual
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next el nodo que se quiere settear al que apunta pNext del nodo actual
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return la informacion que contiene o que guarda el nodo
     */
    public Arista getInfo() {
        return info;
    }

    /**
     * @param info la informacion que se quiere cambiar que contiene o que guarda el nodo
     */
    public void setInfo(Arista info) {
        this.info = info;
    }

    

}
