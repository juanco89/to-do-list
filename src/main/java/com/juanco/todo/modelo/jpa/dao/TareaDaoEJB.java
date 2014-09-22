package com.juanco.todo.modelo.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.juanco.todo.modelo.jpa.entidades.Tarea;

/**
 * Dao EJB para la entidad TAREA.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Stateless
public class TareaDaoEJB {

	@PersistenceContext(unitName="UnidadTODO")
	private EntityManager em;
	
    public TareaDaoEJB() {
    }
    
    public List<Tarea> buscarTodo()	{	
		List<Tarea> resultado = null;
		try {
			resultado =  em.createNativeQuery("SELECT * FROM tarea", Tarea.class).getResultList();
		}catch(Exception e) {
			// logging
		}
    	return resultado;
    }
    
}
