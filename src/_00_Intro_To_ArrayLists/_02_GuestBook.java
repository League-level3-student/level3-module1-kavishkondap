package _00_Intro_To_ArrayLists;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	static JFrame frame = new JFrame ();
	static JPanel panel = new JPanel ();
	static JButton add = new JButton ();
	static JButton view = new JButton ();
	public static void main(String[] args) {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		frame.setVisible (true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		view.addActionListener(new _02_GuestBook ());
		add.addActionListener(new _02_GuestBook ());

	}
}
