package model;

public class Factura {
	String periodo;
	float montoFijo;
	float montoVariable;
	float totalPago;
	int numeroDeMedidor;
	String nombreCliente;
	public Factura(String periodo, float montoFijo, float montoVariable, float totalPago, int numeroDeMedidor,
			String nombreCliente) {
		this.periodo = periodo;
		this.montoFijo = montoFijo;
		this.montoVariable = montoVariable;
		this.totalPago = totalPago;
		this.numeroDeMedidor = numeroDeMedidor;
		this.nombreCliente = nombreCliente;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public float getMontoFijo() {
		return montoFijo;
	}
	public void setMontoFijo(float montoFijo) {
		this.montoFijo = montoFijo;
	}
	public float getMontoVariable() {
		return montoVariable;
	}
	public void setMontoVariable(float montoVariable) {
		this.montoVariable = montoVariable;
	}
	public float getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(float totalPago) {
		this.totalPago = totalPago;
	}
	public int getNumeroDeMedidor() {
		return numeroDeMedidor;
	}
	public void setNumeroDeMedidor(int numeroDeMedidor) {
		this.numeroDeMedidor = numeroDeMedidor;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	@Override
	public String toString() {
		return "Factura [periodo=" + periodo + ", montoFijo=" + montoFijo + ", montoVariable=" + montoVariable
				+ ", totalPago=" + totalPago + ", numeroDeMedidor=" + numeroDeMedidor + ", nombreCliente="
				+ nombreCliente + "]";
	}
	
	
}
