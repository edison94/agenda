$( document ).ready(function() {
	$("select#sujeto").change(cargarOpciones);
});

$(function() {
	$('.datepicker').datepicker({
	    format: 'dd/mm/yyyy',
	    todayBtn: "linked",
	    language: "es"
	});
});

function cargarOpciones() { 
	var op = $(this).val() == "empleado"?0:1;
	  var ops = opciones[op];
	  var select = $("select#criterio");
	  select.find("option").remove();
	  ops.forEach(function(item){
		  $("<option>").val(item).html(item).appendTo(select);
	  });
	  
	  select.change(function(){
		  $.get('departamentos.json', function(responseJson) {
			  console.log("cambio");
              console.log(responseJson);
          });
	  });
}

var opciones = [
	["Categoría", "Departamento", "Dirección", "Nombre", "Teléfono"],
	["Dirección", "Nombre", "Teléfono"]
]
