import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.*;
public class Delete extends JFrame implements ActionListener {
	JPanel panel;
	JLabel general_employee_l, tickets_l, service_agent_l, assignment_group_l;
	JCheckBox general_employee_c, tickets_c, service_agent_c, assignment_group_c, del_all_c;
	String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public Delete() {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		//general_employee_l = new JLabel("General Employee");
		general_employee_c = new JCheckBox("General Employee");
		
		tickets_c = new JCheckBox("Tickets");
		service_agent_c = new JCheckBox("Service Agent");
		assignment_group_c = new JCheckBox("Assignment Group");
		del_all_c = new JCheckBox("Delete All Tables");
		//t1 = new JTextField(10);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		g1.setConstraints(general_employee_c, gbc);
		panel.add(general_employee_c);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 2;
		g1.setConstraints(tickets_c, gbc);
		panel.add(tickets_c);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		g1.setConstraints(service_agent_c, gbc);
		panel.add(service_agent_c);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 4;
		g1.setConstraints(assignment_group_c, gbc);
		panel.add(assignment_group_c);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 5;
		g1.setConstraints(del_all_c, gbc);
		panel.add(del_all_c);
		
		b1 = new JButton("Delete");
		b1.setMnemonic(KeyEvent.VK_ENTER);
		b1.addActionListener(this);
		
		

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;
		g1.setConstraints(b1, gbc);
		panel.add(b1);
		this.setLocationRelativeTo(null);
	
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String str = evt.getActionCommand();
		
		if (str.equals("Delete")) {
			 
		}
	}
}
