package turismo_en_tierra_media;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {

	List<Usuario> personas = new ArrayList<Usuario>();
	
	@Before
	public void setUp() {
		LectorDeArchivos lector = new LectorDeArchivos();
		lector.leerUsuarios(personas);
	}
	
	@After
	public void tearDown() {
		personas.clear();
	}
	
	@Test
	public void pruebaDeLecturadeTipoDeAtraccion() {
		assertEquals(TipoDeAtraccion.AVENTURA, personas.get(0).getAtraccionFavorita());
		assertEquals(TipoDeAtraccion.DEGUSTACION, personas.get(1).getAtraccionFavorita());
		assertEquals(TipoDeAtraccion.PAISAJE, personas.get(2).getAtraccionFavorita());
		assertEquals(TipoDeAtraccion.PAISAJE, personas.get(3).getAtraccionFavorita());
	}
	
	@Test
	public void usuarioToString() {
		assertEquals("Eowyn tiene 10 monedas, 8 horas libres y su tipo de atraccion favorito es Aventura", personas.get(0).userInfo());
	}
	
	@Test
	public void agregarUnaAtraccionAlItinerario() {
		Atraccion atraccion1= new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		
		atraccion1.reservarLugar(personas.get(0));
		
		assertEquals(5,atraccion1.getUsosDisponibles());
		assertEquals(6,personas.get(0).getTiempoDisponible(),0);
		List<Atraccion> atraccionEquals= new ArrayList<Atraccion>();
		atraccionEquals.add(atraccion1); 
		assertEquals(atraccionEquals, personas.get(0).getItinerario());
	}
}