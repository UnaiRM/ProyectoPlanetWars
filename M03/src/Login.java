

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JPanel panel_6;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	
	private JLabel lblNewLabel_1;
	private JTextField name;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		getContentPane().setLayout(null);
		
		this.setSize(486,448);
		
		JButton login = new JButton("");
		login.setIcon(new ImageIcon("fotos proyecto/BOTON.jpg"));
		login.setBounds(175, 356, 109, 35);
		
		getContentPane().add(login);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = name.getText();
				String contr = passwordField.getText();
				
				boolean val = false;
				int comp = ConnectionBDD.loginProcedure(nombre, contr);
				
				switch (comp) {
				case 0:
					// Usuario incorrecto
					JOptionPane.showMessageDialog(new errorUsuario(), 
			                "Incorrect user or password", "Login incorrect", 
			                JOptionPane.WARNING_MESSAGE);
					break;
					
				case -1:
					// Contraseña incorrecta
					JOptionPane.showMessageDialog(new errorContrasena(), 
			                "Incorrect password", "Login incorrect", 
			                JOptionPane.WARNING_MESSAGE);
					break;
					
				case 1:
					// Login correcto
					val = true;
					break;
				default:
					break;
				}
				if (val) {
					Main.setFlagLogin(true);
					new MENU().main(null); // MIRAR COMO HACER QUE SIGA EL PROGRAMA
				}
				
			}
		});
		passwordField = new JPasswordField();
		passwordField.setBounds(81, 288, 227, 19);
		getContentPane().add(passwordField);
		
		name = new JTextField();
		name.setBounds(81, 192, 227, 19);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("fotos proyecto/login8.jpg"));
		lblNewLabel_3.setBounds(0, 0, 480, 417);
		getContentPane().add(lblNewLabel_3);
		
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
}

class errorUsuario extends JFrame{
	
	errorUsuario(){
		
	}
	
}

class errorContrasena extends JFrame{
	
	errorContrasena(){
		
	}
	
	
}