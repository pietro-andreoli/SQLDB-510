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
	JLabel group_name_l, open_ticket_l, group_member_l;
	JTextField group_name_t, open_ticket_t, group_member_t;
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
		this.option = option;
		if(option == 0){
			this.setSize(500, 500);
			employee_name_l = new JLabel("Employee Name");
			employee_num_l = new JLabel("Employee No");
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
			employee_name_l = new JLabel("Employ Name");
			employee_num_l = new JLabel("Employee No");
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
			open_ticket_l = new JLabel ("Open Ticket");
			group_member_l = new JLabel ("Group Member");
			group_name_t = new JTextField(10);
			open_ticket_t = new JTextField(10);
			group_member_t = new JTextField(10);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 1;
			g1.setConstraints(group_name_l, gbc);
			panel.add(group_name_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 1;
			g1.setConstraints(group_name_t, gbc);
			panel.add(group_name_t);
			
			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 2;
			g1.setConstraints(open_ticket_l, gbc);
			panel.add(open_ticket_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 2;
			g1.setConstraints(open_ticket_t, gbc);
			panel.add(open_ticket_t);
			
			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 3;
			g1.setConstraints(group_member_l, gbc);
			panel.add(group_member_l);

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 3;
			g1.setConstraints(group_member_t, gbc);
			panel.add(group_member_t);
		}

		this.setLocationRelativeTo(null);
		b1 = new JButton("Insert");
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
			System.out.println("hello world!");
			Connection c = null;
		    Statement stmt = null;
		    PreparedStatement ps = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
		      c.setAutoCommit(false);
		      
		      System.out.println("Opened database successfully");
		      String sql = "";
		      try {
					
					if(this.option == 0){
						
						stmt = c.createStatement();
					      sql = "INSERT INTO general_employee (employee_num";
					      if(employee_num_t.getText().equals(""))throw new IllegalArgumentException("Employee Number Cant be Empty");
					      if(!employee_name_t.getText().equals("")) sql+=", employee_name";
					      sql+=") VALUES ("+employee_num_t.getText();
					      if(!employee_name_t.getText().equals("")) sql+=", '"+employee_name_t.getText()+"'";
					      sql+=");";
					      System.out.println(sql);
					      stmt.executeUpdate(sql);
					}else if(this.option == 1){
						stmt = c.createStatement();
					    sql = "INSERT INTO ticket (";
					    if(!ticket_num_t.getText().equals("")) sql+="ticket_num";
					    else throw new IllegalArgumentException("Ticket Number Cant Be Empty");
					    if(!date_opened_t.getText().equals("")) sql+=", date_opened";
					    if(!date_closed_t.getText().equals("")) sql+=", date_closed";
					    if(!assignment_group_t.getText().equals("")) sql+=", assignment_group";
					    if(!status_t.getText().equals("")) sql+=", status";
					    if(!priority_t.getText().equals("")) sql+=", priority";
					    if(!opened_for_t.getText().equals("")) sql+=", opened_for";
					    sql+=" ) ";
					    sql += "VALUES (";
					    if(!ticket_num_t.getText().equals("")) sql+= ""+ticket_num_t.getText();
					    if(!date_opened_t.getText().equals("")) sql+=", '" +date_opened_t.getText()+"'";
					    if(!date_closed_t.getText().equals("")) sql+=", '"+date_closed_t.getText()+"'";
					    if(!assignment_group_t.getText().equals("")) sql+=", '"+assignment_group_t.getText()+"'";
					    if(!status_t.getText().equals("")) sql+=", '"+status_t.getText()+"'";
					    if(!priority_t.getText().equals("")) sql+=", "+priority_t.getText();
					    if(!opened_for_t.getText().equals("")) sql+=", '"+opened_for_t.getText()+"'";
					    sql+=");";
					    System.out.println(sql);
					    stmt.executeUpdate(sql);
					    System.out.println("Insert Successful");

					}else if(this.option == 2){
						stmt = c.createStatement();
					      sql = "INSERT INTO service_agent (employee_num, employee_name";
					      if(employee_num_t.getText().equals(""))throw new IllegalArgumentException("Employee Number Cant be Empty");
					      if(employee_name_t.getText().equals(""))throw new IllegalArgumentException("Employee Name Cant be Empty");
					      if(!assignment_group_t.getText().equals("")) sql+=", assignment_group";
					      sql+=") VALUES ("+employee_num_t.getText()+", '"+employee_name_t.getText()+"'";
					      if(!assignment_group_t.getText().equals("")) sql+=", '"+assignment_group_t.getText()+"'";
					      sql+=");";
					      System.out.println(sql);
					      stmt.executeUpdate(sql);
						
					}else if(this.option == 3){
						stmt = c.createStatement();
					    sql = "INSERT INTO assignment_group (name";
					    if(group_name_t.getText().equals(""))throw new IllegalArgumentException("Assignment Group Cant be Empty");
					    if(!open_ticket_t.getText().equals("")) sql+=", open_ticket";
					    if(!group_member_t.getText().equals("")) sql+=", group_member";
					    sql+=") VALUES ("+"'"+group_name_t.getText()+"'";
					    if(!open_ticket_t.getText().equals("")) sql+=", "+open_ticket_t.getText();
					    if(!group_member_t.getText().equals("")) sql+=", '"+group_member_t.getText()+"'";
					    sql+=");";
					    System.out.println(sql);
					    stmt.executeUpdate(sql);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, ex);
				}
		/*      stmt = c.createStatement();
		      String sql = "INSERT INTO general_employee (employee_num,employee_name) " +
		                   "VALUES (10000001, 'Ajani Goldmane');"; 
		      stmt.executeUpdate(sql);
		      System.out.println("Added ajani");
		      sql = "INSERT INTO general_employee (employee_num,employee_name) " +
		            "VALUES (10000002, 'Dack Fayden');"; 
		      stmt.executeUpdate(sql);
		      System.out.println("2");
		      sql = "INSERT INTO general_employee (employee_num,employee_name) " +
		            "VALUES (10000003, 'Domri Rade');"; 
		    //  stmt.executeUpdate(sql);*/
		     /* if(!sql.equals("")){
		    	  stmt.executeUpdate(sql);
		    	  System.out.println("Insert Successful");
		      }*/

		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		    	JOptionPane.showMessageDialog(this, e.getMessage());
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() + ", " + e);
		      //System.exit(0);
		    }
		    //System.out.println("Records created successfully");
			
		}
	}

	public static void main(String[] args) {
		
	}
}