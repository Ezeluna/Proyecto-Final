package logic;

import java.time.LocalDate;
import java.util.ArrayList;

//probando
public class Bachiller extends Personal {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> habilidades;

	public Bachiller(String cedula, String name, String apellido, String sexo, String nacionalidad,  String provincia,
			String ciudad, String sector, String calle, int numeroCasa, String referencia, LocalDate fechaN, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, int categoriaLicencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estadoCivil, ArrayList<String> habilidades) {
		super(cedula, name, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaN, telefono, correo,
				yearExperiencia, vehiculo, categoriaLicencia, dispViajar, mudarse, contratado, estadoCivil);
		// TODO Auto-generated constructor stub
		
	   this.habilidades = new ArrayList<>();
	   for (String habili : habilidades) {
			this.habilidades.add(habili);
			
		}
	}
	
	@Override
	void insertarIdioma(String aux){
		idiomas.add(aux); 
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	

	//Probando
}
