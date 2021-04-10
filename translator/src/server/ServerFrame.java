package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.TextArea;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_1 = new JLabel("Connection Status : Waitting for connection...");
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 148);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server");
		lblNewLabel.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 25, 414, 44);
		contentPane.add(lblNewLabel_1);
	}

	public void setConnectionStatus(boolean flag) {
		if(flag) {
			lblNewLabel_1.setText("Connection Status : Connected");
		}
		else {
			lblNewLabel_1.setText("Connection Status : Waitting for connection...");
		}
	}
}