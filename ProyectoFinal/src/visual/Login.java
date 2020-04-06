package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Bolsa_Laboral;
import logic.User;


import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblMin; 
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Bolsa_Laboral.getInstance().readBolsa();
				User aux = new User("Administrador", "Admin", "Admin");
			    Bolsa_Laboral.getInstance().regUser(aux);;
				Bolsa_Laboral.getInstance().writeBolsa();
			
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		this.setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 450, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login DAEX\u00A9");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(21, 11, 167, 29);
		panel.add(lblNewLabel);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblClose.setBounds(418, 11, 22, 29);
		panel.add(lblClose);
		
		lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		lblMin.setForeground(Color.WHITE);
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMin.setBounds(386, 11, 10, 29);
		panel.add(lblMin);
		
		JLabel lblNewLabel_3 = new JLabel("Bolsa Laboral");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(123, 41, 136, 14);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(0, 65, 450, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(new Color(236,240,241));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 54, 75, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(22, 110, 129, 17);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(108, 122, 137));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(131, 53, 224, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Bolsa_Laboral.getInstance().confirmLogin(textField.getText(),textField_1.getText())){
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				};
				
			}
		});
		btnNewButton.setBackground(new Color(34, 167, 240));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(266, 144, 89, 35);
		panel_1.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(108, 122, 137));
		textField_1.setBounds(131, 108, 224, 20);
		panel_1.add(textField_1);
		
	}
}
