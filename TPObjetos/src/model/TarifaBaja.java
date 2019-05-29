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

	public void agregarDetalle() {
		/*
		DetalleBaja d = new DetalleBaja(detalleConcepto, unidad, desde, hasta, valor);
		lstDetalle.add(d);
		*/
		
		DetalleBaja d1 = new DetalleBaja("Cargo Fijo", "$/mes", 0, 150, 32.82);
		DetalleBaja d2 = new DetalleBaja("Cargo Variable", "$/kWh", 0, 150, 2.653);

		DetalleBaja d3 = new DetalleBaja("Cargo Fijo", "$/mes", 151, 325, 56.11);
		DetalleBaja d4 = new DetalleBaja("Cargo Variable", "$/kWh", 151, 325, 2.651);

		DetalleBaja d5 = new DetalleBaja("Cargo Fijo", "$/mes", 326, 400, 91.73);
		DetalleBaja d6 = new DetalleBaja("Cargo Variable", "$/kWh", 326, 400, 2.705);

		DetalleBaja d7 = new DetalleBaja("Cargo Fijo", "$/mes", 401, 450, 107.34);
		DetalleBaja d8 = new DetalleBaja("Cargo Variable", "$/kWh", 401, 450, 2.758);

		DetalleBaja d9 = new DetalleBaja("Cargo Fijo", "$/mes", 450, 500, 161.66);
		DetalleBaja d10 = new DetalleBaja("Cargo Variable", "$/kWh", 450, 500, 2.864);

		DetalleBaja d11 = new DetalleBaja("Cargo Fijo", "$/mes", 501, 600, 316.00);
		DetalleBaja d12 = new DetalleBaja("Cargo Variable", "$/kWh", 501, 600, 2.918);

		DetalleBaja d13 = new DetalleBaja("Cargo Fijo", "$/mes", 601, 700, 850.24);
		DetalleBaja d14 = new DetalleBaja("Cargo Variable", "$/kWh", 0, 150, 3.309);
		
		lstDetalle.add(d1);
		lstDetalle.add(d2);
		lstDetalle.add(d3);
		lstDetalle.add(d4);
		lstDetalle.add(d5);
		lstDetalle.add(d6);
		lstDetalle.add(d7);
		lstDetalle.add(d8);
		lstDetalle.add(d9);
		lstDetalle.add(d10);
		lstDetalle.add(d11);
		lstDetalle.add(d12);
		lstDetalle.add(d13);
		lstDetalle.add(d14);

	}
	

	public float calcularTotalTarifa(float consumo){
		
		float resultado=0;

		for (DetalleBaja d: lstDetalle){
			
			if((consumo>= d.getDesde())&&(consumo< d.getHasta())){
				
				if(d.getDetalleConcepto().contains("Cargo Fijo")){
					resultado = (float) (resultado + d.getValor());
				}
				
				if(d.getDetalleConcepto().contains("Cargo Variable")){
					resultado = (float) (resultado + d.getValor()*consumo);
				}
			}
		}
		return resultado;
	}
	
}
