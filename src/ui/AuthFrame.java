package ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import controler.Controler;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.User;

public class AuthFrame {

	private JFrame frame;
	private Controler controler;
	private JTextField textField;
	private User user;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthFrame window = new AuthFrame(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AuthFrame(Controler controler) {
		initialize();
		this.controler = controler;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Put your code in this field:");
		lblNewLabel.setBounds(141, 72, 172, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(116, 115, 221, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(169, 180, 117, 29);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceptUser();
				goToNextFrame();
			}
		});
		frame.getContentPane().add(btnGo);
	
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void acceptUser() {
		String code = this.textField.getText();
		this.textField.setText("");
		this.user = this.controler.finishAuth(code);
	}
	
	public void goToNextFrame() {
		this.frame.setVisible(false);
		UserFrame userFrame = new UserFrame(this.user, this.controler);
		userFrame.getFrame().setVisible(true);
	}

}
