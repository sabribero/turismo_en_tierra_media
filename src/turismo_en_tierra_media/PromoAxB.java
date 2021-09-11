package turismo_en_tierra_media;

import java.util.List;

public class PromoAxB extends Promocion{
	
	
/*
 * 
 * El valor de toda la promo es igual al valor de la atraccion A 
 * 
 *es decir que toma como valor el de la primera atraccion.
 */
	
	public PromoAxB(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		super(atraccionesEnPromo, valorPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		this.valorPromo= atraccionesEnPromo.get(0).getValor();
		
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo) {
			
			this.tiempoPromo=+cadaUna.getTiempoDeUso();
			}
		
	
	}
	

	
	
}
