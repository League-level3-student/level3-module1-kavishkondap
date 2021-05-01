package _05_Intro_To_Hash_Maps;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */
	HashMap <Integer, String> users = new HashMap ();
	 JFrame frame = new JFrame ();
	 JPanel panel = new JPanel ();
	 JButton add = new JButton ("Add");
	 JButton search = new JButton ("Search");
	 JButton view = new JButton ("View");
	 JButton remove = new JButton ("Remove");
	public static void main(String[] args) {
		_02_LogSearch runner = new _02_LogSearch ();
		runner.run ();
	}
	public void run () {
		frame.add(panel);
		panel.add(view);
		panel.add(add);
		panel.add(search);
		panel.add(remove);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		view.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		search.addActionListener(this);
		frame.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == add) {
			String id = JOptionPane.showInputDialog(null, "Enter an ID number");
			String name = null;
				name = JOptionPane.showInputDialog(null, "Enter a name");
			users.put(Integer.parseInt(id), name);
		}	
		if (arg0.getSource() == view) {
			//Set keys =  users.keySet ();
			String allNames = "USERS: \n";
			for (Integer num :  users.keySet()) {
				allNames += "ID: " + num + " Name: " + users.get(num) + "\n";
			}
			JOptionPane.showMessageDialog(null, allNames);
			
		}
		if (arg0.getSource() == remove) {
			String id = JOptionPane.showInputDialog(null, "Enter an ID");
			if (users.containsKey(Integer.parseInt(id))) {
				users.remove(Integer.parseInt (id));
			}else {
				JOptionPane.showMessageDialog(null, "ID not found");
			}
		}
		if (arg0.getSource() == search) {
			String id = JOptionPane.showInputDialog(null, "Enter an ID");
			if (users.containsKey(Integer.parseInt(id))) {
				JOptionPane.showMessageDialog (null, "ID: " + id + " Name: " + users.get(Integer.parseInt (id)));
			}else {
				JOptionPane.showMessageDialog(null, "ID not found");
			}
		}
		}
	}
	
	

