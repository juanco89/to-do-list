/**
 * Módulo para presentar las tareas en la vista.
 */

var App = (function (module) {
	
	module.table = module.table || {};
	
	/* Variables locales */
	
	var grid = null;		 // Almacena la referencia del elemento HTML que contiene el GRID
	
	

	/* ** Funciones publicas (API del modulo) ** */
	
	module.table.init = function() {
		if(grid === null) {
			grid = $("#datos-grid");
		}
		grid.jqGrid({
			datatype: "local",
		   	colNames:['#','Descripción', 'Hora', 'Realizada'],
		   	colModel:[
		   		{name:'id',index:'id', width:50,hidden:true},
		   		{name:'descripcion',index:'descripcion', width:150},
		   		{name:'fecha',index:'fecha', width:100},
		   		{name:'realizado',index:'realizado', width:80, align:"right"}		
		   	],
		   	rownumbers: true,
		   	rowNum:10, 
		   	sortname: 'id',
		    sortorder: "asc",
		    // caption:"Lista de tareas"
			// pager: '#un-div-pager'
		});
		// grid.jqGrid('navGrid','#un-div-pager',{edit:false,add:false,del:false});
	};
	
	module.table.showData = function(datos) {
		if(typeof datos !== 'undefined' && datos != null) {
			grid.jqGrid('setGridParam', {data: datos}).trigger("reloadGrid");
		}
	};
	
	return module;
	
})(App || {});

