<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.juanco.todo.modelo.jdbc.dto.Tarea"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JAVA Servlets TO DO</title>
    </head>
    <body>
    	<div id="contenido">
	    	<div>
	    		<form name="frmGuardarTareaEstatica" method="post" action="guardar-tarea">
	    			<label for="txtDescripcion">Descripción</label>
	    			<input type="text" id="txtDescripcion" name="txtDescripcion" value="" />
	    			
	    			<input type="submit" id="btnGuardar" name="btnGuardar" value="Guardar" />
	    		</form>
	    	</div>
	    	<br />
	    	<table>
	    		<tr>
	    			<th>#</th>
	    			<th>Descripción</th>
	    			<th>Fecha - Hora</th>
	    			<th>Realizada</th>
	    		</tr>
	    		<%
	    			List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
	    			if(tareas != null && tareas.size() > 0) {
	    				DateFormat format = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
	    				int i = 0;
	    				for(Tarea t: tareas) {
	    					i++;
	    		%>
				    		<tr>
				    			<th><%= i %></th>
				    			<th><%= t.getDescripcion() %></th>
				    			<th><%= format.format(t.getFecha()) %></th>
				    			<th><%= t.isRealizado()? 
				    					"Si": 
				    					"<a href='terminar-tarea?id=" +  t.getId() + "'>No</a>" %></th>
				    		</tr>
	    		<%
	    				}
	    			}
	    		%>
	    	</table>
    	</div>
    </body>
</html>
