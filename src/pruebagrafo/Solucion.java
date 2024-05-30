
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Solucion {
    
        //prueba BSF
//    public void bfs(Grafo grafo, String palabra, int verticeInicial){
//        boolean[] visitados = new boolean[grafo.getNumVertices()]; //lista de F F F F al inicio para c/vertice
//        ListaNumVertice cola = new ListaNumVertice();  //se va a guardar el vertice actual inicialmente
//       
//        
//        for (int v=0; v<grafo.getNumVertices(); v++){
//            if (grafo.getListaVertices()[v].getLetra()==palabra.charAt(0)){
//                visitados[v]=true;  //el inicial ya se marca visitado
//                cola.insertarUltimo(v);  //se inserta este en el que nos fijaremos
//                while (!cola.esVacia()){
//                    
//                    NodoNumVertice vert = cola.eliminarPrimero();
//                    for (int adyacente: )
//                        
//                }
//               
//           }
//        }   
//    }

//    public void bfs(Grafo grafo, String palabra) {
//        boolean palabraEncontrada = false;
//        
//        for (int v = 0; v < grafo.getNumVertices(); v++) {
//            if (grafo.getListaVertices()[v].getLetra() == palabra.charAt(0)) {
//                boolean[] visitados = new boolean[grafo.getNumVertices()]; // Reset visitados para cada nueva búsqueda
//                if (buscarPalabra(grafo, palabra, v, visitados)) {
//                    palabraEncontrada = true;
//                    break;
//                }
//            }
//        }
//        
//        if (palabraEncontrada) {
//            System.out.println("La palabra " + palabra + " fue encontrada en el grafo.");
//        } else {
//            System.out.println("La palabra " + palabra + " no fue encontrada en el grafo.");
//        }
//    }
//
//    private boolean buscarPalabra(Grafo grafo, String palabra, int verticeInicial, boolean[] visitados) {
//        ListaNumVertice cola = new ListaNumVertice();
//        cola.insertarUltimo(verticeInicial);
//        visitados[verticeInicial] = true;
//        
//        int pos = 1;  // Posición en la palabra que estamos buscando
//        while (!cola.esVacia()) {
//            NodoNumVertice actual = cola.eliminarPrimero();
//            int numVertice = actual.getInfo();
//            
//            if (pos == palabra.length()) {
//                return true;  // Si se encontró toda la palabra
//            }
//
//            Nodo aux = grafo.getListaVertices()[numVertice].getListaAdy().primero();
//            while (aux != null) {
//                int adyacente = aux.getInfo().getDestino();
//                
//                if (!visitados[adyacente] && grafo.getListaVertices()[adyacente].getLetra() == palabra.charAt(pos)) {
//                    cola.insertarUltimo(adyacente);
//                    visitados[adyacente] = true;
//                    pos++;
//                    
//                    // Verificar si se encontró toda la palabra después de cada inserción exitosa
//                    if (pos == palabra.length()) {
//                        return true;
//                    }
//                }
//                
//                aux = aux.getNext();
//            }
//        }
//        return false;  // Si no se encontró la palabra
//    }
    }
    

    


//       String palabra= "hola";
//        for(int i=0; i<palabra.length(); i++){
//            System.out.println(palabra.charAt(i));
//        }
