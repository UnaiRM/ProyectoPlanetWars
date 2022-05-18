import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BattleDevelopment {

	public BattleDevelopment(String battleDevelopment) {
		JFrame frame = new JFrame ("Report Read");
        frame.setSize(486,448);
        JTextArea textArea = new JTextArea ();
        textArea.setBackground(Color.black);
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        textArea.setForeground(Color.white);
        textArea.setText(battleDevelopment);
        JScrollPane scroll = new JScrollPane (textArea, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(scroll);
        frame.setVisible (true);
	}
	
}
