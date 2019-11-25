var partidaModulo = (function() {
  var stompClient = null;
  var _nameSala = null;
  var _nick = null;
  var conexion = false;
  var theObject = undefined;
  var theBalaObjects = undefined;

  /*var pintarInfoJuego = function(JSONObject){
	  main.renderizar(JSONObject);
  };*/
  var _crearBala = function(key, poder, x, y, dano) {
    var valor = key + ";" + poder + ";" + x + ";" + y + ";" + dano;
    stompClient.send("/app/createBalas." + _nameSala, {}, valor);
  };

  var connectAndSubscribe = function() {
    console.info("Connecting to WS...");
    var socket = new SockJS("/stompendpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      console.log("Connected: " + frame);
      stompClient.subscribe("/topic/salaDatos." + _nameSala, function(
        eventbody
      ) {
        console.log(eventbody);
        theObject = JSON.parse(eventbody.body);
        //metodos
        //pintarInfoJuego(theObject);
      });

      stompClient.subscribe("/topic/salaBalas." + _nameSala, function(
        eventbody
      ) {
        console.log(eventbody);
        //metodos
        theBalaObjects = JSON.parse(eventbody.body);
      });

      conexion = true;
    });
  };

  return {
    init: function() {
      partidaModulo.disconnect();
      //console.log("sala " + _nameSala);
      _nameSala = verificationModule.readCookie("sala");
      _nick = verificationModule.readCookie("nickname");
      //_subscribe = "/topic/salaDatos.";
      connectAndSubscribe();
      main.init();
    },
    mover: function(x, y) {
      if (conexion != false) {
        // console.log("mover x" + x + " y " + y);
        stompClient.send(
          "/app/salaMovimiento." + _nameSala,
          {},
          _nick + ";" + x + ";" + y
        );
      }
    },
    getJugadores: function(callback) {
      if (conexion != false) {
        stompClient.send("/app/salaDatos." + _nameSala, {}, " ");
      }
      if (theObject !== undefined) callback(theObject);
    },
    crearDisparo: function(id, poder, x, y, dano) {
      var key = _nick + id;
      _crearBala(key, poder, x, y, dano);
    },
    getBalas: function(callback) {
      if (conexion != false) {
        stompClient.send("/app/salaBalas." + _nameSala, {}, " ");
      }
      if (theBalaObjects !== undefined) callback(theObject);
    },
    cogerBandera: function() {
      stompClient.send("/app/salaBandera." + _nameSala, {}, _nick);
    },
    disconnect: function() {
      conexion = false;
      if (stompClient !== null) {
        stompClient.disconnect();
      }
      console.log("Disconnected");
    }
  };
})();
