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
	
	
	
	
	
	

	
	
	 //Personal 
	
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
	
	//Modificar solicitante
	public void modificarSolicitante(Personal solicitante) {
		
		
	}
	
}
