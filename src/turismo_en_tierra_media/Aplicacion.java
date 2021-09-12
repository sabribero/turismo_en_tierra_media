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

	// Lista de listas y listas auxiliares para ordenar antes de ofrecer

	List<List<Atraccion>> listaOrdenadaParaSugerir = new ArrayList<List<Atraccion>>();
	List<List<Promocion>> listaOrdenadaParaSugerirPromociones = new ArrayList<List<Promocion>>();

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

		atraccionesDeAventura.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDePaisaje.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDeDegustacion.sort(Comparator.comparing(Atraccion::getValor).reversed());
		todasLasAtracciones.sort(Comparator.comparing(Atraccion::getValor).reversed());
		
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
		
		//las ordeno
		promocionesDeAventura.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		promocionesDePaisaje.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		promocionesDeDegustacion.sort(Comparator.comparing(Promocion::getValorPromo).reversed());
		todasLasPromociones.sort(Comparator.comparing(Promocion::getValorPromo).reversed());

	}


	public void ofrecerTodo(Usuario unUsuario) {

		System.out.println("Bienvenido " + unUsuario.getNombre() + ", vamos a comenzar: \n\n");

		this.listaOrdenadaParaSugerir.clear();
		this.listaOrdenadaParaSugerirPromociones.clear();

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.PAISAJE) {
			
			
			Sugeridor.sugerirPromo(unUsuario, promocionesDePaisaje);
			Sugeridor.sugerirPromo(unUsuario, promocionesDeAventura);
			Sugeridor.sugerirPromo(unUsuario, promocionesDeDegustacion);
			
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDePaisaje);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeAventura);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeDegustacion);

		}

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.DEGUSTACION) {
			
			
			
			Sugeridor.sugerirPromo(unUsuario, promocionesDeDegustacion);
			Sugeridor.sugerirPromo(unUsuario, promocionesDePaisaje);
			Sugeridor.sugerirPromo(unUsuario, promocionesDeAventura);
			
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeDegustacion);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDePaisaje);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeAventura);
			

		}

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.AVENTURA) {
			
			Sugeridor.sugerirPromo(unUsuario, promocionesDeAventura);
			Sugeridor.sugerirPromo(unUsuario, promocionesDeDegustacion);
			Sugeridor.sugerirPromo(unUsuario, promocionesDePaisaje);
			
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeAventura);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDeDegustacion);
			Sugeridor.sugerirAtracciones(unUsuario, atraccionesDePaisaje);


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