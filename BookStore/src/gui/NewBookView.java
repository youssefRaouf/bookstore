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

public class NewBookView {

	public JFrame frame;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField txtXxxxyyyyzzzz;
	JTextField textField_3;
	JTextField textField_7;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JLabel lblAuthors;
	JLabel lblNewLabel;
	private JLabel lblPrice;
	private JLabel lblCategory;
	private JLabel lblQuantity;
	private JLabel lblThreshold;

	JButton btnOk;
	public JButton btnUpdate;

	public NewBookView() {
		initialize();
	}

	public void view() {
		frame.setVisible(true);
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		lblNewLabel = new JLabel("ISBN");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Title");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblPublisher = new JLabel("Publisher_Name");
		GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
		gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublisher.gridx = 0;
		gbc_lblPublisher.gridy = 2;
		frame.getContentPane().add(lblPublisher, gbc_lblPublisher);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;

		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		lblAuthors = new JLabel("Authors");
		GridBagConstraints gbc_lblAuthors = new GridBagConstraints();
		gbc_lblAuthors.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthors.gridx = 0;
		gbc_lblAuthors.gridy = 3;
		frame.getContentPane().add(lblAuthors, gbc_lblAuthors);

		txtXxxxyyyyzzzz = new JTextField();
		txtXxxxyyyyzzzz.setText("xxxx,yyyy,zzzz");
		GridBagConstraints gbc_txtXxxxyyyyzzzz = new GridBagConstraints();
		gbc_txtXxxxyyyyzzzz.insets = new Insets(0, 0, 5, 0);
		gbc_txtXxxxyyyyzzzz.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXxxxyyyyzzzz.gridx = 4;
		gbc_txtXxxxyyyyzzzz.gridy = 3;

		frame.getContentPane().add(txtXxxxyyyyzzzz, gbc_txtXxxxyyyyzzzz);
		txtXxxxyyyyzzzz.setColumns(10);

		JLabel lblPublicationYear = new JLabel("publication year");
		GridBagConstraints gbc_lblPublicationYear = new GridBagConstraints();
		gbc_lblPublicationYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublicationYear.gridx = 0;
		gbc_lblPublicationYear.gridy = 4;
		frame.getContentPane().add(lblPublicationYear, gbc_lblPublicationYear);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		frame.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 5;
		frame.getContentPane().add(lblPrice, gbc_lblPrice);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;

		frame.getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		lblCategory = new JLabel("category");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 6;

		frame.getContentPane().add(lblCategory, gbc_lblCategory);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 6;
		frame.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		lblQuantity = new JLabel("quantity");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 7;
		frame.getContentPane().add(lblQuantity, gbc_lblQuantity);

		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 4;
		gbc_textField_6.gridy = 7;

		frame.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		lblThreshold = new JLabel("Threshold");
		GridBagConstraints gbc_lblThreshold = new GridBagConstraints();
		gbc_lblThreshold.insets = new Insets(0, 0, 5, 5);
		gbc_lblThreshold.gridx = 0;
		gbc_lblThreshold.gridy = 8;

		frame.getContentPane().add(lblThreshold, gbc_lblThreshold);

		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 4;
		gbc_textField_7.gridy = 8;

		frame.getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 10;
		btnOk.setVisible(false);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnUpdate_1 = new GridBagConstraints();
		gbc_btnUpdate_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate_1.gridx = 3;
		gbc_btnUpdate_1.gridy = 9;
		btnUpdate.setVisible(false);
		frame.getContentPane().add(btnUpdate, gbc_btnUpdate_1);
		frame.getContentPane().add(btnOk, gbc_btnOk);

	}
}
