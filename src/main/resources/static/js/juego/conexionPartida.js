var partidaModulo = (function() {
  var stompClient = null;
  var _nameSala = null;
  var _nick = null;
  var conexion = false;
  var theObject = undefined;
  var theBalaObjects = undefined;
  var theBanderaObjects = undefined;

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
      //console.log("Connected: " + frame);
      stompClient.subscribe("/topic/salaDatos." + _nameSala, function(
        eventbody
      ) {
        //console.log(eventbody);
        theObject = JSON.parse(eventbody.body);
        //metodos
        //pintarInfoJuego(theObject);
      });

      stompClient.subscribe("/topic/salaBalas." + _nameSala, function(
        eventbody
      ) {
        //console.log(eventbody);
        //metodos
        theBalaObjects = JSON.parse(eventbody.body);
      });

      stompClient.subscribe("/topic/salaBandera." + _nameSala, function(
        eventbody
      ) {
        //console.log(eventbody);
        //metodos
        theBanderaObjects = JSON.parse(eventbody.body);
      });

      conexion = true;
    });
  };

  return {
    //conexion
    init: function() {
      partidaModulo.disconnect();
      //console.log("sala " + _nameSala);
      _nameSala = verificationModule.readCookie("sala");
      _nick = verificationModule.readCookie("nickname");
      //_subscribe = "/topic/salaDatos.";
      connectAndSubscribe();
      main.init();
    },
    disconnect: function() {
      conexion = false;
      if (stompClient !== null) {
        stompClient.disconnect();
      }
      //console.log("Disconnected");
    },
    //-------------------jugador
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
    moverBandera:function(x,y){
    	if(conexion !=false) {
    		stompClient.send(
    			"/app/movimientoBandera."+_nameSala,
    			{},
    			_nick +";"+x+";"+y
    		
    		);
    	}
    },
    getJugadores: function(callback) {
      if (conexion != false) {
        stompClient.send("/app/salaDatos." + _nameSala, {}, " ");
      }
      if (theObject !== undefined) callback(theObject);
    },

    setVidaPJ: function(vida) {
      var valores = _nick + ";" + vida;
      stompClient.send("/app/vidaPj." + _nameSala, {}, valores);
    },

    addPuntos: function(punto) {
      var valores = _nick + ";" + punto;
      stompClient.send("/app/addPuntosPj." + _nameSala, {}, valores);
    },
    //-------------------bala
    crearDisparo: function(id, poder, x, y, dano) {
      var key = _nick + "," + id;
      _crearBala(key, poder, x, y, dano);
    },
    getBalas: function(callback) {
      if (conexion != false) {
        stompClient.send("/app/salaBalas." + _nameSala, {}, " ");
      }
      if (theBalaObjects !== undefined) callback(theBalaObjects);
    },
    moverBala: function(id, x, y) {
      var valores = _nick + id + ";" + x + ";" + y;
      stompClient.send("/app/movimientoBalas." + _nameSala, {}, valores);
    },
    colisionBala: function(id) {
      var key = _nick + id;
      stompClient.send("/app/colisionBala." + _nameSala, {}, key);
    },
    //-------------------bandera
    cogerBandera: function() {
      stompClient.send("/app/cogerBandera." + _nameSala, {}, _nick);
    },
    getBandera: function(callback) {
      if (conexion != false) {
        stompClient.send("/app/salaBandera." + _nameSala, {}, " ");
      }
      if (theBanderaObjects !== undefined) callback(theBanderaObjects);
    }
  };
})();
