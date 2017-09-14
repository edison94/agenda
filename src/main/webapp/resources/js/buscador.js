$( document ).ready(function() {
	$('.datepicker').datepicker({
	    format: 'dd/mm/yyyy',
	    todayBtn: "linked",
	    language: "es"
	});
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
	  Object.keys(ops).forEach(function(item){
		  console.log(item);
		  $("<option>").val(item).html(ops[item]).appendTo(select);
	  });
}

var persona = {"direccion": "Dirección", "nombre": "Nombre", "telefono": "Teléfono"};
var empleado = {"categoria": "Categoría", "departamento": "Departamento","direccion": "Dirección", "nombre": "Nombre", "telefono": "Teléfono"};
var opciones = [empleado,persona];