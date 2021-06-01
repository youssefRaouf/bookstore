package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SearchDisplayer {
	private JButton addButton;			
    private JButton modifyButton;
	
	public JButton getAddButton() {
		return addButton;
	}

	public JButton getModifyButton() {
		return modifyButton;
	}


	private ArrayList<ArrayList<String> > isbns = new  ArrayList<ArrayList<String> >();

	public ArrayList<ArrayList<String> > getIsbns() {
		return isbns;
	}


	private JFrame frame;
	private HashMap<String,ArrayList<String> > books;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public SearchDisplayer() {
		//initialize();
        addButton = new JButton("Add to cart");			
        modifyButton = new JButton("modify Book");

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
         frame.setLayout(new BorderLayout());
		
        HashMap<String, String> selectedBooks = new   HashMap<String, String>();
         
		ArrayList<String>lines  = new  ArrayList<String>() ;

		for (HashMap.Entry<String, ArrayList<String>> entry : books.entrySet()) {
			
			System.out.println("hereeeeeeeeeeee");
			String isbn = entry.getKey();
		    ArrayList<String> value = entry.getValue();
		    String[] keys = {"Title", "Price", "Category", "Quantity"};
			
			String text = "";
			text += "ISBN: " + isbn + ",   "; 
			for (int i=0;i<value.size();i++){
				text += keys[i] + ": "  + value.get(i)+",   ";
			}
			selectedBooks.put(text, isbn) ;
			lines.add(text);
		}
		
		 JList list = new JList(lines.toArray());

		 
	        list.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	            	
	                if (!e.getValueIsAdjusting()) {
	                	
	    				String quan = JOptionPane.showInputDialog("Enter Quantity of The Book if you want to buy !");
	    				
	                    final ArrayList<String> selectedValuesList = (ArrayList<String>) list.getSelectedValuesList();
	                    
	                    for (int i=0;i<selectedValuesList.size();i++){
	                    	String key = selectedValuesList.get(i);
	                    	ArrayList <String> entry = new ArrayList<String> ();
	                    	entry.add(selectedBooks.get(key));
	                    	entry.add(quan);
	                    	isbns.add(entry);
	             
	                    }
	                    
	                    System.out.println(selectedValuesList);
	                }
	            }	        });
	 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("JList Example");
	        frame.setSize(600, 600);
	        frame.setLocationRelativeTo(null);
	        
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(1,1,1,1));
	        
	        panel.add(addButton);
	        panel.add(modifyButton);
	   
	        frame.getContentPane().add(new JScrollPane(list),BorderLayout.CENTER);
	        frame.getContentPane().add(panel,BorderLayout.SOUTH);	
	        
	       
	}
	
	
	public void setSearchResults (HashMap<String,ArrayList<String> > books){
		this.books = books;
	}
	public void view (){
		
	     frame.setVisible(true);
	}

	
}
