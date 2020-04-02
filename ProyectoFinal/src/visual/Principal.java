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
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;
	

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Bolsa_Laboral.getInstance().writeBolsa();
			}
		});
		setTitle("Cercarti Group");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		Bolsa_Laboral.getInstance().readBolsa();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Empresa");
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
		
		JMenu mnSolicitudEmpresa = new JMenu("Solicitud");
		mnSolicitudEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(mnSolicitudEmpresa);
		
		JMenuItem mntmSolicitudEmpresa = new JMenuItem("Solicitud Empresa");
		mntmSolicitudEmpresa.setBackground(SystemColor.inactiveCaptionBorder);
		mntmSolicitudEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarSolicitud_Empresa solicitud = new InsertarSolicitud_Empresa(null);
				solicitud.setModal(true);
				solicitud.setVisible(true);
			}
		});
		mnSolicitudEmpresa.add(mntmSolicitudEmpresa);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listado de Solicitudes");
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
		menuBar.add(mnPersonal);
		
		JMenuItem mntSolicitudP = new JMenuItem("Solicitud");
		mntSolicitudP.setBackground(SystemColor.inactiveCaptionBorder);
		mntSolicitudP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarSolicitante insertP = new InsertarSolicitante();
				insertP.setModal(true);
				insertP.setVisible(true);
				
			}
		});
		mnPersonal.add(mntSolicitudP);
		
		JMenu mnMatcheo = new JMenu("Matcheo");
		menuBar.add(mnMatcheo);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnMatcheo.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
	}

}
