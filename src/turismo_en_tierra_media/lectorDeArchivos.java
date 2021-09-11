package turismo_en_tierra_media;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class lectorDeArchivos {

	// Metodo que llamo en caso de que llegue una lista de Usuarios
	public void leerUsuarios(List<Usuario> todosLosUsuarios) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;

			// TipoDeAtraccion tipo = TipoDeAtraccion.DEFAULT;
			while ((linea = br.readLine()) != null) {
				
				// ahora los archivos de entrada soportan comentarios, si la línea tiene '#' al comienzo se ignora.
				if (linea.charAt(0) != '#') {
					String[] valores = linea.replace("\t","").split(",");	// el replace es para eliminar los espacios en los archivos de entrada.
					
					Usuario aux = new Usuario(valores[0], TipoDeAtraccion.valueOf(valores[3]), Integer.parseInt(valores[1]),
						Float.parseFloat(valores[2]));
					
					todosLosUsuarios.add(aux);
				}
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
	public void LeerAtracciones(List<Atraccion> todasLasAtracciones) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			
			while ((linea = br.readLine()) != null) {
				
				if (linea.charAt(0) != '#') {
					String[] valores = linea.replace("\t","").split(","); // el replace es para eliminar las tabulaciones en los archivos de entrada
					
					Atraccion aux = new Atraccion(valores[4], Integer.parseInt(valores[0]), Float.parseFloat(valores[1]),
						Integer.parseInt(valores[2]), TipoDeAtraccion.valueOf(valores[3]));
					
					todasLasAtracciones.add(aux);
				}
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

	/////////////////////// AGREGADO 5 DEL 9

	// Metodo que llamo en caso de que llegue una lista de Atracciones
	public void LeerPromos(List<Promocion> todasLasPromos, List<Atraccion> todasLasAtracciones) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Promociones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				
				if (linea.charAt(0) != '#') {
					List<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
					int valorDescuento;
	
					String[] valores = linea.replace("\t","").split(",");
	
					valorDescuento = Integer.parseInt(valores[1]);
	
					for (int i = 2; i < valores.length; i++) {
						for (int j = 0; j < todasLasAtracciones.size(); j++) {
							if (valores[i].equals(todasLasAtracciones.get(j).getNombre())) {
								atraccionesEnPromocion.add(todasLasAtracciones.get(j));
							}
						}
					}
					
					if (valores[0].equals("ABSOLUTA")) //unTipo == TipoDePromo.ABSOLUTA)
						todasLasPromos.add(new PromoAbsoluta(atraccionesEnPromocion, valorDescuento));
					else if (valores[0].equals("PORCENTUAL")) //unTipo == TipoDePromo.PORCENTUAL)
						todasLasPromos.add(new PromoPorcentual(atraccionesEnPromocion, valorDescuento));
					else if (valores[0].equals("AxB")) //unTipo == TipoDePromo.AxB)
						todasLasPromos.add(new PromoAxB(atraccionesEnPromocion));
				}
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
}