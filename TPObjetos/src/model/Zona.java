package model;

import java.util.List;

public class Zona {
	
	
	private int idZona;
	private String nombre;
	private List<Inspector> inspectores;
	private List<Cliente> clientes;
	
	public Zona() {
		
	}

	public Zona(int idZona, String nombre, List<Inspector> inspectores, List<Cliente> clientes) {
		super();
		this.idZona = idZona;
		this.nombre = nombre;
		this.inspectores = inspectores;
		this.clientes = clientes;
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

	public List<Inspector> getInspectores() {
		return inspectores;
	}

	public void setInspectores(List<Inspector> inspectores) {
		this.inspectores = inspectores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombre=" + nombre + ", inspectores=" + inspectores + ", clientes="
				+ clientes + "]";
	}
	
	
	
	
	
	
}
