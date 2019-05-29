package test;
import model.*;

public class TestCliente {
	public static void main(String[] args) {
		SistemaElectrico se = new SistemaElectrico();
		float numereo = se.generarTotal(se.traerMedidor(12345678));
		/*
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
		 */
	}
}
