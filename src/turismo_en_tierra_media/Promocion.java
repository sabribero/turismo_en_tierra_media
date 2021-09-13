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

	public TipoDeAtraccion getTipoDeAtraccion() {
		//asumiendo que está validado que todas las atracciones son del mismo tipo
		return this.atraccionesEnPromocion.get(0).getTipo();
	}
//-------------------------SETTERS--------------------
	public void setTiempo() {
		this.tiempoPromo=0;
		for(Atraccion cadaUna : atraccionesEnPromocion) {
			this.tiempoPromo += cadaUna.getTiempoDeUso();
		}
	}

}
