
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

    public Solucion(Grafo grafo) {
        palabraValidada = new String[0];
        cantidadPalabras = 0;
        this.palabrabfs = null;
    }
    public boolean bfs(String palabra, int verticeInicial, Grafo grafo) { 
        boolean encontrada = false;
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            NodoMascara[] visitados = new NodoMascara[grafo.getNumVertices()]; 
            ColaMascara cola = new ColaMascara(); 
            int capa = 0; 
            
            //NodoMascara primero = new NodoMascara(grafo.getListaVertices()[v]);
            if (grafo.getListaVertices()[v].getLetra()==palabra.charAt(0)){
                cola.preinsertarPrimero(grafo.getListaVertices()[v]);
                capa++;
            }
            
            while (capa < palabra.length() && cola.getiN() != 0) {
//                System.out.println(cola.primero().getInfo().getLetra());
//                System.out.println(capa);
                NodoMascara aux = cola.primero();
                cola.eliminarPrimero(); //aqui de una vez lo elimino
                Nodo pAux = grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getFirst();  //adyacente actual
                
                int contadorDeBuenas=0;
                for (int ady = 0; ady < grafo.getListaVertices()[aux.getInfo().getNumVertice()].getListaAdy().getiN(); ady++) {
                    //System.out.println(visitados[pAux.getInfo().getDestino()].getCapa()==capa);
                    if (pAux.getInfo().getLetraDestino()==palabra.charAt(capa) && (visitados[pAux.getInfo().getDestino()]==null || visitados[pAux.getInfo().getDestino()].getCapa()==capa)) { //buscando hermanitos en los visitados
                        NodoMascara nuevo = new NodoMascara(grafo.getListaVertices()[pAux.getInfo().getDestino()]);
                        nuevo.setCapa(capa);
                        nuevo.setAncestor(aux);
                        cola.insertarUltimoCreado(nuevo);
                        contadorDeBuenas++;
                    }
                    pAux = pAux.getNext(); 
                }
                aux.setContador(contadorDeBuenas);
                visitados[aux.getInfo().getNumVertice()]=aux; //AQUI haremos validacion para eliminar recorrido perdido
                
//                if(contadorDeBuenas>=1){
//                    visitados[aux.getInfo().getNumVertice()]=aux; //AQUI haremos validacion para eliminar recorrido perdido
//                }else{
//                    NodoMascara puntero=aux.getAncestor();
//                    while(puntero!=null && puntero.getContador()<2){
//                        visitados[puntero.getInfo().getNumVertice()]=null;
//                        puntero=puntero.getAncestor();
//                    }
//                }
//              
                if (cola.primero()==null || cola.primero().getCapa() >aux.getCapa()){
                    capa++;
                }
                
            }
          /*  for (NodoMascara i: visitados){
                    if(i!=null){
                    System.out.println(i.getInfo().getNumVertice());
                    System.out.println(visitados[i.getInfo().getNumVertice()].getContador());
                        
                    }else{
                        System.out.println(i);
                    System.out.println("null");
                    }
                }*/
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


    public boolean buscarPalabraDFS(String palabra) {
        boolean[][] visitado = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dfs(i, j, palabra, 0, visitado)) {
                    agregarPalabraValidada(palabra);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String palabra, int indice, boolean[][] visitado) { 
        if (indice == palabra.length()) {
            return true;
        }
        if (i < 0 || i >= 4 || j < 0 || j >= 4 || visitado[i][j] || Main.grafo.getListaVertices()[i * 4 + j].getLetra() != palabra.charAt(indice)) {
            return false;
        }
        visitado[i][j] = true;
        int[][] direcciones = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] d : direcciones) {
            if (dfs(i + d[0], j + d[1], palabra, indice + 1, visitado)) {
                return true;
            }
        }
        visitado[i][j] = false;
        return false;
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

   
