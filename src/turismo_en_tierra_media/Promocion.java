package turismo_en_tierra_media;

public class Promocion {
	
	private TipoDeAtraccion tipo;
	
	private int precio1;
	private String nombre1;
	private int precio2;
	private String nombre2;
	
	public Promocion(TipoDeAtraccion tipo, Atraccion atraccion1, Atraccion atraccion2) {
		//TODO Habría que pedir por consola que se ingrese una nueva promocion o que se 
		//rearme el archivo para que no queden los valores en null
		try {
			Validacion.validarTipo(tipo, atraccion1.getTipo());
			Validacion.validarTipo(tipo, atraccion2.getTipo());
			this.tipo = tipo;
			this.precio1 = atraccion1.getValor();
			this.precio2= atraccion2.getValor();
			this.nombre1=atraccion1.getNombre();
			this.nombre2=atraccion2.getNombre();
		} catch(DistintoTipoException e) {
			System.err.println("Discrepancia de tipos de las atracciones con el tipo de la promocion en la promocion que incluye " + atraccion1.getNombre() + " y " + atraccion2.getNombre()+ ".");
		}
	}

//--------------------------GETTERS----------------------
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public int getPrecio1() {
		return precio1;
	}

	public int getPrecio2() {
		return precio2;
	}
	
	public String getNombre1() {
		return this.nombre1;
	}
	public String  getNombre2() {
		return this.nombre2;
	}
}
