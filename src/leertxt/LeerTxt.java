/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leertxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import pruebagrafo.Diccionario;
import pruebagrafo.ListaSimple;

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
    public LeerTxt() {
    }
    
    /**
    * Metodo para extraer las palabras del txt y guardarlo en una lista
    * @param abre, archivo escojido en el JFileChooser por el usuario
    */
public void crearLista(File abre){
    this.setLista(new ListaSimple());
        String line;
        String palabras_txt = "";
        
        try{
            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine().toUpperCase()) != null && !line.equals("/dic")){
                if (line.length() >2){
                palabras_txt += line + "\n";
                }
                }           
            if (!"".equals(palabras_txt)){
                String [] palabras_split = palabras_txt.split("\n");
                   for (int i = 1; i < palabras_split.length; i++) {
                        lista.insertarUltimo(palabras_split[i]);  
            }
                br.close();
                //JOptionPane.showMessageDialog(null, "Informacion guardada");
                //lista.imprimir_lista(); para probar si se estan guardando las palabras
                // guardar diccionario
                Diccionario dic = new Diccionario(this.lista);
                setDic(dic);
            }
        }
       catch (Exception err){
           JOptionPane.showMessageDialog(null, "Ingrese un documento valido. No es posible guardar las palabras");
       }
        
    }
    /**
     * Metodo para extraer las letras del txt y guardarlas en un array doble
     * @param abre, archivo escojido en el JFileChooser por el usuario
     */
    public void crearArray(File abre){
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
                //JOptionPane.showMessageDialog(null, "Informacion guardada");
                
            }
        
       catch (Exception err){
           JOptionPane.showMessageDialog(null, "Ingrese un documento valido. No fue posible guardar las letras.");
       }
        
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
