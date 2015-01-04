
(function(){
	var app = angular.module('AppToDo', []);
	
	app.controller('TasksController', ['$http', function($http){
		
		var tareas = this;
		tareas.tareas = [];
		
		$http.get('/to-do-list/rest/tareas/buscarTodas').success(function(data) {
			tareas.tareas = data;
			allTasks = tareas.tareas;
			
		}).error(function(error) {
			alert(error);
		});
	}]);
	
	app.controller('FormController', function(){
		this.tarea = {};
		
		var initTask = function() {
			this.tarea = {};
			this.tarea.realizado = false;
		};
		
		initTask();
		
		this.addTask = function() {
			this.tarea.fecha = new Date().getTime();
			allTasks.unshift(this.tarea);
			
			this.tarea = {};
			initTask();
		};
	});
	
	
	var allTasks = [];
	
})();
