package model;

public class Medidor {
	private int nroSerie;
	private String domicilioMedidor;
	private boolean esBaja;
	private Cliente cliente;
	private Tarifa tarifa;
	public Medidor(int nroSerie, String domicilioMedidor, boolean esBaja, Cliente cliente, Tarifa tarifa) {
		super();
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = esBaja;
		this.cliente = cliente;
		this.tarifa = tarifa;
	}
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getDomicilioMedidor() {
		return domicilioMedidor;
	}
	public void setDomicilioMedidor(String domicilioMedidor) {
		this.domicilioMedidor = domicilioMedidor;
	}
	public boolean isEsBaja() {
		return esBaja;
	}
	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Numero de Serie:"+nroSerie+"Domicilio:"+domicilioMedidor+"Cliente:"+cliente.toString()+"Tarifa:"+tarifa.toString();
	}
	
	

}
