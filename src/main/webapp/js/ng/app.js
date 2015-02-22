
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

		return $resource('/to-do-list/rest/tasks/:id', {id:'@id'}, 
			{
				update: { method:'PUT' }
			});

	});

	app.controller('TasksController', ['$scope', '$http', 'Tarea', 'ListaTareas', function($scope, $http, Tarea, ListaTareas) {

		$scope.verTareasRealizadas = true;

		Tarea.query(function(value) {
			ListaTareas.setTasks(value);
		});

		$scope.tasks = function() {
			return ListaTareas.getTasks();
		};

		$scope.marcarComoRealizada = function(tarea) {
			tarea.realizado = true;
			tarea.$update({id: tarea.id}, function() {
				
			}, function() {
				tarea.realizado = false;  // rollback
			} );
		};

	}]);

	app.controller('FormController',[ '$scope', 'Tarea', 'ListaTareas' ,function($scope, Tarea, ListaTareas){
		
		$scope.tarea = {};
		
		var initTask = function() {
			$scope.tarea = {};
			$scope.tarea.realizado = false;
		};
		
		initTask();
		
		$scope.addTask = function() {
			if(! (!!$scope.tarea.descripcion)) {
				console.log('Ingrese la descripcion de la tarea.');
				return;
			}
			var nTarea = new Tarea();

			nTarea.descripcion = $scope.tarea.descripcion;
			nTarea.fecha = new Date();
			nTarea.realizado = $scope.tarea.realizado;

			nTarea.$save(function(data) {
				ListaTareas.addTask(data);
				console.log(data);
				initTask();
			});
		};
	}]);
	
})();
