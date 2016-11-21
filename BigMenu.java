import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BigMenu extends JFrame implements ActionListener {
	JMenuBar mbar;
	JMenu mnu, mnu2;
	JMenuItem insert, update, delete, navigate, viewlist, search;
	String options[] = { "General Employee", "Ticket", "Service Agent", "Assignment Group", "Ticket Date" };
	public BigMenu() {
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

	public void actionPerformed(ActionEvent evt) {
		String str = evt.getActionCommand();
		if (str.equals("Insert")) {
			JOptionPane.showMessageDialog(this, "You Clicked Insert Button");
			Insert1 obj = new Insert1();
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
		if (str.equals("Update")) {
			// JOptionPane.showMessageDialog(this,"You Clicked Update Button");
			
			int chosen = JOptionPane.showOptionDialog(this, "Which table do you want to edit?", "ayylmao",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			Update1 obj = new Update1(chosen);
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
		if (str.equals("Delete")) {
			JOptionPane.showMessageDialog(this, "You Clicked Delete Button");
			Delet obj = new Delet();
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
		if (str.equals("Search")) {
			JOptionPane.showMessageDialog(this, "You Clicked Search Button");
			Search1 obj = new Search1();
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
		if (str.equals("ViewList")) {
			JOptionPane.showMessageDialog(this, "You Clicked ViewList Button");
			viewlist obj = new viewlist();
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
		if (str.equals("Navigate")) {
			JOptionPane.showMessageDialog(this, "You Clicked Naviagate Button");
			recnav obj = new recnav();
			obj.setSize(300, 300);
			obj.setVisible(true);
		}
	}

	public static void main(String[] args) {
		BigMenu obj = new BigMenu();
		obj.setSize(300, 300);
		obj.setVisible(true);
	}
}