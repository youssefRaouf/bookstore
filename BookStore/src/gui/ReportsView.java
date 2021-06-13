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
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReportsView {
	
	public JList list;
	public JFrame frame;
	public ArrayList<ArrayList<String>> items;
	public JButton managerPage;
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
		list = new JList(items.toArray());
		list.setBounds(0,0, 1000,1000);
		p.add(list);
		managerPage = new JButton("go back to Manager Page");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 10;
		p.add(managerPage,gbc_btnOk);
		frame.add(p);
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	//needs to be editied
	public void setList (ArrayList<String> newData) {
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0;i<newData.size();i++) {
				data.add(newData.get(i));	
		}
		list.setListData(data.toArray());
		
	}
}
