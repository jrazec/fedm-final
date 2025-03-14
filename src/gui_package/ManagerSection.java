package gui_package;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ManagerSection extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private JTextField searchEmailTxt;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JTextField passwordTxt;
    private JComboBox<String> roleComboBox;
    private JLabel foundLbl;
    private Users users;

    public ManagerSection() {
        users = new Users(); // Load user data

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Manager - View & Update Users");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(250, 10, 300, 30);
        contentPane.add(lblTitle);

        // Table setup
        String[] columnNames = {"First Name", "Last Name", "Email", "Role"};
        tableModel = new DefaultTableModel(columnNames, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(30, 50, 720, 200);
        contentPane.add(scrollPane);
        loadUsersIntoTable();

        // Search Field
        JLabel lblSearch = new JLabel("Search by Email:");
        lblSearch.setBounds(180, 276, 120, 25);
        contentPane.add(lblSearch);

        searchEmailTxt = new JTextField();
        searchEmailTxt.setBounds(300, 276, 180, 25);
        contentPane.add(searchEmailTxt);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(490, 276, 100, 25);
        contentPane.add(searchButton);

        foundLbl = new JLabel("");
        foundLbl.setBounds(30, 300, 300, 25);
        contentPane.add(foundLbl);

        // Update Section
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(30, 337, 100, 25);
        contentPane.add(lblFirstName);

        firstNameTxt = new JTextField();
        firstNameTxt.setBounds(130, 337, 150, 25);
        contentPane.add(firstNameTxt);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(302, 337, 100, 25);
        contentPane.add(lblLastName);

        lastNameTxt = new JTextField();
        lastNameTxt.setBounds(400, 337, 225, 25);
        contentPane.add(lastNameTxt);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 367, 100, 25);
        contentPane.add(lblPassword);

        passwordTxt = new JTextField();
        passwordTxt.setBounds(130, 367, 150, 25);
        contentPane.add(passwordTxt);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(302, 367, 100, 25);
        contentPane.add(lblRole);

        roleComboBox = new JComboBox<>(new String[]{"Customer Service", "IT", "Manager"});
        roleComboBox.setBounds(400, 367, 225, 25);
        contentPane.add(roleComboBox);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(637, 337, 120, 55);
        contentPane.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(30, 421, 100, 30);
        contentPane.add(backButton);

        // Search action
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = searchEmailTxt.getText().trim().toLowerCase();
                String[] user = users.getUserByEmail(email);
                if (user == null) {
                    foundLbl.setText("User not found!");
                } else {
                    foundLbl.setText("User found!");
                    firstNameTxt.setText(user[0]);
                    lastNameTxt.setText(user[1]);
                    passwordTxt.setText(user[4]);
                    roleComboBox.setSelectedItem(user[3]);
                }
            }
        });

        // Update action
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = searchEmailTxt.getText().trim().toLowerCase();
                String firstName = firstNameTxt.getText();
                String lastName = lastNameTxt.getText();
                String password = passwordTxt.getText();
                String role = (String) roleComboBox.getSelectedItem();

                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                users.updateUser(email, firstName, lastName, role, password);
                foundLbl.setText("User updated successfully!");
                loadUsersIntoTable();
                // LOGGIN THIS ONE OUT HUHU TOOK ME YEARS JUST TO CREATE THIS ONE LINER.. 
                LogsHandler.addLog("Manager updated user: " + email);
            }
        });

        // Back action
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  
                new Magellan_Solutions(users).setVisible(true);
            }
        });
    }

    private void loadUsersIntoTable() {
        tableModel.setRowCount(0);
        List<User> userList = users.getAllUsers();
        for (User user : userList) {
            tableModel.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()});
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerSection frame = new ManagerSection();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}