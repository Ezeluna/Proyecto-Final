package logic;

import java.util.ArrayList;

public class Bachiller extends Personal {
	private ArrayList<String> habilidades;

	public Bachiller(String id, String cedula, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, ArrayList<String> idiomas, String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios) {
		super(id, cedula, name, apellido, sexo, nacionalidad, ciudad, direccion, idiomas, fechaNacimiento, telefono, correo,
				yearExperiencia, vehiculo, licencia, dispViajar, mudarse, contratado, estudiosComplementarios);
		// TODO Auto-generated constructor stub
		
	   this.habilidades = new ArrayList<>();
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	

	//Probando
}
