package model;

public class ClienteJuridico extends Cliente{
	private String razonSocial;
	private long nroCUIT;
	
	public ClienteJuridico(int nroCliente, String zonaCliente, String razonSocial, long nroCUIT) {
		super(nroCliente, zonaCliente);
		this.razonSocial = razonSocial;
		this.nroCUIT = nroCUIT;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public long getNroCUIT() {
		return nroCUIT;
	}
	
	public void setNroCUIT(long nroCUIT) {
		this.nroCUIT = nroCUIT;
	}

}
