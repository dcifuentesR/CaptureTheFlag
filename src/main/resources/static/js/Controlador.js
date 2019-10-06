class Controlador {
	
	constructor(){
		this.izq = new EntradaTeclado();
		this.der =new EntradaTeclado();
		this.arriba=new EntradaTeclado();
		
		this.estadoTecla = function(tipo,tecla) {
			var presionada = (tipo == "keydown") ? true :false;
			
			switch(tecla){
			case "keyD": this.der.getEntrada(presionada); break;
			case "keyA": this.izq.getEntrada(presionada);
			
			}
		}
	}
	
}	
	
Controlador.EntradaTeclado = class {
		constructor(){
			this.estaPresionada=false;
		}
		
		getEntrada(presionada){
			if(this.estaPresionada !=presionada)
				this.estaPresionada=presionada;
		}
	}
	
	
