package com.juanco.todo.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.juanco.todo.modelo.jpa.dao.TareaDao;
import com.juanco.todo.modelo.jpa.entidades.Tarea;


/**
 * Servicio web REST para exponer el recurso Tareas.
 * 
 * API:
 * /tareas (GET) listAll
 * /tareas/:id  (GET) get
 * /tareas  (POST)  create
 * /tareas/:id  (PUT)  update
 * /tareas/:id  (DELETE) remove
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 *
 */
@Path("/tasks")
public class ServicioTareasRest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private TareaDao dao;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarea> buscarTodas() {
		return dao.buscarTodo();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea buscarTarea(@PathParam("id") String id) {
		return dao.buscar(Integer.parseInt(id));
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea crear(Tarea tarea) {
		return (dao.guardar(tarea)) ? tarea : null ;
	}
	
	
	@Path("/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea agregar(@PathParam("id") String id, Tarea tarea) {
		if(tarea != null) {
			if(dao.actualizar(tarea)) {
				return tarea;
			}
		}
		return null;
	}
	
}
