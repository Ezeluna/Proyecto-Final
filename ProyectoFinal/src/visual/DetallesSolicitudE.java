package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import logic.Solicitud;
import logic.SolicitudBachiller;
import logic.SolicitudTecnico;
import logic.SolicitudUniversitario;



public class DetallesSolicitudE extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textRnc;
	private JTextField textNombre;
	private JTextField textContrato;
	private JTextField textVacantes;
	private JTextField textLocalidad;
	private JTextField textLicencia;
	private JTextField textTipoVa;
	private JTextField textEdad;
	private JTextField textExperienciaU;
	private JTextField textCarrera;
	private JTextField textExpeTec;
	private JTextField textArea;
	private JTextField textExpBa;
	private JLabel lblReub;
	private JLabel lblReqVeh;
	private JLabel lblPostGra;
	private JPanel panelUniversitario;
	private JPanel panelTecnico;
	private JPanel panelBachiller;
	private JList listIdioma;
	private JList listHabilidades;
	private Solicitud miSolici;
	private DefaultListModel idioma = new DefaultListModel();
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DetallesSolicitudE dialog = new DetallesSolicitudE();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DetallesSolicitudE(Solicitud solicitud) {
		setResizable(false);
		setModal(true);
		miSolici = solicitud;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cargarInfo();
			}
		});
				
		
		setTitle("Solicitud\r\n");
		setBounds(100, 100, 547, 577);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelEmpre = new JPanel();
		panelEmpre.setBorder(new TitledBorder(null, "Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpre.setBounds(10, 32, 507, 72);
		contentPanel.add(panelEmpre);
		panelEmpre.setLayout(null);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setBounds(10, 30, 57, 14);
		panelEmpre.add(lblRnc);
		
		textRnc = new JTextField();
		textRnc.setEnabled(false);
		textRnc.setBounds(88, 24, 121, 21);
		panelEmpre.add(textRnc);
		textRnc.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setBounds(251, 30, 62, 14);
		panelEmpre.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setBounds(346, 27, 134, 20);
		panelEmpre.add(textNombre);
		textNombre.setColumns(10);
		
		JPanel panelInfoGeneral = new JPanel();
		panelInfoGeneral.setBorder(new TitledBorder(null, "Info. General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoGeneral.setBounds(10, 123, 507, 188);
		contentPanel.add(panelInfoGeneral);
		panelInfoGeneral.setLayout(null);
		
		JLabel lblContrato = new JLabel("Contrato:");
		lblContrato.setBounds(10, 28, 66, 14);
		panelInfoGeneral.add(lblContrato);
		
		textContrato = new JTextField();
		textContrato.setEnabled(false);
		textContrato.setBounds(110, 25, 121, 20);
		panelInfoGeneral.add(textContrato);
		textContrato.setColumns(10);
		
		JLabel lblVacante = new JLabel("Vacantes:");
		lblVacante.setBounds(274, 28, 66, 14);
		panelInfoGeneral.add(lblVacante);
		
		textVacantes = new JTextField();
		textVacantes.setEnabled(false);
		textVacantes.setBounds(350, 25, 134, 20);
		panelInfoGeneral.add(textVacantes);
		textVacantes.setColumns(10);
		
		JLabel lblReubcacion = new JLabel("Reubicaci\u00F3n:");
		lblReubcacion.setBounds(10, 64, 66, 14);
		panelInfoGeneral.add(lblReubcacion);
		
		lblReub = new JLabel("New label");
		lblReub.setBounds(128, 64, 46, 14);
		panelInfoGeneral.add(lblReub);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(274, 64, 66, 14);
		panelInfoGeneral.add(lblLocalidad);
		
		textLocalidad = new JTextField();
		textLocalidad.setEnabled(false);
		textLocalidad.setBounds(350, 61, 134, 20);
		panelInfoGeneral.add(textLocalidad);
		textLocalidad.setColumns(10);
		
		JLabel lblRequiereVeh = new JLabel("Requiere Veh\u00EDculo:");
		lblRequiereVeh.setBounds(10, 103, 104, 14);
		panelInfoGeneral.add(lblRequiereVeh);
		
		lblReqVeh = new JLabel("New label");
		lblReqVeh.setBounds(128, 103, 46, 14);
		panelInfoGeneral.add(lblReqVeh);
		
		JLabel lblLicencia = new JLabel("Licencia:");
		lblLicencia.setBounds(274, 103, 53, 14);
		panelInfoGeneral.add(lblLicencia);
		
		textLicencia = new JTextField();
		textLicencia.setEnabled(false);
		textLicencia.setBounds(350, 100, 134, 20);
		panelInfoGeneral.add(textLicencia);
		textLicencia.setColumns(10);
		
		JLabel lblTipoVacante = new JLabel("Tipo de Vacante:");
		lblTipoVacante.setBounds(10, 140, 104, 14);
		panelInfoGeneral.add(lblTipoVacante);
		
		textTipoVa = new JTextField();
		textTipoVa.setEnabled(false);
		textTipoVa.setBounds(110, 137, 121, 20);
		panelInfoGeneral.add(textTipoVa);
		textTipoVa.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(274, 140, 51, 14);
		panelInfoGeneral.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setEnabled(false);
		textEdad.setBounds(350, 131, 134, 20);
		panelInfoGeneral.add(textEdad);
		textEdad.setColumns(10);
		
		JPanel panelIdioma = new JPanel();
		panelIdioma.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Idioma(s)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIdioma.setBounds(281, 337, 236, 134);
		contentPanel.add(panelIdioma);
		panelIdioma.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 216, 100);
		panelIdioma.add(scrollPane);
		
		listIdioma = new JList();
		listIdioma.setEnabled(false);
		scrollPane.setViewportView(listIdioma);
		
		panelUniversitario = new JPanel();
		panelUniversitario.setBorder(new TitledBorder(null, "Universitario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUniversitario.setBounds(10, 337, 245, 134);
		contentPanel.add(panelUniversitario);
		panelUniversitario.setLayout(null);
		
		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setBounds(10, 36, 75, 14);
		panelUniversitario.add(lblExperiencia);
		
		textExperienciaU = new JTextField();
		textExperienciaU.setEnabled(false);
		textExperienciaU.setBounds(95, 33, 121, 20);
		panelUniversitario.add(textExperienciaU);
		textExperienciaU.setColumns(10);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(10, 75, 61, 14);
		panelUniversitario.add(lblCarrera);
		
		textCarrera = new JTextField();
		textCarrera.setEnabled(false);
		textCarrera.setBounds(95, 72, 121, 20);
		panelUniversitario.add(textCarrera);
		textCarrera.setColumns(10);
		
		JLabel lblPostGrado = new JLabel("PostGrado:");
		lblPostGrado.setBounds(10, 109, 61, 14);
		panelUniversitario.add(lblPostGrado);
		
		lblPostGra = new JLabel("New label");
		lblPostGra.setBounds(128, 109, 46, 14);
		panelUniversitario.add(lblPostGra);
		
		panelTecnico = new JPanel();
		panelTecnico.setBounds(10, 337, 245, 134);
		contentPanel.add(panelTecnico);
		panelTecnico.setBorder(new TitledBorder(null, "T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTecnico.setLayout(null);
		panelTecnico.setVisible(false);
		
		JLabel lblExpeTec = new JLabel("Experiencia:");
		lblExpeTec.setBounds(10, 36, 75, 14);
		panelTecnico.add(lblExpeTec);
		
		textExpeTec = new JTextField();
		textExpeTec.setBounds(78, 33, 121, 20);
		panelTecnico.add(textExpeTec);
		textExpeTec.setColumns(10);
		
		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setBounds(10, 75, 61, 14);
		panelTecnico.add(lblArea);
		
		textArea = new JTextField();
		textArea.setBounds(78, 72, 121, 20);
		panelTecnico.add(textArea);
		textArea.setColumns(10);
		
		panelBachiller = new JPanel();
		panelBachiller.setBounds(10, 337, 245, 134);
		contentPanel.add(panelBachiller);
		panelBachiller.setBorder(new TitledBorder(null, "Bachiller", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBachiller.setLayout(null);
		panelBachiller.setVisible(false);
		
		JLabel lblBachiller = new JLabel("Experiencia: ");
		lblBachiller.setBounds(10, 36, 75, 14);
		panelBachiller.add(lblBachiller);
		
		textExpBa = new JTextField();
		textExpBa.setBounds(95, 33, 121, 20);
		panelBachiller.add(textExpBa);
		textExpBa.setColumns(10);
		
		JLabel lblHabilidades = new JLabel("Habilidades:");
		lblHabilidades.setBounds(10, 75, 61, 14);
		panelBachiller.add(lblHabilidades);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 64, 122, 59);
		panelBachiller.add(scrollPane_1);
		
		listHabilidades = new JList();
		scrollPane_1.setViewportView(listHabilidades);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Aceptar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void cargarIdiomas() {
		for (String idio : miSolici.getIdiomas()) {
			idioma.addElement(idio);			
		}
		listIdioma.setModel(idioma);
	}
	
	private void cargarInfo() {
		textRnc.setText(miSolici.getEmpresa().getRNC());
		textNombre.setText(miSolici.getEmpresa().getNombre());
		textContrato.setText(miSolici.getTipoContrato());
		textVacantes.setText(Float.toString(miSolici.getCantVacantes()));
		textLocalidad.setText(miSolici.getLocalidad());
		textLicencia.setText("Categoría: "+Integer.toString(miSolici.getCategoriaLicencia()));
		String edadMin = Integer.toString(miSolici.getEdadMin());
		String edadMax = Integer.toString(miSolici.getEdadMax());
		textEdad.setText(edadMin+" a "+edadMax+" años");
		if(miSolici.isMudarse()){
			lblReub.setText("Si");
		}else{
			lblReub.setText("No");
		}
		if(miSolici.isVehiculoPropio()){
			lblReqVeh.setText("Si");
		}else{
			lblReqVeh.setText("No");
		}
		cargarIdiomas();
		if(miSolici instanceof SolicitudUniversitario){
			
			panelUniversitario.setVisible(true);
			panelTecnico.setVisible(false);
			panelBachiller.setVisible(false);
			
			textExperienciaU.setText(Integer.toString(((SolicitudUniversitario)miSolici).getYearExperience()));
			textCarrera.setText(((SolicitudUniversitario)miSolici).getCarrera());
			if(((SolicitudUniversitario)miSolici).isPostGrado()){
				lblPostGra.setText("Si");				
			}else{
				lblPostGra.setText("No");
			}
		}
		if(miSolici instanceof SolicitudTecnico){
			textTipoVa.setText("Técnico");
			panelUniversitario.setVisible(false);
			panelTecnico.setVisible(true);
			panelBachiller.setVisible(false);
			textExpeTec.setText(Integer.toString(((SolicitudTecnico)miSolici).getYearExperience()));
			textArea.setText(((SolicitudTecnico)miSolici).getArea());
						
		}
		if(miSolici instanceof SolicitudBachiller){
			textTipoVa.setText("Bachiller");
			panelUniversitario.setVisible(false);
			panelTecnico.setVisible(false);
			panelBachiller.setVisible(true);
			textExpBa.setText(Integer.toString(((SolicitudBachiller)miSolici).getYearExperience()));
			CargarHabilidades();
		}
		
		
	}
		
	private void CargarHabilidades() {
		DefaultListModel habilidades = new DefaultListModel();
		for (String habili : ((SolicitudBachiller)miSolici).getHabilidades()) {
			habilidades.addElement(habili);
		}
		listHabilidades.setModel(habilidades);
		
		
	}
		
		

}
