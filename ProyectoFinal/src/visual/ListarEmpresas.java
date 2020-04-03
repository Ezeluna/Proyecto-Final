package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Bolsa_Laboral;
import logic.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ListarEmpresas extends JDialog {
	

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private DefaultTableModel model;
	private JButton btnModificar;
	private Bolsa_Laboral bolsa = Bolsa_Laboral.getInstance();
	private String cod;
	private Empresa miem = null;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	
	
	  public static void main(String[] args) { try { ListarEmpresas dialog = new
	  ListarEmpresas(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	  dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	  
	  }
	 
	 

	/**
	 * Create the dialog.
	 */
	public ListarEmpresas() {
		setResizable(false);
		setTitle("Listado de Empresas");
		setBounds(100, 100, 671, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "Lista de Empresas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 645, 414);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 625, 360);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();

				if (aux > -1) {

					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
					cod = (String) table.getModel().getValueAt(aux, 0);

				} else {
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					String cod = "";
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] colimneNames = { "RNC", "Nombre", "Provincia", "Télefono", "Email" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colimneNames);
		table.setModel(model);
		table.getTableHeader().setResizingAllowed(false);
		loadTable();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setIcon(new ImageIcon(ListarEmpresas.class.getResource("/icons/borrar.png")));
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cod != "") {
						int answer = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la empresa?",
								"Devolver publicacion", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null);
						if (answer == JOptionPane.YES_OPTION) {
							Bolsa_Laboral.getInstance().eliminarEmpresa(cod);
							loadTable();
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
					Bolsa_Laboral.getInstance().eliminarEmpresa(cod);
				}
			});
			buttonPane.add(btnEliminar);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(ListarEmpresas.class.getResource("/icons/modificar.png")));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cod != "") {
							miem = Bolsa_Laboral.getInstance().RetornarEmpresa(cod);
						

						}
							InsertarEmpresa modificarempre = new InsertarEmpresa("Modificar Empresa", true, miem, null);
							modificarempre.setModal(true);
							modificarempre.setLocationRelativeTo(null);
							modificarempre.setVisible(true);
							loadTable();
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(ListarEmpresas.class.getResource("/icons/cancelar.png")));
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
	
	private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Empresa miemp : bolsa.getMisEmpresas()) {
			fila[0] = miemp.getRNC();
			fila[1] = miemp.getNombre();
			fila[2] = miemp.getProvincia();
			fila[3] = miemp.getTelefono();
			fila[4] = miemp.getEmail();
			model.addRow(fila);

		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(90);
		columnModel.getColumn(1).setPreferredWidth(145);
		columnModel.getColumn(2).setPreferredWidth(115);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(180);

	}
}
