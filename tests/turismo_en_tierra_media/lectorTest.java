package turismo_en_tierra_media;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class lectorTest {

	List<Atraccion> lasAtracciones = new ArrayList<Atraccion>();
	List<Promocion> lasPromociones = new ArrayList<Promocion>();
	List<Usuario> losUsuarios = new ArrayList<Usuario>();

	@Before
	public void setup() {
		lectorDeArchivos lector = new lectorDeArchivos();
		lector.LeerAtracciones(lasAtracciones);
		lector.LeerPromos(lasPromociones, lasAtracciones);
		lector.leerUsuarios(losUsuarios);

	}

	@Test
	public void cantidadDePromosTest() {

		assertNotNull(lasAtracciones);
		assertNotNull(lasPromociones);
		assertNotNull(losUsuarios);

	}

}