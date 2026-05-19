package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NotificationDetailFrame extends JFrame {

    public NotificationDetailFrame(String[] d){

        setTitle("Notification");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(15,23,42));

        // ===== TITLE =====
        JLabel title = new JLabel("Notification Details", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(20,0,20,0));
        main.add(title, BorderLayout.NORTH);

        // ===== CONTENT =====
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(30,41,59));
        content.setBorder(new EmptyBorder(20,30,20,30));

        content.add(label("Grievance ID: " + d[2]));
        content.add(Box.createVerticalStrut(10));

        content.add(label("Date: " + d[6]));
        content.add(Box.createVerticalStrut(20));

        content.add(label("Message:"));
        content.add(Box.createVerticalStrut(10));

        JTextArea msgArea = new JTextArea(d[4]);
        msgArea.setLineWrap(true);
        msgArea.setWrapStyleWord(true);
        msgArea.setEditable(false);
        msgArea.setForeground(Color.WHITE);
        msgArea.setBackground(new Color(30,41,59));
        msgArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        msgArea.setBorder(null);

        content.add(msgArea);

        main.add(content, BorderLayout.CENTER);

        add(main);
        setVisible(true);
    }

    private JLabel label(String text){
        JLabel l = new JLabel(text);
        l.setForeground(Color.LIGHT_GRAY);
        l.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return l;
    }
}