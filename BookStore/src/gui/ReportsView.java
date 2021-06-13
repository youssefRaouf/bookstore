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

public class ReportsView {
	
	public JList list;
	public JFrame frame;
	public ArrayList<ArrayList<String>> items;
	
	public ReportsView() {
		items = new ArrayList();
		initialize();
	}

	public ReportsView(ArrayList<ArrayList<String>> arrayList) {
		this.items = arrayList;
		initialize();
	}
	private void initialize() {
		frame = new JFrame("frame");

		// create a panel
		JPanel p = new JPanel();

		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTotalPrice.setBounds(0, 224, 124, 37);
		p.add(lblTotalPrice);
		
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
	
	//needs to be editied
	public void setList (ArrayList<String> newData) {
		ArrayList<String> data = new ArrayList<String>();
		int totalPrice = 0;
		for(int i=0;i<newData.size();i++) {
				//ArrayList<String> temp = newData.get(i);
				data.add(newData.get(i));
				//totalPrice += Integer.parseInt(temp.get(1))* Integer.parseInt(temp.get(5));
		}
		list.setListData(data.toArray());
		//label.setText(Integer.toString(totalPrice));
	}
}
