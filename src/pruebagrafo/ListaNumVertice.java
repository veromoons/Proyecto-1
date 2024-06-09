/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagrafo;

/**
 * Clase para implementar primitivas de una lista que guarde las posiciones o numVertices de los vertices de un grafo 
 * @author veronicaluna
 */
public class ListaNumVertice {
    //Atributos
    private NodoNumVertice first;
    private int iN;

    //Constructor
    public ListaNumVertice() {             
        this.first = null;
        this.iN = 0;
    }
    
   /**
    * Metodo para ubicar el ultimo nodo que conforma la lista, el que su pNext apunta a null
    * @return objeto de la clase Nodo
    */
    public NodoNumVertice buscarUltimo(){

        NodoNumVertice aux = first;
        if (primero()==null){
            return null;
        }
        while(aux.getNext()!=null){
                aux=aux.getNext();
        }
        return aux;
    }

    /**
     * Metodo que indica si la lista esta vacia o no, que es cuando el apuntador pFirst apunta a null
     * @return booleano, true si esta vacia y false si no lo esta
     */
    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
    * Metodo para obtener el primer nodo de la lista
    * @return un objeto tipo Nodo que es el primero de la lista 
    */
    public NodoNumVertice primero(){ 
        return first;
    }
    
    /**
    * Metodo para obtener lo ultimo de la lista (null en este caso), se usa para referirse a null
    * @return null
    */
    public NodoNumVertice ultimo(){
        return null;
    }
    
    /**
    * Procedimiento para preinsertar un nuevo nodo antes del primer nodo de una lista, es necesario entonces reubicar el apuntafor first de la lista al nuevo nodo anadido
    */
    public void preinsertarPrimero(int numV){  //se le pasa la arista (que es la posicion del siguiente)
        NodoNumVertice nuevo = new NodoNumVertice(numV);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
    * Procedimiento para insertar un nuevo nodo luego del ultimo de la lista, por lo que es necesario ir a la funcion de buscarUltimo
    */
    public void insertarUltimo(int numV){              
        NodoNumVertice ultimo = buscarUltimo(); 
        NodoNumVertice nuevo = new NodoNumVertice(numV); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    public NodoNumVertice eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoNumVertice aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }
    
    public void destructor(){
        NodoNumVertice temp;              
        while (first != null){
            temp = first;
            first = first.getNext();
            temp.setNext(null);
        }
        iN=0;
    }
    
    /**
    * Procedimiento para imprimir la lista por consola, que se utiliza es para pruebas de codigos principalmente de la clase Grafo para debuggear y verificar que todo sirva
    */
    public void recorrer(){
        NodoNumVertice aux=first;
        while(aux!=null){          
            System.out.print(aux.getInfo()+", ");
            aux=aux.getNext();
        }
    }

    
    
    
    
    

    /**
     * @return el primer nodo que conforma la lista
     */
    public NodoNumVertice getFirst() {
        return first;
    }

/**
     * @return el tamano de la lista iN
     */
    public int getiN() {
        return iN;
    }

    
    
    
    
    
    
}
