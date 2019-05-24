package model;

public class DetalleBaja {

	private String detalleConcepto;
	private String unidad;
	private boolean superarLimite;
	private double valor;

	public DetalleBaja(String detalleConcepto, String unidad, boolean superarLimite, double valor) {
		super();
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.superarLimite = superarLimite;
		this.valor = valor;
	}

	public String getDetalleConcepto() {
		return detalleConcepto;
	}

	public void setDetalleConcepto(String detalleConcepto) {
		this.detalleConcepto = detalleConcepto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public boolean isSuperarLimite() {
		return superarLimite;
	}

	public void setSuperarLimite(boolean superarLimite) {
		this.superarLimite = superarLimite;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleBaja [detalleConcepto=" + detalleConcepto + ", unidad=" + unidad + ", superarLimite="
				+ superarLimite + ", valor=" + valor + "]";
	}

}
