
package pruebagrafo;

/**
     * Constructor
     * @param entero d que es la posicion del vertice destino
     * @param caracter ld que es la letra de ese  vertice destino
     * @author veronicaluna
     */
public class Arista {
    
    private int destino;
    private char letraDestino;
   

    public Arista(int d, char ld) {
        this.destino = d;
        this.letraDestino = ld;
    }

    /**
     * @return the destino (la posicion del vertice destino)
     */
    public int getDestino() {  
        return destino;
    }

    /**
     * @return the letraDestino (la letra del vertice destino)
     */
    public char getLetraDestino() {
        return letraDestino;
    }
    
    
    
}
