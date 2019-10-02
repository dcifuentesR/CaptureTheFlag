var juego = (function(){
	
	class Jugador{
		constructor(x,y,vida){
			 this.velX=0;
			 this.velY=0;
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
		refrescar(){
			this.x+=this.velX;
		}
		
	};
	
	return {
		init:function(){
			jugador = new Jugador(100,50,100);
			
		}
	}
	
})();