package model;

public class DatosPersonales {
	private String nombre;
	private String apellido;
	private long dni;
	
	public DatosPersonales(String nombre, String apellido, long dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public long getDni() {
		return dni;
	}
	
	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni;
	}

	public boolean equals(DatosPersonales datos) {
		// TODO Auto-generated method stub
		return this.dni==datos.dni;
	}
	
	
}
