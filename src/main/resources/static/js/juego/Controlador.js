class Controlador {
	
	constructor(){
		this.izq = new EntradaTeclado();
		this.der =new EntradaTeclado();
		this.arriba=new EntradaTeclado();
		this.x = 0;
		this.y =
		this.estadoTecla = function(tipo,tecla) {
			var presionada = (tipo == "keydown") ? true :false;
			switch(tecla){
			case "d": this.der.getEntrada(presionada); break;
			case "a": this.izq.getEntrada(presionada); break;
			case "w": this.arriba.getEntrada(presionada);
			}
		}

		this.disparo = function(event){
			var canvas = document.getElementById("myCanvas"),
			context = canvas.getContext("2d");
			var offsetleft = parseInt(getOffset(canvas).left, 10);
			var offsettop = parseInt(getOffset(canvas).top, 10);
			var x = event.pageX - offsetleft;
			var y = event.pageY - offsettop;
		}

		var getOffset = function (obj) {
			var offsetLeft = 0;
			var offsetTop = 0;
			do {
				if (!isNaN(obj.offsetLeft)) {
					offsetLeft += obj.offsetLeft;
				}
				if (!isNaN(obj.offsetTop)) {
					offsetTop += obj.offsetTop;
				}
			} while (obj = obj.offsetParent);
			return { left: offsetLeft, top: offsetTop };
		};

	}
}	
	
class EntradaTeclado {
		constructor(){
			this.activa = this.estaPresionada = false;
		}
		
		getEntrada(presionada){
			if(this.estaPresionada !=presionada) this.activa = presionada;
				this.estaPresionada=presionada;
		}
}
	
	
