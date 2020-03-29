package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logic.Bolsa_Laboral;
import logic.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//jeje
public class InsertarEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSector;
	private JTextField txtCiudad;
	private JTextField txtCalle;
	private JTextField txtArea;
	private JTextField txtReferencia;
	private JFormattedTextField ftxtTelf;
	private JFormattedTextField ftxtRNC;
	private JComboBox cbxProvincia;
	private JSpinner spnNolocal;
	private Empresa miEmpresa = null; 
	private String probando;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { InsertarEmpresa dialog = new
	 * InsertarEmpresa(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public InsertarEmpresa(String title, boolean modi, Empresa empresa, String RNCsoli)  {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (RNCsoli != null) {
					ftxtRNC.setText(RNCsoli);
					ftxtRNC.setEnabled(false);
				}
			}
		});
		miEmpresa = empresa; 
		setResizable(false);
		setBounds(100, 100, 614, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setTitle(title);
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBounds(5, 23, 593, 140);
		contentPanel.add(pnlInformacion);
		pnlInformacion.setLayout(null);
		
		JLabel lblRNC = new JLabel("RNC:");
		lblRNC.setBounds(10, 24, 46, 14);
		pnlInformacion.add(lblRNC);
		
		JLabel lblrea = new JLabel("\u00C1rea:");
		lblrea.setBounds(10, 100, 62, 14);
		pnlInformacion.add(lblrea);
		
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("##########");
			ftxtRNC = new JFormattedTextField(mascara);
			ftxtRNC.setBackground(Color.WHITE);
			ftxtRNC.setBounds(93, 17, 174, 23);
			pnlInformacion.add(ftxtRNC);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(312, 34, 62, 14);
		pnlInformacion.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(312, 84, 46, 14);
		pnlInformacion.add(lblEmail);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}
			}
		});
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(405, 34, 174, 23);
		pnlInformacion.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(405, 80, 174, 23);
		pnlInformacion.add(txtEmail);
		
		MaskFormatter mascara1;
		try {
			mascara1 = new MaskFormatter("###-###-####");
			ftxtTelf = new JFormattedTextField(mascara1);
			ftxtTelf.setColumns(10);
			ftxtTelf.setBackground(Color.WHITE);
			ftxtTelf.setBounds(93, 57, 174, 23);
			pnlInformacion.add(ftxtTelf);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblTelf = new JLabel("Tel\u00E9fono:");
		lblTelf.setBounds(10, 62, 62, 14);
		pnlInformacion.add(lblTelf);
		
		txtArea = new JTextField();
		txtArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}
			}
		});
		txtArea.setBounds(93, 97, 174, 23);
		pnlInformacion.add(txtArea);
		txtArea.setColumns(10);
		
		JPanel pnlUbicacion = new JPanel();
		pnlUbicacion.setBorder(new TitledBorder(null, "Ubicaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUbicacion.setBounds(5, 174, 593, 166);
		contentPanel.add(pnlUbicacion);
		pnlUbicacion.setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia:   ");
		lblProvincia.setBounds(10, 27, 73, 14);
		pnlUbicacion.add(lblProvincia);
		
		cbxProvincia = new JComboBox();
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {
				"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ",
				"Dajabón ", "Distrito Nacional ", "Duarte ",
				"Elías Piña ", "El Seibo ", "Espaillat ",
				"Hato Mayor ", "Independencia ", "La Altagracia ",
				"La Romana ", "La Vega ", "María Trinidad Sánchez ",
				"Monseñor Nouel ", "Montecristi ", "Monte Plata ",
				"Pedernales ", "Peravia ", "Puerto Plata ",
				"Hermanas Mirabal ", "Samaná ",
				"Sánchez Ramírez ", "San Cristóbal ",
				"San José de Ocoa ", "San Juan ",
				"San Pedro de Macorís ", "Santiago ",
				"Santiago Rodríguez ", "Santo Domingo ", "Valverde "}));
		cbxProvincia.setBackground(Color.WHITE);
		cbxProvincia.setBounds(93, 27, 174, 23);
		pnlUbicacion.add(cbxProvincia);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setBounds(10, 76, 54, 14);
		pnlUbicacion.add(lblSector);
		
		txtSector = new JTextField();
		txtSector.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}
			}
		});
		txtSector.setColumns(10);
		txtSector.setBackground(Color.WHITE);
		txtSector.setBounds(93, 73, 174, 23);
		pnlUbicacion.add(txtSector);
		
		JLabel lblNolocal = new JLabel("No. Localidad");
		lblNolocal.setBounds(10, 126, 88, 14);
		pnlUbicacion.add(lblNolocal);
		
		spnNolocal = new JSpinner();
		spnNolocal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar= e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null,"Este campo no adminte letras");

				}
			}
		});
		spnNolocal.setBounds(93, 123, 174, 21);
		pnlUbicacion.add(spnNolocal);
		
		txtCiudad = new JTextField();
		txtCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}
			}
		});
		txtCiudad.setColumns(10);
		txtCiudad.setBackground(Color.WHITE);
		txtCiudad.setBounds(405, 24, 174, 23);
		pnlUbicacion.add(txtCiudad);
		
		JLabel lblCiudad = new JLabel("Cuidad:");
		lblCiudad.setBounds(312, 24, 62, 14);
		pnlUbicacion.add(lblCiudad);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(312, 73, 46, 14);
		pnlUbicacion.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(Color.WHITE);
		txtCalle.setBounds(405, 70, 174, 23);
		pnlUbicacion.add(txtCalle);
		
		txtReferencia = new JTextField();
		txtReferencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}
			}
		});
		txtReferencia.setColumns(10);
		txtReferencia.setBackground(Color.WHITE);
		txtReferencia.setBounds(405, 117, 174, 23);
		pnlUbicacion.add(txtReferencia);
		
		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setBounds(312, 120, 73, 14);
		pnlUbicacion.add(lblReferencia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(modi){
					btnRegistrar.setText("Salvar Modificaciones");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!(modi)) {
							String rnc = ftxtRNC.getText();
							String name = txtName.getText();
							String tele = ftxtTelf.getText();
							String email = txtEmail.getText();
							String provincia = cbxProvincia.getSelectedItem().toString();

							String ciudad = txtCiudad.getText();
							String sector = txtSector.getText();
							String calle = txtCalle.getText();
							String area = txtArea.getText(); 
							String referencia = txtReferencia.getText();
							int local = (int) spnNolocal.getValue();
							Empresa miEmpre = new Empresa(rnc, name, tele, provincia, ciudad, sector, calle, local, area, email, referencia);
							

							if (txtName.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar  el nombre de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (ftxtRNC.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el RNC de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (ftxtTelf.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el telefono la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtEmail.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el email la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (cbxProvincia.getSelectedIndex() == 0) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe seleccionar la Provincia de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCalle.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar la calle  de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCiudad.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe la ciudad de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtSector.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el sector de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtReferencia.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar una referencia  de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (spnNolocal.getValue().toString().equalsIgnoreCase("0")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el No. de localidad de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtArea.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar un área de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (empresaRep(rnc)) {
								JOptionPane.showMessageDialog(null,
										"Empresa existente", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);
							} else {
								if ((Bolsa_Laboral.getInstance()
										.validarCorreo(email))) {
									JOptionPane.showMessageDialog(null,
											"Favor registar un E-mail valido",
											"ATENCIÓN",
											JOptionPane.WARNING_MESSAGE, null);
									txtEmail.setText(null);

								} else {
									Bolsa_Laboral.getInstance().insertEmpresa(miEmpre);
									if (RNCsoli == null) {
										ftxtRNC.setText(null);
									}

									txtName.setText(null);
									ftxtTelf.setText(null);
									txtEmail.setText(null);
									cbxProvincia.setSelectedIndex(0);
									txtSector.setText(null);
									spnNolocal.setValue(0);
									txtCiudad.setText(null);
									txtArea.setText(null);
									txtReferencia.setText(null);
									txtCalle.setText(null);
									JOptionPane
											.showMessageDialog(null,
													"Empresa Agregada Satisfactoriamente");
									if (RNCsoli != null) {
										dispose();
									}

								}

							}

						} else {String rnc = ftxtRNC.getText();
						String name = txtName.getText();
						String tele = ftxtTelf.getText();
						String email = txtEmail.getText();
						String provincia = cbxProvincia.getSelectedItem()
								.toString();

						String ciudad = txtCiudad.getText();
						String area = txtArea.getText(); 
						String sector = txtSector.getText();
						String calle = txtCalle.getText();
						String referencia = txtReferencia.getText();
						int local = (int) spnNolocal.getValue();
						Empresa modiEmpre = new Empresa(rnc, name, tele, provincia, ciudad, sector, calle, local, area, email, referencia);
							Bolsa_Laboral.getInstance().modificaEmpresa(modiEmpre);
							JOptionPane.showMessageDialog(null, "Empresa Modificada");
							dispose();
							
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		if(modi){
			loadEmpresaModi();}
	}
	
	private void loadEmpresaModi() {
		if (miEmpresa != null) {
			ftxtRNC.setEnabled(false);
			ftxtRNC.setText(miEmpresa.getRNC());
			txtEmail.setText(miEmpresa.getEmail());
			txtName.setText(miEmpresa.getNombre());
			txtArea.setText(miEmpresa.getArea());
			ftxtTelf.setText(miEmpresa.getTelefono());
			txtSector.setText(miEmpresa.getDireccion());
			spnNolocal.setValue(miEmpresa.getNumeroLocal());
			txtCiudad.setText(miEmpresa.getCiudad());
			txtReferencia.setText(miEmpresa.getReferencia());
			txtCalle.setText(miEmpresa.getCalle());
			cbxProvincia.setSelectedItem(miEmpresa.getProvincia());
		}

	}

	public boolean empresaRep(String rnc) {
		boolean aux = false;
		for (Empresa empresa : Bolsa_Laboral.getInstance().getMisEmpresas()) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				aux = true;
			}

		}
		return aux;
	}
}
