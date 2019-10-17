class Vista{
	constructor(canvas){
		this.buffer = document.createElement("canvas").getContext("2d");
		this.context = canvas.getContext("2d");
		
		//--- toca cambiar parametros si se quieren mas tilesheets
		this.tileSheet = new Vista.TileSheet(16,6,10);
		var test =[];
		this.dibujarMapa = function(mapa, columnas){
			for(let i = 0; i<mapa.length; i++){
				let valCasilla = mapa[i];
				
				let sourceX = Math.floor(valCasilla / 1)*this.tileSheet.tamanioCasilla;
				let sourceY = ((valCasilla % 1)*10)*this.tileSheet.tamanioCasilla;
				
				let destinationX = (i % columnas) * this.tileSheet.tamanioCasilla;
				let destinationY = Math.floor(i / columnas) * this.tileSheet.tamanioCasilla;
				
				this.buffer.drawImage(this.tileSheet.imagen,sourceX,sourceY, this.tileSheet.tamanioCasilla,this.tileSheet.tamanioCasilla,destinationX,destinationY,this.tileSheet.tamanioCasilla,this.tileSheet.tamanioCasilla);
			}
		};
			this.dibujarJugador = function(x,y,ancho,alto,color){
				this.buffer.fillStyle = color;
				this.buffer.fillRect(Math.floor(x),Math.floor(y),ancho,alto);
			};
			this.llenarCanvas = function(color){
				this.buffer.fillStyle = color;
				this.buffer.fillRect(0,0,this.buffer.canvas.width,this.buffer.canvas.height);
			};
			this.renderizar=function(){
				this.context.drawImage(this.buffer.canvas, 0, 0, this.buffer.canvas.width, this.buffer.canvas.height, 0, 0, this.context.canvas.width, this.context.canvas.height);

			};
			this.redimensionar = function(ancho,alto,razonAltoAncho){
				
				if(alto/ancho > razonAltoAncho){
					this.context.canvas.height = ancho * razonAltoAncho;
					this.context.canvas.width = ancho;
				}else{
					this.context.canvas.height = alto;
					this.context.canvas.width = alto/razonAltoAncho;
				}
				
				this.context.imageSmoothingEnabled = false;
				
			};
	}
	
};

Vista.TileSheet = class {
	
	constructor(tamanioCasilla,columnas,filas){
		this.imagen = new Image();
		this.tamanioCasilla = tamanioCasilla;
		this.columnas = columnas;
		this.filas = filas;
	}
};