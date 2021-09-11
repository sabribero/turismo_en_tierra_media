package turismo_en_tierra_media;

import java.util.List;

public class PromoAxB extends Promocion {
	

	public PromoAxB(List<Atraccion> atraccionesEnPromo) {
		super(atraccionesEnPromo);
		this.atraccionesEnPromocion=atraccionesEnPromo;
		this.setValor();
		this.tipoAtraccion = atraccionesEnPromo.get(0).getTipo(); // asumo que habrá almenos una atracción y todas en la lista serán del mismo tipo
		this.tipo = TipoDePromo.AxB;
		
	}	
	
	public void setValor() {
		this.valor=0;
		//recorre las atracciones sin incluir la ultima, que supuestamente es gratis
		for(int i=0; i<atraccionesEnPromocion.size()-1;i++) {
			this.valor+= this.atraccionesEnPromocion.get(i).getValor();
		}
	}
}