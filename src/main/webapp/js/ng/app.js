
(function(){
	var app = angular.module('AppToDo', ['ngResource']);
	
	app.service('ListaTareas', function() {

		var tasks = [];

		this.setTasks = function(collection) {
			tasks = collection;
		};

		this.addTask = function(t) {
			tasks.unshift(t);
		};

		this.getTasks = function(){
			return tasks;
		};
	});

	app.factory('Tarea', function($resource) {

		return $resource('/to-do-list/rest/tasks/:id');

	});

	app.controller('TasksController', ['$scope', '$http', 'Tarea', 'ListaTareas', function($scope, $http, Tarea, ListaTareas){
		
$scope.hola ='Hola mundo';

		Tarea.query(function(value) {
			ListaTareas.setTasks(value);
		});

		$scope.tasks = function() {
			return ListaTareas.getTasks();
		};

	}]);

	app.controller('FormController',[ '$scope', 'Tarea', 'ListaTareas' ,function($scope, Tarea, ListaTareas){
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
	}]);
	
	
	var allTasks = [];
	
})();
