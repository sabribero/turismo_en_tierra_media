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
				
				// ahora los archivos de entrada soportan comentarios, si la l�nea tiene '#' al comienzo se ignora.
				if (linea.charAt(0) != '#') {
					String[] valores = linea.replace("\t","").split(",");	// el replace es para eliminar los espacios en los archivos de entrada.
					
					//auxiliares para validar los datos ingresados y luego crear el objeto
					String nombre= Validacion.validar(valores[0]);
					int monedas= Validacion.validar(Integer.parseInt(valores[1]));
					float tiempoLibre= Validacion.validar(Float.parseFloat(valores[2]));
					
					Usuario aux = new Usuario(nombre, TipoDeAtraccion.valueOf(valores[3]), monedas, tiempoLibre);
					
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
					//auxiliares para validar los datos ingresados y luego crear el objeto
					String nombre= Validacion.validar(valores[4]);
					int valor= Validacion.validar(Integer.parseInt(valores[0]));
					double tiempoDeUso= Validacion.validar(Float.parseFloat(valores[1]));
					int usosMaximos= Validacion.validar(Integer.parseInt(valores[2]));
					
					Atraccion aux = new Atraccion(nombre, valor, tiempoDeUso, usosMaximos, TipoDeAtraccion.valueOf(valores[3]));
					
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
					//verifico que las promociones sean del mismo tipo de atraccion, y si lo son
					//se crea la promocion correspondiente
					try {
						for(Atraccion atraccion: atraccionesEnPromocion) {
							Validacion.validarTipo(atraccionesEnPromocion.get(0).getTipo(), atraccion.getTipo());
						}
						if (valores[0].equals("ABSOLUTA"))
							todasLasPromos.add(new PromoAbsoluta(atraccionesEnPromocion, valorDescuento));
						else if (valores[0].equals("PORCENTUAL"))
							todasLasPromos.add(new PromoPorcentual(atraccionesEnPromocion, valorDescuento));
						else if (valores[0].equals("AxB"))
							todasLasPromos.add(new PromoAxB(atraccionesEnPromocion));
					} catch(DistintoTipoException e) {
						System.err.println("Se encontro una discrepancia en los tipos de atracciones de una promocion ingresada.");
					}
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