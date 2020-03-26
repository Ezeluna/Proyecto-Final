package logic;

public class SolicitudUniversitario extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private String carrera;
	private boolean postGrado;

	public SolicitudUniversitario(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String direccion,
			int edadMax, int edadMin, int yearExperience, String jornadaLaboral, boolean presencial,
			String tipoContrato, boolean vehiculoPropio, int categoriaLicencia, boolean mudarse, String carrera, boolean postGrado) {
		super(id, cantVacantes, cantSolicitudes, empresa, direccion, edadMax, edadMin, yearExperience, jornadaLaboral,
				presencial, tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
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
