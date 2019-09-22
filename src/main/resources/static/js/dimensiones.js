var dimiensiones = {
  ancho:
    window.innerWidth ||
    document.documentElement.clientWidth ||
    document.body.clientWidth,
  alto:
    window.innerHeight ||
    document.documentElement.clientHeight ||
    document.body.clientHeight,
  ladoTildes: 100,
  escala: 1,
  iniciar: function() {
    window.addEventListener("resize", function(evento) {
      dimiensiones.ancho =
        window.innerWidth ||
        document.documentElement.clientWidth ||
        document.body.clientWidth;
      dimiensiones.alto =
        window.innerHeight ||
        document.documentElement.clientHeight ||
        document.body.clientHeight;
      inicio.recargarTiles();
    });
  },
  obtenerTilesHorizontales: function() {
    var ladoFinal = dimiensiones.ladoTildes * dimiensiones.escala;
    return Math.ceil((dimiensiones.ancho - ladoFinal) / ladoFinal);
  },
  obtenerTilesVerticales: function() {
    var ladoFinal = dimiensiones.ladoTildes * dimiensiones.escala;
    return Math.ceil((dimiensiones.alto - ladoFinal) / ladoFinal);
  },
  obtenerTotalTildes: function() {
    return (
      dimiensiones.obtenerTilesHorizontales() *
      dimiensiones.obtenerTilesVerticales()
    );
  }
};
