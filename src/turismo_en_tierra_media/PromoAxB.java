package turismo_en_tierra_media;

public class PromoAxB extends Promocion{
	
	private Atraccion atraccionGratis;
	
	public PromoAxB(TipoDeAtraccion tipo, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccionGratis) {
		super(tipo, atraccion1, atraccion2);
		try {
			Validacion.validarTipo(tipo, atraccionGratis.getTipo());
			this.atraccionGratis=atraccionGratis;
		} catch(DistintoTipoException e) {
			System.err.println("Discrepancia de tipos de atraccion en la promocion AXB que ofrece gratis " + atraccionGratis.getNombre() + ".");
		}
	}
	
	//TODO por el momento devuelve String para hacer las pruebas, lo ideal seria que devuelva una Atraccion
	//que se pueda agregar al itinerario.
	
	public String aplicarPromo() {
		return this.atraccionGratis.getNombre();
	}
}
