package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class Promocion {
	protected int valor;
	protected double tiempoPromo;
	protected TipoDeAtraccion tipoAtraccion;
	protected TipoDePromo tipo;


	protected List<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();

	public Promocion(List<Atraccion> atraccionesEnPromo) {

		this.atraccionesEnPromocion = atraccionesEnPromo;
		this.setTiempo();
	}

	// --------------------------GETTERS----------------------


	public List<Atraccion> getAtraccionesEnPromocion() {
		return atraccionesEnPromocion;
	}
	
	public String getNombre() {
		
		String salida="";
		
		for(Atraccion cadaUna :this.getAtraccionesEnPromocion())
			salida += " "+cadaUna.getNombre() + ",";
			
		return salida;
	}
	
	public int getValorPromo() {
		return this.valor;
	}
	
	public double getTiempoDeUso() {
		return tiempoPromo;
	}

	public TipoDePromo getTipo() {
		return tipo;
	}

	
//-------------------------SETTERS--------------------
	//no se utiliza este setter directamente en el constructor ya que
	//en la promocion AxB hay que esperar a que se agregue la atraccion
	//gratis a la lista
	public void setTiempo() {
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromocion) {
			this.tiempoPromo += cadaUna.getTiempoDeUso();
		}
	}
	/*
	 *  
	 * FALTAN LOS GETTERS DE NOMBRE, TIEMPO DE USO Y ETC QUE SE DEBERIAN SACAR DE
	 * CADA UNA DE LAS ATRACCIONES Y SUMARSE.
	 * 
	 */

}
