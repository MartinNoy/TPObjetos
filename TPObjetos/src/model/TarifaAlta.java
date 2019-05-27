package model;

import java.util.List;
import java.util.ArrayList;

public class TarifaAlta extends Tarifa {

	private String tensionContratada;
	private int limite;
	private List<DetalleBaja> lstDetalle;
	
	public TarifaAlta(String servicio, String tensionContratada, int limite, List<DetalleBaja> lstDetalle) {
		super(servicio);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.lstDetalle = lstDetalle;
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

	public List<DetalleBaja> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(List<DetalleBaja> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", lstDetalle="
				+ lstDetalle + "]";
	}
	
	
	public boolean agregarDetalleAlta(String detalleConcepto, String unidad, boolean supererLimite, double valor) {
		DetalleAlta detalle = new DetalleAlta(detalleConcepto, unidad, supererLimite, valor);
		return true;
	}
	

}
