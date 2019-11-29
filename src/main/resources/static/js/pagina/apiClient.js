const apiUri = "capturetheflag-arsw.herokuapp.com/";
apiClient = (function() {
  return {
    saveCuenta: function(cuenta) {
      //console.log(cuenta);
      $.ajax({
        url: "cuentas/",
        type: "post",
        data: cuenta,
        contentType: "application/json"
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

    saveJugar: function(jugar,nick) {
      //console.log(cuenta);
      $.ajax({
        url: "cuentas/" + nick + "/partidas",
        type: "post",
        data: jugar,
        contentType: "application/json"
      });
    },

    
    getPartida: function(nombre, fecha) {
      $.ajax({
        url: "cuentas/" + fecha + "/" + nombre,
        success: function(result) {
          //console.log(result);
          return result;
        }
      });
    },

    getJugador: function(nick) {
      $.ajax({
        url: "cuentas/" + nick,
        success: function(result) {
          //console.log(result);
          return result;
        }
      });
    },
    
    getPartidasUser: function(nick, callback) {
      $.ajax({
        url: "cuentas/" + nick + "/partidas",
        success: function(result) {
          //console.log(result);
          callback(result);
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
