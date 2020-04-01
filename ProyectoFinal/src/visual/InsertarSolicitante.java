package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logic.Bolsa_Laboral;
import logic.Personal;


import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertarSolicitante extends JDialog {
//jeje
	private final JPanel contentPanel = new JPanel();
	private JPanel panel1;
	private JPanel panel2;
	private JButton btnEliminarIdioma;
	private JButton btnRemoverH;
	private JButton btnContinuar;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JPanel panelContacto;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCiudad;
	private JTextField textSector;
	private JTextField textCalle;
	private JTextField textReferencia;
	private JFormattedTextField ftextCedula;
	private JFormattedTextField ftextTelefono;
	private JComboBox cbxLicencia;
	private JComboBox cbxProvincias;
	private JComboBox cbxEstadoCivil;
	private JComboBox cbxNacionalidad;
	private JComboBox cbxIdiomas;
	private JComboBox cbxHabilidades;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFemenino;
	private JRadioButton rbtnSiVehiculoPro;
	private JRadioButton rbtnNoVehiculoPro;
	private JRadioButton rbtnSiDisponibilidad;
	private JRadioButton rbtnNoDisponibilidad;
	private JRadioButton rbtnObrero;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnUniversitario;
	private JSpinner spnNumeroCasa;
	private JSpinner spnYearExpO;
	private JTextField textField;
	private JPanel panelObrero;
	private JPanel panelTecnico;
	private JList listIdiomas;
	private JList listHabilidades;
	private ArrayList<String> misIdiomas = new ArrayList<>();
	private ArrayList<String> misHabilidades = new ArrayList<>();
	private DefaultListModel<String> modeloIdiomas = new DefaultListModel<>();
	private DefaultListModel<String> modeloHabilidad = new DefaultListModel<>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarSolicitante dialog = new InsertarSolicitante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarSolicitante() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
			}
		});
		setTitle("Insertar Solicitante");
		setBounds(100, 100, 612, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			panel1 = new JPanel();
			contentPanel.add(panel1, "name_428725178558000");
			panel1.setLayout(null);
			{
				JPanel panelInformacionGe = new JPanel();
				panelInformacionGe.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelInformacionGe.setBounds(10, 25, 576, 169);
				panel1.add(panelInformacionGe);
				panelInformacionGe.setLayout(null);
				{
					JLabel lblCedula = new JLabel("C\u00E9dula:");
					lblCedula.setBounds(10, 33, 44, 14);
					panelInformacionGe.add(lblCedula);
				}
				{
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(10, 64, 56, 14);
					panelInformacionGe.add(lblNombre);
				}
				{
					textNombre = new JTextField();
					textNombre.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char validar= e.getKeyChar();
							if(Character.isDigit(validar)) {
								getToolkit ().beep();
								e.consume();
								JOptionPane.showMessageDialog(null, "No se permiten números");
							}
						}
					});
					textNombre.setBounds(89, 61, 131, 20);
					panelInformacionGe.add(textNombre);
					textNombre.setColumns(10);
				}
				{
					JLabel lblApellidos = new JLabel("Apellidos:");
					lblApellidos.setBounds(10, 95, 56, 14);
					panelInformacionGe.add(lblApellidos);
				}
				{
					textApellidos = new JTextField();
					textApellidos.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char validar= e.getKeyChar();
							if(Character.isDigit(validar)) {
								getToolkit ().beep();
								e.consume();
								JOptionPane.showMessageDialog(null, "No se permiten números");
							}
						}
					});
					textApellidos.setBounds(89, 92, 131, 20);
					panelInformacionGe.add(textApellidos);
					textApellidos.setColumns(10);
				}
				{
					JLabel lblFechaNacim = new JLabel("Nacimiento:");
					lblFechaNacim.setBounds(10, 126, 67, 14);
					panelInformacionGe.add(lblFechaNacim);
				}
				{
					JLabel lblSexo = new JLabel("Sexo:");
					lblSexo.setBounds(295, 33, 46, 14);
					panelInformacionGe.add(lblSexo);
				}
				
				rdbMasculino = new JRadioButton("M");
				rdbMasculino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbMasculino.setSelected(true);
						rdbFemenino.setSelected(false);

					}
				});
				rdbMasculino.setBounds(382, 29, 44, 23);
				panelInformacionGe.add(rdbMasculino);
				
				rdbFemenino = new JRadioButton("F");
				rdbFemenino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbMasculino.setSelected(false);
						rdbFemenino.setSelected(true);
					}
				});
				rdbFemenino.setBounds(428, 29, 56, 23);
				panelInformacionGe.add(rdbFemenino);
				
				JLabel lblEstadoCivil = new JLabel("Estado Civil:");
				lblEstadoCivil.setBounds(295, 64, 79, 14);
				panelInformacionGe.add(lblEstadoCivil);
				
				cbxEstadoCivil = new JComboBox();
				cbxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Casado / Unido", "Divorceado / Viudo", "Soltero"}));
				cbxEstadoCivil.setBounds(382, 60, 133, 22);
				panelInformacionGe.add(cbxEstadoCivil);
				
				JLabel lblNacionalidad = new JLabel("Nacionalidad:");
				lblNacionalidad.setBounds(295, 95, 79, 14);
				panelInformacionGe.add(lblNacionalidad);
				
				cbxNacionalidad = new JComboBox();
				cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Alemana", "Argentina", "Belga", "Boliviana", "Brasile\u00F1a", "Canadiense", "China", "Colombiana", "Costarricense", "Cubana", "Danesa", "Dominicana", "Espa\u00F1ola", "Filipina", "Francesa", "Griega", "Guatemalteca", "Haitiana", "Holandesa", "Hondure\u00F1a", "Inglesa", "Israel\u00ED", "Italiana", "Jamaiquina", "Japonesa", "Estadounidense", "Mexicana", "Peruana", "Puertorrique\u00F1a", "Rusa", "Sueca", "Suiza", "Surcoreana", "Venezolana"}));
				cbxNacionalidad.setBounds(382, 91, 133, 22);
				panelInformacionGe.add(cbxNacionalidad);
				
				JLabel lblLicencia = new JLabel("Licencia: ");
				lblLicencia.setBounds(295, 126, 56, 14);
				panelInformacionGe.add(lblLicencia);
				
				cbxLicencia = new JComboBox();
				cbxLicencia.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "No Poseo Licencia", "Categor\u00EDa 1", "Categor\u00EDa 2", "Categor\u00EDa 3", "Categor\u00EDa 4"}));
				cbxLicencia.setBounds(382, 122, 133, 22);
				panelInformacionGe.add(cbxLicencia);
				
				MaskFormatter mascaraCedula;
				try {
					mascaraCedula = new MaskFormatter("###-#######-#");
					mascaraCedula.setPlaceholderCharacter('_');
				    ftextCedula = new JFormattedTextField(mascaraCedula);
				    ftextCedula.setBounds(89, 30, 131, 20);
				    panelInformacionGe.add(ftextCedula);
				    
				    JDateChooser dateChooser = new JDateChooser();
				    dateChooser.setBounds(89, 123, 131, 20);
				    panelInformacionGe.add(dateChooser);
				
				}catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			JPanel panelUbicacionA = new JPanel();
			panelUbicacionA.setBorder(new TitledBorder(null, "Ubicaci\u00F3n Actual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelUbicacionA.setBounds(10, 205, 576, 165);
			panel1.add(panelUbicacionA);
			panelUbicacionA.setLayout(null);
			{
				JLabel lblProvincia = new JLabel("Provincia: ");
				lblProvincia.setBounds(10, 30, 59, 14);
				panelUbicacionA.add(lblProvincia);
			}
			{
				cbxProvincias = new JComboBox();
				cbxProvincias.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "S\u00E1nchez Ram\u00EDrez", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
				cbxProvincias.setBounds(97, 26, 131, 22);
				panelUbicacionA.add(cbxProvincias);
			}
			{
				JLabel lblCiudad = new JLabel("Ciudad: ");
				lblCiudad.setBounds(10, 76, 59, 14);
				panelUbicacionA.add(lblCiudad);
			}
			
			textCiudad = new JTextField();
			textCiudad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char validar= e.getKeyChar();
					if(Character.isDigit(validar)) {
						getToolkit ().beep();
						e.consume();
						JOptionPane.showMessageDialog(null, "No se permiten números");
					}
				}
			});
			textCiudad.setBounds(97, 73, 131, 20);
			panelUbicacionA.add(textCiudad);
			textCiudad.setColumns(10);
			
			JLabel lblSector = new JLabel("Sector: ");
			lblSector.setBounds(10, 122, 59, 14);
			panelUbicacionA.add(lblSector);
			
			
			textSector = new JTextField();
			textSector.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char validar= e.getKeyChar();
					if(Character.isDigit(validar)) {
						getToolkit ().beep();
						e.consume();
						JOptionPane.showMessageDialog(null, "No se permiten números");
					}
				}
			});
			textSector.setBounds(97, 119, 131, 20);
			panelUbicacionA.add(textSector);
			textSector.setColumns(10);
			{
				JLabel lblCalle = new JLabel("Calle:");
				lblCalle.setBounds(307, 30, 46, 14);
				panelUbicacionA.add(lblCalle);
			}
			{
				textCalle = new JTextField();
				textCalle.setBounds(391, 27, 131, 20);
				panelUbicacionA.add(textCalle);
				textCalle.setColumns(10);
			}
			{
				JLabel lblNumeroCasa = new JLabel("N\u00FAmero:");
				lblNumeroCasa.setBounds(307, 76, 52, 14);
				panelUbicacionA.add(lblNumeroCasa);
			}
			
			spnNumeroCasa = new JSpinner();
			spnNumeroCasa.setBounds(391, 73, 131, 20);
			panelUbicacionA.add(spnNumeroCasa);
			
			JLabel lblReferencia = new JLabel("Referencia:");
			lblReferencia.setBounds(307, 122, 74, 14);
			panelUbicacionA.add(lblReferencia);
			
			textReferencia = new JTextField();
			textReferencia.setBounds(391, 119, 131, 20);
			panelUbicacionA.add(textReferencia);
			textReferencia.setColumns(10);
		}
		{
			panel2 = new JPanel();
			contentPanel.add(panel2, "name_428725249088700");
			panel2.setLayout(null);
			
			panelContacto = new JPanel();
			panelContacto.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelContacto.setBounds(10, 11, 566, 86);
			panel2.add(panelContacto);
			panelContacto.setLayout(null);
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
			lblTelefono.setBounds(10, 34, 66, 14);
			panelContacto.add(lblTelefono);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(266, 34, 46, 14);
			panelContacto.add(lblEmail);
			
			textField = new JTextField();
			textField.setBounds(316, 30, 226, 23);
			panelContacto.add(textField);
			textField.setColumns(10);
			
			MaskFormatter mascaraTelefono;
			try {
				mascaraTelefono = new MaskFormatter("(###) ### - ####");
				mascaraTelefono.setPlaceholderCharacter('_');
			    ftextTelefono = new JFormattedTextField(mascaraTelefono);
			    ftextTelefono.setBounds(75, 30, 140, 22);
			    panelContacto.add(ftextTelefono);
			
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
			JPanel panelInfoGeneral = new JPanel();
			panelInfoGeneral.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoGeneral.setBounds(10, 107, 566, 104);
			panel2.add(panelInfoGeneral);
			panelInfoGeneral.setLayout(null);
			
			JLabel lblVehiculo = new JLabel("Veh\u00EDculo Propio: ");
			lblVehiculo.setBounds(10, 30, 96, 14);
			panelInfoGeneral.add(lblVehiculo);
			
			rbtnSiVehiculoPro = new JRadioButton("S\u00ED");
			rbtnSiVehiculoPro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiVehiculoPro.setSelected(true);
					rbtnNoVehiculoPro.setSelected(false);
				}
			});
			rbtnSiVehiculoPro.setBounds(125, 26, 48, 23);
			panelInfoGeneral.add(rbtnSiVehiculoPro);
			
		    rbtnNoVehiculoPro = new JRadioButton("No");
		    rbtnNoVehiculoPro.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		rbtnSiVehiculoPro.setSelected(false);
					rbtnNoVehiculoPro.setSelected(true);
		    	}
		    });
			rbtnNoVehiculoPro.setBounds(193, 26, 48, 23);
			panelInfoGeneral.add(rbtnNoVehiculoPro);
			
			JLabel lblDisponibilidadM = new JLabel("Disponibilidad de mudarse:");
			lblDisponibilidadM.setBounds(10, 68, 163, 14);
			panelInfoGeneral.add(lblDisponibilidadM);
			
			rbtnSiDisponibilidad = new JRadioButton("S\u00ED\r\n");
			rbtnSiDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDisponibilidad.setSelected(true);
					rbtnNoDisponibilidad.setSelected(false);
				}
			});
			rbtnSiDisponibilidad.setBounds(170, 64, 39, 23);
			panelInfoGeneral.add(rbtnSiDisponibilidad);
			
			rbtnNoDisponibilidad = new JRadioButton("No");
			rbtnNoDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDisponibilidad.setSelected(false);
					rbtnNoDisponibilidad.setSelected(true);
				}
			});
			rbtnNoDisponibilidad.setBounds(211, 64, 48, 23);
			panelInfoGeneral.add(rbtnNoDisponibilidad);
			
			JSeparator separator = new JSeparator();
			separator.setBackground(Color.RED);
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(265, 11, 8, 82);
			panelInfoGeneral.add(separator);
			
			JLabel lblIdiomas = new JLabel("Idiomas: ");
			lblIdiomas.setBounds(290, 11, 56, 14);
			panelInfoGeneral.add(lblIdiomas);
			
			cbxIdiomas = new JComboBox();
			cbxIdiomas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!misIdiomas.contains(cbxIdiomas.getSelectedItem().toString())
							&& cbxIdiomas.getSelectedIndex() > 0) {
						misIdiomas.add(cbxIdiomas.getSelectedItem().toString());
						modeloIdiomas.removeAllElements();
						loadIdioma();
						cbxIdiomas.setSelectedIndex(0);
					} else if (misIdiomas.contains(cbxIdiomas.getSelectedItem().toString())) {
						panel2.setVisible(true);
					}
				}
			});
			cbxIdiomas.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Afrikaans", "Alban\u00E9s", "Alem\u00E1n", "Amharico", "Arabe", "Armenio", "Bengali", "Bieloruso", "Birman\u00E9s", "Bulgaro", "Catalan", "Checo", "Chino", "Coreano", "Croata", "Dan\u00E9s", "Dari", "Dzongkha", "Escoc\u00E9s", "Eslovaco", "Esloveniano", "Espa\u00F1ol", "Esperanto", "Estoniano", "Faroese", "Farsi", "Finland\u00E9s", "Franc\u00E9s", "Gaelico", "Galese", "Gallego", "Griego", "Hebreo", "Hindi", "Holand\u00E9s", "Hungaro", "Ingl\u00E9s", "Indonesio", "Inuktitut (Eskimo)", "Islandico", "Italiano", "Japon\u00E9s", "Khmer", "Kurdo", "Lao", "Laponico", "Latviano", "Lituano", "Macedonio", "Malay\u00E9s", "Malt\u00E9s", "Nepali", "Noruego", "Pashto", "Polaco", "Portugu\u00E9s", "Rumano", "Ruso", "Serbio", "Somali", "Suahili", "Sueco", "Tagalog-Filipino", "Tajik", "Tamil", "Tailand\u00E9s", "Tibetano", "Tigrinia", "Tongan\u00E9s", "Turco", "Turkmenistano", "Ucraniano", "Urdu", "Uzbekistano", "Vasco", "Vietnam\u00E9s"}));
			cbxIdiomas.setBounds(273, 36, 123, 23);
			panelInfoGeneral.add(cbxIdiomas);
			
			btnEliminarIdioma = new JButton("Remover\r\n");
			btnEliminarIdioma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = listIdiomas.getSelectedIndex();
					String idioma = listIdiomas.getSelectedValue().toString();
					modeloIdiomas.remove(index);
					eliminarIdioma(idioma);
					btnEliminarIdioma.setEnabled(false);

				}
			});
			btnEliminarIdioma.setEnabled(false);
			btnEliminarIdioma.setBounds(290, 64, 89, 23);
			panelInfoGeneral.add(btnEliminarIdioma);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(406, 20, 142, 67);
			panelInfoGeneral.add(scrollPane);
			
			listIdiomas = new JList();
			listIdiomas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnEliminarIdioma.setEnabled(true);
				}
			});
			scrollPane.setViewportView(listIdiomas);
			
			JPanel panelTipoSolicitante = new JPanel();
			panelTipoSolicitante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTipoSolicitante.setBounds(10, 216, 566, 49);
			panel2.add(panelTipoSolicitante);
			panelTipoSolicitante.setLayout(null);
			
			rbtnObrero = new JRadioButton("Obrero\r\n");
			rbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.setEnabled(true);
					rbtnObrero.setSelected(true);
					rbtnTecnico.setSelected(false);
					rbtnUniversitario.setSelected(false);
					panelObrero.setVisible(true);
					//panel_Tecnico.setVisible(false);
					//panel_Universitario.setVisible(false);
				}
			});
			rbtnObrero.setBounds(72, 19, 84, 23);
			panelTipoSolicitante.add(rbtnObrero);
			
			rbtnTecnico = new JRadioButton("T\u00E9cnico");
			rbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.setEnabled(true);
					rbtnObrero.setSelected(false);
					rbtnTecnico.setSelected(true);
					rbtnUniversitario.setSelected(false);
					panelObrero.setVisible(false);
					//panel_Tecnico.setVisible(true);
					//panel_Universitario.setVisible(false);
				}
			});
			rbtnTecnico.setBounds(228, 19, 84, 23);
			panelTipoSolicitante.add(rbtnTecnico);
			
			rbtnUniversitario = new JRadioButton("Universitario");
			rbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.setEnabled(true);
					rbtnObrero.setSelected(false);
					rbtnTecnico.setSelected(false);
					rbtnUniversitario.setSelected(true);
					panelObrero.setVisible(false);
					//panelTecnico.setVisible(false);
					//panelUniversitario.setVisible(true);
				}
			});
			rbtnUniversitario.setBounds(384, 19, 109, 23);
			panelTipoSolicitante.add(rbtnUniversitario);
			
			
			panelObrero = new JPanel();
			panelObrero.setBorder(new TitledBorder(null, "Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelObrero.setBounds(10, 267, 566, 112);
			panel2.add(panelObrero);
			panelObrero.setLayout(null);
			
			JLabel lblHabilidades = new JLabel("Habilidades:");
			lblHabilidades.setBounds(288, 26, 71, 14);
			panelObrero.add(lblHabilidades);
			
			cbxHabilidades = new JComboBox();
			cbxHabilidades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!misHabilidades.contains(cbxHabilidades.getSelectedItem().toString())
							&& cbxHabilidades.getSelectedIndex() > 0) {
						misHabilidades.add(cbxHabilidades.getSelectedItem().toString());
						modeloHabilidad.removeAllElements();
						loadHabilidades();
					} else if (misHabilidades.contains(cbxHabilidades.getSelectedItem().toString())) {
						panel2.setVisible(true);
					}
				}
				
			});
			cbxHabilidades.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Alba\u00F1il", "Anfitri\u00F3n de Fiesta", "Artesano", "Carpintero", "Chofer", "Chef", "Constructor", "Decorador", "Ebanista", "Electricista", "Mec\u00E1nico", "Pintor", "Plomero", "Salva Vidas", "Modista", "Seguridad", "Sirviente", "Jardinero"}));
			cbxHabilidades.setBounds(276, 47, 123, 22);
			panelObrero.add(cbxHabilidades);
			
			btnRemoverH = new JButton("Remover");
			btnRemoverH.setEnabled(false);
			btnRemoverH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = listHabilidades.getSelectedIndex();
					String habilidad = listHabilidades.getSelectedValue().toString();
					modeloHabilidad.remove(index);
					eliminarHabilidad(habilidad);
					btnRemoverH.setEnabled(false);
				}
			});
			
			btnRemoverH.setBounds(298, 80, 89, 23);
			panelObrero.add(btnRemoverH);
			JScrollPane scrollPaneH = new JScrollPane();
			scrollPaneH.setBounds(409, 22, 140, 65);
			panelObrero.add(scrollPaneH);
			
			listHabilidades = new JList();
			listHabilidades.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnRemoverH.setEnabled(true);
				}
			});
			scrollPaneH.setViewportView(listHabilidades);
			
			
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBackground(Color.RED);
			separator_1.setOrientation(SwingConstants.VERTICAL);
			separator_1.setBounds(270, 11, 2, 92);
			panelObrero.add(separator_1);
			
			
			
			JLabel lblYearExpe = new JLabel("A\u00F1os de Experiencia:");
			lblYearExpe.setBounds(10, 51, 123, 14);
			panelObrero.add(lblYearExpe);
			
			spnYearExpO = new JSpinner();
			spnYearExpO.setBounds(143, 48, 114, 20);
			panelObrero.add(spnYearExpO);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnContinuar = new JButton("Continuar");
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean igual = false;
					String sexo = "";
					if (rdbFemenino.isSelected()) {
						sexo = "Femenino";
					} else if (rdbMasculino.isSelected()) {
						sexo = "Masculino";
					}
					
					if(panel1.isVisible()) {
					
					if(!Bolsa_Laboral.getInstance().getMisSolicitantes().isEmpty()) {
						for (Personal personal : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
							if (ftextCedula.getText().equalsIgnoreCase(personal.getCedula())) {
								igual=true;
							}
						  }
						}
						if(igual==true) {
							JOptionPane.showMessageDialog(null,"Ya existe una persona registrada con esa cedula");
						}
						else if(ftextCedula.getText().equalsIgnoreCase("___-_______-_")||textNombre.getText().isEmpty()|| textApellidos.getText().isEmpty()||textCiudad.getText().isEmpty() || cbxLicencia.getSelectedIndex() == 0 || cbxProvincias.getSelectedIndex() == 0 || sexo.equalsIgnoreCase("") ) {
							JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
						}
					}
					
					panel1.setVisible(false);
					panel2.setVisible(true);
				}
				}
			);
			buttonPane.add(btnContinuar);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setHorizontalAlignment(SwingConstants.RIGHT);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	
	public void loadIdioma() {
		for (String idioma : misIdiomas) {
			modeloIdiomas.addElement(idioma);
		}
		listIdiomas.setModel(modeloIdiomas);
	}
	
	public void eliminarIdioma(String idioma) {
		int index = 0;
		for (int i = 0; i < misIdiomas.size(); i++) {
			if (misIdiomas.get(i).equalsIgnoreCase(idioma)) {
				index = i;
			}
		}
		misIdiomas.remove(index);
	}
	
	public void loadHabilidades() {
		for (String habilidad : misHabilidades) {
			modeloHabilidad.addElement(habilidad);
		}
		listHabilidades.setModel(modeloHabilidad);
	}
	
	public void eliminarHabilidad(String habilidad) {
		int index = 0;
		for (int i = 0; i < misHabilidades.size(); i++) {
			if (misHabilidades.get(i).equalsIgnoreCase(habilidad)) {
				index = i;
			}
		}
		misHabilidades.remove(index);
	}

}
