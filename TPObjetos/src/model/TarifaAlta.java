package model;

import java.util.List;
import java.util.ArrayList;

public class TarifaAlta extends Tarifa {

	private String tensionContratada;
	private int limite;
	private List<DetalleAlta> lstDetalle;
	
	public TarifaAlta(String servicio, String tensionContratada, int limite) {
		super(servicio);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.lstDetalle = new ArrayList<DetalleAlta>();
	}

	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public List<DetalleAlta> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(List<DetalleAlta> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", lstDetalle="
				+ lstDetalle + "]";
	}

}
