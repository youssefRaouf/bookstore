import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class UserModel {

	protected BookStoreModel bookStore;
	public String email;
	protected HashMap<String, ArrayList<String>> books;

	public UserModel() {
		bookStore = BookStoreModel.getInstance();
		books = new HashMap<String, ArrayList<String>>();
		try {
			bookStore.connectToDB();
		} catch (Exception e) {

		}
	}
	
	/*
	 * add new user in the database
	 */

	public HashMap<String, ArrayList<String>> getBooks() {
		return books;
	}

	public boolean signUp(String userName, String fName, String lName, String email, String password,
			String phoneNumber, String shippingAddress, String access) {
		try {
			String query = "insert into " + "User values (" + userName + ", " + fName + " , " + lName + " ," + email
					+ ", " + password + " , " + phoneNumber + " ," + shippingAddress + " , " + access + " )";
			System.out.println(query);
			bookStore.statement = bookStore.connect.createStatement();
			bookStore.statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * set current email with the current user return type of access ( manager or
	 * user )
	 */
	public String login(String password, String email) {

		try {
			String query = "select * from " + " User where Email = " + email + " and Password = " + password;
			System.out.println(query);
			bookStore.statement = bookStore.connect.createStatement();
			bookStore.resultSet = bookStore.statement.executeQuery(query);

			while (bookStore.resultSet.next()) {

				this.email = "'" + bookStore.resultSet.getString("Email") + "'";
				return bookStore.resultSet.getString("access");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}


	/*
	 * store the result of research in HashMap < isbn,arraylist<string>>
	 */
	public void searchForBook(ArrayList<String> attribute, ArrayList<String> value) throws SQLException {
		books.clear();
		try {
			String query = "select * from " + " Book where ";
			for (int i = 0; i < attribute.size(); i++) {
				query += attribute.get(i) + " = " + value.get(i) + " ";

				if (i != attribute.size() - 1)
					query += " and ";

			}
			System.out.println(query);
			bookStore.statement = bookStore.connect.createStatement();
			bookStore.resultSet = bookStore.statement.executeQuery(query);

			while (bookStore.resultSet.next()) {
				ArrayList<String> book = new ArrayList<String>();
				String isbn = bookStore.resultSet.getString("ISBN");
				book.add(bookStore.resultSet.getString("Title"));
				Integer price = bookStore.resultSet.getInt("Price");
				book.add(price.toString());
				book.add(bookStore.resultSet.getString("Category"));
				Integer quantity = bookStore.resultSet.getInt("Quantity");
				book.add(quantity.toString());
				books.put(isbn, book);
			}

		} catch (SQLException e) {
			// throw e;
		}
	}


	public void checkout(ArrayList<ArrayList<String>> items, String email) {
		for (int i = 0; i < items.size(); i++) {
			LocalDate myObj = LocalDate.now();
			String query = "insert into" + " Purchases values (" + email + " ," + items.get(i).get(4) + " ,"
					+ items.get(i).get(5)+" ,"+"'"+myObj+"'"+")";
			System.out.println(query);
			try {
				bookStore.statement = bookStore.connect.createStatement();
				int l = bookStore.statement.executeUpdate(query);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "book with isbn "+ items.get(i).get(4)+" have no enough copies so you are enable to buy it");
			}
		}
		 JOptionPane.showMessageDialog(null, "books bought successfully we will head you back to main page");
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
