import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class viewlist extends JFrame {
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JPanel panel;
	GridBagLayout g1;
	GridBagConstraints gbc;
	Connection con = null;
	String s;
	Statement st = null;
	ResultSet rs = null;

	public viewlist() {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		l1 = new JLabel("Employ Number");
		l2 = new JLabel("Employ Name ");
		l3 = new JLabel("Department");
		l4 = new JLabel("Designation");
		l5 = new JLabel("Basic");

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);

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
		gbc.gridy = 17;
		g1.setConstraints(l5, gbc);
		panel.add(l5);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 17;
		g1.setConstraints(t5, gbc);
		panel.add(t5);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:java");
			st = con.createStatement();
			rs = st.executeQuery("select * from javasql");
			rs.next();
			t1.setText(rs.getString("Empno"));
			t2.setText(rs.getString("nam"));
			t3.setText(rs.getString("dept"));
			t4.setText(rs.getString("desig"));
			t5.setText(rs.getString("basic"));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex);
		}
	}

	public static void main(String[] args) {
		viewlist obj = new viewlist();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}