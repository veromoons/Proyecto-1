/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leertxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import pruebagrafo.ListaSimple;

/**
 *
 * @author berna
 */
public class LeerTxt {
    private ListaSimple lista;
    private char [][] array;
    
    

public void crearLista(File abre){
    this.setLista(new ListaSimple());
        String line;
        String palabras_txt = "";
        
        try{
            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null && !line.equals("/dic")){
                palabras_txt += line + "\n";
                }           
            if (!"".equals(palabras_txt)){
                String [] palabras_split = palabras_txt.split("\n");
                   for (int i = 1; i < palabras_split.length; i++) {
                        lista.insertarUltimo(palabras_split[i]);  
            }
                br.close();
                JOptionPane.showMessageDialog(null, "Informacion guardada");
                lista.imprimir_lista();
            }
        }
       catch (Exception err){
           JOptionPane.showMessageDialog(null, "error");
       }
        
    }
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
                        //System.out.println(letras_split[cont]);
                        cont ++;
                    }
                }
                          
            }
                br.close();
                JOptionPane.showMessageDialog(null, "Informacion guardada");
                
            }
        
       catch (Exception err){
           JOptionPane.showMessageDialog(null, "error");
       }
        
    }
    /**
     * @return the lista
     */
    public ListaSimple getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }

    /**
     * @return the array
     */
    public char[][] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(char[][] array) {
        this.array = array;
    }
    public void imprimir_lista(){
      
    }

    public LeerTxt() {
    }


}
