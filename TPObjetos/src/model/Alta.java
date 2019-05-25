package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alta extends Lectura {
	
	private int consumoHsPico;
	private int consumoHsValle;
	private int consumoHsResto;
	
	public Alta(int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor,
			int consumoHsPico, int consumoHsValle, int consumoHsResto) {
		super(idLectura, fecha, hora, inspector, medidor);
		this.consumoHsPico = consumoHsPico;
		this.consumoHsValle = consumoHsValle;
		this.consumoHsResto = consumoHsResto;
	}

	public int getConsumoHsPico() {
		return consumoHsPico;
	}

	public void setConsumoHsPico(int consumoHsPico) {
		this.consumoHsPico = consumoHsPico;
	}

	public int getConsumoHsValle() {
		return consumoHsValle;
	}

	public void setConsumoHsValle(int consumoHsValle) {
		this.consumoHsValle = consumoHsValle;
	}

	public int getConsumoHsResto() {
		return consumoHsResto;
	}

	public void setConsumoHsResto(int consumoHsResto) {
		this.consumoHsResto = consumoHsResto;
	}

	@Override
	public String toString() {
		return "Alta [consumoHsPico=" + consumoHsPico + ", consumoHsValle=" + consumoHsValle + ", consumoHsResto="
				+ consumoHsResto + "]";
	}

	
}
