package model;

import model.DatosPersonales;

public class Inspector {
	private int nroLegajo;
	private DatosPersonales datosPersonales;
	
	public Inspector(int nroLegajo, DatosPersonales datosPersonales) {
		this.setNroLegajo(nroLegajo);
		this.setDatosPersonales(datosPersonales);
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
}
