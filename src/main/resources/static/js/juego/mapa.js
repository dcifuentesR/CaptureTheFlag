class Mapa{
	constructor(){
		this.collider= new Mapa.Collider();
		
		this.colorFondo = "#000000"
		this.ancho = 500;
		this.alto =500;
		this.friccion=0.9;
		this.gravedad=2.5;
		//---------------------por ahora aquí, luego desde un JSON ----------
		this.columnas = 31;
		this.filas = 31;
		this.tamanioCasilla = 16;
		this.map= [1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,4.5,4.5,4.5,4.5,4.5,4.5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,2.1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3];
		this.layer="world";
		
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
		
		var abajo,izquierda,derecha,arriba,valCasilla;
		//sup-izq
		arriba = Math.floor(jugador.getArriba() / this.tamanioCasilla);
		izquierda = Math.floor(jugador.getIzquierda() / this.tamanioCasilla);
		valCasilla = this.map[arriba * this.columnas + izquierda];
		this.collider.colisionar(valCasilla,jugador,izquierda*this.tamanioCasilla,arriba*this.tamanioCasilla,this.tamanioCasilla);
		//sup-der
		arriba = Math.floor(jugador.getArriba() / this.tamanioCasilla);
		derecha = Math.floor(jugador.getDerecha() / this.tamanioCasilla);
		valCasilla = this.map[arriba * this.columnas + derecha];
		this.collider.colisionar(valCasilla,jugador,derecha*this.tamanioCasilla,arriba*this.tamanioCasilla,this.tamanioCasilla);
		//inf-izq
		abajo = Math.floor(jugador.getAbajo() / this.tamanioCasilla);
		izquierda = Math.floor(jugador.getIzquierda() / this.tamanioCasilla);
		valCasilla = this.map[abajo * this.columnas + izquierda];
		this.collider.colisionar(valCasilla,jugador,izquierda*this.tamanioCasilla,abajo*this.tamanioCasilla,this.tamanioCasilla);
		//inf-der
		abajo = Math.floor(jugador.getAbajo() / this.tamanioCasilla);
		derecha = Math.floor(jugador.getDerecha() / this.tamanioCasilla);
		valCasilla = this.map[abajo * this.columnas + derecha];
		this.collider.colisionar(valCasilla,jugador,derecha*this.tamanioCasilla,abajo*this.tamanioCasilla,this.tamanioCasilla);
		
	}
	
	refrescar(){
		this.jugador.velY += this.gravedad;
		this.jugador.refrescar();
		
		this.jugador.velX *= this.friccion;
		this.jugador.velY *= this.friccion;

		this.manejarColisiones(this.jugador);
	}
	
}

Mapa.Jugador = class {
	constructor(x,y,vida){
		this.color = "#ff0000";
		this.ancho=16;
		this.alto=16;
		 this.velX=0;
		 this.velY=0;
		 this.saltando = true;
		 
		 this.x=x;
		 this.y=y;
		 this.xPrevFrame=x;
		 this.yPrevFrame=y;
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
		this.xPrevFrame=this.x;
		this.yPrevFrame=this.y;
		this.x += this.velX;
		this.y += this.velY;
	}
	
	/**
	 * estos getters/setters obtienen y asignan las posisiones de los extremos del jugador.
	 */
	getAbajo(){return this.y + this.alto;}
	getIzquierda(){return this.x;}
	getDerecha(){return this.x +this.ancho;}
	getArriba(){return this.y;}
	//se usan para asignar a la posicion del jugador las posiciones de los extremos de las plataformas al colisionar con estas
	setAbajo(y){this.y = y - this.alto;}
	setIzquierda(x){this.x=x;}
	setDerecha(x){this.x=x -this.ancho;}
	setArriba(y){this.y=y;}
	
	
	getPrevAbajo(){return this.yPrevFrame + this.alto;}
	getPrevIzquierda(){return this.xPrevFrame;}
	getPrevDerecha(){return this.xPrevFrame +this.ancho;}
	getPrevArriba(){return this.yPrevFrame;}
	//se usan para asignar a la posicion del jugador las posiciones de los extremos de las plataformas al colisionar con estas
	setPrevAbajo(y){this.yPrevFrame = y - this.alto;}
	setPrevIzquierda(x){this.xPrevFrame=x;}
	setPrevDerecha(x){this.xPrevFrame=x -this.ancho;}
	setPrevArriba(y){this.yPrevFrame=y;}
}

Mapa.Collider = class {
	
	constructor(){
		this.colisionar = function(posPlataforma,jugador,casillaX,casillaY,tamanioCasilla){
			if(posPlataforma!=-1)
				this.manejarColisionesPlataformaArriba(jugador,casillaY);
		}
	}
	
	manejarColisionesPlataformaAbajo(){
		
	}
	
	manejarColisionesPlataformaIzquierda(){
		
	}
	
	manejarColisionesPlataformaDerecha(){
		
	}

	manejarColisionesPlataformaArriba(jugador,arribaPlataforma){
		if(jugador.getAbajo() > arribaPlataforma && jugador.getPrevAbajo() <= arribaPlataforma){
			jugador.setAbajo(arribaPlataforma - 0.01);
			jugador.velY = 0;
			jugador.saltando = false;
		}
	
	}
	
}