package turismo_en_tierra_media;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromocionesTest {
	
/*
 * TODO
 * Por el momento imprime un mensaje de error. Habría que pensar una mejor manera
 * de no permitir que se ingresen distintos tipos de atracciones. Quiza verificarlo en
 * el momento de recibir las promociones desde el archivo?*/
	@Test
	public void discrepanciaDeTipos() {
		Atraccion atraccion1=new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		Atraccion atraccion2= new Atraccion("La Comarca",3,6.5,150,TipoDeAtraccion.DEGUSTACION);
		PromoPorcentual promo= new PromoPorcentual(TipoDeAtraccion.AVENTURA, atraccion1, atraccion2, 3);
		//no es null
		assertNotNull(promo);
		//pero sus datos sí lo son
		assertNull(promo.getNombre1());
		assertEquals(0, promo.getPrecio1());
		//  :/
		
		Atraccion atraccion3= new Atraccion("Erebor", 12, 3, 32,TipoDeAtraccion.PAISAJE);
		PromoAxB promo2= new PromoAxB(TipoDeAtraccion.AVENTURA, atraccion1, atraccion2, atraccion3);
	}
	@Test
	public void promoPorcentual() {
		Atraccion atraccion1=new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		Atraccion atraccion2= new Atraccion("Bosque negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		PromoPorcentual promo= new PromoPorcentual(TipoDeAtraccion.AVENTURA, atraccion1, atraccion2, 20);
		//redondea para arriba
		assertEquals(23, promo.aplicarPromo());
	}

	public void promoAbsoluta() {
		Atraccion atraccion1= new Atraccion("Lothlorien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		Atraccion atraccion2= new Atraccion("La Comarca",3,6.5,150,TipoDeAtraccion.DEGUSTACION);
		PromoAbsoluta promo= new PromoAbsoluta(TipoDeAtraccion.DEGUSTACION, atraccion1, atraccion2, 36);
		assertEquals(36, promo.aplicarPromo());
	}
	
	public void promoAXB() {
		Atraccion atraccion1= new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		Atraccion atraccion2= new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		Atraccion atraccion3= new Atraccion("Erebor", 12, 3, 32,TipoDeAtraccion.PAISAJE);
		PromoAxB promo= new PromoAxB(TipoDeAtraccion.PAISAJE, atraccion1, atraccion2, atraccion3);
		assertEquals("Erebor", promo.aplicarPromo());
	}
	
}
