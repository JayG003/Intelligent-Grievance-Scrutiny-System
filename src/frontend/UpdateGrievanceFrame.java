package frontend;

import database.JDBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UpdateGrievanceFrame extends JFrame {

    JComboBox<String> statusBox;
    JTextArea reasonArea;
    JTextArea noticeArea;
    JLabel contactLabel;
    JLabel authoritycontact;
    JButton updateBtn;
    JButton cancelBtn;

    int grievanceId;

    public UpdateGrievanceFrame(int grievanceId) {
        this.grievanceId = grievanceId;

        setTitle("Update Grievance Status");
        setSize(700, 750);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout());

        // Load and set icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        if (icon.getIconWidth() > 0) {
            setIconImage(icon.getImage());
        }

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(15, 23, 42));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Header panel with logo
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 41, 59));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        JLabel logoLabel = new JLabel();
        Image logo = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(logo));

        JLabel titleLabel = new JLabel("Update Grievance Status");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(0, 15, 0, 0));

        headerPanel.add(logoLabel, BorderLayout.WEST);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(15, 23, 42));
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBorder(new EmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // 🔹 Fetch grievance data
        String[] data = JDBC.getGrievanceById(String.valueOf(grievanceId));

        // 🔹 Contact Info
        String contact = "Mobile: " + data[4] + " | Email: " + data[5];
        contactLabel = new JLabel(contact);
        contactLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contactLabel.setForeground(new Color(200, 200, 200));
        JLabel contactTitleLabel = new JLabel("User Contact Information");
        contactTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        contactTitleLabel.setForeground(new Color(96, 165, 250));

        gbc.gridy = 0;
        contentPanel.add(contactTitleLabel, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 15, 0);
        contentPanel.add(contactLabel, gbc);

        // 🔹 Status Dropdown
        JLabel statusTitleLabel = new JLabel("Select New Status");
        statusTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        statusTitleLabel.setForeground(new Color(96, 165, 250));

        String[] statuses = {"Under Scrutiny", "Resolved", "Rejected"};
        statusBox = new JComboBox<>(statuses);
        statusBox.setBackground(new Color(40, 40, 50));
        statusBox.setForeground(Color.WHITE);
        statusBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        statusBox.setPreferredSize(new Dimension(200, 35));

        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 5, 0);
        contentPanel.add(statusTitleLabel, gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 0, 15, 0);
        contentPanel.add(statusBox, gbc);

        // 🔹 Reason TextArea
        JLabel reasonTitleLabel = new JLabel("Reason for Status Change");
        reasonTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        reasonTitleLabel.setForeground(new Color(96, 165, 250));

        reasonArea = new JTextArea(4, 30);
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);
        reasonArea.setBackground(new Color(30, 41, 59));
        reasonArea.setForeground(new Color(229, 231, 235));
        reasonArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        reasonArea.setBorder(new LineBorder(new Color(55, 65, 81), 1));
        reasonArea.setMargin(new Insets(8, 8, 8, 8));
        reasonArea.setCaretColor(Color.WHITE);

        JScrollPane reasonScroll = new JScrollPane(reasonArea);
        reasonScroll.getViewport().setBackground(new Color(30, 41, 59));
        reasonScroll.setBorder(null);

        gbc.gridy = 4;
        gbc.insets = new Insets(10, 0, 5, 0);
        contentPanel.add(reasonTitleLabel, gbc);
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 0, 15, 0);
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        contentPanel.add(reasonScroll, gbc);

        // 🔹 Notice TextArea
        JLabel noticeTitleLabel = new JLabel("Notice to Authority");
        noticeTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        noticeTitleLabel.setForeground(new Color(96, 165, 250));

        String contact1 = "Email: " + data[10];
        authoritycontact = new JLabel(contact1);
        authoritycontact.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        authoritycontact.setForeground(new Color(200, 200, 200));
        JLabel contactTitleLabel1 = new JLabel("Authority Contact Information");
        contactTitleLabel1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        contactTitleLabel1.setForeground(new Color(96, 165, 250));
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 5, 0);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(contactTitleLabel1, gbc);
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 5, 0);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(authoritycontact, gbc);

        noticeArea = new JTextArea(4, 30);
        noticeArea.setLineWrap(true);
        noticeArea.setWrapStyleWord(true);
        noticeArea.setBackground(new Color(30, 41, 59));
        noticeArea.setForeground(new Color(229, 231, 235));
        noticeArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        noticeArea.setBorder(new LineBorder(new Color(55, 65, 81), 1));
        noticeArea.setMargin(new Insets(8, 8, 8, 8));
        noticeArea.setCaretColor(Color.WHITE);

        JScrollPane noticeScroll = new JScrollPane(noticeArea);
        noticeScroll.getViewport().setBackground(new Color(30, 41, 59));
        noticeScroll.setBorder(null);

        gbc.gridy = 8;
        gbc.insets = new Insets(10, 0, 5, 0);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(noticeTitleLabel, gbc);
        gbc.gridy = 9;
        gbc.insets = new Insets(5, 0, 20, 0);
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        contentPanel.add(noticeScroll, gbc);

        // 🔹 Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(15, 23, 42));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        updateBtn = new JButton("Update Status");
        updateBtn.setBackground(new Color(96, 165, 250));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        updateBtn.setFocusPainted(false);
        updateBtn.setBorder(BorderFactory.createEmptyBorder(8, 30, 8, 30));
        updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(75, 85, 99));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorder(BorderFactory.createEmptyBorder(8, 30, 8, 30));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonPanel.add(updateBtn);
        buttonPanel.add(cancelBtn);

        gbc.gridy = 10;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(buttonPanel, gbc);

        // Add panels to main
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);


        // ================= ACTION LISTENERS ================= //
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String status = statusBox.getSelectedItem().toString();
                String reason = reasonArea.getText().trim();
                String notice = noticeArea.getText().trim();

                // 🔥 Validation
                if(reason.isEmpty()){
                    JOptionPane.showMessageDialog(
                            UpdateGrievanceFrame.this,
                            "Reason for status change is required!",
                            "Validation Error",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                boolean success = JDBC.updateGrievanceStatus(
                        grievanceId,
                        status,
                        reason,
                        notice
                );
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}