package turismo_en_tierra_media;

import java.util.List;

public class PromoAbsoluta extends Promocion{


/*
 * 
 * Toma como valor de la promocion al indicado 
 * 
 * con valorPromo
 */
	
	public PromoAbsoluta(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		
		super(atraccionesEnPromo, valorPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		this.valorPromo= valorPromo;
		
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo) {
			
			this.tiempoPromo=+cadaUna.getTiempoDeUso();
			}
	}
	
	
}
