import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Insert extends JFrame implements ActionListener {
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
	// String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;
	int option;
	JButton b1;

	public Insert(int option) {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		if(option == 0){
			this.setSize(500, 500);
			employee_name_l = new JLabel("Employ No");
			employee_num_l = new JLabel("Employee Name");
			employee_name_t = new JTextField(10);
			employee_num_t = new JTextField(10);



			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 8;
			g1.setConstraints(employee_num_l, gbc);
			panel.add(employee_num_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 5;
			g1.setConstraints(employee_name_l, gbc);
			panel.add(employee_name_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 5;
			g1.setConstraints(employee_name_t, gbc);
			panel.add(employee_name_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 8;
			g1.setConstraints(employee_num_t, gbc);
			panel.add(employee_num_t);


		//If ticket
		}else if(option == 1){
			this.setSize(500, 500);
			ticket_num_l = new JLabel("Ticket No");
			date_opened_l = new JLabel("Date Opened");
			date_closed_l = new JLabel("Date Closed");
			assignment_group_l = new JLabel("Assignment Group");
			status_l = new JLabel("Status");
			priority_l = new JLabel("Priority");
			opened_for_l = new JLabel("Opened For");

			ticket_num_t = new JTextField(10);
			date_opened_t = new JTextField(10);
			date_closed_t = new JTextField(10);
			assignment_group_t = new JTextField(10);
			status_t = new JTextField(10);
			priority_t = new JTextField(10);
			opened_for_t = new JTextField(10);

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
			gbc.gridy = 2;
			g1.setConstraints(date_opened_l, gbc);
			panel.add(date_opened_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 2;
			g1.setConstraints(date_opened_t, gbc);
			panel.add(date_opened_t);

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

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 4;
			g1.setConstraints(assignment_group_l, gbc);
			panel.add(assignment_group_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 4;
			g1.setConstraints(assignment_group_t, gbc);
			panel.add(assignment_group_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 5;
			g1.setConstraints(status_l, gbc);
			panel.add(status_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 5;
			g1.setConstraints(status_t, gbc);
			panel.add(status_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 6;
			g1.setConstraints(priority_l, gbc);
			panel.add(priority_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 6;
			g1.setConstraints(priority_t, gbc);
			panel.add(priority_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 7;
			g1.setConstraints(opened_for_l, gbc);
			panel.add(opened_for_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 7;
			g1.setConstraints(opened_for_t, gbc);
			panel.add(opened_for_t);
		}else if(option == 2){
			this.setSize(500, 500);
			employee_name_l = new JLabel("Employ No");
			employee_num_l = new JLabel("Employee Name");
			assignment_group_l = new JLabel ("Assignment Group");

			employee_name_t = new JTextField(10);
			employee_num_t = new JTextField(10);
			assignment_group_t = new JTextField(10);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 1;
			g1.setConstraints(employee_name_l, gbc);
			panel.add(employee_name_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 1;
			g1.setConstraints(employee_name_t, gbc);
			panel.add(employee_name_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 2;
			g1.setConstraints(employee_num_l, gbc);
			panel.add(employee_num_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 2;
			g1.setConstraints(employee_num_t, gbc);
			panel.add(employee_num_t);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 3;
			g1.setConstraints(assignment_group_l, gbc);
			panel.add(assignment_group_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 3;
			g1.setConstraints(assignment_group_t, gbc);
			panel.add(assignment_group_t);
		}else if(option == 3){
			this.setSize(300, 300);
			group_name_l = new JLabel ("Group Name");

			group_name_t = new JTextField(10);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 3;
			g1.setConstraints(group_name_l, gbc);
			panel.add(group_name_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 3;
			g1.setConstraints(group_name_t, gbc);
			panel.add(group_name_t);
		}

		this.setLocationRelativeTo(null);
		b1 = new JButton("Update");
		b1.setMnemonic(KeyEvent.VK_ENTER);
		b1.addActionListener(this);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;
		g1.setConstraints(b1, gbc);
		panel.add(b1);

		this.pack();
       		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String s = evt.getActionCommand();
		if (s.equals("Insert")) {
			try {
				if(this.option == 0){
				}else if(this.option == 1){
				}else if(this.option == 2){
				}else if(this.option == 3){
				}
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String[] args) {
		viewlist obj = new viewlist();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}
