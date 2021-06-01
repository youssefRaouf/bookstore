package gui;


import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpView {

	JFrame frame;
	JTextField creditCardNo;

	JTextField user_name;
	JTextField password;
	JTextField last_name;
	JTextField first_name;
	JTextField email;
	JTextField textField_7;
	JTextField phone_number;
	JTextField shipping_address;
	JTextField textField_6;
	private JLabel lblPrice;
	private JLabel lblCategory;
	private JLabel lblQuantity;
	private JLabel lblThreshold;
	private MainView mainView;
	
	private MainView home;
	
	JButton btnOk;
	private JLabel lblCcns;
	private JLabel lblExpireDates;
	private JTextField ccns;
	private JTextField expireDate;

	public SignUpView() {
		initialize();
		home = new MainView ();
	}

	public void view() {
		frame.setVisible(true);
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel(" User Name ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		user_name = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(user_name, gbc_textField);
		user_name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(" password ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		password = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(password, gbc_textField_1);
		password.setColumns(10);

		JLabel lblPublisher = new JLabel(" last name ");
		GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
		gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublisher.gridx = 0;
		gbc_lblPublisher.gridy = 2;
		frame.getContentPane().add(lblPublisher, gbc_lblPublisher);

		last_name = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;

		frame.getContentPane().add(last_name, gbc_textField_2);
		last_name.setColumns(10);

		JLabel lblAuthors = new JLabel(" first name ");
		GridBagConstraints gbc_lblAuthors = new GridBagConstraints();
		gbc_lblAuthors.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthors.gridx = 0;
		gbc_lblAuthors.gridy = 3;
		frame.getContentPane().add(lblAuthors, gbc_lblAuthors);

		first_name = new JTextField();
		//first_name.setText("xxxx,yyyy,zzzz");
		GridBagConstraints gbc_txtXxxxyyyyzzzz = new GridBagConstraints();
		gbc_txtXxxxyyyyzzzz.insets = new Insets(0, 0, 5, 0);
		gbc_txtXxxxyyyyzzzz.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXxxxyyyyzzzz.gridx = 4;
		gbc_txtXxxxyyyyzzzz.gridy = 3;

		frame.getContentPane().add(first_name, gbc_txtXxxxyyyyzzzz);
		first_name.setColumns(10);

		JLabel lblPublicationYear = new JLabel(" e-mail ");
		GridBagConstraints gbc_lblPublicationYear = new GridBagConstraints();
		gbc_lblPublicationYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublicationYear.gridx = 0;
		gbc_lblPublicationYear.gridy = 4;
		frame.getContentPane().add(lblPublicationYear, gbc_lblPublicationYear);

		email = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		frame.getContentPane().add(email, gbc_textField_3);
		email.setColumns(10);

		lblPrice = new JLabel(" phone number ");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 5;
		frame.getContentPane().add(lblPrice, gbc_lblPrice);

		phone_number = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;

		frame.getContentPane().add(phone_number, gbc_textField_4);
		phone_number.setColumns(10);

		
		
		lblCategory = new JLabel("   shipping address ");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 6;

		frame.getContentPane().add(lblCategory, gbc_lblCategory);

		shipping_address = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 6;
		frame.getContentPane().add(shipping_address, gbc_textField_5);
		shipping_address.setColumns(10);

		

		
	/*	creditCardNo = new JTextField();
		creditCardNo.setText("xxxx,yyyy,zzzz");
		GridBagConstraints gbc_creditCardNo = new GridBagConstraints();
		gbc_creditCardNo.insets = new Insets(0, 0, 5, 0);
		gbc_creditCardNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_creditCardNo.gridx = 4;
		gbc_creditCardNo.gridy = 3;

		frame.getContentPane().add(creditCardNo, gbc_creditCardNo);
		creditCardNo.setColumns(10);
*/
/*
		JLabel lblAuthors = new JLabel("Authors");
		GridBagConstraints gbc_lblAuthors = new GridBagConstraints();
		gbc_lblAuthors.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthors.gridx = 0;
		gbc_lblAuthors.gridy = 3;
		frame.getContentPane().add(lblAuthors, gbc_lblAuthors);

		creditCardNo = new JTextField();
		creditCardNo.setText("xxxx,yyyy,zzzz");
		GridBagConstraints gbc_txtXxxxyyyyzzzz = new GridBagConstraints();
		gbc_txtXxxxyyyyzzzz.insets = new Insets(0, 0, 5, 0);
		gbc_txtXxxxyyyyzzzz.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXxxxyyyyzzzz.gridx = 4;
		gbc_txtXxxxyyyyzzzz.gridy = 3;

	*/	//frame.getContentPane().add(creditCardNo, gbc_txtXxxxyyyyzzzz);
		//creditCardNo.setColumns(10);

		
		/////////////////////////////////////////////////////////////////
	
		btnOk = new JButton("Register ");
		lblCcns = new JLabel("Ccn(s)");
		GridBagConstraints gbc_lblCcns = new GridBagConstraints();
		gbc_lblCcns.insets = new Insets(0, 0, 5, 5);
		gbc_lblCcns.gridx = 0;
		gbc_lblCcns.gridy = 7;
		frame.getContentPane().add(lblCcns, gbc_lblCcns);
		
		ccns = new JTextField();
		ccns.setText("xxx,yyy,zzz,...");
		GridBagConstraints gbc_textFieldf = new GridBagConstraints();
		gbc_textFieldf.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldf.gridx = 4;
		gbc_textFieldf.gridy = 7;
		frame.getContentPane().add(ccns, gbc_textFieldf);
		ccns.setColumns(10);
		
		lblExpireDates = new JLabel("expire dates");
		GridBagConstraints gbc_lblExpireDates = new GridBagConstraints();
		gbc_lblExpireDates.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpireDates.gridx = 0;
		gbc_lblExpireDates.gridy = 8;
		frame.getContentPane().add(lblExpireDates, gbc_lblExpireDates);
		
		expireDate = new JTextField();
		expireDate.setText("xxx,yyy,zzz,...");
		GridBagConstraints gbc_textFieldg = new GridBagConstraints();
		gbc_textFieldg.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldg.gridx = 4;
		gbc_textFieldg.gridy = 8;
		frame.getContentPane().add(expireDate, gbc_textFieldg);
		expireDate.setColumns(10);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 10;
		frame.getContentPane().add(btnOk, gbc_btnOk);
	
	
	}

	public JTextField getCcns() {
		return ccns;
	}

	public void setCcns(JTextField ccns) {
		this.ccns = ccns;
	}

	public JTextField getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(JTextField expireDate) {
		this.expireDate = expireDate;
	}

	public JTextField getUser_name() {
		return user_name;
	}

	public void setUser_name(JTextField user_name) {
		this.user_name = user_name;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JTextField getLast_name() {
		return last_name;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setLast_name(JTextField last_name) {
		this.last_name = last_name;
	}

	public JTextField getFirst_name() {
		return first_name;
	}

	public void setFirst_name(JTextField first_name) {
		this.first_name = first_name;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(JTextField phone_number) {
		this.phone_number = phone_number;
	}

	public JTextField getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(JTextField shipping_address) {
		this.shipping_address = shipping_address;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}
}
