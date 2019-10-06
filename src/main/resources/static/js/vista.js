class Vista{
	constructor(canvas){
		this.buffer = document.createElement("canvas").getContext("2d");
		this.context = canvas.getContext("2d");
			
			
			this.dibujarJugador = function(x,y,ancho,alto){
				this.buffer.fillRect(Math.floor(x),Math.floor(y),ancho,alto);
			}
			this.renderizar=function(){
				this.context.drawImage(this.buffer.canvas, 0, 0, this.buffer.canvas.width, this.buffer.canvas.height, 0, 0, this.context.canvas.width, this.context.canvas.height);

			}
	}
}