package turismo_en_tierra_media;

import java.util.List;

public class PromoPorcentual extends Promocion {

	/*
	 * Descuenta el porcentaje de valor promo del valor total (suma) de todas las atracciones incluidas en la promo. 
	 */

	public PromoPorcentual(List<Atraccion> atraccionesEnPromo, int valorDescuento) {
		
		super(atraccionesEnPromo, valorDescuento);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habr� almenos una atracci�n y todas en la lista ser�n del mismo tipo
		this.tipo = TipoDePromo.PORCENTUAL;
		
		this.valorPromo=0;
		for(Atraccion cadaUna: atraccionesEnPromo)
			this.valorPromo += Math.round(cadaUna.getValor()*(1-(valorDescuento/100.0)));	// sumatoria de los valores de cada atracci�n de la promoci�n con descuento
																							// Hago un redondeo para obtener un n�mero entero de monedas
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromo)
			this.tiempoPromo+=cadaUna.getTiempoDeUso();
	}	
}