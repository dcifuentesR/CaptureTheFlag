var salasModule = (function() {
  class Cuenta {
    constructor(id, correo, contrasena, nick) {
      this.correo = correo;
      this.contrasena = contrasena;
      this.nick = nick;
      this.id = id;
    }
  }

  var _nick;
  var stompClient = null;
  var _nameSala;
  var _subscribe;
  var _participantes;
  var _salas;

  var _createCuenta = function(cuent) {
    var cuenta = new Cuenta(
      cuent.id,
      cuent.correo,
      cuent.contrasena,
      cuent.nick
    );
    return cuenta;
  };

  var _joinSala = function(cuent) {
    console.log("_createSala");
    console.log("cuenta " + cuent + " asdsda " + cuent[0]);
    var cuenta = _createCuenta(cuent);
    console.log(cuenta);
    stompClient.send("/app/joinsala." + _nameSala, {}, JSON.stringify(cuenta));
    location.href = "/sala.html";
  };

  var _createSala = function(cuent) {
    console.log("_createSala");
    console.log("cuenta " + cuent + " asdsda " + cuent[0]);
    /*var cuenta = new Cuenta(
      cuent.id,
      cuent.correo,
      cuent.contrasena,
      cuent.nick
    );*/
    var cuenta = _createCuenta(cuent);
    console.log(cuenta);
    stompClient.send(
      "/app/createsala." + _nameSala,
      {},
      JSON.stringify(cuenta)
    );
    location.href = "/sala.html";
  };

  var _tablaSalas = function() {
    console.log("_tablaSalas");
    console.log(_salas);
    $("#tabla-salas > tbody").empty();
    _salas.map(function(sala) {
      $("#tabla-salas > tbody").append(
        "<tr>" +
          "<td>" +
          sala.nombre +
          "</td>" +
          "<td>" +
          Object.keys(sala.miembros).length +
          "</td>" +
          "<td>" +
          "<a class='btn btn-primary' onclick='salasModule.joinSala(\"" +
          sala.nombre +
          "\")' >Unirse</a>" +
          "</td>" +
          "</tr>"
      );
    });
  };

  var _tablaParticipantes = function(participantes) {
    console.log("_tablaParticipantes");
    $("#tabla-participantes > tbody").empty();
    participantes.map(function(participante) {
      $("#tabla-participantes > tbody").append(
        "<tr>" + "<td>" + participante.nick + "</td>" + "</tr>"
      );
    });
  };
  var connectAndSubscribe = function() {
    console.info("Connecting to WS...");
    var socket = new SockJS("/stompendpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      console.log("Connected: " + frame);
      if (_subscribe == "/topic/joinsala.") {
        stompClient.subscribe(_subscribe + _nameSala, function(eventbody) {
          var theObject = JSON.parse(eventbody.body);
          _participantes = theObject;
          _tablaParticipantes(_participantes);
        });
        if (_nameSala) {
          console.log(_nameSala);
          stompClient.send("/app/sala." + _nameSala, {}, " ");
        }
      } else {
        stompClient.subscribe(_subscribe, function(eventbody) {
          var theObject = JSON.parse(eventbody.body);
          //console.log(theObject);
          _salas = theObject;
          _tablaSalas();
        });
        stompClient.send("/app/showsala", {}, " ");
      }
    });
  };

  var _createOrJoinSala = function(nSala, funcion) {
    _nameSala = nSala;
    document.cookie = "sala=" + encodeURIComponent(_nameSala);
    _nick = verificationModule.readCookie("nickname");
    apiClient.checkPassword(_nick, funcion);
  };

  return {
    init: function(sub) {
      salasModule.disconnect();
      if (sub == 1) {
        _subscribe = "/topic/showsala";
        connectAndSubscribe();
        console.log("send");
        //salasModule.showSalas();
      } else {
        console.log("sala " + _nameSala);
        _nameSala = verificationModule.readCookie("sala");
        _subscribe = "/topic/joinsala.";
        connectAndSubscribe();
      }
    },
    joinSala: function(nSala) {
      console.log("joinSalas");
      _createOrJoinSala(nSala, _joinSala);
    },
    createSalas: function(nSala) {
      console.log("createSalas");
      _createOrJoinSala(nSala, _createSala);
    },
    disconnect: function() {
      if (stompClient !== null) {
        stompClient.disconnect();
      }
      console.log("Disconnected");
    }
  };
})();
