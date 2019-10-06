window.addEventListener("load",function(event){
	
	
	var estadoTecla=function(event){
		controlador.estadoTecla(event.type,event.key);
	}
	
	var renderizar = function(event){
		vista.llenarCanvas(mapa.colorFondo);
		vista.dibujarJugador(mapa.jugador.x,mapa.jugador.y,mapa.jugador.ancho,mapa.jugador.alto,mapa.jugador.color);
		vista.renderizar();
	}
	
	var refrescar = function(){
		if(controlador.izq.activa){ mapa.Jugador.moverseIzq();}
		if(controlador.der.activa){ mapa.Jugador.moverseDer();}
		if(controlador.arriba.activa){mapa.Jugador.saltar(); Controlador.arriba.activa =false;}
		
		mapa.refrescar();
	}
	
	var controlador = new Controlador();
	var vista = new Vista(document.querySelector("canvas"));
	var mapa = new Mapa();
	var motor = new Motor(1000/30,renderizar,refrescar);
	
	vista.buffer.canvas.ancho = mapa.ancho;
	vista.buffer.canvas.height = mapa.alto;
	window.addEventListener("keydown",estadoTecla);
	window.addEventListener("keyup",estadoTecla);
	
	motor.start();
	
});