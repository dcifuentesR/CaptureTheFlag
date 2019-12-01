var appModule = (function() {
  var nick;
  var checkPassword = function() {
    var nick = $("#nick").val();
    apiClient.checkPassword(nick, _check);
  };

  var addAcount = function() {
    var correo = $("#email").val();
    var nick = $("#nick").val();
    var password = $("#password").val();
    var cuenta = { correo: correo, contrasena: password, nick: nick };
    apiClient.saveCuenta(JSON.stringify(cuenta));
    location.href = "/index.html";
  };

  var addPartida = function(sala) {
    var date = sala.fecha;
    var nombre = verificationModule.readCookie("sala");
    var partida = { fecha: date, nombre: nombre };
    apiClient.savePartida(JSON.stringify(partida));
  };

  var addJugar = function(kills, muertes, posicion, puntos) {
    var partida = _getPartida(
      verificationModule.readCookie("sala"),
      verificationModule.readCookie("fechaSala")
    );
    var jugador = _getJugador(verificationModule.readCookie("nickname"));
    var jugar = {
      cuenta: {
        id: jugador.id,
        correo: jugador.correo,
        contrasena: jugador.contrasena,
        nick: jugador.nick
      },
      partida: { id: partida.id, fecha: partida.fecha, nombre: partida.nombre },
      kills: kills,
      muertes: muertes,
      posicion: posicion,
      puntos: puntos
    };
    apiClient.saveJugar(JSON.stringify(jugar), jugador.nick);
  };

  var _getPartida = function(nombre, fecha) {
    var partida = apiClient.getPartida(nombre, fecha);
    return partida;
  };

  var _getJugador = function(nick) {
    var jugador = apiClient.getJugador(nick);
    return jugador;
  };

  var _check = function(cuenta) {
    var password = $("#password").val();
    if (cuenta.contrasena === password) {
      nick = $("#nick").val();
      location.href = "/home.html";
      //console.log("appmodule " + nick);
      verificationModule.crear_cookie_sesion(nick);
    } else {
      alert("Incorrect password");
    }
  };

  return {
    checkPassword: checkPassword,
    addAcount: addAcount,
    addPartida: addPartida,
    addJugar: addJugar
  };
})();

