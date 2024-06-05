
package pruebagrafo;
import Interfaces.VentanaPrueba;
import java.awt.Color;
import javax.swing.text.View;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


/**
 *
 * 
 */


public class Solucion { 
    private String[] palabraValidada;
    private int cantidadPalabras;
    private String palabrabfs;

    public Solucion(Grafo grafo) {  //QUITAR este parametro pq no hace nada con el
        palabraValidada = new String[0];
        cantidadPalabras = 0;
        this.palabrabfs = null;
    }
    
    
    public String busquedaDiccionarioBFS(ListaSimple diccionario, Grafo grafo){
        String encontradas="";
        int contador=0;
        NodoListaSimple aux=diccionario.primero();
        while(contador<diccionario.getiN() && aux !=null){
            if (bfs(aux.getInfo(),0,grafo)){
                encontradas+= aux.getInfo()+"\n";
            }
            aux=aux.getNext();
            contador++;
        }
        return encontradas;
    }
    
    //ERROR CON: TAMARA, repite una A ver el output o el recorrido en la interfaz, pero no falla con CHAOA por ej
    public boolean bfs(String palabra, int verticeInicial, Grafo grafo) { 
        boolean encontrada = false;
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            NodoMascara[] visitados = new NodoMascara[grafo.getNumVertices()]; //todos empiezan en nulos, bo booleanos porque guardamos es mascara
            ColaMascara cola = new ColaMascara(); 
            int capa = 0;  //FRONTERA

            if (grafo.getListaVertices()[v].getLetra()==palabra.charAt(0)){
                cola.preinsertarPrimero(grafo.getListaVertices()[v]);
                capa++; 
            }
            
            while (capa < palabra.length() && cola.getiN() != 0) {
                NodoMascara aux = cola.primero();
                cola.eliminarPrimero(); //aqui de una vez lo elimino
                Nodo pAux = grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getFirst();  //adyacente actual
                
                int contadorDeBuenas=0;
                for (int ady = 0; ady < grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getiN(); ady++) {
                    if (pAux.getInfo().getLetraDestino()==palabra.charAt(capa) && (visitados[pAux.getInfo().getDestino()]==null || visitados[pAux.getInfo().getDestino()].getCapa()==capa)) { //buscando hermanitos en los visitados
                        NodoMascara nuevo = new NodoMascara(grafo.getListaVertices()[pAux.getInfo().getDestino()]);
                        nuevo.setCapa(capa);
                        nuevo.setAncestor(aux);
                        cola.insertarUltimoCreado(nuevo);
                        contadorDeBuenas++; //los q anade a la cola, adyacentes q son iguales a la sig letra de la palabra
                    }
                    pAux = pAux.getNext(); 
                }
                aux.setContador(contadorDeBuenas);
                
                if(contadorDeBuenas>=1){//AQUI haremos validacion para eliminar recorrido perdido. Aux es A en la primera ej si quieres ABgd
                    visitados[aux.getInfo().getNumVertice()]=aux; //aqui es donde se guarda en visitados aux antes de pasar al siguiente y evaluar sus adyacentes igual
                }else{                                              //en visitados se anaden en la posicion de su indice numvertice
                    NodoMascara puntero=aux.getAncestor(); //el primero de la palabra nunca tiene ancestro, no entra en el while y ya pq apunta a null x default 
                    while(puntero!=null){ //lo minimo que tenga es un hijo para no borrarle el camino por otro lado que si sea valido, ya ahi tendria 2 o mas
                        if( puntero.getContador()<2) {
                        visitados[puntero.getInfo().getNumVertice()]=null;
                         puntero=puntero.getAncestor();
                        }else{                              //si una bifurcacion no ocurre en el inicio de una rama, me va a descontar uno de ese contador por si otra ramificacion tambien necesita hacer el backtracking o devolverse
                            int contadorActual = puntero.getContador();
                            puntero.setContador(contadorActual-1);
                        }   
                    }
                }
              
                if (cola.primero()==null || cola.primero().getCapa() >aux.getCapa()){ //NO AFECTA SI la cola esta vacia porque no entra al while aunque se sume a capa, es solo para wue no haya error de NPE
                    capa++;                                               //esto sirve para cambiar de capa  al llegar al inicio de la siguiente frontera
                }
                
            }
               
            if (cola.getiN()>0) {
                encontrada=true;
                NodoMascara puntero=cola.primero();
                String palabraFinal="";
                while(puntero!=null){
                    palabraFinal=puntero.getInfo().getNumVertice()+","+palabraFinal;
                    puntero=puntero.getAncestor();
                }
                //System.out.println(palabraFinal);
                this.palabrabfs = palabraFinal;
                break;
            } else {
                encontrada = false;
            }
        }
        return encontrada;
    }
    
    
    
    
    
    
    
    public String busquedaDiccionarioDFS(ListaSimple diccionario, Grafo grafo){
        String encontradas="";
        int contador=0;
        NodoListaSimple aux=diccionario.primero();
        while(contador<diccionario.getiN() && aux !=null){
            if (buscarPalabraDFS(aux.getInfo())){
                encontradas+= aux.getInfo()+"\n";
            }
            aux=aux.getNext();
            contador++;
        }
        return encontradas;
    }
 

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
    

    
    
    
    
    
    
    public void mostrarGrafo(Grafo grafo){
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
        int dimension = 4;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int actual = i * dimension + j;
                int[][] direcciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},         {0, 1}, //0,0  
                    {1, -1}, {1, 0}, {1, 1}
                };

                for (int[] d : direcciones) { 
                    int nuevai = i + d[0]; 
                    int nuevaj = j + d[1];
                    int nuevoIndice = nuevai * dimension + nuevaj;

                    
                    if (nuevai >= 0 && nuevai < dimension && nuevaj >= 0 && nuevaj < dimension) {
                        //agregarArista(actual, nuevoIndice);  
                        sId += actual + "-";
                        sId += nuevoIndice;
                        //System.out.println(id);
                        try{
                          grafo_mostrar.addEdge(sId, arrayNodos[actual], arrayNodos[nuevoIndice]);  
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
     public void mostrarRecorrido(Grafo grafo, String verticesPalabra){
         System.out.println(verticesPalabra);
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
        int dimension = 4;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int actual = i * dimension + j;
                int[][] direcciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},         {0, 1}, //0,0  
                    {1, -1}, {1, 0}, {1, 1}
                };

                for (int[] d : direcciones) { 
                    int nuevai = i + d[0]; 
                    int nuevaj = j + d[1];
                    int nuevoIndice = nuevai * dimension + nuevaj;

                    
                    if (nuevai >= 0 && nuevai < dimension && nuevaj >= 0 && nuevaj < dimension) {
                        //agregarArista(actual, nuevoIndice);  
                        sId += actual + "-";
                        sId += nuevoIndice;
                        //System.out.println(id);
                        try{
                          grafo_mostrar.addEdge(sId, arrayNodos[actual], arrayNodos[nuevoIndice]);  
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
                "}");
        String [] arrayVertices = verticesPalabra.split(",");
        int numVertice;
         for (int i = 0; i < arrayVertices.length; i++) {
             numVertice = Integer.parseInt(arrayVertices[i]);
             arrayNodos[numVertice].setAttribute("ui.color", Color.pink);
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

    public Solucion() {
    }
     

    private void agregarPalabraValidada(String palabra) {
        String[] nuevoDiccionario = new String[cantidadPalabras + 1];
        for (int i = 0; i < cantidadPalabras; i++) {
            nuevoDiccionario[i] = palabraValidada[i];
        }
        nuevoDiccionario[cantidadPalabras] = palabra;
        palabraValidada = nuevoDiccionario;
        cantidadPalabras++;
    }

    public String[] getPalabraValidada() {
        return palabraValidada;
    }

    public void buscarPalabrasValidadasDFS(Diccionario diccionario) {
        NodoListaSimple palabraActual = diccionario.obtenerLista().getFirst();
        while (palabraActual != null) {
            buscarPalabraDFS(palabraActual.getInfo().toString());
            palabraActual = palabraActual.getNext();
        }
    }

    public String getPalabrabfs() {
        return palabrabfs;
    }

    
    
}

   
