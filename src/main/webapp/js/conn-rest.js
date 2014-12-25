/**
 * Módulo javascript para la conexión con servicios REST.
 */

var App = (function (module) {
	
	module.rest = module.rest || {};
	
	/* **** Variables locales  **** */
	
	var urlAllTasks = "/to-do-list/rest/tareas/buscarTodas";
	var urlSaveTask = "/to-do-list/rest/tareas/guardar";
	var urlFinishTask = "/to-do-list/rest/tareas/marcarComoRealizada";
	
	
	/* ***** Funciones publicas ***** */

	module.rest.getTasks = function(callback) {
		$.ajax({
		  url: urlAllTasks,
		  type: 'get',
		  dataType: 'json',
		  error: function(textStatus) {
			  alert(textStatus);
		  },
		  success: function(data){ callback(data); }
		});
	};
	
	module.rest.addTask = function(descripcion, callback) {
		if(typeof(descripcion) != "undefined") {
			var param = {};
			param.descripcion = descripcion;
			
			$.ajax({
			  url: urlSaveTask,
			  type: 'get',
			  data: param,
			  dataType: 'json',
			  error: function(textStatus) {
				  alert(textStatus);
			  },
			  success: function(tarea){ callback(tarea); }
			});
		}
	};
	
	module.rest.finishTask = function(id, callback) {
		if(typeof(id) != "undefined") {
			var param = {};
			param.id = id;
			
			$.ajax({
			  url: urlFinishTask,
			  type: 'get',
			  data: param,
			  dataType: 'json',
			  error: function(textStatus) {
				  alert(textStatus);
			  },
			  success: function(tarea){ callback(tarea); }
			});
		}
	};
	
	return module;
	
})(App || {});
