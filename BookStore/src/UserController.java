
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.SearchDisplayer;
import gui.*;

public class UserController<SearchResults> {

	UserModel user;
	ManagerModel manger;

	HomeView home;
	SignUpView signUp;
	MainView mainPage;
	String access;
	ManagerController manager;
	ShoppingCartContents cart;
	SearchDisplayer search;

	public UserController() {
		System.out.println("in controller constructor");
		home = new HomeView();

		manger = new ManagerModel();

		signUp = new SignUpView();
		mainPage = new MainView();
		search = new SearchDisplayer();
		// searchResult
		// user = new UserModel();

		JButton login = home.getLogin();
		login.addActionListener(new SignInListener());

		JButton sign_up = signUp.getBtnOk();
		sign_up.addActionListener(new SignUpListener());

		JButton register = home.getSignup();
		register.addActionListener(new RegisterListener());
		cart = new ShoppingCartContents();
		mainPage.getCart().addActionListener(new ViewCart());
		cart.btnRemove.addActionListener(new RemoveItem());
		JButton searchBtn = mainPage.getBtnGo();
		searchBtn.addActionListener(new searchListener());
		JButton addToCart = search.getAddButton();
		addToCart.addActionListener(new AddToCartListener());
		JButton modifyBtn = search.getModifyButton();
		modifyBtn.addActionListener(new ModifyListener());

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
			System.out.println(":" + access + ":");
			if (access == null) {
				System.out.println(access + "  ddddddd ");
				JOptionPane.showMessageDialog(null, "Empty Email or password !", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (access.equals("user")) {
				mainPage.setAccess("user");
				user = (UserModel) manger;
				home.getFrame().setVisible(false);
				mainPage.getFrame().setVisible(true);

			} else if (access.equals("manager")) {
				mainPage.setAccess("manager");
				manager = new ManagerController(manger);
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
			if (!cart.Items.getSelectedItem().equals("Purchaces")) {
				System.out.println("lol");
			}
		}
	}

	public class ViewCart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<ArrayList<String>> cartContents;
			if (user == null) {
				cartContents = manger.viewCartItems();
			} else {
				cartContents = user.viewCartItems();
			}
			if (cartContents == null) {
				JOptionPane.showMessageDialog(cart.frame, "sorry !", "Error", JOptionPane.ERROR_MESSAGE);

			}

			cart.Items.addItem("Purchaces");
			for (int i = 0; i < cartContents.size() - 1; i++) {
				System.out.println("lol" + cartContents.get(0));
				ArrayList<String> book = new ArrayList<String>();
				String elemet = "Title: " + cartContents.get(i).get(0) + " Price: " + cartContents.get(i).get(1);
				cart.Items.addItem(elemet);

			}
			cart.label.setText(cartContents.get(cartContents.size() - 1).get(1));
			cart.view();
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
				System.out.println("ISBN");
				System.out.println(mainPage.getISBN());
			}
			if (mainPage.getChckbxCatagory().isSelected()) {
				attributes.add("Category");
				values.add(mainPage.getCatagory());
				System.out.println("Category");
				System.out.println(mainPage.getCatagory());
			}
			if (mainPage.getChckbxPrice().isSelected()) {
				attributes.add("Price");
				values.add(mainPage.getPrice());
				System.out.println("price");
				System.out.println(mainPage.getPrice());
			}
			if (mainPage.getChckbxPublicationYear().isSelected()) {
				attributes.add("Publication_Year");
				values.add(mainPage.getYear());
				System.out.println("Publication_Year");
				System.out.println(mainPage.getYear());
			}
			if (mainPage.getChckbxPublisherName().isSelected()) {
				attributes.add("Publisher_Name");
				values.add(mainPage.getPublisher());
				System.out.println("Publisher");
				System.out.println(mainPage.getPublisher());

			}
			if (mainPage.getChckbxTitle().isSelected()) {
				attributes.add("Title");
				values.add(mainPage.getTitle());

			}
			if (mainPage.getChckbxQuantity().isSelected()) {
				attributes.add("Quantity");
				values.add(mainPage.getQuantity());
				System.out.println("Quantity");
				System.out.println(mainPage.getQuantity());
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private class AddToCartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("in action listern");
			try {

				user.addBook(search.getIsbns());
				search.getFrame().setVisible(false);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private class ModifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("in modify");
			try {
				System.out.println("access" + access);
				if (access.equals("manager"))
					manager.manger.frame.setVisible(true);
				else {

					JOptionPane.showMessageDialog(null, "you do not have the rights to modifiy!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				manger.addBook(search.getIsbns());
				search.getFrame().setVisible(false);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
