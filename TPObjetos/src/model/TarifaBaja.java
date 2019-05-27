package model;

import java.util.List;
import java.util.ArrayList;

public class TarifaBaja extends Tarifa {

	private List<DetalleAlta> lstDetalle;

	public TarifaBaja(String servicio, List<DetalleAlta> lstDetalle) {
		super(servicio);
		this.lstDetalle = lstDetalle;
	}

	public List<DetalleAlta> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(List<DetalleAlta> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaBaja [lstDetalle=" + lstDetalle + "]";
	}

}
