package com.juanco.todo.rest;

import java.io.Serializable;
import java.sql.Timestamp;
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

import com.juanco.todo.modelo.jpa.dao.TareaDao;
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
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private TareaDao dao;
	
	/**
	 * Busca las tareas almacenadas.
	 * 
	 * @param realizadas - Boolean - Indica si se incluyen las tareas realizadas.
	 * @return List<Tarea> - Lista de tareas encontradas.
	 */
	@Path("/buscarTodas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarea> buscarTodas(@DefaultValue("true") @QueryParam("realizadas") boolean realizadas ) {
		
		return dao.buscarTodo();
	}
	
	@Path("/guardar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea agregar(@QueryParam("descripcion") String descripcion) {
		if(descripcion != null) {
			Tarea t = new Tarea();
			t.setFecha(new Timestamp(System.currentTimeMillis()));
			if("".equals(descripcion))
				t.setDescripcion("Vacio ...");
			else
				t.setDescripcion(descripcion);
			t.setRealizado(false);
			dao.guardar(t);
			return t;
		}
		return null;
	}
	
	@Path("/marcarComoRealizada")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea marcarComoRealizada(@QueryParam("id") String id) {
		Tarea t = dao.buscar(Integer.parseInt(id));
		if(t != null) {
			t.setRealizado(true);
			if(dao.actualizar(t)) {
				return t;
			}
		}
		return null;
	}
	
	@Path("/tarea/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Tarea buscarTarea(@PathParam("id") String id) {
		
		return dao.buscar(Integer.parseInt(id));
	}
}
