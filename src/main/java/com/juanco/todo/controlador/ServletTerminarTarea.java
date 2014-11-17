package com.juanco.todo.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juanco.todo.modelo.jdbc.dao.TareaDao;
import com.juanco.todo.util.Logg;

/**
 * Servlet encargado de actualizar las tarea marcandolas como realizadas.
 * 
 * @author juanco89@gmail.com
 * @version 1.0
 */
public class ServletTerminarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		Object identificador = request.getParameter("id");
		
		if(identificador != null) {
			int id = -1;
			try {
				id = Integer.parseInt( ((String)identificador) );
				
				// Se actualiza la tarea
				TareaDao dao = new TareaDao();
				try {
					dao.marcarComoRealizada(id);
				} catch (SQLException e) {
					Logg.registrar(e.getLocalizedMessage());
				}
			}catch(Exception e) {
				Logg.registrar("No se pudo realizar casting del identificador: " + e.getLocalizedMessage());
			}
		}
        
    	// Se redirige hacia el servlet de listar tareas.
        request.getRequestDispatcher("/listar-tareas").forward(request, response);
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Actualiza una tarea específica marcándola como realizada";
	}
}
