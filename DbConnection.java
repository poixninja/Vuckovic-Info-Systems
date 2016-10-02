// Connect to Access Database using JDBC-ODBC Bridge
// Displaying the contents of table S in database S_P_SP.
// Java core packages
import java.sql.*;
import java.util.*;

import javax.swing.JTextField;
public class DbConnection extends phonebook{
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
   public void Save(JTextField ufname) {
	   try {
		   Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
		   Connection connection = DriverManager.getConnection(
		            "jdbc:odbc:address_book" );
		   Statement statement = connection.createStatement();
		   statement.executeQuery("select * names");
		   
	   }
	   catch ( SQLException sqlException ) {
	         System.exit( 1 );}
	   catch ( ClassNotFoundException classNotFound ) {
	         System.exit( 1 );}

   }
  

}  // end class DbConnection
