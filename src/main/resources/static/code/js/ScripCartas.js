$('document').ready(function (){
    getCartas();
});
var datosP;

function getCartas(){

    $.ajax({
        url: '/api/cartas/all',
        type:'GET',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(data) {
            // Aquí procesamos los datos obtenidos
            console.log(data);
            paintCarta(data);
            datosP = data;

            //reduccionVida();

        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Aquí manejamos cualquier error que pueda haber ocurrido
            console.log(textStatus + ': ' + errorThrown);
        }
    });
}

function paintCarta(r){
    let d="";
    for(let i=0;i<r.length;i++) {
        d += `
          <h3>Memes</h3>
          <p>${r[0].descripcion}</p>
          <div class="link">
            <a href="#">Detalles</a>
          </div>
        `;
    }

    $('#parrilla').html(d);
}

function penitencia(){
    document.getElementById("botonsi").display = "none";

    let d="";
    for(let i=0;i<datosP.length;i++) {
        d += `
         <div class="otro">
                <div class="content-text">${datosP[0].penitencia}
                <div class="content-buttons"><a href="../templates/game_1v1.html" id="close-button">Aceptar</a></div>
            </div>
        `;
    }

    $('#window-notice').html(d);
    document.getElementById("vidaA").value = vidaA-10;

}


