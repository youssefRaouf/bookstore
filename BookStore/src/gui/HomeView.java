package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.Box;

public class HomeView {

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton login;
	private JLabel lblBookstoreSystem;
	private JLabel lblCreateNewAccount;
	private JButton signup;
	
	
	public HomeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setResizable(false);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(52, 51, 70, 15);
		panel.add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(52, 78, 114, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(52, 109, 114, 19);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		login = new JButton("Login");
				login.setBounds(52, 140, 117, 25);
		panel.add(login);
		
		lblBookstoreSystem = new JLabel("BookStore System");
		lblBookstoreSystem.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBookstoreSystem.setBounds(158, 12, 228, 15);
		panel.add(lblBookstoreSystem);
		
		lblCreateNewAccount = new JLabel("or create new user");
		lblCreateNewAccount.setBounds(52, 195, 260, 30);
		panel.add(lblCreateNewAccount);
		
		signup = new JButton("Sign Up");
		
		
		
		signup.setBounds(52, 237, 117, 25);
		panel.add(signup);
		frame.setVisible(true);
			
		/*
		 * JButton addButton = new JButton("Add Book");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newBook.view();

			}

		});
		 * 
		 * */	
		
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getSignup() {
		return signup;
	}

	public void setSignup(JButton signup) {
		this.signup = signup;
	}
}
