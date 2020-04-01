package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableCellRenderer;


import logic.Bolsa_Laboral;
import logic.Empresa;
import logic.Solicitud;
import logic.SolicitudTecnico;
import logic.SolicitudUniversitario;
import logic.SolicitudBachiller; 

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
//
public class ListarSolicitud_Empresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table_1;
	private static Object[] fila;
	private static DefaultTableModel modeloTabla;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	public static JComboBox cbxfiltro;
	private Empresa empresaListar = null;
	private JFormattedTextField ftxtRNCempresa;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnShow;
	private String codigo = "";

	private static JComboBox<String> cbxHabilidades;
	private static JComboBox<String> cbxIdioma;
	


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListarSolicitud_Empresa() {
		setTitle("Lista de Solicitudes - Bolsa Laboral");
		setResizable(false);
		setBounds(100, 100, 943, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 907, 425);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 25, 68, 14);
		panel.add(lblFiltrarPor);
		
		cbxfiltro = new JComboBox();
		cbxfiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShow.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
		});
		cbxfiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxfiltro.getSelectedIndex() == 0) {
					ftxtRNCempresa.setText("");
					loadtabla(0);
				} else if (cbxfiltro.getSelectedIndex() == 1) {
					ftxtRNCempresa.setText("");
					loadtabla(1);
				} else if (cbxfiltro.getSelectedIndex() == 2) {
					ftxtRNCempresa.setText("");
					loadtabla(2);
				} else if (cbxfiltro.getSelectedIndex() == 3) {
					ftxtRNCempresa.setText("");
					loadtabla(3);
				}

			}
		});
		cbxfiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Universitarios", "T\u00E9cnicos", "Bachilleres"}));
		cbxfiltro.setBounds(77, 21, 118, 23);
		panel.add(cbxfiltro);
		
		JLabel lblRncEmpresa = new JLabel("RNC Empresa:");
		lblRncEmpresa.setBounds(211, 25, 85, 14);
		panel.add(lblRncEmpresa);
		
		ftxtRNCempresa = new JFormattedTextField();
		ftxtRNCempresa.setBounds(306, 21, 118, 23);
		panel.add(ftxtRNCempresa);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShow.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
				empresaListar = Bolsa_Laboral.getInstance().RetornarEmpresa(ftxtRNCempresa.getText());

				if (empresaListar != null) {
					loadTablaRNC();
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró ningún solicitud para el RNC dado.",
							"ATENCIÓN", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnSearch.setBounds(430, 21, 29, 23);
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShow.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
		});
		scrollPane.setBounds(10, 58, 887, 356);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table_1.getSelectedRow();
				if (aux > -1) {
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnShow.setEnabled(true);
					codigo = (String) table_1.getModel().getValueAt(aux, 0);

				} else {
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					btnShow.setEnabled(false);
					codigo = "";
				}
			}
		});
		modeloTabla = new DefaultTableModel();
		table_1.getTableHeader().setResizingAllowed(false);
		loadAll();
		scrollPane.setViewportView(table_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar esta solicitud?", "Atención Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							if (!codigo.equalsIgnoreCase("")) {
								if (Bolsa_Laboral.getInstance().EliminarSolicitud(codigo)) {
									loadtabla(cbxfiltro.getSelectedIndex());
									JOptionPane.showMessageDialog(null, "Se ha eliminada la solicitud", "Información",
											JOptionPane.INFORMATION_MESSAGE, null);

									btnEliminar.setEnabled(false);
									btnShow.setEnabled(false);
									btnModificar.setEnabled(false);
								}
							}
						}
					}
				});
				
				btnShow = new JButton("Ver Solicitud");
				btnShow.setEnabled(false);
				btnShow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DetallesSolicitudE detalle = new DetallesSolicitudE();//Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo)
						detalle.setModal(true);
						detalle.setVisible(true);
					}
				});
				buttonPane.add(btnShow);
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsertarSolicitud_Empresa modificarSoli = new InsertarSolicitud_Empresa(Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo));
						modificarSoli.setModal(true);
						modificarSoli.setVisible(true);
						Solicitud soli = Bolsa_Laboral.getInstance().RetornarSolocitudId(codigo);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
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
	}
	
	public static void loadtabla(int i) {
		if (i == 0) {
			loadAll();
			cbxIdioma = new JComboBox<String>();
		}
		if (i == 1) {
			loadUniversitario();
		}
		if (i == 2) {
			loadTecnico();

		}
		if (i == 3) {
			loadBachiller();
		}

	}

	private static void loadAll() {
		String[] nombreColumna = { "Código", "Empresa", "Tipo", "Rango Edad", "Vehiculo", "Provincia" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {

			fila[0] = soli.getId();
			fila[1] = soli.getEmpresa().getNombre();
			if (soli instanceof SolicitudUniversitario) {
				fila[2] = "Universitario";
			}
			if (soli instanceof SolicitudTecnico) {
				fila[2] = "Técnico";
			}
			if (soli instanceof SolicitudBachiller) {
				fila[2] = "Bachiller";
			}
			String min = Integer.toString(soli.getEdadMin());
			String max = Integer.toString(soli.getEdadMax());
			fila[3] = min + " - " + max;

			if (soli.isVehiculoPropio()) {
				fila[4] = "Si";
			} else {
				fila[4] = "No";
			}
			fila[5] = soli.getLocalidad();
			modeloTabla.addRow(fila);
		}
		table_1.setModel(modeloTabla);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table_1.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(130);
		columnModel.getColumn(5).setPreferredWidth(159);

	}

	private static void loadUniversitario() {
		String[] nombreColumna = { "Código", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Carrera", "PostGrado" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudUniversitario) {
				String[] idioma = llenado(soli.getIdiomas());
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();

				fila[0] = soli.getId();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();
				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;
				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = ((SolicitudUniversitario) soli).getCarrera();
				if (((SolicitudUniversitario) soli).isPostGrado()) {
					fila[8] = "Si";
				} else {
					fila[8] = "No";
				}
				modeloTabla.addRow(fila);

			}

		}
		table_1.setModel(modeloTabla);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table_1.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(110);
		columnModel.getColumn(4).setPreferredWidth(60);
		columnModel.getColumn(5).setPreferredWidth(110);
		columnModel.getColumn(6).setPreferredWidth(120);
		columnModel.getColumn(7).setPreferredWidth(121);
		columnModel.getColumn(8).setPreferredWidth(84);

	}

	private static void loadTecnico() {
		String[] nombreColumna = { "Código", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Area" };

		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudTecnico) {
				String[] idioma = llenado(soli.getIdiomas());
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();

				fila[0] = soli.getId();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();

				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;

				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = ((SolicitudTecnico) soli).getArea();

				modeloTabla.addRow(fila);

			}

		}
		table_1.setModel(modeloTabla);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table_1.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(81);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(135);
		columnModel.getColumn(7).setPreferredWidth(139);

	}

	private static void loadBachiller() {
		String[] nombreColumna = { "Código", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Habilidades" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudBachiller) {
				String[] idioma = llenado(soli.getIdiomas());
				String[] habilidad = llenado(((SolicitudBachiller) soli).getHabilidades());
				cbxHabilidades = new JComboBox<String>(habilidad);
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();
				setCombo();

				fila[0] = soli.getId();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();

				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;
				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = "Ver Habilidades";

				modeloTabla.addRow(fila);

			}

		}
		table_1.setModel(modeloTabla);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table_1.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(81);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(135);
		columnModel.getColumn(7).setPreferredWidth(139);

	}
	
	private void loadTablaRNC() {
		ArrayList<Solicitud> lista = new ArrayList<>();
		lista = Bolsa_Laboral.getInstance().RetornaSolicitudEmp(empresaListar);
		String[] nombreColumna = { "Código", "Empresa", "Tipo","Rango Edad", "Vehiculo","Provincia" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];

		for (Solicitud soli : lista) {
		
			fila[0] = soli.getId();
			fila[1] = soli.getEmpresa().getNombre();
			if (soli instanceof SolicitudUniversitario) {
				fila[2] = "Universitario";
			}
			if (soli instanceof SolicitudTecnico) {
				fila[2] = "Técnico";
			}
			if (soli instanceof SolicitudBachiller) {
				fila[2] = "Bachiller";
			}
			String min = Integer.toString(soli.getEdadMin());
			String max = Integer.toString(soli.getEdadMax());
			fila[3] = min + " - " + max;
			if (soli.isVehiculoPropio()) {
				fila[4] = "Si";
			} else {
				fila[4] = "No";
			}
			fila[5] = soli.getLocalidad();
			modeloTabla.addRow(fila);

		}
		table_1.setModel(modeloTabla);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table_1.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(130);
		columnModel.getColumn(5).setPreferredWidth(159);
	}

	public static void setComboIdiomas() {
		TableColumn col = table_1.getColumnModel().getColumn(6);
		col.setCellEditor(new DefaultCellEditor(cbxIdioma));
	}

	public static void setCombo() {
		TableColumn col = table_1.getColumnModel().getColumn(7);
		col.setCellEditor(new DefaultCellEditor(cbxHabilidades));

	}

	public static String[] llenado(ArrayList<String> copiado) {
		String[] arr = new String[copiado.size()];
		copiado.toArray(arr);
		return arr;
	}
}
