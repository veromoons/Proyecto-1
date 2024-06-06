
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Nodo {
    
    private Arista info;  //el nodo contiene objetos de tipo Arista que son a su vez enteros que indican el numero de vertice o indice (numVertice) del vertice adyacente (destino)
    private Nodo next;

    public Nodo(Arista info) {
        this.info = info;
        this.next = null;
    }

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return the info
     */
    public Arista getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Arista info) {
        this.info = info;
    }

    

}
