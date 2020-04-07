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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JSeparator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import java.awt.Panel;
import java.awt.Color;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim = null;
	private static JPanel panelBarrasSolici;
	public static JPanel panelPastel1; 
	public static JPanel panelPastel2;
	private static CategoryDataset datasetBarra;
	private static PieDataset datasetPastel;
	private static PieDataset datasetPastel2;
	private static JFreeChart chartBarra;
	private static JFreeChart chartPastel;
	private static JFreeChart chartPastel2;
	private JLabel lblhora; 
	private JLabel lblyear; 

	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-pie-chart-64.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea guardar los nuevos cambios en DAEX\u00A9 - Bolsa Laboral?",
						"Atención Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
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
		mntmPareo.setIcon(new ImageIcon(Principal.class.getResource("/icons/pareo.png")));
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
		mntContratados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaContratados aux;
				try {
					aux = new ListaContratados();
					aux.setModal(true);
					aux.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntContratados.setIcon(new ImageIcon(Principal.class.getResource("/icons/Contratar.png")));
		mntContratados.setBackground(SystemColor.inactiveCaptionBorder);
		mnMatcheo.add(mntContratados);
		
		JMenuItem mntmPorcentaje = new JMenuItem("Porcentajes de Sastifacci\u00F3n");
		mntmPorcentaje.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-discount-finder-20.png")));
		mntmPorcentaje.setBackground(SystemColor.inactiveCaptionBorder);
		mntmPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PorcentajeSas aux = new PorcentajeSas();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnMatcheo.add(mntmPorcentaje);
		
		JMenu mnNewMenu = new JMenu("Empresa");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/icons/empresa24.png")));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrarEmpresa = new JMenuItem("Registrar Empresa");
		mntmRegistrarEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/icons/addEmpresa.png")));
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
		mntmListarEmpresas.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
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
		mntmSolicitudEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/icons/addSolicitud.png")));
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
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
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
		mntSolicitudP.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
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
		mntListarSP.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
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
		mnUtilidades.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-file-configuration-32.png")));
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nueo Usuario");
		mntmNewMenuItem_1.setBackground(SystemColor.inactiveCaptionBorder);
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/icons/add.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users users = new Users();
				users.setModal(true);
				users.setVisible(true);
			}
		});
		mnUtilidades.add(mntmNewMenuItem_1);
		mntGuardar.setIcon(new ImageIcon(Principal.class.getResource("/icons/guardar.png")));
		mntGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		mnUtilidades.add(mntGuardar);
		
		JSeparator separator_1 = new JSeparator();
		mnUtilidades.add(separator_1);
		
		JMenuItem mntCerrar = new JMenuItem("Cerrar");
		mntCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea guardar los nuevos cambios en la bolsa laboral?",
						"Atención Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
		
		panelPastel1 = new JPanel();
		panelPastel1.setBackground(SystemColor.inactiveCaptionBorder);
		panelPastel1.setBounds(468, 191, 416, 369);
		panel.add(panelPastel1);
		panelPastel1.setLayout(null);
		
		JLabel lblCharVacio2 = new JLabel("          NO HAY EMPLEADOS");
		lblCharVacio2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCharVacio2.setBounds(10, 54, 381, 304);
		panelPastel1.add(lblCharVacio2);
		
		panelPastel2 = new JPanel();
		panelPastel2.setBackground(SystemColor.inactiveCaptionBorder);
		panelPastel2.setBounds(912, 191, 416, 369);
		panel.add(panelPastel2);
		panelPastel2.setLayout(null);
		
		JLabel lblNoEmpleadosP = new JLabel("          NO HAY EMPLEADOS");
		lblNoEmpleadosP.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNoEmpleadosP.setBounds(10, 54, 381, 304);
		panelPastel2.add(lblNoEmpleadosP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 579, 1350, 59);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblhora = new JLabel("");
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblhora.setBounds(24, 11, 140, 39);
		panel_1.add(lblhora);
		
		lblyear = new JLabel("");
		lblyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblyear.setBounds(119, 11, 116, 39);
		panel_1.add(lblyear);
		
		actualizarChart();
		actualizarPastel();
		actualizarPastel2();
		reloj();
	}
	
	public static JFreeChart creandoGraficoB1(CategoryDataset dataSet, String titulo ) {
		JFreeChart grafico1 = ChartFactory.createBarChart3D(titulo, "Tipo de solicitantes", "Cantidad de solicitantes", dataSet, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot plot = (CategoryPlot) grafico1.getPlot();
		plot.setBackgroundPaint(new Color(236,240,241));
		grafico1.setBackgroundPaint(SystemColor.activeCaption);
		return grafico1;
	}
	
	public static CategoryDataset creandoCategoria() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoB(), "Tipo de Solicitantes", "Bachilleres");
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoT(), "Tipo de Solicitantes", "Técnicos");
		dataset.setValue(Bolsa_Laboral.getInstance().desempleadoU(), "Tipo de Solicitantes", "Universitarios");
		return dataset;
	}
	
	public static void actualizarChart() {
		panelBarrasSolici.removeAll();
		panelBarrasSolici.revalidate();
		datasetBarra = creandoCategoria();
		chartBarra = creandoGraficoB1(datasetBarra, "SOLICITANTES");
		panelBarrasSolici.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(chartBarra);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		panelBarrasSolici.add(chartPanel, BorderLayout.CENTER);
		panelBarrasSolici.repaint();

	}
	
	
	public static JFreeChart creandoGraficoP(PieDataset dataSet, String titulo) {
		JFreeChart chart = ChartFactory.createPieChart3D(titulo, dataSet, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setBackgroundPaint(new Color(236,240,241));
		chart.setBackgroundPaint(SystemColor.activeCaption);
		plot.setStartAngle(0.5);
		plot.setDirection(Rotation.CLOCKWISE);
		return chart;
	}
	
	public static PieDataset dataSetPastel() {
		DefaultPieDataset result = new DefaultPieDataset();
		if (Bolsa_Laboral.getInstance().porcientoB() != 0) {
			result.setValue("Bachiller", Bolsa_Laboral.getInstance().porcientoB());
		}
		if (Bolsa_Laboral.getInstance().porcientoT() != 0) {
			result.setValue("Tecnico", Bolsa_Laboral.getInstance().porcientoT());
		}
		if (Bolsa_Laboral.getInstance().porcientoU() != 0) {
			result.setValue("Universitario", Bolsa_Laboral.getInstance().porcientoU());
		}

		return result;
	}
	
	public static void actualizarPastel() {
		panelPastel1.removeAll();
		panelPastel1.revalidate();
		datasetPastel = dataSetPastel();
		chartPastel = creandoGraficoP(datasetPastel, "Trabajadores Contratados por Tipo");
		panelPastel1.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(chartPastel);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		panelPastel1.add(chartPanel, BorderLayout.CENTER);
		panelPastel1.repaint();

	}
	
	public static JFreeChart creandoGraficoP2(PieDataset dataSet, String titulo) {
		JFreeChart chart2 = ChartFactory.createPieChart3D(titulo, dataSet, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart2.getPlot();
		plot.setBackgroundPaint(new Color(236,240,241));
		chart2.setBackgroundPaint(SystemColor.activeCaption);
		plot.setStartAngle(0.5);
		plot.setDirection(Rotation.CLOCKWISE);
		return chart2;
	}
	public static PieDataset dataSetPastel2() {
		DefaultPieDataset result = new DefaultPieDataset();
		if (Bolsa_Laboral.getInstance().porcientoF() != 0) {
			result.setValue("Femenino", Bolsa_Laboral.getInstance().porcientoF());
		}
		if (Bolsa_Laboral.getInstance().porcientoH() != 0) {
			result.setValue("Masculino", Bolsa_Laboral.getInstance().porcientoH());
		}

		return result;
	}
	public static void actualizarPastel2() {
		panelPastel2.removeAll();
		panelPastel2.revalidate();
		datasetPastel2 = dataSetPastel2();
		chartPastel2 = creandoGraficoP2(datasetPastel2, "Porcentaje de Contratados por Género");
		panelPastel2.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel2 = new ChartPanel(chartPastel2);
		chartPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
		panelPastel2.add(chartPanel2, BorderLayout.CENTER);
		panelPastel2.repaint();

	}
	
	
	public void reloj() {

		Thread reloj = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar calen = new GregorianCalendar();
						int dia = calen.get(Calendar.DAY_OF_WEEK_IN_MONTH);
						int diaSemana = calen.get(Calendar.DAY_OF_WEEK);
						int mes = calen.get(Calendar.MONTH + 1);
						int minutos = calen.get(Calendar.MINUTE);
						int hora = calen.get(Calendar.HOUR);
						int sec = calen.get(Calendar.SECOND);
						int meri = calen.get(Calendar.AM_PM);
						LocalDate date = LocalDate.now();
						int anno = date.getYear();
						int mess= date.getMonthValue();
						int dias = date.getDayOfMonth();
						String realmes = "";
						String merid = "";
						if (meri == 1) {
							merid = " PM";
						} else {
							merid = " AM";
						}
						if (mess == 1) {
							realmes = "Enero";
						}
						if (mess == 1) {
							realmes = "Enero";
						}
						if (mess == 2) {
							realmes = "Febreo";
						}
						if (mess == 3) {
							realmes = "Marzo";
						}
						if (mess == 4) {
							realmes = "Abril";
						}
						if (mess == 5) {
							realmes = "Mayo";
						}
						if (mess == 6) {
							realmes = "Junio";
						}
						if (mess == 7) {
							realmes = "Julio";
						}
						if (mess == 8) {
							realmes = "Agosto";
						}
						if (mess == 9) {
							realmes = "Septiembre";
						}
						if (mess == 10) {
							realmes = "Octubre";
						}
						if (mess == 11) {
							realmes = "Novienbre";
						}
						if (mess == 12) {
							realmes = "Diciembre";
						}
						lblhora.setText(hora + ":" + minutos + ":" + sec + merid);
						lblyear.setText(dias+", "+realmes+", "+anno);
						

						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		reloj.start();

	}
}
