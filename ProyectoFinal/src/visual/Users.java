package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Bolsa_Laboral;
import logic.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Users extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox comboBox;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Users dialog = new Users();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Users() {
		setResizable(false);
		setBounds(100, 100, 350, 415);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(44,62,80));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setUndecorated(true);
		
		JLabel lblNombreUsuario = new JLabel("Usuario:");
		lblNombreUsuario.setForeground(SystemColor.controlLtHighlight);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreUsuario.setBounds(27, 110, 97, 14);
		contentPanel.add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBackground(new Color(108, 122, 137));
		textField.setBounds(152, 106, 147, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setForeground(SystemColor.desktop);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Empresario", "Solicitante"}));
		comboBox.setBounds(152, 232, 147, 20);
		contentPanel.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(SystemColor.controlLtHighlight);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(27, 234, 97, 14);
		contentPanel.add(lblTipo);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setForeground(SystemColor.controlLtHighlight);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(27, 150, 97, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Conf. Contrase\u00F1a:");
		lblConfirmarPassword.setForeground(SystemColor.controlLtHighlight);
		lblConfirmarPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmarPassword.setBounds(27, 192, 173, 14);
		contentPanel.add(lblConfirmarPassword);
		{
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.setForeground(new Color(255, 255, 255));
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnRegistrar.setBackground(new Color(34, 167, 240));
			btnRegistrar.setBounds(186, 296, 97, 37);
			contentPanel.add(btnRegistrar);
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					User user = new User(comboBox.getSelectedItem().toString(),textField.getText(),passwordField.getText());
				    Bolsa_Laboral.getInstance().regUser(user);
				    textField.setText("");
				    passwordField.setText("");
				    passwordField_1.setText("");
				    comboBox.setSelectedIndex(0);
				    
				    
				    JOptionPane.showMessageDialog(null,
							"Usuario registrado satisfactoriamente.", "DAEX\u00A9 - Bolsa Laboral",
							JOptionPane.INFORMATION_MESSAGE, null);
				}
			});
			btnRegistrar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnRegistrar);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBackground(new Color(255, 69, 0));
			cancelButton.setForeground(new Color(255, 255, 255));
			cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			cancelButton.setBounds(66, 296, 95, 37);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 350, 66);
		contentPanel.add(panel);
		
		JLabel lblUsuariosDaex = new JLabel("Usuarios DAEX\u00A9");
		lblUsuariosDaex.setForeground(Color.WHITE);
		lblUsuariosDaex.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsuariosDaex.setBounds(21, 11, 208, 29);
		panel.add(lblUsuariosDaex);
		
		JLabel lblClose_1 = new JLabel("X");
		lblClose_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblClose_1.setForeground(Color.WHITE);
		lblClose_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblClose_1.setBounds(318, 11, 22, 21);
		panel.add(lblClose_1);
		
		JLabel lblMin_1 = new JLabel("-");
		lblMin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		lblMin_1.setForeground(Color.WHITE);
		lblMin_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMin_1.setBounds(298, 11, 10, 21);
		panel.add(lblMin_1);
		
		JLabel lblNewLabel_3 = new JLabel("Bolsa Laboral");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(143, 41, 136, 14);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(108, 122, 137));
		passwordField.setBounds(152, 148, 147, 20);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(108, 122, 137));
		passwordField_1.setBounds(152, 190, 147, 20);
		contentPanel.add(passwordField_1);
	}
}

