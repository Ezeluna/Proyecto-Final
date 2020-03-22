package logic;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Personal {
	
	protected String id; 
	protected String cedula;
	protected String name; 
	protected String apellido; 
	protected String sexo; 
	protected String nacionalidad;
	protected String ciudad;
	protected String direccion;
	protected ArrayList<String> idiomas;
	protected String fechaNacimiento;
	protected String telefono;
	protected String correo;
	protected int yearExperiencia;
	protected boolean vehiculo;
	protected boolean licencia;
	protected boolean dispViajar;
	protected boolean mudarse;
	protected boolean contratado;
	protected String estudiosComplementarios;
	protected LocalDate fechaContratado;
	
	public Personal(String cedula, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, /*ArrayList<String> idiomas,*/ String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios) {
		super();
		this.cedula = cedula;
		this.name = name;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.ciudad = ciudad;
		this.direccion = direccion;
		//this.idiomas = idiomas;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.yearExperiencia = yearExperiencia;
		this.vehiculo = vehiculo;
		this.licencia = licencia;
		this.dispViajar = dispViajar;
		this.mudarse = mudarse;
		this.contratado = contratado;
		this.estudiosComplementarios = estudiosComplementarios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getYearExperiencia() {
		return yearExperiencia;
	}

	public void setYearExperiencia(int yearExperiencia) {
		this.yearExperiencia = yearExperiencia;
	}

	public boolean isVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(boolean vehiculo) {
		this.vehiculo = vehiculo;
	}

	public boolean isLicencia() {
		return licencia;
	}

	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}

	public boolean isDispViajar() {
		return dispViajar;
	}

	public void setDispViajar(boolean dispViajar) {
		this.dispViajar = dispViajar;
	}

	public boolean isMudarse() {
		return mudarse;
	}

	public void setMudarse(boolean mudarse) {
		this.mudarse = mudarse;
	}

	public boolean isContratado() {
		return contratado;
	}

	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}

	public String getEstudiosComplementarios() {
		return estudiosComplementarios;
	}

	public void setEstudiosComplementarios(String estudiosComplementarios) {
		this.estudiosComplementarios = estudiosComplementarios;
	}

	public LocalDate getFechaContratado() {
		return fechaContratado;
	}

	public void setFechaContratado(LocalDate fechaContratado) {
		this.fechaContratado = fechaContratado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	//Probando
	
	
	
	
	

}
