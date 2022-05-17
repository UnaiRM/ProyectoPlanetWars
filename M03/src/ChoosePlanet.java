import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JList;

import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChoosePlanet extends JFrame {

	private JPanel contentPane;
	public  int dimAncho=1536;
	public  int dimAlto=864;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosePlanet frame = new ChoosePlanet("a");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChoosePlanet(String texto) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, dimAncho,dimAlto);
		
		this.setTitle("Choose Planet");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setResizable(false);
		setContentPane(contentPane);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/space.png");
		fondo.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));		
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(65, 796, 85, 21);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		
		JButton eleccion = new JButton("Eleccion");
		eleccion.setBackground(Color.BLACK);
		eleccion.setForeground(Color.WHITE);
		eleccion.setBounds(1040, 750, 96, 24);
		eleccion.setFocusable(false);
		eleccion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ConnectionBDD.setIdPlaneta(Integer.valueOf(textField.getText()));
				System.out.println("ID planeta: "+ConnectionBDD.idPlaneta);
				Planet planeta = ConnectionBDD.loadPlanet();
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
				TimerTask autoBattle = new TimerTask() {
					
					@Override
					public void run() {
						Battle battle = new Battle(Main.getEnemyArmy(),planeta.getArmy());
						battle.startBattle();
						BattleDevelopment developmentAuto = new BattleDevelopment(Main.getBattleDevelopment());
						Main.createEnemyArmy();
					}
				};
				time.schedule(autoBattle, 180000,180000);
				time.schedule(createEnemyArmy, 120000,120000);
				time.schedule(autoIncrease, 60000,60000);
				MENU menu = new MENU(planeta, time);
			}
		});
		contentPane.add(eleccion);
		
		textField = new JTextField();
		textField.setBounds(596, 750, 410, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel labelchoose = new JLabel("");
		labelchoose.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelchoose.setHorizontalAlignment(SwingConstants.CENTER);
		labelchoose.setVerticalAlignment(SwingConstants.TOP);

		labelchoose.setForeground(Color.WHITE);
		labelchoose.setBounds(512, 312, 566, 392);
//		texto = "<html><body>JLabel con <br> varias <br>linea :-) </body></html>";
		labelchoose.setText(texto);
		
		contentPane.add(labelchoose);
		

		contentPane.add(exit);
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		setVisible(true);
		
	}
}
