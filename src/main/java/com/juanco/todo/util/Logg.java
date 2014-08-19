
package com.juanco.todo.util;

/**
 * Clase para el registro de eventos.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Logg {

    public Logg() {
    }
    
    /**
     * Registra la línea de texto para efectos de auditoría y debug.
     * 
     * @param linea - String - Texto a registrar.
     */
    public static void registrar(String linea) {
        System.out.println(linea);
    }

}
