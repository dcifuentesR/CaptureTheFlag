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

  var addPartida = function() {
    var fecha =  "get fecha del stomp";
    var nombre = verificationModule.readCookie("sala");
    var partida = { fecha: fecha, nombre: nombre };
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

var verificationModule = (function() {
  var crear_cookie_sesion = function(usuario) {
    document.cookie = "nickname=" + encodeURIComponent(usuario);
    document.cookie = "sala=";
    var ca = document.cookie.split(";");
    //console.log("cookie inicial");
    //console.log(ca);
  };

  var readCookie = function(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(";");
    //console.log("cookie");
    //console.log(ca);
    for (var i = 0; i < ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == " ") c = c.substring(1, c.length);
      if (c.indexOf(nameEQ) == 0) {
        return decodeURIComponent(c.substring(nameEQ.length, c.length));
      }
    }
    return null;
  };

  var check_cookie = function() {
    //console.log(document.cookie)
    var user = readCookie("nickname");
    if (user == null) {
      alert("Permiso denegado, debe logearse primero.");
      location.href = "/index.html";
    }
  };

  var borrar_cookie = function() {
    document.cookie = "nickname=; expires=Thu, 01 Jan 1970 00:00:01 GMT;";
  };

  return {
    crear_cookie_sesion: crear_cookie_sesion,
    check_cookie: check_cookie,
    borrar_cookie: borrar_cookie,
    readCookie: readCookie
  };
})();
