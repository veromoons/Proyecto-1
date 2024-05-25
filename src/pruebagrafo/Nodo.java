
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Nodo {
    
    private char info;
    private Nodo next;
    
    public Nodo(char l) { 
        this.info = l; 
        this.next = null; 
    }

    /**
     * @return the info
     */
    public char getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(char info) {
        this.info = info;
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
    
    
}
