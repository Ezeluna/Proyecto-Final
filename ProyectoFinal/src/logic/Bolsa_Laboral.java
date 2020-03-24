package logic;

import java.util.ArrayList;



public class Bolsa_Laboral {
	
	private ArrayList<Personal> misSolicitantes; 
	private ArrayList<Empresa> misEmpresas; 
	private ArrayList<solicitudEmpresa> reqEmpresas; 
	private ArrayList<solicitudPersona> reqPersona;
	public static Bolsa_Laboral bolsa;  
	
	// CONSTRUCTOR
	
	public Bolsa_Laboral() {
		super();
		this.misSolicitantes = new ArrayList<>(); 
		this.misEmpresas = new ArrayList<>(); 
		this.reqEmpresas = new ArrayList<>(); 
		this.reqPersona = new ArrayList<>(); 
		
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

	public ArrayList<solicitudEmpresa> getReqEmpresas() {
		return reqEmpresas;
	}

	public void setReqEmpresas(ArrayList<solicitudEmpresa> reqEmpresas) {
		this.reqEmpresas = reqEmpresas;
	}

	public ArrayList<solicitudPersona> getReqPersona() {
		return reqPersona;
	}

	public void setReqPersona(ArrayList<solicitudPersona> reqPersona) {
		this.reqPersona = reqPersona;
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
				solicitante.setFechaNacimiento(solicit.getFechaNacimiento());
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
	
	public void contratarEmpleados(solicitudEmpresa solicitud, ArrayList<Personal> empleados) {// Contratar empleado

		Empresa empresa = solicitud.getEmpresa();
		for (Personal solicitante : empleados) {
			solicitud.IncrementarCantSolicitudes();;
			empresa.insertarEmpleadoC(solicitante);;
		}

	}
	
	// SOLICITUD EMPRESA
	
	public void insertSolicitud(solicitudEmpresa pSolicitud) {// Agregar una solicitud al arraylist
		reqEmpresas.add(pSolicitud);
	}

	public boolean buscarSolicitud(solicitudEmpresa pSolicitud) {// Devuelve un boolean si el solicitante existe
		boolean find = false;
		if (reqEmpresas.contains(pSolicitud)) {
			find = true;
		}
		return find;
	}
	
	public int cantSoliB(String rnc) {// Retorna cantidad de solicitudes de obreros por una empresa
		int cant = 0;
		for (solicitudEmpresa soli : reqEmpresas) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli.getGradoAcademico().equalsIgnoreCase("Bachiller")) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public int cantSoliT(String rnc) {// Retorna cantidad de solicitudes de tecnicos por una empresa
		int cant = 0;
		for (solicitudEmpresa soli : reqEmpresas) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli.getGradoAcademico().equalsIgnoreCase("Tecnico")) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public int cantSoliU(String rnc) {// Retorna cantidad de solicitudes de tecnicos por una empresa
		int cant = 0;
		for (solicitudEmpresa soli : reqEmpresas) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli.getGradoAcademico().equalsIgnoreCase("Universitario")) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public solicitudEmpresa RetornarSolocitudCod(String id) {// Retornar Solicitud de una empresa pansando su codigo
		solicitudEmpresa miSolicitud = null;
		for (solicitudEmpresa solicitud : reqEmpresas) {
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
	
	public ArrayList<solicitudEmpresa> RetornaSolicitudEmp(Empresa emp) {// Retorna todas las solicitudes de una empresa
		ArrayList<solicitudEmpresa> solicitudes = new ArrayList<solicitudEmpresa>();
		for (solicitudEmpresa solicitud : reqEmpresas) {
			if (solicitud.getEmpresa().getRNC().equalsIgnoreCase(emp.getRNC())) {
				solicitudes.add(solicitud);
			}

		}
		return solicitudes;
	}
	
	public boolean EliminarSolicitud(String id) {// borra una solicitud de empresa pasando su id
		boolean eliminar = false;
		solicitudEmpresa SolicitudEliminar = null;
		for (solicitudEmpresa soli : reqEmpresas) {
			if (soli.getId().equalsIgnoreCase(id)) {
				SolicitudEliminar = soli;
				eliminar = true;
			}

		}
		reqEmpresas.remove(SolicitudEliminar);
		return eliminar;
	}
	
	// SOLICITUD PERSONAL
	
	


}
