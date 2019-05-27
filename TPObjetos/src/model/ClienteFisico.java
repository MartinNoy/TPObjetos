package model;

public class ClienteFisico extends Cliente{

	private DatosPersonales datosPersonales;
	
	public ClienteFisico(int nroCliente, Zona zonaCliente, DatosPersonales datosPersonales) {
		super(nroCliente, zonaCliente);
		this.setDatosPersonales(datosPersonales);
	}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Datos personales: "+ datosPersonales.toString();
	}
	
	public boolean equals(ClienteFisico cliente) {
		// TODO Auto-generated method stub
		return datosPersonales.equals(cliente.datosPersonales);
	}
	
}
	
	
