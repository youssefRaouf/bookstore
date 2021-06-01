import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.*;

public class ManagerController {

	ManagerView manger;
	ManagerModel model;

	public ManagerController(ManagerModel mangerModel) {
		System.out.println("in controller constructor");
		manger = new ManagerView();
		model = mangerModel;
		JButton addNewBook = manger.getOkButton();
		addNewBook.addActionListener(new NewBookAddition());
		manger.promoteButton.addActionListener(new PromoteUser());
		manger.placeOderButton.addActionListener(new PlaceOrder());
		manger.cancelOrderBox.addActionListener(new CancelOrder());
		manger.confirmOrderBox.addActionListener(new ConfirmOrder());
		manger.newBook.btnUpdate.addActionListener(new ConfirmUpdateBook());
		manger.addPublisherBtn.addActionListener(new AddPublisher());
		fillComboBox(manger.cancelOrderBox);
		fillComboBox(manger.confirmOrderBox);
	}
	
	public void view()
	{
		manger.frame.setVisible(true);
	}

	public class AddPublisher implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTextField name = new JTextField();
			JTextField address = new JTextField();
			JTextField phone = new JTextField();
			
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Name"));
			myPanel.add(name);
			//myPanel.add(Box.createHorizontalStrut(50)); // a spacer
			//myPanel.add(Box.createVerticalStrut(100));
			myPanel.add(new JLabel("Address"));
			myPanel.add(address);
			myPanel.add(new JLabel("Phone"));
			myPanel.add(phone);
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Fill Author Data",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String nameValue = null;
				String phoneValue = null;
				String addressValue = null;
				if (name.getText() != null) {
					nameValue = "\'" + name.getText() + "\'";
				}
				if (phone.getText() != null) {
					phoneValue = "\'" + phone.getText() + "\'";
				}
				if (address.getText() != null) {
					addressValue = "\'" + address.getText() + "\'";
				}
				model.addPublisher(nameValue, addressValue, phoneValue);
			}

		}
			
		}
		
	
	public class ConfirmUpdateBook implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<Object> attributes =  new ArrayList<Object>();
			ArrayList<Object> values = new ArrayList<Object>();
			if(manger.getCategory() != null)
			{
				attributes.add("Category");
				values.add(manger.getCategory());
			}
			if(manger.getISBN() != null)
			{
				attributes.add("ISBN");
				values.add(manger.getISBN());
				
			}
			if(manger.getPblisherName() != null)
			{
				attributes.add("Publisher_Name");
				values.add(manger.getPblisherName());
			}
			if(manger.getPrice() != null)
			{
				attributes.add("Price");
				values.add(manger.getPrice());
				
			}
			if(manger.getPublicationYear() != null)
			{
				attributes.add("Publication_Year");
				values.add(manger.getPublicationYear());
				
			}
			if(manger.getQuantity() != null)
			{
				attributes.add("Quantity");
				values.add(manger.getQuantity());
			}
			if(manger.getThreshold() != null)
			{
				attributes.add("Threshold");
			values.add(manger.getThreshold());
				
			}
			if(manger.getTitle() != null)
			{
				attributes.add("Title");
				values.add(manger.getTitle());
				
			}
		  model.modifyBook(attributes, values);
		  manger.newBook.frame.setVisible(false);	
			
		}
		
	}
	public void fillComboBox(JComboBox box) {
		HashMap<String, Integer> data = model.getOrders();
		Set<String> keys = data.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			box.addItem(iterator.next());
		}
	}

	public class CancelOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedKey = (String) manger.cancelOrderBox.getSelectedItem();
			if (!selectedKey.equals("OrdersList")) {
				HashMap<String, Integer> orders = model.getOrders();
				Integer orderID = orders.get(selectedKey);
				System.out.println(orderID);
				model.cancelOrder(orderID);
				manger.cancelOrderBox.removeItemAt(manger.cancelOrderBox.getSelectedIndex());
			}
		}

	}

	public class ConfirmOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedKey = (String) manger.confirmOrderBox.getSelectedItem();
			if (!selectedKey.equals("OrdersList")) {
				HashMap<String, Integer> orders = model.getOrders();
				Integer orderID = orders.get(selectedKey);
				model.confirmOrder(orderID);
				manger.confirmOrderBox.removeItemAt(manger.confirmOrderBox.getSelectedIndex());
			}
		}
	}

	public class PlaceOrder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField isbn = new JTextField(5);
			JTextField quantity = new JTextField(5);
			JPanel myPanel = new JPanel();
			myPanel.add(new JLabel("ISBN"));
			myPanel.add(isbn);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("Quantity"));
			myPanel.add(quantity);
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				Integer quantityValue = null;
				String IsbnValue = null;
				if (quantity.getText() != null) {
					quantityValue = Integer.parseInt(quantity.getText());
				}
				if (isbn.getText() != null) {
					IsbnValue = "\'" + isbn.getText() + "\'";
				}
				model.placeOrder(quantityValue, IsbnValue);
				fillComboBox(manger.cancelOrderBox);
				fillComboBox(manger.confirmOrderBox);
			}

		}
	}

	public class PromoteUser implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane option = new JOptionPane();
			String userEmail = option.showInputDialog("Enter User Email");
			model.promoteUser("\'" + userEmail + "\'");
		}

	}

	public class NewBookAddition implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("***************");
			String[] authors;
			ArrayList<String> authorList;

			if (manger.getAuthors() != null) {
				authors = (manger.getAuthors()).split(",");
				authorList = new ArrayList<String>((Arrays.asList(authors)));
			} else {
				authorList = null;

			}

			model.addBook(manger.getCategory(), manger.getISBN(), manger.getPrice(), manger.getPublicationYear(),
					manger.getPblisherName(), manger.getThreshold(), manger.getQuantity(), authorList,
					manger.getTitle());
			manger.newBook.frame.setVisible(false);
		}
	}

}
