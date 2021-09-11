package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class Promocion {

	protected int valorPromo;
	protected double tiempoPromo;


	protected List<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();

	public Promocion(List<Atraccion> atraccionesEnPromo, int valorPromo) {

		this.atraccionesEnPromocion = atraccionesEnPromo;
		this.valorPromo = valorPromo;

		/*
		 * El valor en monedas va a depender del valor de cada atraccion, del tipo de
		 * promo y del valor de la promo
		 * 
		 * 20% de descuento, 30% de descuento, absoluto de 40 monedas, 2x1, etc.
		 */

	}

	// --------------------------GETTERS----------------------


	public List<Atraccion> getAtraccionesEnPromocion() {
		return atraccionesEnPromocion;
	}

	public int getValorPromo() {
		return valorPromo;
	}
	
	public String getNombre() {
		
		String salida="";
		
		for(Atraccion cadaUna :this.getAtraccionesEnPromocion())
			
			salida= salida + cadaUna.getNombre() + ", ";
			
		return salida;
	}
	
	
	public double getTiempoDeUso() {
		return tiempoPromo;
	}

	/*
	 * 
	 * 
	 * FALTAN LOS GETTERS DE NOMBRE, TIEMPO DE USO Y ETC QUE SE DEBERIAN SACAR DE
	 * CADA UNA DE LAS ATRACCIONES Y SUMARSE.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
