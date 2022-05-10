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
import javax.swing.JButton;
import java.awt.Color;

public class DefenseAttack extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefenseAttack frame = new DefenseAttack();
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
	public DefenseAttack() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		
		
		this.setTitle("ATTACK");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/space.png");
		lblNewLabel.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		JButton defense = new JButton("DEFENSE");
		defense.setForeground(Color.WHITE);
		defense.setBackground(Color.RED);
		defense.setFocusable(false);
		defense.setBounds(914, 355, 327, 62);
		defense.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuildDefense().main(null);
				dispose();
			}
		});
		
		
		contentPane.add(defense);
		
		JButton attack = new JButton("ATTACK");
		attack.setBackground(Color.BLACK);
		attack.setForeground(Color.WHITE);
		attack.setFocusable(false);
		attack.setBounds(415, 355, 327, 62);
		attack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuildAttack().main(null);
				dispose();
				
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
				new MENU().main(null);
				dispose();
				
			}
		});
		
		
		contentPane.add(exit);
		lblNewLabel.setIcon(new ImageIcon("fotos proyecto/space.png"));
		lblNewLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblNewLabel);
		
		
	}
}
