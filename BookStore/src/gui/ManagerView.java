package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

public class ManagerView {

	public JFrame frame;
	public NewBookView newBook = new NewBookView();
	public JButton promoteButton;
	public JButton placeOderButton;
	public JComboBox cancelOrderBox;
	public JComboBox confirmOrderBox;
	public JButton addPublisherBtn;


	/**
	 * Create the application.
	 */
	public ManagerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton addButton = new JButton("Add Book");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newBook.btnOk.setVisible(true);
				newBook.view();

			}

		});
		addButton.setBounds(12, 36, 157, 25);
		frame.getContentPane().add(addButton);

		promoteButton = new JButton("Promote User");
		promoteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		promoteButton.setBounds(12, 82, 157, 25);
		frame.getContentPane().add(promoteButton);

		placeOderButton = new JButton("Place Order");
		placeOderButton.setBounds(12, 137, 157, 25);
		frame.getContentPane().add(placeOderButton);

		JButton modifyBook = new JButton("modify book");
		modifyBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newBook.txtXxxxyyyyzzzz.setVisible(false);;
				newBook.btnUpdate.setVisible(true);
				newBook.lblAuthors.setVisible(false);
				newBook.lblNewLabel.setVisible(false);
				newBook.textField.setVisible(false);
				newBook.view();
			}
		});
		modifyBook.setBounds(232, 36, 157, 25);
		frame.getContentPane().add(modifyBook);

		JButton btnReports = new JButton("Reports");
		btnReports.setBounds(10, 173, 159, 25);
		frame.getContentPane().add(btnReports);

		JLabel lblManagerPrivilage = new JLabel("Manager Privilage");
		lblManagerPrivilage.setBackground(Color.BLACK);
		lblManagerPrivilage.setBounds(132, 9, 217, 15);
		frame.getContentPane().add(lblManagerPrivilage);
		
		cancelOrderBox = new JComboBox();
		cancelOrderBox.setBounds(312, 87, 89, 20);
		frame.getContentPane().add(cancelOrderBox);
		
		JLabel lblCancelOrder = new JLabel("Cancel Order ");
		lblCancelOrder.setBounds(232, 87, 89, 20);
		frame.getContentPane().add(lblCancelOrder);
		
		JLabel lblConfirmOrder = new JLabel("Confirm Order ");
		lblConfirmOrder.setBounds(232, 137, 89, 20);
		frame.getContentPane().add(lblConfirmOrder);
		
		confirmOrderBox = new JComboBox();
		confirmOrderBox.setBounds(312, 139, 89, 20);
		confirmOrderBox.addItem("OrdersList");
		cancelOrderBox.addItem("OrdersList");

		frame.getContentPane().add(confirmOrderBox);
		
		addPublisherBtn = new JButton("Add Publisher");
		
		addPublisherBtn.setBounds(12, 209, 157, 23);
		frame.getContentPane().add(addPublisherBtn);
	}

	public JButton getOkButton() {

		return newBook.btnOk;
	}

	public String getISBN() {
		try {

			return "\'" + newBook.textField.getText() + "\'";
		} catch (Exception e) {
			return null;
		}
	}

	public String getTitle() {
		try {

			return "\'" + newBook.textField_1.getText() + "\'";
		} catch (Exception e) {
			return null;
		}
	}

	public String getPblisherName() {
		try {

			return "\'" + newBook.textField_2.getText() + "\'";
		} catch (Exception e) {
			return null;
		}
	}

	public String getAuthors() {
		try {

			return newBook.txtXxxxyyyyzzzz.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getPublicationYear() {

		try {

			return "\'" + newBook.textField_3.getText() + "\'";
		} catch (Exception e) {
			return null;
		}

	}

	public Integer getThreshold() {
		try {

			return Integer.parseInt(newBook.textField_7.getText());
		} catch (Exception e) {
			return null;
		}
	}

	public Integer getPrice() {
		try {

			return Integer.parseInt(newBook.textField_4.getText());
		} catch (Exception e) {
			return null;
		}
	}

	public String getCategory() {
		try {

			return "\'" + newBook.textField_5.getText() + "\'";
		} catch (Exception e) {
			return null;
		}
	}

	public Integer getQuantity() {
		try {

			return Integer.parseInt(newBook.textField_6.getText());
		} catch (Exception e) {
			return null;
		}
	}
}
