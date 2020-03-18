package logic;

import java.util.ArrayList;

public class solicitudPersona {
	
	private String id; 
	private String gradoAcademico; 
	private String actividadProfesional; 
	private String nacionalidad;
	private String direccion; 
	private ArrayList<String> idiomas; 
	private String jornadaLab; 
	private boolean presencial; 
	private String tipoContrato; 
	private int yearExperience; 
	private boolean mudarse; 
	private boolean vehiculoPropio; 
	private int categLicencia;
	
	public solicitudPersona(String id, String gradoAcademico, String actividadProfesional, String nacionalidad,
			String direccion, ArrayList<String> idiomas, String jornadaLab, boolean presencial, String tipoContrato,
			int yearExperience, boolean mudarse, boolean vehiculoPropio, int categLicencia) {
		super();
		this.id = id;
		this.gradoAcademico = gradoAcademico;
		this.actividadProfesional = actividadProfesional;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.idiomas = idiomas;
		this.jornadaLab = jornadaLab;
		this.presencial = presencial;
		this.tipoContrato = tipoContrato;
		this.yearExperience = yearExperience;
		this.mudarse = mudarse;
		this.vehiculoPropio = vehiculoPropio;
		this.categLicencia = categLicencia;
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

	public String getJornadaLab() {
		return jornadaLab;
	}

	public void setJornadaLab(String jornadaLab) {
		this.jornadaLab = jornadaLab;
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

	public int getYearExperience() {
		return yearExperience;
	}

	public void setYearExperience(int yearExperience) {
		this.yearExperience = yearExperience;
	}

	public boolean isMudarse() {
		return mudarse;
	}

	public void setMudarse(boolean mudarse) {
		this.mudarse = mudarse;
	}

	public boolean isVehiculoPropio() {
		return vehiculoPropio;
	}

	public void setVehiculoPropio(boolean vehiculoPropio) {
		this.vehiculoPropio = vehiculoPropio;
	}

	public int getCategLicencia() {
		return categLicencia;
	}

	public void setCategLicencia(int categLicencia) {
		this.categLicencia = categLicencia;
	} 
	
	
	
	
	

}
