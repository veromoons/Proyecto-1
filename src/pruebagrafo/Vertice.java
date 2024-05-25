
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Vertice {
    
    private int id; 
    private char letra;
    Lista listaAdy;

    public Vertice(char leetra) {
        this.id = id;
        this.letra = leetra;
        this.listaAdy = new Lista();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the letra
     */
    public char getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }
    
    
    
    
}
