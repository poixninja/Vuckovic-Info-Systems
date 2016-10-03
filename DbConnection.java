// Connect to Access Database using JDBC-ODBC Bridge
// Displaying the contents of table S in database S_P_SP.
// Java core packages
import java.sql.*;
import java.util.*;
import javax.swing.JTextField;
public class DbConnection extends phonebook{
	int count = 0;
	//private String fn, ln, a1, a2, c, s, z, p, e;
   // constructor connects to database, queries database,
   // processes results and displays results in window
   public void Connection()
   {
      try {
         // load database driver class
         Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
         // connect to database
         Connection connection = DriverManager.getConnection(
            "jdbc:odbc:address_book" );

        
      }  // end try

      // detect problems interacting with the database
      catch ( SQLException sqlException ) {
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
		            "jdbc:odbc:address_book" );
		   //Statement statement = connection.createStatement();
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
		   
	   }
	   catch ( SQLException sqlException ) {
		   System.out.println(sqlException.getMessage());
	         System.exit( 1 );}
	   catch ( ClassNotFoundException classNotFound ) {
	         System.exit( 1 );}
}
  

}  // end class DbConnection
