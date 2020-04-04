package logic;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
//hola
public abstract class Personal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String id; 
	protected String cedula;
	protected String name; 
	protected String apellido; 
	protected String sexo; 
	protected String nacionalidad;
	protected String provincia;
	protected String ciudad;
	protected String sector;
	protected String calle;
	protected int numeroCasa;
	protected String referencia;
	protected ArrayList<String> idiomas;
	protected LocalDate fechaN;
	protected String telefono;
	protected String correo;
	protected int yearExperiencia;
	protected boolean vehiculo;
	protected int categoriaLicencia;
	protected boolean dispViajar;
	protected boolean mudarse;
	protected boolean contratado;
	//protected String estudiosComplementarios;
	protected LocalDate fechaContratado;
	protected long edad;
	protected String estadoCivil;
	
	public Personal(String cedula, String name, String apellido, String sexo, String nacionalidad, String provincia,
			String ciudad, String sector, String calle, int numeroCasa, String referencia, LocalDate fechaN, String telefono, String correo, int yearExperiencia, boolean vehiculo,
			int categoriaLicencia, boolean dispViajar, boolean mudarse, boolean contratado, String estadoCivil) {
		super();
		this.cedula = cedula;
		this.name = name;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.sector = sector;
		this.calle = calle;
		this.numeroCasa = numeroCasa;
		this.referencia = referencia;
		idiomas = new ArrayList<String>();
		this.fechaN = fechaN;
		this.telefono = telefono;
		this.correo = correo;
		this.yearExperiencia = yearExperiencia;
		this.vehiculo = vehiculo;
		this.categoriaLicencia = categoriaLicencia;
		this.dispViajar = dispViajar;
		this.mudarse = mudarse;
		this.contratado = contratado;
		this.estadoCivil = estadoCivil;
		//this.estudiosComplementarios = estudiosComplementarios;
	}
	
	abstract void insertarIdioma(String aux);

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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
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

	/*public String getEstudiosComplementarios() {
		return estudiosComplementarios;
	}

	public void setEstudiosComplementarios(String estudiosComplementarios) {
		this.estudiosComplementarios = estudiosComplementarios;
	}*/

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

	public int getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public void setCategoriaLicencia(int categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}

	public LocalDate getFechaN() {
		return fechaN;
	}

	public void setFechaN(LocalDate fechaN) {
		this.fechaN = fechaN;
	}

	public long getEdad() {
		setEdadSolicitante();
		return edad;
	}

	
	public void setEdad(long edad) {
		this.edad = edad;
	}
	
	
	public int setEdadSolicitante() {
		LocalDate now = LocalDate.now();
		Period periodo = Period.between(fechaN, now);
		int edad = periodo.getYears();
		setEdad(edad);
		return edad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	
	
	
	

}
