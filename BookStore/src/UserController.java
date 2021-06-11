
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.*;

public class UserController<SearchResults> {

	UserModel user;
	ManagerModel manger;
	HomeView home;
	SignUpView signUp;
	CheckoutView checkoutPage;
	MainView mainPage;
	String access;
	ManagerController manager;
	JButton mainPageBtn;
	ShoppingCartContents cart;
	SearchDisplayer search;

	public UserController() {
		home = new HomeView();
		manger = new ManagerModel();
		signUp = new SignUpView();
		mainPage = new MainView();
		search = new SearchDisplayer();
		checkoutPage = new CheckoutView();
		checkoutPage.btnOk.addActionListener(new checkoutListener());
		cart = new ShoppingCartContents();
		cart.btnRemove.addActionListener(new RemoveItem());
		cart.checkOutButton.addActionListener(new goToCheckoutListener());
		cart.mainPage.addActionListener(new goBackToMainPage());
		checkoutPage.mainPage.addActionListener(new goBackToMainPage());
		JButton login = home.getLogin();
		login.addActionListener(new SignInListener());

		JButton sign_up = signUp.getBtnOk();
		sign_up.addActionListener(new SignUpListener());

		JButton register = home.getSignup();
		register.addActionListener(new RegisterListener());
		mainPage.getCart().addActionListener(new ViewCart());
		JButton searchBtn = mainPage.getBtnGo();
		searchBtn.addActionListener(new searchListener());
		JButton logoutBtn = mainPage.getBtnLogout();
		logoutBtn.addActionListener(new logoutListener());
		JButton mngBtn = mainPage.getBtnManager();
		mngBtn.addActionListener(new manageListener());
		search.getMainPageButton().addActionListener(new goBackToMainPage());

	}

	public class SignInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String email = home.getTxtEmail().getText();
			String password = home.getTxtPassword().getText();
			if (email != null) {
				email = "\'" + email + "\'";
			}
			if (password != null) {
				password = "\'" + password + "\'";
			}
			access = manger.login(password, email);
			if (access == null) {
				JOptionPane.showMessageDialog(null, "wrong Email or password !");
			} else if (access.equals("user")) {
				mainPage.setAccess("user");
				user = (UserModel) manger;
				home.getFrame().setVisible(false);
				mainPage.getFrame().setVisible(true);

			} else if (access.equals("manager")) {
				mainPage.setAccess("manager");
				manager = new ManagerController(manger);
				mainPageBtn = manager.mainPageBtn();
				mainPageBtn.addActionListener(new goBackToMainPage());
				home.getFrame().setVisible(false);
				mainPage.view();

			}
		}
	}

	public class SignUpListener implements ActionListener {
		/*
		 * user name, password, last name, first name, e-mail address, phone number, and
		 * shipping address
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {

			user = (UserModel) manger;
			mainPage.setAccess("user");
			String user_name = signUp.getUser_name().getText().length() == 0 ? null
					: "'" + signUp.getUser_name().getText() + "'";
			String last_name = signUp.getLast_name().getText().length() == 0 ? null
					: "'" + signUp.getLast_name().getText() + "'";
			String first_name = signUp.getFirst_name().getText().length() == 0 ? null
					: "'" + signUp.getFirst_name().getText() + "'";
			String phone_number = signUp.getPhone_number().getText().length() == 0 ? null
					: "'" + signUp.getPhone_number().getText() + "'";
			String shipping_address = signUp.getShipping_address().getText().length() == 0 ? null
					: "'" + signUp.getShipping_address().getText() + "'";
			String email = signUp.getEmail().getText().length() == 0 ? null : "'" + signUp.getEmail().getText() + "'";
			String password = signUp.getPassword().getText().length() == 0 ? null
					: "'" + signUp.getPassword().getText() + "'";
			boolean valid = user.signUp(user_name, first_name, last_name, email, password, phone_number,
					shipping_address, "'user'");
			if (!valid) {

				JOptionPane.showMessageDialog(null, "Wrong data!", "Error", JOptionPane.ERROR_MESSAGE);

			} else {
				signUp.getFrame().setVisible(false);
				mainPage.view();

			}
		}
	}

	public class RegisterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			home.getFrame().setVisible(false);
			signUp.view();
		}
	}

	/**** remove item from shop has cart ****/
	public class RemoveItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			search.removeIsbn(cart.list.getSelectedIndex());
			cart.setList(search.getIsbns());
		}
	}

	public class ViewCart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cart.setList(search.getIsbns());
			cart.getFrame().setVisible(true);
			mainPage.getFrame().setVisible(false);
		}
	}

	public class logoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			user = null;
			manager = null;
			mainPage.getFrame().setVisible(false);
			home.getFrame().setVisible(true);
		}
	}

	public class searchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<String> attributes = new ArrayList<String>();
			ArrayList<String> values = new ArrayList<String>();

			if (mainPage.getIsbnCheckBox().isSelected()) {
				attributes.add("ISBN");
				values.add(mainPage.getISBN());
			}
			if (mainPage.getChckbxCatagory().isSelected()) {
				attributes.add("Category");
				values.add(mainPage.getCatagory());
			}
			if (mainPage.getChckbxPrice().isSelected()) {
				attributes.add("Price");
				values.add(mainPage.getPrice());
			}
			if (mainPage.getChckbxPublicationYear().isSelected()) {
				attributes.add("Publication_Year");
				values.add(mainPage.getYear());
			}
			if (mainPage.getChckbxPublisherName().isSelected()) {
				attributes.add("Publisher_Name");
				values.add(mainPage.getPublisher());
			}
			if (mainPage.getChckbxTitle().isSelected()) {
				attributes.add("Title");
				values.add(mainPage.getTitle());
			}
			if (mainPage.getChckbxQuantity().isSelected()) {
				attributes.add("Quantity");
				values.add(mainPage.getQuantity());
			}
			try {
				if (manger != null) {
					manger.searchForBook(attributes, values);
				} else {
					user.searchForBook(attributes, values);
				}
				search.setSearchResults(manger == null ? user.getBooks() : manger.getBooks());
				search.initialize();
				search.getFrame().setVisible(true);
				mainPage.getFrame().setVisible(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private class goBackToMainPage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			navigateToMainPage();
		}

	}

	private class manageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (access.equals("manager"))
				manager.manger.frame.setVisible(true);
			else {

				JOptionPane.showMessageDialog(null, "you are not a manager!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			mainPage.getFrame().setVisible(false);
		}

	}

	private class checkoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (user != null) {
				user.checkout(search.getIsbns(), user.email);
			} else {
				manager.model.checkout(search.getIsbns(), manager.model.email);
			}
			search.emptyIsbns();
			navigateToMainPage();
		}

	}

	private class goToCheckoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (search.getIsbns().size() > 0) {
				cart.getFrame().setVisible(false);
				checkoutPage.getFrame().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "your cart is empty");
			}
		}

	}

	private void navigateToMainPage() {
		try {
			if (search.getFrame() != null)
				search.getFrame().setVisible(false);
			if (cart.getFrame() != null)
				cart.getFrame().setVisible(false);
			if (checkoutPage.getFrame() != null) {
				checkoutPage.getFrame().setVisible(false);
			}
			if(manger != null && manager != null)
				manager.navigateToMainPage();
			mainPage.getFrame().setVisible(true);
		} catch (Error e) {

		}
	}

}
