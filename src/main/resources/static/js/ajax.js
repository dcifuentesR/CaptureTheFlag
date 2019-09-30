var ajax = {
  cargarArchivo: function(ruta) {
    var peticion = new XMLHttpRequest();
    //evento, cada vez que cambie la peticion se notificara
    peticion.onreadystatechange = function() {
      /*
        0/ unset - no iniciada
        1/ opened - conectado al servidor
        2/ headers_recieved - peticion recibido
        3/ loading - procesando peticion
        4/ done - peticion ginalizada, respuesta preparada
      */
      if (peticion.readyState == XMLHttpRequest.DONE) {
        if (peticion.status == 200) {
          console.log(JSON.parse(peticion.responseText));
        } else if (peticion.status == 400) {
          console.log("error");
        } else {
          console.log("resultado inesperado");
        }
      }
    };

    peticion.open("GET", ruta, true);
    peticion.send();
  }
};
