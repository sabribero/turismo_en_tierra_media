package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class pruebaPorConsola {

	public static void main(String[] args) {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
		List<Promocion> todasLasPromociones = new ArrayList<Promocion>();

		lectorDeArchivos lector = new lectorDeArchivos();

		lector.leerUsuarios(todosLosUsuarios);
		lector.LeerAtracciones(todasLasAtracciones);
		lector.LeerPromos(todasLasPromociones, todasLasAtracciones);

		Aplicacion APP = new Aplicacion(todasLasAtracciones, todasLasPromociones);

		APP.separarEnListas();
		
		
		System.out.println("Las atracciones separadas por tipo son:\n ");	
		
		
		System.out.print("Aventura: ");
		System.out.println(APP.atraccionesDeAventura);
		System.out.print("Degustacion: ");
		System.out.println(APP.atraccionesDeDegustacion);
		System.out.print("Paisaje : ");
		System.out.println(APP.atraccionesDePaisaje);
		
		
		System.out.println("\n Iniciamos la oferta de atracciones:  \n \n ");	

		for (int i = 0; i < todosLosUsuarios.size(); i++) {

			APP.ofrecerTodo(todosLosUsuarios.get(i));

			System.out.println(todosLosUsuarios.get(i).getNombre() + " va a ir a:");
			todosLosUsuarios.get(i).getItinerario().forEach(System.out::println);
			
			System.out.println(" \n \n FIN DE USUARIO \n \n");
			
			

		}
		
		System.out.println("FIN DE LA APP. Gracias por utilizar Tierra Media APP");

	}

}