package logic;

import java.util.ArrayList;

public class solicitudEmpresa {
	
	private String id; 
	private String gradoAcademico; 
	private String actividadProfesional; 
	private String nacionalidad; 
	private String direccion; 
	private ArrayList<String> idiomas; 
	private int edadMax; 
	private int edadMin; 
	private int yearExperience; 
	private String jornadaLaboral; 
	private boolean presencial; 
	private String tipoContrato; 
	private boolean vehiculoPropio; 
	private int categoriaLicencia; 
	private boolean mudarse; 
	private int cantVacantes;
	
	public solicitudEmpresa(String id, String gradoAcademico, String actividadProfesional, String nacionalidad,
			String direccion, ArrayList<String> idiomas, int edadMax, int edadMin, int yearExperience,
			String jornadaLaboral, boolean presencial, String tipoContrato, boolean vehiculoPropio,
			int categoriaLicencia, boolean mudarse, int cantVacantes) {
		super();
		this.id = id;
		this.gradoAcademico = gradoAcademico;
		this.actividadProfesional = actividadProfesional;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.idiomas = idiomas;
		this.edadMax = edadMax;
		this.edadMin = edadMin;
		this.yearExperience = yearExperience;
		this.jornadaLaboral = jornadaLaboral;
		this.presencial = presencial;
		this.tipoContrato = tipoContrato;
		this.vehiculoPropio = vehiculoPropio;
		this.categoriaLicencia = categoriaLicencia;
		this.mudarse = mudarse;
		this.cantVacantes = cantVacantes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGradoAcademico() {
		return gradoAcademico;
	}

	public void setGradoAcademico(String gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public String getActividadProfesional() {
		return actividadProfesional;
	}

	public void setActividadProfesional(String actividadProfesional) {
		this.actividadProfesional = actividadProfesional;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public int getYearExperience() {
		return yearExperience;
	}

	public void setYearExperience(int yearExperience) {
		this.yearExperience = yearExperience;
	}

	public String getJornadaLaboral() {
		return jornadaLaboral;
	}

	public void setJornadaLaboral(String jornadaLaboral) {
		this.jornadaLaboral = jornadaLaboral;
	}

	public boolean isPresencial() {
		return presencial;
	}

	public void setPresencial(boolean presencial) {
		this.presencial = presencial;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public boolean isVehiculoPropio() {
		return vehiculoPropio;
	}

	public void setVehiculoPropio(boolean vehiculoPropio) {
		this.vehiculoPropio = vehiculoPropio;
	}

	public int getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public void setCategoriaLicencia(int categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}

	public boolean isMudarse() {
		return mudarse;
	}

	public void setMudarse(boolean mudarse) {
		this.mudarse = mudarse;
	}

	public int getCantVacantes() {
		return cantVacantes;
	}

	public void setCantVacantes(int cantVacantes) {
		this.cantVacantes = cantVacantes;
	} 
	
	
	
	

}
