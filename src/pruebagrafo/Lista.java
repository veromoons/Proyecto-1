
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
        if (first==ultimo()){
            return null;
        }
        while(aux.getNext()!=ultimo()){
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
    
    public void insertarUltModif(char l){              //aqui busco dentro de la funcion
        Nodo ult=buscarUltimo();                    //mejorarlo, que solo busque ultimo luego del if de saber que no esta vacia
        Nodo nuevo = new Nodo(l); 
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
