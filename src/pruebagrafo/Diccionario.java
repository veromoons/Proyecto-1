/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebagrafo;

/**
 *
 * @author berna
 */
public class Diccionario {
    private ListaSimple diccionario;
    private ListaSimple listaPalabras;
    
    public Diccionario() {
        listaPalabras = new ListaSimple();
    }

    public ListaSimple obtenerLista() {
        return listaPalabras;
    }
  

    public Diccionario(ListaSimple diccionario) {
        this.diccionario = diccionario;
    }
    
   
    /**
     * @return the diccionario
     */
    public ListaSimple getDiccionario() {
        return diccionario;
    }
    
    

    /**
     * @param diccionario the diccionario to set
     */
 
    
}
