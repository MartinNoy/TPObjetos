package model;

public class Factura {
	String periodo;
	float montoFijo;
	float montoVariable;
	float variablePico;
	float variableValle;
	float variableResto;
	float totalPago;
	int numeroDeMedidor;
	String nombreCliente;

	public Factura(String periodo, float montoFijo, float montoVariable, float totalPago, int numeroDeMedidor,
			String nombreCliente, float variablePico, float variableValle, float variableResto) {
		this.periodo = periodo;
		this.montoFijo = montoFijo;
		this.montoVariable = montoVariable;
		this.totalPago = totalPago;
		this.numeroDeMedidor = numeroDeMedidor;
		this.nombreCliente = nombreCliente;
		this.variablePico = variablePico;
		this.variableValle = variableValle;
		this.variableResto = variableResto;
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

	public float getVariablePico() {
		return variablePico;
	}

	public void setVariablePico(float variablePico) {
		this.variablePico = variablePico;
	}

	public float getVariableValle() {
		return variableValle;
	}

	public void setVariableValle(float variableValle) {
		this.variableValle = variableValle;
	}

	public float getVariableResto() {
		return variableResto;
	}

	public void setVariableResto(float variableResto) {
		this.variableResto = variableResto;
	}

	public String toStringBaja() {
		return "Factura [periodo=" + periodo + ", montoFijo=" + montoFijo + ", montoVariable=" + montoVariable
				+ ", totalPago=" + totalPago + ", numeroDeMedidor=" + numeroDeMedidor + ", nombreCliente="
				+ nombreCliente + "]";
	}

	public String toStringAlta() {
		return "Factura [periodo=" + periodo + ", montoFijo=" + montoFijo + ", VartiablePico=" + variablePico
				+ ", VartiableValle=" + variableValle + ", VartiableResto=" + variableResto + ", totalPago=" + totalPago
				+ ", numeroDeMedidor=" + numeroDeMedidor + ", nombreCliente=" + nombreCliente + "]";

	}

}
