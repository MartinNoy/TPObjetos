package model;

public class ClienteFisico extends Cliente{
	private DatosPersonales datosPersonales;
	
	public ClienteFisico(int nroCliente, String zonaCliente, DatosPersonales datosPersonales) {
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
	
	