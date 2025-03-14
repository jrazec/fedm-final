package gui_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchEmail;
	private JTextField oldEmailToChangeTxt;
	private JTextField textField;
	private JTextField oldLastNameToChangeTxt;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchEmail = new JTextField();
		searchEmail.setColumns(10);
		searchEmail.setBounds(30, 114, 221, 26);
		contentPane.add(searchEmail);
		
		JLabel lblNewLabel = new JLabel("Enter email:");
		lblNewLabel.setBounds(30, 98, 221, 16);
		contentPane.add(lblNewLabel);
		
		JLabel foundLbl = new JLabel("User Found/User Not Found");
		foundLbl.setBounds(40, 152, 221, 16);
		contentPane.add(foundLbl);
		
		oldEmailToChangeTxt = new JTextField();
		oldEmailToChangeTxt.setColumns(10);
		oldEmailToChangeTxt.setBounds(30, 224, 221, 26);
		contentPane.add(oldEmailToChangeTxt);
		
		JLabel lblEnterNewEmail = new JLabel("Update email:");
		lblEnterNewEmail.setBounds(30, 207, 221, 16);
		contentPane.add(lblEnterNewEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 284, 221, 26);
		contentPane.add(textField);
		
		JLabel oldFirstNameToChangeTxt = new JLabel("Update first name:");
		oldFirstNameToChangeTxt.setBounds(30, 267, 221, 16);
		contentPane.add(oldFirstNameToChangeTxt);
		
		oldLastNameToChangeTxt = new JTextField();
		oldLastNameToChangeTxt.setColumns(10);
		oldLastNameToChangeTxt.setBounds(30, 344, 221, 26);
		contentPane.add(oldLastNameToChangeTxt);
		
		JLabel lblUpdateLastName = new JLabel("Update last name:");
		lblUpdateLastName.setBounds(30, 327, 221, 16);
		contentPane.add(lblUpdateLastName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(301, 284, 221, 26);
		contentPane.add(textField_2);
		
		JLabel lblUpdatePassword = new JLabel("Update password:");
		lblUpdatePassword.setBounds(301, 267, 221, 16);
		contentPane.add(lblUpdatePassword);
		
		JComboBox oldRoleToChangeTxt = new JComboBox();
		oldRoleToChangeTxt.setBounds(301, 223, 259, 27);
		contentPane.add(oldRoleToChangeTxt);
		
		JLabel lblEnterEmployeeDepartment = new JLabel("Choose role/department:");
		lblEnterEmployeeDepartment.setBounds(301, 206, 221, 16);
		contentPane.add(lblEnterEmployeeDepartment);
		
		JLabel errorEmailLbl = new JLabel("valid or invalid, or check if there are any same email heree");
		errorEmailLbl.setBounds(40, 248, 221, 16);
		contentPane.add(errorEmailLbl);
		
		JLabel errPasswordLbl = new JLabel("8 min char");
		errPasswordLbl.setBounds(301, 310, 221, 16);
		contentPane.add(errPasswordLbl);
		
		JButton searchEmailBtn = new JButton("Find");
		searchEmailBtn.setBounds(302, 114, 117, 29);
		contentPane.add(searchEmailBtn);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(302, 344, 117, 29);
		contentPane.add(updateButton);
		
		JLabel lblUpdateUsers = new JLabel("UPDATE USERS");
		lblUpdateUsers.setBounds(217, 44, 221, 16);
		contentPane.add(lblUpdateUsers);
	}
}
