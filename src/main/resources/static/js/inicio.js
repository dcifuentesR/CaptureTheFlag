document.addEventListener(
  "DOMContentLoaded",
  function() {
    inicio.iniciarJuego();
  },
  false
);

var inicio = {
  iniciarJuego: function() {
    console.log("Juego iniciado");
    ajax.cargarArchivo("mapas/prueba.json");
    teclado.iniciar();
    dimiensiones.iniciar();
    inicio.recargarTiles();
    bublePrincipal.iterar();
  },
  recargarTiles: function() {
    document.getElementById("juego").innerHTML = "";
    for (var y = 0; y < dimiensiones.obtenerTilesVerticales(); y++) {
      for (var x = 0; x < dimiensiones.obtenerTilesHorizontales(); x++) {
        var r = new Rectangulo(
          x * +dimiensiones.ladoTildes,
          y * dimiensiones.ladoTildes,
          dimiensiones.ladoTildes,
          dimiensiones.ladoTildes
        );
      }
    }
  }
};
