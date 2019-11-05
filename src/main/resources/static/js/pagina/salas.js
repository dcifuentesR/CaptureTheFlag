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

  var _createSala = function(cuent) {
    console.log("_createSala");
    console.log("cuenta " + cuent + " asdsda " + cuent[0]);
    var cuenta = new Cuenta(
      cuent.id,
      cuent.correo,
      cuent.contrasena,
      cuent.nick
    );
    console.log(cuenta);
    stompClient.send(
      "/app/createsala." + _nameSala,
      {},
      JSON.stringify(cuenta)
    );
    location.href = "/sala.html";
  };

  var tablaSalas = function() {
    console.log("tablaSalas");
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
          "<a class='btn btn-primary' href='/juego.html'>Unirse</a>" +
          "</td>" +
          "</tr>"
      );
    });
  };

  var tablaParticipantes = function() {
    console.log("tablaParticipantes");
    $("#tabla-participantes").empty();
    _participantes.map(function(participante) {
      $("#tabla-participantes").append(
        "<tr>" + "<td>" + participante.nombre + "</td>" + "</tr>"
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
          tablaParticipantes();
        });
        stompClient.send("/app/sala." + _nameSala, {}, " ");
      } else {
        stompClient.subscribe(_subscribe, function(eventbody) {
          var theObject = JSON.parse(eventbody.body);
          //console.log(theObject);
          _salas = theObject;
          tablaSalas();
        });
        stompClient.send("/app/showsala", {}, " ");
      }
    });
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
    joinSala: function() {
      console.log("joinSalas");
      tablaParticipantes();
    },
    createSalas: function(nSala) {
      console.log("createSalas");
      _nameSala = nSala;
      document.cookie = "sala=" + encodeURIComponent(_nameSala);
      _nick = verificationModule.readCookie("nickname");
      apiClient.checkPassword(_nick, _createSala);
    },
    disconnect: function() {
      if (stompClient !== null) {
        stompClient.disconnect();
      }
      console.log("Disconnected");
    }
  };
})();
