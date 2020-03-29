package logic;

import java.util.ArrayList;
//hi
public class SolicitudBachiller extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> habilidades; 

	public SolicitudBachiller(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String direccion,
			int edadMax, int edadMin, int yearExperience, String jornadaLaboral, boolean presencial,
			String tipoContrato, boolean vehiculoPropio, int categoriaLicencia, boolean mudarse, ArrayList<String> habilidades) {
		super(id, cantVacantes, cantSolicitudes, empresa, direccion, edadMax, edadMin, yearExperience, jornadaLaboral,
				presencial, tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
		this.habilidades = new ArrayList<>();
		for (String habili : habilidades) {
			this.habilidades.add(habili);
			
		}
	}

	@Override
	void insertarIdioma(String aux) {
		idiomas.add(aux); 
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	
	

}
