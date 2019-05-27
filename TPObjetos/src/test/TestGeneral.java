package test;

import model.*;
import java.util.*;

public class TestGeneral {
	public static void main(String[] args) {
		SistemaElectrico se = new SistemaElectrico();
		Alta alta1 = new Alta();
		Baja baja1= new Baja();
		Cliente cliente1 = new ClienteFisico();
		Cliente cliente2 = new ClinteJuridico();
		DatosPersonales datosPersonales1 = new DatosPersonales();
		DetalleAlta detalleAlta1 = new DetalleAlta();
		DetalleBaja detalleBaja1 = new DetalleBaja();
		Factura factura1 = new Factura();
		Inspector inspector1 = new Inspector();
		Lectura lectura1 = new Lectura();
		Medidor medidor1= new Medidor();
		Tarifa tarifa1 = new Tarifa();
		TarifaAlta tarifaAlta1 = new TarifaAlta();
		TarifaBaja tarifaBaja1 = new TarifaBaja();
		Zona zona1 = new Zona(); //Zona
		
	}

}
