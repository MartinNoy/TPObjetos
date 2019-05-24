package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaElectrico {
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Zona> zonas = new ArrayList<Zona>();
	List<Tarifa> tarifas = new ArrayList<Tarifa>(); // Franco: ABM Tarifa y sus traer
	List<Medidor> medidores = new ArrayList<Medidor>();// Martin Crea ABM de Medidor y todos los traer

	public SistemaElectrico(List<Zona> zonas, List<Tarifa> tarifas, List<Cliente> clientes, List<Medidor> medidores) {
		this.clientes = clientes;
		this.zonas = zonas;
		this.tarifas = tarifas;
		this.medidores = medidores;
	}

	public SistemaElectrico() {

	}

	public List<Cliente> getclientes() {
		return clientes;
	}

	public void setclientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Zona> getzonas() {
		return zonas;
	}

	public void setzonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public List<Tarifa> gettarifas() {
		return tarifas;
	}

	public void settarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public List<Medidor> getmedidores() {
		return medidores;
	}

	public void setmedidores(List<Medidor> medidores) {
		this.medidores = medidores;
	}

	// ----------------------------------------Comienzo ABM Medidor---------------------------------------------------

	public boolean agregarMedidor(String domicilio, boolean esBaja, Cliente cliente, Tarifa tarifa) throws Exception {
		if (traerMedidor(cliente) != null)
			throw new Exception("El cliente ya exciste");
		int id = 1;
		if (!medidores.isEmpty())
			id = medidores.get(medidores.size() - 1).getNroSerie() + 1;
		Medidor medidor = new Medidor(id, domicilio, esBaja, cliente, tarifa);
		medidores.add(medidor);

		return true;
	}

	public boolean eliminarMedidor(Cliente cliente) throws Exception {
		if (traerMedidor(cliente) == null)
			throw new Exception("El cliente no exciste");
		Medidor medidor = traerMedidor(cliente);
		medidores.remove(medidor);
		return true;
	}

	public Medidor traerMedidor(Cliente cliente) {
		Medidor medidor = null;
		int cont = 0;
		while (medidores.size() > cont && medidor == null) {
			if (medidores.get(cont).getCliente().equals(cliente)) {
				medidor = medidores.get(cont);

			}
			cont++;
		}

		return medidor;
	}

	// ----------------------------------------Fin ABM Medidor---------------------------------------------------

	// ----------------------------------------Comienzo ABM Tarifa-----------------------------------------------

	public boolean agregarTarifa(Tarifa tarifa) throws Exception {
		boolean agregado = false;
		if (tarifas.isEmpty()) {
			agregado = tarifas.add(tarifa);
		} else {
			if (traerTarifa(tarifa) == null) {
				agregado = tarifas.add(tarifa);
			} else {
				throw new Exception("Error: La Tarifa ya ha sido agregada a la lista de Tarifas anteriormente");
			}
		}
		return agregado;
	}

	public boolean modificarTarifa(Tarifa tarifaVieja, Tarifa tarifaNueva) throws Exception {
		boolean modificado = false;
		Tarifa tarifaAux = traerTarifa(tarifaNueva);
		if (tarifaAux != null) {
			tarifaVieja = tarifaNueva;
			modificado = true;
		} else {
			throw new Exception("Error: La Tarifa a modificar no esta en la Lista de Tarifas");
		}
		return modificado;
	}

	public boolean eliminarTarifa(Tarifa tarifa) throws Exception {
		boolean eliminado = false;
		Tarifa tarifaEliminar = traerTarifa(tarifa);
		if (tarifaEliminar != null) {
			eliminado = tarifas.remove(tarifaEliminar);
		} else {
			throw new Exception("Error: La Tarifa a eliminar no esta en la Lista de Tarifas");
		}

		return eliminado;
	}

	public Tarifa traerTarifa(Tarifa tarifa) {
		Tarifa tarifaEnviada = null;
		int indice = 0;
		while (indice < tarifas.size()) {
			if (tarifas.get(indice).equals(tarifa)) {
				tarifaEnviada = tarifas.get(indice);
			}
			indice++;
		}
		return tarifaEnviada;
	}

	// ----------------------------------------Fin ABM Tarifa----------------------------------------------------

}
