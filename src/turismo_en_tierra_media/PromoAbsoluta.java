package turismo_en_tierra_media;

import java.util.List;

public class PromoAbsoluta extends Promocion {

/*
 * Toma como valor de la promocion al indicado con valorPromo 
 */
	
	public PromoAbsoluta(List<Atraccion> atraccionesEnPromo, int valorPromo) {
		
		super(atraccionesEnPromo, valorPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habrá almenos una atracción y todas en la lista serán del mismo tipo
		this.tipo = TipoDePromo.ABSOLUTA;
		
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo) {
			this.tiempoPromo += cadaUna.getTiempoDeUso(); //decía "=+", para que acumule tiene que ser "+="
			}
	}	
}