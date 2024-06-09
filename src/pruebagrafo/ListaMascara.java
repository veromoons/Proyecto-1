/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagrafo;

/**
 * Clase para implementar primitivas de una lista utilizada en la busqueda BFS 
 * @author veronicaluna
 */
public class ListaMascara {
    //Atributos
    private NodoMascara first;              
    private int iN;

    //Constructor
    public ListaMascara() {             
        this.first = null;
        this.iN = 0;
    }
    
    /**
    * Metodo para ubicar el ultimo nodo que conforma la lista, el que su pNext apunta a null
    * @return objeto de la clase Nodo
    */
    public NodoMascara buscarUltimo(){

        NodoMascara aux = first;
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
    public NodoMascara primero(){ 
        return first;
    }

    /**
    * Metodo para obtener lo ultimo de la lista (null en este caso), se usa para referirse a null
    * @return null
    */
    public NodoMascara ultimo(){
        return null;
    }
    
    /**
    * Procedimiento para preinsertar un nuevo nodo antes del primer nodo de una lista, es necesario entonces reubicar el apuntafor first de la lista al nuevo nodo anadido
    */
    public void preinsertarPrimero(Vertice numV){  //se le pasa la arista (que es la posicion del siguiente)
        NodoMascara nuevo = new NodoMascara(numV);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    public void insertarUltimo(Vertice numV){              
        NodoMascara ultimo = buscarUltimo(); 
        NodoMascara nuevo = new NodoMascara(numV); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    /**
    * Procedimiento para insertar un nuevo nodo luego del ultimo de la lista, por lo que es necesario ir a la funcion de buscarUltimo
    */
    public void insertarUltimoCreado(NodoMascara nuevo){              
        NodoMascara ultimo = buscarUltimo(); 
        if (esVacia()) {
            first = nuevo;
        } else {
            ultimo.setNext(nuevo); 
        }
        iN++;   
    }
    
    
    public NodoMascara eliminarPrimero(){
        if (esVacia()) {
            return null;
        }
        NodoMascara aux= null;
        aux = first;
        first = aux.getNext();
        aux.setNext(null);
        iN--;
        return aux;
    }
    
    public void destructor(){
        NodoMascara temp;              
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
        NodoMascara aux=first;
        while(aux!=null){          
            System.out.print(aux.getInfo()+", ");
            aux=aux.getNext();
        }
    }

    /**
     * @return el primer nodo que conforma la lista
     */
    public NodoMascara getFirst() {
        return first;
    }

    /**
     * @return el tamano de la lista iN
     */
    public int getiN() {
        return iN;
    }
    
}
