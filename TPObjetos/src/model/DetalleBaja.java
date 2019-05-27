package model;

public class DetalleBaja {

	private String detalleConcepto;
	private String unidad;
	private int desde;
	private int hasta;
	private double valor;

	public DetalleBaja(String detalleConcepto, String unidad, int desde, int hasta, double valor) {
		super();
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.desde = desde;
		this.hasta = hasta;
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

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleAlta [detalleConcepto=" + detalleConcepto + ", unidad=" + unidad + ", desde=" + desde
				+ ", hasta=" + hasta + ", valor=" + valor + "]";
	}

}
