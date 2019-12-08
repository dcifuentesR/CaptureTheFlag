const apiUri = "capturetheflag-arsw.herokuapp.com/";
apiClient = (function() {
  return {
    saveCuenta: function(cuenta) {
      //console.log(cuenta);
      $.ajax({
        url: "cuentas/",
        type: "post",
        data: cuenta,
        contentType: "application/json",
        success: function() {
          location.href = "/index.html";
        },
        error: function(XMLHttpRequest) {
          alert("Error al registrar nick o correo ya registrados");
        }
      });
    },

    savePartida: function(partida) {
      //console.log(cuenta);
      $.ajax({
        url: "partidas/",
        type: "post",
        data: partida,
        contentType: "application/json"
      });
    },

    saveJugar: function(jugar, nick) {
      console.log("jugar " + jugar);
      $.ajax({
        url: "cuentas/" + nick + "/partidas",
        type: "post",
        data: jugar,
        contentType: "application/json",
        success: function() {
          location.href = "/home.html";
        },
        error: function() {
          alert("Problemas con el servidor, la partida no pudo ser guardada");
          location.href = "/home.html";
        }
      });
    },

    getPartida: function(nombre, fecha, callback, dato, posicion) {
      console.log("fecha: " + fecha + "nombre: " + nombre);
      $.ajax({
        url: "partidas/" + fecha + "/" + nombre,
        success: function(result) {
          console.log("partidaaaa " + result);
          callback(result, dato, posicion);
        }
      });
    },

    getJugador: function(nick, dato, posicion, sala, callback) {
      $.ajax({
        url: "cuentas/" + nick,
        success: function(result) {
          console.log("jugador " + result);
          callback(result, dato, posicion, sala);
        }
      });
    },

    getPartidasUser: function(nick, callback) {
      $.ajax({
        url: "cuentas/" + nick + "/partidas",
        success: function(result) {
          callback(result);
        },
        error: function() {
          alert("Error al consultar el perfil intente mas tarde");
        }
      });
    },

    checkPassword: function(nick, callback) {
      jQuery.ajax({
        url: "cuentas/" + nick,
        success: function(result) {
          //console.log(result);
          callback(result);
        },
        async: true
      });
    }
  };
})();
