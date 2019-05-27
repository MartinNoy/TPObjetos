package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaElectrico {
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Zona> zonas = new ArrayList<Zona>(); // Gabriel: ABM Zona y los traer
	List<Tarifa> tarifas = new ArrayList<Tarifa>(); // Franco: ABM Tarifa y sus traer
	List<Medidor> medidores = new ArrayList<Medidor>(); // Martin Crea ABM de Medidor y todos los traer
	List<Lectura> lecturas = new ArrayList<Lectura>(); // Gabriel: ABM Lectura y sus traer

	public SistemaElectrico(List<Zona> zonas, List<Tarifa> tarifas, List<Cliente> clientes, List<Medidor> medidores, List<Lectura> lecturas ) {
		this.clientes = clientes;
		this.zonas = zonas;
		this.tarifas = tarifas;
		this.medidores = medidores;
		this.lecturas = lecturas;
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
	
	public List<Lectura> getLecturas() {
		return lecturas;
	}

	public void setLecturas(List<Lectura> lecturas) {
		this.lecturas = lecturas;
	}
	

	// ----------------------------------------Comienzo ABM Medidor---------------------------------------------------

	

	public boolean agregarMedidor(String domicilio, boolean esBaja, Cliente cliente, Tarifa tarifa) throws Exception {
		if (traerMedidor(cliente) != null)
			throw new Exception("El cliente ya existe");
		int id = 1;
		if (!medidores.isEmpty())
			id = medidores.get(medidores.size() - 1).getNroSerie() + 1;
		Medidor medidor = new Medidor(id, domicilio, esBaja, cliente, tarifa);
		medidores.add(medidor);

		return true;
	}

	public boolean eliminarMedidor(Cliente cliente) throws Exception {
		if (traerMedidor(cliente) == null)
			throw new Exception("El cliente no existe");
		Medidor medidor = traerMedidor(cliente);
		medidores.remove(medidor);
		return true;
	}
	
	public boolean modificarmedidor(int nroSerie, String domicilioMedidor, boolean esBaja, Cliente cliente, Tarifa tarifa) throws Exception{
		Medidor medidorModificar = traerMedidor(cliente);
		if (medidorModificar==null)throw new Exception("El medidor no existe");
		medidorModificar.setNroSerie(nroSerie);
		medidorModificar.setDomicilioMedidor(domicilioMedidor);
		medidorModificar.setEsBaja(esBaja);
		medidorModificar.setCliente(cliente);
		medidorModificar.setTarifa(tarifa);
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
	
	// ----------------------------------------Comienzo ABM Zona-------------------------------------------------
	
	public boolean agregarZona(Zona zona)throws Exception {
		Zona existeZona=traerZona(zona.getIdZona());
		if(existeZona!=null) {
			throw new Exception ("Zona "+zona.getIdZona()+" ya existe");
		}	
		return zonas.add(zona);
	}
	
	public boolean modificarZona(int idZona, String zona) throws Exception{
		Zona existeZona=traerZona(idZona);
		if(existeZona==null)throw new Exception ("La zona "+idZona+" no se puede modificar, no existe en la Lista");
		existeZona.setNombre(zona);
		return true;
	}
	
	public boolean eliminarZona(int idZona) throws Exception{
		Zona existeZona=traerZona(idZona);		
		if(existeZona==null)			
			throw new Exception ("La zona id:   "+idZona+" no existe para eliminar");	
		return zonas.remove(existeZona);
	}
	
	public Zona traerZona(String nombre) {
		int i=0;
		Zona zonaEncontrada=null;
		while (i<zonas.size() && zonaEncontrada==null) {
			if(zonas.get(i).getNombre().equals(nombre)) {		  
				zonaEncontrada=zonas.get(i);		 
			}	 
			i++;	 
		}
		return zonaEncontrada;
	}
	
	public Zona traerZona(int idZona){
		int i=0;
		Zona zonaEncontrada=null;
		while (i<zonas.size() && zonaEncontrada==null) {
			if(zonas.get(i).getIdZona()==idZona) {		  
				zonaEncontrada=zonas.get(i);		 
			}	 
			i++;	 
		}
		return zonaEncontrada;
	}

	public Zona traerZona(Zona zona){
		Zona zonaEncontrada=traerZona(zona.getIdZona());
		return zonaEncontrada;
	}
	
	
	// ----------------------------------------Fin ABM Zona---------------------------------------------------------
	
	// ----------------------------------------Comienzo ABM Lectura-------------------------------------------------
	
	public boolean agregarLectura(Lectura lectura)throws Exception {
		Lectura existeLectura=traerLectura(lectura.getIdLectura());
		if(existeLectura!=null) {
			throw new Exception ("No puedo agregar la lectura"+lectura.getIdLectura()+" ya existe");
		}
		return lecturas.add(lectura);
	}
	
	public boolean agregarLectura(Alta Alta)throws Exception {

	    Lectura existeLectura=traerLectura(Alta.getIdLectura());

		if(existeLectura!=null) {
			throw new Exception ("No puedo agregar la lectura"+Alta.getIdLectura()+", ya existe");
		}
		return lecturas.add(Alta);
	}
	
	 public boolean agregarLectura(Baja Baja)throws Exception {

	    	Lectura existeLectura=traerLectura(Baja.getIdLectura());

			if(existeLectura!=null) {
				throw new Exception ("No puedo agregar la lectura"+Baja.getIdLectura()+" ya existe");
			}
			return lecturas.add(Baja);
	}
	 
	 
	 public boolean eliminarLectura(int idLectura)throws Exception {
			Lectura existeLectura=traerLectura(idLectura);

			if(existeLectura==null) 
				throw new Exception ("La lectura con id: "+idLectura+" ,NO existe para eliminar");
			return lecturas.remove(existeLectura);
		}
	 
	 
	 public boolean modificarLectura(int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor, int consumoHsPico, int consumoHsValle, int consumoHsResto) 
				throws Exception {
			Alta existeLectura=traerAlta(idLectura);

			if(existeLectura==null) throw new Exception ("La lectura Alta Demanda NO existe");
			existeLectura.setFecha(fecha);
			existeLectura.setHora(hora);
			existeLectura.setInspector(inspector);
			existeLectura.setMedidor(medidor);
			existeLectura.setConsumoHsPico(consumoHsPico);
			existeLectura.setConsumoHsResto(consumoHsResto);
			existeLectura.setConsumoHsValle(consumoHsValle);
			return true;
		}
	 
	 
	 public boolean modificarBaja(int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor, int consumo )throws Exception  { 
			Baja existeLectura=traerBaja(idLectura);

			if(existeLectura==null) throw new Exception ("La lectura Alta Demanda NO existe");	
			existeLectura.setFecha(fecha);
			existeLectura.setHora(hora);
			existeLectura.setInspector(inspector);
			existeLectura.setMedidor(medidor);
			existeLectura.setConsumo(consumo);
			return true;
		}
	 
	 public Lectura traerLectura(LocalDate fecha, Medidor medidor) {
		 Lectura Lectura = null;
		 int cont=0;
		 while(lecturas.size()>cont && Lectura == null) {
			 if(lecturas.get(cont).getFecha().isEqual(fecha)&&lecturas.get(cont).getMedidor().equals(medidor)) {
				 Lectura = lecturas.get(cont);
			 }
			 cont++;
		 }
		 return Lectura;
	 }
	 
	 public Lectura traerLectura(int idLectura){
			int i=0;
			Lectura lecturaEncontrada=null;
			while (i<lecturas.size() && lecturaEncontrada==null) {
				if(lecturas.get(i).getIdLectura()==idLectura) {		  
					lecturaEncontrada=lecturas.get(i);		 
				}	 
				i++;	 
			}
			return lecturaEncontrada;
		}
	 
	 public Alta traerAlta(int idLectura) {
		  
			int i=0;
			boolean encontrada=false;
			Alta lecturaEncontrada=null;

			while (i<lecturas.size() && !encontrada) {
				Lectura lectura = lecturas.get(i);
				if(lectura instanceof Alta) {	
					Alta lecturaAlta = (Alta)  lectura ;
					if(lectura.getIdLectura()==idLectura) {
						lecturaEncontrada= lecturaAlta;
						encontrada=true;	
					}	 
				}
				i++;
			}
			return lecturaEncontrada;
		}
	 
	 public Baja traerBaja(int idLectura) {
		  
			int i=0;
			boolean encontrada=false;
			Baja lecturaEncontrada=null;

			while (i<lecturas.size() && !encontrada) {
				Lectura lectura = lecturas.get(i);
				if(lectura instanceof Baja) {	
					Baja lecturabaja = (Baja)  lectura ;
					if(lectura.getIdLectura()==idLectura) {
						lecturaEncontrada= lecturabaja;
						encontrada=true;	
					}	 
				}
				i++;
			}
			return lecturaEncontrada;
		}
	 
	 // ----------------------------------------Fin ABM Lectura---------------------------------------------------------
	 
	// --------------------------------------Comienzo ABM Cliente------------------------------------------------
		
		public boolean agregarCliente(String zonaCliente, DatosPersonales datosPersonales) throws Exception {
			if(traerCliente(datosPersonales)!= null) throw new Exception("El cliente ya existe");
			int id = 1;
			if(!clientes.isEmpty()) id = clientes.get(clientes.size()-1).getNroCliente()+1;
			Cliente cliente = new ClienteFisico(id, zonaCliente, datosPersonales);
			clientes.add(cliente);
			return true;
		}
		
		public boolean agregarCliente(String zonaCliente, String razonSocial, long nroCUIT) throws Exception {
			if(traerCliente(nroCUIT)!= null) throw new Exception("El cliente ya existe");
			int id = 1;
			if(!clientes.isEmpty()) id = clientes.get(clientes.size()-1).getNroCliente()+1;
			Cliente cliente = new ClienteJuridico(id, zonaCliente, razonSocial, nroCUIT);
			clientes.add(cliente);
			return true;
		}
		
		public boolean eliminarCliente(long nroCUIT) throws Exception {
			Cliente cliente = traerCliente(nroCUIT);
			if (cliente==null) throw new Exception ("cliente no existe");
			clientes.remove(cliente);
			return true;
		}
		
		public boolean eliminarCliente(DatosPersonales datosPersonales) throws Exception {
			Cliente cliente = traerCliente(datosPersonales);
			if (cliente==null) throw new Exception ("cliente no existe");
			clientes.remove(cliente);
			return true;
		}
		
		
		
		public Cliente traerCliente(DatosPersonales datosPersonales) {
			Cliente cliente = null;
			int cont = 0;
			while(clientes.size()>cont && cliente==null) {
				if(clientes.get(cont) instanceof ClienteFisico) {
					ClienteFisico clienteFisico = (ClienteFisico)clientes.get(cont);
					if(clienteFisico.getDatosPersonales()==datosPersonales) {
						cliente = clienteFisico;
					}
				}
			}

			return cliente;
		}
		public Cliente traerCliente(long nroCUIT) {
			Cliente cliente = null;
			int cont = 0;
			while(clientes.size()>cont && cliente==null) {
				if(clientes.get(cont) instanceof ClienteJuridico) {
					ClienteJuridico clienteJuridico = (ClienteJuridico)clientes.get(cont);
					if(clienteJuridico.getNroCUIT()==nroCUIT) {
						cliente = clienteJuridico;
					}
				}
			}
			
			return cliente;
		}
		
		public boolean modificarCliente(DatosPersonales datosPersonales) throws Exception{
			ClienteFisico clienteModificar = (ClienteFisico)traerCliente(datosPersonales);
			if(clienteModificar == null)throw new Exception ("cliente no existe");
			clienteModificar.setDatosPersonales(datosPersonales);
			return true;
		}
		public boolean modificarCliente(long nroCUIT, String razonSocial) throws Exception{
			ClienteJuridico clienteModificar = (ClienteJuridico)traerCliente(nroCUIT);
			if(clienteModificar == null)throw new Exception ("cliente no existe");
			clienteModificar.setNroCUIT(nroCUIT);
			clienteModificar.setRazonSocial(razonSocial);
			return true;
		}
		
	 
	 //----------------------------------------Fin ABM Cliente---------------------------------------------------------
}
