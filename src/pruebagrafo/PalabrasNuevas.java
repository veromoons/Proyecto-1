/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;   
import java.io.IOException;
/**
 *
 * @author ruthsenior
 */


public class PalabrasNuevas {
    private String[] palabrasNuevas;
    private int cantidadPalabras;
    
    public PalabrasNuevas() {
        this.palabrasNuevas = new String[0];
        this.cantidadPalabras = 0;
    }
    
    public void agregarPalabra(String palabra) {
        if (!tienePalabra(palabra.toUpperCase())) {
            String[] nuevasPalabras = new String[getCantidadPalabras() + 1];
            System.arraycopy(getPalabrasNuevas(), 0, nuevasPalabras, 0, getCantidadPalabras());
            nuevasPalabras[getCantidadPalabras()] = palabra.toUpperCase();
            setCantidadPalabras(getCantidadPalabras() + 1);
            setPalabrasNuevas(nuevasPalabras);
        }
    }
    
    private boolean tienePalabra(String palabra) {
        for (int i = 0; i < getCantidadPalabras(); i++) {
            if (getPalabrasNuevas()[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }
   
    public String[] guardarPalabrasNuevas(String archivo) throws IOException {
        if (getCantidadPalabras() == 0) {
            System.out.println("No se han encontrado palabras todavía");
            return new String[0];
        }
        
        
        StringBuilder contenidoExistente = new StringBuilder();
        File file = new File(archivo);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contenidoExistente.append(linea).append("\n");
                }
            }
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contenidoExistente.toString());
            for (int i = 0; i < getCantidadPalabras(); i++) {
                writer.write(getPalabrasNuevas()[i]);
                writer.newLine();
            }
        }

        String[] palabrasGuardadas = new String[getCantidadPalabras()];
        System.arraycopy(getPalabrasNuevas(), 0, palabrasGuardadas, 0, getCantidadPalabras());
        return palabrasGuardadas;
    }


    /**
     * @return the palabrasNuevas
     */
    public String[] getPalabrasNuevas() {
        return palabrasNuevas;
    }

    /**
     * @param palabrasNuevas the palabrasNuevas to set
     */
    public void setPalabrasNuevas(String[] palabrasNuevas) {
        this.palabrasNuevas = palabrasNuevas;
    }

    /**
     * @return the cantidadPalabras
     */
    public int getCantidadPalabras() {
        return cantidadPalabras;
    }

    /**
     * @param cantidadPalabras the cantidadPalabras to set
     */
    public void setCantidadPalabras(int cantidadPalabras) {
        this.cantidadPalabras = cantidadPalabras;
    }

}
   