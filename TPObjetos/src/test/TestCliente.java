

package test;
import java.time.LocalDate;
import java.time.LocalTime;

import model.*;

public class TestCliente {
	public static void main(String[] args) {
		SistemaElectrico se = new SistemaElectrico();
		LocalDate fecha1= LocalDate.of(2018, 04, 01);
		LocalDate fecha2= LocalDate.of(2018, 05, 01);
		LocalDate fecha3= LocalDate.of(2018, 06, 01);
		LocalDate fecha4= LocalDate.of(2018, 07, 01);
		
		LocalTime hora = LocalTime.of(12,05);
		
		
		//-----Agregando Tarifas------
		try {
			System.out.println("-------------------------Tarifas------------------------");
			se.agregarTarifa(
					"Baja");
			se.traerTarifaBaja("Baja").agregarDetalle();

			System.out.println(se.traerTarifaBaja("Baja").getLstDetalle());
		//float numereo = se.generarTotal(se.traerMedidor(12345678));
			
			se.agregarTarifa("Alta", "BT<300kW", 300, 3226.41, 2.260, 2.160, 2.061 );
			se.agregarTarifa("Alta", "MT<300kW", 300, 3226.09, 2.148, 2.053, 1.959 );
			se.agregarTarifa("Alta", "AT<300kW", 300, 3224.11, 2.060, 1.969, 1.879 );
			se.agregarTarifa("Alta", "BT>300kW", 300, 3226.41, 3.286, 3.138, 2.990 );
			se.agregarTarifa("Alta", "MT>300kW", 300, 3226.09, 3.123, 2.983, 2.841 );
			se.agregarTarifa("Alta", "AT>300kW", 300, 3224.11, 2.995, 2.860, 2.725 );
			
			System.out.println(se.traerTarifaAlta("Alta").getLstDetalle());
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//-----Fin Tarifas------
		
		
		
		try {

		//-----Agregando clientes------
			System.out.println("-------------------------Clientes------------------------");

		se.agregarCliente("Lanus", "Martin","Noy",00000001);
		se.agregarCliente("Lanus", "Franco","Ribas",00000002);
		se.agregarCliente("Burzaco", "Julian", "Verdirame",00000003);
		se.agregarCliente("Lanus", "Jose","Perez",00000004);
		se.agregarCliente("Lanus", "Braian","niseggi",00000005);
		se.agregarCliente("Burzaco", "Noely", "fernandez", 00000006);		
		se.agregarCliente("Lanus", "Monica","martinez",00000007);		
		se.agregarCliente("Lanus", "Alberto","rey",00000021);		
		se.agregarCliente("Burzaco", "Luciana", "mancilla", 00000022);		
		se.agregarCliente("Burzaco", "Ivan", "sosa", 00000010);		
		se.agregarCliente("Lanus", "Solange","Colman",00000011);		
		se.agregarCliente("Lanus", "Nicolas","Zappia",00000012);		
		se.agregarCliente("Burzaco", "Julian", "Rosalbo", 00000013);		
		se.agregarCliente("Lanus", "Emiliano","Sanchez",00000014);		
		se.agregarCliente("Lanus", "Maria","pizzano",00000015);		
		se.agregarCliente("Burzaco", "Andrea", "Martinez", 00000016);		
		se.agregarCliente("Lanus", "Melina","Baustian",00000017);		
		se.agregarCliente("Lanus", "Carlos","Carpi",00000023);
		se.agregarCliente("Burzaco", "Santiago", "Marchese", 00000024);
		se.agregarCliente("Burzaco", "Martin", "Molina", 00000020);
		System.out.println(se.getclientes());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//-----Agregando Medidor------
				try {
					System.out.println("-------------------------Medidores------------------------");
					se.agregarMedidor("Alcorta310", true, 00000001, "Baja");
					se.agregarMedidor("Alcorta311", true, 00000002, "Baja");
					se.agregarMedidor("Alcorta312", true, 00000003, "Baja");
					se.agregarMedidor("Alcorta313", true, 00000004, "Baja");
					se.agregarMedidor("Alcorta314", true, 00000005, "Baja");
					se.agregarMedidor("Alcorta315", true, 00000006, "Baja");
					se.agregarMedidor("Alcorta316", true, 00000007, "Baja");
					se.agregarMedidor("Alcorta317", true, 00000021, "Baja");
					se.agregarMedidor("Alcorta318", true, 00000022, "Baja");
					se.agregarMedidor("Alcorta319", true, 00000010, "Baja");
					se.agregarMedidor("Alcorta320", true, 00000011, "Baja");
					se.agregarMedidor("Alcorta321", true, 00000012, "Baja");
					se.agregarMedidor("Alcorta322", true, 00000013, "Baja");
					se.agregarMedidor("Alcorta323", true, 00000014, "Baja");
					se.agregarMedidor("Alcorta324", true, 00000015, "Baja");
					se.agregarMedidor("Alcorta325", true, 00000016, "Baja");
					se.agregarMedidor("Alcorta326", true, 00000017, "Baja");
					se.agregarMedidor("Alcorta327", true, 00000023, "Baja");
					se.agregarMedidor("Alcorta328", true, 00000024, "Baja");
					se.agregarMedidor("Alcorta329", true, 00000020, "Baja");
					System.out.println(se.getmedidores());
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
		//-----Agregando Inspector------
		System.out.println("-------------------------Inspectores------------------------");
		se.agregarIspector("Julian", "Verdirame", 14023748, "Lanus");
		
		//-----Agregando Lecturas-------
		
		try {
			System.out.println("-------------------------Lecturas------------------------");
			se.agregarLectura(fecha1, hora, 14023748, 1, 100);
			se.agregarLectura(fecha2, hora, 14023748, 1, 210);
			se.agregarLectura(fecha3, hora, 14023748, 1, 620);
			se.agregarLectura(fecha4, hora, 14023748, 1, 930);
			se.agregarLectura(fecha1, hora, 14023748, 2, 234);
			se.agregarLectura(fecha2, hora, 14023748, 2, 456);
			se.agregarLectura(fecha3, hora, 14023748, 2, 500);
			se.agregarLectura(fecha4, hora, 14023748, 2, 842);
			se.agregarLectura(fecha1, hora, 14023748, 3, 100);
			se.agregarLectura(fecha2, hora, 14023748, 3, 210);
			se.agregarLectura(fecha3, hora, 14023748, 3, 678);
			se.agregarLectura(fecha4, hora, 14023748, 3, 900);
			se.agregarLectura(fecha1, hora, 14023748, 4, 160);
			se.agregarLectura(fecha2, hora, 14023748, 4, 345);
			se.agregarLectura(fecha3, hora, 14023748, 4, 765);
			se.agregarLectura(fecha4, hora, 14023748, 4, 823);
			se.agregarLectura(fecha1, hora, 14023748, 5, 265);
			se.agregarLectura(fecha2, hora, 14023748, 5, 474);
			se.agregarLectura(fecha3, hora, 14023748, 5, 794);
			se.agregarLectura(fecha4, hora, 14023748, 5, 823);
			se.agregarLectura(fecha1, hora, 14023748, 6, 214);
			se.agregarLectura(fecha2, hora, 14023748, 6, 314);
			se.agregarLectura(fecha3, hora, 14023748, 6, 543);
			se.agregarLectura(fecha4, hora, 14023748, 6, 654);
			se.agregarLectura(fecha1, hora, 14023748, 7, 455);
			se.agregarLectura(fecha2, hora, 14023748, 7, 766);
			se.agregarLectura(fecha3, hora, 14023748, 7, 998);
			se.agregarLectura(fecha4, hora, 14023748, 7, 1200);
			se.agregarLectura(fecha1, hora, 14023748, 8, 123);
			se.agregarLectura(fecha2, hora, 14023748, 8, 442);
			se.agregarLectura(fecha3, hora, 14023748, 8, 634);
			se.agregarLectura(fecha4, hora, 14023748, 8, 972);
			se.agregarLectura(fecha1, hora, 14023748, 9, 231);
			se.agregarLectura(fecha2, hora, 14023748, 9, 555);
			se.agregarLectura(fecha3, hora, 14023748, 9, 734);
			se.agregarLectura(fecha4, hora, 14023748, 9, 987);
			se.agregarLectura(fecha1, hora, 14023748, 10, 213);
			se.agregarLectura(fecha2, hora, 14023748, 10, 466);
			se.agregarLectura(fecha3, hora, 14023748, 10, 800);
			se.agregarLectura(fecha4, hora, 14023748, 10, 1123);
			se.agregarLectura(fecha1, hora, 14023748, 11, 453);
			se.agregarLectura(fecha2, hora, 14023748, 11, 899);
			se.agregarLectura(fecha3, hora, 14023748, 11, 1241);
			se.agregarLectura(fecha4, hora, 14023748, 11, 1400);
			se.agregarLectura(fecha1, hora, 14023748, 12, 178);
			se.agregarLectura(fecha2, hora, 14023748, 12, 400);
			se.agregarLectura(fecha3, hora, 14023748, 12, 550);
			se.agregarLectura(fecha4, hora, 14023748, 12, 777);
			se.agregarLectura(fecha1, hora, 14023748, 13, 154);
			se.agregarLectura(fecha2, hora, 14023748, 13, 356);
			se.agregarLectura(fecha3, hora, 14023748, 13, 678);
			se.agregarLectura(fecha4, hora, 14023748, 13, 945);
			se.agregarLectura(fecha1, hora, 14023748, 14, 231);
			se.agregarLectura(fecha2, hora, 14023748, 14, 463);
			se.agregarLectura(fecha3, hora, 14023748, 14, 888);
			se.agregarLectura(fecha4, hora, 14023748, 14, 905);
			se.agregarLectura(fecha1, hora, 14023748, 15, 105);
			se.agregarLectura(fecha2, hora, 14023748, 15, 255);
			se.agregarLectura(fecha3, hora, 14023748, 15, 565);
			se.agregarLectura(fecha4, hora, 14023748, 15, 887);
			se.agregarLectura(fecha1, hora, 14023748, 16, 387);
			se.agregarLectura(fecha2, hora, 14023748, 16, 623);
			se.agregarLectura(fecha3, hora, 14023748, 16, 822);
			se.agregarLectura(fecha4, hora, 14023748, 16, 1021);
			se.agregarLectura(fecha1, hora, 14023748, 17, 214);
			se.agregarLectura(fecha2, hora, 14023748, 17, 533);
			se.agregarLectura(fecha3, hora, 14023748, 17, 777);
			se.agregarLectura(fecha4, hora, 14023748, 17, 976);
			se.agregarLectura(fecha1, hora, 14023748, 18, 243);
			se.agregarLectura(fecha2, hora, 14023748, 18, 765);
			se.agregarLectura(fecha3, hora, 14023748, 18, 888);
			se.agregarLectura(fecha4, hora, 14023748, 18, 1234);
			se.agregarLectura(fecha1, hora, 14023748, 19, 334);
			se.agregarLectura(fecha2, hora, 14023748, 19, 566);
			se.agregarLectura(fecha3, hora, 14023748, 19, 843);
			se.agregarLectura(fecha4, hora, 14023748, 19, 1099);
			se.agregarLectura(fecha1, hora, 14023748, 20, 100);
			se.agregarLectura(fecha2, hora, 14023748, 20, 245);
			se.agregarLectura(fecha3, hora, 14023748, 20, 623);
			se.agregarLectura(fecha4, hora, 14023748, 20, 976);
			
			System.out.println(se.traerLectura(fecha1, 2).toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(se.generarTotal(1));			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
