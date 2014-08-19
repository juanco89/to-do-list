
package com.juanco.todo.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Dto para la entidad Tarea.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Tarea implements Serializable {
    
    private int id;
    private Date fecha;
    private String descripcion;
    private boolean realizado;

    public Tarea() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}
