
package pruebagrafo;
import Interfaces.VentanaPrueba;
import java.awt.Color;
import javax.swing.text.View;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


/**
 * Clase para implementar procedimientos en la interfaz //no seee
 * @author veronicaluna, sofiagrateron, ruthsenior
 */


public class Solucion { 
    private String palabrabfs;

    /**
     * Constructor
     * @param grafo 
     */
       
    public Solucion() {
        this.palabrabfs = null;   
    }
    /**
     * Metodo para implementar la busqueda BFS
     * @param palabra, palabra a buscar
     * @param verticeInicial
     * @param grafo
     * @return 
     */
    public String busquedaDiccionarioBFS(ListaSimple diccionario, Grafo grafo){
        String encontradas="";
        int contador=0;
        NodoListaSimple aux=diccionario.getFirst();
        while(contador<diccionario.getiN() && aux !=null){
            if (bfs(aux.getInfo(),0,grafo)){
                encontradas+= aux.getInfo()+"\n";
            }
            aux=aux.getNext();
            contador++;
        }
        return encontradas;
    }
    
    public boolean trackValidation(NodoMascara nodoInicio, Vertice nodoBuscado){
        boolean encontrado = false;
        NodoMascara puntero=nodoInicio.getAncestor(); //el primero de la palabra nunca tiene ancestro, no entra en el while y ya pq apunta a null x default 
        while(puntero!=null){
            if( puntero.getInfo() == nodoBuscado) { //aqui va a comparar todos los ancestros por cada letra de la palabra que se hayan conseguido hasta ahora e ira por cada ancestro para comparar si es igual al posible nodoBuscado que se esta considerando (adyacente pAux de aux)
               return true;                         //si es true significa que ya esta como ancestro, por lo que no lo va a repetir
            }else{                              
               puntero=puntero.getAncestor(); //y asi luego pasa al ancentro de nodoinicio consecutivamente hasta llegar al primer ancestro. Si no se consigue el nosoBuscado (pAux) entonces si es apto como siguiente letra
            }                                   //cada ancestro tiene su ancestro, es como una cadena y vas iterando en la cadena al anterior (ancestro) con un estilo de apuntador al ancestro cada vez
        }
        return encontrado;  //si no se consigue un ancestro en toda la cola igual a nodoBuscado, entonces se considera apto
    }
    /**
     * Metodo para hacer la busqueda BFS
     * @param palabra
     * @param verticeInicial
     * @param grafo
     * @return verdadero si la palabra fue encontrada
     */
    public boolean bfs(String palabra, int verticeInicial, Grafo grafo) { 
        boolean encontrada = false;
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            ListaMascara cola = new ListaMascara(); //es una lista con atributos de listas enlazadas, NO de cola (por ej preinsertar, en una cola no es permitido esto)
            int capa = 0;  //FRONTERA

            if (grafo.getListaVertices()[v].getLetra()==palabra.charAt(0)){
                cola.preinsertarPrimero(grafo.getListaVertices()[v]);
                capa++; 
            }
            
            while (capa < palabra.length() && cola.getiN() != 0) {
                NodoMascara aux = cola.primero();
                cola.eliminarPrimero(); //aqui elimino el primero (aux) para evaluar el siguiente (adyacentes ingresados de haber coincidencias)
                Nodo pAux = grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getFirst();  //al inicio es el primer adyacente del aux, luego es el actual
                
                for (int ady = 0; ady < grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getiN(); ady++) {
                    if (pAux.getInfo().getLetraDestino()==palabra.charAt(capa) && (!trackValidation(aux, grafo.getListaVertices()[pAux.getInfo().getDestino()]))) { //si es igual a la letra que sigue de aux (paux es adyacente) y no es ya ancestro de los ancestros de aux, entonces vas a buscarlo en la otra funcion
                        NodoMascara nuevo = new NodoMascara(grafo.getListaVertices()[pAux.getInfo().getDestino()]);
                        nuevo.setCapa(capa);
                        nuevo.setAncestor(aux);
                        cola.insertarUltimoCreado(nuevo);   //en cola se guardan los adyacentes de aux (si coincide con la letra de la palabra actual cada vez que se itera)
                    }
                    pAux = pAux.getNext();    //pasas a evaluar a ver si hay algun adyacente que coincida o en otro caso, si hay mas adyacentes con la misma letra de la que viene en la palabra buscada ya que es BFS, va por fronteras
                }
                
                if (cola.primero()==null || cola.primero().getCapa() >aux.getCapa()){ //NO AFECTA SI la cola esta vacia porque no entra al while aunque se sume a capa, es solo para wue no haya error de NPE
                    capa++;                                               //esto sirve para cambiar de capa  al llegar al inicio de la siguiente frontera porque al inicio es 0, consigue la primera igual que tiene capa 0 y luego la aumenta para los otros
                }
            }
               
            if (cola.getiN()>0) { //siempre quedan las ultimas letras de la palabra en la cola, si no quedan es porqu no esta la palabra. Si no encuentra la palabra, lista queda vacia ya que aux es ese ultimo nodomascara que quedaba en la lista y al entrar en el while de arriba, se elimina y no tiene adyacentes (se salta el for). Si consigue la ult letra, la convierte tambien en aux pero para porque se alcanzo el largo de la palabra
                encontrada=true;                            //asi, no se necesito crear una estructura auxiliar como una lista sino ir iterando por el atributo getAncestro
                NodoMascara puntero=cola.primero();   //de conseguirla, queda de primera la ultima letra de la palabra buscada (porque ahi paro la iteracion)
                String palabraFinal="";
                while(puntero!=null){                           // va iterando (igual que en trackValidation) en los ancestros
                    palabraFinal=puntero.getInfo().getNumVertice()+","+palabraFinal;
                    puntero=puntero.getAncestor();
                }
                //System.out.println("Recorrido: "+palabraFinal);   //por si acaso se quiere ver los numVertice de los que se encontraron como letras de la palabra
                this.palabrabfs = palabraFinal;
                break;
            } else {
                encontrada = false;
            }
        }
        return encontrada;
    }
    
    
    /**
     * Metodo para buscar todas las palabras del diccionario en el tablero por DFS
     * @param palabra
     * @return string de las palabras encontradas
     */
    public String busquedaDiccionarioDFS(ListaSimple diccionario, Grafo grafo){
        String encontradas="";
        int contador=0;
        NodoListaSimple aux=diccionario.getFirst();
        while(contador<diccionario.getiN() && aux !=null){
            if (buscarPalabraDFS(aux.getInfo())){
                encontradas+= aux.getInfo()+"\n";
            }
            aux=aux.getNext();
            contador++;
        }
        return encontradas;
    }
    /**
     * Metodo para buscar una palabra por DFS
     * @param palabra a buscar
     * @return verdadero si encontrada la palabra
     */
    public boolean buscarPalabraDFS(String palabra) {
        boolean[][] visitado = new boolean[4][4]; //matriz bidimensional que simula el grafo, asi como se aplico en leerTXT
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dfs(i, j, palabra, 0, visitado)) { 
                    return true;
                }
            }
        }
        return false;
    }
     
    /**
     * Metodo para buscar una palabra por DFS
     * @param i
     * @param j
     * @param palabra
     * @param posicionLetra
     * @param visitado
     * @return 
     */
    private boolean dfs(int i, int j, String palabra, int posicionLetra, boolean[][] visitado) { 
        if (posicionLetra == palabra.length()) { 
            return true;
        }
        if (i < 0 || i >= 4 || j < 0 || j >= 4 || visitado[i][j] ||  Main.grafo.getListaVertices()[i * 4 + j].getLetra() != palabra.charAt(posicionLetra)) {  //en recursividad, se trabaja con variables locales, cada llamada tiene acceso a las variables locales definidas en el ámbito de esa llamada
            return false;           //igual que en metodo crearGrafo en clase Grafo, pasando de i y j (matrices)(van de 0 hasta el max -1) a numVertice es i*4+j, y se hacen validaciones de i y j para la parte recursiva de analizar sus posibles posiciones, como en crearGrafo tal cual
        }                                                           //aqui entonces de verifica que ni esa posicion de ese numVertice este ya visitada y que la letra de ese vertice (segun su numVertice o su posicion en la lista de vertices) sea igual a la letra por la que vamos evaluando de la palabra
        
        visitado[i][j] = true;              //si no estaba visitado y paso hasta aqui porque la letra de este vertice coincide con la actual de la palabra, que se marque visitado
        int[][] posiblesMovimientos = //se analizan las posibles posiciones a las que s epuede mover para ir encontrando la palabra, se coloco asi para verlo mejor visualmente (al programar la funcion hizo falta verlo asi) como en crearGrafo y en el centro el actual
                    {{-1, -1}, {-1, 0}, {-1, 1}, //en el centro iria (i,j) donde por ej en la posicion de abajo, se sabe que es (i+1, misma columna j), igual que el analisis en crearGrafo
                    {0, -1},            {0, 1}, 
                    {1, -1},  {1, 0},   {1, 1}};  
        
        for (int parIJ = 0; parIJ < posiblesMovimientos.length; parIJ++) {  //igual que en metodo crearGrafo en clase Grafo...
            int[] subindices = posiblesMovimientos[parIJ];                  //se queda en este for para la recursiva, de ser False al probar con una posible siguiente letra, va a la posiicon siguiente del for. Cuando la consigue y se llega a la palabra (Retorna true en el primer if de funcion dfs), toda la funcion retorna true que es como el break del for y si se devuelve a busquedaDFS
            if (dfs(i + subindices[0], j + subindices[1], palabra, posicionLetra + 1, visitado)) {  //empezamos el backtracking donde vamos por ambientes, y cuando se llegue al limite de letras en la palabra (posicionLetra = palabra.len) 
                return true;  //aqui es como el break del for, se va a busquedaPalabraDFS para decir que si la consiguio y se acaba todo.
                              //se ser true, hace la llamada para la siguiente letra y asi hasta que o sea false y se acabe el for y pase para abajo o que sea true y se salga porque consiguio la palabra y todo pare
            }
        }//estas dos lineas son de bacjtracking luego de haber recorrido una posible palabra y que no haya reusltado, va hacia atras en las llamadas para colocar su puesto en b=visitados como true
        visitado[i][j] = false; //aqui hasta que se acabe el backtracking y haya marcado todos como T en visitados para que puedan volver a considerarse para la palabra
        return false; //esto es para la primera llamada que se hizo y se devuelve a buscarPalabraDFS que se quedo como pausado en esa primera llamada, y considera las siguientes letras
    }

    /**
     * Metodo para mostrar el grafo en una ventana
     * @param grafo
     */
    public void mostrarGrafo(Grafo grafo){                     //de nuevo, basandonos en el mismo codigo y logica que logramos en crearGrafo (que tambien usamos en DFS ya que sirvio la logica) 
        Graph grafo_mostrar = new MultiGraph("Grafo");
        Node[] arrayNodos = new Node[16];
        for (int i = 0; i < arrayNodos.length; i++) {
            String id = "";
            id += i;
            arrayNodos[i] = grafo_mostrar.addNode(id);
            arrayNodos[i].setAttribute(id, grafo.getListaVertices()[i].getLetra());
            
        }
        int id = 0;
        for (Node node : grafo_mostrar){
            node.setAttribute("ui.label", node.getAttribute(Integer.toString(id)));
            id ++;
       
        }
      String sId = "";
        int tamanoiyj = 4;     
        for (int i = 0; i < tamanoiyj; i++) {
            for (int j = 0; j < tamanoiyj; j++) {
                int actual = i * tamanoiyj + j;
                int[][] posiblesPosiciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},         {0, 1}, //0,0  
                    {1, -1}, {1, 0}, {1, 1}
                };

                for (int parIJ = 0; parIJ < posiblesPosiciones.length; parIJ++) {
                    int[] subindices = posiblesPosiciones[parIJ];  //subindices i o j de una matriz, i es el elemento de fila y j el de columna
                    int nuevai = i + subindices[0]; //0 es la posicion de i, 1 es la posicion de j
                    int nuevaj = j + subindices[1]; 
                    int nuevoDestino = nuevai * tamanoiyj + nuevaj;

                    
                    if (nuevai >= 0 && nuevai < tamanoiyj && nuevaj >= 0 && nuevaj < tamanoiyj) {
                        //agregarArista(actual, nuevoIndice);  
                        sId += actual + "-";
                        sId += nuevoDestino;
                        //System.out.println(id);
                        try{
                          grafo_mostrar.addEdge(sId, arrayNodos[actual], arrayNodos[nuevoDestino]);  
                        }
                        catch (Exception e){
                            
                        }
                        sId = "";
        }
        
    }
    
}
        }
        grafo_mostrar.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 60px, 60px;\n" +
                "    fill-color: pink;\n" +
                "    text-mode: normal; \n" +
                "    text-size: 40px; \n" +
                "    shape: box; \n" +
                "}");
        
        System.setProperty("org.graphstream.ui","swing");
        Viewer viewer = grafo_mostrar.display();
        viewer.disableAutoLayout();
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    /**
     * Metodo para mostrar el recorrido de la palabra encontrada
     * @param grafo
     * @param verticesPalabra, string con los indices de las letras de la palabra encotrada
     */
     public void mostrarRecorrido(Grafo grafo, String verticesPalabra){             //aqui tambien nos basamos en la misma logica y codigo de crearGrafo al igual que en busqueda DFS y la funcion de arriba mostrarGrafo...
        Graph grafo_mostrar = new MultiGraph("Grafo");
        Node[] arrayNodos = new Node[16];
        for (int i = 0; i < arrayNodos.length; i++) {
            String id = "";
            id += i;
            arrayNodos[i] = grafo_mostrar.addNode(id);
            arrayNodos[i].setAttribute(id, grafo.getListaVertices()[i].getLetra());
            
        }
        int id = 0;
        for (Node node : grafo_mostrar){
            node.setAttribute("ui.label", node.getAttribute(Integer.toString(id)));
            id ++;
       
        }
      String sId = "";
        int tamanoiyj = 4;
        for (int i = 0; i < tamanoiyj; i++) {
            for (int j = 0; j < tamanoiyj; j++) {
                int actual = i * tamanoiyj + j;
                int[][] posiblesPosiciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},         {0, 1}, 
                    {1, -1}, {1, 0}, {1, 1}
                };

                for (int parIJ = 0; parIJ < posiblesPosiciones.length; parIJ++) {
                    int[] subindices = posiblesPosiciones[parIJ];  //subindices i o j de una matriz, i es el elemento de fila y j el de columna
                    int nuevai = i + subindices[0]; //0 es la posicion de i, 1 es la posicion de j
                    int nuevaj = j + subindices[1]; 
                    int nuevoDestino = nuevai * tamanoiyj + nuevaj;

                    
                    if (nuevai >= 0 && nuevai < tamanoiyj && nuevaj >= 0 && nuevaj < tamanoiyj) {
                        sId += actual + "-";
                        sId += nuevoDestino;
                        try{
                          grafo_mostrar.addEdge(sId, arrayNodos[actual], arrayNodos[nuevoDestino]);  
                        }
                        catch (Exception e){
                            
                        }
                        sId = "";
        }
        
    }
    
}
        }
        grafo_mostrar.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 60px, 60px;\n" +
                "    text-mode: normal; \n" +
                "    fill-mode: dyn-plain; \n" +
                "    text-size: 40px; \n" +
                "    shape: box; \n" +
                "}" +
        "edge {" +
        "    fill-mode: dyn-plain;" +
        "}");
        String [] arrayVertices = verticesPalabra.split(",");
        int numVertice;
        for (int i = 0; i < arrayVertices.length; i++) {
             numVertice = Integer.parseInt(arrayVertices[i]);
             arrayNodos[numVertice].setAttribute("ui.color", Color.pink);
             String indice = "";
             if (i != arrayVertices.length -1){
             indice += arrayVertices[i] + "-";
             indice += arrayVertices[i+1];
             grafo_mostrar.getEdge(indice).setAttribute("ui.color", Color.pink);
             }
         }              
         for (int i = 0; i < arrayNodos.length; i++) {
             if (arrayNodos[i].getAttribute("ui.color") == null){
                 arrayNodos[i].setAttribute("ui.color", Color.white);
             }
         }
        System.setProperty("org.graphstream.ui","swing");
        Viewer viewer = grafo_mostrar.display();
        viewer.disableAutoLayout();
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
    }
    /**
     * 
     * @return 
     */
    public String getPalabrabfs() {
        return palabrabfs;
    }
    
    
}

   
