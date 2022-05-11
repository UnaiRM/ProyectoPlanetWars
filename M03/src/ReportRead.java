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
import javax.swing.JTextField;
import javax.swing.JList;

import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ReportRead extends JFrame {

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
					ReportRead frame = new ReportRead();
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
	public ReportRead() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, dimAncho,dimAlto);
		
		this.setTitle("Report Read");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/report.png");
		fondo.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		
	
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(65, 796, 85, 21);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReportChoose().main(null);
				
				
			}
		});
		contentPane.add(exit);
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		
	}
}
