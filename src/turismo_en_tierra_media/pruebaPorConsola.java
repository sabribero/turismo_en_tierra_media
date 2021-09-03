package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.List;

public class pruebaPorConsola {

	public static void main(String[] args) {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
	//	List<Promocion> todasLasPromociones = new ArrayList<Promocion>();

		lectorDeArchivos lector = new lectorDeArchivos();

		lector.leerUsuarios("Usuarios.txt", todosLosUsuarios);
		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		Aplicacion APP = new Aplicacion(todasLasAtracciones);

		APP.separarAtracciones();

		for (int i = 0; i < todosLosUsuarios.size(); i++) {

			APP.ofrecerAtracciones(todosLosUsuarios.get(i));

			System.out.println(todosLosUsuarios.get(i).getNombre() + " va a ir a:");
			todosLosUsuarios.get(i).getItinerario().forEach(System.out::println);
			
			

		}

	}

}