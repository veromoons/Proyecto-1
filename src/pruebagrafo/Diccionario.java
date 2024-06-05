/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 * Clase para guardar listas de palabras
 * @author sofiagrateron
 */
public class Diccionario {
    private ListaSimple diccionario;
    private ListaSimple listaPalabras;

    /**
     * Constructor
     * @param diccionario 
     */
    public Diccionario(ListaSimple diccionario) {
        this.diccionario = diccionario;
        this.listaPalabras = diccionario;
    }
    public Diccionario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Metodo para obtener una lista de palabras en especifico
     * @return 
     */
    public ListaSimple obtenerLista() {
        return listaPalabras;
    }
   
    /**
     * Metodo para obtener el diccionario
     * @return the diccionario
     */
    public ListaSimple getDiccionario() {
        return diccionario;
    }
    
}
