package com.juanco.todo.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.juanco.todo.modelo.jpa.dao.TareaDaoEJB;
import com.juanco.todo.modelo.jpa.entidades.Tarea;


/**
 * Servicio web REST para exponer las operaciones de negocio para
 * la gestión de la lista de tareas.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 *
 */
@Path("tareas")
public class ServicioTareas implements Serializable {
	
	@EJB
	private TareaDaoEJB dao;
	
	@Path("/buscarTodas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarea> buscarTodas(@DefaultValue("true") @QueryParam("realizadas") boolean realizadas ) {
		
		return dao.buscarTodo();
	}
	
	@Path("/marcarComoRealizada/{tarea}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public boolean marcarComoRealizada(@PathParam("tarea") String tarea) {
		
		return false;
	}
	
}
