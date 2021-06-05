package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ShoppingCartContents {

	public JFrame frame;
	public ArrayList<ArrayList<String>> items;
	public JLabel label;
	public JButton btnRemove;
	public JButton checkOutButton;
	public JList list;
	public JButton mainPage;

	/**
	 * Create the application.
	 */
	public ShoppingCartContents() {
		items = new ArrayList();
		initialize();
	}

	public ShoppingCartContents(ArrayList<ArrayList<String>> arrayList) {
		this.items = arrayList;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("frame");

		// create a panel
		JPanel p = new JPanel();

		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTotalPrice.setBounds(0, 224, 124, 37);

		p.add(lblTotalPrice);

		label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(134, 235, 95, 20);
		p.add(label);

		checkOutButton = new JButton("Check Out");
		checkOutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		checkOutButton.setBounds(0, 224, 129, 37);
		p.add(checkOutButton);
		
		mainPage = new JButton("go back to Main Page");
		p.add(mainPage);

		btnRemove = new JButton("Remove");
		btnRemove.setBounds(320, -1, 89, 23);
		p.add(btnRemove);
		list = new JList(items.toArray());
		list.setBounds(0,0, 1000,1000);
		p.add(list);
		frame.add(p);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void setList (ArrayList<ArrayList<String>> newData) {
		ArrayList<String> data = new ArrayList<String>();
		int totalPrice = 0;
		for(int i=0;i<newData.size();i++) {
				ArrayList<String> temp = newData.get(i);
				data.add("ISBN: "+temp.get(4)+",  Title: "+ temp.get(0)+",   Price: "+temp.get(1)+",   Quantity: "+temp.get(5));
				totalPrice += Integer.parseInt(temp.get(1))* Integer.parseInt(temp.get(5));
		}
		list.setListData(data.toArray());
		label.setText(Integer.toString(totalPrice));
	}

}
