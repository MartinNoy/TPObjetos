package model;

public class Zona {
	
	
	private int idZona;
	private String nombre;
	
	public Zona() {
		
	}

	public Zona(int idZona, String nombre) {
		super();
		this.idZona = idZona;
		this.nombre = nombre;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
}
