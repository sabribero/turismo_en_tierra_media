package turismo_en_tierra_media;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class lectorDeArchivos {




	// Metodo que llamo en caso de que llegue una lista de Usuarios
	public void leerUsuarios(String nombre, List<Usuario> todosLosUsuarios) {
		
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombre);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			
			TipoDeAtraccion tipo = TipoDeAtraccion.DEFAULT;
			while ((linea = br.readLine()) != null) {

				String[] valores = linea.split(",");
				
				if(valores[3].equals("P")) tipo = TipoDeAtraccion.PAISAJE;
				if(valores[3].equals("D")) tipo = TipoDeAtraccion.DEGUSTACION;
				if(valores[3].equals("A")) tipo = TipoDeAtraccion.AVENTURA;

				Usuario aux = new Usuario (valores[0], tipo, Integer.parseInt(valores[1]), Float.parseFloat(valores[2]));

				todosLosUsuarios.add(aux);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	// Metodo que llamo en caso de que llegue una lista de Atracciones
	public void LeerAtracciones(String nombre, List<Atraccion> todasLasAtracciones) {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombre);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			TipoDeAtraccion tipo = TipoDeAtraccion.DEFAULT;
			while ((linea = br.readLine()) != null) {

				String[] valores = linea.split(",");
				
				if(valores[4].equals("P")) tipo = TipoDeAtraccion.PAISAJE;
				if(valores[4].equals("D")) tipo = TipoDeAtraccion.DEGUSTACION;
				if(valores[4].equals("A")) tipo = TipoDeAtraccion.AVENTURA;

				Atraccion aux = new Atraccion(valores[4], Integer.parseInt(valores[0]),
						Float.parseFloat(valores[1]), Integer.parseInt(valores[2]), tipo);

				todasLasAtracciones.add(aux);

			}

		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
	
}