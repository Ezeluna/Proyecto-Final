package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Bolsa_Laboral implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private ArrayList<Personal> misSolicitantes; 
	private ArrayList<Empresa> misEmpresas; 
	private ArrayList<Solicitud> misSolicitudes; 
	private ArrayList<Empresa> misEmpleadosCon;
	public static Bolsa_Laboral bolsa;
	private FileWriter Fwriter; 
	private String archivo = "Bolsa_Laboral.dat"; 
	
	
	
	
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
		String id = getIdSolicitante();
		solicitante.setId(id);;
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
				solicitante.setSector(solicit.getSector());
				solicitante.setCiudad(solicit.getCiudad());
				solicitante.setCorreo(solicit.getCorreo());
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
	
	
    //ELIMINAR VACANTE
	public int eliminarV(Solicitud soli,ArrayList<Personal> empleados) {
		int cant = 0;
		contratarEmpleados(soli, empleados);
		for(int i = 0; i < soli.getCantVacantes(); i++) {
			cant = (int) (soli.getCantVacantes() - misEmpleadosCon.size());
		}
		
		return cant;
	}
	
	// SOLICITUD EMPRESA
	
	public void insertSolicitud(Solicitud solicitud) {// Agregar una solicitud al arraylist
		String id = getIdSolicitud();
		solicitud.setId(id);;
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
	
	public Empresa RetornaEmpresaSoli(String rnc) {// Retorna una solicitud dado el rnc de una empresa
		Empresa empre = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				empre = empresa;
			}

		}
		return empre;

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
	
	public void ActualizarSolicitud(Solicitud modi, Solicitud modificarSoli) {// Actualizar una solicitud cuando se modifica
		int index = 0;
		if (misSolicitudes.contains(modi)) {
			index = misSolicitudes.indexOf(modi);
		}
		misSolicitudes.set(index, modificarSoli);

	}
	
	// PERSONAL SOLICITUD
	
	public int cantSolicitanteUniversitario() {// devuelve cantidad de solicitantes universitarios

		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Universitario) {
				cant++;
			}
		}

		return cant;
	}

	public int cantSolicitanteTecnico() {// devuelve cantidad de solicitantes tecnicos

		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Tecnico) {
				cant++;
			}
		}

		return cant;
	}

	public int cantSolicitanteBachiller() {// devuelve cantidad de solicitantes bachilleres

		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Bachiller) {
				cant++;
			}
		}

		return cant;
	}
	
	public int desempleadoU() {// Retornar cant. Universitarios desempleados
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Universitario) {
					cant++;
				}
			}
		}
		return cant;
	}

	public int desempleadoT() {// Retornar cant. Tecnicos desempleados
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Tecnico) {
					cant++;
				}
			}
		}
		return cant;
	}

	public int desempleadoB() {// Retornar cant. Bachilleres desempleados
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Bachiller) {
					cant++;
				}
			}
		}
		return cant;
	}
	
	public int totalContratado() {// Retorna total de contratados
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (soli.isContratado()) {
				cant++;
			}
		}
		return cant;
	}
	
	
	
	// PORCIENTOS 
	
	public float porcientoSolicitud(Solicitud soli) {// RETORNA EL PORCIENTO DE LAS SOLICITUDES ACTIVAS
		float por = 0;
		if (soli.getCantSolicitudes() != soli.cantVacantes) {
			float cantTotal = soli.getCantVacantes();
			float cantActual = soli.getCantSolicitudes();
			por = (cantActual / cantTotal) * 100;
		} else {
			por = 100;
		}
		return por;
	}
	
	public float porcientoU() {// Retorna % de Universitarios Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}

	public float porcientoT() {// Retorna % de Tecnicos Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}
	
	public float porcientoB() {// Retorna % de Bachilleres Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Bachiller) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}
	
	public float porcientoF() {// Retorna % de Bachilleres femeninos Contratado
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Bachiller) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}
	
	public float porcientoH() {// retorna el % de Bachilleres masculinos contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Bachiller) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
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
			
			if (validarIdiomas(persona, solicitud)) {
				porciento++;
			}
		}

		if (porciento >= 5) {// si se cumple el 70%
			valido = true;
		}

		return valido;
	}
	
	// VALIDACION DE IDIOMAS
	
	public boolean validarIdiomas(Personal persona, Solicitud soli) {
		boolean aux = false;
		if (soli.idiomas.size() == 0) {
			aux = true;
		}
		for (String idiomas : soli.getIdiomas()) {
			if (persona.getIdiomas().contains(idiomas)) {
				aux = true;
			} else {
				aux = false;
				break;

			}
		}

		return aux;
	}
	
	// VALIDACION BACHILLER SOL
		private boolean ValidarBachiller(Personal solicitante, Solicitud solicitud) {
			boolean validar = false;
			for (String habilidadBachiller : ((SolicitudBachiller) solicitud).getHabilidades()) {
				if (((Bachiller) solicitante).getHabilidades().contains(habilidadBachiller)) {
					validar = true;
				} else {
					validar = false;
					break;
				}
			}

			return validar;
		}
	
	// VALIDACION TECNICO SOL
	private boolean ValidarTecnico(Personal solicitante, Solicitud soli) {
		boolean validar = false;
		if (((Tecnico) solicitante).getArea().equalsIgnoreCase(((SolicitudTecnico) soli).getArea())) {
			validar = true;
		}
		return validar;
	}

	// VALIDACION UNIVERSITARIO SOL
	private boolean validarUniversitario(Personal solicitante, Solicitud soli) {
		boolean validar = false;
		if (((Universitario) solicitante).getCarrera().equalsIgnoreCase(((SolicitudUniversitario) soli).getCarrera())) {
			validar = true;
			if (!((Universitario) solicitante).isPostGrado() && ((SolicitudUniversitario) soli).isPostGrado()) {
				validar = false;
			}

		}
		return validar;
	}
	
	// VALIDACION CORREO
	public boolean validarCorreo(String correo) {
		Pattern patt = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patt.matcher(correo);
			if (!match.find()) {
				return true;
			} else {
				return false;
			}
		}
	
	// MATCHEO GENERAL
	public ArrayList<Personal> matcheo(Solicitud soli) {

		ArrayList<Personal> candidato = new ArrayList<>();
		if (soli instanceof SolicitudBachiller) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Bachiller) {
					if (validarGeneral(solicitante, soli)) {
						if (ValidarBachiller(solicitante, soli)) {
							candidato.add(solicitante);
							

						}
					}
				}
			}

		}

		if (soli instanceof SolicitudTecnico) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Tecnico) {
					if (validarGeneral(solicitante, soli)) {
						if (ValidarTecnico(solicitante, soli)) {
							candidato.add(solicitante);
							
						}

					}
				}
			}
		}
		if (soli instanceof SolicitudUniversitario) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Universitario) {
					if (validarGeneral(solicitante, soli)) {
						if (validarUniversitario(solicitante, soli)) {
							candidato.add(solicitante);
							
						}

					}
				}
			}
		}

		return candidato;
	}
	
	// FICHEROS 
	
	public String getIdSolicitud() { // Generacion de Codigos para solicitud
		String code = "";
		String codigo = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		for (int i = 0; i < 3;) {
			char c = (char) r.nextInt(225);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				code += c;
				i++;
			}

		}
		codigo = "SO" + code;
		return codigo;
	}
	public String getIdSolicitante() {// Generacion de Codigos para solicitantes 
		String code = "";
		String codigo = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		for (int i = 0; i < 3;) {
			char c = (char) r.nextInt(225);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				code += c;
				i++;
			}

		}
		codigo = "S" + code;
		return codigo;
	}
	
	public void writeBolsa() {
		FileOutputStream bolsaFile = null;
		ObjectOutputStream bolsaOut = null;

		try {
			bolsaFile = new FileOutputStream(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bolsaOut = new ObjectOutputStream(bolsaFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bolsaOut.writeObject(bolsa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readBolsa() {
		FileInputStream bolsaFile = null;
		ObjectInputStream bolsaIn = null;
		try {
			bolsaFile = new FileInputStream("Bolsa_Laboral.dat");
			bolsaIn = new ObjectInputStream(bolsaFile);
			try {
				bolsa = (Bolsa_Laboral) bolsaIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
