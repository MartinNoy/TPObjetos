package model;

public class Cliente {
	private int nroCliente;
	private String zonaCliente;
	
	
	public Cliente(int nroCliente, String zonaCliente) {
		this.nroCliente = nroCliente;
		this.setZonaCliente(zonaCliente);
	}
	
	public int getNroCliente() {
		return nroCliente;
	}
	
	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getZonaCliente() {
		return zonaCliente;
	}

	public void setZonaCliente(String zonaCliente) {
		this.zonaCliente = zonaCliente;
	}
}