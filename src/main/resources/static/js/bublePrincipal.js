var bublePrincipal = {
  idEjecucion: null,
  ultimoRegistro: 0,
  aps: 0,
  fps: 0,
  iterar: function(registroTemporal) {
    bublePrincipal.idEjecucion = window.requestAnimationFrame(
      bublePrincipal.iterar
    );
    bublePrincipal.actualizar(registroTemporal);
    bublePrincipal.dibujar(registroTemporal);

    if (registroTemporal - bublePrincipal.ultimoRegistro > 999) {
      bublePrincipal.ultimoRegistro = registroTemporal;
      console.log(
        "APS: " + bublePrincipal.aps + "| FPS: " + bublePrincipal.fps
      );
      bublePrincipal.aps = 0;
      bublePrincipal.fps = 0;
    }
  },
  detener: function() {},
  actualizar: function(registroTemporal) {
    teclado.reiniciar();
    bublePrincipal.aps++;
  },
  dibujar: function(registroTemporal) {
    bublePrincipal.fps++;
  }
};
