package gui_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.util.regex.Pattern;

public class Update extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchEmail;
    private JTextField oldEmailToChangeTxt;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JTextField passwordTxt;
    private JComboBox<String> roleComboBox;
    private JLabel foundLbl;
    private JLabel errPasswordLbl;
    private Users users;  

    private String oldTxt = "";
    private static final Color PRIMARY_COLOR = new Color(60, 141, 188);
    private static final Color ACCENT_COLOR = new Color(245, 245, 245);
    private static final Color SUCCESS_COLOR = new Color(0, 166, 90);
    private static final Color ERROR_COLOR = new Color(221, 75, 57);
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);


    public Update(Users users) {
        this.users = users; 

        setTitle("User Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel lblUpdateUsers = new JLabel("UPDATE USERS");
        lblUpdateUsers.setFont(HEADER_FONT);
        lblUpdateUsers.setForeground(Color.WHITE);
        lblUpdateUsers.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblUpdateUsers, BorderLayout.CENTER);
        
        JButton backButton = new JButton("Back");
        backButton.setFont(BUTTON_FONT);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(PRIMARY_COLOR);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        headerPanel.add(backButton, BorderLayout.WEST);
        
        contentPane.add(headerPanel, BorderLayout.NORTH);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        searchPanel.setBackground(ACCENT_COLOR);
        searchPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                "Search User",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                LABEL_FONT,
                PRIMARY_COLOR));
        
        GridBagConstraints searchGbc = new GridBagConstraints();
        searchGbc.insets = new Insets(10, 10, 10, 10);
        searchGbc.fill = GridBagConstraints.HORIZONTAL;
        
        searchGbc.gridx = 0;
        searchGbc.gridy = 0;
        searchGbc.weightx = 0.3;
        JLabel lblNewLabel = new JLabel("Enter email:");
        lblNewLabel.setFont(LABEL_FONT);
        searchPanel.add(lblNewLabel, searchGbc);
        
        searchGbc.gridx = 1;
        searchGbc.gridy = 0;
        searchGbc.weightx = 0.5;
        searchEmail = new JTextField();
        searchEmail.setFont(LABEL_FONT);
        searchEmail.setColumns(20);
        searchPanel.add(searchEmail, searchGbc);
        
        searchGbc.gridx = 2;
        searchGbc.gridy = 0;
        searchGbc.weightx = 0.2;
        JButton searchEmailBtn = new JButton("Find");
        searchEmailBtn.setFont(BUTTON_FONT);
        searchEmailBtn.setBackground(PRIMARY_COLOR);
        searchEmailBtn.setForeground(Color.WHITE);
        searchEmailBtn.setFocusPainted(false);
        searchPanel.add(searchEmailBtn, searchGbc);
        
        searchGbc.gridx = 0;
        searchGbc.gridy = 1;
        searchGbc.gridwidth = 3;
        foundLbl = new JLabel("");
        foundLbl.setFont(LABEL_FONT);
        searchPanel.add(foundLbl, searchGbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        mainPanel.add(searchPanel, gbc);
        
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridBagLayout());
        updatePanel.setBackground(ACCENT_COLOR);
        updatePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                "Update User Information",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                LABEL_FONT,
                PRIMARY_COLOR));
        
        GridBagConstraints updateGbc = new GridBagConstraints();
        updateGbc.insets = new Insets(10, 10, 10, 10);
        updateGbc.fill = GridBagConstraints.HORIZONTAL;
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 0;
        updateGbc.weightx = 0.5;
        JLabel lblEnterNewEmail = new JLabel("Update email:");
        lblEnterNewEmail.setFont(LABEL_FONT);
        updatePanel.add(lblEnterNewEmail, updateGbc);
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 1;
        oldEmailToChangeTxt = new JTextField();
        oldEmailToChangeTxt.setFont(LABEL_FONT);
        oldEmailToChangeTxt.setEditable(false);
        oldEmailToChangeTxt.setBackground(new Color(220, 220, 220));
        updatePanel.add(oldEmailToChangeTxt, updateGbc);
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 2;
        JLabel lblFirstName = new JLabel("Update first name:");
        lblFirstName.setFont(LABEL_FONT);
        updatePanel.add(lblFirstName, updateGbc);
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 3;
        firstNameTxt = new JTextField();
        firstNameTxt.setFont(LABEL_FONT);
        updatePanel.add(firstNameTxt, updateGbc);
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 4;
        JLabel lblLastName = new JLabel("Update last name:");
        lblLastName.setFont(LABEL_FONT);
        updatePanel.add(lblLastName, updateGbc);
        
        updateGbc.gridx = 0;
        updateGbc.gridy = 5;
        lastNameTxt = new JTextField();
        lastNameTxt.setFont(LABEL_FONT);
        updatePanel.add(lastNameTxt, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 0;
        JLabel lblRole = new JLabel("Choose role/department:");
        lblRole.setFont(LABEL_FONT);
        updatePanel.add(lblRole, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 1;
        roleComboBox = new JComboBox<>(new String[]{"Admin", "Manager", "Customer Service Department", "IT Department"});
        roleComboBox.setFont(LABEL_FONT);
        updatePanel.add(roleComboBox, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 2;
        JLabel lblUpdatePassword = new JLabel("Update password:");
        lblUpdatePassword.setFont(LABEL_FONT);
        updatePanel.add(lblUpdatePassword, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 3;
        passwordTxt = new JPasswordField();
        passwordTxt.setFont(LABEL_FONT);
        updatePanel.add(passwordTxt, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 4;
        errPasswordLbl = new JLabel("");
        errPasswordLbl.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        errPasswordLbl.setForeground(ERROR_COLOR);
        updatePanel.add(errPasswordLbl, updateGbc);
        
        updateGbc.gridx = 1;
        updateGbc.gridy = 5;
        updateGbc.anchor = GridBagConstraints.EAST;
        JButton updateButton = new JButton("Update");
        updateButton.setFont(BUTTON_FONT);
        updateButton.setBackground(SUCCESS_COLOR);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updatePanel.add(updateButton, updateGbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        mainPanel.add(updatePanel, gbc);

        // SEARCHING AN EMAIL AND SETTING THEIR RECORD
        searchEmailBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = searchEmail.getText().trim().toLowerCase();
                if (!isValidEmail(email)) {
                    foundLbl.setText("Invalid email format");
                    return;
                }

                String[] user = users.getUserByEmail(email);
                if (user == null) {
                    foundLbl.setText("No user found");
                } else {
                    foundLbl.setText("User found");
                    oldEmailToChangeTxt.setText(user[2]); // email(ACTING AS PRIMARY KEY)
                    firstNameTxt.setText(user[0]); // fname
                    lastNameTxt.setText(user[1]); // lnamee
                    passwordTxt.setText(user[4]); // Password of user
                    roleComboBox.setSelectedItem(user[3]); // Role/ deptt
                    oldTxt = user[2];
                }
            }
        });

        // Updatingg the user
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordTxt.getText().length() < 8) {
                    errPasswordLbl.setText("Password must be at least 8 characters!");
                    return;
                }

                String email = oldEmailToChangeTxt.getText();
                String firstName = firstNameTxt.getText();
                String lastName = lastNameTxt.getText();
                String password = passwordTxt.getText();
                String role = (String) roleComboBox.getSelectedItem();

                users.updateUser(email, firstName, lastName, role, password);
                foundLbl.setText("User updated successfully!");
                LogsHandler.addLog("Admin updated user: " + oldTxt);
            }
        });


        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new AdminSection(users).setVisible(true); 
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }
}
