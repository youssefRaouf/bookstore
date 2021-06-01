

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingCartContents {

	public JFrame frame;
	public JComboBox Items;
	public JLabel label ;
	public JButton btnRemove;

	/**
	 * Create the application.
	 */
	public ShoppingCartContents() {
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
		
		Items = new JComboBox();
		Items.setBounds(0, 0, 299, 20);
		frame.getContentPane().add(Items);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTotalPrice.setBounds(0, 224, 124, 37);

		
		frame.getContentPane().add(lblTotalPrice);
		
		label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(134, 235, 95, 20);
		frame.getContentPane().add(label);
		
		JButton checkOutButton = new JButton("Check Out");
		checkOutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		checkOutButton.setBounds(239, 224, 129, 37);
		frame.getContentPane().add(checkOutButton);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(320, -1, 89, 23);
		frame.getContentPane().add(btnRemove);
	}
	public void view()
	{
		frame.setVisible(true);		
	}
	
}
