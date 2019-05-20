package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaElectrico {
	List<Cliente>clientes = new ArrayList<Cliente>();
	List<Zona>zonas = new ArrayList<Zona>();
	List<Tarifa>tarifas = new ArrayList<Tarifa>();
	List<Medidor>medidores = new ArrayList<Medidor>();
	
	public SistemaElectrico(List<Zona> zonas, List<Tarifa> tarifas,
			List<Cliente> clientes, List<Medidor> medidores) {
		this.clientes = clientes;
		this.zonas = zonas;
		this.tarifas = tarifas;
		this.medidores = medidores;
	}
	
	public SistemaElectrico() {
		
	}
	
	public List<Cliente> getclientes(){
		return clientes;
	}
	
	public void setclientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Zona> getzonas(){
		return zonas;
	}
	
	public void setzonas(List<Zona> zonas) {
		this.zonas = zonas;
	}
	
	public List<Tarifa> gettarifas(){
		return tarifas;
	}
	
	public void settarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
	public List<Medidor> getmedidores(){
		return medidores;
	}
	
	public void setmedidores(List<Medidor> medidores) {
		this.medidores = medidores;
	}
	
	
}
