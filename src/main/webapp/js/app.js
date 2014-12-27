
(function(){
	var app = angular.module('AppToDo', []);
	
	app.controller('TasksController', function(){
		this.tareas = tasks;
	});
	
	app.controller('FormController', function(){
		this.tarea = {};
		
		var initTask = function() {
			this.tarea = {};
			this.tarea.realizada = false;
		};
		
		initTask();
		
		this.addTask = function() {
			this.tarea.fecha = new Date().getTime();
			tasks.push(this.tarea);
			
			this.tarea = {};
			initTask();
		};
	});
	
	
	var tasks = []; 
//		[
//			{
//				id: 1,
//				descripcion: '',
//				fecha: '',
//				realizada: false
//			}
//		];
	
})();
