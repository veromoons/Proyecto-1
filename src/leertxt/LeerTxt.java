/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leertxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import pruebagrafo.Diccionario;
import pruebagrafo.ListaSimple;
import pruebagrafo.NodoListaSimple;

/**
 * Clase para extraer la informacion del txt y guardarla en el memoria
 * @author sofiagrateron
 */
public class LeerTxt {
    private ListaSimple lista;
    private Diccionario dic;
    private char [][] array;

        /**
         * Constructor
         */
    public LeerTxt(){
        }
    
    public void anadirPalabraNuevaTXT(String palabraNueva, ListaSimple diccion, File abre){
        boolean encontrada = false;
        diccion.imprimir_lista();
        if (diccion.getFirst()!=null){  //si la lista no esta vacia
            NodoListaSimple aux = diccion.getFirst();
            while (aux!=null && encontrada==false){
                if (aux.getInfo().equals(palabraNueva)){
                    encontrada=true;
                }else{
                    aux=aux.getNext();
                }
            }
            if (!encontrada){
                ListaSimple listaTemp = new ListaSimple();   //aqui creamos la estructura auxiliar temporal para luego pegarla toda en el txt (reescribirlo)
                try{
                    FileReader fr = new FileReader(abre);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while (line != null) {
                        if (line.equals("/dic")) {
                            listaTemp.insertarUltimo(palabraNueva);  //anade la palabra justo antes de la linea que dice /dic en el txt
                            diccion.insertarUltimo(palabraNueva);
                        }
                        listaTemp.insertarUltimo(line); //igual la anade a la lista temp por la intencion del codigo (reescribir)
                        line = br.readLine();
                    }
                    br.close();  
                    JOptionPane.showMessageDialog(null, "Palabra añadida exitosamente.");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo leer el archivo.");
                }
                try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(abre)))) {
                    NodoListaSimple pAux = listaTemp.getFirst();
                    while(pAux!=null){
                        out.println(pAux.getInfo());
                        pAux=pAux.getNext();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo reescribir el archivo.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Esta palabra ya existe en el diccionario.");
            }
        }
    }
    

    /**
     * Metodo para extraer las palabras del txt y guardarlo en una lista
     * @param abre, archivo escogido en el JFileChooser por el usuario
     */
    public boolean crearLista(File abre) {
        this.setLista(new ListaSimple());
        String line;
        String palabras_txt = "";
        if(abre!=null){
            try{
                FileReader fr = new FileReader(abre);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine().toUpperCase()) != null && !line.equals("/DIC")){
                    if (line.length() > 2){
                        palabras_txt += line + "\n";
                    }
                    else{
                        return false;
                    }
                }           
                if (!"".equals(palabras_txt)){
                    String [] palabras_split = palabras_txt.split("\n");
                    for (int i = 1; i < palabras_split.length; i++) {
                        lista.insertarUltimo(palabras_split[i]);
                    }
                    br.close();
                    // guardar diccionario
                    Diccionario dic = new Diccionario(this.lista);
                    setDic(dic);
                }
                return true;
            }
            catch (Exception err){
               JOptionPane.showMessageDialog(null, "No se pudo leer el archivo ingresado. Intente con un archivo de tipo TXT valido.");
            }
        }
        return false;
    }
    /**
     * Metodo para extraer las letras del txt y guardarlas en un array doble
     * @param abre, archivo escojido en el JFileChooser por el usuario
     */
    public boolean crearArray(File abre){
        String returnS = "";
        this.setArray(new char [4][4]);
        String line;
        String letras_txt = "";
        
        try{
            String tab = "tab";
            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null && !line.equals("/tab")){
                if (line.equals(tab)){
                    line = br.readLine();
                    letras_txt += line;
                   
                } 
                }
            if (!"".equals(letras_txt)){
                String [] letras_split = letras_txt.split(",");
                for (int i = 0; i < letras_split.length; i++) {
                    if (!letras_split[i].matches("[A-Z]+")){
                        return false;
                    }
                            }
                
                int cont = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++){
                        this.array[i][j] = letras_split[cont].charAt(0);
                        //System.out.println(letras_split[cont]); para probar si se estan guardando las letras
                        cont ++;
                    }
                }
                          
            }
                br.close();
                return true;
            
            }
        
       catch (Exception err){
           JOptionPane.showMessageDialog(null, "No se pudo leer el archivo ingresado. Intente con un archivo de tipo TXT valido.");
       }
      return false;  
    }
    /**
     * Metodo para obtener la lista de palabras
     * @return the lista
     */
    public ListaSimple getLista() {
        return lista;
    }

    /**
     * Metodo para guardar la lista de palabras como atributo de la clase
     * @param lista the lista to set
     */
    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }

    /**
     * Metodo para obtener el array doble de letras
     * @return the array
     */
    public char[][] getArray() {
        return array;
    }

    /**
     * Metodo para guardar el array doble de letras como atributo de la clase
     * @param array the array to set
     */
    public void setArray(char[][] array) {
        this.array = array;
    }
    /**
     * Metodo para guardar un el diccionario completo de palabras como atributo de la clase
     * @param dic 
     */
    public void setDic(Diccionario dic) {
        this.dic = dic;
    }
    /**
     * Metodo para obtener el diccionario completo de palabras
     * @return 
     */
    public Diccionario getDic() {
        return dic;
    }


}