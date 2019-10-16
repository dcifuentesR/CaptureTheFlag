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
	
	
