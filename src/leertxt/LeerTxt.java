/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leertxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import pruebagrafo.Lista;

/**
 *
 * @author berna
 */
public class LeerTxt {
    private Lista lista;
    private int [] array;
    
    

public void crearLista(){
    this.setLista(new Lista());
        String line;
        String palabras_txt = "";
        String path = "test\\dic.txt";
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        while (!line.equals("/dic")){
                        palabras_txt += line + "\n";
                        }
                    }
                        }
                if (!"".equals(palabras_txt)){
                    String [] palabras_split = palabras_txt.split("\n");
                    for (int i = 1; i < palabras_split.length; i++) {
                        String [] palabra = palabras_split[i].split(",");
                        //clientes.agregarAlFinal(cliente[0], Integer.parseInt(cliente[1]));
                        
                    
                }
            }
                br.close();
                JOptionPane.showMessageDialog(null, "Informacion guardada");
            }
        }
       catch (Exception err){
           //JOptionPane.showMessageDialog(null, "error al leer clientes");
       }
        
    }

    /**
     * @return the lista
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * @return the array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(int[] array) {
        this.array = array;
    }

}
