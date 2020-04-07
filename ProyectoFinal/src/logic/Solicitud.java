package logic;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Solicitud implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String id; 
	protected float cantVacantes;
	private float cantAux; 
	protected int cantSolicitudes;
	protected Empresa empresa;  
	protected String localidad; 
	protected int edadMax; 
	protected int edadMin; 
	protected int yearExperience; 
	protected String tipoContrato; 
	protected boolean vehiculoPropio; 
	protected int categoriaLicencia; 
	protected boolean mudarse;
	protected ArrayList<String> idiomas = new ArrayList<>(); ; 
	
	public Solicitud( float cantVacantes, Empresa empresa, String localidad, int edadMax, 
			int edadMin, int yearExperience, String tipoContrato, boolean vehiculoPropio, 
			int categoriaLicencia, boolean mudarse, ArrayList<String> idiomas) {
		super();
		this.cantVacantes = cantVacantes;
		this.cantSolicitudes = 0;
		this.cantAux = 0; 
		this.localidad = localidad; 
		this.empresa = empresa;
		this.edadMax = edadMax;
		this.edadMin = edadMin;
		this.yearExperience = yearExperience;
		this.tipoContrato = tipoContrato;
		this.vehiculoPropio = vehiculoPropio;
		this.categoriaLicencia = categoriaLicencia;
		this.mudarse = mudarse;
		for (String idio : idiomas) {
			this.idiomas.add(idio);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getCantVacantes() {
		return cantVacantes;
	}

	public void setCantVacantes(float cantVacantes) {
		this.cantVacantes = cantVacantes;
	}

	public int getCantSolicitudes() {
		return cantSolicitudes;
	}

	public void setCantSolicitudes(int cantSolicitudes) {
		this.cantSolicitudes = cantSolicitudes;
	}

	public float getCantAux() {
		return cantAux;
	}

	public void setCantAux(float cantAux) {
		this.cantAux = cantAux;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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
	
	public void DecrementoV() {
		cantVacantes--; 
		cantAux++;
	}
	
	

}
