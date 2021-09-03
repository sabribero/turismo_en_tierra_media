package turismo_en_tierra_media;

public class Validacion {

	public static int validar(int numero) {
		try {
			if(numero>=0) {
				return numero;
			} else {
				throw new NumeroNegativoException("Se ha ingresado un número negativo.");
			}
		} catch(IllegalArgumentException e) {
			return 0;
		} catch(NumeroNegativoException e2) {
			return 0;
		}
	}
	
	public static double validar(double numero) {
		try {
			if(numero>=0) {
				return numero;
			} else {
				throw new NumeroNegativoException("Se ha ingresado un número negativo.");
			}
		} catch(IllegalArgumentException e) {
			return 0;
		} catch(NumeroNegativoException e2) {
			return 0;
		}
	}
	
	public static String validar(String cadena) {
		try{
			if(cadena!= null) {
				return cadena;
			} else {
				throw new NullPointerException("No se ingreso ninguna cadena de caracteres.");
			}
		} catch(NullPointerException e1) {
			return " ";
		}
	}
	
	//solo tira error si los datos no son correctos
	
	public static void validarTipo(TipoDeAtraccion referencia, TipoDeAtraccion dato) throws DistintoTipoException {
		if(referencia!=dato) {
			throw new DistintoTipoException("Discrepancia de tipos de atraccion.");
		}
	}
}
