package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

import controler.Controler;

public class InitialFrame {
	
	private JFrame frame;
	private Controler controler;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialFrame window = new InitialFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controler = new Controler();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThisApplicationIs = DefaultComponentFactory.getInstance().createLabel("This application is created by Isabelly");
		lblThisApplicationIs.setBounds(105, 256, 244, 16);
		frame.getContentPane().add(lblThisApplicationIs);
		
		JLabel lblLabel = DefaultComponentFactory.getInstance().createLabel("<html><body align=\"center\">Clink in this link above to allow<br>this application to access your dropbox</body></html>");
		lblLabel.setBounds(99, 86, 250, 45);
		
		frame.getContentPane().add(lblLabel);
		
		JButton btnLink = new JButton("Link");
		btnLink.setBounds(162, 157, 117, 29);
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDropboxURL();
				goToNextFrame();
			}
		});
		
		frame.getContentPane().add(btnLink);
		
		
	}
	
	public void openDropboxURL(){
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(this.controler.getDropboxAuthURL()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void goToNextFrame() {
		this.frame.setVisible(false);
		AuthFrame auth = new AuthFrame(this.controler);
		auth.getFrame().setVisible(true);
	}
}
