package turismo_en_tierra_media;

import java.util.List;

public class PromoAbsoluta extends Promocion {

/*
 * Toma como valor de la promocion al indicado con valorPromo 
 */
	
	
	public PromoAbsoluta(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		super(atraccionesEnPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		this.valor= valorPromo;
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habr� almenos una atracci�n y todas en la lista ser�n del mismo tipo
		this.tipo = TipoDePromo.ABSOLUTA;
		
	}
	
}