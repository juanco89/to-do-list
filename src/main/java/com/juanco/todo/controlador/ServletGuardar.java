package com.juanco.todo.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juanco.todo.modelo.jdbc.dao.TareaDao;
import com.juanco.todo.modelo.jdbc.dto.Tarea;
import com.juanco.todo.util.Logg;

/**
 * Controlador (Servlet) para la operacion de guardar tarea.
 * 
 * @author juan C. Orozco <juanco89@gmail.com>
 * @version 1.0
 */
public class ServletGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		Object descripcion = request.getParameter("txtDescripcion");
		
		if(descripcion != null) {
			Tarea dto = new Tarea();
			dto.setDescripcion((String)descripcion);
			dto.setFecha(new Date());
			dto.setRealizado(false);
			
			TareaDao dao = new TareaDao();
			try {
				dao.insertar(dto);
			} catch (SQLException e) {
				Logg.registrar(e.getLocalizedMessage());
			}
		}
        // Se redirige hacia el servlet de listar tareas.
        request.getRequestDispatcher("/listar-tareas").forward(request, response);
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	public String getServletInfo() {
		return "Almacena en db una nueva tarea";
	}
}
