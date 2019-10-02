window.addEventListener("load",function(event){
	
	var estadoTecla=function(event){
		Controlador.estadoTecla(event.type,event.key);
	}
	
	var renderizar = function(event){
		
		vista.dibujarJugador(juego.Jugador.x,juego.Jugador.y,20,20);
		vista.renderizar();
	}
	
	var refrescar = function(){
		if(Controlador.izq.presionada){ juego.Jugador.moverseIzq();}
		if(Controlador.der.presionada){ juego.Jugador.moverseDer();}
		
		juego.refrescar();
	}
	
	var Controlador = new Controlador();
	var Vista = new Vista(document.querySelector("canvas"));
	var juego = new Juego();
	var motor = new Motor(1000/30,renderizar,refrescar);
	
	window.addEventListener("keydown",estadoTecla);
	window.addEventListener("keyup",estadoTecla);
	
})