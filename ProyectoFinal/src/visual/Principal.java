package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Bolsa_Laboral;


import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JSeparator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import java.awt.Panel;
import java.awt.Color;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim = null;
	private static JPanel panelBarrasSolici;
	private static CategoryDataset datasetBarra;
	private static PieDataset datasetPastel;
	private static JFreeChart chartBarra;
	private static JFreeChart chartPastel;
	private static JPanel panelPastel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-pie-chart-64.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "�Desea guardar los nuevos cambios en DAEX\u00A9 - Bolsa Laboral?",
						"Atenci�n Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					Loading load = new Loading(1); 
					load.setVisible(true);
					load.setLocationRelativeTo(null);
					Bolsa_Laboral.getInstance().writeBolsa();
					dispose();
				}else {
					dispose();
				}
				
			}
		});
		setTitle("DAEX\u00A9 - Bolsa Laboral");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		Bolsa_Laboral.getInstance().readBolsa();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnMatcheo = new JMenu("Bolsa Laboral");
		mnMatcheo.setIcon(new ImageIcon(Principal.class.getResource("/icons/pareo24.png")));
		mnMatcheo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnMatcheo);
		
		JMenuItem mntmPareo = new JMenuItem("Realizar Match");
		mntmPareo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Match match;
				try {
					match = new Match();
					match.setModal(true);
					match.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		mntmPareo.setBackground(SystemColor.inactiveCaptionBorder);
		mnMatcheo.add(mntmPareo);
		
		JMenuItem mntContratados = new JMenuItem("Personal Contratado");
		mntContratados.setBackground(SystemColor.inactiveCaptionBorder);
		mnMatcheo.add(mntContratados);
		
		JMenu mnNewMenu = new JMenu("Empresa");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/icons/empresa24.png")));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrarEmpresa = new JMenuItem("Registrar Empresa");
		mntmRegistrarEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		mntmRegistrarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarEmpresa empre;
				empre = new InsertarEmpresa("Insertar Empresa", false, null, null);
				empre.setModal(true);
				empre.setLocationRelativeTo(null);
				empre.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRegistrarEmpresa);
		
		JMenuItem mntmListarEmpresas = new JMenuItem("Listado de Empresas");
		mntmListarEmpresas.setBackground(SystemColor.inactiveCaptionBorder);
		mntmListarEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpresas empre;
				empre = new ListarEmpresas(); 
				empre.setModal(true);
				empre.setLocationRelativeTo(null);
				empre.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListarEmpresas);
		
		JMenu mnSolicitudEmpresa = new JMenu("Solicitud Empresarial");
		mnSolicitudEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/icons/Solicitud24.png")));
		mnSolicitudEmpresa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnSolicitudEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(mnSolicitudEmpresa);
		
		JMenuItem mntmSolicitudEmpresa = new JMenuItem("Registrar Solicitud");
		mntmSolicitudEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		mntmSolicitudEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarSolicitud_Empresa solicitud = new InsertarSolicitud_Empresa(null);
				solicitud.setModal(true);
				solicitud.setVisible(true);
			}
		});
		mnSolicitudEmpresa.add(mntmSolicitudEmpresa);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar Solicitud");
		mntmNewMenuItem.setBackground(SystemColor.inactiveCaptionBorder);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarSolicitud_Empresa listsolicitud = new ListarSolicitud_Empresa();
				listsolicitud.setModal(true);
				listsolicitud.setVisible(true);
			}
		});
		mnSolicitudEmpresa.add(mntmNewMenuItem);
		
		JMenu mnPersonal = new JMenu("Personal");
		mnPersonal.setIcon(new ImageIcon(Principal.class.getResource("/icons/Solicitante24.png")));
		mnPersonal.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnPersonal);
		
		JMenuItem mntSolicitudP = new JMenuItem("Solicitud");
		mntSolicitudP.setBackground(SystemColor.inactiveCaptionBorder);
		mntSolicitudP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarSolicitante insertP = new InsertarSolicitante("Insertar Solicitante", false, null, null);
				insertP.setModal(true);
				insertP.setVisible(true);
				
			}
		});
		mnPersonal.add(mntSolicitudP);
		
		JMenuItem mntListarSP = new JMenuItem("Listar Personal");
		mntListarSP.setBackground(SystemColor.inactiveCaptionBorder);
		mntListarSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarSolicitantes solici = new ListarSolicitantes();
				solici.setVisible(true);
				solici.setLocationRelativeTo(null);
				solici.setModal(true);
				
			}
		});
		mnPersonal.add(mntListarSP);
		
		JMenu mnUtilidades = new JMenu("Utilidades");
		mnUtilidades.setIcon(new ImageIcon(Principal.class.getResource("/icons/reportar24.png")));
		mnUtilidades.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnUtilidades);
		
		JMenuItem mntGuardar = new JMenuItem("Guardar Datos");
		mntGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bolsa_Laboral.getInstance().writeBolsa();
				Loading load = new Loading(2); 
				load.setVisible(true);
				load.setLocationRelativeTo(null);
			}
		});
		mntGuardar.setIcon(new ImageIcon(Principal.class.getResource("/icons/guardar.png")));
		mntGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		mnUtilidades.add(mntGuardar);
		
		JSeparator separator_1 = new JSeparator();
		mnUtilidades.add(separator_1);
		
		JMenuItem mntCerrar = new JMenuItem("Cerrar");
		mntCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "�Desea guardar los nuevos cambios en la bolsa laboral?",
						"Atenci�n Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Bolsa_Laboral.getInstance().writeBolsa();
					Loading load = new Loading(2); 
					load.setVisible(true);
					load.setLocationRelativeTo(null);
					dispose();
				}else {
					dispose();
				}

			}
		});
		mntCerrar.setIcon(new ImageIcon(Principal.class.getResource("/icons/cancelar.png")));
		mntCerrar.setBackground(SystemColor.inactiveCaptionBorder);
		mnUtilidades.add(mntCerrar);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/icons/DAEX_LOGO.png")));
		lblNewLabel.setBounds(550, -17, 195, 194);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 164, 1350, 2);
		panel.add(separator);
		
		panelBarrasSolici = new JPanel();
		panelBarrasSolici.setBackground(SystemColor.inactiveCaptionBorder);
		panelBarrasSolici.setBounds(26, 191, 416, 369);
		panel.add(panelBarrasSolici);
		panelBarrasSolici.setLayout(null);
		
		JLabel lblCharVacio = new JLabel("       NO HAY SOLICITANTES");
		lblCharVacio.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCharVacio.setBounds(10, 54, 381, 304);
		panelBarrasSolici.add(lblCharVacio);
		
		Panel panelBarrasCon = new Panel();
		panelBarrasCon.setBackground(SystemColor.inactiveCaptionBorder);
		panelBarrasCon.setBounds(468, 191, 416, 369);
		panel.add(panelBarrasCon);
		panelBarrasCon.setLayout(null);
		
		JLabel lblCharVacio2 = new JLabel("          NO HAY EMPLEADOS");
		lblCharVacio2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCharVacio2.setBounds(10, 54, 381, 304);
		panelBarrasCon.add(lblCharVacio2);
		
		JPanel panelPastel = new JPanel();
		panelPastel.setBackground(SystemColor.inactiveCaptionBorder);
		panelPastel.setBounds(912, 191, 416, 369);
		panel.add(panelPastel);
		panelPastel.setLayout(null);
		
		JLabel lblNoEmpleadosP = new JLabel("          NO HAY EMPLEADOS");
		lblNoEmpleadosP.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNoEmpleadosP.setBounds(10, 54, 381, 304);
		panelPastel.add(lblNoEmpleadosP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 579, 1350, 59);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
	}
	
	public static JFreeChart creandoGraficoB1(CategoryDataset dataSet, String titulo ) {
		JFreeChart grafico1 = ChartFactory.createBarChart3D(titulo, "Tipo de solicitante", "Cantidad de solicitante", dataSet, PlotOrientation.VERTICAL, false, true, false);
		
		//CategoryPlot plot = (CategoryPlot) grafico1.getPlot();
		Color color = new Color(255,120,80);
		grafico1.setBackgroundPaint(color);
		return grafico1;
	}
	
	public static CategoryDataset creandoCategoria() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoB(), "Tipo de Solicitante", "Obreros");
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoU(), "Tipo de Solicitante", "Universitarios");
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoT(), "Tipo de Solicitante", "T�cnicos");
		return dataset;
	}
	
	public static void actualizarChart() {
		panelBarrasSolici.removeAll();
		panelBarrasSolici.revalidate();
		datasetBarra = creandoCategoria();
		chartBarra = creandoGraficoB1(datasetBarra, "Solicitantes Desempleados");
		panelBarrasSolici.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(chartBarra);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		panelBarrasSolici.add(chartPanel, BorderLayout.CENTER);
		panelBarrasSolici.repaint();

	}
}
