package model;

import java.util.List;
import java.util.ArrayList;

public class Inspector {
	private int nroLegajo;
	private DatosPersonales datosPersonales;
	private List<Zona> zonas;
	
	public Inspector(int nroLegajo, DatosPersonales datosPersonales) {
		super();
		this.nroLegajo = nroLegajo;
		this.datosPersonales = datosPersonales;
		this.zonas = new ArrayList<Zona>();
	}
	public int getNroLegajo() {
		return nroLegajo;
	}
	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}
	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	public List<Zona> getZonas() {
		return zonas;
	}
	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}
	@Override
	public String toString() {
		return "Inspector [nroLegajo=" + nroLegajo + ", datosPersonales=" + datosPersonales + "]";
	}
	
	
	
}
