class Mapa{
	constructor(){
		this.colorFondo = "#000000"
		this.ancho = 500;
		this.alto =500;
		this.friccion=0.9;
		this.gravedad=3;
		
		this.jugador = new Mapa.Jugador(50,50,20);
	}
	manejarColisiones(jugador){
		if(jugador.x<0){
			jugador.x =0;
			jugador.velX=0;
		}else if(jugador.x+jugador.ancho > this.ancho){
			jugador.x =this.ancho - jugador.ancho;
			jugador.velX = 0;
		}
		if(jugador.y < 0){
			jugador.y=0;
			jugador.velY=0;
		}else if(jugador.y +jugador.alto > this.alto){
			jugador.saltando = false;
			jugador.y = this.alto - jugador.alto;
			jugador.velY=0;
		}
	}
	
	refrescar(){
		this.jugador.velY += this.gravedad;

		this.manejarColisiones(this.jugador);
		this.jugador.velX *= this.friccion;
		this.jugador.velY *= this.friccion;

		this.jugador.refrescar();
	}
	
}

Mapa.Jugador = class {
	constructor(x,y,vida){
		this.color = "#ff0000";
		this.ancho=16;
		this.alto=16;
		 this.velX=0;
		 this.velY=0;
		 this.saltando = false;
		 
		 this.x=x;
		 this.y=y;
		 this.vida=vida;
	}
	
	moverseIzq(){
		this.velX-=0.5;
	}
	
	moverseDer(){
		this.velX+=0.5;
	}
	
	saltar(){
		if(!this.saltando){
			this.saltando = true;
			this.velY -= 20;
		}
	}
	refrescar(){
		this.x += this.velX;
		this.y += this.velY;
	}
	
}