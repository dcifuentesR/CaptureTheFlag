window.addEventListener("load",function(event){
	
	
	var estadoTecla=function(event){
		controlador.estadoTecla(event.type,event.key);
	}
	
	var redimensionar = function(event){
		vista.redimensionar(document.documentElement.clientWidth - 32, document.documentElement.clientHeight - 32,mapa.alto/mapa.ancho);
		vista.renderizar();
	}
	
	var renderizar = function(event){
		vista.llenarCanvas(mapa.colorFondo);
		vista.dibujarJugador(mapa.jugador.x,mapa.jugador.y,mapa.jugador.ancho,mapa.jugador.alto,mapa.jugador.color);
		vista.renderizar();
	}
	
	var refrescar = function(){
		if(controlador.izq.activa){ mapa.jugador.moverseIzq();}
		if(controlador.der.activa){ mapa.jugador.moverseDer();}
		if(controlador.arriba.activa){mapa.jugador.saltar(); controlador.arriba.activa =false;}
		
		mapa.refrescar();
	}
	
	var controlador = new Controlador();
	var vista = new Vista(document.querySelector("canvas"));
	var mapa = new Mapa();
	var motor = new Motor(1000/30,renderizar,refrescar);
	
	vista.buffer.canvas.width = mapa.ancho;
	vista.buffer.canvas.height = mapa.alto;
	
	vista.tileSheet.imagen.addEventListener("load",function(event){
		redimensionar();
		
		motor.start();
	},{once:true});
	
	vista.tileSheet.imagen.src = "js/juego/tileset.png";
	
	window.addEventListener("keydown",estadoTecla);
	window.addEventListener("keyup",estadoTecla);
	window.addEventListener("resize",redimensionar);
	
	redimensionar();
	
	motor.start();
	
});