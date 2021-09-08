package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class pruebaPorConsola {

	public static void main(String[] args) {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
	//	List<Promocion> todasLasPromociones = new ArrayList<Promocion>();

		lectorDeArchivos lector = new lectorDeArchivos();

		lector.leerUsuarios(todosLosUsuarios);
		lector.LeerAtracciones(todasLasAtracciones);

		Aplicacion APP = new Aplicacion(todasLasAtracciones);

		APP.separarAtracciones();
		
		
		System.out.println("Las atracciones separadas por tipo son:\n ");	
		
		System.out.println(APP.atraccionesDeAventura);
		System.out.println(APP.atraccionesDeDegustacion);
		System.out.println(APP.atraccionesDePaisaje);
		
		
		System.out.println("\n Iniciamos la oferta de atracciones:  \n \n ");	

		for (int i = 0; i < todosLosUsuarios.size(); i++) {

			APP.ofrecerAtracciones(todosLosUsuarios.get(i));

			System.out.println(todosLosUsuarios.get(i).getNombre() + " va a ir a:");
			todosLosUsuarios.get(i).getItinerario().forEach(System.out::println);
			
			

		}
		
		System.out.println("FIN. Gracias por utilizar Tierra Media APP");

	}

}