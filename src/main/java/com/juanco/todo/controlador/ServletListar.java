
package com.juanco.todo.controlador;

import com.juanco.todo.modelo.jdbc.dao.TareaDao;
import com.juanco.todo.modelo.jdbc.dto.Tarea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador (Servlet) para el caso de listar las tareas.
 * 
 * Este controlador responde por get y por post.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class ServletListar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TareaDao dao = new TareaDao();
        List<Tarea> lista = dao.buscarTodo();
        
        request.setAttribute("tareas", lista);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Busca y lista todas las tareas existentes";
    }
}
