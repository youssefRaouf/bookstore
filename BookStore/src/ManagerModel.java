
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerModel extends UserModel {

	Statement stmt;
	//Connection connect;

	public ManagerModel() {
		super();
		try {
			//bookModel.connectToDB();
			//connect = bookModel.getConnect();
			
			stmt = bookStore.connect.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<String> credit = new ArrayList<String>();
				credit.add("124");
				credit.add("125");
				ArrayList<String> expire = new ArrayList<String>();
				expire.add("'1995-12-05'");
				expire.add("'2017-12-06'");
				/*try {
					signUp(" 'user' "," 'rana' ", " 'fayez' ", "'eng.roka97@hotmail.com'", " '123456' ", 
							" '3090366' ", " '35 address' "," 'user' ",credit,expire);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				 
	}


	
	public boolean addBook(String catagory, String ISBN, int price,
			String publicationYear, String publisherName, int threshold,
			int quantity, ArrayList<String> authors, String title) { // / in
																		// system
																		// =
																		// table
																		// book

		boolean inserted = false;
		String sqlBook = "insert into Book values (" + ISBN + "," + title
				+ "," + price + "," + catagory

				+ "," + publicationYear + "," + threshold + ","
				+ quantity + "," + publisherName + ")";

		String sqlAuthor = "insert into Author values (";
		String sqlHas = "insert into Book_has_Author values (";
		for (int i = 0; i < authors.size(); i++) {
			// insert authors
			try {
				String temp = sqlAuthor + authors.get(i) + ")";
				System.out.println(temp + "  ll");
				stmt.executeUpdate(sqlAuthor + "\'" + authors.get(i) + "\'"
						+ ")");

			} catch (SQLException e) {

				e.printStackTrace();
				return false;
			}
			// insert book tuple
			try {
				if (!inserted) {
					System.out.println(sqlBook);
					stmt.executeUpdate(sqlBook);
					inserted = true;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			// insert intermediate table for author and book isbn
			try {
				stmt.executeUpdate(sqlHas + "" + ISBN + ",\'"
						+ authors.get(i) + "\')");
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}

		return true;

	}

	public HashMap<String, Integer> getOrders()
	{
		String sql = "select * from Manager_Order";
		HashMap<String, Integer> map = new  HashMap<>();
				
		try {
			System.out.println("queryyyyyyyy " + sql);
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				int noCopies = result.getInt("no_of_copies");
				int orderNumber = result.getInt("OrderID");
				String isbn = result.getString("Book_ISBN");
				String data = orderNumber + ":" + noCopies + ":" + isbn;
				map.put(data, orderNumber);			
				System.out.println(orderNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	public boolean addPublisher(String name, String address, String phone) {

		String sql = "insert into Publisher values (" + name + ","
				+ address + "," + phone + ")";
		try {
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean modifyBook(ArrayList<Object> attributes,
			ArrayList<Object> values) {
		//HashMap<String, ArrayList<String>> books = null; // that's hash map
		Set<String> booksISBN = books.keySet();
		String sql = "update Book set ";

		for (int i = 0; i < attributes.size(); i++) {
			sql += attributes.get(i) + " = ";
			if (values.get(i).getClass() == String.class) {
				sql +=   values.get(i);
			} else
				sql += values.get(i);
			if (i != attributes.size() - 1)
				sql += " ,";

		}
		sql += " where ";
		Iterator<String> iterator = booksISBN.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			String setElement = iterator.next();
			sql += "ISBN = " + setElement;
			if (count != booksISBN.size()) {
				sql += " or ";
			}
		}
		return true;

	}

	public boolean placeOrder(int noCopies, String ISBN) {
		String sql = "insert into Manager_Order(no_of_copies ,Book_ISBN,confirm) values ("
				+ noCopies + "," + ISBN + " ," + false + ")";
		try {
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean confirmOrder(int orderNumber) {
		String sql = "select * from Manager_Order where OrderID = "
				+ orderNumber;
		try {

			ResultSet resultSet = stmt.executeQuery(sql);

			if (resultSet.next()) {
				System.out.println("*****************");

				int noCopies = resultSet.getInt("no_of_copies");
				System.out.println("copies " + noCopies);

				String ISBN = resultSet.getString("Book_ISBN");
				System.out.println("ISBN : " + ISBN);

				String sqlUpdateBook = "update Book  set Quantity =  "
						+ "Quantity +  " + noCopies + " where ISBN = \'" + ISBN
						+ "\'";
				System.out.println(sqlUpdateBook);
				stmt.executeUpdate(sqlUpdateBook);
				String deleteOrder = "Delete from Manager_Order where OrderID = "
						+ orderNumber;
				stmt.executeUpdate(deleteOrder);
			}
			resultSet.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("catchh   ");
			e.printStackTrace();
		}

		return true;
	}
    public boolean cancelOrder(int orderNumber)
    {
    	String deleteOrder = "Delete from Manager_Order where OrderID = "
				+ orderNumber;
		try {
			stmt.executeUpdate(deleteOrder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	return true;
    }
    
	public boolean promoteUser (String email){
		
		
		String sqlUpdateUser = "update User set access =  "
				+ "\' manager \' "  + " where email = " + email;
		System.out.println(sqlUpdateUser);
		try {
			stmt.executeUpdate(sqlUpdateUser);
			return true ;
		} catch (SQLException e) {
			e.printStackTrace();
			return false ;
		}
		
	}
}
