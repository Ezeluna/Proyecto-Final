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

	public boolean EmpresaExiste(String rnc) {// Devuelve un boolean de si existe una empresa pasando RNC
		boolean existe = false;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				existe = true;
			}
		}
		return existe;

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
}
