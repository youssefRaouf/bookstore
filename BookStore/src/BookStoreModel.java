
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStoreModel {

	private static BookStoreModel instance = null;

	private BookStoreModel() {
		// Exists only to defeat instantiation.
	}

	public static BookStoreModel getInstance() {
		if (instance == null) {
			instance = new BookStoreModel();
		}
		return instance;
	}

	public Connection connect = null;
	public Statement statement = null;

	public Connection getConnect() {
		return connect;
	}

	public ResultSet resultSet = null;

	final private String host = "127.0.0.1";
	final private String user = "youyou";
	final private String password = "youyou";
	final public String database = "mydb";

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB

			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, password);

		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
