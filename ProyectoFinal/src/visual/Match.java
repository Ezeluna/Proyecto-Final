package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import logic.Bolsa_Laboral;
import logic.Empresa;
import logic.Personal;
import logic.Solicitud;
import logic.SolicitudBachiller;
import logic.SolicitudTecnico;
import logic.SolicitudUniversitario;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class Match extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Object[] fila;
	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private JFormattedTextField ftxtRNC;
	Empresa miEmpresa = null;
	private JTextField txtNombre;
	private JButton btnShow;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList list;
	private String codigo = "";
	private ArrayList<Personal> miPersonalC = new ArrayList<>();
	private JFormattedTextField ftxtCodSolicitud;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Match() throws ParseException{
		setResizable(false);
		setModal(true);
		setTitle("DAEX\u00A9 - Bolsa Laboral");
		setBounds(100, 100, 870, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 11, 838, 415);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel pnlEmpresa = new JPanel();
		pnlEmpresa.setBorder(new TitledBorder(null, "Empresa:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		pnlEmpresa.setBounds(5, 5, 505, 400);
		panel.add(pnlEmpresa);
		pnlEmpresa.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane_1.setBounds(10, 114, 485, 233);
		pnlEmpresa.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow(); 
				if(aux > -1) {
					btnShow.setEnabled(true);
					codigo = (String) table.getModel().getValueAt(aux, 0);
					ftxtCodSolicitud.setValue(codigo);
				} else {
					codigo = "";
					btnShow.setEnabled(false);
				}
			}
		});
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		loadTable(null);
		scrollPane_1.setViewportView(table);
		
		btnShow = new JButton(" Ver Solicitantes");
		btnShow.setIcon(new ImageIcon(Match.class.getResource("/icons/ver.png")));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solicitud soli = Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo);
				if(soli != null) {
					miPersonalC = Bolsa_Laboral.getInstance().matcheo(soli);
				}
				
				cargarSolicitante();
			}
		});
		btnShow.setEnabled(false);
		btnShow.setBounds(330, 358, 165, 25);
		pnlEmpresa.add(btnShow);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(73, 57, 406, 23);
		pnlEmpresa.add(txtNombre);
		
		MaskFormatter mascara = new MaskFormatter("##########");
		ftxtRNC = new JFormattedTextField(mascara);
		ftxtRNC.setBackground(Color.WHITE);
		ftxtRNC.setBounds(73, 26, 139, 23);
		pnlEmpresa.add(ftxtRNC);
		
		JLabel label = new JLabel("RNC:");
		label.setBounds(20, 30, 46, 14);
		pnlEmpresa.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 61, 59, 14);
		pnlEmpresa.add(lblNombre);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCodSolicitud.setValue("");
				
				if(Bolsa_Laboral.getInstance().RetornarEmpresa(ftxtRNC.getText()) != null) {
					miEmpresa = Bolsa_Laboral.getInstance().RetornarEmpresa(ftxtRNC.getText()); 
					txtNombre.setText(miEmpresa.getNombre());
					loadTable(miEmpresa);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro una empresa con el RNC digitado.", "Información",
											JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(Match.class.getResource("/icons/Logo Buscar.png")));
		btnBuscar.setBounds(215, 25, 29, 25);
		pnlEmpresa.add(btnBuscar);
		
		JLabel label_1 = new JLabel("C\u00F3digo Solicitud:");
		label_1.setBounds(254, 30, 102, 14);
		pnlEmpresa.add(label_1);
		
		ftxtCodSolicitud = new JFormattedTextField();
		ftxtCodSolicitud.setEnabled(false);
		ftxtCodSolicitud.setBackground(Color.WHITE);
		ftxtCodSolicitud.setBounds(351, 26, 128, 23);
		pnlEmpresa.add(ftxtCodSolicitud);
		
		JLabel lblSoli = new JLabel("Solicitudes Empresariales:");
		lblSoli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoli.setBounds(168, 89, 176, 14);
		pnlEmpresa.add(lblSoli);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(null);
				ftxtCodSolicitud.setText("");
				txtNombre.setText("");
				ftxtRNC.setText("");
			}
		});
		btnLimpiar.setBounds(231, 358, 89, 25);
		pnlEmpresa.add(btnLimpiar);
		{
			JPanel pnlSolicitantes = new JPanel();
			pnlSolicitantes.setBorder(new TitledBorder(null, "Solicitantes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlSolicitantes.setBackground(SystemColor.inactiveCaptionBorder);
			pnlSolicitantes.setBounds(520, 5, 308, 400);
			panel.add(pnlSolicitantes);
			pnlSolicitantes.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 32, 291, 357);
				pnlSolicitantes.add(scrollPane);
				
			    list = new JList();
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnContratar = new JButton("Contratar");
				btnContratar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (miPersonalC.size() != 0) {
							Solicitud soli = Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo);
							Bolsa_Laboral.getInstance().contratarEmpleados(soli, miPersonalC);
							JOptionPane.showMessageDialog(null, "Los solicitantes han sido contratados.", "Información",
									JOptionPane.INFORMATION_MESSAGE, null);
							Bolsa_Laboral.getInstance().removerContratados(miPersonalC);
							clean();
						} else {
							JOptionPane.showMessageDialog(null,
									"No existen solicitantes en la actualidad para satisfacer esta solicitud",
									"Información", JOptionPane.INFORMATION_MESSAGE, null);
							
						}
					}
				});
				btnContratar.setActionCommand("OK");
				buttonPane.add(btnContratar);
				getRootPane().setDefaultButton(btnContratar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setIcon(new ImageIcon(Match.class.getResource("/icons/cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void loadTable(Empresa empresa) {
		String[] columnNames = { "Código", "Tipo", "Vacantes", "Rango Edad", "Localidad" };
		modelo.setColumnIdentifiers(columnNames);
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];

		if (empresa == null) {
			for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {
				if (soli.getCantVacantes() > 0) {
					fila[0] = soli.getId();
					if (soli instanceof SolicitudUniversitario) {
						fila[1] = "Universitario";
					}
					if (soli instanceof SolicitudTecnico) {
						fila[1] = "Técnico";
					}
					if (soli instanceof SolicitudBachiller) {
						fila[1] = "Bachiller";
					}
					fila[2] = soli.getCantVacantes();
					String min = Integer.toString(soli.getEdadMin());
					String max = Integer.toString(soli.getEdadMax());
					String rango = min + "-" + max;
					fila[3] = rango;
					fila[4] = soli.getLocalidad();

					modelo.addRow(fila);

				}
			}

		} else {
			ArrayList<Solicitud> solicitudesEmpresa = new ArrayList<>();
			for (Solicitud solicitud : Bolsa_Laboral.getInstance().RetornaSolicitudEmp(empresa)) {
				solicitudesEmpresa.add(solicitud);

			}

			for (Solicitud soli : solicitudesEmpresa) {
				if (soli.getCantVacantes() > 0) {
					fila[0] = soli.getId();
					if (soli instanceof SolicitudUniversitario) {
						fila[1] = "Universitario";
					}
					if (soli instanceof SolicitudTecnico) {
						fila[1] = "Técnico";
					}
					if (soli instanceof SolicitudBachiller) {
						fila[1] = "Bachiller";
					}
					fila[2] = soli.getCantVacantes();
					String min = Integer.toString(soli.getEdadMin());
					String max = Integer.toString(soli.getEdadMax());
					String rango = min + "-" + max + " Años";
					fila[3] = rango;
					fila[4] = soli.getLocalidad();

					modelo.addRow(fila);

				}
			}
		}

		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < columnNames.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}
		columnModel.getColumn(0).setPreferredWidth(80);
		columnModel.getColumn(1).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(106);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(80);

	}

	public void cargarSolicitante() {
		if (miPersonalC.size() != 0) {
			for (Personal soli : miPersonalC) {
				String candidato = soli.getCedula() + " " + soli.getName() + " " + soli.getApellido();
				model.addElement(candidato);
			}
			list.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null,
					"No existen solicitantes en la actualidad para satisfacer esta solicitud", "Información",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public void clean() {
		model.clear();
		miPersonalC = new ArrayList<>();
		loadTable(null);
	}
}
