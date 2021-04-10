package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

@SuppressWarnings("serial")
public class clientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private boolean keyPressed = false;
	JLabel lblNewLabel_3 = new JLabel("");
	private JTable table;
	/**
	 * Create the frame.
	 */
	public clientFrame() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This program will get input in english and translate it to another 3 languages");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 414, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Insert Text : ");
		lblNewLabel_2.setBounds(20, 65, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keyPressed = true;
			}
		});
	
	
		textField.setBounds(113, 62, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 414, 168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"English", "Bahasa Malaysia", "Arabic", "Korean"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(149);
		table.getColumnModel().getColumn(1).setPreferredWidth(162);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(155);
		
		scrollPane.setViewportView(table);
		
		
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 309, 414, 70);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("can only detect the words that have in google translate class");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 42, 414, 14);
		contentPane.add(lblNewLabel_4);
		
	}
	
	public String getText() {
		System.out.print(1);
		return textField.getText();
		
	}
	
	public void setText(String text) {
		System.out.print(2);
		lblNewLabel_3.setText(text +" words");
	}
	
	public boolean getButton() {
		System.out.print(3);
		return keyPressed;
	}
	public void setButton() {
		System.out.print(4);
		keyPressed = false;
	}
	
	public void setTranslationText(String text1, String text2, String text3, String text4) {
		table.getModel().setValueAt(text1, 0, 0);
		table.getModel().setValueAt(text2, 0, 1);
		table.getModel().setValueAt(text3, 0, 2);
		table.getModel().setValueAt(text4, 0, 3);
	}
	
	public void setFound(boolean status) {
		
		if(status) {
			lblNewLabel_3.setText("");
			
		}
		else
		{
			lblNewLabel_3.setText("not found ");
		}
	}
}