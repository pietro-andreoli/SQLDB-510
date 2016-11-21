import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update1 extends JFrame implements ActionListener {
	JPanel panel;
	JLabel l1, l2, l3;
	JTextField t1, t2, t3;
	String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public Update1() {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		l1 = new JLabel("Employ No");
		l2 = new JLabel("Designation ");
		l3 = new JLabel("Basic");

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);

		b1 = new JButton("Update");
		b1.setMnemonic('U');
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
		String str = evt.getActionCommand();
		if (str.equals("Update")) {
			try {
				String updcmd = "update javasql set desig=?,basic=? where empno=?";
				ps = con.prepareStatement(updcmd);
				ps.setString(1, t2.getText());
				ps.setInt(2, Integer.parseInt(t3.getText()));
				ps.setInt(3, Integer.parseInt(t1.getText()));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Updated...");
			} catch (Exception exs) {
				JOptionPane.showMessageDialog(this, exs);
			}
		}
	}

	public static void main(String[] args) {
		Update1 obj = new Update1();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}