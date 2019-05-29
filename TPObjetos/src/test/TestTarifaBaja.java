package test;

import model.SistemaElectrico;

public class TestTarifaBaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaElectrico se = new SistemaElectrico();
		try {
		se.agregarTarifa("Tarifa_ejemplo");
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 0, 150, 32.82);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 0, 150, 2.653);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 151, 325, 56.11);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 151, 325, 2.651);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 326, 400, 91.73);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 326, 400, 2.705);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 401, 450, 107.34);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 401, 450, 2.758);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 450, 500, 161.66);		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 450, 500, 2.864);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 501, 600, 316.00);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 501, 600, 2.918);
		
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Fijo", "$/mes", 601, 700, 850.24);
		se.traerTarifaBaja("Tarifa_ejemplo").agregarDetalle("Cargo Variable", "$/kWh", 0, 150, 3.309);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
