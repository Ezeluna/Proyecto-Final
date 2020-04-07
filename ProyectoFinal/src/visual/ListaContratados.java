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
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Bachiller;
import logic.Personal;
import logic.Tecnico;
import logic.Universitario;
import logic.Bolsa_Laboral;
import logic.Solicitud;
import logic.Empresa;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Button;


public class ListaContratados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private  JTable table;
	private  DefaultTableModel model;
	private static Object[] fila;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private Empresa miEmpresa; 

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaContratados() throws ParseException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaContratados.class.getResource("/icons/Listas.png")));
		setTitle("Lista de contratados");
		setBounds(100, 100, 719, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new TitledBorder(null, "Personal Contratado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 93, 693, 296);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			scrollPane.setBounds(10, 23, 673, 255);
			panel.add(scrollPane);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			table.setModel(model);
			table.getTableHeader().setResizingAllowed(false);
			loadTabla();
			//loadEmpresa();
			scrollPane.setViewportView(table);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 693, 71);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		MaskFormatter mascara = new MaskFormatter("##########");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(ListaContratados.class.getResource("/icons/aceptar.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public  String tipoEmpleado(Personal pers) {
		String tipoEmp = null;
		if(pers instanceof Bachiller) {
			tipoEmp = "Bachiller";
		}
		if(pers instanceof Tecnico) {
			tipoEmp = "Técnico";
		}
		if(pers instanceof Universitario) {
			tipoEmp = "Universitario";
		}
		
		return tipoEmp;
	}
	
	
	private  void loadTabla() {
		String [] columNombres = {"Cédula", "Empleado", "Tipo de empleado", "Empresa"};
		model.setColumnIdentifiers(columNombres);
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(Personal aux : Bolsa_Laboral.getInstance().getMisSolicitantes()) {	
			if(aux.isContratado()) {
					fila[0] = aux.getCedula();
					fila[1] = aux.getName() + " " + aux.getApellido();
					fila[2] = tipoEmpleado(aux);
					for(Empresa aux2 : Bolsa_Laboral.getInstance().getMisEmpresas()) {
					fila[3] =  aux2.getNombre();
					model.addRow(fila);
			   } 
	        } 
		}
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < columNombres.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(170);
		columnModel.getColumn(1).setPreferredWidth(170);
		columnModel.getColumn(2).setPreferredWidth(165);
		columnModel.getColumn(3).setPreferredWidth(167);

		
	}
	

}
