package com.juanco.todo.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.juanco.todo.modelo.dto.Tarea;


/**
 * Servicio web REST para exponer las operaciones de negocio para
 * la gestión de la lista de tareas.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 *
 */
@Path("tareas")
public class ServicioTareas implements Serializable {
	
	@Path("/buscarTodas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarea> buscarTodas() {
		
		return new ArrayList<Tarea>();
	}
	
}
