package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.User;
import javax.swing.JLabel;
import controler.Controler;
public class UserFrame {

	private JFrame frame;
	private User user;
	private Controler controler;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame window = new UserFrame(null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 */
	public UserFrame(User user, Controler controler) {
		this.user = user;
		this.controler = controler;
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
		
		JLabel lblHello = new JLabel("Hello, " + this.user.getName());
		lblHello.setBounds(29, 19, 401, 16);
		
		frame.getContentPane().add(lblHello);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

}
