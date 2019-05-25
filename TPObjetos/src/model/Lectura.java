package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lectura {
	
	protected int idLectura;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected Inspector inspector;
	protected Medidor medidor;
	
	public Lectura (int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor) {
		super();
		this.idLectura = idLectura;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.medidor = medidor;
	}

	public int getIdLectura() {
		return idLectura;
	}

	public void setIdLectura(int idLectura) {
		this.idLectura = idLectura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	@Override
	public String toString() {
		return "Lectura [idLectura=" + idLectura + ", fecha=" + fecha + ", hora=" + hora + ", inspector="
				+ inspector + ", medidor=" + medidor + "]";
	}
	
	
	
	

}
