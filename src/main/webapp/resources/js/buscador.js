$( document ).ready(function() {
	$("select#sujeto").on("load",cargarOpciones);
	$("select#sujeto").change(cargarOpciones);
});

function cargarOpciones() {
	  $.get('opciones', {sujeto: $(this).val()}, function(responseJson) {
		  var $select = $('#criterio');
        $select.find('option').remove();
        $.each(responseJson, function(key, value) {
            $('<option>').val(value).text(value).appendTo($select);
        });
        $select.change(function(event) {
      	  
        });
    });
}