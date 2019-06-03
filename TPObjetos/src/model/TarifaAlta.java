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
	
	public void agregarDetalle() {
		/*
		DetalleAlta d = new DetalleAlta(detalleConcepto, unidad, supererLimite, valor);
		lstDetalle.add(d);
		*/
		
		DetalleAlta d01= new DetalleAlta("Cargo Fijo", "$/mes", false, 3226.41);
		DetalleAlta d02= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 2.260);
		DetalleAlta d03= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 2.160);
		DetalleAlta d04= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 2.061);

		DetalleAlta d11= new DetalleAlta("Cargo Fijo", "$/mes", false, 3226.09);
		DetalleAlta d12= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 2.148);
		DetalleAlta d13= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 2.053);
		DetalleAlta d14= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 1.959);

		DetalleAlta d21= new DetalleAlta("Cargo Fijo", "$/mes", false, 3224.11);
		DetalleAlta d22= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 2.060);
		DetalleAlta d23= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 1.969);
		DetalleAlta d24= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 1.879);

		DetalleAlta d31= new DetalleAlta("Cargo Fijo", "$/mes", false, 3226.41);
		DetalleAlta d32= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 3.286);
		DetalleAlta d33= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 3.138);
		DetalleAlta d34= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 2.990);

		DetalleAlta d41= new DetalleAlta("Cargo Fijo", "$/mes", false, 3226.09);
		DetalleAlta d42= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 3.123);
		DetalleAlta d43= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 2.983);
		DetalleAlta d44= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 2.841);

		DetalleAlta d51= new DetalleAlta("Cargo Fijo", "$/mes", false, 3224.11);
		DetalleAlta d52= new DetalleAlta("Cargo Variable Pico", "$/kWh", false, 2.995);
		DetalleAlta d53= new DetalleAlta("Cargo Variable Resto", "$/kWh", false, 2.860);
		DetalleAlta d54= new DetalleAlta("Cargo Variable Valle", "$/kWh", false, 2.125);

		lstDetalle.add(d01);
		lstDetalle.add(d02);
		lstDetalle.add(d03);
		lstDetalle.add(d04);
		
		lstDetalle.add(d11);
		lstDetalle.add(d12);
		lstDetalle.add(d13);
		lstDetalle.add(d14);
		
		lstDetalle.add(d21);
		lstDetalle.add(d22);
		lstDetalle.add(d23);
		lstDetalle.add(d24);
		
		lstDetalle.add(d31);
		lstDetalle.add(d32);
		lstDetalle.add(d33);
		lstDetalle.add(d34);
		
		lstDetalle.add(d41);
		lstDetalle.add(d42);
		lstDetalle.add(d43);
		lstDetalle.add(d44);
		
		lstDetalle.add(d51);
		lstDetalle.add(d52);
		lstDetalle.add(d53);
		lstDetalle.add(d54);
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
