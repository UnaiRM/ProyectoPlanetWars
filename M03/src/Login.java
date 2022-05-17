

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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
	
//	private static boolean flagButton = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ConnectionBDD con = new ConnectionBDD();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					
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
		this.setTitle("Login");
		JButton login = new JButton("");
		login.setIcon(new ImageIcon("fotos proyecto/BOTON.jpg"));
		login.setBounds(175, 356, 109, 35);
		this.setResizable(false);
		
		getContentPane().add(login);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idUsuarioPlanetas[] = ConnectionBDD.loginProcedure(name.getText(), passwordField.getText()); 
				int idUsuario = Integer.valueOf(idUsuarioPlanetas[0]);
				String idPlanetas = idUsuarioPlanetas[1];
				if (idUsuario < 1) {
					// POPUP DE ERROR
					JOptionPane.showMessageDialog(new JFrame(), "Login incorrecto", "Error login",
					        JOptionPane.ERROR_MESSAGE);
				} else {
					ConnectionBDD.setIdUsuario(idUsuario);
					Planet planeta;
					
					if (idPlanetas.charAt(0) == '0') {
//						Main.setFlagNoTienePlanetas(true);
						// Se crea un nuevo planeta
						planeta = new Planet();
												
						// Se le busca una id nueva y se establece para todo el programa
						ConnectionBDD.idPlaneta = ConnectionBDD.idNewPlanet();
						// Se inserta el nuevo planeta
						ConnectionBDD.insertarPlaneta(planeta);
						dispose();
						System.out.println("ID planeta: "+ConnectionBDD.idPlaneta);
						Timer time= new Timer();
						TimerTask autoIncrease= new TimerTask() {
							
							public void run() {		
							planeta.setDeuterium(planeta.getDeuterium()+Variables.PLANET_DEUTERIUM_GENERATED);
							planeta.setMetal(planeta.getMetal()+Variables.PLANET_METAL_GENERATED);
							ConnectionBDD.updatePlaneta(planeta);
							}
						};
						Main.createEnemyArmy();
						TimerTask createEnemyArmy = new TimerTask() {
							
							@Override
							public void run() {
								MENU.setThreat(Main.ViewThreat());							
							}
						};
						time.schedule(createEnemyArmy, 120000,120000);
						time.schedule(autoIncrease, 0,60000);
						MENU menu = new MENU(planeta, time);
					} else {
//						Main.setFlagTienePlanetas(true);
						// CAMBIAR A LA INTERFAZ PARA ELEGIR
						dispose();
						ChoosePlanet choose = new ChoosePlanet(ConnectionBDD.infoPlanets(idPlanetas));
						
					}
					
//					flagButton = true;
					
					
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
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("fotos proyecto/login8.jpg"));
		fondo.setBounds(0, 0, 480, 417);
		getContentPane().add(fondo);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		

	}

//	public static boolean isFlagButton() {
//		return flagButton;
//	}
//
//	public static void setFlagButton(boolean flagButton) {
//		Login.flagButton = flagButton;
//	}
	
	
}