/**
 * Módulo javascript para la conexión con servicios REST.
 */

var App = (function (module) {
	
	module.rest = module.rest || {};
	
	/* **** Variables locales  **** */
	
	var urlAllTasks = "/to-do-list/rest/tareas/buscarTodas";
	
	
	
	/* ***** Funciones publicas ***** */

	module.rest.getTasks = function(callback) {
		$.ajax({
		  url: urlAllTasks,
		  type: 'get',
		  // data: parametros
		  dataType: 'json',
		  error: function(textStatus) {
			  // alert(textStatus);
		  },
		  success: function(data){ callback(data); }
		});
	};
	
	
	return module;
	
})(App || {});
