package comparadores;

import java.util.Comparator;

import turismo_en_tierra_media.Atraccion;

public class ComparadorAtraccion implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion atraccion1, Atraccion atraccion2) {
		if(Integer.compare(atraccion1.getValor(), atraccion2.getValor())==0) {
			return Double.compare(atraccion1.getTiempoDeUso(), atraccion2.getTiempoDeUso());
		}
		return Integer.compare(atraccion1.getValor(), atraccion2.getValor());
	}

}
