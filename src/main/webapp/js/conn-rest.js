/**
 * Módulo javascript para la conexión con servicios REST.
 */

/*
 * Definción de valores.
 */
var urlGetTask = "/to-do-list/rest/tareas/buscarTodas";

/**
 * Punto de ingreso al cargue de la aplicación.
 */
$(document).ready(function() {
	getTasks();
});

/**
 * Realiza el llamado ajax para obtener la lista de las tareas.
 */
function getTasks() {
	$.ajax({
	  url: urlGetTask,
	  type: 'get',
	  // data: parametros
	  dataType: 'json',
	  error: function(textStatus) {
		  // alert(textStatus);
	  },
	  success: function(data) {
		  if(typeof data !== "undefined" && data != null)
			  mostrarTareas(data);
	  }
	});
}
