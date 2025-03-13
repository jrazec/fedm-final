package gui_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class EmployeePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePage frame = new EmployeePage();
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
	public EmployeePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel introLbl = new JLabel("Hi,");
		introLbl.setBounds(16, 6, 195, 35);
		introLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(introLbl);
		
		JLabel empNameLbl = new JLabel("emp Name here..");
		empNameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		empNameLbl.setBounds(16, 30, 276, 25);
		contentPane.add(empNameLbl);
		
		JLabel deptLbl = new JLabel("role, here");
		deptLbl.setBounds(16, 53, 61, 16);
		contentPane.add(deptLbl);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 81, 61, 16);
		contentPane.add(lblNewLabel);
	}

}
