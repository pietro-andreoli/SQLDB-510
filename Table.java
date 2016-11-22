import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Table extends JFrame implements ActionListener {
	GridBagLayout g1;
	GridBagConstraints gbc;
	JPanel panel;
	JTextArea text_area;

	public Table(String display){
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);
		int width = 500;
		int height = 500;
		this.setSize(width, height);
		text_area = new JTextArea(display);
		text_area.setMaximumSize(new Dimension(width, height));
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		g1.setConstraints(text_area, gbc);
		panel.add(text_area);
		
		this.setLocationRelativeTo(null);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
