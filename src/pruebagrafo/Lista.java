
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Lista {
    
    //Atributos
    private Nodo first;
    private int iN;

    //Constructor
    public Lista() {             
        this.first = null;
        this.iN = 0;
    }
    
    public Nodo buscarUltimo(){

        Nodo aux = first;
        if (primero()==null){
            return null;
        }
        while(aux.getNext()!=null){
                aux=aux.getNext();
        }
        return aux;
    }

    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }

    public Nodo primero(){ 
        return first;
    }

    public Nodo ultimo(){
        return null;
    }
    
    public void preinsertarPrimero(Arista arc){  //se le pasa la arista (que es la posicion del siguiente)
        Nodo nuevo = new Nodo(arc);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    public void insertarUltimo(Arista arc){              
        Nodo ult=buscarUltimo();                    
        Nodo nuevo = new Nodo(arc); 
        if(ult == null){
           first = nuevo;
        }else{
            nuevo.setNext(ult);
            ult.setNext(nuevo);
        }
        iN++;   
    }
    
    
    
    
    
    
    
    
    
    

    /**
     * @return the first
     */
    public Nodo getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Nodo first) {
        this.first = first;
    }

    /**
     * @return the iN
     */
    public int getiN() {
        return iN;
    }

    /**
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }
    
    
    
    
    
    
    
    
}
