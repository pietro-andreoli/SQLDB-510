import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
    public static Main obj;
    JMenu mnu, mnu2;
    JButton insert, update, delete, navigate, viewlist, search;
    String options[] = { "General Employee", "Ticket", "Service Agent", "Assignment Group" };

    public Main()
    {
        setLayout(new FlowLayout());
        insert = new JButton("Insert");
        add(insert);

        update = new JButton("Update");
        add(update);

        delete = new JButton("Delete");
        add(delete);

        search = new JButton("Search");
        add(search);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        search.addActionListener(this);
    }

    @Override
	public void actionPerformed(ActionEvent evt)
    {
        String str = evt.getActionCommand();
        if (str.equals("Insert"))
        {
            int chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "Update Table",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

            Insert obj = new Insert(chosen);
            obj.setSize(300, 300);
            obj.setVisible(true);

            
        }

        if (str.equals("Update"))
        {

            int chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "Update Table", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            Update obj = new Update(chosen);
            obj.setVisible(true);

            
        }

        if (str.equals("Delete"))
        {
            Delete obj = new Delete();
            obj.setSize(300, 300);
            obj.setVisible(true);

           
        }

        if (str.equals("Search"))
        {
            int chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "Update Table",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            search obj = new search(chosen);
            obj.setSize(300, 300);
            obj.setVisible(true);

           
        }


    }

    public static void main(String[] args)
    {
        obj = new Main();
        obj.setSize(300, 300);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        
        Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:helpdesk.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      
	      /*
	      //BEGINNING OF CREATING TABLES
	      String sql;
	      
	      //Setting CREATE TABLE command for general_employee table
	      sql =   "CREATE TABLE general_employee(" +
	    		  "employee_num INTEGER PRIMARY KEY CHECK(employee_num BETWEEN 10000000 AND 499999999)," +
	    		  "employee_name VARCHAR2(30) NOT NULL)";
	      
	      //Create "general_employee" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TABLE command for ticket table
	      sql =        "CREATE TABLE ticket " +
	                   "(ticket_num INT PRIMARY KEY     NOT NULL," +
	                   " date_opened           CHAR(30) NOT NULL,"+
	                   " dare_closed           CHAR(30),"+
	                   "assignment_group       CHAR(20) NOT NULL,"+
	                   "status                 CHAR(10) DEFAULT 'Open',"+
	                   "priority               INT      NOT NULL,"+
	                   "opened_for             CHAR(25) NOT NULL)"; 
	      
	      //Create "ticket" table
	      stmt.executeUpdate(sql);

	      //Setting CREATE TABLE command for service_agent table
	      sql =        "CREATE TABLE service_agent " +
	                   "(employee_num INT PRIMARY KEY     NOT NULL," +
	                   " assignment_group           CHAR(20),"+
	                   " employee_name              CHAR(30) NOT NULL)";
	      
	      //Create "service_agent" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TABLE command for assignment_group table
	      sql =   "CREATE TABLE assignment_group(" +
	    		  "group_name VARCHAR2(30) PRIMARY KEY)";
	      
	      //Create "assignment_group" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TBALE command for assigned table
	      sql = "CREATE TABLE assigned(" +
	    		"assignment_group  VARCHAR2(20) REFERENCES assignment_group(group_name)," +
	    		"ticket_number     INTEGER REFERENCES  tickets(ticket_num)," +
	    		"PRIMARY KEY(assignment_group, ticket_number)" +
	    		  ")";
	      
	      //Create "assigned" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TABLE command for dependent_of table
	      sql = "CREATE TABLE dependent_of" +
	    		"(employee_number INTEGER," +
	    		"ticket_number INTEGER," +
	    		"PRIMARY KEY(employee_number, ticket_number))";
	      
	      //Create "dependent_of" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TABLE command for services table
	      sql = "CREATE TABLE services" +
	    		"(" +
	    		"employee_number INTEGER REFERENCES general_employee(employee_num)," +
	    		"service_agent_id INTEGER REFERENCES service_agent(employee_num)," +
	    		"PRIMARY KEY(employee_number, service_agent_id)" +  
	    		")";
	     
	      //Create "services" table
	      stmt.executeUpdate(sql);
	      
	      //Setting CREATE TABLE command for part_of table
	      sql = "CREATE TABLE part_of" +
	    		"(" +
	    		"employee_num INTEGER REFERENCES service_agent(employee_num)," +
	    		"group_name VARCHAR2(10) REFERENCES assignment_group(group_name)," +
	    		"PRIMARY KEY(employee_num, group_name)" +
	    	  	")";
	      
	      //Create "part_of" table
	      stmt.executeUpdate(sql);
	      
	      //END OF CREATING TABLES
	      */
	      
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Tables created successfully");
    }
}