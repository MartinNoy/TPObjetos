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
	List<Inspector> inspectores = new ArrayList<Inspector>();
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

	
	

	
	

	public boolean agregarMedidor(String domicilio, boolean esBaja, int dni, Tarifa tarifa) throws Exception {
		if (traerMedidor(dni) != null)
			throw new Exception("El cliente ya existe");
		int id = 1;
		if (!medidores.isEmpty())
			id = medidores.get(medidores.size() - 1).getNroSerie() + 1;
		Medidor medidor = new Medidor(id, domicilio, esBaja, traerCliente(dni), tarifa);
		medidores.add(medidor);

		return true;
	}

	public boolean eliminarMedidor(int dni) throws Exception {
		if (traerMedidor(dni) == null)
			throw new Exception("El cliente no existe");
		Medidor medidor = traerMedidor(dni);
		medidores.remove(medidor);
		return true;
	}
	
	public boolean modificarmedidor(int nroSerie, String domicilioMedidor, boolean esBaja, int dniCliente ) throws Exception{
		Medidor medidorModificar = traerMedidor(nroSerie);
		if (medidorModificar==null)throw new Exception("El medidor no existe");
		medidorModificar.setNroSerie(nroSerie);
		medidorModificar.setDomicilioMedidor(domicilioMedidor);
		medidorModificar.setEsBaja(esBaja);
		medidorModificar.setCliente(traerCliente(dniCliente));
		//medidorModificar.setTarifa(tarifa);
		
		return true;
	}
	
	public boolean modificarmedidor(int nroSerie, String domicilioMedidor, boolean esBaja, int dniCliente, String tensionContratada  ) throws Exception{
		Medidor medidorModificar = traerMedidor(nroSerie);
		if (medidorModificar==null)throw new Exception("El medidor no existe");
		medidorModificar.setNroSerie(nroSerie);
		medidorModificar.setDomicilioMedidor(domicilioMedidor);
		medidorModificar.setEsBaja(esBaja);
		medidorModificar.setCliente(traerCliente(dniCliente));
		medidorModificar.setTarifa(traerTarifaAlta(tensionContratada));
		
		
		return true;
	}

	public Medidor traerMedidor(int nroSerie) {
		Medidor medidor = null;
		int cont = 0;
		while (medidores.size() > cont && medidor == null) {
			if (medidores.get(cont).getNroSerie()==nroSerie) {
				medidor = medidores.get(cont);

			}
			cont++;
		}

		return medidor;
	}

	// ----------------------------------------Fin ABM Medidor---------------------------------------------------
	
	
	
	
	

	// ----------------------------------------Comienzo ABM Tarifa-----------------------------------------------

	public boolean agregarTarifa(String servicio, String tensionContratada, int limite) throws Exception {
		boolean agregado = false;
		Tarifa tarifa = new TarifaAlta(servicio, tensionContratada,limite);
		if (tarifas.isEmpty()) {
			agregado = tarifas.add(tarifa);
		} else {
			if (traerTarifa(servicio) == null) {
				agregado = tarifas.add(tarifa);
			} else {
				throw new Exception("Error: La Tarifa ya ha sido agregada a la lista de Tarifas anteriormente");
			}
		}
		return agregado;
	}

	public boolean agregarTarifa(String servicio) throws Exception {
		boolean agregado = false;
		Tarifa tarifa = new TarifaBaja(servicio);
		if (tarifas.isEmpty()) {
			agregado = tarifas.add(tarifa);
		} else {
			if (traerTarifa(servicio) == null) {
				agregado = tarifas.add(tarifa);
			} else {
				throw new Exception("Error: La Tarifa ya ha sido agregada a la lista de Tarifas anteriormente");
			}
		}
		return agregado;
	}
	
	public boolean modificarTarifaAlta(String tarifaVieja, String tarifaNueva, String tensionContratada, int limite) throws Exception {
		boolean modificado = false;
		Tarifa tarifaAux = traerTarifa(tarifaVieja);
		Tarifa tarifaNuevaAux = traerTarifa(new TarifaAlta(tarifaNueva,tensionContratada,limite).getServicio());
		if (tarifaAux != null && tarifaNuevaAux != null) {
			tarifaNuevaAux = tarifaAux;
			modificado = true;
		} else {
			throw new Exception("Error: La Tarifa a modificar no esta en la Lista de Tarifas");
		}
		return modificado;
	}

	public boolean eliminarTarifa(String servicio) throws Exception {
		boolean eliminado = false;
		Tarifa tarifaEliminar = traerTarifa(servicio);
		if (tarifaEliminar != null) {
			eliminado = tarifas.remove(tarifaEliminar);
		} else {
			throw new Exception("Error: La Tarifa a eliminar no esta en la Lista de Tarifas");
		}

		return eliminado;
	}

	public Tarifa traerTarifa(String servicioSoicitado) {
		Tarifa tarifaEnviada = null;
		int indice = 0;
		while (indice < tarifas.size()) {
			if (tarifas.get(indice).equals(new Tarifa(servicioSoicitado))) {
				tarifaEnviada = tarifas.get(indice);
			}
			indice++;
		}
		return tarifaEnviada;
	}
	
	public TarifaBaja traerTarifaBaja(String servicioSoicitado) {
		TarifaBaja tarifaEnviada = null;
		int indice = 0;
		while (indice < tarifas.size()) {
			if (tarifas.get(indice).equals(new Tarifa(servicioSoicitado)) && tarifas.get(indice) instanceof TarifaBaja) {
				tarifaEnviada = (TarifaBaja) tarifas.get(indice);
			}
			indice++;
		}
		return tarifaEnviada;
	
	}public TarifaAlta traerTarifaAlta(String servicioSoicitado) {
		TarifaAlta tarifaEnviada = null;
		int indice = 0;
		while (indice < tarifas.size()) {
			if (tarifas.get(indice).equals(new Tarifa(servicioSoicitado)) && tarifas.get(indice) instanceof TarifaAlta) {
				tarifaEnviada = (TarifaAlta) tarifas.get(indice);
			}
			indice++;
		}
		return tarifaEnviada;
	}

	// ----------------------------------------Fin ABM Tarifa----------------------------------------------------
	
	// ----------------------------------------Comienzo ABM Zona-------------------------------------------------
	
	public boolean agregarZona(String nombre)throws Exception {
		int id = 1;
		Zona existeZona=traerZona(nombre);
		if(existeZona!=null) {
			throw new Exception ("Zona "+nombre+" ya existe");
		}
		if (!zonas.isEmpty())id=zonas.get(zonas.size()-1).getIdZona()+1;
		Zona zona = new Zona(id, nombre);
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
	
	public boolean agregarLectura(LocalDate fecha, LocalTime hora,int dni, int nroSerie, int consumo )throws Exception {
		int id = 1;
		if (!lecturas.isEmpty())id=lecturas.get(lecturas.size()-1).getIdLectura()+1;
		Lectura lectura = new Baja(id,fecha,hora,traerInspector(dni),traerMedidor(nroSerie),consumo);
		Lectura existeLectura=traerLectura(lectura.getIdLectura());
		if(existeLectura!=null) {
			throw new Exception ("No puedo agregar la lectura"+lectura.getIdLectura()+" ya existe");
		}
		return lecturas.add(lectura);
	}
	
	public boolean agregarLectura(LocalDate fecha, LocalTime hora,int dni, int nroSerie, int hsPico, int hsValle, int hsResto )throws Exception {
		int id = 1;
		if (!lecturas.isEmpty())id=lecturas.get(lecturas.size()-1).getIdLectura()+1;
		Lectura lectura = new Alta(id,fecha,hora,traerInspector(dni),traerMedidor(nroSerie), hsResto, hsValle, hsPico);
		Lectura existeLectura=traerLectura(lectura.getIdLectura());
		if(existeLectura!=null) {
			throw new Exception ("No puedo agregar la lectura"+lectura.getIdLectura()+" ya existe");
		}
		return lecturas.add(lectura);
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
	 
	 
	 public boolean modificarLectura(int idLectura, LocalDate fecha, LocalTime hora, Inspector inspector, Medidor medidor, int consumo )throws Exception  { 
			Baja existeLectura=traerBaja(idLectura);

			if(existeLectura==null) throw new Exception ("La lectura Alta Demanda NO existe");	
			existeLectura.setFecha(fecha);
			existeLectura.setHora(hora);
			existeLectura.setInspector(inspector);
			existeLectura.setMedidor(medidor);
			existeLectura.setConsumo(consumo);
			return true;
		}
	 
	 public Lectura traerLectura(LocalDate fecha, int nroSerie) {
		 Lectura Lectura = null;
		 Medidor medidor = traerMedidor(nroSerie);
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
	 

		public List<Lectura> traerLecturas(Medidor medidor) {
			List<Lectura> lecturasPorMedidor = new ArrayList<Lectura>();
			int indice = 0;
			while (lecturas.size() > indice) {
				if (lecturas.get(indice).getMedidor().equals(medidor)) {
					lecturasPorMedidor.add(lecturas.get(indice));
				}
				indice++;
			}
	
			return lecturasPorMedidor;
		}
	 
	 	
	 
	 // ----------------------------------------Fin ABM Lectura---------------------------------------------------------
	 
	// --------------------------------------Comienzo ABM Cliente------------------------------------------------
		
		public void agregarCliente(String nombreZona, String nombre , String apellido, int dni) throws Exception {
			DatosPersonales datosPersonales = new DatosPersonales(nombre,apellido,dni);
			
			if(traerZona(nombreZona) == null) {
				agregarZona(nombreZona);
				
			}
			Zona zonaCliente = traerZona(nombreZona);
			if(traerCliente(dni)!= null) throw new Exception("El cliente ya existe");
			int id = 1;
			if(!clientes.isEmpty()) id = clientes.get(clientes.size()-1).getNroCliente()+1;
			Cliente cliente = new ClienteFisico(id, zonaCliente, datosPersonales);
			clientes.add(cliente);
		}
		
		public boolean agregarCliente(Zona zonaCliente, String razonSocial, long nroCUIT) throws Exception {
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
		
		public boolean eliminarCliente(int dni) throws Exception {
			Cliente cliente = traerCliente(dni);
			if (cliente==null) throw new Exception ("cliente no existe");
			clientes.remove(cliente);
			return true;
		}
		
		
		
		public Cliente traerCliente(int dni) {
			Cliente cliente = null;
			int cont = 0;
			while(clientes.size()>cont && cliente==null) {
				if(clientes.get(cont) instanceof ClienteFisico) {
					ClienteFisico clienteFisico = (ClienteFisico)clientes.get(cont);
					if(clienteFisico.getDatosPersonales().getDni()==dni) {
						cliente = clienteFisico;
					}
				}
				cont ++;
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
			cont ++;
			}
			
			return cliente;
		}
		
		public boolean modificarCliente(int dni, String nombreModificar, String apellidoModificar, int dniModificar ) throws Exception{
			ClienteFisico clienteModificar = (ClienteFisico)traerCliente(dni);
			if(clienteModificar == null)throw new Exception ("cliente no existe");
			clienteModificar.getDatosPersonales().setApellido(apellidoModificar);
			clienteModificar.getDatosPersonales().setNombre(nombreModificar);
			clienteModificar.getDatosPersonales().setDni(dniModificar);
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
		
	 // ----------------------------------------Comienzo ABM inspector-------------------------------------------------
		
		public boolean agregarIspector(String nombre, String apellido, int dni, String nombreZona) {
			int id = 1;
			DatosPersonales datos = new DatosPersonales(nombre,apellido,dni);
			if(!inspectores.isEmpty())id=inspectores.get(inspectores.size()-1).getNroLegajo()+1;
			Inspector inspector = new Inspector(id, datos , traerZona(nombreZona));
			return inspectores.add(inspector);
		}
		
		public Inspector traerInspector(int dni) {
			Inspector inspector = null;
			int cont = 0;
			while(inspectores.size()>cont && inspector!= null) {
				if(inspectores.get(cont).getDatosPersonales().getDni()==dni) {
					inspector = inspectores.get(cont);
				}
				cont ++;
			}
			return inspector;
		}

	 //----------------------------------------Generar Total a pagar---------------------------------------------------
		//Franco: todavia le falta.. paciencia.
		public String traerPeriodoMes(LocalDate fecha) {
			return  fecha.getMonth().toString();
		}
		
		public float calcularConsumoAlta(Alta lecturaAlta, Alta lecturaAltaAnterior, TarifaAlta tarifa) {
			return tarifa.calcularTotalTarifa(lecturaAltaAnterior.getConsumoHsPico() - lecturaAlta.getConsumoHsPico(),
					lecturaAltaAnterior.getConsumoHsResto() - lecturaAlta.getConsumoHsResto(),
					lecturaAltaAnterior.getConsumoHsValle() - lecturaAlta.getConsumoHsValle());
		}
		
		public float calcularConsumoBaja(Baja lecturaBaja, Baja lecturaBajaAnterior, TarifaBaja tarifa) {
			return tarifa.calcularTotalTarifa(lecturaBaja.getConsumo() - lecturaBajaAnterior.getConsumo());
		}

		public float generarTotal(Medidor medidor,List<Lectura> lect)throws Exception { 
			float total = 0;
			if (lect.size() > 1) {
				if (lect.get(lect.size() - 1) instanceof Alta) {
					total = calcularConsumoAlta((Alta) lect.get(lect.size() - 1), (Alta) lect.get(lect.size() - 2),
							(TarifaAlta) medidor.getTarifa());
					
				} else {
					total = calcularConsumoBaja((Baja) lect.get(lect.size() - 1), (Baja) lect.get(lect.size() - 2),
							(TarifaBaja) medidor.getTarifa());
				}
			}else {
				throw new Exception ("No hay suficientes Lecturas para generar el Total");
			}
		return total;
		}
			
		public Factura generarFactura(Medidor medidor) throws Exception{		
			List<Lectura> lect = this.traerLecturas(medidor);
			
			
			Factura fac = new traerPeriodoMes(Factura(lect.get(lect.size()-1).getFecha()),,,generarTotal(medidor,lect),medidor.getNroSerie(),traerCliente(medidor.getCliente().getNroCliente()));
		return fac;
		}
		
		

}
