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
import java.awt.Toolkit;

public class Match extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private JFormattedTextField ftxtRNC;
	Empresa miEmpresa = null;
	private JButton btnCandidatos;
	private DefaultListModel model = new DefaultListModel();
	private DefaultListModel modelCont = new DefaultListModel();
	private JList<String> lstSoli;
	private JList<String> lstSoli2;
	private String codigo = "";
	private ArrayList<String> EmpleadosC = new ArrayList<>(); 
	private ArrayList<String> EmpleadosCVuelta = new ArrayList<>();
	private ArrayList<Personal> misSolicitantesC = new ArrayList<>();
	private JFormattedTextField ftxtCodSolicitud;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Match() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Match.class.getResource("/icons/icons8-pie-chart-64.png")));
		setTitle("DAEX\u00A9 - Bolsa Laboral");
		setResizable(false);
		setBounds(100, 100, 588, 670);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pnlSolicitantes = new JPanel();
			pnlSolicitantes.setBackground(SystemColor.inactiveCaptionBorder);
			pnlSolicitantes.setBorder(new TitledBorder(null, "Solicitantes Candidatos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlSolicitantes.setBounds(10, 340, 562, 246);
			contentPanel.add(pnlSolicitantes);
			pnlSolicitantes.setLayout(null);
			
			JButton btnDer = new JButton("");
			btnDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (lstSoli.getSelectedValue() != null) {
						modelCont.addElement(lstSoli.getSelectedValue());
						lstSoli2.setModel(modelCont);
						model.removeElement(lstSoli.getSelectedValue());
						lstSoli.setModel(model);	
					}	
				}
			});
			btnDer.setIcon(new ImageIcon(Match.class.getResource("/icons/Siguiente.png")));
			btnDer.setBounds(257, 93, 45, 23);
			pnlSolicitantes.add(btnDer);
			
			JButton btnIzq = new JButton("");
			btnIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (lstSoli2.getSelectedValue() != null) {
						model.addElement(lstSoli2.getSelectedValue());
						lstSoli.setModel(model);
						modelCont.removeElement(lstSoli2.getSelectedValue()); 
						lstSoli2.setModel(modelCont);
					}
				}
			});
			btnIzq.setIcon(new ImageIcon(Match.class.getResource("/icons/retroceso.png")));
			btnIzq.setBounds(257, 137, 45, 23);
			pnlSolicitantes.add(btnIzq);
			
			JLabel lblNewLabel_1 = new JLabel("Solicitantes:");
			lblNewLabel_1.setBounds(10, 21, 81, 14);
			pnlSolicitantes.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Solicitantes a Contratar:");
			lblNewLabel_2.setBounds(313, 21, 145, 14);
			pnlSolicitantes.add(lblNewLabel_2);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 40, 237, 190);
			pnlSolicitantes.add(scrollPane_1);
			
			lstSoli = new JList();
			lstSoli.setBorder(new TitledBorder(null, "         C\u00E9dula       --             Nombre            ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_1.setViewportView(lstSoli);

			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(312, 40, 237, 190);
			pnlSolicitantes.add(scrollPane_2);
			
			lstSoli2 = new JList();
			scrollPane_2.setViewportView(lstSoli2);
			lstSoli2.setBorder(new TitledBorder(null, "         C\u00E9dula       --             Nombre            ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n Empresarial:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 562, 328);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel pnlSolicitudes = new JPanel();
				pnlSolicitudes.setBackground(SystemColor.inactiveCaptionBorder);
				pnlSolicitudes.setBorder(new TitledBorder(null, "Solicitudes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlSolicitudes.setLayout(null);
				pnlSolicitudes.setBounds(10, 89, 542, 202);
				panel.add(pnlSolicitudes);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 522, 170);
				pnlSolicitudes.add(scrollPane);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int aux = table.getSelectedRow();
						if (aux > -1) {
							btnCandidatos.setEnabled(true);
							codigo = (String) table.getModel().getValueAt(aux, 0);
							ftxtCodSolicitud.setValue(codigo);
						} else {
							codigo = "";
							btnCandidatos.setEnabled(false);
						}
					}
				});
				modelo = new DefaultTableModel();
				table.setModel(modelo);
				loadTable(null);
				scrollPane.setViewportView(table);
			}
			{
				JPanel pnlEmpresa = new JPanel();
				pnlEmpresa.setBackground(SystemColor.inactiveCaption);
				pnlEmpresa.setLayout(null);
				pnlEmpresa.setBounds(10, 21, 542, 64);
				panel.add(pnlEmpresa);
				
				JLabel lblRNC = new JLabel("RNC:");
				lblRNC.setBounds(20, 12, 46, 14);
				pnlEmpresa.add(lblRNC);
				
				JLabel lblName = new JLabel("Nombre:");
				lblName.setBounds(20, 39, 58, 14);
				pnlEmpresa.add(lblName);
				
				txtName = new JTextField();
				txtName.setBackground(SystemColor.controlLtHighlight);
				txtName.setEnabled(false);
				txtName.setBounds(76, 36, 430, 20);
				pnlEmpresa.add(txtName);
				txtName.setColumns(10);
				
				MaskFormatter mascara = new MaskFormatter("##########");
				ftxtRNC = new JFormattedTextField(mascara);
				ftxtRNC.setBounds(76, 9, 117, 20);
				pnlEmpresa.add(ftxtRNC);
				
				JButton btnSearch = new JButton("");
				btnSearch.setIcon(new ImageIcon(Match.class.getResource("/icons/Logo Buscar.png")));
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ftxtCodSolicitud.setValue("");
						model.clear();
						modelCont.clear();

						if (Bolsa_Laboral.getInstance().RetornarEmpresa(ftxtRNC.getText()) != null) {
							miEmpresa = Bolsa_Laboral.getInstance().RetornarEmpresa(ftxtRNC.getText());
							txtName.setText(miEmpresa.getNombre());
							loadTable(miEmpresa);
						} else {
							JOptionPane.showMessageDialog(null,
									"No se encontro una empresa con el RNC digitado.", "Información",
									JOptionPane.WARNING_MESSAGE, null);
						}
					}
				});
				btnSearch.setBounds(203, 9, 29, 21);
				pnlEmpresa.add(btnSearch);
				
				JLabel lblCod = new JLabel("Id Solicitud:");
				lblCod.setBounds(300, 12, 79, 14);
				pnlEmpresa.add(lblCod);
				
				ftxtCodSolicitud = new JFormattedTextField();
				ftxtCodSolicitud.setBackground(SystemColor.controlLtHighlight);
				ftxtCodSolicitud.setEnabled(false);
				ftxtCodSolicitud.setBounds(389, 9, 117, 20);
				pnlEmpresa.add(ftxtCodSolicitud);
			}
			
			btnCandidatos = new JButton("Ver Candidatos");
			btnCandidatos.setIcon(new ImageIcon(Match.class.getResource("/icons/ver.png")));
			btnCandidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.removeAllElements();
					modelCont.removeAllElements();
					Solicitud soli = Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo);
					if (soli != null) {
						misSolicitantesC = Bolsa_Laboral.getInstance().matcheo(soli);
					}

					cargarSolicitante();
				}
			});
			btnCandidatos.setEnabled(false);
			btnCandidatos.setBounds(410, 294, 142, 23);
			panel.add(btnCandidatos);
			
			JButton btnClean = new JButton("Limpiar");
			btnClean.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadTable(null);
					ftxtCodSolicitud.setText("");
					txtName.setText("");
					ftxtRNC.setText("");
					model.clear();
					modelCont.clear();
				}
			});
			btnClean.setIcon(new ImageIcon(Match.class.getResource("/icons/filtrar.png")));
			btnClean.setBounds(297, 294, 103, 23);
			panel.add(btnClean);
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnContratar = new JButton("Contratar");
				btnContratar.setIcon(new ImageIcon(Match.class.getResource("/icons/Contratar.png")));
				btnContratar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (misSolicitantesC.size() != 0) {
							Solicitud solicitud = Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo);
							ArrayList<Personal> auxSoliC = new ArrayList<>();
							
							for (int i = 0; i < modelCont.getSize(); i++) {
								auxSoliC.add(Bolsa_Laboral.getInstance().
										buscarSolicitanteByCe(modelCont.getElementAt(i).toString().substring(0,13)));
							}
							if(auxSoliC!= null) {
							int option = JOptionPane.
									showConfirmDialog(null, "Esta a punto de contratar empleado/s. Esta seguro? ", "Aviso", JOptionPane.WARNING_MESSAGE);
							        if(option == JOptionPane.OK_OPTION) {
								Bolsa_Laboral.getInstance().contratarEmpleados(solicitud, auxSoliC);
								clean();
								JOptionPane.showMessageDialog(null, "Operación Satisfactoria.", "Información",
										JOptionPane.INFORMATION_MESSAGE, null);
								Principal.actualizarPastel();
								Principal.actualizarPastel2();
								Principal.actualizarChart();
							    } 
								
							}
						}else {
							JOptionPane.showMessageDialog(null,
									"No existen solicitantes para satisfacer esta solicitud",
									"Información", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
				});
				btnContratar.setActionCommand("OK");
				buttonPane.add(btnContratar);
				getRootPane().setDefaultButton(btnContratar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(Match.class.getResource("/icons/cancelar.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
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
		columnModel.getColumn(2).setPreferredWidth(104);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(100);

	}
	
	public void cargarSolicitante() {
		if (misSolicitantesC.size() != 0) {
			for (Personal soli : misSolicitantesC) {
				String candidato = soli.getCedula() + "     " + soli.getName() + " " + soli.getApellido();
				model.addElement(candidato);
			}
			lstSoli.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null,
					"No existen solicitantes para satisfacer esta solicitud", "Información",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}



	public void clean() {
		ftxtCodSolicitud.setText("");
		ftxtRNC.setText("");
		txtName.setText("");
		model.clear();
		modelCont.clear();
		misSolicitantesC = new ArrayList<>();
		loadTable(null);
	}
}