import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Upgrade extends JFrame {

	private JPanel contentPane;
	public  int dimAncho=1536;
	public  int dimAlto=864;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upgrade frame = new Upgrade();
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
	public Upgrade() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, dimAncho,dimAlto);
		
		this.setTitle("UPGRADE");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		this.setResizable(false);
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Documents\\GitHub\\ProyecyoPlanetWars\\M03\\fotos proyecto\\Upgra.png");
		fondo.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		
		
		JLabel attack = new JLabel("2000");
		attack.setHorizontalAlignment(SwingConstants.CENTER);
		attack.setForeground(Color.WHITE);
		attack.setFont(new Font("Tahoma", Font.PLAIN, 39));
		attack.setBounds(878, 542, 156, 63);
		contentPane.add(attack);
		
		JLabel defense = new JLabel("2000");
		defense.setHorizontalAlignment(SwingConstants.CENTER);
		defense.setFont(new Font("Tahoma", Font.PLAIN, 39));
		defense.setForeground(Color.WHITE);
		defense.setBounds(875, 371, 156, 63);
		contentPane.add(defense);
		
		
		
		JLabel actualAttack = new JLabel("0");
		actualAttack.setHorizontalAlignment(SwingConstants.RIGHT);
		actualAttack.setForeground(Color.WHITE);
		actualAttack.setFont(new Font("Tahoma", Font.PLAIN, 27));
		actualAttack.setBounds(779, 133, 45, 55);
		contentPane.add(actualAttack);
		
		JLabel actualDefense = new JLabel("0");
		actualDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		actualDefense.setFont(new Font("Tahoma", Font.PLAIN, 27));
		actualDefense.setForeground(Color.WHITE);
		actualDefense.setBounds(778, 43, 45, 55);
		contentPane.add(actualDefense);
		JButton upgradeD = new JButton("UPGRADE");
		upgradeD.setBackground(new Color(75, 0, 130));
		upgradeD.setForeground(Color.WHITE);
		upgradeD.setBounds(1057, 373, 157, 62);
		upgradeD.setFocusable(false);
		
		upgradeD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(defense.getText());
				int resta=(numEntero*106)/100;
				String numCadena= Integer.toString(resta);
				defense.setText(numCadena);
				
				int numEntero2 = Integer.parseInt(actualDefense.getText());
				int suma=numEntero2+1;
				String numCadena2= Integer.toString(suma);
				actualDefense.setText(numCadena2);
				
			}
		} );
		
		contentPane.add(upgradeD);
		
		JButton upgradeA = new JButton("UPGRADE");
		upgradeA.setForeground(Color.WHITE);
		upgradeA.setBackground(new Color(75, 0, 130));
		upgradeA.setBounds(1057, 549, 157, 62);
		upgradeA.setFocusable(false);
		upgradeA.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(attack.getText());
				int resta=(numEntero*106)/100;
				String numCadena= Integer.toString(resta);
				attack.setText(numCadena);
				
				int numEntero2 = Integer.parseInt(actualAttack.getText());
				int suma=numEntero2+1;
				String numCadena2= Integer.toString(suma);
				actualAttack.setText(numCadena2);
			}
		} );
		contentPane.add(upgradeA);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(31, 796, 85, 21);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MENU().main(null);
				
				
			}
		});
		contentPane.add(exit);
		
		
		
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		
	}
}
