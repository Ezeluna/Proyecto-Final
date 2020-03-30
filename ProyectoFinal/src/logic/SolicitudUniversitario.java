package logic;

import java.util.ArrayList;

public class SolicitudUniversitario extends Solicitud {
	//ctt
	private static final long serialVersionUID = 1L;
	private String carrera;
	private boolean postGrado;

	public SolicitudUniversitario(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String localidad,
			int edadMax, int edadMin, int yearExperience, 
			String tipoContrato, boolean vehiculoPropio, int categoriaLicencia, boolean mudarse, ArrayList<String> habilidades) {
		super(id, cantVacantes, cantSolicitudes, empresa, localidad, edadMax, edadMin, yearExperience,
				tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
		this.carrera = carrera; 
		this.postGrado = postGrado; 
	}

	@Override
	void insertarIdioma(String aux) {
		idiomas.add(aux); 
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public boolean isPostGrado() {
		return postGrado;
	}

	public void setPostGrado(boolean postGrado) {
		this.postGrado = postGrado;
	}
	
	

}
