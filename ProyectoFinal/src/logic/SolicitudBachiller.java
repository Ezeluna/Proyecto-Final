package logic;

public class SolicitudBachiller extends Solicitud {

	public SolicitudBachiller(String id, int cantVacantes, int cantSolicitudes, Empresa empresa, String direccion,
			int edadMax, int edadMin, int yearExperience, String jornadaLaboral, boolean presencial,
			String tipoContrato, boolean vehiculoPropio, int categoriaLicencia, boolean mudarse) {
		super(id, cantVacantes, cantSolicitudes, empresa, direccion, edadMax, edadMin, yearExperience, jornadaLaboral,
				presencial, tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		// TODO Auto-generated constructor stub
	}

	@Override
	void insertarIdioma(String aux) {
		// TODO Auto-generated method stub

	}

}
