import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU frame = new MENU();
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
	public MENU() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100,dimAncho,dimAlto );
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/menu.png");
		fondo.setBounds(47, 10, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		
		
		JLabel stats = new JLabel("Hello");
		stats.setFont(new Font("Arial", Font.PLAIN, 17));
		stats.setForeground(Color.WHITE);
		stats.setBounds(37, 93, 296, 38);
		contentPane.add(stats);
		
		
		
		
		
		
		JButton botonbuild = new JButton("");
		botonbuild.setIcon(new ImageIcon("fotos proyecto/BUILD.jpeg"));
		
		botonbuild.setBounds(443, 572, 122, 103);
		botonbuild.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DefenseAttack().main(null);
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
				new Upgrade().main(null);
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
				
				new ReportChoose().main(null);
				dispose();
			}
		});
		contentPane.add(batalla);
	}

}
