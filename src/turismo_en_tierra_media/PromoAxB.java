package turismo_en_tierra_media;

import java.util.List;

public class PromoAxB extends Promocion {
	
	/* 
	 * El valor de la promo es igual al valor el de la primera atraccion.
	 */

	public PromoAxB(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		super(atraccionesEnPromo, valorPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		
		this.valorPromo= atraccionesEnPromo.get(0).getValor();
		
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habr� almenos una atracci�n y todas en la lista ser�n del mismo tipo
		this.tipo = TipoDePromo.AxB;
		
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo) {
			this.tiempoPromo+=cadaUna.getTiempoDeUso(); //dec�a "=+", para que acumule tiene que ser "+="
			}
	}	
}