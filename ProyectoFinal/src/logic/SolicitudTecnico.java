package logic;

public class SolicitudTecnico extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private String area; 

	public SolicitudTecnico(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String direccion,
			int edadMax, int edadMin, int yearExperience, String jornadaLaboral, boolean presencial,
			String tipoContrato, boolean vehiculoPropio, int categoriaLicencia, boolean mudarse, String area) {
		super(id, cantVacantes, cantSolicitudes, empresa, direccion, edadMax, edadMin, yearExperience, jornadaLaboral,
				presencial, tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
		this.area = area;
	}

	@Override
	void insertarIdioma(String aux) {
		idiomas.add(aux); 
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	

}
