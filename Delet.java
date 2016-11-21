import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener {
	JPanel panel;
	JLabel l1;
	JTextField t1;
	String s;

	ResultSet rs;
	Connection con;
	PreparedStatement ps;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public Delete() {
		gbc = new GridBagConstraints();
		g1 = new GridBagLayout();
		panel = (JPanel) getContentPane();
		panel.setLayout(g1);

		l1 = new JLabel("Employ No");

		t1 = new JTextField(10);

		b1 = new JButton("Delete");
		b1.setMnemonic('D');
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
		if (str.equals("Delete")) {
			try {
				int no = Integer.parseInt(t1.getText());
				ps = con.prepareStatement("delete from javasql where empno=?");
				ps.setInt(1, no);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Deleted");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex);
			}
		}
	}
}
