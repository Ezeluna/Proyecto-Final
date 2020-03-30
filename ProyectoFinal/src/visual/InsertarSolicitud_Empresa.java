package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class InsertarSolicitud_Empresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	//probando jeje

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
		setBounds(100, 100, 547, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
				JFormattedTextField ftxtRNC = new JFormattedTextField();
				ftxtRNC.setBackground(Color.WHITE);
				ftxtRNC.setBounds(81, 27, 120, 23);
				panelEmpresa.add(ftxtRNC);
			}
			{
				JButton btnNewButton = new JButton("");
				btnNewButton.setBounds(204, 26, 29, 25);
				panelEmpresa.add(btnNewButton);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(263, 31, 56, 14);
				panelEmpresa.add(lblNombre);
			}
			{
				textField = new JTextField();
				textField.setEnabled(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(338, 27, 160, 23);
				panelEmpresa.add(textField);
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
				JComboBox cbxContrato = new JComboBox();
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
				JRadioButton rbtnReubicacionSi = new JRadioButton("Si");
				rbtnReubicacionSi.setBackground(new Color(248, 248, 255));
				rbtnReubicacionSi.setBounds(124, 64, 45, 23);
				PanelGeneral.add(rbtnReubicacionSi);
			}
			{
				JRadioButton rbtnReubicacionNo = new JRadioButton("No");
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
				JRadioButton rbtnVehiculoSi = new JRadioButton("Si");
				rbtnVehiculoSi.setBackground(new Color(248, 248, 255));
				rbtnVehiculoSi.setBounds(124, 105, 45, 23);
				PanelGeneral.add(rbtnVehiculoSi);
			}
			{
				JRadioButton rbtnVehiculoNo = new JRadioButton("No");
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
				JSpinner spnVacantes = new JSpinner();
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
				JComboBox cbxLocalidad = new JComboBox();
				cbxLocalidad.setBackground(Color.WHITE);
				cbxLocalidad.setBounds(338, 64, 160, 23);
				PanelGeneral.add(cbxLocalidad);
			}
			{
				JComboBox cbxLicencia = new JComboBox();
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
				JSpinner spnEdadMinima = new JSpinner();
				spnEdadMinima.setBackground(Color.WHITE);
				spnEdadMinima.setBounds(62, 24, 51, 23);
				panelEdad.add(spnEdadMinima);
			}
			{
				JSpinner spnEdadMaxima = new JSpinner();
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
				JRadioButton rbtnTecnico = new JRadioButton("T\u00E9cnico ");
				rbtnTecnico.setBackground(new Color(248, 248, 255));
				rbtnTecnico.setBounds(107, 22, 75, 23);
				PanelVacante.add(rbtnTecnico);
			}
			{
				JRadioButton rbtnUniversitario = new JRadioButton("Universitario");
				rbtnUniversitario.setBackground(new Color(248, 248, 255));
				rbtnUniversitario.setBounds(6, 22, 99, 23);
				PanelVacante.add(rbtnUniversitario);
			}
			{
				JRadioButton rbtnObrero = new JRadioButton("Obrero");
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
				JComboBox cbxIdioma = new JComboBox();
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
				JSpinner spnUniversitarioExperiencia = new JSpinner();
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
				JRadioButton rbtnPostGradoSi = new JRadioButton("Si");
				rbtnPostGradoSi.setBackground(new Color(248, 248, 255));
				rbtnPostGradoSi.setBounds(114, 96, 40, 23);
				panelUniversitario.add(rbtnPostGradoSi);
			}
			{
				JRadioButton rbtnPostGradoNo = new JRadioButton("No");
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
				JComboBox cbxCarrera = new JComboBox();
				cbxCarrera.setBackground(Color.WHITE);
				cbxCarrera.setBounds(93, 61, 160, 23);
				panelUniversitario.add(cbxCarrera);
			}
		}
		{
			JPanel buttonPane = new JPanel();
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
