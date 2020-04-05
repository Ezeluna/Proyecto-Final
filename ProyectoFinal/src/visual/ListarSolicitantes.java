package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import logic.Personal;
import logic.Bolsa_Laboral;
import logic.Bachiller;
import logic.Tecnico;
import logic.Universitario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

public class ListarSolicitantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modeloTabla;
	private static Object[] fila;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JComboBox cbxMostrar;
	private String cedulaCliente = "";
	private JComboBox<String> habilidades;
	private static JComboBox<String> cbxIdioma;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListarSolicitantes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarSolicitantes.class.getResource("/icons/Listas.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cbxMostrar.setSelectedIndex(0);
				cargarTablaG();
			}
		});
		setResizable(false);
		setModal(true);
		setTitle("Listar Solicitantes");
		setResizable(false);
		setBounds(100, 100, 987, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new TitledBorder(null, "Listado de Solicitantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 951, 417);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblMostrarPor = new JLabel("Mostrar por:");
			lblMostrarPor.setBounds(10, 33, 77, 14);
			panel.add(lblMostrarPor);
			
			cbxMostrar = new JComboBox();
			cbxMostrar.setBackground(Color.WHITE);
			cbxMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String seleccion = cbxMostrar.getSelectedItem().toString();
					if (seleccion.equalsIgnoreCase("General")) {
						cargarTablaG();
					}
					if (seleccion.equalsIgnoreCase("Universitarios")) {
						cargarTablaU();
					}
					if (seleccion.equalsIgnoreCase("Bachilleres")) {
						cargarTablaB();
					}
					if (seleccion.equalsIgnoreCase("Técnicos")) {
						cargarTablaT();
					}
				
				}
			});
			cbxMostrar.setModel(new DefaultComboBoxModel(new String[] {"General", "Bachilleres", "T\u00E9cnicos", "Universitarios"}));
			cbxMostrar.setToolTipText("");
			cbxMostrar.setBounds(95, 30, 119, 20);
			panel.add(cbxMostrar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 60, 931, 343);
			panel.add(scrollPane);
			{	
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int aux = table.getSelectedRow();
					
					if(aux > -1) {
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
						cedulaCliente = (String) table.getModel().getValueAt(aux,0);
					} else {
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						cedulaCliente = "";	
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getTableHeader().setResizingAllowed(false);
			modeloTabla = new DefaultTableModel() {

				@Override
				public boolean isCellEditable(int row, int column) {
					return true;
				}
			};
			String tipo = cbxMostrar.getSelectedItem().toString();

			loadTabla(tipo);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setIcon(new ImageIcon(ListarSolicitantes.class.getResource("/icons/borrar.png")));
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Personal soli = Bolsa_Laboral.getInstance().buscarSolicitanteByCe(cedulaCliente);

					if (soli != null) {
						if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la solicitud?", "AVISO",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							Bolsa_Laboral.getInstance().eliminarSolicitante(soli);
							//Principal.actualizarChart();

						}
					}
				}
				
			});
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(ListarSolicitantes.class.getResource("/icons/modificar.png")));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Personal persona = Bolsa_Laboral.getInstance().buscarSolicitanteByCe(cedulaCliente);
						InsertarSolicitante soli = new InsertarSolicitante("Modificar Solicitante", true, persona, null);
						soli.setModal(true);
						soli.setLocationRelativeTo(null);
						soli.setVisible(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						cedulaCliente = "";
		
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setIcon(new ImageIcon(ListarSolicitantes.class.getResource("/icons/cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	}
	
	public static void cargarTablaG() {
		String tipo = "";
		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Experiencia", "Tipo" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
			if (soli.isContratado() == false) {
				if (!soli.isContratado()) {
					tipo = "Universitario";
					if (soli instanceof Bachiller) {
						tipo = "Bachiller";
					}
					if (soli instanceof Tecnico) {
						tipo = "Técnico";
					}
					fila[0] = soli.getCedula();
					fila[1] = soli.getName() + " " + soli.getApellido();
					fila[2] = soli.getEdad() + " años";
					fila[3] = soli.getYearExperiencia() + " años";
					fila[4] = tipo;
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					centrar.setHorizontalAlignment(SwingConstants.CENTER);
					for (int i = 0; i < nombreColumna.length; i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(centrar);
					}
					
					modeloColumna.getColumn(0).setPreferredWidth(160);
					modeloColumna.getColumn(1).setPreferredWidth(282);
					modeloColumna.getColumn(2).setPreferredWidth(160);
					modeloColumna.getColumn(3).setPreferredWidth(170);
					modeloColumna.getColumn(4).setPreferredWidth(160);
				}
			}

		}

	}
	
	public  void cargarTablaB() {

		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Habilidades", "Idiomas", "Experiencia",
				"Teléfono", "E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
			if (soli instanceof Bachiller) {
				if (soli.isContratado() == false) {
					String[] idioma = llenarA(soli.getIdiomas());
					String[] habilidad = llenarA(((Bachiller) soli).getHabilidades());
					habilidades = new JComboBox<String>(habilidad);
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();
					setCombo();

					fila[0] = soli.getCedula();
					fila[1] = soli.getName() + " " + soli.getApellido();
					fila[2] = soli.getEdad() + " años";
					fila[3] = "Hacer click";
					fila[4] = "Hacer click";
					fila[5] = soli.getYearExperiencia() + " años";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getCorreo();
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					centrar.setHorizontalAlignment(SwingConstants.CENTER);
					for (int i = 0; i < nombreColumna.length; i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(centrar);
					}
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(120);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(100);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(160);
				}
			}

		}
	}
	
	public void cargarTablaT() {
		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Área", "Idiomas", "Experiencia", "Teléfono",
				"E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
			if (soli instanceof Tecnico) {
				if (soli.isContratado() == false) {
					String[] idioma = llenarA(soli.getIdiomas());
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();

					fila[0] = soli.getCedula();
					fila[1] = soli.getName() + " " + soli.getApellido();
					fila[2] = soli.getEdad() + " años";
					fila[3] = ((Tecnico) soli).getArea();
					fila[4] = "Hacer click";
					fila[5] = soli.getYearExperiencia() + " años";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getCorreo();
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					centrar.setHorizontalAlignment(SwingConstants.CENTER);
					for (int i = 0; i < nombreColumna.length; i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(centrar);
					}
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(120);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(100);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(160);
				}
			}

		}

	}
	
	public static void cargarTablaU() {

		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Carrera", "Idiomas", "Experiencia", "Teléfono",
				"E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
			if (soli instanceof Universitario) {
				if (soli.isContratado() == false) {
					String[] idioma = llenarA(soli.getIdiomas());
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();

					fila[0] = soli.getCedula();
					fila[1] = soli.getName() + " " + soli.getApellido();
					fila[2] = soli.getEdad() + " años";
					fila[3] = ((Universitario) soli).getCarrera();
					fila[4] = "Hacer click";
					fila[5] = soli.getYearExperiencia() + " años";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getCorreo();

					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					centrar.setHorizontalAlignment(SwingConstants.CENTER);
					for (int i = 0; i < nombreColumna.length; i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(centrar);
					}
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(120);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(100);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(160);
				}
			}

		}
	}

	public static void loadTabla(String seleccion) {
		if (seleccion.equalsIgnoreCase("General")) {
			cargarTablaG();
		}
		if (seleccion.equalsIgnoreCase("Universitarios")) {
			cargarTablaU();

		}
		if (seleccion.equalsIgnoreCase("Bachilleres")) {

		}
		if (seleccion.equalsIgnoreCase("Técnicos")) {

		}
	}
	
	public static String[] llenarA(ArrayList<String> copiado) {
		String[] arr = new String[copiado.size()];
		copiado.toArray(arr);
		return arr;
	}
	
	public static void setComboIdiomas() {
		TableColumn col = table.getColumnModel().getColumn(4);
		col.setCellEditor(new DefaultCellEditor(cbxIdioma));
	}

	
	public void setCombo() {
		TableColumn col = table.getColumnModel().getColumn(3);
		col.setCellEditor(new DefaultCellEditor(habilidades));
		habilidades.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

	}
}
