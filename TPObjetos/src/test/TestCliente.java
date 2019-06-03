

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
		//-----Agregando Medidor------
		try {
			se.agregarMedidor("Alcorta310", true, 41142737, se.traerTarifaBaja("baja"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//-----Agregando Tarifas------
		try {
			se.agregarTarifa("Baja");
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

		se.agregarCliente("Lanus", "Martin","Noy",41142737);
		se.agregarCliente("Lanus", "Franco","Ribas",14502662);
		se.agregarCliente("Burzaco", "Julian", "Verdirame", 40256894);
		
		System.out.println(se.getclientes());
		
		//-----modificado clientes------
		
		se.modificarCliente(41142737, "Oscar", "Noy", 41142736);
		System.out.println(se.getclientes());
		
		//-----eliminar clientes------
		se.eliminarCliente(41142736);
		System.out.println(se.getclientes());
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//-----Agregando Inspector------
		
		se.agregarIspector("Julian", "Verdirame", 14023748, "Lanus");
		
		try {
			se.agregarLectura(fecha1, hora, 14023748, 1, 100);
			se.agregarLectura(fecha2, hora, 14023748, 1, 210);
			se.agregarLectura(fecha3, hora, 14023748, 1, 620);
			se.agregarLectura(fecha4, hora, 14023748, 1, 930);
			
			System.out.println(se.traerLectura(fecha1, 1).toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
