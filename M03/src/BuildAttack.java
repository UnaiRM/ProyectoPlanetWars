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

public class BuildAttack extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildAttack frame = new BuildAttack();
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
	public BuildAttack() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\BATALLA ESPACIAL.jpg"));
		
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
		ImageIcon imagen= new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\tropas.png");
		lblNewLabel.setBounds(75, -16, 1920, 1080);
		imagen=new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
		
		JButton CONSTRUIR = new JButton("BUILD");
		CONSTRUIR.setFocusable(false);
		CONSTRUIR.setForeground(Color.WHITE);
		CONSTRUIR.setBackground(Color.BLACK);
		CONSTRUIR.setBounds(683, 702, 159, 73);
		contentPane.add(CONSTRUIR);
		
		JLabel contador_2_1 = new JLabel("0");
		contador_2_1.setForeground(Color.WHITE);
		contador_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contador_2_1.setBackground(Color.BLACK);
		contador_2_1.setBounds(1007, 578, 45, 27);
		contentPane.add(contador_2_1);
		
		JLabel contador_2 = new JLabel("0");
		contador_2.setForeground(Color.WHITE);
		contador_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contador_2.setBackground(Color.BLACK);
		contador_2.setBounds(734, 578, 45, 27);
		contentPane.add(contador_2);
		
		JLabel contador_1 = new JLabel("0");
		contador_1.setForeground(Color.WHITE);
		contador_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contador_1.setBackground(Color.BLACK);
		contador_1.setBounds(477, 576, 45, 27);
		contentPane.add(contador_1);
		
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\negro.jpg"));
		lblNewLabel_5_1_1_1.setBounds(966, 578, 60, 33);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\negro.jpg"));
		lblNewLabel_5_1_1.setBounds(694, 578, 60, 33);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\negro.jpg"));
		lblNewLabel_5_1.setBounds(436, 576, 60, 33);
		contentPane.add(lblNewLabel_5_1);
		
		JButton restar_3 = new JButton("");
		restar_3.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\menos.png"));
		restar_3.setBounds(1062, 583, 27, 21);
		restar_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(contador_2_1.getText());
				int resta=numEntero-1;
				String numCadena= Integer.toString(resta);
				if (resta>0) {
					contador_2_1.setText(numCadena);
				}
				else {
					contador_2_1.setText("0");
				}
				
			}
		});

		contentPane.add(restar_3);
		
		JButton sumar_3 = new JButton("");
		sumar_3.setBounds(1100, 583, 27, 21);
		sumar_3.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\mas.png"));
		sumar_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int numEntero = Integer.parseInt(contador_2_1.getText());
				
				String numCadena= Integer.toString(numEntero+1);
				
				contador_2_1.setText(numCadena);
				
			}
		});
		
		
		contentPane.add(sumar_3);
		
		JButton sumar_2 = new JButton("");
		sumar_2.setBounds(834, 583, 27, 21);
		sumar_2.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\mas.png"));
		sumar_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int numEntero = Integer.parseInt(contador_2.getText());
				
				String numCadena= Integer.toString(numEntero+1);
				
				contador_2.setText(numCadena);
				
			}
		});
		
		
		contentPane.add(sumar_2);
		
		JButton restar_2 = new JButton("");
		restar_2.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\menos.png"));
		restar_2.setBounds(792, 583, 27, 21);
		restar_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(contador_2.getText());
				int resta=numEntero-1;
				String numCadena= Integer.toString(resta);
				if (resta>0) {
					contador_2.setText(numCadena);
				}
				else {
					contador_2.setText("0");
				}
				
			}
		});
		
		
		
		contentPane.add(restar_2);
		
		JButton restar_1 = new JButton("");
		restar_1.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\menos.png"));
		restar_1.setBounds(531, 583, 27, 21);
		restar_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(contador_1.getText());
				int resta=numEntero-1;
				String numCadena= Integer.toString(resta);
				if (resta>0) {
					contador_1.setText(numCadena);
				}
				else {
					contador_1.setText("0");
				}
				
			}
		});
		contentPane.add(restar_1);
		
		
		JButton sumar_1 = new JButton("");
		sumar_1.setBounds(568, 583, 27, 21);
		sumar_1.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\mas.png"));
		sumar_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int numEntero = Integer.parseInt(contador_1.getText());
				
				String numCadena= Integer.toString(numEntero+1);
				
				contador_1.setText(numCadena);
				
			}
		});

		contentPane.add(sumar_1);
		JLabel contador = new JLabel("0");
		contador.setBackground(Color.BLACK);
		contador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contador.setForeground(Color.WHITE);
		contador.setBounds(212, 578, 45, 27);
		contentPane.add(contador);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\negro.jpg"));
		lblNewLabel_5.setBounds(173, 578, 60, 33);
		contentPane.add(lblNewLabel_5);
		
		JButton restar = new JButton("");
		restar.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\menos.png"));
		restar.setBounds(267, 583, 27, 21);
		contentPane.add(restar);
		restar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numEntero = Integer.parseInt(contador.getText());
				int resta=numEntero-1;
				String numCadena= Integer.toString(resta);
				if (resta>0) {
					contador.setText(numCadena);
				}
				else {
					contador.setText("0");
				}
				
			}
		});
		
		JButton sumar = new JButton("");
		sumar.setIcon(new ImageIcon("C:\\Users\\isidoro\\OneDrive\\Escritorio\\fotos proyecto\\mas.png"));
		sumar.setBounds(308, 583, 27, 21);
		sumar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int numEntero = Integer.parseInt(contador.getText());
				
				String numCadena= Integer.toString(numEntero+1);
				
				contador.setText(numCadena);
				
			}
		});
		contentPane.add(sumar);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(65, 796, 85, 21);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		lblNewLabel.setIcon(imagen);
		lblNewLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblNewLabel);
		
	}
}
