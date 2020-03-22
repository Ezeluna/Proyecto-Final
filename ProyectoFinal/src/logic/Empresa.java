package logic;

import java.util.ArrayList;
import java.time.LocalDate;

public class Empresa {
	private String RNC;
	private String nombre;
	private String telefono;
	private String ciudad;
	private String direccion;
	private String area; 
	private String email;
	private ArrayList<Personal> misEmpleadosC;
	
	public Empresa(String RNC, String nombre, String telefono, String ciudad, String direccion, String area, String email) {
		super();
		this.RNC = RNC;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.area = area; 
		this.email = email;
		this.misEmpleadosC = new ArrayList<>();
	}

	public String getRNC() {
		return RNC;
	}

	public void setRNC(String RNC) {
		this.RNC = RNC;
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

	/*public void setMisEmpleadosC(ArrayList<Personal> misEmpleadosC) {
		this.misEmpleadosC = misEmpleadosC;
	}*/
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	//Función para agregar un empleado contratado
	public void insertarEmpleadoC(Personal empleadoC) {
		LocalDate date = LocalDate.now();
		empleadoC.setFechaContratado(date);
		empleadoC.setContratado(true);
		misEmpleadosC.add(empleadoC);
	}
	
	//Probando

}
