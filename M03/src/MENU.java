import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;


public class MENU extends JFrame {

	private JPanel contentPane;
	public  int dimAncho=1536;
	public  int dimAlto=864;
	
	//private boolean flagBuildButton = false, flagBattleButton = false, flagUpgradeButton = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU frame = new MENU(new Planet(), new Timer());
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
	public MENU(Planet planeta, Timer time) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100,dimAncho,dimAlto );
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/menu.png");
		fondo.setBounds(47, 10, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		JLabel Ataque = new JLabel("");
		Ataque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Ataque.setForeground(Color.WHITE);
		Ataque.setBounds(42, 502, 256, 315);
				
		
//		Timer time= new Timer();
//		TimerTask viewThreat= new TimerTask() {
//			
//			public void run() {		
//			System.out.println(Main.ViewThreat());	
//			}
//		};
//		time.schedule(viewThreat, 0,100);
		contentPane.add(Ataque);
		
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		JLabel stats = new JLabel("Hello");
		stats.setFont(new Font("Arial", Font.PLAIN, 17));
		stats.setForeground(Color.WHITE);
		stats.setBounds(37, 93, 296, 263);
		contentPane.add(stats);

		JButton botonbuild = new JButton("");
		botonbuild.setIcon(new ImageIcon("fotos proyecto/BUILD.jpeg"));
		
		botonbuild.setBounds(443, 572, 122, 103);
		botonbuild.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				flagBuildButton = true;
				dispose();
//				setVisible(false);
				DefenseAttack build = new DefenseAttack(planeta, time);
			}
		});
		
		botonbuild.setFocusable(false);
		contentPane.add(botonbuild);
		
		JButton botonUpgrade = new JButton("");
		botonUpgrade.setIcon(new ImageIcon("fotos proyecto/ION.png"));
		botonUpgrade.setBounds(795, 572, 107, 113);
		botonUpgrade.setFocusable(false);
		botonUpgrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("botonUpgrade");
//				flagUpgradeButton = true;
				dispose();
				Upgrade upgrade = new Upgrade(planeta,time);
			}
		});
		
		contentPane.add(botonUpgrade);
		
		JButton batalla = new JButton("");
		batalla.setIcon(new ImageIcon("fotos proyecto/batalla2.png"));
		batalla.setBounds(1172, 582, 107, 96);
		batalla.setFocusable(false);
		batalla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				flagBattleButton = true;
				dispose();
				ReportChoose batalla = new ReportChoose(planeta,time);
			}
		});
		contentPane.add(batalla);
		setVisible(true);
	}
//	public boolean isFlagBuildButton() {
//		return flagBuildButton;
//	}
//	public void setFlagBuildButton(boolean flagBuildButton) {
//		this.flagBuildButton = flagBuildButton;
//	}
//	public boolean isFlagBattleButton() {
//		return flagBattleButton;
//	}
//	public void setFlagBattleButton(boolean flagBattleButton) {
//		this.flagBattleButton = flagBattleButton;
//	}
//	public boolean isFlagUpgradeButton() {
//		return flagUpgradeButton;
//	}
//	public void setFlagUpgradeButton(boolean flagUpgradeButton) {
//		this.flagUpgradeButton = flagUpgradeButton;
//	}
	
	
	
}
