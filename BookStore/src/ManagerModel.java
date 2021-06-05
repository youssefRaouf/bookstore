
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerModel extends UserModel {

	Statement stmt;
	// Connection connect;

	public ManagerModel() {
		super();
		try {
			stmt = bookStore.connect.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addBook(String catagory, String string, String publicationYear, String publisherName, String string2,
			String string3, String author_id, String title) {
		String query = "insert into Book(Title, Price ,Category , Publication_Year ,Threshold , Quantity ,Publisher_Name,Author_Id) values ("
				+ '"' + title + '"' + "," + string + "," + '"' + catagory + '"' + "," + '"' + publicationYear + '"'
				+ "," + string2 + "," + string3 + "," + '"' + publisherName + '"' + "," + '"' + author_id + '"' + ")";
		try {
			System.out.println(query);
			stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Book inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "book insertion failed with error message: " + e.getMessage());
		}
	}

	public HashMap<String, Integer> getOrders() {
		String sql = "select * from Manager_Order";
		HashMap<String, Integer> map = new HashMap<>();
		try {
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				int noCopies = result.getInt("no_of_copies");
				int orderNumber = result.getInt("OrderID");
				String isbn = result.getString("Book_ISBN");
				String data = "Book Isbn: " + isbn + "  no. of copies: " + noCopies;
				map.put(data, orderNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void modifyBook(ArrayList<Object> attributes, ArrayList<Object> values) {
		String sql = "update Book set ";
		for (int i = 1; i < attributes.size(); i++) {
			sql += attributes.get(i) + " = '";
			if (values.get(i).getClass() == String.class) {
				sql += values.get(i);
			} else
				sql += values.get(i);
			if (i != attributes.size() - 1) {
				sql += "' ,";
			} else {
				sql += "'";
			}
		}
		sql += " where ISBN =" + values.get(0);
		try {
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Book updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "book update failed with error message: " + e.getMessage());
		}

	}

	public boolean placeOrder(int noCopies, String ISBN) {
		String sql = "insert into Manager_Order(no_of_copies ,Book_ISBN) values (" + noCopies + "," + ISBN + ")";
		try {
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "placing order succeeded");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "placing order failed with error message: " + e.getMessage());
		}
		return false;
	}

	public void confirmOrder(int orderNumber) {
		try {
			String deleteOrder = "Delete from Manager_Order where OrderID = " + orderNumber;
			System.out.println(deleteOrder);
			stmt.executeUpdate(deleteOrder);
			JOptionPane.showMessageDialog(null, "order confirm succeeded");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "order confirm failed with error message: " + e.getMessage());
		}
	}

	public void cancelOrder(int orderNumber) {
		String deleteOrder = "Delete from Manager_Order where OrderID = " + orderNumber;
		try {
			stmt.executeUpdate(deleteOrder);
			JOptionPane.showMessageDialog(null, "deleting order succeeded");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "deleting order failed with error message: " + e.getMessage());
		}
	}

	public void promoteUser(String email) {

		String sqlUpdateUser = "update User set access =  " + "\'manager\' " + " where email = " + email;
		System.out.println(sqlUpdateUser);
		try {
			stmt.executeUpdate(sqlUpdateUser);
			JOptionPane.showMessageDialog(null, "user promotion succeeded");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "user promotion failed with error message: " + e.getMessage());
		}

	}
}
