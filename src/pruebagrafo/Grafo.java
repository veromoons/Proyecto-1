
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Grafo {
    
    private int numVertices;
    private int max;
    private Vertice[] listaVertices;

    public Grafo(int t) {
        this.numVertices = 0; 
        this.max = t;
        this.listaVertices = new Vertice[t];
    }
    
    public void agregarVertice(char letra){
        Vertice v = new Vertice(letra); 
        numVertices++;                      //las posiciones entonces de listaVertices va de 1 a 16
        v.setId(numVertices);               //hice un id numerico (del 1 al 16)
        listaVertices[numVertices] = v;
    }
    
    public void agregarArista(){
        
    }
    
    
    
    
    
    
    

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the listaVertices
     */
    public Vertice[] getListaVertices() {
        return listaVertices;
    }

    /**
     * @param listaVertices the listaVertices to set
     */
    public void setListaVertices(Vertice[] listaVertices) {
        this.listaVertices = listaVertices;
    }
    
    
    
    
    
}
