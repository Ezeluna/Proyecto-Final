package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logic.Bolsa_Laboral;
import logic.Empresa;
import logic.Solicitud;
import logic.SolicitudBachiller;
import logic.SolicitudTecnico;
import logic.SolicitudUniversitario;

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
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//
public class InsertarSolicitud_Empresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JRadioButton rbtnBachiller;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnUniversitario;
	private JRadioButton rbtnPostGradoSi;
	private JRadioButton rbtnPostGradoNo;
	private JRadioButton rbtnReubicacionNo;
	private JRadioButton rbtnReubicacionSi;
	private JRadioButton rbtnVehiculoSi;
	private JRadioButton rbtnVehiculoNo;
	private JPanel panelTecnico;
	private JPanel panelBachiller;
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
	private JList listIdiomas;
	private JList ListHabilidad;
	private JSpinner spnUniversitarioExperiencia;
	private JSpinner spnTecnicoExperiencia;
	private JComboBox cbxCarrera;
	private JComboBox cbxArea;
	private JComboBox cbxHabilidades;
	private JSpinner spnBachillerExperiencia;

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
	/*
	 * public static void main(String[] args) { try { InsertarSolicitud_Empresa
	 * dialog = new InsertarSolicitud_Empresa();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public InsertarSolicitud_Empresa(Solicitud modi) {
		setResizable(false);
		modificarSoli = modi; 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (modificarSoli == null) {

					if (rbtnUniversitario.isSelected()) {
						rbtnUniversitario.setSelected(true);
						panelTecnico.setVisible(false);
						panelBachiller.setVisible(false);
					}
					if (rbtnTecnico.isSelected()) {
						rbtnUniversitario.setSelected(false);
						panelTecnico.setVisible(true);
						panelBachiller.setVisible(false);
					}
					if (rbtnBachiller.isSelected()) {
						rbtnUniversitario.setSelected(false);
						panelTecnico.setVisible(false);
						panelBachiller.setVisible(true);
					}

				} else {
					for (String idioma : modificarSoli.getIdiomas()) {
						misIdiomas.add(idioma);
					}
					ftxtRNC.setValue(modi.getEmpresa().getRNC());
					ftxtRNC.setEnabled(false);

					txtName.setText(modi.getEmpresa().getNombre());
					cbxContrato.setSelectedItem(modi.getTipoContrato());
					if (modi.isMudarse()) {
						rbtnReubicacionSi.setSelected(true);
					} else {
						rbtnReubicacionNo.setSelected(true);
					}
					if (modi.isVehiculoPropio()) {
						rbtnVehiculoSi.setSelected(true);
						cbxLicencia.setSelectedItem(modi.getCategoriaLicencia());
					} else {
						rbtnVehiculoNo.setSelected(true);
					}
					cbxLocalidad.setSelectedItem(modi.getLocalidad());
					spnVacantes.setValue(modi.getCantVacantes());
					spnEdadMinima.setValue(modi.getEdadMin());
					spnEdadMaxima.setValue(modi.getEdadMax());
					cargarIdioma();

					if (modificarSoli instanceof SolicitudUniversitario) {
						rbtnUniversitario.setSelected(true);
						panelUniversitario.setVisible(true);
						panelTecnico.setVisible(false);
						panelBachiller.setVisible(false);
						rbtnUniversitario.setEnabled(false);
						rbtnTecnico.setEnabled(false);
						rbtnBachiller.setEnabled(false);
						spnUniversitarioExperiencia.setValue(((SolicitudUniversitario) modi).getYearExperience());
						cbxCarrera.setSelectedItem(((SolicitudUniversitario) modi).getCarrera());
						if (((SolicitudUniversitario) modi).isPostGrado()) {
							rbtnPostGradoSi.setSelected(true);
						} else {
							rbtnPostGradoNo.setSelected(true);
						}

					}
					if (modificarSoli instanceof SolicitudTecnico) {
						rbtnTecnico.setSelected(true);
						panelTecnico.setVisible(true);
						panelUniversitario.setVisible(false);
						panelBachiller.setVisible(false);
						rbtnUniversitario.setEnabled(false);
						rbtnTecnico.setEnabled(false);
						rbtnBachiller.setEnabled(false);
						spnTecnicoExperiencia.setValue(((SolicitudTecnico) modi).getYearExperience());
						cbxArea.setSelectedItem(((SolicitudTecnico) modi).getArea());

					}
					if (modificarSoli instanceof SolicitudBachiller) {
						for (String habili : ((SolicitudBachiller) modificarSoli).getHabilidades()) {
							misHabilidades.add(habili);
						}
						rbtnBachiller.setSelected(true);
						panelBachiller.setVisible(true);
						panelUniversitario.setVisible(false);
						panelTecnico.setVisible(false);
						rbtnUniversitario.setEnabled(false);
						rbtnTecnico.setEnabled(false);
						rbtnBachiller.setEnabled(false);
						spnBachillerExperiencia.setValue(((SolicitudBachiller) modi).getYearExperience());
						cargarHabilidades();

					}

				}
			}
		});
		if (modificarSoli == null) {
			setTitle("Insertar Solicitud - Bolsa Laboral");

		} else {
			setTitle("Modificar Solicitud - Bolsa Laboral");

		}
		setBounds(100, 100, 547, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(248, 248, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
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
			try {
				MaskFormatter mascara = new MaskFormatter("##########");
				ftxtRNC = new JFormattedTextField(mascara);
				ftxtRNC.setBackground(new Color(255, 255, 255));
				ftxtRNC.setBounds(81, 27, 120, 23);
				panelEmpresa.add(ftxtRNC);

			} catch (Exception e) {
				// TODO: handle exception
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
			PanelGeneral.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "General",            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
				rbtnReubicacionSi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnReubicacionNo.setSelected(false);
					}
				});
				rbtnReubicacionSi.setBackground(new Color(248, 248, 255));
				rbtnReubicacionSi.setBounds(124, 64, 45, 23);
				PanelGeneral.add(rbtnReubicacionSi);
			}
			{
				rbtnReubicacionNo = new JRadioButton("No");
				rbtnReubicacionNo.setBackground(new Color(248, 248, 255));
				rbtnReubicacionNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnReubicacionSi.setSelected(false);
					}
				});
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
				rbtnVehiculoSi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnVehiculoNo.setSelected(false);
						cbxLicencia.setEnabled(true);
					}
				});
				rbtnVehiculoSi.setBounds(124, 105, 45, 23);
				PanelGeneral.add(rbtnVehiculoSi);
			}
			{
				rbtnVehiculoNo = new JRadioButton("No");
				rbtnVehiculoNo.setBackground(new Color(248, 248, 255));
				rbtnVehiculoNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnVehiculoSi.setSelected(false);
						cbxLicencia.setEnabled(false);
					}
				});
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
				spnVacantes.setBackground(new Color(255, 255, 255));
				spnVacantes.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
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
				JLabel lblNewLabel = new JLabel("M\u00EDnima:");
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
				spnEdadMinima.setModel(new SpinnerNumberModel(new Integer(18), null, null, new Integer(1)));
				spnEdadMinima.setBackground(Color.WHITE);
				spnEdadMinima.setBounds(62, 24, 51, 23);
				panelEdad.add(spnEdadMinima);
			}
			{
				spnEdadMaxima = new JSpinner();
				spnEdadMaxima.setModel(new SpinnerNumberModel(new Integer(35), null, null, new Integer(1)));
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
				rbtnTecnico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnUniversitario.setSelected(false);
						rbtnBachiller.setSelected(false);
						panelUniversitario.setVisible(false);
						panelTecnico.setVisible(true);
						panelBachiller.setVisible(false);
					}
				});
				rbtnTecnico.setBackground(new Color(248, 248, 255));
				rbtnTecnico.setBounds(107, 22, 75, 23);
				PanelVacante.add(rbtnTecnico);
			}
			{
				rbtnUniversitario = new JRadioButton("Universitario");
				rbtnUniversitario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnTecnico.setSelected(false);
						rbtnBachiller.setSelected(false);
						panelUniversitario.setVisible(true);
						panelTecnico.setVisible(false);
						panelBachiller.setVisible(false);
					}
				});
				rbtnUniversitario.setBackground(new Color(248, 248, 255));
				rbtnUniversitario.setBounds(6, 22, 99, 23);
				PanelVacante.add(rbtnUniversitario);
			}
			{
				rbtnBachiller = new JRadioButton("Bachiller");
				rbtnBachiller.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rbtnUniversitario.setSelected(false);
						rbtnTecnico.setSelected(false);
						panelUniversitario.setVisible(false);
						panelTecnico.setVisible(false);
						panelBachiller.setVisible(true);
					}
				});
				rbtnBachiller.setBackground(new Color(248, 248, 255));
				rbtnBachiller.setBounds(184, 22, 75, 23);
				PanelVacante.add(rbtnBachiller);
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
				cbxIdioma.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (!misIdiomas.contains((String) cbxIdioma.getSelectedItem())
								&& cbxIdioma.getSelectedIndex() > 0) {

							misIdiomas.add((String) cbxIdioma.getSelectedItem());
						} else if (misIdiomas.contains((String) cbxIdioma.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "Ese idioma ha sido seleccionado", "ATENCIÓN",
									JOptionPane.ERROR_MESSAGE, null);
						}
						cbxIdioma.setSelectedIndex(0);
						cargarIdioma();
					}
				});
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
				
				listIdiomas = new JList();
				listIdiomas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						indexListaIdioma = (String) listIdiomas.getSelectedValue();
					}
				
				});
				listIdiomas.setLocation(18, 0);
				scrollPane.setViewportView(listIdiomas);
				
			}
	
			{
				JButton btnEliminarIdioma = new JButton("");
				btnEliminarIdioma.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						misIdiomas.remove(indexListaIdioma);
						cargarIdioma();
					}
				});
				btnEliminarIdioma.setBounds(201, 26, 29, 25);
				panelIdioma.add(btnEliminarIdioma);
			}
		}
		{
			panelUniversitario = new JPanel();
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
				cbxCarrera.setBounds(93, 61, 160, 23);
				panelUniversitario.add(cbxCarrera);
			}
		}
		{
			panelTecnico = new JPanel();
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
				JLabel lblArea = new JLabel("Area:");
				lblArea.setBounds(18, 65, 72, 14);
				panelTecnico.add(lblArea);
			}
			{
				cbxArea = new JComboBox();
				cbxArea.setBackground(new Color(248, 248, 255));
				cbxArea.setModel(new DefaultComboBoxModel(
						new String[] { "<Seleccionar>", "Emprendimiento", "Mecanograf\u00EDa", "Dise\u00F1o Gr\u00E1fico",
								"Programaci\u00F3n", "Contabilidad", "Programaci\u00F3n Web" }));
				cbxArea.setBounds(93, 61, 160, 23);
				panelTecnico.add(cbxArea);
			}
		}
		{
			panelBachiller = new JPanel();
			panelBachiller.setLayout(null);
			panelBachiller.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bachiller", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelBachiller.setBackground(new Color(248, 248, 255));
			panelBachiller.setBounds(255, 319, 265, 164);
			contentPanel.add(panelBachiller);
			{
				JLabel label_1 = new JLabel("Experiencia:");
				label_1.setBounds(18, 29, 72, 14);
				panelBachiller.add(label_1);
			}
			{
				spnBachillerExperiencia = new JSpinner();
				spnBachillerExperiencia.setBackground(new Color(248, 248, 255));
				spnBachillerExperiencia.setBounds(93, 25, 160, 23);
				panelBachiller.add(spnBachillerExperiencia);
			}
			{
				JLabel lblHabilidades = new JLabel("Habilidades:");
				lblHabilidades.setBounds(18, 65, 72, 14);
				panelBachiller.add(lblHabilidades);
			}
		
			{
				cbxHabilidades = new JComboBox();
				cbxHabilidades.setBackground(new Color(248, 248, 255));
				cbxHabilidades.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (!misHabilidades.contains((String) cbxHabilidades.getSelectedItem())
								&& cbxHabilidades.getSelectedIndex() > 0) {
							misHabilidades.add((String) cbxHabilidades.getSelectedItem());
						} else if (misHabilidades.contains((String) cbxHabilidades.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "Esta habilidad ya fue seleccionada", "ERROR",
									JOptionPane.ERROR_MESSAGE, null);
						}
						cbxHabilidades.setSelectedIndex(0);
						cargarHabilidades();
					}

				});
				cbxHabilidades.setModel(new DefaultComboBoxModel(
						new String[] { "< Seleccione >", "Alba\u00F1il", "Anfitri\u00F3n de Fiesta", "Artesano", "Carpintero",
								"Chofer", "Chef", "Constructor", "Decorador", "Ebanista", "Electricista", "Mec\u00E1nico",
								"Pintor", "Plomero", "Salva Vidas", "Modista", "Seguridad", "Sirviente", "Jardinero" }));
				cbxHabilidades.setBounds(93, 61, 126, 23);
				panelBachiller.add(cbxHabilidades);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(18, 90, 235, 63);
				panelBachiller.add(scrollPane_1);
				
				ListHabilidad = new JList();
				ListHabilidad.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						indexListaHabilidades = (String) ListHabilidad.getSelectedValue();
					}
				});
				ListHabilidad.setLocation(20, 0);
				scrollPane_1.setViewportView(ListHabilidad);
			}
			
			{
				JButton bntEliminarHabilidad = new JButton("");
				bntEliminarHabilidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						misHabilidades.remove(indexListaHabilidades);
						cargarHabilidades();
					}
				});
				bntEliminarHabilidad.setBounds(224, 60, 29, 25);
				panelBachiller.add(bntEliminarHabilidad);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(248, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				if (modificarSoli != null) {
					okButton.setText("Modificar");
				} else {
					okButton.setText("Insertar");
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String RNC = ftxtRNC.getText();
						String Contrato = (String) cbxContrato.getSelectedItem();
						Boolean reubicacion = false;
						if (rbtnReubicacionSi.isSelected()) {
							reubicacion = true;
						} else if (rbtnReubicacionNo.isSelected()) {
							reubicacion = false;
						}
						boolean vehiculo = false;
						if (rbtnVehiculoSi.isSelected()) {
							vehiculo = true;
						} else if (rbtnVehiculoNo.isSelected()) {
							vehiculo = false;
						}

						float vacantes = (float) spnVacantes.getValue();

						String localidad = (String) cbxLocalidad.getSelectedItem();
						int categoriaLicencia = 0;
						if (cbxLicencia.getSelectedIndex() == 1) {
							categoriaLicencia = 1;
						}
						if (cbxLicencia.getSelectedIndex() == 2) {
							categoriaLicencia = 2;
						}
						if (cbxLicencia.getSelectedIndex() == 3) {
							categoriaLicencia = 3;
						}
						if (cbxLicencia.getSelectedIndex() == 4) {
							categoriaLicencia = 4;
						}
						if (cbxLicencia.getSelectedIndex() == 5) {
							categoriaLicencia = 5;
						}
						int edadMinima = (int) spnEdadMinima.getValue();
						int edadMaxima = (int) spnEdadMaxima.getValue();
						int experienciaUniversitario = (int) spnUniversitarioExperiencia.getValue();
						int experienciaTecnico = (int) spnTecnicoExperiencia.getValue();
						int experienciaBachiller = (int) spnBachillerExperiencia.getValue();
						String carrera = (String) cbxCarrera.getSelectedItem();
						boolean posGrado = false;
						if (rbtnPostGradoSi.isSelected()) {
							posGrado = true;
						}
						String area = (String) cbxArea.getSelectedItem();
						if (modificarSoli == null) {

							if (txtName.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Se debe ingresar la empresa que solicita",
										"ATENCIÓN", JOptionPane.WARNING_MESSAGE, null);
							} else if (cbxContrato.getSelectedIndex() == 0 || cbxLocalidad.getSelectedIndex() == 0) {
								JOptionPane.showMessageDialog(null, "No deje campos vacios", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);

							} else if (rbtnVehiculoSi.isSelected() && cbxLicencia.getSelectedIndex() == 0) {
								JOptionPane.showMessageDialog(null,
										"Selecciona la categoria de la Licencia de conducir", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);

							} else if (!rbtnTecnico.isSelected() && !rbtnUniversitario.isSelected()
									&& !rbtnBachiller.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecciona el tipo de empleado que se necesita",
										"ATENCIÓN", JOptionPane.WARNING_MESSAGE, null);

							} else if (panelUniversitario.isVisible() && cbxCarrera.getSelectedIndex() == 0) {
								JOptionPane.showMessageDialog(null, "Selecciona la carrera del universitario",
										"ATENCIÓN", JOptionPane.WARNING_MESSAGE, null);

							} else if (panelTecnico.isVisible() && cbxArea.getSelectedIndex() == 0) {
								JOptionPane.showMessageDialog(null, "Selecciona el area del tecnico", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);
							} else if (panelBachiller.isVisible() && misHabilidades.size() == 0) {
								JOptionPane.showMessageDialog(null, "Selecciona las habilidades del obrero", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);

							} else if (panelUniversitario.isVisible() && !rbtnPostGradoSi.isSelected()
									&& !rbtnPostGradoNo.isSelected()) {
								rbtnPostGradoNo.setSelected(true);
							} else if ((int) spnEdadMaxima.getValue() < (int) spnEdadMinima.getValue()) {
								JOptionPane.showMessageDialog(null, "Edad minima no puede ser mayor que la máxima",
										"ATENCIÓN", JOptionPane.WARNING_MESSAGE, null);

							} else {
								if (rbtnUniversitario.isSelected()) {
									SolicitudUniversitario nuevaSoli = new SolicitudUniversitario((float) vacantes,
											empresa, localidad, edadMaxima, edadMinima, experienciaUniversitario, Contrato, vehiculo,
											categoriaLicencia, reubicacion, misIdiomas, carrera, posGrado);

									bolsa.insertSolicitud(nuevaSoli);
									JOptionPane.showMessageDialog(null, "La Solicitud se registro correctamente",
											"Información", JOptionPane.INFORMATION_MESSAGE, null);
									clean(1);
								}
								if (rbtnTecnico.isSelected()) {
									SolicitudTecnico nuevaSoli = new SolicitudTecnico((float) vacantes,
											empresa, localidad, edadMaxima, edadMinima, experienciaUniversitario, Contrato, vehiculo,
											categoriaLicencia, misIdiomas, reubicacion, area);
									
									bolsa.insertSolicitud(nuevaSoli);
									JOptionPane.showMessageDialog(null, "La Solicitud se registro correctamente",
											"Información", JOptionPane.INFORMATION_MESSAGE, null);
									clean(2);
								}
								if (rbtnBachiller.isSelected()) {
									SolicitudBachiller nuevaSoli = new SolicitudBachiller((float) vacantes,
											empresa, localidad, edadMaxima, edadMinima, experienciaUniversitario, Contrato, vehiculo,
											categoriaLicencia, reubicacion, misIdiomas, misHabilidades);
									nuevaSoli.setIdiomas(misIdiomas);
									bolsa.insertSolicitud(nuevaSoli);
									JOptionPane.showMessageDialog(null, "La Solicitud se registro correctamente",
											"Información", JOptionPane.INFORMATION_MESSAGE, null);
									clean(3);
								}

							}
							////// MODIFICAR
						} else {

							modificarSoli.setTipoContrato((String) cbxContrato.getSelectedItem());

							if (rbtnReubicacionSi.isSelected()) {
								modificarSoli.setMudarse(true);
							} else {
								modificarSoli.setMudarse(false);
							}
							if (rbtnVehiculoSi.isSelected()) {
								modificarSoli.setVehiculoPropio(true);
								modificarSoli.setCategoriaLicencia((int) cbxLicencia.getSelectedIndex());
							} else {
								modificarSoli.setVehiculoPropio(false);
							}
							modificarSoli.setCantVacantes((float) spnVacantes.getValue());
							modificarSoli.setDireccion((String) cbxLocalidad.getSelectedItem());
							modificarSoli.setEdadMin((int) spnEdadMinima.getValue());
							modificarSoli.setEdadMax((int) spnEdadMaxima.getValue());
							modificarSoli.setIdiomas(misIdiomas);
							if (modi instanceof SolicitudUniversitario) {
								modificarSoli.setYearExperience((int) spnUniversitarioExperiencia.getValue());
								((SolicitudUniversitario) modificarSoli)
										.setCarrera((String) cbxCarrera.getSelectedItem());
								if (rbtnPostGradoSi.isSelected()) {
									((SolicitudUniversitario) modificarSoli).setPostGrado(true);
								} else {
									((SolicitudUniversitario) modificarSoli).setPostGrado(false);
								}

							} else if (modi instanceof SolicitudTecnico) {
								modificarSoli.setYearExperience((int) spnTecnicoExperiencia.getValue());
								((SolicitudTecnico) modificarSoli).setArea((String) cbxArea.getSelectedItem());

							} else if (modi instanceof SolicitudBachiller) {
								modificarSoli.setYearExperience((int) spnBachillerExperiencia.getValue());
								((SolicitudBachiller) modificarSoli).setHabilidades(misHabilidades);

							}
							Bolsa_Laboral.getInstance().ActualizarSolicitud(modi, modificarSoli);
							JOptionPane.showMessageDialog(null, "La Solicitud se modifico correctamente", "Información",
									JOptionPane.INFORMATION_MESSAGE, null);
							if (ListarSolicitud_Empresa.cbxfiltro.getSelectedIndex() == 0) {
								ListarSolicitud_Empresa.loadtabla(0);
							}
							if (ListarSolicitud_Empresa.cbxfiltro.getSelectedIndex() == 1) {
								ListarSolicitud_Empresa.loadtabla(1);

							}
							if (ListarSolicitud_Empresa.cbxfiltro.getSelectedIndex() == 2) {
								ListarSolicitud_Empresa.loadtabla(2);

							}
							if (ListarSolicitud_Empresa.cbxfiltro.getSelectedIndex() == 3) {
								ListarSolicitud_Empresa.loadtabla(3);

							}

							dispose();

						}

					}

					private void clean(int i) {
						ftxtRNC.setValue("");
						txtName.setText("");
						cbxContrato.setSelectedIndex(0);
						rbtnReubicacionNo.setSelected(false);
						rbtnReubicacionSi.setSelected(false);
						rbtnVehiculoSi.setSelected(false);
						rbtnVehiculoNo.setSelected(false);
						spnVacantes.setValue(1);
						cbxLocalidad.setSelectedIndex(0);
						cbxLicencia.setSelectedIndex(0);
						spnEdadMinima.setValue(18);
						spnEdadMaxima.setValue(19);
						misIdiomas.removeAll(misIdiomas);
						cargarIdioma();
						if (i == 1) {
							rbtnUniversitario.setSelected(false);
							spnUniversitarioExperiencia.setValue(0);
							cbxCarrera.setSelectedIndex(0);
							rbtnPostGradoNo.setSelected(false);
							rbtnPostGradoSi.setSelected(false);
						}
						if (i == 2) {
							rbtnTecnico.setSelected(false);
							spnTecnicoExperiencia.setValue(0);
							cbxArea.setSelectedIndex(0);
						}
						if (i == 3) {
							rbtnBachiller.setSelected(false);
							misHabilidades.removeAll(misHabilidades);
							cargarHabilidades();
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {				public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void cargarIdioma() {
		DefaultListModel idioma = new DefaultListModel();

		for (String idio : misIdiomas) {
			idioma.addElement(idio);
		}
		listIdiomas.setModel(idioma);

	}

	private void cargarHabilidades() {
		DefaultListModel habilidades = new DefaultListModel();

		for (String habili : misHabilidades) {
			habilidades.addElement(habili);
		}
		ListHabilidad.setModel(habilidades);

	}
}
