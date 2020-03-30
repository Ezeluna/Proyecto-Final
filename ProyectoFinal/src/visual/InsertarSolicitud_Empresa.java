package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logic.Bolsa_Laboral;
import logic.Empresa;
import logic.Solicitud;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertarSolicitud_Empresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JRadioButton rbtnObrero;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnUniversitario;
	private JRadioButton rbtnPostGradoSi;
	private JRadioButton rbtnPostGradoNo;
	private JRadioButton rbtnReubicacionNo;
	private JRadioButton rbtnReubicacionSi;
	private JRadioButton rbtnVehiculoSi;
	private JRadioButton rbtnVehiculoNo;
	private JPanel panelTecnico;
	private JPanel panelObrero;
	private JPanel panelUniversitario;
	private JPanel PanelGeneral;
	private JFormattedTextField ftxtRNC;
	private JComboBox cbxLicencia;
	private JComboBox cbxContrato;
	private JComboBox cbxLocalidad;
	private JSpinner spnVacantes;
	private JSpinner spnEdadMinima;
	private JSpinner spnEdadMaxima;
	private JComboBox cbxIdioma;
	private JList listIdioma;
	private JList ListHabilidad;
	private JSpinner spnUniversitarioExperiencia;
	private JSpinner spnTecnicoExperiencia;
	private JComboBox cbxCarrera;
	private JComboBox cbxArea;
	private JComboBox cbxHabilidades;
	private JSpinner spnObreroExperiencia;

	private ArrayList<String> misIdiomas = new ArrayList<>();
	private ArrayList<String> misHabilidades = new ArrayList<>();
	
	private String indexListaIdioma;
	private String indexListaHabilidades;
	private Bolsa_Laboral bolsa = Bolsa_Laboral.getInstance();
	private Empresa empresa;
	private Solicitud modificarSoli = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarSolicitud_Empresa dialog = new InsertarSolicitud_Empresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarSolicitud_Empresa() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
		setBounds(100, 100, 547, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(248, 248, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelEmpresa = new JPanel();
			panelEmpresa.setLayout(null);
			panelEmpresa.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Empresa",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelEmpresa.setBackground(new Color(248, 248, 255));
			panelEmpresa.setBounds(10, 32, 507, 72);
			contentPanel.add(panelEmpresa);
			{
				JLabel lblRnc = new JLabel("RNC:");
				lblRnc.setBounds(15, 31, 46, 14);
				panelEmpresa.add(lblRnc);
			}
			{
				ftxtRNC = new JFormattedTextField();
				ftxtRNC.setBackground(Color.WHITE);
				ftxtRNC.setBounds(81, 27, 120, 23);
				panelEmpresa.add(ftxtRNC);
			}
			{
				JButton btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String RNC = ftxtRNC.getText();

						empresa = bolsa.RetornarEmpresa(RNC);

						if (empresa != null) {
							txtName.setText(empresa.getNombre());
						} else {
							if (JOptionPane.showConfirmDialog(null,
									"No se encontro ninguna Empresa. \n ¿Désea registrar una empresa nueva?",
									"Atención Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								
									InsertarEmpresa nuevaEmpresa = new InsertarEmpresa("Insertar Empresa", false, null,
											ftxtRNC.getText());
									nuevaEmpresa.setLocationRelativeTo(null);
									nuevaEmpresa.setModal(true);
									nuevaEmpresa.setVisible(true);
						
							}

						}
					}
				});
				btnNewButton.setBounds(204, 26, 29, 25);
				panelEmpresa.add(btnNewButton);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(263, 31, 56, 14);
				panelEmpresa.add(lblNombre);
			}
			{
				txtName = new JTextField();
				txtName.setEnabled(false);
				txtName.setColumns(10);
				txtName.setBackground(Color.WHITE);
				txtName.setBounds(338, 27, 160, 23);
				panelEmpresa.add(txtName);
			}
		}
		{
			JPanel PanelGeneral = new JPanel();
			PanelGeneral.setLayout(null);
			PanelGeneral.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "General",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelGeneral.setBackground(new Color(248, 248, 255));
			PanelGeneral.setBounds(10, 104, 507, 150);
			contentPanel.add(PanelGeneral);
			{
				JLabel lblNewLabel_1 = new JLabel(" Contrato:");
				lblNewLabel_1.setBounds(15, 27, 83, 14);
				PanelGeneral.add(lblNewLabel_1);
			}
			{
				cbxContrato = new JComboBox();
				cbxContrato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Largo Plazo ", "Corto Plazo ", "Temporal "}));
				cbxContrato.setBackground(Color.WHITE);
				cbxContrato.setBounds(81, 23, 149, 23);
				PanelGeneral.add(cbxContrato);
			}
			{
				JLabel lblReubicacin = new JLabel("Reubicaci\u00F3n:");
				lblReubicacin.setBounds(15, 68, 83, 14);
				PanelGeneral.add(lblReubicacin);
			}
			{
				rbtnReubicacionSi = new JRadioButton("Si");
				rbtnReubicacionSi.setBackground(new Color(248, 248, 255));
				rbtnReubicacionSi.setBounds(124, 64, 45, 23);
				PanelGeneral.add(rbtnReubicacionSi);
			}
			{
				rbtnReubicacionNo = new JRadioButton("No");
				rbtnReubicacionNo.setBackground(new Color(248, 248, 255));
				rbtnReubicacionNo.setBounds(179, 64, 45, 23);
				PanelGeneral.add(rbtnReubicacionNo);
			}
			{
				JLabel lblVehiculo = new JLabel("Requiere veh\u00EDculo:");
				lblVehiculo.setBounds(15, 109, 114, 14);
				PanelGeneral.add(lblVehiculo);
			}
			{
				rbtnVehiculoSi = new JRadioButton("Si");
				rbtnVehiculoSi.setBackground(new Color(248, 248, 255));
				rbtnVehiculoSi.setBounds(124, 105, 45, 23);
				PanelGeneral.add(rbtnVehiculoSi);
			}
			{
				rbtnVehiculoNo = new JRadioButton("No");
				rbtnVehiculoNo.setBackground(new Color(248, 248, 255));
				rbtnVehiculoNo.setBounds(179, 105, 45, 23);
				PanelGeneral.add(rbtnVehiculoNo);
			}
			{
				JLabel lblVacantes = new JLabel("Vacantes:");
				lblVacantes.setBounds(263, 27, 83, 14);
				PanelGeneral.add(lblVacantes);
			}
			{
				spnVacantes = new JSpinner();
				spnVacantes.setBackground(Color.WHITE);
				spnVacantes.setBounds(338, 23, 160, 23);
				PanelGeneral.add(spnVacantes);
			}
			{
				JLabel lblLocalidad = new JLabel("Localidad:");
				lblLocalidad.setBounds(263, 68, 83, 14);
				PanelGeneral.add(lblLocalidad);
			}
			{
				JLabel lblCategoriaLic = new JLabel("Licencia:");
				lblCategoriaLic.setBounds(263, 109, 83, 14);
				PanelGeneral.add(lblCategoriaLic);
			}
			{
				cbxLocalidad = new JComboBox();
				cbxLocalidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>" , "Azua ", "Bahoruco ",
						"Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ",
						"Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ",
						"Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ",
						"Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ",
						"S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ",
						"San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ",
						"Valverde "}));
				cbxLocalidad.setBackground(Color.WHITE);
				cbxLocalidad.setBounds(338, 64, 160, 23);
				PanelGeneral.add(cbxLocalidad);
			}
			{
				cbxLicencia = new JComboBox();
				cbxLicencia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Categor\u00EDa 1", "Categor\u00EDa 2", "Categor\u00EDa 3", "Categor\u00EDa 4", "Categor\u00EDa 5"}));
				cbxLicencia.setEnabled(false);
				cbxLicencia.setBackground(Color.WHITE);
				cbxLicencia.setBounds(338, 105, 160, 23);
				PanelGeneral.add(cbxLicencia);
			}
		}
		{
			JPanel panelEdad = new JPanel();
			panelEdad.setLayout(null);
			panelEdad.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rango De Edad",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelEdad.setBackground(new Color(248, 248, 255));
			panelEdad.setBounds(10, 257, 245, 59);
			contentPanel.add(panelEdad);
			{
				JLabel lblNewLabel = new JLabel("Minima:");
				lblNewLabel.setBounds(15, 28, 60, 14);
				panelEdad.add(lblNewLabel);
			}
			{
				JLabel lblMxima = new JLabel("M\u00E1xima:");
				lblMxima.setBounds(129, 28, 60, 14);
				panelEdad.add(lblMxima);
			}
			{
				spnEdadMinima = new JSpinner();
				spnEdadMinima.setBackground(Color.WHITE);
				spnEdadMinima.setBounds(62, 24, 51, 23);
				panelEdad.add(spnEdadMinima);
			}
			{
				spnEdadMaxima = new JSpinner();
				spnEdadMaxima.setBackground(Color.WHITE);
				spnEdadMaxima.setBounds(180, 24, 51, 23);
				panelEdad.add(spnEdadMaxima);
			}
		}
		{
			JPanel PanelVacante = new JPanel();
			PanelVacante.setLayout(null);
			PanelVacante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo Vacante",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelVacante.setBackground(new Color(248, 248, 255));
			PanelVacante.setBounds(255, 257, 265, 59);
			contentPanel.add(PanelVacante);
			{
				rbtnTecnico = new JRadioButton("T\u00E9cnico ");
				rbtnTecnico.setBackground(new Color(248, 248, 255));
				rbtnTecnico.setBounds(107, 22, 75, 23);
				PanelVacante.add(rbtnTecnico);
			}
			{
				rbtnUniversitario = new JRadioButton("Universitario");
				rbtnUniversitario.setBackground(new Color(248, 248, 255));
				rbtnUniversitario.setBounds(6, 22, 99, 23);
				PanelVacante.add(rbtnUniversitario);
			}
			{
				rbtnObrero = new JRadioButton("Obrero");
				rbtnObrero.setBackground(new Color(248, 248, 255));
				rbtnObrero.setBounds(184, 22, 75, 23);
				PanelVacante.add(rbtnObrero);
			}
		}
		{
			JPanel panelIdioma = new JPanel();
			panelIdioma.setLayout(null);
			panelIdioma.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Idiomas",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelIdioma.setBackground(new Color(248, 248, 255));
			panelIdioma.setBounds(10, 319, 245, 164);
			contentPanel.add(panelIdioma);
			{
				JLabel lblIdioma = new JLabel("Idioma:");
				lblIdioma.setBounds(15, 31, 46, 14);
				panelIdioma.add(lblIdioma);
			}
			{
				cbxIdioma = new JComboBox();
				cbxIdioma.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Afrikaans", "Alban\u00E9s",
						"Alem\u00E1n", "Amharico", "Arabe", "Armenio", "Bengali", "Bieloruso", "Birman\u00E9s", "Bulgaro",
						"Catalan", "Checo", "Chino", "Coreano", "Croata", "Dan\u00E9s", "Dari", "Dzongkha", "Escoc\u00E9s",
						"Eslovaco", "Esloveniano", "Espa\u00F1ol", "Esperanto", "Estoniano", "Faroese", "Farsi",
						"Finland\u00E9s", "Franc\u00E9s", "Gaelico", "Galese", "Gallego", "Griego", "Hebreo", "Hindi",
						"Holand\u00E9s", "Hungaro", "Ingl\u00E9s", "Indonesio", "Inuktitut (Eskimo)", "Islandico",
						"Italiano", "Japon\u00E9s", "Khmer", "Kurdo", "Lao", "Laponico", "Latviano", "Lituano", "Macedonio",
						"Malay\u00E9s", "Malt\u00E9s", "Nepali", "Noruego", "Pashto", "Polaco", "Portugu\u00E9s", "Rumano",
						"Ruso", "Serbio", "Somali", "Suahili", "Sueco", "Tagalog-Filipino", "Tajik", "Tamil",
						"Tailand\u00E9s", "Tibetano", "Tigrinia", "Tongan\u00E9s", "Turco", "Turkmenistano", "Ucraniano",
						"Urdu", "Uzbekistano", "Vasco", "Vietnam\u00E9s"}));
				cbxIdioma.setBackground(Color.WHITE);
				cbxIdioma.setBounds(68, 27, 130, 23);
				panelIdioma.add(cbxIdioma);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(15, 67, 215, 86);
				panelIdioma.add(scrollPane);
			}
			{
				JButton btnEliminarIdioma = new JButton("");
				btnEliminarIdioma.setBounds(201, 26, 29, 25);
				panelIdioma.add(btnEliminarIdioma);
			}
		}
		{
			JPanel panelUniversitario = new JPanel();
			panelUniversitario.setLayout(null);
			panelUniversitario.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
								"Universitario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelUniversitario.setBackground(new Color(248, 248, 255));
			panelUniversitario.setBounds(255, 319, 265, 164);
			contentPanel.add(panelUniversitario);
			{
				JLabel lblExperiencia = new JLabel("Experiencia:");
				lblExperiencia.setBounds(18, 29, 72, 14);
				panelUniversitario.add(lblExperiencia);
			}
			{
				spnUniversitarioExperiencia = new JSpinner();
				spnUniversitarioExperiencia.setBackground(Color.WHITE);
				spnUniversitarioExperiencia.setBounds(93, 25, 160, 23);
				panelUniversitario.add(spnUniversitarioExperiencia);
			}
			{
				JLabel lblPostgrado = new JLabel("PostGrado:");
				lblPostgrado.setBounds(18, 100, 72, 14);
				panelUniversitario.add(lblPostgrado);
			}
			{
				rbtnPostGradoSi = new JRadioButton("Si");
				rbtnPostGradoSi.setBackground(new Color(248, 248, 255));
				rbtnPostGradoSi.setBounds(114, 96, 40, 23);
				panelUniversitario.add(rbtnPostGradoSi);
			}
			{
				rbtnPostGradoNo = new JRadioButton("No");
				rbtnPostGradoNo.setBackground(new Color(248, 248, 255));
				rbtnPostGradoNo.setBounds(180, 96, 51, 23);
				panelUniversitario.add(rbtnPostGradoNo);
			}
			{
				JLabel lblCarrera = new JLabel("Carrera:");
				lblCarrera.setBounds(18, 65, 72, 14);
				panelUniversitario.add(lblCarrera);
			}
			{
				cbxCarrera = new JComboBox();
				cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Adm. de Empresas",
						"Adm. Hotelera", "Derecho", "Econom\u00EDa", "Contabilidad", "Mercadotecnia", "Arquitectura",
						"Comunicacion Social", "Dise\u00F1o e Interiorismo", "Ecologia", "Educaci\u00F3n", "Filosof\u00EDa",
						"Psicolog\u00EDa", "Ing. Civil", "Ing. Electr\u00F3nica", "Ing. Industrial",
						"Ing. Mecatr\u00F3nica", "Ing. Sistema", "Ing. Telem\u00E1tica", "Enfermeria", "Estomatolog\u00EDa",
						"Medicina", "Nutricion y Dietetica", "Terapia F\u00EDsica" }));
				cbxCarrera.setBackground(Color.WHITE);
				cbxCarrera.setBounds(93, 61, 160, 23);
				panelUniversitario.add(cbxCarrera);
			}
		}
		{
			JPanel panelTecnico = new JPanel();
			panelTecnico.setLayout(null);
			panelTecnico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "T\u00E9cnico",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTecnico.setBackground(new Color(248, 248, 255));
			panelTecnico.setBounds(255, 319, 265, 164);
			contentPanel.add(panelTecnico);
			{
				JLabel label = new JLabel("Experiencia:");
				label.setBounds(18, 29, 72, 14);
				panelTecnico.add(label);
			}
			{
				spnTecnicoExperiencia = new JSpinner();
				spnTecnicoExperiencia.setBackground(new Color(248, 248, 255));
				spnTecnicoExperiencia.setBounds(93, 25, 160, 23);
				panelTecnico.add(spnTecnicoExperiencia);
			}
			{
				JLabel label_8 = new JLabel("*");
				label_8.setForeground(Color.RED);
				label_8.setBounds(10, 65, 46, 14);
				panelTecnico.add(label_8);
			}
			{
				JLabel lblArea = new JLabel("Area:");
				lblArea.setBounds(18, 65, 72, 14);
				panelTecnico.add(lblArea);
			}
			{
				JComboBox cbxArea = new JComboBox();
				cbxArea.setBackground(new Color(248, 248, 255));
				cbxArea.setBounds(93, 61, 160, 23);
				panelTecnico.add(cbxArea);
			}
		}
		{
			JPanel panelObrero = new JPanel();
			panelObrero.setLayout(null);
			panelObrero.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Obrero",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelObrero.setBackground(new Color(248, 248, 255));
			panelObrero.setBounds(255, 319, 265, 164);
			contentPanel.add(panelObrero);
			{
				JLabel label_1 = new JLabel("Experiencia:");
				label_1.setBounds(18, 29, 72, 14);
				panelObrero.add(label_1);
			}
			{
				spnObreroExperiencia = new JSpinner();
				spnObreroExperiencia.setBackground(new Color(248, 248, 255));
				spnObreroExperiencia.setBounds(93, 25, 160, 23);
				panelObrero.add(spnObreroExperiencia);
			}
			{
				JLabel lblHabilidades = new JLabel("Habilidades:");
				lblHabilidades.setBounds(18, 65, 72, 14);
				panelObrero.add(lblHabilidades);
			}
			{
				JLabel label_9 = new JLabel("*");
				label_9.setForeground(Color.RED);
				label_9.setBounds(10, 65, 46, 14);
				panelObrero.add(label_9);
			}
			{
				cbxHabilidades = new JComboBox();
				cbxHabilidades.setBackground(new Color(248, 248, 255));
				cbxHabilidades.setBounds(93, 61, 126, 23);
				panelObrero.add(cbxHabilidades);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(18, 90, 235, 63);
				panelObrero.add(scrollPane_1);
			}
			{
				JButton bntEliminarHabilidad = new JButton("");
				bntEliminarHabilidad.setBounds(224, 60, 29, 25);
				panelObrero.add(bntEliminarHabilidad);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(248, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

}
