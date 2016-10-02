import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class phonebook extends JFrame implements ActionListener
{
JInternalFrame f1;
JDesktopPane pane;
private JTextField ufname,ulname,uadd,ucity,ustate,uzip,uphone,uemail;
JPanel sp,sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8;

    public phonebook()
    {
        CreateGui();
    }

    private void CreateGui()
    {
        setTitle("Phonebook");
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
		uadd = new JTextField(20);
		sp1.add(uadd);
		westPanel.add(sp1);
		
		sp8.add(new JLabel("Address 2  "));			//ADDRESS SEARCH BOX
		uadd = new JTextField(20);
		sp8.add(uadd);
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


		//TOOLBAR   (NON-FUNCTIONING)
		JToolBar tb = new JToolBar();
		JButton button = new JButton("New");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tb.add(button);
		tb.add(new JButton("Save"));
		tb.add(new JButton("Delete"));
		tb.add(new JButton("Search"));
		tb.add(new JButton("Print"));
		

        // Add all!
        f1.getContentPane().add(westPanel, BorderLayout.WEST);
        f1.getContentPane().add(tb, BorderLayout.NORTH);
        pane.add(f1);
        getContentPane().add(pane);



        setSize(500,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
    	
    }

    public static void main(String args[])
    {
        new phonebook();
    }
}