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
	
	public JButton getReportOneButton;
	public JButton getReportTwoButton;
	public JButton getReportThreeButton;
	
	public JButton mainPage;
	public JComboBox confirmOrderBox;

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
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton addButton = new JButton("Add Book");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newBook.btnOk.setVisible(true);
				newBook.btnUpdate.setVisible(false);
				newBook.lblAuthors.setVisible(true);
				newBook.textField.setVisible(false);
				newBook.txtXxxxyyyyzzzz.setVisible(true);
				newBook.lblNewLabel.setVisible(false);
				newBook.textField_2.setVisible(true);
                newBook.textField_3.setVisible(true);
                newBook.lblPublicationYear.setVisible(true);
                newBook.lblPublisher.setVisible(true);
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
				newBook.btnOk.setVisible(false);
				newBook.textField.setVisible(true);
				newBook.lblNewLabel.setVisible(true);
				newBook.txtXxxxyyyyzzzz.setVisible(false);
				newBook.btnUpdate.setVisible(true);
				newBook.lblAuthors.setVisible(false);
				newBook.textField_2.setVisible(false);
                newBook.textField_3.setVisible(false);
                newBook.lblPublicationYear.setVisible(false);
                newBook.lblPublisher.setVisible(false);
				newBook.view();
			}
		});
		modifyBook.setBounds(232, 36, 157, 25);
		frame.getContentPane().add(modifyBook);
//*************************************************************************************		
		getReportOneButton = new JButton("Total Sales");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		getReportOneButton.setBounds(8, 209, 161, 25);
		frame.getContentPane().add(getReportOneButton);
		
		getReportTwoButton = new JButton("Top 5");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		getReportTwoButton.setBounds(6, 245, 163, 25);
		frame.getContentPane().add(getReportTwoButton);
		
		getReportThreeButton = new JButton("Top 10 selling");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		getReportThreeButton.setBounds(4, 281, 165, 25);
		frame.getContentPane().add(getReportThreeButton);
//*************************************************************************************	
		//mainPage.setBounds(10, 173, 159, 25);
		mainPage = new JButton("go back to main page");
		mainPage.setBounds(10, 173, 159, 25);
		frame.getContentPane().add(mainPage);

		JLabel lblManagerPrivilage = new JLabel("Manager Privilage");
		lblManagerPrivilage.setBackground(Color.BLACK);
		lblManagerPrivilage.setBounds(132, 9, 217, 15);
		frame.getContentPane().add(lblManagerPrivilage);
		JLabel lblConfirmOrder = new JLabel("Confirm Order ");
		lblConfirmOrder.setBounds(232, 137, 89, 20);
		frame.getContentPane().add(lblConfirmOrder);
		confirmOrderBox = new JComboBox();
		confirmOrderBox.setBounds(314, 139, 200, 30);
		confirmOrderBox.addItem("OrdersList");
		frame.getContentPane().add(confirmOrderBox);
	}

	public JButton getOkButton() {

		return newBook.btnOk;
	}

	public String getISBN() {
		try {

			return newBook.textField.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getTitle() {
		try {

			return  newBook.textField_1.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getPblisherName() {
		try {

			return newBook.textField_2.getText();
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

			return newBook.textField_3.getText();
		} catch (Exception e) {
			return null;
		}

	}

	public String getThreshold() {
		try {

			return newBook.textField_7.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getPrice() {
		try {

			return newBook.textField_4.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getCategory() {
		try {

			return newBook.textField_5.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getQuantity() {
		try {

			return newBook.textField_6.getText();
		} catch (Exception e) {
			return null;
		}
	}
	public JFrame getFrame() {
		return frame;
	}
}
