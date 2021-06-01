import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UserModel {

	protected BookStoreModel bookStore;
	private String email;
	protected HashMap<String,ArrayList<String> > books;


	public UserModel() {
		bookStore = BookStoreModel.getInstance();
		books = new  HashMap<String,ArrayList<String> > ();
		try {
			bookStore.connectToDB();
		} catch (Exception e) {
			
		}
	}
	/*
	 * add new user in the database 
	 */
	
	public HashMap<String,ArrayList<String> > getBooks (){
		return books;
	}
	
	
	public boolean signUp(String userName, String fName,
			String lName, String email,String password, String phoneNumber,
			String shippingAddress,String access,ArrayList<String> ccn,ArrayList<String> expireDate) {
		System.out.println("enterrrrrrrrrr");
		try {
			String query = "insert into " + "User values ("+
           		 userName+", " +fName +" , " +lName + " ,"+
           		 email+", " + password + " , "+phoneNumber + " ," + shippingAddress+" , " + access + " )";
			 System.out.println("signUp: " + query);    
            bookStore.statement = bookStore.connect.createStatement();
            bookStore.statement.executeUpdate(query);
            
            for(int i = 0 ; i < ccn.size() ; i++)
             {
            	 query =  "insert into " + " Credit_card values ( ";
            	 query += ccn.get(i) + " , " + "\'"  + expireDate.get(i)+"\'"+ " , "+ email + " )";
            	 System.out.println(query);
            	 bookStore.statement = bookStore.connect.createStatement();
                 bookStore.statement.executeUpdate(query); 
            	 
            	 System.out.println("c: " + query);
             }
            
                        
         } catch (Exception e ) {
        	e.printStackTrace();
           return false;
        }
  	   return true;
	}
	
	
    /*
     * set current email with the current user 
     * return type of access ( manager or user )
     */
	public String login(String password, String email)  {
		
		try {
			String query = "select * from " + " User where Email = "+
           		   email +" and Password = "+password ;
			System.out.println("login: "+query);
            bookStore.statement = bookStore.connect.createStatement();
            bookStore.resultSet = bookStore.statement.executeQuery(query);
            
            while (bookStore.resultSet.next()) {
          	  
            	 this.email = "'"+bookStore.resultSet.getString("Email")+"'";
            	 System.out.println(bookStore.resultSet.getString("access"));
          	     return bookStore.resultSet.getString("access");
            }
         } catch (Exception e ) {
        	 e.printStackTrace();
        	 return null;
        }
		System.out.println("not found");
  	  return null;
	}
	/*
	 * edit information in profile with the new value
	 * return true if success 
	 */
	public boolean editProfile(ArrayList<String> attribute, ArrayList<String> newValue) {
		
		try {
			
			String query ="update " + " User set ";
			for(int i = 0 ; i < attribute.size();i++)
			{	
					
				query += attribute.get(i)+" = "+newValue.get(i);
				if(i != attribute.size() -1)
					query += " , ";
			}
			query+= " where Email = " +email;
			System.out.println("editProfile:"+ query);
            bookStore.statement = bookStore.connect.createStatement();
             bookStore.statement.executeUpdate(query);
                           
         } catch (SQLException e ) {
        	//e.printStackTrace();
           return false;
        }
  	   return true;
  	   
	}

	/*
	 * store the result of research in HashMap < isbn,arraylist<string>>
	 */
	public void searchForBook(ArrayList<String> attribute, ArrayList<String> value) throws SQLException {
		
		books.clear();
		try{
		String query ="select * from " + " Book where ";
		for(int i = 0 ; i < attribute.size();i++)
		{
			query += attribute.get(i)+" = "+value.get(i)+" ";
		
			if(i != attribute.size() -1)
				query += " and ";
				 	
		}
		System.out.println(query);
		bookStore.statement = bookStore.connect.createStatement();
        bookStore.resultSet = bookStore.statement.executeQuery(query);
                     
        while (bookStore.resultSet.next()) {
      	  ArrayList <String> book = new ArrayList<String>();
      	  String isbn = bookStore.resultSet.getString("ISBN");
      	book.add(bookStore.resultSet.getString("Title"));
      	Integer price = bookStore.resultSet.getInt("Price");
      	book.add(price.toString());
      	book.add(bookStore.resultSet.getString("Category"));
    	Integer quantity = bookStore.resultSet.getInt("Quantity");
      	book.add(quantity.toString());
      	System.out.println(isbn + " "+ price + " "+ quantity);
        books.put(isbn, book);  
        }
        
     } catch (SQLException e ) {
        //throw e;
     }
}

	/*
	 * add isbn,quantity of book in cart
	 */
	public void addBook(ArrayList<ArrayList<String> > book) throws SQLException { // / in shopping cart
        
		try {
			 bookStore.statement = bookStore.connect.createStatement();
             
		for(int i = 0 ; i < book.size();i++)
			{
				String query = "insert into"+ " User_has_inCart values (" +email +" , ";
				ArrayList<String> b = book.get(i);
				query += " "+b.get(0)+" , ";
				query += b.get(1) + ") ";
				System.out.println(" " + query);
				bookStore.statement.executeUpdate(query);
		 }                 
         } catch (SQLException e ) {
          // throw e;
        }
	}

	
	/*
	 * return title of each book in cart and the last element is total price
	 */
	public ArrayList<ArrayList<String >> viewCartItems(){
		ArrayList<ArrayList<String > > items = new ArrayList<ArrayList<String > >(); 
		String query ="select * from "+" User_has_inCart where User_Email = " +
				 email;
		System.out.println(query);
		try{
			bookStore.statement = bookStore.connect.createStatement();
	        bookStore.resultSet = bookStore.statement.executeQuery(query);
	        Integer sum = 0;
	        ArrayList<String>isbn = new ArrayList<String>();
	        while (bookStore.resultSet.next()) {
	        	
	        	isbn.add(bookStore.resultSet.getString("Book_ISBN"));	
	        }
	        for(int i = 0 ; i < isbn.size();i++){
	    		query ="select * from " +" Book where ISBN = " + isbn.get(i);
	    		System.out.println(query);
	    		bookStore.statement = bookStore.connect.createStatement();
	            bookStore.resultSet = bookStore.statement.executeQuery(query);
	            if (bookStore.resultSet.next()){
	            	ArrayList<String >item = new ArrayList<String >();
	            	Integer price = bookStore.resultSet.getInt("Price");
	            	String title = bookStore.resultSet.getString("Title");
	            	item.add(title);
	            	item.add(price.toString());
	            	sum+= price;
	            	items.add(item);
	            }
	        }
	        ArrayList<String >totalPrice = new ArrayList<String >();
	        totalPrice.add("Total Price");
	        totalPrice.add(sum.toString());
	        items.add(totalPrice);
		}catch(Exception e)
		{
			return null;
		}
		
        return items;
	}	

	/* 
	 * use also in logout
	 */
	public void removeCartItem() throws SQLException {
		 bookStore.statement = bookStore.connect.createStatement();
		 String query = "delete from "+ " User_has_inCart where User_Email = "+
		 email ;
		 System.out.println(query);
         bookStore.statement.executeUpdate(query);
	}

	public boolean checkOut(String ccn) throws SQLException  {
		
		 String query = "select * from Credit_card where ccn = " + ccn;
		 bookStore.statement = bookStore.connect.createStatement();
         bookStore.resultSet = bookStore.statement.executeQuery(query);
         if(bookStore.resultSet.next())
         {
        	 Date expireDate = bookStore.resultSet.getDate("Expire_Date");
        	 Date date = new Date();
        	 if(date.compareTo(expireDate) > 0)
        		 {
        		   
        		   return false;
        		 }
         }
         
         bookStore.connect.setAutoCommit(false);
		 Savepoint point = bookStore.connect.setSavepoint();
		 try{
	      query ="select * from "+" User_has_inCart where User_Email = " +
					 email;
			System.out.println(query);
			bookStore.statement = bookStore.connect.createStatement();
	        bookStore.resultSet = bookStore.statement.executeQuery(query);
	        ArrayList<String>isbn = new ArrayList<String>();
	        ArrayList<Integer>quantity = new ArrayList<Integer>();
	        while (bookStore.resultSet.next()) {
	        	isbn.add(bookStore.resultSet.getString("Book_ISBN"));
	        	quantity.add(bookStore.resultSet.getInt("no_of_copies"));
	        }
	        for(int i = 0 ; i < isbn.size();i++){
	    		query ="select * from " +" Book where ISBN = " + isbn.get(i);
	    		System.out.println(query);
	    		bookStore.statement = bookStore.connect.createStatement();
	            bookStore.resultSet = bookStore.statement.executeQuery(query);
	           if (bookStore.resultSet.next()){
	            	Integer remainedCopies = bookStore.resultSet.getInt("Quantity") - quantity.get(i);
	            	query ="update " + " Book set Quantity = " +remainedCopies.toString() + " where ISBN = " + isbn.get(i); 
	            	System.out.println(query);
	            	bookStore.statement = bookStore.connect.createStatement();
		            bookStore.statement.executeUpdate(query);	
	            }
	        }
	        bookStore.connect.commit();
	        bookStore.connect.setAutoCommit(true);
		 }catch(SQLException e)
		 {
			 
			 bookStore.connect.rollback(point);
			 System.out.println("roll back");
			 return false;
		 }
		 removeCartItem();
		 return true;
        
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
