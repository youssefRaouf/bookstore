
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStoreModel {
	
	 private static BookStoreModel instance = null;
	   private BookStoreModel() {
	      // Exists only to defeat instantiation.
	   }

	   public static BookStoreModel getInstance() {
	      if(instance == null) {
	         instance = new BookStoreModel();
	      }
	      return instance;
	   }
	
	
	
	   public Connection connect = null;
	   public Statement statement = null;
 


	public Connection getConnect() {
		return connect;
	}



	private PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;

      final private String host = "localhost";
      final private String user = "root";
      final private String passwd = "";
      final public String database = "mydb";

      public void connectToDB() throws Exception {
              try {
                      // This will load the MySQL driver, each DB has its own driver
                      Class.forName("com.mysql.cj.jdbc.Driver");

                      // Setup the connection with the DB
                     
                      connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","youyou","youyou");
                      
                    /* statement = connect.createStatement();

                      String sql = "INSERT INTO Author " +
                                   "VALUES ( 'Zara')";
                      statement.executeUpdate(sql);
                      System.out.println("Inserted records into the table...");*/

              } catch (Exception e) {
                  System.out.println(e);

                      
              }
              
      }
}
