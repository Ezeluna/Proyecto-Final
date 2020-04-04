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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarSolicitantes dialog = new ListarSolicitantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarSolicitantes() {
		setTitle("Listar Solicitantes");
		setBounds(100, 100, 987, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado de Solicitantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 951, 417);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblMostrarPor = new JLabel("Mostrar por:");
			lblMostrarPor.setBounds(10, 33, 77, 14);
			panel.add(lblMostrarPor);
			
			cbxMostrar = new JComboBox();
			cbxMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String seleccion = cbxMostrar.getSelectedItem().toString();
					if (seleccion.equalsIgnoreCase("General")) {
						cargarTablaG();
					}
					if (seleccion.equalsIgnoreCase("Universitarios")) {
						cargarTablaU();
					}
					if (seleccion.equalsIgnoreCase("Obreros")) {
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
			scrollPane.setBounds(10, 60, 931, 343);
			panel.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
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
	
	public static void cargarTablaG() {
		String tipo = "";
		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Años de Experiencia", "Tipo" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : Bolsa_Laboral.getInstance().getMisSolicitantes()) {
			if (soli.isContratado() == false) {
				if (!soli.isContratado()) {
					tipo = "Universitario";
					if (soli instanceof Bachiller) {
						tipo = "Obrero";
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
					modeloColumna.getColumn(0).setPreferredWidth(160);
					modeloColumna.getColumn(1).setPreferredWidth(282);
					modeloColumna.getColumn(2).setPreferredWidth(160);
					modeloColumna.getColumn(3).setPreferredWidth(170);
					modeloColumna.getColumn(4).setPreferredWidth(150);
				}
			}

		}

	}
	
	public  void cargarTablaB() {

		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Habilidades", "Idiomas", "Años de Experiencia",
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
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(100);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
				}
			}

		}
	}
	
	public void cargarTablaT() {
		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Área", "Idiomas", "Años de Experiencia", "Teléfono",
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
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(100);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
				}
			}

		}

	}
	
	public static void cargarTablaU() {

		String[] nombreColumna = { "Cédula", "Nombre", "Edad", "Carrera", "Idiomas", "Años de Experiencia", "Teléfono",
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
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(150);
					modeloColumna.getColumn(2).setPreferredWidth(80);
					modeloColumna.getColumn(3).setPreferredWidth(110);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
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
		if (seleccion.equalsIgnoreCase("Bachiller")) {

		}
		if (seleccion.equalsIgnoreCase("Técnicos")) {

		}
	}
	
	
	
}
