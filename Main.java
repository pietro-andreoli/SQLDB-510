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
        	String[] query_type = {"Basic", "Advanced"};
        	String[] basic = {"Find Open Tickets", "List All Agents", "Find Closed Ticket", "Assigned Tickets", "List General Employees", "An Employee's Assignment Group", "List Ticket 2 Close Date"};
        	String[] advanced = {};
        	int chosen = -1;
        	int query_type_chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "Query Stuff",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, query_type, null);
        	if(query_type_chosen == 0){
        		/*chosen = JOptionPane.showOptionDialog(this, "Which Query Are You Looking To Execute?", "Basic Query Stuff",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, basic, null);*/
        		JComboBox<String> combo = new JComboBox<String>(basic);
        		chosen = JOptionPane.showConfirmDialog(this, combo , "Basic Query Stuff", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        	}else{
        		JComboBox<String> combo = new JComboBox<String>(advanced);
        		chosen = JOptionPane.showConfirmDialog(this, combo , "Advanced Query Stuff", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) + basic.length;
        	}
            if(chosen > -1){
            	search obj = new search(chosen);
            }
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
	      /* "CREATE TABLE ticket " +
	                   "(ticket_num INT PRIMARY KEY     NOT NULL," +
	                   " date_opened           CHAR(30) NOT NULL,"+
	                   " dare_closed           CHAR(30),"+
	                   "assignment_group       CHAR(20) NOT NULL,"+
	                   "status                 CHAR(10) DEFAULT 'Open',"+
	                   "priority               INT      NOT NULL,"+
	                   "opened_for             CHAR(25) NOT NULL)"; */
	      /*"CREATE TABLE service_agent " +
	                   "(employee_num INT PRIMARY KEY     NOT NULL," +
	                   " assignment_group           CHAR(20),"+
	                   " employee_name              CHAR(30) NOT NULL)"*/
	      /*"CREATE TABLE assigned " +
	                   " (ticket_num INT                REFERENCES ticket(ticket_num)           NOT NULL," +
	                   " assignment_group   VARCHAR(20) REFERENCES assignment_group(group_name) NOT NULL,"+
	                   " primary key(ticket_num,assignment_group))"
*/
	      /*  "CREATE TABLE creates " +
	                   " (ticket_num INT       REFERENCES ticket(ticket_num)             NOT NULL," +
	                   " employee_num   INT    REFERENCES general_employee(employee_num) NOT NULL,"+
	                   " primary key(ticket_num,employee_num))"*/
	      /*  "CREATE TABLE part_of " +
	                   " (group_name VARCHAR(20)  REFERENCES assignment_group(group_name)  NOT NULL," +
	                   " employee_num   INT       REFERENCES service_agent(employee_num)   NOT NULL,"+
	                   " primary key(group_name,employee_num))"*/
	    /*  String sql = "CREATE TABLE assigned " +
                  " (ticket_num INT                REFERENCES ticket(ticket_num)           NOT NULL," +
                  " assignment_group   VARCHAR(20) REFERENCES assignment_group(group_name) NOT NULL,"+
                  " primary key(ticket_num,assignment_group))";*/
	     /*String sql = "DROP TABLE ticket";
	     stmt.executeUpdate(sql);
	      sql = "CREATE TABLE ticket " +
          "(ticket_num INT PRIMARY KEY     NOT NULL," +
          " date_opened           VARCHAR(30) NOT NULL,"+
          " date_closed           VARCHAR(30),"+
          "assignment_group       VARCHAR(20) NOT NULL,"+
          "status                 VARCHAR(10) DEFAULT 'Open',"+
          "priority               INT      NOT NULL,"+
          "opened_for             VARCHAR(25) NOT NULL)";
	      stmt.executeUpdate(sql);*/
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
    }
}