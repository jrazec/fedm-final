package gui_package;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Magellan_Solutions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private static Users users;

    private static final Color PRIMARY_COLOR = new Color(120, 134, 199);
    private static final Color SECONDARY_COLOR = new Color(240, 240, 240);
    private static final Color ACCENT_COLOR = new Color(255, 102, 0);
    private static final Color TEXT_COLOR = Color.WHITE;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        EventQueue.invokeLater(() -> {
            try {
                users = new Users(); 
                Magellan_Solutions frame = new Magellan_Solutions(users);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Magellan_Solutions(Users users) {
    	this.users = users;
        setTitle("Magellan Solutions - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setResizable(false);
        
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, PRIMARY_COLOR, 0, h, new Color(45, 51, 107));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, w, h);
            }
        };
        contentPane.setBackground(new Color(45, 51, 107));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(169, 181, 223));
        loginPanel.setBounds(298, 119, 300, 350);
        contentPane.add(loginPanel);

        JLabel lblTitle = new JLabel("Magellan's Solutions");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(TEXT_COLOR);
        lblTitle.setBounds(310, 50, 300, 40);
        contentPane.add(lblTitle);

        JLabel lblLoginTitle = new JLabel("User Login");
        lblLoginTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblLoginTitle.setForeground(new Color(45, 51, 107));
        lblLoginTitle.setBounds(110, 20, 150, 30);
        loginPanel.add(lblLoginTitle);

        JLabel lblUsername = new JLabel("Email:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUsername.setForeground(new Color(45, 51, 107));
        lblUsername.setBounds(50, 70, 100, 20);
        loginPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 10));
        usernameField.setBounds(50, 95, 200, 30);
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        loginPanel.add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPassword.setForeground(new Color(45, 51, 107));
        lblPassword.setBounds(50, 135, 100, 20);
        loginPanel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 10));
        passwordField.setBounds(50, 160, 200, 30);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        loginPanel.add(passwordField);

        JLabel lblRole = new JLabel("Select Role:");
        lblRole.setFont(new Font("Arial", Font.PLAIN, 14));
        lblRole.setForeground(new Color(45, 51, 107));
        lblRole.setBounds(50, 200, 100, 20);
        loginPanel.add(lblRole);

        roleComboBox = new JComboBox<>(new String[]{"Customer Service", "IT", "Manager", "Admin"});
        roleComboBox.setFont(new Font("Arial", Font.PLAIN, 10));
        roleComboBox.setBounds(50, 225, 200, 30);
        roleComboBox.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        roleComboBox.setBackground(Color.WHITE);
        loginPanel.add(roleComboBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 280, 200, 35);
        loginButton.setBackground(new Color(45, 51, 107));
        loginButton.setForeground(new Color(255, 242, 242));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(null);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(loginButton);

        JLabel lblFooter = new JLabel("© 2025 Magellan Solutions. All rights reserved.");
        lblFooter.setFont(new Font("Arial", Font.PLAIN, 12));
        lblFooter.setForeground(TEXT_COLOR);
        lblFooter.setBounds(310, 520, 300, 20);
        contentPane.add(lblFooter);

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
            case "Customer Service":
                new EmployeeSection(users).setVisible(true);
                break;
            case "IT":
                new EmployeeSection(users).setVisible(true);
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
    private String task;

    public User(String firstName, String lastName, String email, String role, String password,String task) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email.toLowerCase();
        this.role = role;
        this.password = password;
        this.task = task;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getPassword() { return password; }
    public String getTaskToUser() { return password; }
    

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setRole(String role) { this.role = role; }
    public void setPassword(String password) { this.password = password; }
    public void setTaskToUser(String task) { this.task = task ; }
}

class Users {
    private Map<String, String> credentials;
    private Map<String, String> roles;
    private List<User> userList;

    public Users() {
        credentials = new HashMap<>();
        roles = new HashMap<>();
        userList = new ArrayList<>();

        // Predefined Users
        addUser("Admin", "AdminA", "admin@gmail.com", "Admin", "12345678");
        addUser("John Razec", "Agno", "manager@gmail.com", "Manager", "12345678");
        addUser("Justine Cedrick", "Ambal", "salesrep1@gmail.com", "Customer Service", "12345678");
        addUser("Christine Grace", "Mendoza", "it1@gmail.com", "IT", "12345678");
    }

    public boolean validateUser(String email, String password, String role) {
        email = email.toLowerCase();
        return credentials.containsKey(email) &&
               credentials.get(email).equals(password) &&
               roles.get(email).equals(role);
    }

    public void addUser(String firstName, String lastName, String email, String role, String password) {
        email = email.toLowerCase();
        User newUser = new User(firstName, lastName, email, role, password,"");
        userList.add(newUser);
        credentials.put(email, password);
        roles.put(email, role);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList); 
    }

    public String[] getUserByEmail(String email) {
        for (User user : userList) { 
            if (user.getEmail().equalsIgnoreCase(email)) { 
                return new String[]{
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getRole(),
                    user.getPassword()
                };
            }
        }
        return null; 
    }


    public void updateUser(String email, String firstName, String lastName, String role, String password) {
        email = email.toLowerCase();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setRole(role);
                user.setPassword(password);
                credentials.put(email, password); 
                roles.put(email, role);
                break;
            }
        }
    }
    
    public void setTask(String email, String task) {
        email = email.toLowerCase();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                user.setTaskToUser(task);
     
                break;
            }
        }
    }
    public boolean deleteUserByEmail(String email) {
        return userList.removeIf(user -> user.getEmail().equalsIgnoreCase(email));
    }
    
    public class AuditLog {
        private static final List<String> logs = new ArrayList<>();

        public static void addLog(String action) {
            logs.add(action);
        }

        public static List<String> getLogs() {
            return new ArrayList<>(logs);
        }

        public static void clearLogs() {
            logs.clear();
        }
    }

}





