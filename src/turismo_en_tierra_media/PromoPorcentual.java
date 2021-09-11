package turismo_en_tierra_media;

import java.util.List;

public class PromoPorcentual extends Promocion{
	

	/*
	 * 
	 * Descuenta el porcentaje de valor promo del valor total (suma) de todas las atracciones
	 * incluidas en la promo.
	 */

	public PromoPorcentual(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		
		super(atraccionesEnPromo, valorPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		
		this.valorPromo=0;
		for(Atraccion cadaUna: atraccionesEnPromo) {
			
			this.valorPromo=+cadaUna.getValor();
		}
		
		
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo) {
			
			this.tiempoPromo=+cadaUna.getTiempoDeUso();
			}
		
	}


}
