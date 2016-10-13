import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.sql.*;
class phonebook extends JFrame implements ActionListener
{
DbConnection connect = new DbConnection();
JInternalFrame f1;
JDesktopPane pane;
public JTextField ufname;
public JTextField ulname;
public JTextField uadd1;
public JTextField uadd2;
public JTextField ucity;
public JTextField ustate;
public JTextField uzip;
public JTextField uphone;
public JTextField uemail;
JPanel sp,sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8;
private String event ="", fname="", lname="", add1="", add2="", city="", state="", zip="", phone="", email="";

    public phonebook()
    {
        CreateGui();
    }

   // private void windowResize(ComponentEvent e){
    //	if (e.getSource() == f1){
    	//	f1.setBounds(0, 0, pane.getWidth(), pane.getHeight());
    //	}
   // }

    private void CreateGui()
    {
        setTitle("Phonebook by Team Hats");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane=new JDesktopPane();
        pane.setBackground(Color.GRAY);


        // No title,not resizable,not iconifiable,not maximizable, not closable, no icon
        f1=new JInternalFrame("phonebook");
        JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel,BoxLayout.Y_AXIS));

        // Set sizes
        f1.setSize(443,448);
        // Make all visible
        f1.setVisible(true);
        f1.setLocation(20,20);

        sp = new JPanel();	//SEARCH PANEL
        sp1 = new JPanel(new FlowLayout());
        sp8 = new JPanel(new FlowLayout());
        sp2 = new JPanel(new FlowLayout());
        sp3 = new JPanel(new FlowLayout());
        sp4 = new JPanel(new FlowLayout());
        sp5 = new JPanel(new FlowLayout());
        sp6 = new JPanel(new FlowLayout());
        sp7 = new JPanel(new FlowLayout());
		sp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("First Name");
		sp.add(label);		//NAME SEARCH BOX
		ufname = new JTextField(20);
		sp.add(ufname);
		westPanel.add(sp);

		sp7.add(new JLabel("Last Name"));		//LAST NAME SEARCH BOX
		ulname = new JTextField(20);
		sp7.add(ulname);
		westPanel.add(sp7);

		sp1.add(new JLabel("Address 1  "));			//ADDRESS SEARCH BOX
		uadd1 = new JTextField(20);
		sp1.add(uadd1);
		westPanel.add(sp1);

		sp8.add(new JLabel("Address 2  "));			//ADDRESS SEARCH BOX
		uadd2 = new JTextField(20);
		sp8.add(uadd2);
		westPanel.add(sp8);

		sp2.add(new JLabel("City          "));			//CITY SEARCH BOX
		ucity = new JTextField(20);
		sp2.add(ucity);
		westPanel.add(sp2);

		sp3.add(new JLabel("State         "));			//STATE SEARCH BOX
		ustate = new JTextField(20);
		sp3.add(ustate);
		westPanel.add(sp3);

		sp4.add(new JLabel("Zipcode     "));			//ZIP SEARCH BOX
		uzip = new JTextField(20);
		sp4.add(uzip);
		westPanel.add(sp4);

		sp5.add(new JLabel("Phone       "));			//Phone SEARCH BOX
		uphone = new JTextField(20);
		sp5.add(uphone);
		westPanel.add(sp5);

		sp6.add(new JLabel("Email         "));			//EMAIL SEARCH BOX
		uemail = new JTextField(20);
		sp6.add(uemail);
		westPanel.add(sp6);


		//TOOLBAR   (SEMI-FUNCTIONING)
		JToolBar tb = new JToolBar();
		JButton button = new JButton("New");
		button.addActionListener(this);
		JButton button1 = new JButton("Save");
		button1.addActionListener(this);
		JButton button2 = new JButton("Delete");
		button2.addActionListener(this);
		JButton button3 = new JButton("Search");
		button3.addActionListener(this);
		JButton button4 = new JButton("Print");
		button4.addActionListener(this);
		JButton button5 = new JButton("Update");
		button5.addActionListener(this);
		JButton button6 = new JButton("Clear");
		button6.addActionListener(this);
		tb.add(button);
		tb.add(button1);
		tb.add(button5);
		tb.add(button2);
		tb.add(button3);
		tb.add(button4);
		tb.add(button6);


        // Add all!
        f1.getContentPane().add(westPanel, BorderLayout.WEST);
        f1.getContentPane().add(tb, BorderLayout.NORTH);
        pane.add(f1);
        getContentPane().add(pane);



        setSize(500,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
    	event = e.getActionCommand();

    	if (event == "New") {
    		ufname.setText("");
    		ulname.setText("");
    		uadd1.setText("");
    		uadd2.setText("");
    		ucity.setText("");
    		ustate.setText("");
    		uzip.setText("");
    		uphone.setText("");
    		uemail.setText("");

    		//JFrame msg = new JFrame(); For Pop up message
			//JOptionPane.showMessageDialog(msg, "Insertion Completed");
    	}
    	if (event == "Save") {
    		fname = ufname.getText();
    		lname = ulname.getText();
    		add1 = uadd1.getText();
    		add2 = uadd2.getText();
    		city = ucity.getText();
    		state = ustate.getText();
    		zip = uzip.getText();
    		phone = uphone.getText();
    		email = uemail.getText();
    		connect.Save(fname, lname, add1, add2, city, state, zip, phone, email);

    		JFrame msg = new JFrame(); //For Pop up message
			JOptionPane.showMessageDialog(msg, "Insertion Completed");

    	}
    	if (event == "Update"){
    		fname = ufname.getText();
    		lname = ulname.getText();
    		add1 = uadd1.getText();
    		add2 = uadd2.getText();
    		city = ucity.getText();
    		state = ustate.getText();
    		zip = uzip.getText();
    		phone = uphone.getText();
    		email = uemail.getText();
    	
    		connect.Update(fname, lname, add1, add2, city, state, zip, phone, email);
    		JFrame msg = new JFrame(); //For Pop up message
			JOptionPane.showMessageDialog(msg, "Update Done");
    	}
    	if (event == "Delete") {
			//JFrame msg = new JFrame(); For Pop up message
			//JOptionPane.showMessageDialog(msg, "Record deleted");

    	}
    	if (event == "Search") {
    		

    		connect.Search(ufname, ulname, uadd1, uadd2, ucity, ustate, uzip, uphone, uemail);


    	}
    	if (event == "Print") {

			//JFrame msg = new JFrame(); For Pop up message
			//JOptionPane.showMessageDialog(msg, "Printing");

    	}

    	if (event == "Clear") {
    		ufname.setText("");
    		ulname.setText("");
    		uadd1.setText("");
    		uadd2.setText("");
    		ucity.setText("");
    		ustate.setText("");
    		uzip.setText("");
    		uphone.setText("");
    		uemail.setText("");
    	}

    }

    public void searchField(String dbfname, String dblname, String dbadd1, String dbadd2, String dbcity, String dbstate, String dbzip, String dbphone, String dbemail){
    	ufname.setText(dbfname);
		ulname.setText(dblname);
		uadd1.setText(dbadd1);
		uadd2.setText(dbadd2);
		ucity.setText(dbcity);
		ustate.setText(dbstate);
		uzip.setText(dbzip);
		uphone.setText(dbphone);
		uemail.setText(dbemail);
    }
    public static void main(String args[])
    {
        new phonebook();
    }
}