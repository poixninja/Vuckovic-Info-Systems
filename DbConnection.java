// Connect to Access Database using JDBC-ODBC Bridge
// Displaying the contents of table S in database Adress-Book.
// Java core packages
import java.sql.*;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DbConnection extends phonebook{
	int count=0, pid;

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
try{
	   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
	   Connection c = DriverManager.getConnection(
	            "jdbc:odbc:Address-Book" );

	   PreparedStatement update = c.prepareStatement("");

}
catch ( SQLException sqlException ) {
	   System.out.println(sqlException.getMessage());
       System.exit( 1 );}
 catch ( ClassNotFoundException classNotFound ) {
       System.exit( 1 );}
}

public void Search(String fname, String lname, String add1, String add2, String city, String state, String zip,
		String phone, String email) {
	try{
		   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
		   Connection c = DriverManager.getConnection(
		            "jdbc:odbc:Address-Book" );

		   PreparedStatement search = c.prepareStatement("Select names.personID from names inner join "
		   		+ "(addresses inner join "
		   		+ "(phoneNumbers inner join emailAddresses "
		   		+ "on emailAddresses.personID = phoneNumbers.personID)"
		   		+ "on phoneNumbers.personID = addresses.personID)"
		   		+ "on addresses.personID = names.personID "
		   		+ "where firstName = ? and "
		   		+ "lastName = ? and "
		   		+ "street1 = ? and "
		   		+ "street2 = ? and "
		   		+ "city = ? and "
		   		+ "state = ? and "
		   		+ "zipcode = ? and "
		   		+ "emailAddress = ? "
		   		+ "and phoneNumber = ? "
		   		+ "group by personID");
		   search.setString(1 , fname);
		   search.setString(2 , lname);
		   search.setString(3, add1);
		   search.setString(4, add2);
		   search.setString(5, city);
		   search.setString(6, state);
		   search.setString(7, zip);
		   search.setString(8, phone);
		   search.setString(9, email);
		   search.executeQuery();
		   pid = search.getResultSet().getInt(1);
		   System.out.println(pid);


	}
	catch ( SQLException sqlException ) {
		   System.out.println(sqlException.getMessage());
	       System.exit( 1 );}
	 catch ( ClassNotFoundException classNotFound ) {
	       System.exit( 1 );}

}


}  // end class DbConnection
