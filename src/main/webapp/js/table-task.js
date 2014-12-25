/**
 * Módulo para presentar las tareas en la vista.
 */

var App = (function (module) {
	
	module.table = module.table || {};
	
	/* Variables locales */
	
	var grid = null;		 // Almacena la referencia del elemento HTML que contiene el GRID
	
	var eventoChangeForCheckboxes = function(event){
		var tr = $(event.target).closest('tr');
	    var index = tr[0].id;
	    // var row = grid.jqGrid('getRowData', index);
	    
		App.rest.finishTask(index, function(tarea) {
			if(typeof(tarea) != 'undefined' && tarea != null) {
				$('#datos-grid tr[id="' + index +'"] input[type="checkbox"]').attr("disabled", true);
			}else {
				$('#datos-grid tr[id="' + index +'"] input[type="checkbox"]').attr("checked", false);
				alert("No se pudo marcar la tarea como realizada");
			}
		});
	};
	
	
	/* ** Funciones publicas (API del modulo) ** */
	
	module.table.init = function() {
		if(grid === null) {
			grid = $("#datos-grid");
		}
		grid.jqGrid({
			datatype: "local",
		   	colNames:['#','Descripción', 'Hora', 'Realizada'],
		   	colModel:[
		   		{name:'id',index:'id', width:50,hidden:true },
		   		{name:'descripcion',index:'descripcion', width:150 },
		   		{name:'fecha',index:'fecha', width:100 },
		   		{name:'realizado',index:'realizado', width:80, align: "center", 
		   			formatter: "checkbox", formatoptions: { disabled: false }, 
		   			edittype: "checkbox", editoptions: {value: "true:false", defaultValue:"true" } }
		   		
		   	],
		   	rownumbers: true,
		   	rowNum:10, 
		   	sortname: 'id',
		    sortorder: "asc",
		    loadComplete: function (data) {
		    	$('#datos-grid * input[type="checkbox"][checked="checked"]').attr("disabled", true);
		    	
		    	// Evento para marcar como realizada
		    	$('#datos-grid * input[type="checkbox"]').on('change', eventoChangeForCheckboxes);
		    }
		    // caption:"Lista de tareas"
			// pager: '#un-div-pager'
		});
		// grid.jqGrid('navGrid','#un-div-pager',{edit:false,add:false,del:false});
		
		grid.jqGrid('sortGrid', 'realizado', true, 'asc');
	};
	
	module.table.showData = function(datos) {
		if(typeof datos !== 'undefined' && datos != null) {
			grid.jqGrid('setGridParam', {data: datos}).trigger("reloadGrid");
		}
	};
	
	module.table.addRow = function(tarea) {
		if(typeof tarea !== 'undefined' && tarea != null) {
			grid.jqGrid("addRowData", tarea.id, tarea, "last");
			$('#datos-grid tr[id="' + tarea.id + '"] input[type="checkbox"]').on('change', eventoChangeForCheckboxes);
			$('#txtDescripcion').val('');
		}
	};
	
	return module;
	
})(App || {});

