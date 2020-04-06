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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logic.Bachiller;
import logic.Bolsa_Laboral;
import logic.Personal;
import logic.Tecnico;
import logic.Universitario;


import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.SpinnerNumberModel;

public class InsertarSolicitante extends JDialog {
//jeje //
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
	private JComboBox cbxAreaTecnico;
	private JComboBox cbxCarrera;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFemenino;
	private JRadioButton rbtnSiVehiculoPro;
	private JRadioButton rbtnNoVehiculoPro;
	private JRadioButton rbtnSiDisponibilidad;
	private JRadioButton rbtnNoDisponibilidad;
	private JRadioButton rdbSiPost;
	private JRadioButton rdbNoPost;
	private JRadioButton rbtnBachiller;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnUniversitario;
	private JSpinner spnNumeroCasa;
	private JSpinner spnYearT;
	private JSpinner spnYearExpO;
	private JSpinner spnAnosExpUniversitario;
	private JTextField textEmail;
	private JPanel pnlBachiller;
	private JList listIdiomas;
	private JList listHabilidades;
	private JDateChooser dateChooser;
	private ArrayList<String> misIdiomas = new ArrayList<>();
	private ArrayList<String> misHabilidades = new ArrayList<>();
	private DefaultListModel<String> modeloIdiomas = new DefaultListModel<>();
	private DefaultListModel<String> modeloHabilidad = new DefaultListModel<>();
	private JPanel pnlTecnico;
	private JPanel pnlUniversitario;
	private boolean estado = false;
	private boolean error = false;
	private Personal modiS = null;
	private Personal verSoli = null;
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			InsertarSolicitante dialog = new InsertarSolicitante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public InsertarSolicitante(String title, boolean modificar, Personal solicitante, Personal persona) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertarSolicitante.class.getResource("/icons/agregarSolicitante.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
				if (modificar) {
					loadSolicitanteModi();
				}
				if (persona != null) {

				}
			}
		});
		modiS = solicitante;
		verSoli = persona;
		setTitle("Insertar Solicitante");
		setBounds(100, 100, 612, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null);
		{
			panel1 = new JPanel();
			panel1.setBackground(SystemColor.inactiveCaptionBorder);
			contentPanel.add(panel1, "name_428725178558000");
			panel1.setLayout(null);
			{
				JPanel panelInformacionGe = new JPanel();
				panelInformacionGe.setBackground(SystemColor.inactiveCaptionBorder);
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
				rdbMasculino.setBackground(SystemColor.inactiveCaptionBorder);
				rdbMasculino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbMasculino.setSelected(true);
						rdbFemenino.setSelected(false);

					}
				});
				rdbMasculino.setBounds(382, 29, 44, 23);
				panelInformacionGe.add(rdbMasculino);
				
				rdbFemenino = new JRadioButton("F");
				rdbFemenino.setBackground(SystemColor.inactiveCaptionBorder);
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
				cbxEstadoCivil.setBackground(Color.WHITE);
				cbxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Casado / Unido", "Divorceado / Viudo", "Soltero"}));
				cbxEstadoCivil.setBounds(382, 60, 133, 22);
				panelInformacionGe.add(cbxEstadoCivil);
				
				JLabel lblNacionalidad = new JLabel("Nacionalidad:");
				lblNacionalidad.setBounds(295, 95, 79, 14);
				panelInformacionGe.add(lblNacionalidad);
				
				cbxNacionalidad = new JComboBox();
				cbxNacionalidad.setBackground(Color.WHITE);
				cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"< Seleccione >", "Alemana", "Argentina", "Belga", "Boliviana", "Brasile\u00F1a", "Canadiense", "China", "Colombiana", "Costarricense", "Cubana", "Danesa", "Dominicana", "Espa\u00F1ola", "Filipina", "Francesa", "Griega", "Guatemalteca", "Haitiana", "Holandesa", "Hondure\u00F1a", "Inglesa", "Israel\u00ED", "Italiana", "Jamaiquina", "Japonesa", "Estadounidense", "Mexicana", "Peruana", "Puertorrique\u00F1a", "Rusa", "Sueca", "Suiza", "Surcoreana", "Venezolana"}));
				cbxNacionalidad.setBounds(382, 91, 133, 22);
				panelInformacionGe.add(cbxNacionalidad);
				
				JLabel lblLicencia = new JLabel("Licencia: ");
				lblLicencia.setBounds(295, 126, 56, 14);
				panelInformacionGe.add(lblLicencia);
				
				cbxLicencia = new JComboBox();
				cbxLicencia.setBackground(Color.WHITE);
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
				
				}catch (ParseException e) {
					e.printStackTrace();
				}
				

			    dateChooser = new JDateChooser();
			    dateChooser.setBackground(SystemColor.inactiveCaptionBorder);
			    dateChooser.setBounds(89, 123, 131, 20);
			    panelInformacionGe.add(dateChooser);
			}
			
			JPanel panelUbicacionA = new JPanel();
			panelUbicacionA.setBackground(SystemColor.inactiveCaptionBorder);
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
				cbxProvincias.setBackground(Color.WHITE);
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
			spnNumeroCasa.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
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
			panel2.setBackground(SystemColor.inactiveCaptionBorder);
			contentPanel.add(panel2, "name_428725249088700");
			panel2.setLayout(null);
			
			panelContacto = new JPanel();
			panelContacto.setBackground(SystemColor.inactiveCaptionBorder);
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
			
			textEmail = new JTextField();
			textEmail.setBounds(316, 30, 226, 23);
			panelContacto.add(textEmail);
			textEmail.setColumns(10);
			
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
			panelInfoGeneral.setBackground(SystemColor.inactiveCaptionBorder);
			panelInfoGeneral.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoGeneral.setBounds(10, 107, 566, 104);
			panel2.add(panelInfoGeneral);
			panelInfoGeneral.setLayout(null);
			
			JLabel lblVehiculo = new JLabel("Veh\u00EDculo Propio: ");
			lblVehiculo.setBounds(10, 30, 96, 14);
			panelInfoGeneral.add(lblVehiculo);
			
			rbtnSiVehiculoPro = new JRadioButton("S\u00ED");
			rbtnSiVehiculoPro.setBackground(SystemColor.inactiveCaptionBorder);
			rbtnSiVehiculoPro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiVehiculoPro.setSelected(true);
					rbtnNoVehiculoPro.setSelected(false);
				}
			});
			rbtnSiVehiculoPro.setBounds(125, 26, 48, 23);
			panelInfoGeneral.add(rbtnSiVehiculoPro);
			
		    rbtnNoVehiculoPro = new JRadioButton("No");
		    rbtnNoVehiculoPro.setBackground(SystemColor.inactiveCaptionBorder);
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
			rbtnSiDisponibilidad.setBackground(SystemColor.inactiveCaptionBorder);
			rbtnSiDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDisponibilidad.setSelected(true);
					rbtnNoDisponibilidad.setSelected(false);
				}
			});
			rbtnSiDisponibilidad.setBounds(170, 64, 39, 23);
			panelInfoGeneral.add(rbtnSiDisponibilidad);
			
			rbtnNoDisponibilidad = new JRadioButton("No");
			rbtnNoDisponibilidad.setBackground(SystemColor.inactiveCaptionBorder);
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
			cbxIdiomas.setBackground(Color.WHITE);
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
			panelTipoSolicitante.setBackground(SystemColor.inactiveCaptionBorder);
			panelTipoSolicitante.setBorder(new TitledBorder(new TitledBorder(null, "Tipo de Solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null)));
			panelTipoSolicitante.setBounds(10, 216, 566, 49);
			panel2.add(panelTipoSolicitante);
			panelTipoSolicitante.setLayout(null);
			
			rbtnBachiller = new JRadioButton("Bachiller\r\n");
			rbtnBachiller.setBackground(SystemColor.inactiveCaptionBorder);
			rbtnBachiller.setSelected(true);
			rbtnBachiller.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						btnRegistrar.setEnabled(true);
						rbtnBachiller.setSelected(true);
						rbtnTecnico.setSelected(false);
						rbtnUniversitario.setSelected(false);
						pnlBachiller.setVisible(true);
						pnlTecnico.setVisible(false);
						pnlUniversitario.setVisible(false);
				}
			});
			rbtnBachiller.setBounds(72, 19, 84, 23);
			panelTipoSolicitante.add(rbtnBachiller);
			
			rbtnTecnico = new JRadioButton("T\u00E9cnico");
			rbtnTecnico.setBackground(SystemColor.inactiveCaptionBorder);
			rbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.setEnabled(true);
					rbtnBachiller.setSelected(false);
					rbtnTecnico.setSelected(true);
					rbtnUniversitario.setSelected(false);
					pnlBachiller.setVisible(false);
					pnlTecnico.setVisible(true);
					pnlUniversitario.setVisible(false);
				}
			});
			rbtnTecnico.setBounds(228, 19, 84, 23);
			panelTipoSolicitante.add(rbtnTecnico);
			
			rbtnUniversitario = new JRadioButton("Universitario");
			rbtnUniversitario.setBackground(SystemColor.inactiveCaptionBorder);
			rbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.setEnabled(true);
					rbtnBachiller.setSelected(false);
					rbtnTecnico.setSelected(false);
					rbtnUniversitario.setSelected(true);
					pnlBachiller.setVisible(false);
					pnlTecnico.setVisible(false);
					pnlUniversitario.setVisible(true);
				}
			});
			rbtnUniversitario.setBounds(384, 19, 109, 23);
			panelTipoSolicitante.add(rbtnUniversitario);
			
			
			pnlBachiller = new JPanel();
			pnlBachiller.setBackground(SystemColor.inactiveCaptionBorder);
			pnlBachiller.setBorder(new TitledBorder(null, "Bachiller", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlBachiller.setBounds(10, 267, 566, 112);
			panel2.add(pnlBachiller);
			pnlBachiller.setLayout(null);
			
			JLabel lblHabilidades = new JLabel("Habilidades:");
			lblHabilidades.setBounds(288, 26, 71, 14);
			pnlBachiller.add(lblHabilidades);
			
			cbxHabilidades = new JComboBox();
			cbxHabilidades.setBackground(Color.WHITE);
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
			pnlBachiller.add(cbxHabilidades);
			
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
			pnlBachiller.add(btnRemoverH);
			JScrollPane scrollPaneH = new JScrollPane();
			scrollPaneH.setBounds(409, 22, 140, 65);
			pnlBachiller.add(scrollPaneH);
			
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
			pnlBachiller.add(separator_1);
			
			
			
			JLabel lblYearExpe = new JLabel("A\u00F1os de Experiencia:");
			lblYearExpe.setBounds(10, 51, 123, 14);
			pnlBachiller.add(lblYearExpe);
			
			spnYearExpO = new JSpinner();
			spnYearExpO.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnYearExpO.setBounds(143, 48, 114, 20);
			pnlBachiller.add(spnYearExpO);
			
			pnlTecnico = new JPanel();
			pnlTecnico.setBackground(SystemColor.inactiveCaptionBorder);
			pnlTecnico.setBorder(new TitledBorder(null, "T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlTecnico.setBounds(10, 267, 566, 112);
			panel2.add(pnlTecnico);
			pnlTecnico.setLayout(null);
			pnlTecnico.setVisible(false);
			
			JLabel lblYear = new JLabel("A\u00F1os de Experiencia:");
			lblYear.setBounds(10, 49, 132, 14);
			pnlTecnico.add(lblYear);
			
			spnYearT = new JSpinner();
			spnYearT.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnYearT.setBackground(new Color(248, 248, 255));
			spnYearT.setBounds(146, 46, 123, 23);
			pnlTecnico.add(spnYearT);

			JLabel lblrea = new JLabel("\u00C1rea:");
			lblrea.setBounds(310, 49, 38, 14);
			pnlTecnico.add(lblrea);
			
			cbxAreaTecnico = new JComboBox();
			cbxAreaTecnico.setBackground(Color.WHITE);
			cbxAreaTecnico.setModel(
					new DefaultComboBoxModel(new String[] { "< Seleccione >", "Emprendimiento", "Mecanograf\u00EDa",
							"Dise\u00F1o Gr\u00E1fico", "Programaci\u00F3n", "Contabilidad", "Programaci\u00F3n Web" }));
			cbxAreaTecnico.setBounds(396, 46, 123, 23);
			pnlTecnico.add(cbxAreaTecnico);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setOrientation(SwingConstants.VERTICAL);
			separator_2.setBackground(Color.RED);
			separator_2.setBounds(290, 11, 2, 92);
			pnlTecnico.add(separator_2);

			
			pnlUniversitario = new JPanel();
			pnlUniversitario.setBackground(SystemColor.inactiveCaptionBorder);
			pnlUniversitario.setBorder(new TitledBorder(null, "Universitario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlUniversitario.setBounds(10, 267, 566, 112);
			panel2.add(pnlUniversitario);
			pnlUniversitario.setLayout(null);
			pnlUniversitario.setVisible(false);
			
	    	JLabel lblAnosExpUniversitario = new JLabel("A\u00F1os de Experiencia:");
			lblAnosExpUniversitario.setBounds(10, 49, 132, 14);
			pnlUniversitario.add(lblAnosExpUniversitario);

				spnAnosExpUniversitario = new JSpinner();
				spnAnosExpUniversitario.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnAnosExpUniversitario.setBackground(new Color(248, 248, 255));
				spnAnosExpUniversitario.setBounds(146, 46, 123, 23);
				pnlUniversitario.add(spnAnosExpUniversitario);
				
				JLabel lblCarrera = new JLabel("Carrera:");
				lblCarrera.setBounds(305, 26, 65, 14);
				pnlUniversitario.add(lblCarrera);
				
				cbxCarrera = new JComboBox();
				cbxCarrera.setBackground(Color.WHITE);
				cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "< Seleccione >", "Adm. de Empresas",
						"Adm. Hotelera", "Derecho", "Econom\u00EDa", "Contabilidad", "Mercadotecnia", "Arquitectura",
						"Comunicacion Social", "Dise\u00F1o e Interiorismo", "Ecologia", "Educaci\u00F3n", "Filosof\u00EDa",
						"Psicolog\u00EDa", "Ing. Civil", "Ing. Electr\u00F3nica", "Ing. Industrial", "Ing. Mecatr\u00F3nica",
						"Ing. Sistema", "Ing. Telem\u00E1tica", "Enfermeria", "Estomatolog\u00EDa", "Medicina",
						"Nutricion y Dietetica", "Terapia F\u00EDsica" }));
				cbxCarrera.setBounds(391, 23, 123, 23);
				pnlUniversitario.add(cbxCarrera);

				JLabel lblPostgrado = new JLabel("PostGrado:");
				lblPostgrado.setBounds(305, 64, 65, 14);
				pnlUniversitario.add(lblPostgrado);
				
				rdbSiPost = new JRadioButton("S\u00ED");
				rdbSiPost.setBackground(SystemColor.inactiveCaptionBorder);
				rdbSiPost.setBounds(391, 60, 38, 23);
				pnlUniversitario.add(rdbSiPost);

				rdbNoPost = new JRadioButton("No");
				rdbNoPost.setBackground(SystemColor.inactiveCaptionBorder);
				rdbNoPost.setBounds(431, 60, 58, 23);
				pnlUniversitario.add(rdbNoPost);
				
				JSeparator separator_3 = new JSeparator();
				separator_3.setOrientation(SwingConstants.VERTICAL);
				separator_3.setBackground(Color.RED);
				separator_3.setBounds(290, 11, 2, 92);
				pnlUniversitario.add(separator_3);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnContinuar = new JButton("Continuar");
			btnContinuar.setIcon(new ImageIcon(InsertarSolicitante.class.getResource("/icons/Siguiente.png")));
			btnContinuar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String sexo2 = "";
					String fecha2 = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
					if (rdbFemenino.isSelected()) {
						sexo2 = "Femenino";
					} else if (rdbMasculino.isSelected()) {
						sexo2 = "Masculino";
					}
					if (panel2.isVisible() ) {
					if(!ftextCedula.getText().equalsIgnoreCase("___-_______-_") && !textNombre.getText().isEmpty() &&  !textApellidos.getText().isEmpty() && !textCiudad.getText().isEmpty() && cbxLicencia.getSelectedIndex() != 0 && cbxProvincias.getSelectedIndex() != 0 && !sexo2.equalsIgnoreCase("") && !fecha2.equalsIgnoreCase("")) {
						
						
						btnContinuar.setIcon(
						
								new ImageIcon(InsertarSolicitante.class.getResource("/icons/Siguiente.png")));
					}
					}
					 else {
						btnContinuar.setIcon(
								new ImageIcon(InsertarSolicitante.class.getResource("/icons/retroceso.png")));
					}
					
					boolean igual = false;
					String sexo = "";
					String fecha = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
					if (rdbFemenino.isSelected()) {
						sexo = "Femenino";
					} else if (rdbMasculino.isSelected()) {
						sexo = "Masculino";
					}
				
				if (panel2.isVisible()) {
					estado = false;
					panel2.setVisible(false);
					panel1.setVisible(true);
					btnContinuar.setText("Continuar");
				}
					
					else if(panel1.isVisible()) {
						if(!modificar) {
					
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
						}
						else if(ftextCedula.getText().equalsIgnoreCase("___-_______-_")||textNombre.getText().isEmpty()|| textApellidos.getText().isEmpty()||textCiudad.getText().isEmpty() || cbxLicencia.getSelectedIndex() == 0 || cbxProvincias.getSelectedIndex() == 0 || sexo.equalsIgnoreCase("") || fecha.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
						}else {
							if (!modificar) {
								estado = true;
								btnRegistrar.setEnabled(true);
								rbtnBachiller.setSelected(true);
								rbtnTecnico.setSelected(false);
								rbtnUniversitario.setSelected(false);
								pnlBachiller.setVisible(true);
								pnlTecnico.setVisible(false);
								pnlUniversitario.setVisible(false);
								panel1.setVisible(false);
								panel2.setVisible(true);
								btnContinuar.setText("Retroceder");

							} else {
								btnRegistrar.setEnabled(true);
								btnContinuar.setText("Retroceder");
								panel1.setVisible(false);
								panel2.setVisible(true);
							}
							if (persona != null) {

								btnRegistrar.setEnabled(false);
							}
						}
					}
				}
				});
			buttonPane.add(btnContinuar);
			{
				btnRegistrar = new JButton("Registrar");
				if (!modificar) {
					btnRegistrar.setIcon(new ImageIcon(InsertarSolicitante.class.getResource("/icons/add.png")));
				} else {
					btnRegistrar.setIcon(new ImageIcon(InsertarSolicitante.class.getResource("/icons/modificar.png")));
				}
				
				
				btnRegistrar.setEnabled(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean error = false;

						String cedula = ftextCedula.getText();
						String nombre = textNombre.getText();
						String apellido = textApellidos.getText();
						String telefono = ftextTelefono.getText();
						String estadoCivil = cbxEstadoCivil.getSelectedItem().toString();
						String nacionalidad = cbxNacionalidad.getSelectedItem().toString();
						String sexo = "";
						String provincia = cbxProvincias.getSelectedItem().toString();
						String ciudad = textCiudad.getText();
						String sector = textSector.getText();
						String calle = textCalle.getText();
						String direccion = "";
						int numeroCasa = (int) spnNumeroCasa.getValue();
						String referencia = textReferencia.getText();
						String email = textEmail.getText();
						Date fechaN = dateChooser.getDate();
						LocalDate fechaNacimiento = fechaN.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						boolean vehiculoP = false;
						boolean postGrado = false;
						boolean mudarse = false;
						boolean dispViajar = false;
						boolean contratado = false;
						if (rbtnSiDisponibilidad.isSelected()) {
							mudarse = true;
						} else if (rbtnNoDisponibilidad.isSelected()) {
							mudarse = false;
						}
						if (rbtnSiVehiculoPro.isSelected()) {
							vehiculoP = true;
						} else if (rbtnNoVehiculoPro.isSelected()) {
							vehiculoP = false;
						}
						int licencia = 0;
						if (cbxLicencia.getSelectedIndex() == 1) {
							licencia = 0;
						}
						if (cbxLicencia.getSelectedIndex() == 2) {
							licencia = 1;
						}
						if (cbxLicencia.getSelectedIndex() == 3) {
							licencia = 2;
						}
						if (cbxLicencia.getSelectedIndex() == 4) {
							licencia = 3;
						}
						if (cbxLicencia.getSelectedIndex() == 5) {
							licencia = 4;
						}
						if (rdbFemenino.isSelected()) {
							sexo = "Femenino";
						}
						if (rdbMasculino.isSelected()) {
							sexo = "Masculino";
						}
						if (rdbSiPost.isSelected()) {
							postGrado = true;
						}
						if (telefono.equalsIgnoreCase("") || email.equalsIgnoreCase("")) {
							error = true;
							JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos.", "AVISO",
									JOptionPane.WARNING_MESSAGE, null);
							if (panel2.isVisible()) {
								panel1.setVisible(false);
								panel2.setVisible(true);
							}
						}else if ((!rbtnNoDisponibilidad.isSelected() && !rbtnSiDisponibilidad.isSelected())
								|| (!rbtnSiVehiculoPro.isSelected() && !rbtnNoVehiculoPro.isSelected())) {
							error = true;
							JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos.", "AVISO",
									JOptionPane.WARNING_MESSAGE, null);

						} else if (rbtnBachiller.isSelected()) {
							if (misHabilidades.size() == 0) {
								error = true;
								JOptionPane.showMessageDialog(null, "Debe de insertar habilidades de Bachiller.", "AVISO",
										JOptionPane.WARNING_MESSAGE, null);
                                 
							}
							else if (Bolsa_Laboral.getInstance().validarCorreo(email)) {
								panel1.setVisible(false);
								panel2.setVisible(true);
								error = true;
								JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "AVISO",
										JOptionPane.ERROR_MESSAGE, null);
							
							}
						}
				
						else if (rbtnTecnico.isSelected()) {
							if (cbxAreaTecnico.getSelectedIndex() == 0) {
								error = true;
								JOptionPane.showMessageDialog(null, "Debe de insetar area de Ténico.", "AVISO",
										JOptionPane.WARNING_MESSAGE, null);
							}
							else if (Bolsa_Laboral.getInstance().validarCorreo(email)) {
								panel1.setVisible(false);
								panel2.setVisible(true);
								error = true;
								
								JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "AVISO",
										JOptionPane.ERROR_MESSAGE, null);
								
							}	
						} 
						
						else if (rbtnUniversitario.isSelected()) {
							if (cbxCarrera.getSelectedIndex() == 0) {
								error = true;
								JOptionPane.showMessageDialog(null, "Debe de insetar carrera de Universitario.",
										"AVISO", JOptionPane.WARNING_MESSAGE, null);

							} else if (Bolsa_Laboral.getInstance().validarCorreo(email)) {
								panel1.setVisible(false);
								panel2.setVisible(true);
								error = true;
								JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "AVISO",
										JOptionPane.ERROR_MESSAGE, null);
								
							}
								
						}
						if(rbtnBachiller.isSelected()) {
							if(!error) {
								if(!modificar) {
									int years = (int) spnYearExpO.getValue();
									Personal soli = new Bachiller(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado, estadoCivil, misIdiomas, misHabilidades);
									Bolsa_Laboral.getInstance().insertarSolicitante(soli);
									estado = false;
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha registrado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									
									Principal.actualizarChart();  
									clean();
								}
								if(modificar) {
									int years = (int) spnYearExpO.getValue();
									Personal soli = new Bachiller(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado, estadoCivil, misIdiomas, misHabilidades);
									Bolsa_Laboral.getInstance().modificarSolicitante(soli);
									estado = false;
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha modificado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									Principal.actualizarChart();  
									dispose();
								}
								
							}
						}
						
						if(rbtnUniversitario.isSelected()) {
							if(!error) {
								if(!modificar) {
									int years = (int) spnAnosExpUniversitario.getValue();
									Personal soli = new Universitario(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado, estadoCivil, misIdiomas, cbxCarrera.getSelectedItem().toString(), postGrado);
									Bolsa_Laboral.getInstance().insertarSolicitante(soli);		
									estado = false;
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha registrado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									
									Principal.actualizarChart();  
									clean();
					        	}
								if(modificar) {
									int years = (int) spnAnosExpUniversitario.getValue();
									Personal soli = new Universitario(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado, estadoCivil, misIdiomas, cbxCarrera.getSelectedItem().toString(), false);
									estado = false;
									Bolsa_Laboral.getInstance().modificarSolicitante(soli);
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha modificado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									
									Principal.actualizarChart(); 
									dispose();
								}
					        }  
						}
						
						if(rbtnTecnico.isSelected()) {
							if(!error) {
								if(!modificar) {
									int years = (int) spnYearT.getValue();
									Personal soli = new Tecnico(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado, estadoCivil, misIdiomas, cbxAreaTecnico.getSelectedItem().toString());
									Bolsa_Laboral.getInstance().insertarSolicitante(soli);
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha registrado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									Bolsa_Laboral.getInstance().modificarSolicitante(soli);
                                        
									Principal.actualizarChart();
									estado = false;
									clean();
								}
								if(modificar) {
									int years = (int) spnYearT.getValue();
									Personal soli = new Tecnico(cedula, nombre, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaNacimiento, telefono, email, years, vehiculoP, licencia, dispViajar, mudarse, contratado,estadoCivil, misIdiomas, cbxAreaTecnico.getSelectedItem().toString());
									Bolsa_Laboral.getInstance().modificarSolicitante(soli);
									JOptionPane.showMessageDialog(null,
											"El solicitante se ha modificado de manera exitosa.", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);
									estado = false;
									Principal.actualizarChart(); 
									dispose();
								}
							}
						}
					}
					
				});
				
				btnRegistrar.setHorizontalAlignment(SwingConstants.RIGHT);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(InsertarSolicitante.class.getResource("/icons/cancelar.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		estado();
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
	
	public void resetWindow() {
		rbtnBachiller.setSelected(true);
		rbtnTecnico.setSelected(false);
		rbtnUniversitario.setSelected(false);
		pnlBachiller.setVisible(true);
		pnlTecnico.setVisible(false);
		pnlUniversitario.setVisible(false);
		panel1.setVisible(false);
		panel2.setVisible(true);
		btnContinuar.setText(" Retroceder");
		error = false;

	}

	public void clean() {
		btnContinuar.setIcon(new ImageIcon(InsertarSolicitante.class.getResource("/icons/Siguiente.png")));
		textNombre.setText("");
		textApellidos.setText("");
		textCalle.setText("");
		textCiudad.setText("");
		textEmail.setText("");
		ftextCedula.setText("");
		textReferencia.setText("");
		textSector.setText("");
		ftextTelefono.setText("");
		ftextCedula.setText("");
		cbxAreaTecnico.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
		cbxEstadoCivil.setSelectedIndex(0);
		cbxHabilidades.setSelectedIndex(0);
		cbxIdiomas.setSelectedIndex(0);
		cbxLicencia.setSelectedIndex(0);
		cbxNacionalidad.setSelectedIndex(0);
		cbxProvincias.setSelectedIndex(0);
		rbtnBachiller.setSelected(true);
		rdbFemenino.setSelected(false);
		rdbMasculino.setSelected(false);
		rbtnNoDisponibilidad.setSelected(false);
		rbtnSiDisponibilidad.setSelected(false);
		rbtnSiVehiculoPro.setSelected(false);
		rbtnNoVehiculoPro.setSelected(false);
		panel1.setVisible(true);
		panel2.setVisible(false);
		spnYearExpO.setValue(0);
		spnYearT.setValue(0);
		spnAnosExpUniversitario.setValue(0);
		spnNumeroCasa.setValue(0);
		btnContinuar.setText("Continuar ");
		LocalDate fecha = LocalDate.now();
		Date date = java.sql.Date.valueOf(fecha);
		btnRegistrar.setEnabled(false);
		misHabilidades = new ArrayList<>();
		misIdiomas = new ArrayList<>();
		modeloHabilidad.clear();
		error = false;
		modeloIdiomas.clear();
	}
	
	public void estado() {
		Thread ventana = new Thread() {
			public void run() {
				try {
					for (;;) {

						if (estado) {
							panel1.setVisible(false);
							panel2.setVisible(true);
							btnContinuar.setText(" Retroceder");
						}

						sleep(10);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ventana.start();

	}
	
	public void call() {
		dispose();
		InsertarSolicitante soli = new InsertarSolicitante("Insertar Solicitante", false, null, null);
		soli.setModal(true);
		soli.setLocationRelativeTo(null);
		soli.setVisible(true);
	}

	
	public void loadSolicitanteModi() {
		if (modiS != null) {
			btnRegistrar.setText("Modificar");
			LocalDate fecha = modiS.getFechaN();
			Date date = java.sql.Date.valueOf(fecha);
			textApellidos.setEnabled(false);
			textNombre.setEnabled(false);
			rdbFemenino.setEnabled(false);
			rdbMasculino.setEnabled(false);
			ftextCedula.setEnabled(false);
			dateChooser.setEnabled(false);
			cbxNacionalidad.setEnabled(false);
			rbtnSiDisponibilidad.setEnabled(false);
			rbtnNoDisponibilidad.setEnabled(false);
			
			// Incersion de datos
						for (String idio : modiS.getIdiomas()) {
							misIdiomas.add(idio);
						}
						loadIdioma();
						textCiudad.setText(modiS.getCiudad());
						textCalle.setText(modiS.getCalle());
						textSector.setText(modiS.getSector());
						textReferencia.setText(modiS.getReferencia());
						spnNumeroCasa.setValue(modiS.getNumeroCasa());
						textNombre.setText(modiS.getName());
						textApellidos.setText(modiS.getApellido());
						ftextCedula.setText(modiS.getCedula());
						dateChooser.setDate(date);
						cbxNacionalidad.setSelectedItem(modiS.getNacionalidad());
						cbxEstadoCivil.setSelectedItem(modiS.getEstadoCivil());
						cbxProvincias.setSelectedItem(modiS.getProvincia());
						ftextTelefono.setText(modiS.getTelefono());
						textEmail.setText(modiS.getCorreo());
						if (modiS.getSexo().equalsIgnoreCase("Femenino")) {
							rdbFemenino.setSelected(true);
						} else {
							rdbMasculino.setSelected(true);
						}
						if (modiS.isVehiculo()) {
							rbtnSiVehiculoPro.setSelected(true);
						} else {
							rbtnNoVehiculoPro.setSelected(true);
						}
						if (modiS.getCategoriaLicencia() == 0) {
							cbxLicencia.setSelectedIndex(1);
						}
						if (modiS.getCategoriaLicencia() == 1) {
							cbxLicencia.setSelectedIndex(2);
						}
						if (modiS.getCategoriaLicencia() == 2) {
							cbxLicencia.setSelectedIndex(3);
						}
						if (modiS.getCategoriaLicencia() == 3) {
							cbxLicencia.setSelectedIndex(4);
						}
						if (modiS.getCategoriaLicencia() == 4) {
							cbxLicencia.setSelectedIndex(5);
						}
						if (modiS.isMudarse() == true) {
							rbtnSiDisponibilidad.setSelected(true);
						} else {
							rbtnNoDisponibilidad.setSelected(true);
						}
						if (modiS instanceof Bachiller) {
							for (String habi : ((Bachiller) modiS).getHabilidades()) {
								misHabilidades.add(habi);
							}
							loadHabilidades();
							listHabilidades.setEnabled(false);
							spnYearExpO.setValue(modiS.getYearExperiencia());
							cbxHabilidades.setEnabled(false);
							spnYearExpO.setEnabled(false);
							rbtnBachiller.setSelected(true);
							rbtnTecnico.setSelected(false);
							rbtnUniversitario.setSelected(false);
							rbtnUniversitario.setEnabled(false);
							rbtnTecnico.setEnabled(false);
							rbtnBachiller.setEnabled(false);
							pnlBachiller.setVisible(true);
							pnlTecnico.setVisible(false);
							pnlUniversitario.setVisible(false);
						}
						if (modiS instanceof Universitario) {
							cbxCarrera.setEnabled(false);
							cbxCarrera.setSelectedItem(((Universitario) modiS).getCarrera());
							spnAnosExpUniversitario.setValue(modiS.getYearExperiencia());
							spnAnosExpUniversitario.setEnabled(false);
							rbtnBachiller.setSelected(false);
							rbtnTecnico.setSelected(false);
							rbtnUniversitario.setSelected(true);
							pnlBachiller.setVisible(false);
							pnlTecnico.setVisible(false);
							pnlUniversitario.setVisible(true);
							rbtnUniversitario.setEnabled(false);
							rbtnTecnico.setEnabled(false);
							rbtnBachiller.setEnabled(false);
							rdbNoPost.setEnabled(false);
							rdbSiPost.setEnabled(false);
							if (((Universitario) modiS).isPostGrado()) {
								rdbSiPost.setSelected(true);
							} else {
								rdbNoPost.setSelected(true);
							}
						}
						if (modiS instanceof Tecnico) {
							spnYearT.setValue(modiS.getYearExperiencia());
							spnYearT.setEnabled(false);
							cbxAreaTecnico.setSelectedItem(((Tecnico) modiS).getArea());
							cbxAreaTecnico.setEnabled(false);
							rbtnBachiller.setSelected(false);
							rbtnTecnico.setSelected(true);
							rbtnUniversitario.setSelected(false);
							pnlBachiller.setVisible(false);
							pnlTecnico.setVisible(true);
							pnlUniversitario.setVisible(false);
							rbtnUniversitario.setEnabled(false);
							rbtnTecnico.setEnabled(false);
							rbtnBachiller.setEnabled(false);
						}
	            	}   
	            }
	
	public void laodVer() {
		panel1.setEnabled(false);
		panel2.setEnabled(false);
		LocalDate fecha = verSoli.getFechaN();
		Date date = java.sql.Date.valueOf(fecha);
		textApellidos.setEnabled(false);
		textNombre.setEnabled(false);
		rdbFemenino.setEnabled(false);
		rdbMasculino.setEnabled(false);
		ftextCedula.setEnabled(false);
		dateChooser.setEnabled(false);
		cbxNacionalidad.setEnabled(false);
		rbtnSiDisponibilidad.setEnabled(false);
		rbtnNoDisponibilidad.setEnabled(false);
		
		// Incersion de datos
				for (String idio : verSoli.getIdiomas()) {
					misIdiomas.add(idio);
				}
				loadIdioma();
				textCiudad.setText(verSoli.getCiudad());
				textCalle.setText(verSoli.getCalle());
				textSector.setText(verSoli.getSector());
				textReferencia.setText(verSoli.getReferencia());
				spnNumeroCasa.setValue(verSoli.getNumeroCasa());
				textNombre.setText(verSoli.getName());
				textApellidos.setText(verSoli.getApellido());
				ftextCedula.setText(verSoli.getCedula());
				dateChooser.setDate(date);
				cbxNacionalidad.setSelectedItem(verSoli.getNacionalidad());
				cbxEstadoCivil.setSelectedItem(verSoli.getEstadoCivil());
				cbxProvincias.setSelectedItem(verSoli.getProvincia());
				ftextTelefono.setText(verSoli.getTelefono());
				textEmail.setText(verSoli.getCorreo());
				
				if (verSoli.getSexo().equalsIgnoreCase("Femenino")) {
					rdbFemenino.setSelected(true);
				} else {
					rdbMasculino.setSelected(true);
				}
				if (verSoli.isVehiculo()) {
					rbtnSiVehiculoPro.setSelected(true);
				} else {
					rbtnNoVehiculoPro.setSelected(true);
				}
				if (verSoli.getCategoriaLicencia() == 0) {
					cbxLicencia.setSelectedIndex(1);
				}
				if (verSoli.getCategoriaLicencia() == 1) {
					cbxLicencia.setSelectedIndex(2);
				}
				if (verSoli.getCategoriaLicencia() == 2) {
					cbxLicencia.setSelectedIndex(3);
				}
				if (verSoli.getCategoriaLicencia() == 3) {
					cbxLicencia.setSelectedIndex(4);
				}
				if (verSoli.getCategoriaLicencia() == 4) {
					cbxLicencia.setSelectedIndex(5);
				}
				if (verSoli.isMudarse() == true) {
					rbtnSiDisponibilidad.setSelected(true);
				} else {
					rbtnNoDisponibilidad.setSelected(true);
				}
				
				if (modiS instanceof Bachiller) {
					for (String habi : ((Bachiller) verSoli).getHabilidades()) {
						misHabilidades.add(habi);
					}
					loadHabilidades();
					listHabilidades.setEnabled(false);
					spnYearExpO.setValue(verSoli.getYearExperiencia());
					cbxHabilidades.setEnabled(false);
					spnYearExpO.setEnabled(false);
					rbtnBachiller.setSelected(true);
					rbtnTecnico.setSelected(false);
					rbtnUniversitario.setSelected(false);
					rbtnUniversitario.setEnabled(false);
					rbtnTecnico.setEnabled(false);
					rbtnBachiller.setEnabled(false);
					pnlBachiller.setVisible(true);
					pnlTecnico.setVisible(false);
					pnlUniversitario.setVisible(false);
				}
				
				if (modiS instanceof Universitario) {
					cbxCarrera.setEnabled(false);
					cbxCarrera.setSelectedItem(((Universitario) verSoli).getCarrera());
					spnAnosExpUniversitario.setValue(verSoli.getYearExperiencia());
					spnAnosExpUniversitario.setEnabled(false);
					rbtnBachiller.setSelected(false);
					rbtnTecnico.setSelected(false);
					rbtnUniversitario.setSelected(true);
					pnlBachiller.setVisible(false);
					pnlTecnico.setVisible(false);
					pnlUniversitario.setVisible(true);
					rbtnUniversitario.setEnabled(false);
					rbtnTecnico.setEnabled(false);
					rbtnBachiller.setEnabled(false);
					rdbNoPost.setEnabled(false);
					rdbSiPost.setEnabled(false);
					if (((Universitario) verSoli).isPostGrado()) {
						rdbSiPost.setSelected(true);
					} else {
						rdbNoPost.setSelected(true);
					}
				}
				
				if (modiS instanceof Tecnico) {
					spnYearT.setValue(verSoli.getYearExperiencia());
					spnYearT.setEnabled(false);
					cbxAreaTecnico.setSelectedItem(((Tecnico) verSoli).getArea());
					cbxAreaTecnico.setEnabled(false);
					rbtnBachiller.setSelected(false);
					rbtnTecnico.setSelected(true);
					rbtnUniversitario.setSelected(false);
					pnlBachiller.setVisible(false);
					pnlTecnico.setVisible(true);
					pnlUniversitario.setVisible(false);
					rbtnUniversitario.setEnabled(false);
					rbtnTecnico.setEnabled(false);
					rbtnBachiller.setEnabled(false);
				}

	}
	
	
	
	
		
	}


