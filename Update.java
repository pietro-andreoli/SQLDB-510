import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener {
	JPanel panel;
	//general employee labels and text fields
	JLabel employee_name_l, employee_num_l;
	JTextField employee_name_t, employee_num_t;
	//ticket labels and text fields
	JLabel ticket_num_l, date_opened_l, date_closed_l, assignment_group_l, status_l, priority_l, opened_for_l;
	JTextField ticket_num_t, date_opened_t, date_closed_t, assignment_group_t, status_t, priority_t, opened_for_t;
	//Assignment group text and labels
	JLabel group_name_l;
	JTextField group_name_t;
	String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;
	int option;
	JButton b1;

	public Update(int options) {
		this.option = options;
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);
		//If General Employee
		
		this.setSize(500, 500);
		ticket_num_l = new JLabel("Ticket No");
		
		date_closed_l = new JLabel("Date Closed");

		ticket_num_t = new JTextField(10);
		
		date_closed_t = new JTextField(10);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		g1.setConstraints(ticket_num_l, gbc);
		panel.add(ticket_num_l);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 1;
		g1.setConstraints(ticket_num_t, gbc);
		panel.add(ticket_num_t);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		g1.setConstraints(date_closed_l, gbc);
		panel.add(date_closed_l);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 3;
		g1.setConstraints(date_closed_t, gbc);
		panel.add(date_closed_t);
		





		this.setLocationRelativeTo(null);
		b1 = new JButton("Update");
		b1.setMnemonic(KeyEvent.VK_ENTER);
		b1.addActionListener(this);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;
		g1.setConstraints(b1, gbc);
		panel.add(b1);

		//JACOB THIS IS WHERE YOU SHOULD TRY TO CONNECT TO THE SERVER I THINK

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String str = evt.getActionCommand();
		//JACOB THIS IS WHERE YOU GET THE INFO FOR THE SQL QUERY
		if (str.equals("Update")) {
			try {
				
				Connection c = null;
			    Statement stmt = null;
			    Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
			      System.out.println("Opened database successfully");

			      stmt = c.createStatement();

			    stmt = c.createStatement();
			    stmt.executeQuery( "UPDATE ticket "
			    		+ "SET date_closed = '"+date_closed_t.getText()+"', status = 'Closed'"
			    				+ "WHERE ticket_num = "+ticket_num_t.getText() );
			      
			    stmt.close();
			      c.close();

			} catch (Exception exs) {
			}
		}
	}

	public static void main(String[] args) {
		Update obj = new Update(3);
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}