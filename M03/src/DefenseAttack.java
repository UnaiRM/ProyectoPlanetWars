import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;

public class DefenseAttack extends JFrame {

	private JPanel contentPane;
	public  int dimAncho=1536;
	public  int dimAlto=864;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefenseAttack frame = new DefenseAttack(new Planet(), new Timer());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DefenseAttack(Planet planeta, Timer time) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100,  dimAncho, dimAlto);
		
		
		this.setTitle("Defense Attack");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/space.png");
		fondo.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		JButton defense = new JButton("DEFENSE");
		defense.setForeground(Color.WHITE);
		defense.setBackground(Color.RED);
		defense.setFocusable(false);
		defense.setBounds(914, 355, 327, 62);
		defense.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				BuildDefense buildDefense = new BuildDefense(planeta,time);
			}
		});
		
		
		contentPane.add(defense);
		
		JButton attack = new JButton("Attack");
		attack.setBackground(Color.BLACK);
		attack.setForeground(Color.WHITE);
		attack.setFocusable(false);
		attack.setBounds(415, 355, 327, 62);
		attack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				BuildAttack buildAttack = new BuildAttack(planeta,time);
			}
		});
		contentPane.add(attack);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(43, 796, 85, 21);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ConnectionBDD.updatePlaneta(planeta);
				ConnectionBDD.updateArmy(planeta);
				MENU menu = new MENU(planeta, time);
			}
		});

		contentPane.add(exit);
		fondo.setIcon(new ImageIcon("fotos proyecto/space.png"));
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		setVisible(true);
		
	}

}
