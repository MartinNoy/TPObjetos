package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Baja extends Lectura {
	
	private int consumo;
	
	public Baja(int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor,
			int consumo) {
		super(idLectura, fecha, hora, inspector, medidor);
		this.consumo = consumo;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Baja [consumo=" + consumo + "]";
	}
	
	

}
