package turismo_en_tierra_media;

import java.util.ArrayList;

import java.util.List;

public class Usuario {

	private List<Atraccion> itinerario = new ArrayList<Atraccion>();

	private String nombre;
	private TipoDeAtraccion atraccionFavorita;
	private int presupuesto, monedasIniciales;
	private float tiempoDisponible, tiempoDisponibleOriginal;

	public Usuario(String nombre, TipoDeAtraccion atraccionFavorita, int monedas, float tiempoLibre) {
		this.nombre = nombre;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = monedas;
		this.monedasIniciales = this.presupuesto;
		this.tiempoDisponible = tiempoLibre;
		this.tiempoDisponibleOriginal = this.tiempoDisponible;
	}

	public Usuario() {
		this(" ", TipoDeAtraccion.DEFAULT, 0, 0);
	}

//----------------------------GETTERS---------------------------------------------------
	public int getPresupuesto() {
		return presupuesto;
	}

	public List<Atraccion> getItinerario() {
		return itinerario;
	}

	public float getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreAtraccionFavorita() {
		return this.atraccionFavorita.getNombreDeTipo();
	}

	public TipoDeAtraccion getAtraccionFavorita() {
		return this.atraccionFavorita;
	}

//-------------------------------METODOS----------------------------
	@Override
	public String toString() {
		return this.nombre + ": Gasto " + (this.monedasIniciales - this.presupuesto) + " monedas.\n" + "Pasara "
				+ (this.tiempoDisponibleOriginal - this.tiempoDisponible)
				+ " horas en tierra media.\nSu tipo de atraccion favorito es: " + this.getNombreAtraccionFavorita()
				+ ".\nSu itinerario es: " + this.getItinerario() + ".";
	}
	
	//Datos para validar en junit
	public String userInfo() {
		return this.nombre + " tiene " + this.presupuesto + " monedas, " + (int) (this.tiempoDisponible)
				+ " horas libres y su tipo de atraccion favorito es " + this.getNombreAtraccionFavorita();
	}
	
	// a usarse cuando el usuario clickea aceptar
	protected void agregarAtraccion(Atraccion unaAtraccion) {
		this.itinerario.add(unaAtraccion);
		this.tiempoDisponible -= unaAtraccion.getTiempoDeUso();
	}

	//cobra dependiendo si es una promocion o atraccion
	protected void pagar(Promocion unaPromocion) {
		this.presupuesto -= unaPromocion.getValorPromo();
	}
	
	protected void pagar(Atraccion unaAtraccion) {
		this.presupuesto -= unaAtraccion.getValor();
	}

	// Responde verdadero si tiene las monedas y el tiempo suficiente ---->
	// Verdadero, tengo dinero y tiempo para ir a...
	public boolean podesIrA(Atraccion atraccion) {

		return this.presupuesto >= atraccion.getValor() 
				&& this.tiempoDisponible >= atraccion.getTiempoDeUso() 
				&& todaviaNoVasA(atraccion);								// agrego el método todaviaNoVasA() a este método para
																			// simplificar el la forma de evaluar si el usuario 
																			//puede ir a una atraccion.  
	}
	
	public boolean podesIrA(Promocion promocion) {
		return this.presupuesto>= promocion.getValorPromo() 
				&& this.tiempoDisponible>= promocion.getTiempoDeUso() 
				&& todaviaNoVasA(promocion);
	}
	
	// Si todavia no tiene en el itinerario la atraccion que le pasan como
	// parametro, da true --> Verdad, todavia no voy a .....
	public boolean todaviaNoVasA(Atraccion unaAtraccion) {

		for (Atraccion misAtracciones : itinerario) {
			if (misAtracciones.getNombre().equals(unaAtraccion.getNombre())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean todaviaNoVasA(Promocion promocion) {

		for(Atraccion atraccionPromo : promocion.getAtraccionesEnPromocion()) {
			for (Atraccion misAtracciones : this.itinerario) {
				if(misAtracciones.getNombre().equals(atraccionPromo.getNombre())) {
					return false;
				}
			}
		}
		return true;
	}
}
