
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
	public ArrayList<String> ManagerReport_Total_Sales() {
		int sales = 0;
		String sql = "SELECT sum(no_of_copies) as sales FROM Purchases WHERE MONTH( date ) = MONTH( curdate() ) -1 AND (year(date) = year(curdate())) ;";
		ArrayList<String> Tuples = new ArrayList<>();
		
		try {
			ResultSet result = stmt.executeQuery(sql);
		
			while (result.next()) {
				sales = result.getInt("sales");
				String s = "Sales: " + sales ;
				Tuples.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tuples;

		
	}
	public ArrayList<String> ManagerReport_Top5() {
		String sql = "SELECT User_Email , sum(no_of_copies) \n" + 
				"FROM Purchases\n" + 
				"WHERE ( MONTH( date ) >= MONTH( curdate() )-3 ) AND ( MONTH( date ) < MONTH( curdate() ) ) AND (year(date) = year(curdate())) \n" + 
				"GROUP BY User_Email \n" + 
				"ORDER BY sum(no_of_copies) DESC LIMIT 5;";
		ArrayList<String> Tuples = new ArrayList<String>();
		try {
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				int purchaseAmount = result.getInt("sum(no_of_copies)");
				String user = result.getString("User_Email");
				String data = "User: " + user + "  Purchase Amount: " + purchaseAmount;
				Tuples.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tuples;
	}
	public ArrayList<String> ManagerReport_top10_selling() {
		String sql = "SELECT Book_ISBN , sum(no_of_copies) \n" + 
				"FROM Purchases\n" + 
				"WHERE ( MONTH( date ) >= MONTH( curdate() )-3 ) AND ( MONTH( date ) < MONTH( curdate() ) ) AND (year(date) = year(curdate())) \n" + 
				"GROUP BY Book_ISBN\n" + 
				"ORDER BY sum(no_of_copies) DESC LIMIT 10;";
		ArrayList<String> Tuples = new ArrayList<String>();
		try {
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				int no_of_copies = result.getInt("sum(no_of_copies)");
				String Book_ISBN = result.getString("Book_ISBN");
				String data = "Book_ISBN: " + Book_ISBN + "  Copies: " + no_of_copies;
				Tuples.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tuples;
	}
}
