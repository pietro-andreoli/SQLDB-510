import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.sql.*;

public class Main extends JFrame implements ActionListener
{
	public static Main obj;
	JMenuBar mbar;
	JMenu mnu, mnu2;
	JMenuItem insert, update, delete, navigate, viewlist, search;
	String options[] = { "General Employee", "Ticket", "Service Agent", "Assignment Group" };

	public Main()
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		mnu = new JMenu("Record Ops");
		mnu2 = new JMenu("Transactions");
		insert = new JMenuItem("Insert");
		update = new JMenuItem("Update");
		delete = new JMenuItem("Delete");
		viewlist = new JMenuItem("ViewList");
		navigate = new JMenuItem("Navigate");
		search = new JMenuItem("Search");

		mnu.add(insert);
		mnu.add(update);
		mnu.add(delete);
		mnu2.add(navigate);
		mnu2.add(viewlist);
		mnu2.add(search);
		mbar.add(mnu);
		mbar.add(mnu2);
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		viewlist.addActionListener(this);
		navigate.addActionListener(this);
		search.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)
	{
		String str = evt.getActionCommand();
		if (str.equals("Insert"))
		{
			JOptionPane.showMessageDialog(this, "You Clicked Insert Button");
			Insert obj = new Insert();
			obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		if (str.equals("Update"))
		{
			// JOptionPane.showMessageDialog(this,"You Clicked Update Button");

			int chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "ayylmao",
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			Update obj = new Update(chosen);
			//obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		if (str.equals("Delete"))
		{
			//JOptionPane.showMessageDialog(this, "You Clicked Delete Button");
			Delete obj = new Delete();
			obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		if (str.equals("Search"))
		{
			JOptionPane.showMessageDialog(this, "You Clicked Search Button");
			search obj = new search();
			obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		if (str.equals("ViewList"))
		{
			JOptionPane.showMessageDialog(this, "You Clicked ViewList Button");
			viewlist obj = new viewlist();
			obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		if (str.equals("Navigate"))
		{
			JOptionPane.showMessageDialog(this, "You Clicked Naviagate Button");
			recnav obj = new recnav();
			obj.setSize(300, 300);
			obj.setVisible(true);

			//Loading the driver class to connect to SQL database
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Creating the Connection object
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","adaci","12113408");
				Statement statement = connection.createStatement();

				//Executing the statement query
				ResultSet results = statement.executeQuery("select * from tickets");

				//Printing out the results of the query
				while(results.next())
					System.out.println(results.getInt(1));

					//Closing the connection
					connection.close();
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args)
	{
		obj = new Main();
		obj.setSize(300, 300);
		obj.setLocationRelativeTo(null);
		obj.setVisible(true);
	}
}
