function CrearEquipo(equipo) {

    let equipo1={
        id: 1,
        name: equipo,
        vida: 200,
    }


    $.ajax({
        url: '/api/equipos/save',
        type:'POST',
        data:JSON.stringify(equipo1),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(data) {
            // Aquí procesamos los datos obtenidos
            console.log('Equipo guardado:', data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Aquí manejamos cualquier error que pueda haber ocurrido
            console.log(textStatus + ': ' + errorThrown);
        }
    });

    function getEquipos(){

        $.ajax({
            url: '/api/equipos/all',
            type:'GET',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function(data) {
                // Aquí procesamos los datos obtenidos
                console.log(data);

            },
            error: function(jqXHR, textStatus, errorThrown) {
                // Aquí manejamos cualquier error que pueda haber ocurrido
                console.log(textStatus + ': ' + errorThrown);
            }
        });
    }

}