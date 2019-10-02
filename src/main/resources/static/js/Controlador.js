var Controlador = function(){
	
	this.izq = new EntradaTeclado();
	this.der =new EntradaTeclado();
	this.arriba=new EntradaTeclado();
	
	class EntradaTeclado{
		constructor(){
			this.estaPresionada=false;
		}
		
		getEntrada(presionada){
			if(this.estaPresionada !=presionada)
				this.estaPresionada=presionada;
		}
	}
	
	return{
		estadoTecla:function(tipo,tecla){
			var presionada = (tipo == "keydown") ? true :false;
			
			switch(tecla){
			case "keyD": this.der.getEntrada(presionada); break;
			case "keyA": this.izq.getEntrada(presionada);
			
			}
		},
	}
	
}