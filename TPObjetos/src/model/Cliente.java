package model;

public class Cliente {
	private int nroCliente;
	private Zona zonaCliente;
	
	
	public Cliente(int nroCliente, Zona zonaCliente) {
		this.nroCliente = nroCliente;
		this.setZonaCliente(zonaCliente);
	}
	
	public int getNroCliente() {
		return nroCliente;
	}
	
	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public Zona getZonaCliente() {
		return zonaCliente;
	}

	public void setZonaCliente(Zona zonaCliente2) {
		this.zonaCliente = zonaCliente2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Numero de cliente: "+ nroCliente + " Zona: " + zonaCliente;
	}
	
	
}