package gui_package;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;

public class Magellan_Solutions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private static Users users;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                users = new Users(); 
                Magellan_Solutions frame = new Magellan_Solutions();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Magellan_Solutions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 808, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(30, 144, 255)); 
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Magellan's Solutions");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(270, 30, 300, 35);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(250, 120, 120, 25);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(380, 120, 150, 25);
        contentPane.add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(250, 170, 120, 25);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(380, 170, 150, 25);
        contentPane.add(passwordField);

        JLabel lblRole = new JLabel("Select Role:");
        lblRole.setForeground(Color.WHITE);
        lblRole.setBounds(250, 220, 120, 25);
        contentPane.add(lblRole);

        roleComboBox = new JComboBox<>(new String[]{"Customer Service Department", "IT Department", "Manager", "Admin"});
        roleComboBox.setBounds(380, 220, 150, 25);
        contentPane.add(roleComboBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(340, 280, 120, 30);
        loginButton.setBackground(Color.WHITE);
        contentPane.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String selectedRole = (String) roleComboBox.getSelectedItem();

        if (users.validateUser(username, password, selectedRole)) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + selectedRole + "!");
            redirectToSection(selectedRole);
            dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void redirectToSection(String role) {
        switch (role) {
            case "Admin":
                new AdminSection(users).setVisible(true);
                break;
            case "Manager":
                new ManagerSection().setVisible(true);
                break;
            case "Customer Service Department":
            case "IT Department":
                new EmployeeSection().setVisible(true);
                break;
        }
    }

}

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String password;

    public User(String firstName, String lastName, String email, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getFullName() {
        return firstName+ " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}


class Users {
    private Map<String, String> credentials;
    private Map<String, String> roles;
    private List<User> userList;

    public Users() {
        credentials = new HashMap<>();
        roles = new HashMap<>();
        userList = new ArrayList<>();

        // Predefined users
        addUser("Admin", "", "admin", "Admin", "12345");
        addUser("John", "Doe", "manager@gmail.com", "Manager", "12345");
        addUser("Jane", "Smith", "salesrep1@gmail.com", "Customer Service Department", "12345");
        addUser("Mike", "Johnson", "it1@gmail.com", "IT Department", "12345");
    }

    public boolean validateUser(String username, String password, String role) {
        return credentials.containsKey(username.toLowerCase()) &&
                credentials.get(username.toLowerCase()).equals(password) &&
                roles.get(username.toLowerCase()).equals(role);
    }

    public void addUser(String firstName, String lastName, String email, String role, String password) {
        User newUser = new User(firstName, lastName, email, role, password);
        userList.add(newUser);
        credentials.put(email.toLowerCase(), password);
        roles.put(email.toLowerCase(), role);
    }

    public List<User> getAllUsers() {
        return userList;
    }


}


