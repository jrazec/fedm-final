package gui_package;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class Magellan_Solutions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private Map<String, String> credentials;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
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
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("Magellan's Solutions");
        lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblTitle.setBounds(290, 49, 195, 35);
        contentPane.add(lblTitle);
        
        JLabel lblUsername = new JLabel("Enter username:");
        lblUsername.setBounds(280, 150, 129, 16);
        contentPane.add(lblUsername);
        
        usernameField = new JTextField();
        usernameField.setBounds(410, 145, 130, 26);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Enter password:");
        lblPassword.setBounds(280, 200, 129, 16);
        contentPane.add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(410, 195, 130, 26);
        contentPane.add(passwordField);
        
        JLabel lblRole = new JLabel("Select role:");
        lblRole.setBounds(280, 250, 129, 16);
        contentPane.add(lblRole);
        
        roleComboBox = new JComboBox<>();
        roleComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Admin", "Manager", "Employee"}));
        roleComboBox.setBounds(410, 245, 131, 27);
        contentPane.add(roleComboBox);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 300, 100, 30);
        contentPane.add(loginButton);
        
        initializeCredentials();
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void initializeCredentials() {
        credentials = new HashMap<>();
        credentials.put("Admin", "Admin123");
        credentials.put("Manager", "Manager123");
        credentials.put("Employee", "Employee123");
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String selectedRole = (String) roleComboBox.getSelectedItem();
        
        if (credentials.containsKey(selectedRole) && credentials.get(selectedRole).equals(password) && username.equals(selectedRole)) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + selectedRole + "!");
            showWelcomeScreen(username);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showWelcomeScreen(String username) {
        contentPane.removeAll();
        contentPane.repaint();
        contentPane.revalidate();
        
        JLabel welcomeLabel = new JLabel("Welcome " + username + "!");
        welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        welcomeLabel.setBounds(300, 200, 300, 50);
        contentPane.add(welcomeLabel);
    }
}