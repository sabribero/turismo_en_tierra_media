package turismo_en_tierra_media;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
	
	@After
	public void teardown() {
		lasAtracciones.clear();
		lasPromociones.clear();
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

		assertEquals(2, lasPromociones.get(0).getAtraccionesEnPromocion().size());
		assertEquals(3, lasPromociones.get(1).getAtraccionesEnPromocion().size());
		assertEquals(2, lasPromociones.get(2).getAtraccionesEnPromocion().size());
		assertEquals(3, lasPromociones.get(3).getAtraccionesEnPromocion().size());
	}
	
	@Test
	public void nombresDeAtraccionesTest() {
		
		//Vemos los nombres de las atracciones

		assertEquals("Bosque Negro", lasPromociones.get(0).getAtraccionesEnPromocion().get(0).getNombre());
		assertEquals("Moria", lasPromociones.get(0).getAtraccionesEnPromocion().get(1).getNombre());
	}
	
	@Test
	public void valoresDeLasPromosTest() {
		
		//Vemos los nombres de las atracciones

		assertEquals(100, lasPromociones.get(3).getValorPromo());	// ABSOLUTA,100,Bosque Negro,Moria,Minas Tirith,La Comarca,Mordor
		assertEquals(5, lasPromociones.get(2).getValorPromo());		// AxB,0,Minas Tirith,Erebor
		assertEquals(18, lasPromociones.get(1).getValorPromo());	// PORCENTUAL,20,Minas Tirith,Abismo de Helm,Erebor 
																	// las sumatoria del costo de las atracciones es 22 y tienen 20% de descuento 
		assertEquals(50, lasPromociones.get(0).getValorPromo());	// ABSOLUTA,50,Bosque Negro,Moria
	}
}