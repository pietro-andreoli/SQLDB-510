import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class search extends JFrame implements ActionListener {
	JPanel panel;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	String s;

	ResultSet rs;
	Connection con;
	Statement st;

	GridBagLayout g1;
	GridBagConstraints gbc;

	JButton b1;

	public search() {
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

		b1 = new JButton("Search");
		b1.setMnemonic('S');

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

		b1.addActionListener(this);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:java", "sa", "prasanna");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery("select * from emp");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String s = evt.getActionCommand();
		String tt1 = t1.getText();
		boolean flag = false;
		int n = Integer.parseInt(tt1);
		if (s.equals("Search")) {
			try {
				rs.first();
				do {
					int p = Integer.parseInt(rs.getString("empno"));
					if (n == p) {
						t2.setText(rs.getString("nam"));
						t3.setText(rs.getString("dept"));
						t4.setText(rs.getString("desig"));
						t5.setText(rs.getString("basic"));
						flag = true;
					}
				} while (rs.next());
				if (flag == false)
					JOptionPane.showMessageDialog(this, new String("Record Not Found"));
			} catch (Exception eee) {
				JOptionPane.showMessageDialog(this, eee);
			}

		}
	}

	public static void main(String[] args) {
		search obj = new search();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}