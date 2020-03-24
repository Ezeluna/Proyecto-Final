package logic;

import java.util.ArrayList;

public abstract class Solicitud {
	
	protected String id; 
	protected int cantVacantes;
	protected int cantSolicitudes;
	protected Empresa empresa;  
	protected String direccion; 
	protected ArrayList<String> idiomas; 
	protected int edadMax; 
	protected int edadMin; 
	protected int yearExperience; 
	protected String jornadaLaboral; 
	protected boolean presencial; 
	protected String tipoContrato; 
	protected boolean vehiculoPropio; 
	protected int categoriaLicencia; 
	protected boolean mudarse;
	
	public Solicitud(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String direccion, int edadMax, 
			int edadMin, int yearExperience, String jornadaLaboral,boolean presencial, String tipoContrato, boolean vehiculoPropio, 
			int categoriaLicencia, boolean mudarse) {
		super();
		this.id = id;
		this.cantVacantes = cantVacantes;
		this.cantSolicitudes = 0;
		this.empresa = empresa;
		this.direccion = direccion;
		idiomas = new ArrayList<>(); 
		this.edadMax = edadMax;
		this.edadMin = edadMin;
		this.yearExperience = yearExperience;
		this.jornadaLaboral = jornadaLaboral;
		this.presencial = presencial;
		this.tipoContrato = tipoContrato;
		this.vehiculoPropio = vehiculoPropio;
		this.categoriaLicencia = categoriaLicencia;
		this.mudarse = mudarse;
		
	}
	
	abstract void insertarIdioma(String aux);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantVacantes() {
		return cantVacantes;
	}

	public void setCantVacantes(int cantVacantes) {
		this.cantVacantes = cantVacantes;
	}

	public int getCantSolicitudes() {
		return cantSolicitudes;
	}

	public void setCantSolicitudes(int cantSolicitudes) {
		this.cantSolicitudes = cantSolicitudes;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	
	public void IncrementarCantSolicitudes() {
		cantSolicitudes++;
	}
	
	

}
