import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class recnav extends JFrame implements ActionListener {
	JPanel panel;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	String s;

	ResultSet rs;
	Connection con;
	Statement st;

	JButton b1, b2, b3, b4;
	GridBagLayout g1;
	GridBagConstraints gbc;

	public recnav() {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		l1 = new JLabel("Employ No");
		l2 = new JLabel("Name ");
		l3 = new JLabel("Department");
		l4 = new JLabel("Designation");
		l5 = new JLabel("Basic ");

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);

		/*
		 * String[] dept= {"Computers","Physics","Maths"}; c1=new
		 * JComboBox(dept);
		 */

		b1 = new JButton("First");
		b1.setMnemonic('F');

		b2 = new JButton("Next");
		b2.setMnemonic('N');

		b3 = new JButton("Last");
		b3.setMnemonic('L');

		b4 = new JButton("Previous");
		b4.setMnemonic('P');

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 5;
		g1.setConstraints(l1, gbc);
		panel.add(l1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 5;
		g1.setConstraints(t1, gbc);
		panel.add(t1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 8;
		g1.setConstraints(l2, gbc);
		panel.add(l2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 8;
		g1.setConstraints(t2, gbc);
		panel.add(t2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 11;
		g1.setConstraints(l3, gbc);
		panel.add(l3);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 11;
		g1.setConstraints(t3, gbc);
		panel.add(t3);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 14;
		g1.setConstraints(l4, gbc);
		panel.add(l4);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 14;
		g1.setConstraints(t4, gbc);
		panel.add(t4);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 18;
		g1.setConstraints(l5, gbc);
		panel.add(l5);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 18;
		g1.setConstraints(t5, gbc);
		panel.add(t5);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 23;
		g1.setConstraints(b1, gbc);
		panel.add(b1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 10;
		gbc.gridy = 23;
		g1.setConstraints(b2, gbc);
		panel.add(b2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 16;
		gbc.gridy = 23;
		g1.setConstraints(b3, gbc);
		panel.add(b3);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 23;
		gbc.gridy = 23;
		g1.setConstraints(b4, gbc);
		panel.add(b4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// establishing the connectino to the database
			con = DriverManager.getConnection("jdbc:odbc:java");
			s = "select * from javasql";
			// creating select statement used in forward-only direction.
			//
			// the below statement allows you to navigate the data in any
			// direction.
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// storing the records of table in resultset
			rs = st.executeQuery(s);
			rs.next();
			t1.setText(rs.getString("empno"));
			t2.setText(rs.getString("nam"));
			t3.setText(rs.getString("dept"));
			t4.setText(rs.getString("desig"));
			t5.setText(rs.getString("basic"));
		} catch (Exception ex) {
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String s1 = evt.getActionCommand();
		if (s1.equals("First")) {
			try {
				rs.first();
				t1.setText(rs.getString("empno"));
				t2.setText(rs.getString("nam"));
				t3.setText(rs.getString("dept"));
				t4.setText(rs.getString("desig"));
				t5.setText(rs.getString("basic"));
			} catch (Exception ex1) {

			}
		}
		if (s1.equals("Next")) {
			try {
				rs.next();
				t1.setText(rs.getString("empno"));
				t2.setText(rs.getString("nam"));
				t3.setText(rs.getString("dept"));
				t4.setText(rs.getString("desig"));
				t5.setText(rs.getString("basic"));
			} catch (Exception ex2) {

			}
		}
		if (s1.equals("Last")) {
			try {
				rs.last();
				t1.setText(rs.getString("empno"));
				t2.setText(rs.getString("nam"));
				t3.setText(rs.getString("dept"));
				t4.setText(rs.getString("desig"));
				t5.setText(rs.getString("basic"));
			} catch (Exception ex3) {

			}
		}
		if (s1.equals("Previous")) {
			try {
				rs.previous();
				t1.setText(rs.getString("empno"));
				t2.setText(rs.getString("nam"));
				t3.setText(rs.getString("dept"));
				t4.setText(rs.getString("desig"));
				t5.setText(rs.getString("basic"));
			} catch (Exception ex4) {

			}
		}

	}

	public static void main(String[] args) {
		recnav obj = new recnav();
		obj.setSize(300, 300);
		obj.setVisible(true);

	}
}