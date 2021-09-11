package turismo_en_tierra_media;

import java.util.List;

public class PromoPorcentual extends Promocion {

	/*
	 * Descuenta el porcentaje de valor promo del valor total (suma) de todas las atracciones incluidas en la promo. 
	 */

	public PromoPorcentual(List<Atraccion> atraccionesEnPromo, int valorDescuento) {
		super(atraccionesEnPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habrá almenos una atracción y todas en la lista serán del mismo tipo
		this.tipo = TipoDePromo.PORCENTUAL;
		
		int auxValor=0;
		for(Atraccion cadaUna: atraccionesEnPromocion) {
			auxValor+= cadaUna.getValor();
		}
		this.valor= (int) Math.round(auxValor- auxValor*(valorDescuento/100.0));
	}	
	
}