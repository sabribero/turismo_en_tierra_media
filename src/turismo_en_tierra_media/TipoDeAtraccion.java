package turismo_en_tierra_media;

public enum TipoDeAtraccion {
	PAISAJE("Paisaje"), AVENTURA("Aventura"), DEGUSTACION("Degustacion"), DEFAULT("Default");
	
	String nombre;
	
	TipoDeAtraccion(String nombre) {
		this.nombre=nombre;
	}
	
	String getNombreDeTipo(){
		return this.nombre;
	}
}
