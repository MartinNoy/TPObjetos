package model;

public class ClenteFisico extends Cliente{
	private DatosPersonales datosPersonales;
	
	public ClenteFisico(int nroCliente, String zonaCliente, DatosPersonales datosPersonales) {
		super(nroCliente, zonaCliente);
		this.setDatosPersonales(datosPersonales);
	}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	
}
	
	
