package logic;

import java.util.ArrayList;
import java.time.LocalDate;

public class Empresa {
	private String RNC;
	private String nombre;
	private String telefono;
	private String ciudad;
	private String direccion;
	private String email;
	private ArrayList<Personal> misEmpleadosC;
	
	public Empresa(String rNC, String nombre, String telefono, String ciudad, String direccion, String email,
			ArrayList<Personal> misEmpleadosC) {
		super();
		RNC = rNC;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.email = email;
		this.misEmpleadosC = misEmpleadosC;
	}

	public String getRNC() {
		return RNC;
	}

	public void setRNC(String rNC) {
		RNC = rNC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Personal> getMisEmpleadosC() {
		return misEmpleadosC;
	}

	public void setMisEmpleadosC(ArrayList<Personal> misEmpleadosC) {
		this.misEmpleadosC = misEmpleadosC;
	}
	
	//Función para agregar un empleado contratado
	public void insertarEmpleadoC(Personal empleadoC) {
		LocalDate date = LocalDate.now();
		empleadoC.setFechaContratado(date);
		empleadoC.setContratado(true);
		misEmpleadosC.add(empleadoC);
	}
	
	

}
