package turismo_en_tierra_media;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {


	Usuario[] personas = new Usuario[4];
	@Before
	public void setup() {
		personas[0] = new Usuario("Eowyn", TipoDeAtraccion.AVENTURA, 10, 8);
		personas[1] = new Usuario("Gandalf", TipoDeAtraccion.PAISAJE, 100, 5);
		personas[2] = new Usuario("Sam", TipoDeAtraccion.DEGUSTACION, 36, 8);
		personas[3] = new Usuario("Galadriel", TipoDeAtraccion.PAISAJE, 120, 1);
	}
	
	@Test
	public void noAceptaValoresNegativos(){
		Usuario persona= new Usuario("Marina",TipoDeAtraccion.AVENTURA, 100,-5);
		assertEquals(0, persona.getTiempoDisponible());
	}
	
	@Test
	public void usuarioToString() {
		assertEquals("Eowyn tiene 10 monedas, 8 horas libres y su tipo de atraccion favorito es Aventura", personas[0].toString());
	}
	
	@Test
	public void agregarUnaAtraccionAlItinerario() {
		Atraccion atraccion1= new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		
		atraccion1.reservarLugar(personas[0]);
		
		assertEquals(5,atraccion1.getUsosDisponibles());
		assertEquals(6,personas[0].getTiempoDisponible());
		List<Atraccion> atraccionEquals= new ArrayList<Atraccion>();
		atraccionEquals.add(atraccion1); 
		assertEquals(atraccionEquals, personas[0].getItinerario());
	}
	

}
