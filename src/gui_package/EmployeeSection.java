package gui_package;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EmployeeSection extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private Users users;
    private String loggedInUserEmail;

    // Labels for employee details
    private JLabel empNameLbl;
    private JLabel deptLbl;

    public EmployeeSection(Users users) {
        this.users = users;


        setTitle("Employee Section");
        setBounds(100, 100, 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Title
        JLabel lblViewUsers = new JLabel("VIEW USERS");
        lblViewUsers.setFont(new Font("Arial", Font.BOLD, 16));
        lblViewUsers.setBounds(340, 20, 120, 20);
        contentPane.add(lblViewUsers);

        // Employee Name
        empNameLbl = new JLabel("Employees Dashboard");
        empNameLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        empNameLbl.setBounds(20, 30, 300, 20);
        contentPane.add(empNameLbl);

        // Employee Role
        deptLbl = new JLabel("");
        deptLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        deptLbl.setBounds(20, 50, 300, 20);
        contentPane.add(deptLbl);

        // Table for users
        tableModel = new DefaultTableModel(new Object[]{"First Name", "Last Name", "Email", "Role"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(50, 100, 700, 250);
        contentPane.add(scrollPane);

        // Logout Button
        JButton backBtn = new JButton("Logout");
        backBtn.setBounds(50, 370, 100, 30);
        contentPane.add(backBtn);
        backBtn.addActionListener(e -> {
            dispose();
            new Magellan_Solutions(users).setVisible(true); // Go back to login
        });
        

        // Load user data and details
        loadUserDetails();
        loadUsersIntoTable();
    }

    private void loadUserDetails() {
        String[] userData = users.getUserByEmail(loggedInUserEmail);
    }


    // Load users into the table
    private void loadUsersIntoTable() {
        tableModel.setRowCount(0); // Clear table
        List<User> userList = users.getAllUsers();

        for (User user : userList) {
            if ("Customer Service".equals(user.getRole()) || "IT".equals(user.getRole())) {
                tableModel.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()});
            }
        }
    }

    public static void main(String[] args) {
        Users users = new Users();
        String loggedInUserEmail = "employeeEmail@example.com";
        EventQueue.invokeLater(() -> {
            try {
                EmployeeSection frame = new EmployeeSection(users);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
