package model;

import java.util.List;
import java.util.ArrayList;

public class TarifaBaja extends Tarifa {

	private List<DetalleBaja> lstDetalle;


	public TarifaBaja(String servicio) {

		super(servicio);
		this.lstDetalle = new ArrayList<DetalleBaja>();
	}

	public List<DetalleBaja> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(List<DetalleBaja> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaBaja [lstDetalle=" + lstDetalle + "]";
	}

}
