package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Bolsa_Laboral;
import logic.Solicitud;
import logic.SolicitudBachiller;
import logic.SolicitudTecnico;
import logic.SolicitudUniversitario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class PorcentajeSas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PorcentajeSas dialog = new PorcentajeSas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PorcentajeSas() {
		setTitle("Porcentajes de Contrataci\u00F3n");
		setBounds(100, 100, 719, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "Porcentajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 683, 376);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 22, 663, 332);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] colimneNames = { "Nombre Empresa", "Tipo Solicitud", "Cantidad Vacantes",
				"Porcentaje Completado" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colimneNames);
		table.setModel(model);
		table.getTableHeader().setResizingAllowed(false);
		cargarTabla();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(PorcentajeSas.class.getResource("/icons/aceptar.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void cargarTabla() {
		float cant1 = 0;
		float cant2 = 0;
		float porciento = 0;
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Solicitud soli : Bolsa_Laboral.getInstance().getMisSolicitudes()) {
			
			fila[0] = soli.getEmpresa().getNombre();
			fila[1] = tipoSolicitud(soli);
			fila[2] = soli.getCantVacantes();
			cant1 = soli.getCantVacantes();
			cant2 = soli.getCantSolicitudes();
			porciento = (cant2 / cant1 )*100;
			
			fila[3] = porciento+" %";
			model.addRow(fila);

		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(160);
		columnModel.getColumn(1).setPreferredWidth(167);
		columnModel.getColumn(2).setPreferredWidth(166);
		columnModel.getColumn(3).setPreferredWidth(167);

	}

	public String tipoSolicitud(Solicitud soli) {
		String tipoSoli = null;
		if (soli instanceof SolicitudBachiller) {
			tipoSoli = "Solicitud Obrero";
		}
		if (soli instanceof SolicitudTecnico) {
			tipoSoli = "Solicitud Tecnico";
		} else {
			tipoSoli = "Solicitud Universitario";
		}
		return tipoSoli;
	}

}
