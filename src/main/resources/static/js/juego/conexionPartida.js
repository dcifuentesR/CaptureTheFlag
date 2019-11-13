var partidaModulo = (function() {
  var stompClient = null;
  var _nameSala = null;
  var _nick = null;
  var conexion = false;
  
  var pintarInfoJuego = function(JSONObject){
	  main.renderizar(JSONObject);
  };

  var connectAndSubscribe = function() {
    console.info("Connecting to WS...");
    var socket = new SockJS("/stompendpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      console.log("Connected: " + frame);
      stompClient.subscribe(_subscribe + _nameSala, function(eventbody) {
        var theObject = JSON.parse(eventbody.body);
        //metodos
        pintarInfoJuego(theObject);
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
      _subscribe = "/topic/salaDatos.";
      connectAndSubscribe();
      main.init();
    },
    mover: function(x, y) {
      if (conexion != false) {
        console.log("mover x" + x + " y " + y);
        stompClient.send(
          "/app/salaMovimiento." + _nameSala,
          {},
          _nick + ";" + x + ";" + y
        );
      }
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
