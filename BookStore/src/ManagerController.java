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
	ReportsView report = new ReportsView();

	public ManagerController(ManagerModel mangerModel) {
		manger = new ManagerView();
		model = mangerModel;
		JButton addNewBook = manger.getOkButton();
		addNewBook.addActionListener(new NewBookAddition());
		report.managerPage.addActionListener(new goBackToManager());
		manger.promoteButton.addActionListener(new PromoteUser());
		manger.placeOderButton.addActionListener(new PlaceOrder());
		manger.cancelOrderBox.addActionListener(new CancelOrder());
		manger.confirmOrderBox.addActionListener(new ConfirmOrder());
		manger.newBook.btnUpdate.addActionListener(new ConfirmUpdateBook());
		System.out.println(manger.getReportOneButton);
		manger.getReportOneButton.addActionListener(new ViewReport1());
		manger.getReportTwoButton.addActionListener(new ViewReport2());
		manger.getReportThreeButton.addActionListener(new ViewReport3());
		fillComboBox(manger.cancelOrderBox);
		fillComboBox(manger.confirmOrderBox);
	}

	public void view() {
		manger.frame.setVisible(true);
	}

	public class ConfirmUpdateBook implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<Object> attributes = new ArrayList<Object>();
			ArrayList<Object> values = new ArrayList<Object>();
			if (manger.getISBN() != null && manger.getISBN() != "") {
				attributes.add("ISBN");
				values.add(manger.getISBN());

			}
			if (manger.getCategory() != null && manger.getCategory().length() != 0) {
				attributes.add("Category");
				values.add(manger.getCategory());
			}
			if (manger.getPblisherName() != null && manger.getPblisherName().length() != 0) {
				attributes.add("Publisher_Name");
				values.add(manger.getPblisherName());
			}
			if (manger.getPrice() != null && manger.getPrice().length() != 0) {
				attributes.add("Price");
				values.add(manger.getPrice());

			}
			if (manger.getPublicationYear() != null && manger.getPublicationYear().length() != 0) {
				attributes.add("Publication_Year");
				values.add(manger.getPublicationYear());

			}
			if (manger.getQuantity() != null && manger.getQuantity().length() != 0) {
				attributes.add("Quantity");
				values.add(manger.getQuantity());
			}
			if (manger.getThreshold() != null && manger.getThreshold().length() != 0) {
				attributes.add("Threshold");
				values.add(manger.getThreshold());

			}
			if (manger.getTitle() != null && manger.getTitle().length() != 0) {
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
				if (orderID != null) {
					model.cancelOrder(orderID);
					manger.confirmOrderBox.removeItemAt(manger.cancelOrderBox.getSelectedIndex());
					manger.cancelOrderBox.removeItemAt(manger.cancelOrderBox.getSelectedIndex());
				}
				manger.cancelOrderBox.setSelectedIndex(0);
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
				if (orderID != null) {
					model.confirmOrder(orderID);
					manger.cancelOrderBox.removeItemAt(manger.confirmOrderBox.getSelectedIndex());
					manger.confirmOrderBox.removeItemAt(manger.confirmOrderBox.getSelectedIndex());
				}
				manger.confirmOrderBox.setSelectedIndex(0);
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
				if (quantity.getText() != null && quantity.getText().length() != 0) {
					quantityValue = Integer.parseInt(quantity.getText());
				}
				if (isbn.getText() != null && isbn.getText().length() != 0) {
					IsbnValue = "\'" + isbn.getText() + "\'";
				}
				boolean succeeded = model.placeOrder(quantityValue, IsbnValue);
				if (succeeded) {
					fillComboBox(manger.cancelOrderBox);
					fillComboBox(manger.confirmOrderBox);
				}
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
			model.addBook(manger.getCategory(), manger.getPrice(), manger.getPublicationYear(),
					manger.getPblisherName(), manger.getThreshold(), manger.getQuantity(), manger.getAuthors(),
					manger.getTitle());
			manger.newBook.frame.setVisible(false);
		}
	}

	public void navigateToMainPage() {
		if (manger.frame != null)
			manger.frame.setVisible(false);
	}

	public JButton mainPageBtn() {
		return manger.mainPage;
	}

	public class ViewReport1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			report.setList(model.ManagerReport_Total_Sales());
			report.getFrame().setVisible(true);
			manger.getFrame().setVisible(false);
		}
	}

	public class ViewReport2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			report.setList(model.ManagerReport_Top5());
			report.getFrame().setVisible(true);
			manger.getFrame().setVisible(false);
		}
	}

	public class ViewReport3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			report.setList(model.ManagerReport_top10_selling());
			report.getFrame().setVisible(true);
			manger.getFrame().setVisible(false);
		}
	}
	
	public class goBackToManager implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			report.getFrame().setVisible(false);
			manger.getFrame().setVisible(true);
		}
	}

}
