package turismo_en_tierra_media;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PromocionesTest {

	List<Atraccion> lasAtracciones = new ArrayList<Atraccion>();
	List<Promocion> lasPromociones = new ArrayList<Promocion>();

	@Before
	public void setup() {
		lectorDeArchivos lector = new lectorDeArchivos();
		lector.LeerAtracciones(lasAtracciones);
		lector.LeerPromos(lasPromociones, lasAtracciones);

	}

	@Test
	public void cantidadDePromosTest() {
		
		//Vemos que se cargaron la cantidad correcta de promociones

		assertEquals(4, lasPromociones.size());

	}

	@Test
	public void tiposDePromosTest() {
		
		//Vemos los tipos de atraccion de cada una de las promociones

		assertEquals(TipoDePromo.ABSOLUTA, lasPromociones.get(0).getTipo());
		assertEquals(TipoDePromo.PORCENTUAL, lasPromociones.get(1).getTipo());
		assertEquals(TipoDePromo.AxB, lasPromociones.get(2).getTipo());
		assertEquals(TipoDePromo.ABSOLUTA, lasPromociones.get(3).getTipo());

	}
	
	
	@Test
	public void cantidadDeAtraccionesEnCadaPromoTest() {
		
		//Vemos cuantas atracciones entran en cada promocion

		assertEquals(2, lasPromociones.get(0).getAtraccionesEnLaPromo().size());
		assertEquals(3, lasPromociones.get(1).getAtraccionesEnLaPromo().size());
		assertEquals(2, lasPromociones.get(2).getAtraccionesEnLaPromo().size());
		assertEquals(5, lasPromociones.get(3).getAtraccionesEnLaPromo().size());


	}
	
	
	@Test
	public void nombresDeAtraccionesTest() {
		
		//Vemos los nombres de las atracciones

		assertEquals("Bosque Negro", lasPromociones.get(0).getAtraccionesEnLaPromo().get(0).getNombre());
		assertEquals("Moria", lasPromociones.get(0).getAtraccionesEnLaPromo().get(1).getNombre());


	}
	
	@Test
	public void valoresDeLasPromosTest() {
		
		//Vemos los nombres de las atracciones

		assertEquals(100, lasPromociones.get(3).getValorPromo());
		assertEquals(0, lasPromociones.get(2).getValorPromo());
		assertEquals(20, lasPromociones.get(1).getValorPromo());
		assertEquals(50, lasPromociones.get(0).getValorPromo());


	}
	


}
