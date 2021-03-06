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
import javax.swing.SwingConstants;
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
	
	private static String threat = "";
	
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
		
		JButton exit = new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(42, 796, 63, 21);
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConnectionBDD.updateArmy(planeta);
                ConnectionBDD.updatePlaneta(planeta);
                System.exit(1);
            }
        });
        
        JLabel newtrath = new JLabel(MENU.threat);
        newtrath.setForeground(Color.WHITE);
        newtrath.setFont(new Font("Tahoma", Font.PLAIN, 15));
        newtrath.setBounds(42, 514, 306, 239);
        newtrath.setHorizontalAlignment(SwingConstants.LEFT);
        newtrath.setVerticalAlignment(SwingConstants.TOP);
        contentPane.add(newtrath);
        
        JLabel stats = new JLabel(planeta.printStats());
        stats.setHorizontalAlignment(SwingConstants.LEFT);
        stats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        stats.setForeground(Color.WHITE);
        stats.setBounds(42, 99, 306, 417);
        stats.setVerticalAlignment(SwingConstants.TOP);
        contentPane.add(stats);
        contentPane.add(exit);
		
		JLabel Ataque = new JLabel("");
		Ataque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Ataque.setForeground(Color.WHITE);
		Ataque.setBounds(42, 502, 256, 315);
				
		
		contentPane.add(Ataque);
		
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		

		JButton botonbuild = new JButton("");
		botonbuild.setIcon(new ImageIcon("fotos proyecto/BUILD.jpeg"));
		
		botonbuild.setBounds(443, 572, 122, 103);
		botonbuild.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
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
				BattleDevelopment development = new BattleDevelopment(Main.getBattleDevelopment());
			}
		});
		contentPane.add(batalla);
		setVisible(true);
	}

	public static String getThreat() {
		return threat;
	}
	public static void setThreat(String threat) {
		MENU.threat = threat;
	}
	
}
