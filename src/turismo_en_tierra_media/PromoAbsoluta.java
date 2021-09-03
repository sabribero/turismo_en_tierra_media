package turismo_en_tierra_media;

public class PromoAbsoluta extends Promocion{

	private int precioTotal;
	
	public PromoAbsoluta(TipoDeAtraccion tipo, Atraccion atraccion1, Atraccion atraccion2, int precio) {
		super(tipo, atraccion1, atraccion2);
		this.precioTotal = Validacion.validar(precio);
	}
	
	public int aplicarPromo() {
		return this.precioTotal;
	}
}
