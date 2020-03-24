package logic;

import java.util.ArrayList;







public class Bolsa_Laboral {
	
	private ArrayList<Personal> misSolicitantes; 
	private ArrayList<Empresa> misEmpresas; 
	private ArrayList<Solicitud> misSolicitudes; 
	public static Bolsa_Laboral bolsa;  
	
	// CONSTRUCTOR
	
	public Bolsa_Laboral() {
		super();
		this.misSolicitantes = new ArrayList<>(); 
		this.misEmpresas = new ArrayList<>(); 
		this.misSolicitudes = new ArrayList<>(); 
		
		
	}
	
	// SETTERS Y GETTERS

	public ArrayList<Personal> getMisSolicitantes() {
		return misSolicitantes;
	}

	public void setMisSolicitantes(ArrayList<Personal> misSolicitantes) {
		this.misSolicitantes = misSolicitantes;
	}

	public ArrayList<Empresa> getMisEmpresas() {
		return misEmpresas;
	}

	public void setMisEmpresas(ArrayList<Empresa> misEmpresas) {
		this.misEmpresas = misEmpresas;
	}

	
	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}

	public static Bolsa_Laboral getInstance() {
		if (bolsa == null) {
			bolsa = new Bolsa_Laboral();
		}
		return bolsa;

	}
	
	// EMPRESA
	
	public void insertEmpresa(Empresa empresa) {
		misEmpresas.add(empresa);
	}
	
	public Empresa RetornarEmpresa(String RNC) {// Retornar una Empresa pasando un RNC
		Empresa miEmpresa = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(RNC)) {
				miEmpresa = empresa;
			}

		}
		return miEmpresa;
	}

	public void eliminarEmpresa(String cod) {// Elimina una empresa pasandole el codigo
		Empresa empresaeliminar = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(cod)) {
				empresaeliminar = empresa;
			}
		}
		misEmpresas.remove(empresaeliminar);
	}

	public void modificaEmpresa(Empresa empresa) {// Modifica una empresa que se reciba

		for (Empresa miempresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(miempresa.getRNC())) {
				miempresa.setNombre(empresa.getNombre());
				miempresa.setDireccion(empresa.getDireccion());
				miempresa.setEmail(empresa.getEmail());
				miempresa.setTelefono(empresa.getRNC());
				miempresa.setCiudad(empresa.getCiudad());
			}
		}
	}

	public boolean EmpresaExiste(String rnc) {// Devuelve un boolean si existe una empresa pasando RNC
		boolean existe = false;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				existe = true;
			}
		}
		return existe;

	}
	
	public int CantUCon(String rnc) {// Devuelve la cantidad de Universitarios que contrato una empresa
		int CantconU = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				for (Personal soli : empresa.getMisEmpleadosC()) {
					if (soli instanceof Universitario) {
						CantconU++;
					}
				}
			}
		}
		return CantconU;
	}
	
	public int CantTCon(String rnc) {// Devuelve la cantidad de Tecnicos que contrato una empresa
		int CantconT = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				for (Personal soli : empresa.getMisEmpleadosC()) {
					if (soli instanceof Tecnico) {
						CantconT++;
					}
				}
			}
		}
		return CantconT;
	}
	
	public int CantBCon(String rnc) {// Devuelve la cantidad de Bachilleres que contrato una empresa
		int CantconB = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				for (Personal soli : empresa.getMisEmpleadosC()) {
					if (soli instanceof Bachiller) {
						CantconB++;
					}
				}
			}
		}
		return CantconB;
	}
	

	
	 // PERSONAL
	
	//Insertar un solicitante
	public void insertarSolicitante(Personal solicitante) {
		
		solicitante.setContratado(false);
		misSolicitantes.add(solicitante);
	}
	
	//Buscar solicitante by cedula y retornarlo
	public Personal buscarSolicitanteByCe(String cedula) {
		Personal solici = null;
		
		for(Personal aux : misSolicitantes) {
			if(cedula.equalsIgnoreCase(aux.getCedula())) {
				solici = aux;
			}
		}
		
		return solici;
	}
	
	//Devolver si existe un solicitante
	public boolean SolicitanteExiste(String cedula) {
		boolean existe = false;
		
		for(Personal aux : misSolicitantes) {
			if(cedula.equalsIgnoreCase(aux.getCedula())) {
				existe = true;
			}
		}
		
		return existe;
	}
	
	//Retornar indice del arrayList de misSolicintantes
	public int indiceSolicitante(String id) {
		int indice = 0;
		for(int i = 0; i<misSolicitantes.size(); i++) {
			if(misSolicitantes.get(i).getId().equalsIgnoreCase(id)) {
				indice = i;
			}
		}
		
		return indice;
	}
	
	//Eliminar soclicitante por codigo
	public void eliminarSolicitante(Personal solicitante) {
		int indice = indiceSolicitante(solicitante.getId());
		misSolicitantes.remove(indice);
	}
	
	//Modificar solicitante
	public void modificarSolicitante(Personal solicit) {
		for(Personal solicitante : misSolicitantes ) {
			if(solicit.getCedula().equalsIgnoreCase(solicitante.getCedula())) {//compara la cedula del solicitante que se quiere modificar con la del solicitante que ya se tiene
				solicitante.setName(solicit.getName());
				solicitante.setApellido(solicit.getApellido());
				solicitante.setTelefono(solicit.getTelefono());
				solicitante.setDireccion(solicit.getDireccion());
				solicitante.setCiudad(solicit.getCiudad());
				solicitante.setCorreo(solicit.getCorreo());
				solicitante.setEdad(solicit.getEdad());
			}
		}
	}
	
	public String contradato(Personal soli) {// retorna un boolean si esta contratado o no
		String estado = null;
		if (soli.isContratado()) {
			estado = "Contratado";

		} else {
			estado = "Desempleado";
		}
		return estado;
	}
	
	public String tipoSolicitante(Personal soli) {// retorna el tipo de solicitante
		String solici = null;

		if (soli instanceof Universitario) {
			solici = "Universitario";

		}
		if (soli instanceof Bachiller) {
			solici = "Bachiller";

		}
		if (soli instanceof Tecnico) {
			solici = "Tecnico";

		}

		return solici;

	}
	

	public void removerContratados(ArrayList<Personal> misContratados) {// Quitar las solicitudes de los contratados

		for (Personal contratado : misContratados) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante.isContratado() == false) {
					if (contratado.getCedula().equalsIgnoreCase(solicitante.getCedula())) {
						misSolicitantes.remove(solicitante);
					}
				}
			}
		}
	}
	
	public void contratarEmpleados(Solicitud solicitud, ArrayList<Personal> empleados) {// Contratar empleado

		Empresa empresa = solicitud.getEmpresa();
		for (Personal solicitante : empleados) {
			solicitud.IncrementarCantSolicitudes();;
			empresa.insertarEmpleadoC(solicitante);;
		}

	}
	
	// SOLICITUD EMPRESA
	
	public void insertSolicitud(Solicitud solicitud) {// Agregar una solicitud al arraylist
		misSolicitudes.add(solicitud);
	}

	public boolean buscarSolicitud(Solicitud solicitud) {// Devuelve un boolean si la solicitud existe o no
		boolean find = false;
		if (misSolicitudes.contains(solicitud)) {
			find = true;
		}
		return find;
	}
	
	public int cantSoliB(String rnc) {// Retorna cantidad de solicitudes de bachilleres de una empresa
		int cant = 0;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudBachiller) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public int cantSoliT(String rnc) {// Retorna cantidad de solicitudes de tecnicnos de una empresa
		int cant = 0;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudTecnico) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public int cantSoliU(String rnc) {// Retorna cantidad de solicitudes de universitarios de una empresa
		int cant = 0;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudUniversitario) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public Solicitud RetornarSolocitudId(String id) {// Retornar Solicitud de una empresa pansando su id
		Solicitud miSolicitud = null;
		for (Solicitud solicitud : misSolicitudes) {
			if (solicitud.getId().equalsIgnoreCase(id)) {
				miSolicitud = solicitud;
			}

		}
		return miSolicitud;
	}
	
	public int cantidadSoliEmpresa(Empresa soli) {// retorna cantidad de solicitudes que ha hecho una empresa
		int cant = 0;
		for (Empresa misoli : misEmpresas) {
			if (soli.getRNC().equalsIgnoreCase(misoli.getRNC())) {
				cant++;
			}
		}
		return cant;
	}
	
	public int cantidadSolicitante(Personal soli) {// Retorna cantidad de solicitudes del personal
		int cant = 0;
		for (Personal misoli : misSolicitantes) {
			if (soli.getCedula().equalsIgnoreCase(misoli.getCedula())) {
				cant++;
			}

		}
		return cant;

	}
	
	public ArrayList<Solicitud> RetornaSolicitudEmp(Empresa emp) {// Retorna todas las solicitudes de una empresa
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		for (Solicitud solicitud : misSolicitudes) {
			if (solicitud.getEmpresa().getRNC().equalsIgnoreCase(emp.getRNC())) {
				solicitudes.add(solicitud);
			}

		}
		return solicitudes;
	}
	
	public boolean EliminarSolicitud(String id) {// borra una solicitud de empresa pasando su id
		boolean eliminar = false;
		Solicitud SolicitudEliminar = null;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getId().equalsIgnoreCase(id)) {
				SolicitudEliminar = soli;
				eliminar = true;
			}

		}
		misSolicitudes.remove(SolicitudEliminar);
		return eliminar;
	}
	
	//MATCHING
	
	public boolean validarGeneral(Personal persona, Solicitud solicitud) {// VALIDA AL PERSONAL GENERAL
		int porciento = 0;
		boolean valido = false;
		if (persona.contratado == false) {
			porciento++;

			if (persona.isVehiculo() == solicitud.isVehiculoPropio()) {
				porciento++;
			}
			if (persona.isMudarse() == solicitud.isMudarse()) {
				porciento++;
			}
			if (persona.getCategoriaLicencia() >= solicitud.getCategoriaLicencia()) {
				porciento++;
			}

			if (persona.getYearExperiencia() >= solicitud.getYearExperience()) {
				porciento++;
			}
			if ((persona.getEdad() >= solicitud.getEdadMin()) && (persona.getEdad() <= solicitud.getEdadMax())) {
				porciento++;
			}
		/*	if (validarIdiomas(persona, solicitud)) {
				porciento++;
			}*/
		}

		if (porciento >= 5) {// si se cumple el 70%
			valido = true;
		}

		return valido;
	}
	
	
}
