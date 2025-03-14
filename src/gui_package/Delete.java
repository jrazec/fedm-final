package gui_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailTxt;
	private JTable userToDeleteTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteUsers = new JLabel("DELETE USERS");
		lblDeleteUsers.setBounds(212, 47, 221, 16);
		contentPane.add(lblDeleteUsers);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(25, 117, 221, 26);
		contentPane.add(emailTxt);
		
		JLabel lblFindEmail = new JLabel("Find email:");
		lblFindEmail.setBounds(25, 101, 221, 16);
		contentPane.add(lblFindEmail);
		
		JButton searchEmailBtn = new JButton("Find");
		searchEmailBtn.setBounds(297, 117, 117, 29);
		contentPane.add(searchEmailBtn);
		
		JLabel foundLbl = new JLabel("User Found/User Not Found");
		foundLbl.setBounds(35, 155, 221, 16);
		contentPane.add(foundLbl);
		
		// Here, it will only show once it is queried and foudn a user
		JButton deleteUserButton = new JButton("Delete");
		deleteUserButton.setBounds(249, 279, 117, 29);
		contentPane.add(deleteUserButton);
		
		userToDeleteTable = new JTable();
		userToDeleteTable.setBounds(36, 253, 559, 20);
		contentPane.add(userToDeleteTable);
		// if not found, display here none
	}

}
