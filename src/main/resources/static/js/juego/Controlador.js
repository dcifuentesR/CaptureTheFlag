class Controlador {
	
	constructor(){
		this.izq = new EntradaTeclado();
		this.der =new EntradaTeclado();
		this.arriba=new EntradaTeclado();
		this.estadoTecla = function(tipo,tecla) {
			var presionada = (tipo == "keydown") ? true :false;
			switch(tecla){
			case "d": this.der.getEntrada(presionada); break;
			case "a": this.izq.getEntrada(presionada); break;
			case "w": this.arriba.getEntrada(presionada);
			}
		}

		this.disparar = function(event,callback){
			var canvas = document.getElementById("canvas")
			var context = canvas.getContext("2d");
			var offsetleft = parseInt(getOffset(canvas).left, 10);
			var offsettop = parseInt(getOffset(canvas).top, 10);
			var rect = canvas.getBoundingClientRect();
		 	var x =(event.clientX - rect.left) / (rect.right - rect.left) * canvas.width;
			var y =(event.clientY - rect.top) / (rect.bottom - rect.top) * canvas.height
			//var x = event.pageX - canvas.getBoundingClientRect().left + 8;
			//var y = event.pageY - canvas.getBoundingClientRect().top + 8;
			//console.log("window" + window.scrollY);
			console.log("canvas " + x,y);
			callback(x,y);
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