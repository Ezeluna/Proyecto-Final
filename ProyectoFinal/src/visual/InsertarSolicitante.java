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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.CardLayout;

public class InsertarSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel1;
	private JPanel panel2;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCiudad;
	private JTextField textSector;
	private JTextField textCalle;
	private JTextField textReferencia;
	private JFormattedTextField ftextCedula;
	private JComboBox cbxLicencia;
	private JComboBox cbxProvincias;
	private JComboBox cbxEstadoCivil;
	private JComboBox cbxNacionalidad;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFemenino;
	private JSpinner spnNumeroCasa;
	

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
		setBounds(100, 100, 612, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			JPanel panel1 = new JPanel();
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
				rdbMasculino.setBounds(382, 29, 44, 23);
				panelInformacionGe.add(rdbMasculino);
				
				rdbFemenino = new JRadioButton("F");
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
			textCiudad.setBounds(97, 73, 131, 20);
			panelUbicacionA.add(textCiudad);
			textCiudad.setColumns(10);
			
			JLabel lblSector = new JLabel("Sector: ");
			lblSector.setBounds(10, 122, 59, 14);
			panelUbicacionA.add(lblSector);
			
			textSector = new JTextField();
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
			JPanel panel2 = new JPanel();
			contentPanel.add(panel2, "name_428725249088700");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnContinuar = new JButton("Continuar");
			buttonPane.add(btnContinuar);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setHorizontalAlignment(SwingConstants.RIGHT);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
