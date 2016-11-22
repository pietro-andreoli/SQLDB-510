import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}