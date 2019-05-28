package model;

import java.util.List;
import java.util.ArrayList;

public class Inspector {
	private int nroLegajo;
	private DatosPersonales datosPersonales;
	private Zona zona;

	public Inspector(int nroLegajo, DatosPersonales datosPersonales, Zona zona) {
		super();
		this.nroLegajo = nroLegajo;
		this.datosPersonales = datosPersonales;
		this.zona = zona;
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

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Inspector [nroLegajo=" + nroLegajo + ", datosPersonales=" + datosPersonales + "]";
	}
	
	
	
}
