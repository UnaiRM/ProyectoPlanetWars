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

public class ReportChoose extends JFrame {

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
					ReportChoose frame = new ReportChoose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ReportChoose() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotos proyecto/BATALLA ESPACIAL.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, dimAncho,dimAlto);
		
		this.setTitle("Report Choose");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel fondo = new JLabel("");
		ImageIcon imagen= new ImageIcon("fotos proyecto/report2.png");
		fondo.setBounds(0, 0, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		
	
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(65, 796, 85, 21);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				dispose();
				new MENU().main(null);
								
			}
		});
		
		JButton reportRead = new JButton("Report Read");
		reportRead.setForeground(Color.WHITE);
		reportRead.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportRead.setBackground(new Color(75, 0, 130));
		reportRead.setBounds(907, 372, 256, 104);
		reportRead.setFocusable(false);
		reportRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						new ReportRead().main(null);
						dispose();
			}
		});
		
		contentPane.add(reportRead);
		
		JButton reportStats = new JButton("Report Stats");
		reportStats.setForeground(Color.WHITE);
		reportStats.setBackground(Color.BLACK);
		reportStats.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportStats.setBounds(425, 372, 256, 104);
		reportStats.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReportStats().main(null);
				dispose();
			}
		});
		
		reportStats.setFocusable(false);
		
		
		contentPane.add(reportStats);
		contentPane.add(exit);
		fondo.setIcon(imagen);
		fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(fondo);
		
	}
}
