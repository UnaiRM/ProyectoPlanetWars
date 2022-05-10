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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\BATALLA ESPACIAL.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imagen= new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\menu.png");
		lblNewLabel.setBounds(47, 10, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		lblNewLabel.setIcon(imagen);
		lblNewLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Hello");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(37, 93, 296, 38);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		JButton botonbuild = new JButton("");
		botonbuild.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\BUILD.jpeg"));
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
		botonUpgrade.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\ION.png"));
		botonUpgrade.setBounds(795, 572, 107, 113);
		botonUpgrade.setFocusable(false);
		contentPane.add(botonUpgrade);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\batalla.png"));
		btnNewButton.setBounds(1172, 582, 107, 96);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
	}

}
