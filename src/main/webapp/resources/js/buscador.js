$( document ).ready(function() {
	$("select#sujeto").change(cargarOpciones);
	$(".alert").alert()
	$(".eliminar").click(function(){
		var entry = $(this).parent();
		$.post( entry.attr("data-page") +"/delete", { id: entry.find("input").val() })
		  .done(function(data) {
			  if (!data.error){
				  entry.parent().parent().remove();  
			  }else{
				  $('#myModal').modal('show');
				  $('#myModal').find('.modal-body').html(data.error);
			  }
		  });
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
