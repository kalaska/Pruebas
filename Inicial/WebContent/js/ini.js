/**
 * 
 */
$( document ).ready(function() {
    $( "a" ).click(function( event ) {
        alert( "Porras" );
        event.preventDefault();
    });
});

var frm=$( "#idFormulario" ); //Identificamos el formulario por su id
        var datos = frm.serialize();  //Serializamos sus datos

        //Preparamos la petición Ajax
        var request = $.ajax({
            url: frm.prop("action"),    //Leerá la url en la etiqueta action del formulario (archivo.php)
            method: frm.prop('method'), //Leerá el método en etiqueta method del formulario
            data: datos,                //Variable serializada más arriba 
            dataType: "json"            //puede ser de otro tipo
        });

        //Este bloque se ejecutará si no hay error en la petición
        request.done(function(respuesta) {
            console.log(respuesta);
            console.log(respuesta.foo); //foo es una propiedad (clave), del json que devuelve el servidor
            //Tratamos a respuesta según sea el tipo  y la estructura               
        });

        //Este bloque se ejecuta si hay un error
        request.fail(function(jqXHR, textStatus) {
            alert("Hubo un error: " + textStatus);
        });