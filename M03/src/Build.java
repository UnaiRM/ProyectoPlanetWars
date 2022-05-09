import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Color;

public class Build extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Build frame = new Build();
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
	public Build() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imagen= new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\tropas.png");
		lblNewLabel.setBounds(10, 10, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		JSpinner spinnerbattleship = new JSpinner();
		spinnerbattleship.setBounds(385, 369, 42, 37);
		System.out.println(spinnerbattleship.getValue());
		
		JSpinner spinnerligthhunter = new JSpinner();
		spinnerligthhunter.setBounds(948, 369, 42, 37);
		contentPane.add(spinnerligthhunter);
		
		JSpinner spinnerarmoredship = new JSpinner();
		spinnerarmoredship.setBounds(678, 369, 42, 37);
		contentPane.add(spinnerarmoredship);
		
		contentPane.add(spinnerbattleship);
		lblNewLabel.setIcon(imagen);
		lblNewLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblNewLabel);
		
	}
}
