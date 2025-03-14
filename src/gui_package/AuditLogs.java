package gui_package;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AuditLogs extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable logsTable;
    private DefaultTableModel tableModel;
    private static Users users;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AuditLogs frame = new AuditLogs(users);
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
    public AuditLogs(Users users) {
        setTitle("Audit Logs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Audit Logs");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(320, 20, 200, 30);
        contentPane.add(lblTitle);

        // Table for logs
        tableModel = new DefaultTableModel(new Object[]{"Timestamp", "Action"}, 0);
        logsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(logsTable);
        scrollPane.setBounds(50, 70, 700, 300);
        contentPane.add(scrollPane);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 400, 100, 30);
        contentPane.add(backButton);
        backButton.addActionListener(e -> {
        	dispose();
        	new AdminSection(users).setVisible(true); 
        	
        });


        loadLogs(); 
    }

    private void loadLogs() {
        tableModel.setRowCount(0);
        List<String> logs = LogsHandler.getLogs();
        for (String log : logs) {
            String[] parts = log.split(" - ", 2);
            if (parts.length == 2) {
                tableModel.addRow(new Object[]{parts[0], parts[1]});
            }
        }
    }
}
