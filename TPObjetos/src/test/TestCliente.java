package test;
import model.*;

public class TestCliente {
	public static void main(String[] args) {
		Zona zona1 = new Zona(1, "Lomas de Zamora");
		SistemaElectrico se = new SistemaElectrico();
		try {
		/*Alta alta1 = new Alta();
		Baja baja1= new Baja();
		Cliente cliente1 = new ClienteFisico();
		Cliente cliente2 = new ClinteJuridico();
		DetalleAlta detalleAlta1 = new DetalleAlta();
		DetalleBaja detalleBaja1 = new DetalleBaja();
		Factura factura1 = new Factura();
		Inspector inspector1 = new Inspector();
		Lectura lectura1 = new Lectura();
		Medidor medidor1= new Medidor();
		Tarifa tarifa1 = new Tarifa();
		TarifaAlta tarifaAlta1 = new TarifaAlta();
		TarifaBaja tarifaBaja1 = new TarifaBaja();*/
			
		
		
		//-----Agregando clientes------

		se.agregarCliente(zona1, "Martin","Noy",41142737);
		se.agregarCliente(zona1, "Franco","Ribas",14502662);
		System.out.println(se.getclientes());
		
		
		/*
		DatosPersonales datosPersonales1Mod = new DatosPersonales("Julian", "Verdirame", 40473888);
		se.modificarCliente(datosPersonales1, datosPersonales1Mod);
		System.out.println(se.getclientes());
		
		DatosPersonales datosPersonales2Mod = new DatosPersonales("Lucas", "Rodriguez", 41473978);
		se.modificarCliente(datosPersonales2, datosPersonales2Mod);
		System.out.println(se.getclientes());
		
		DatosPersonales datosPersonales3Mod = new DatosPersonales("Braian", "Niseggi", 42451985);
		se.modificarCliente(datosPersonales3, datosPersonales3Mod);
		System.out.println(se.getclientes());
		
		*/
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
