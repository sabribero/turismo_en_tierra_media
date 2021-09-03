package turismo_en_tierra_media;

public class PromoPorcentual extends Promocion{
	
	private int descuento;
	

	public PromoPorcentual(TipoDeAtraccion tipo,Atraccion atraccion1, Atraccion atraccion2, int descuento) {
		super(tipo, atraccion1, atraccion2);
		this.descuento = Validacion.validar(descuento);
		
	}
//-------------------GETTERS------------------
	public int getDescuento() {
		return descuento;
	}

	

	
	
	public int aplicarPromo() { 
		//paso innecesario pero hace más legible el código
		int total= super.getPrecio1()+ super.getPrecio2();
		return  Math.round(total-total*this.descuento/100);
	}
}
