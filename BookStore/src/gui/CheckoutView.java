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

public class CheckoutView {

	JFrame frame;

	JTextField creditNumber;
	JTextField expiryDate;
	public JButton btnOk;
	public JButton mainPage;

	public CheckoutView() {
		initialize();
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

		JLabel lblNewLabel = new JLabel(" Credit Number ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		creditNumber = new JTextField("xxxx-xxxx-xxxx-xxxx");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(creditNumber, gbc_textField);
		creditNumber.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(" Expiry date ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		expiryDate = new JTextField("mm-yyyy");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(expiryDate, gbc_textField_1);
		expiryDate.setColumns(10);

		btnOk = new JButton("Checkout");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 10;
		frame.getContentPane().add(btnOk, gbc_btnOk);
		mainPage = new JButton("go back to main page");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 11;
		frame.getContentPane().add(mainPage, gbc_btnBack);

		

	}

	public JTextField getCreditNumber() {
		return creditNumber;
	}

	public JTextField getExpiryDate() {
		return expiryDate;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

}
