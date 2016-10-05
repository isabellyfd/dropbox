package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class InitialFrame {

	private JFrame frame;

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
	}
}
