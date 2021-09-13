package turismo_en_tierra_media;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


import java.util.Comparator;
import java.util.List;

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 * Copie y pegue la clase aplicacion en este nuevo repo, todavia no funciona nada pero quiero que quede cargada
 * 
 * 
 * 3/9/2021
 * 
 * 
 * 
 * 
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 */

//La aplicacion se encarga del manejo y organizacion de todas las atracciones y promociones disponibles.

public class Aplicacion {

	// Todas las listas necesarias para organizar
	List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeAventura = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeDegustacion = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDePaisaje = new ArrayList<Atraccion>();

	List<Promocion> todasLasPromociones= new ArrayList<Promocion>();
	List<Promocion> promocionesDeAventura = new ArrayList<Promocion>();
	List<Promocion> promocionesDeDegustacion = new ArrayList<Promocion>();
	List<Promocion> promocionesDePaisaje = new ArrayList<Promocion>();


	// El constructor recibe una lista de atracciones
	public Aplicacion(List<Atraccion> Atracciones, List<Promocion> promociones) {
		this.todasLasAtracciones = Atracciones;
		this.todasLasPromociones=promociones;

	}

	public void separarEnListas() {

		for (int i = 0; i < this.todasLasAtracciones.size(); i++) {

			if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.AVENTURA) {
				atraccionesDeAventura.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.PAISAJE) {
				atraccionesDePaisaje.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.DEGUSTACION) {
				atraccionesDeDegustacion.add(todasLasAtracciones.get(i));

			}
		}

		
		
		//separo las promociones
		
		for (int i = 0; i < todasLasPromociones.size(); i++) {

			if (todasLasPromociones.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.AVENTURA) {
				promocionesDeAventura.add(todasLasPromociones.get(i));

			} else if (todasLasPromociones.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.PAISAJE) {
				promocionesDePaisaje.add(todasLasPromociones.get(i));

			} else if (todasLasPromociones.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.DEGUSTACION) {
				promocionesDeDegustacion.add(todasLasPromociones.get(i));

			}
		}
		
		ordenarListas();

	}
	
	protected void ordenarListas() {
		//atracciones
		atraccionesDeAventura.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDePaisaje.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDeDegustacion.sort(Comparator.comparing(Atraccion::getValor).reversed());
		todasLasAtracciones.sort(Comparator.comparing(Atraccion::getValor).reversed());
		
		//promociones
		promocionesDeAventura.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		promocionesDePaisaje.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		promocionesDeDegustacion.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		todasLasPromociones.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
	}

	public void ofrecerTodo(Usuario unUsuario) {

		System.out.println("Bienvenido " + unUsuario.getNombre() + ", vamos a comenzar: \n\n");

		switch(unUsuario.getAtraccionFavorita()) {
			
		case PAISAJE:
			Sugeridor.sugerirPromos(unUsuario, promocionesDePaisaje);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDePaisaje);
			Sugeridor.sugerirPromosNoFavoritas(unUsuario, todasLasPromociones);
			Sugeridor.sugerirAtraccionesNoFavoritas(unUsuario, todasLasAtracciones);
			break;

		case DEGUSTACION:
			
			Sugeridor.sugerirPromos(unUsuario, promocionesDeDegustacion);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeDegustacion);
			Sugeridor.sugerirPromosNoFavoritas(unUsuario, todasLasPromociones);
			Sugeridor.sugerirAtraccionesNoFavoritas(unUsuario, todasLasAtracciones);
			break;

		case AVENTURA:
			
			Sugeridor.sugerirPromos(unUsuario, promocionesDeAventura);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeAventura);
			Sugeridor.sugerirPromosNoFavoritas(unUsuario, todasLasPromociones);
			Sugeridor.sugerirAtraccionesNoFavoritas(unUsuario, todasLasAtracciones);
			break;

		case DEFAULT:
			System.out.println("Hay una Atraccion cuyos datos no fueron correctamente ingresados.");
		}

		/////////////////////////////////////////////////////

		crearArchivoUsuario(unUsuario);

	}
	
	
	
	
	
	

	public void crearArchivoUsuario(Usuario unUsuario) {

		try {
			String ruta = "archivos_de_salida/"+unUsuario.getNombre()+".txt";
			//String ruta = unUsuario.getNombre() + ".txt";
			String contenido = unUsuario.toString();
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}