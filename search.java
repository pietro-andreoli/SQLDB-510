import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class search extends JFrame implements ActionListener {
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
	int option;
	ResultSet rs;
	Connection con;
	Statement st;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public search(int option) {
		this.option = option;
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

		b1 = new JButton("Search");

		b1.setMnemonic(KeyEvent.VK_ENTER);

		
		this.setLocationRelativeTo(null);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;
		g1.setConstraints(b1, gbc);
		panel.add(b1);

		b1.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String s = evt.getActionCommand();
		
		if (s.equals("Search")) 
		{
			    //Simple Query 1
				if(this.option == 0)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT ticket_num FROM tickets WHERE status='Open';" );
					      
					    String output = "";
					    
					    while (rs.next()) 
					    {
					    	int ticket_num = rs.getInt("ticket_num");
					    	String date_opened = rs.getString("date_opened");
					    	String date_closed = rs.getString("date_closed");
					    	String assignment_group = rs.getString("assignment_group");
					    	String status = rs.getString("status");
					    	int priority = rs.getInt("priority");
					    	String opened_for = rs.getString("opened_for");
					    	
					    	output += ticket_num + " | " + date_opened + " | " + date_closed + " | " 
					    	+ assignment_group + " | " + status + " | " + priority + " | " + opened_for + "\n";
					    	
					    	/*
					    	System.out.println("Ticket Number = " + ticket_num);
					    	System.out.println("Date Opened = " + date_opened);
					    	System.out.println("Date Closed = " + date_closed);
					    	System.out.println("Assignment Group = " + assignment_group);
					    	System.out.println("Status = " + status);
					    	System.out.println("Priority = " + priority);
					    	System.out.println("Opened For: " + opened_for);
					    	*/
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
					
				}
				//Simple Query 2
				else if(this.option == 1)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT employee_name, 'is a member of', assignment_group FROM service_agent;" );
					      	
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	output += rs + " | \n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 3
				else if(this.option == 2)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT assignment_group FROM tickets WHERE status = 'Closed' ORDER BY assignment_group DESC;" );
					      	
					    System.out.println("The following groups have completed tickets:");
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	output += rs + " | \n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 4
				else if(this.option == 3)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT assignment_group, 'is responsible for completing ticket ', ticket_num FROM tickets WHERE priority = '1';" );
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {
					    	output += rs + " | \n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 5
				else if(this.option == 4)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT * FROM general_employee;" );
					      	
					    System.out.println("The following workers are all general employees\n");
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	int employee_num = rs.getInt("employee_num");
					    	String employee_name = rs.getString("employee_name");
					    	
					    	output += employee_num + " | " + employee_name + "\n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 6
				else if(this.option == 5)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT assignment_group FROM service_agent WHERE employee_num = '50000003';" );
					      	
					    System.out.println("The employee with the number 500000003 is in the following assignment group");
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	int employee_num = rs.getInt("employee_num");
					    	String employee_name = rs.getString("employee_name");
					    	String assignment_group = rs.getString("assignment_group");
					    	
					    	output += employee_num + " | " + employee_name + " | " + assignment_group + "\n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 7
				else if(this.option == 6)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT employee_name FROM service_agent WHERE assignment_group = 'Hardware Repair';" );
					      	
					    System.out.println("The following employees are in the Hardware Repair assignment group");
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	String employee_name = rs.getString("employee_name");

					    	output += employee_name + "\n";
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
				//Simple Query 8
				else if(this.option == 7)
				{
					try 
					{
						Connection c = null;
					    Statement stmt = null;
					    Class.forName("org.sqlite.JDBC");
					    c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
					    c.setAutoCommit(false);
					    System.out.println("Opened database successfully");

					    stmt = c.createStatement();
					    ResultSet rs = stmt.executeQuery( "SELECT date_closed FROM tickets WHERE ticket_num = 2;" );
					      	
					    System.out.println("Ticket 2 was closed on the following date:");
					    
					    String output = "";
					    
					    while (rs.next()) 
					    {  
					    	String date_closed = rs.getString("date_closed");

					    	output += date_closed + "\n";
					    	
					    }
					    
					    Table display_table = new Table(output);
					    display_table.setVisible(true);
					    
					    rs.close();
					    stmt.close();
					    c.close();
					} 
					catch ( Exception e ) 
					{
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					    System.exit(0);
					}
				}
			} 
		}
	

	public static void main(String[] args) {
	}
}