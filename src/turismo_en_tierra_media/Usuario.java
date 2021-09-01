package turismo_en_tierra_media;

import java.util.ArrayList;

import java.util.List;

public class Usuario {

	private List<Atraccion> itinerario = new ArrayList<Atraccion>();

	private String nombre;
	private TipoDeAtraccion atraccionFavorita;
	private int presupuesto;
	private int tiempoDisponible;
	
	
	public Usuario(String nombre, TipoDeAtraccion atraccionFavorita, int monedas, int tiempoLibre) {
		this.nombre=Validacion.validar(nombre);
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = Validacion.validar(monedas);
		this.tiempoDisponible = Validacion.validar(tiempoLibre);
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

	public int getTiempoDisponible() {
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
			return this.nombre + " tiene " + this.presupuesto + " monedas, " + this.tiempoDisponible + " horas libres y su tipo de atraccion favorito es " + this.getNombreAtraccionFavorita();
		}
	
	
	//a usarse cuando el usuario clickea aceptar
	protected void agregarAtraccion(Atraccion unaAtraccion) {
		this.itinerario.add(unaAtraccion);
		this.presupuesto-=unaAtraccion.getValor();
		this.tiempoDisponible-=unaAtraccion.getTiempoDeUso();
	}
	

	//Responde verdadero si tiene las monedas y el tiempo suficiente ----> Verdadero, tengo dinero y tiempo para ir a...
	public boolean podriasIrA(Atraccion unaAtraccion) {
		
		if(this.presupuesto>=unaAtraccion.getValor() && this.tiempoDisponible>=unaAtraccion.getTiempoDeUso()) {
			return true;
		}
		return false;
	}
	
	
	//Si todavia no tiene en el itinerario la atraccion que le pasan como parametro, da true --> Verdad, todavia no voy a .....
	public boolean todaviaNoVasA(Atraccion unaAtraccion) {
		
		for(Atraccion misAtracciones: itinerario) {
			if(misAtracciones.getNombre().equals(unaAtraccion.getNombre())) {
				return false;
			}
		
		}
		return true;
	}

}
