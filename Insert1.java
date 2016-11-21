import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Insert1 extends JFrame implements ActionListener {
	JPanel panel;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	// String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public Insert1() {
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

		b1 = new JButton("Insert");
		b1.addActionListener(this);

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

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:java");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String s = evt.getActionCommand();
		if (s.equals("Insert")) {
			try {
				String inscmd = "insert into javasql values(?,?,?,?,?)";
				int eno = Integer.parseInt(t1.getText());
				int bas = Integer.parseInt(t5.getText());
				ps = con.prepareStatement(inscmd);
				ps.setInt(1, eno);
				ps.setString(2, t2.getText());
				ps.setString(3, t3.getText());
				ps.setString(4, t4.getText());
				ps.setInt(5, bas);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Inserted...");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Inset Butt");
				JOptionPane.showMessageDialog(this, ex);
			}
		}
	}

	public static void main(String[] args) {
		viewlist obj = new viewlist();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}
