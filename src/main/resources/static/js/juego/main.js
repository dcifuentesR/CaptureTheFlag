var main = (function(){
	
	var estadoTecla=function(){
		controlador.estadoTecla(event.type,event.key);
	}
	
	var redimensionar = function(){
		vista.redimensionar(document.documentElement.clientWidth - 32, document.documentElement.clientHeight - 32,mapa.alto/mapa.ancho);
		vista.renderizar();
	}
	
	var renderizar = function(/*estadoJuego*/){
		vista.llenarCanvas(mapa.colorFondo);
		vista.dibujarMapa(mapa.map,mapa.columnas);
//		estadoJuego.forEach(function(elementoActual){
//			vista.dibujarJugador(elementoActual["x"],elementoActual["y"],16,16,"#4287f5");
//		});
		vista.dibujarJugador(mapa.jugador.x,mapa.jugador.y,mapa.jugador.ancho,mapa.jugador.alto,mapa.jugador.color);
		vista.dibujarJugador(mapa.bandera.x,mapa.bandera.y,mapa.bandera.ancho,mapa.bandera.alto,"#4287f5");
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
	
	return {
		init:function(){
			
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
			console.log(vista);
			redimensionar();
			
			motor.start();
		}
	}
	
})();