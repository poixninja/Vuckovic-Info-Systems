// Connect to Access Database using JDBC-ODBC Bridge
// Displaying the contents of table S in database Adress-Book.
// Java core packages
import java.sql.*;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DbConnection {
	
	int count=0, intpid;
	String dbfname, dblname, dbadd1,dbadd2,dbcity,dbstate,dbzip,dbphone,dbemail,pid;

   public void Connection()
   {
      try {
         // load database driver class
         Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
         // connect to database
         Connection connection = DriverManager.getConnection(
            "jdbc:odbc:Address-Book" );
        // PreparedStatement counter = connection.prepareStatement("SELECT MAX(emailID) from emailAddresses");
       //  counter.executeQuery();
        // count = (int) counter.getResultSet().getInt(1);


      }  // end try

      // detect problems interacting with the database
      catch ( SQLException sqlException ) {
    	  System.out.println(sqlException.getMessage());
         System.exit( 1 );
      }
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         System.exit( 1 );
      }
   }

public void Save(String fname, String lname, String add1, String add2, String city, String state, String zip,
		String phone, String email) {
	try {
		   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
		   Connection c = DriverManager.getConnection(
		            "jdbc:odbc:Address-Book" );
		   count++;
		   PreparedStatement stm1 = c.prepareStatement("Insert into names (firstName,lastName) values (?,?)");
		   stm1.setString(1,fname);
		   stm1.setString(2, lname);
		   stm1.executeUpdate();
		   PreparedStatement stm2 = c.prepareStatement("Insert into addresses (addressID,street1,street2,city,state,zipcode) values (?,?,?,?,?,?)");
		   stm2.setInt(1, count);
		   stm2.setString(2, add1);
		   stm2.setString(3, add2);
		   stm2.setString(4, city);
		   stm2.setString(5, state);
		   stm2.setString(6, zip);
		   stm2.executeUpdate();
		   PreparedStatement stm3 = c.prepareStatement("Insert into emailAddresses (emailID,emailAddress) values (?,?)");
		   stm3.setInt(1, count);
		   stm3.setString(2, email);
		   stm3.executeUpdate();
		   PreparedStatement stm4 = c.prepareStatement("Insert into phoneNumbers (phoneID,phoneNumber) values (?,?)");
		   stm4.setInt(1, count);
		   stm4.setString(2, phone);
		   stm4.executeUpdate();

		   	//JFrame msg = new JFrame();
			//JOptionPane.showMessageDialog(msg, "Entry Complete");
			//For Pop-up messages
	   }
	   catch ( SQLException sqlException ) {
		   System.out.println(sqlException.getMessage());
	         System.exit( 1 );}
	   catch ( ClassNotFoundException classNotFound ) {
	         System.exit( 1 );}
}

public void Update(String fname, String lname, String add1, String add2, String city, String state, String zip,
		String phone, String email) {
	//System.out.println(intpid);
try{
	   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
	   Connection c = DriverManager.getConnection(
	            "jdbc:odbc:Address-Book" );
	  // System.out.println("Button works");
	   
	   
	 //  System.out.println(intpid);

	   PreparedStatement update1 = c.prepareStatement("update names set firstName = ?, lastname = ? where personID = ?");
	   update1.setString(1, fname);
	   update1.setString(2, lname);
	   update1.setInt(3, intpid);
	   update1.executeUpdate();
	//   System.out.println("u1 Done");
	   
	   PreparedStatement update2 = c.prepareStatement("update addresses set street1 = ?, street2 = ?, city = ?, state = ?, zipcode = ? where personID = ?");
	       update2.setString(1, add1);
		   update2.setString(2, add2);
		   update2.setString(3, city);
		   update2.setString(4, state);
		   update2.setString(5, zip);
		   update2.setInt(6, intpid);
		   update2.executeUpdate();
		  // System.out.println("u2 Done");
		   
		   PreparedStatement update3 = c.prepareStatement("update emailAddresses set emailAddress = ? where personID = ?"); 
		   update3.setString(1, email);
		   update3.setInt(2,intpid);
		   update3.executeUpdate();
		 //  System.out.println("u3 Done");
		   
		   PreparedStatement update4 = c.prepareStatement("update phoneNumbers set phoneNumber = ? where personID = ?");
		   update4.setString(1, phone);
		   update4.setInt(2, intpid);
		   update4.executeUpdate();
		 //  System.out.println("u4 Done");

}
catch ( SQLException sqlException ) {
	   System.out.println(sqlException.getMessage());
       System.exit( 1 );}
 catch ( ClassNotFoundException classNotFound ) {
       System.exit( 1 );}
}

public void Search(JTextField ufname, JTextField ulname, JTextField uadd1, JTextField uadd2, JTextField ucity, JTextField ustate, JTextField uzip,
		JTextField uphone, JTextField uemail) {
	try{
		String fname, lname, add1, add2, city, state, zip, phone, email;
		
		if (ufname.getText().isEmpty()){
			fname = "*";
		}
		else fname = ufname.getText();

		if (ulname.getText().isEmpty()){
			lname = "*";
		}
		else lname = ulname.getText();

		if (uadd1.getText().isEmpty()){
			add1 = "*";
		}
		else add1 = uadd1.getText();

		if (uadd2.getText().isEmpty()){
			add2 = "*";
		}
		else add2 = uadd2.getText();

		if (ucity.getText().isEmpty()){
			city = "*";
		}
		else city = ucity.getText();

		if (ustate.getText().isEmpty()){
			state = "*";
		}
		else state = ustate.getText();

		if (uzip.getText().isEmpty()){
			zip = "*";
		}
		else zip = uzip.getText();

		if (uphone.getText().isEmpty()){
			phone = "*";
		}
		else phone = uphone.getText();

		if (uemail.getText().isEmpty()){
			email = "*";
		}
		else email = uemail.getText();
		
		   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
		   Connection c = DriverManager.getConnection(
		            "jdbc:odbc:Address-Book" );
		 //  phonebook phonebook = new phonebook();

		   PreparedStatement search = c.prepareStatement("Select names.*, emailAddresses.*, addresses.*, phoneNumbers.* from names inner join "
		   		+ "(addresses inner join "
		   		+ "(phoneNumbers inner join emailAddresses "
		   		+ "on emailAddresses.personID = phoneNumbers.personID)"
		   		+ "on phoneNumbers.personID = addresses.personID)"
		   		+ "on addresses.personID = names.personID "
		   		//+ "where firstName = ? and "
		   		+ "where lastName = ?");
		   		//+ "street2 = ? and "
		   		//+ "city = ? and "
		   		//+ "state = ? and "
		   		//+ "zipcode = ? and "
		   		//+ "emailAddress = ? "
		   		//+ "and phoneNumber = ? ");
		  // search.setString(1 , fname);
		   search.setString(1 , lname);
		  // search.setString(2, add1);
		  // search.setString(4, add2);
		  // search.setString(5, city);
		  // search.setString(6, state);
		  // search.setString(7, zip);
		  // search.setString(8, phone);
		  // search.setString(9, email);
		   ResultSet rs = search.executeQuery();
		 if (rs.next()){
		  	   pid = search.getResultSet().getString(1);
		  	   intpid = Integer.parseInt(pid);
		  	  // System.out.println(pid);
		  	   //System.out.println(intpid);
		  	   }
		 
			   dbfname = search.getResultSet().getString(2);
			   dblname = search.getResultSet().getString(3);
			   dbadd1 = search.getResultSet().getString(9);
			   dbadd2 = search.getResultSet().getString(10);
			   dbcity = search.getResultSet().getString(11);
			   dbstate = search.getResultSet().getString(12);
			   dbzip = search.getResultSet().getString(13);
			   dbphone = search.getResultSet().getString(16);
			   dbemail = search.getResultSet().getString(6);
			   
			   ufname.setText(dbfname);
			   ulname.setText(dblname);
			   uadd1.setText(dbadd1);
			   uadd2.setText(dbadd2);
			   ucity.setText(dbcity);
			   ustate.setText(dbstate);
			   uzip.setText(dbzip);
			   uphone.setText(dbphone);
			   uemail.setText(dbemail);
			   
			   
			  
			  
			   
			  //phonebook.searchField(dbfname, dblname, dbadd1,dbadd2,dbcity,dbstate,dbzip,dbphone,dbemail);
			   
		   
		//   System.out.println(dbfname+dblname+dbadd1+dbadd2+dbcity+dbstate+dbzip+dbphone+dbemail);
		   


	}
	catch ( SQLException sqlException ) {
		   System.out.println(sqlException.getMessage());
	       System.exit( 1 );}
	 catch ( ClassNotFoundException classNotFound ) {
	       System.exit( 1 );}

}

public void Delete() {
	try {
        // load database driver class
        Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
        // connect to database
        Connection c = DriverManager.getConnection(
           "jdbc:odbc:Address-Book" );
      PreparedStatement delete1 = c.prepareStatement("delete from names where personID=?");
      delete1.setInt(1, intpid);
      delete1.executeUpdate();
      
      PreparedStatement delete2 = c.prepareStatement("delete from phoneNumbers where personID=?");
      delete2.setInt(1, intpid);
      delete2.executeUpdate();
      
      PreparedStatement delete3 = c.prepareStatement("delete from addresses where personID=?");
      delete3.setInt(1, intpid);
      delete3.executeUpdate();
      
      PreparedStatement delete4 = c.prepareStatement("delete from emailAddresses where personID=?");
      delete4.setInt(1, intpid);
      delete4.executeUpdate();


     }  // end try

     // detect problems interacting with the database
     catch ( SQLException sqlException ) {
   	  System.out.println(sqlException.getMessage());
        System.exit( 1 );
     }
     // detect problems loading database driver
     catch ( ClassNotFoundException classNotFound ) {
        System.exit( 1 );
     }
}


}  // end class DbConnection
