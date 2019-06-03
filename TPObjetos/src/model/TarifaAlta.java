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
	
	
	public boolean agregarDetalleAlta(String detalleConcepto, String unidad, boolean supererLimite, double valor) {
		DetalleAlta detalle = new DetalleAlta(detalleConcepto, unidad, supererLimite, valor);
		return true;
	}
	
	public float calcularTotalTarifa(int consumoPico, int consumoResto, int consumoValle){
		
		float resultado=0;

		
			for (DetalleAlta d: lstDetalle){
			
					if(d.getDetalleConcepto().contentEquals("Cargo Fijo")){
						resultado = (float) (resultado + d.getValor());
					}
					
					if(d.getDetalleConcepto().contentEquals("Cargo Variable Pico")){
						resultado = (float) (resultado + d.getValor()*consumoPico);
					}
					
					if(d.getDetalleConcepto().contentEquals("Cargo Variable Resto")){
						resultado = (float) (resultado + d.getValor()*consumoResto);
					}
					
					if(d.getDetalleConcepto().contentEquals("Cargo Variable Valle")){
						resultado = (float) (resultado + d.getValor()*consumoValle);
					}
			}
		return resultado;
	}

}
