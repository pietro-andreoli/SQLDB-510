import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class search extends JFrame implements ActionListener 
{
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

	public search(int option){
		this.option = option;
		
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
			    ResultSet rs = stmt.executeQuery( "SELECT ticket_num, date_opened, date_closed, assignment_group, status, priority, opened_for FROM ticket WHERE status='Open';" );
			      
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
			    	String employee_name = rs.getString("employee_name");
			    	String assignment_group = rs.getString("assignment_group");
			    	
			    	output += employee_name + " | " + assignment_group + "\n";
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
			    ResultSet rs = stmt.executeQuery( "SELECT assignment_group FROM ticket WHERE status = 'Closed' ORDER BY assignment_group DESC;" );
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {  
			    	String assignment_group = rs.getString("assignment_group");
			    	
			    	output += assignment_group + "\n";
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
			    ResultSet rs = stmt.executeQuery( "SELECT assignment_group, 'is responsible for completing ticket ', ticket_num FROM ticket WHERE priority = '1';" );
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {
			    	String assignment_group = rs.getString("assignment_group");
			    	int ticket_num = rs.getInt("ticket_num");
			    	
			    	output += "Ticket " + ticket_num + " is assigned to: " + assignment_group + "\n";
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
			    ResultSet rs = stmt.executeQuery( "SELECT assignment_group, employee_name, employee_num FROM service_agent WHERE employee_num = '50000003';" );
			      	
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
			    ResultSet rs = stmt.executeQuery( "SELECT date_closed FROM ticket WHERE ticket_num = 1;" );
			      	
			    System.out.println("Ticket 1 was closed on the following date:");
			    
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
		//Advanced Query 1
		else if(this.option == 8)
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
			    ResultSet rs = stmt.executeQuery( "SELECT t.ticket_num, t.status, t.assignment_group "
                        + "                            FROM ticket t "
                        + "                            WHERE EXISTS ("
                        + "                            SELECT t1.ticket_num, t2.ticket_num "
                        + "                            FROM ticket t1, ticket t2 "
                        + "                            WHERE t1.assignment_group = 'Hardware Repair' "
                        + "                            AND t2.assignment_group = 'Software Requests' "
                        + "                            AND t2.opened_for = 'Ajani Goldmane' "
                        + "                            AND t1.opened_for = 'Ajani Goldmane' "
                        + "                            AND t1.status = 'Open' "
                        + "                            AND t2.status = 'Open' "
                        + "                            AND (t.ticket_num = t1.ticket_num"
                        + "                            OR t.ticket_num = t2.ticket_num));" );
			      	
			    System.out.println("The following tickets are currently open for Ajani Goldmane in the Hardware Repair or Software Requests groups:");
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {  
			    	int ticket_num = rs.getInt("ticket_num");
			    	String status = rs.getString("status");
			    	String assignment_group = rs.getString("assignment_group");
			    	
			    	output += ticket_num + " | " + status + " | " + assignment_group + "\n";
			    
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
		//Advanced Query 2
		else if(this.option == 9)
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
			    ResultSet rs = stmt.executeQuery( "SELECT * "
			    		+ "							FROM ticket "
			    		+ "							EXCEPT "
			    		+ "							SELECT * "
			    		+ "							FROM ticket  "
			    		+ "							WHERE assignment_group = 'Software Requests' "
			    		+ "							;" );
			      	
			    System.out.println("The following are all the tickets except for the ones assigned to the Software Requests group");
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {  
			    	int ticket_num = rs.getInt("ticket_num");
			    	String assignment_group = rs.getString("assignment_group");
			    	
			    	output += ticket_num + " | " + assignment_group + "\n";
			    	
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
		//Advanced Query 3
		else if(this.option == 10)
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
			    ResultSet rs = stmt.executeQuery( "SELECT * "
			    		+ "							FROM ticket t "
			    		+ "							WHERE t.opened_for = 'Saheeli Rai' "
			    		+ "							EXCEPT "
			    		+ "							SELECT t1.* "
			    		+ "							FROM ticket t1 "
			    		+ "							WHERE assignment_group = 'Laptop Service' "
			    		+ "							OR t1.opened_for != 'Saheeli Rai' ;" );
			      	
			    System.out.println("The following tickets were opened for Service Agent Saheeli Rai in a group other than her own");
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {  
			    	int ticket_num = rs.getInt("ticket_num");
			    	String assignment_group = rs.getString("assignment_group");
			    	String opened_for = rs.getString("opened_for");
			    	
			    	output += ticket_num + " | " + opened_for + " | " + assignment_group + "\n";
			    	
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
		//Advanced Query 4
		else if(this.option == 11)
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

			    ResultSet rs = stmt.executeQuery( "	   SELECT employee_num, employee_name, assignment_group  "
                        + "                            FROM  service_agent"
                        + "                            WHERE  assignment_group = 'Software Requests' "

                        
                        + "                            UNION"
                        
                        + "                            SELECT employee_num, employee_name, assignment_group  "
                        + "                            FROM  service_agent"
                        + "                            WHERE  assignment_group = 'Hardware Repair' "
                        						);
                        
			      	
			    System.out.println("The following are all the service agents in the Software Requests and Hardware Repair groups");
			    
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
		//Advanced Query 5
		else if(this.option == 12)
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
			    ResultSet rs = stmt.executeQuery( "SELECT name "
			    		+ "							FROM assignment_group "
			    		+ "							WHERE name "
			    		+ "							LIKE 'Hardware%';" );
			      	
			    System.out.println("The following are all of the hardware-based assignment groups:");
			    
			    String output = "";
			    
			    while (rs.next()) 
			    {  
			    	String assignment_group = rs.getString("name");
			    	
			    	output += assignment_group + "\n";
			    	
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
		
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String s = evt.getActionCommand();
		
		if (s.equals("Search")) 
		{
			    
			} 
		}
	

	public static void main(String[] args) {
	}
}
