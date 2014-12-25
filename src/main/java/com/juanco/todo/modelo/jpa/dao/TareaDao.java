package com.juanco.todo.modelo.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.juanco.todo.modelo.jpa.entidades.Tarea;
import com.juanco.todo.util.Logg;

/**
 * Dao EJB para la entidad TAREA.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Stateless
public class TareaDao {

	@PersistenceContext(unitName="UnidadTODO")
	private EntityManager em;
	
    public TareaDao() {
    }
    
	public List<Tarea> buscarTodo()	{
		List<Tarea> resultado = null;
		try {
			// JPA: "SELECT t FROM Tarea t ORDER BY t.fecha, t.realizado"
			resultado = (List<Tarea>) em.createNativeQuery("SELECT * FROM tarea ORDER BY realizado, fecha", Tarea.class).getResultList();
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
		}
    	return resultado;
    }
    
	public boolean guardar(Tarea tarea) {
		try {
			em.persist(tarea);
			return true;
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
			return false;
		}
	}
	
	public Tarea buscar(int id) {
		try {
			return em.find(Tarea.class, id);
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
			return null;
		}
	}
	
	public boolean actualizar(Tarea tarea) {
		try {
			em.merge(tarea);
			return true;
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
			return false;
		}
	}
}
