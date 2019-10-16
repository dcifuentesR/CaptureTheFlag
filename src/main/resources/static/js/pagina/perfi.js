var perfilModule = (function() {
  var _nick;

  var _genTable = function(partidasJugadas) {
    $("#tabla-partidas-jugador > tbody").empty();
    partidasJugadas.map(function(partida) {
      $("#tabla-partidas-jugador > tbody").append(
        "<tr>" +
          "<td>" +
          partida.partida.id +
          "</td>" +
          "<td>" +
          partida.muertes +
          "</td>" +
          "<td>" +
          partida.kills +
          "</td>" +
          "<td>" +
          partida.tbandera +
          "</td>" +
          "<td>" +
          partida.partida.duracion +
          "</td>" +
          "</tr>"
      );
    });
  };

  var partidasJugadas = function() {
    _nick = verificationModule.readCookie("nickname");
    $("#portada-perfil > h1").text("Nick: " + _nick);
    apiClient.getPartidasUser(_nick, _genTable);
  };
  return {
    partidasJugadas: partidasJugadas
  };
})();
