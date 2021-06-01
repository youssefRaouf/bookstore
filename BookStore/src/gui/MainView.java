package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

public class MainView {

	private JFrame frame;
	
	private JButton btnGo ;
	private JButton btnManager ;
	private JButton cart ;
	private JButton logout;
	

	private JTextField txtISBN;
	
	private JTextField textPrice;
	private JTextField textCatagory;
	private JTextField textTitle;
	private JTextField textPublisher;
	private JTextField textYear;
	private JTextField TextQuantity;
	
	
	private JCheckBox isbnCheckBox ;
	private JCheckBox titlecheckBox ;
	private JCheckBox chckbxCatagory ;
	private JCheckBox chckbxPrice  ;
	private JCheckBox chckbxPublicationYear ;
	private JCheckBox chckbxQuantity ;
	private JCheckBox chckbxPublisherName  ;
	private String access = "";
	//================================text field getter ==================================
	
	public String  getISBN() {
		if (txtISBN.getText() != null)
		return "\'"+txtISBN.getText() + "\'";
		else
			return null ;
	}
	public String getPrice() {
		if (textPrice.getText() != null)
		return "\'" +textPrice.getText()+"\'";
		else
			return null ;
	}
	public String  getCatagory() {
		if (textCatagory.getText() != null)
		return "\'"+textCatagory.getText()+"\'";
		else
			return null ;
	}
	public String getQuantity() {
		if (TextQuantity.getText() != null)
		return  "\'"+textPrice.getText()+"\'" ;
		else
			return null ;
	}
	public String  getTitle() {
		if (textTitle.getText() != null)
		return "\'"+textTitle.getText()+"\'";
		else
			return null ;
	}
	
	public String  getPublisher() {
		if (textPublisher.getText() != null)
		return "\'" +textPublisher.getText()+"\'";
		else
			return null ;
	}
	public String  getYear() {
		if (textYear.getText() != null)
		return "\'"+textYear.getText()+"\'";
		else
			return null ;
	}
	
	//================================Button getter ==================================

	public JButton getBtnLogout() {
		return logout;
	}
	
	public JButton getBtnGo() {
		return btnGo;
	}



	public JButton getBtnManager() {
		return btnManager;
	}
	

	public JButton getCart() {
		return cart;
	}
	
	//================================Check box getter ==================================

	
	public JCheckBox getIsbnCheckBox() {
		return isbnCheckBox;
	}

	

	public JCheckBox getChckbxCatagory() {
		return chckbxCatagory;
	}



	public JCheckBox getChckbxPrice() {
		return chckbxPrice;
	}

	

	public JCheckBox getChckbxPublicationYear() {
		return chckbxPublicationYear;
	}

	

	public JCheckBox getChckbxQuantity() {
		return chckbxQuantity;
	}

	
	public JCheckBox getChckbxPublisherName() {
		return chckbxPublisherName;
	}
	public JCheckBox getChckbxTitle() {
		return titlecheckBox;
	}

	public MainView() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void view() {
		frame.setVisible(true);
	}

	public void setAccess (String access){
		this.access = access;
		 if (access.equals("manager")){
			 	frame.getContentPane().add(btnManager);
			 }
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton edit = new JButton("editProfile");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		edit.setBounds(270, 12, 108, 25);
		frame.getContentPane().add(edit);
		
	    cart = new JButton("shoppingCart");
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cart.setBounds(403, 12, 152, 25);
		frame.getContentPane().add(cart);
		
		logout = new JButton("log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logout.setBounds(583, 12, 99, 25);
		frame.getContentPane().add(logout);
		
		isbnCheckBox = new JCheckBox("ISBN");
		
		isbnCheckBox.setBounds(22, 173, 129, 23);
		frame.getContentPane().add(isbnCheckBox);
		
		 titlecheckBox = new JCheckBox("Title");
		titlecheckBox.setBounds(22, 265, 129, 23);
		frame.getContentPane().add(titlecheckBox);
		
	     chckbxCatagory = new JCheckBox("Catagory");
		chckbxCatagory.setBounds(22, 238, 129, 23);
		frame.getContentPane().add(chckbxCatagory);
		
		chckbxPrice = new JCheckBox("Price");
		chckbxPrice.setBounds(22, 209, 129, 23);
		frame.getContentPane().add(chckbxPrice);
		
		 chckbxPublicationYear = new JCheckBox("Publication year");
		chckbxPublicationYear.setBounds(20, 333, 165, 23);
		frame.getContentPane().add(chckbxPublicationYear);
		
	     chckbxQuantity = new JCheckBox("Quantity");
		chckbxQuantity.setBounds(22, 372, 129, 23);
		frame.getContentPane().add(chckbxQuantity);
		
		 chckbxPublisherName = new JCheckBox("Publisher name");
		chckbxPublisherName.setBounds(22, 298, 141, 23);
		frame.getContentPane().add(chckbxPublisherName);
		
		JLabel lblSearch = new JLabel("Search ");
		lblSearch.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSearch.setBounds(22, 113, 70, 15);
		frame.getContentPane().add(lblSearch);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(270, 175, 114, 19);
		frame.getContentPane().add(txtISBN);
		txtISBN.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(270, 213, 114, 19);
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
		textCatagory = new JTextField();
		textCatagory.setColumns(10);
		textCatagory.setBounds(270, 240, 114, 19);
		frame.getContentPane().add(textCatagory);
		
		textTitle = new JTextField();
		textTitle.setBounds(270, 267, 114, 19);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textPublisher = new JTextField();
		textPublisher.setBounds(270, 300, 114, 19);
		frame.getContentPane().add(textPublisher);
		textPublisher.setColumns(10);
		
		textYear = new JTextField();
		textYear.setBounds(270, 334, 114, 21);
		frame.getContentPane().add(textYear);
		textYear.setColumns(10);
		
		TextQuantity = new JTextField();
		TextQuantity.setBounds(270, 374, 114, 19);
		frame.getContentPane().add(TextQuantity);
		TextQuantity.setColumns(10);
		
		 btnManager = new JButton("Manager");
		 btnManager.setBounds(582, 527, 117, 25);
		 
		
		 
		btnGo = new JButton("GO");
		btnGo.setBounds(270, 423, 117, 25);
		frame.getContentPane().add(btnGo);
	}
}
