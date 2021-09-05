package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class Promocion {
	
	private TipoDePromo tipo;
	
	private int valorPromo;
	private List<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
	
	
	//El valor indicado es la suma de las distintas atracciones
	private int valor;
	private double tiempoDeUso;

	
	
	
	

	
	public Promocion(TipoDePromo tipo, List<Atraccion> atraccionesEnPromo, int valorPromo) {

		
		this.tipo=tipo;
		this.atraccionesEnPromocion=atraccionesEnPromo;
		this.valorPromo=valorPromo;
		
		
		/*El valor en monedas va a depender del valor de cada atraccion, del tipo de promo y del valor de la promo
		 * 
		 * 20% de descuento, 30% de descuento, absoluto de 40 monedas, 2x1, etc.
		 */
		
		

		
		
		
	}



	//--------------------------GETTERS----------------------
	public TipoDePromo getTipo() {
		return this.tipo;
	}

	
	public List<Atraccion> getAtraccionesEnLaPromo() {
		return atraccionesEnPromocion;
	}
	
	public int getValorPromo() {
		return valorPromo;
	}
	
/*
 * 
 * 
 * FALTAN LOS GETTERS DE NOMBRE, TIEMPO DE USO Y ETC QUE SE DEBERIAN SACAR DE CADA UNA DE LAS
 * ATRACCIONES Y SUMARSE.
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
