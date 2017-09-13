$( document ).ready(function() {
	$("select#sujeto").change(cargarOpciones);
});

function cargarOpciones() { 
	var op = $(this).val() == "empleado"?0:1;
	  var ops = opciones[op];
	  $("select#criterio").find("option").remove();
	  ops.forEach(function(item){
		  $("<option>").val(item).html(item).appendTo($("select#criterio"));
	  });
}

var opciones = [
	["Categoría", "Departamento", "Dirección", "Nombre", "Teléfono"],
	["Dirección", "Nombre", "Teléfono"]
]
