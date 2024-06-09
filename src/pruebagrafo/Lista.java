
package pruebagrafo;

/**
 * Clase para implementar primitivas de una lista de adyacencia 
 * @author veronicaluna
 */
public class Lista {
    
    //Atributos
    private Nodo first;  //lista de nodos que son los adyacentes (esta es clase de lista de adyacencia)
    private int iN;

    //Constructor
    public Lista() {             
        this.first = null;
        this.iN = 0;
    }
    
    /**
    * Metodo para ubicar el ultimo nodo que conforma la lista, el que su pNext apunta a null
    * @return objeto de la clase Nodo
    */
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
    public Nodo primero(){ 
        return first;
    }
    
    /**
    * Metodo para obtener lo ultimo de la lista (null en este caso), se usa para referirse a null
    * @return null
    */
    public Nodo ultimo(){
        return null;
    }
    
    /**
    * Procedimiento para preinsertar un nuevo nodo antes del primer nodo de una lista, es necesario entonces reubicar el apuntafor first de la lista al nuevo nodo anadido
    */
    public void preinsertarPrimero(Arista arc){  //se le pasa la arista (que es la posicion del siguiente)
        Nodo nuevo = new Nodo(arc);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
    * Procedimiento para insertar un nuevo nodo luego del ultimo de la lista, por lo que es necesario ir a la funcion de buscarUltimo
    */
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
    * Procedimiento para imprimir la lista por consola, que se utiliza es para pruebas de codigos principalmente de la clase Grafo para debuggear y verificar que todo sirva
    */
    public void recorrer(){
        Nodo aux=first;
        while(aux!=null){          
            System.out.print(aux.getInfo()+", ");
            aux=aux.getNext();
        }
    }
    
    
    
    
    
    
    
    
    
    

    /**
     * @return el primer nodo que conforma la lista de adyacencia
     */
    public Nodo getFirst() {
        return first;
    }

    /**
     * @return el tamano de la lista iN
     */
    public int getiN() {
        return iN;
    }

    
    
    
    
    
    
    
    
}
