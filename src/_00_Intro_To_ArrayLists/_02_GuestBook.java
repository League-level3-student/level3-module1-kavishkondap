package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	/*
	 * Create a GUI with two buttons. One button reads "Add Name" and the other
	 * button reads "View Names". When the add name button is clicked, display an
	 * input dialog that asks the user to enter a name. Add that name to an
	 * ArrayList. When the "View Names" button is clicked, display a message dialog
	 * that displays all the names added to the list. Format the list as follows:
	 * Guest #1: Bob Banders Guest #2: Sandy Summers Guest #3: Greg Ganders Guest
	 * #4: Donny Doners
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("ADD");
	JButton view = new JButton("VIEW");
	ArrayList<String> names = new ArrayList();

	public static void main(String[] args) {
		new _02_GuestBook().run ();
	}
	public void run () {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		view.addActionListener(this);
		add.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == add) {
			String name = JOptionPane.showInputDialog(null, "What is the name that you would like to add to the guest book?");
			names.add(name);
		}
		if (arg0.getSource () == view) {
			String displayer = "";
			for (int i = 0; i < names.size(); i++) {
				displayer += "\nGuest #" + (i+1) + " " + names.get (i);
			}
			JOptionPane.showMessageDialog (null, displayer);
		}
		}
}
