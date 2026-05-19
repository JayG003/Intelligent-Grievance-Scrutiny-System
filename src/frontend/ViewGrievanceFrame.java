package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class ViewGrievanceFrame extends JFrame {

    public ViewGrievanceFrame(String[] d){

        setTitle("View Grievance");
        setSize(900, 700);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(15,23,42));

        // ===== TITLE =====
        JLabel title = new JLabel("Grievance Details", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(20,0,20,0));
        main.add(title, BorderLayout.NORTH);

        // ===== CARD PANEL =====
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(30,41,59));
        card.setBorder(new EmptyBorder(20,40,20,40));

        // ===== SECTIONS =====
        card.add(section("Applicant Information",
                "Name", d[3],
                "Mobile", d[4],
                "Email", d[5]
        ));

        card.add(section("Grievance Details",
                "Subject", d[2],
                "Description", d[6],
                "Organization", d[1]
        ));

        card.add(extraSection(d));

        card.add(section("Status Info",
                "Status", d[11],
                "Priority", d[12]
        ));

        JScrollPane scroll = new JScrollPane(card);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(15,23,42));

        main.add(scroll, BorderLayout.CENTER);

        add(main);
        setVisible(true);
    }

    // ===== GENERIC SECTION =====
    private JPanel section(String title, String... data){

        JPanel panel = new JPanel(new GridLayout(data.length/2, 2, 10, 10));
        panel.setBackground(new Color(30,41,59));
        panel.setBorder(new CompoundBorder(
                new EmptyBorder(15,0,15,0),
                new MatteBorder(0,0,1,0,new Color(75,85,99))
        ));

        JLabel heading = new JLabel(title);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 18));
        heading.setForeground(new Color(96,165,250));

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(new Color(30,41,59));
        wrapper.add(heading, BorderLayout.NORTH);
        wrapper.add(panel, BorderLayout.CENTER);

        for(int i=0;i<data.length;i+=2){
            panel.add(label(data[i]));
            if(data[i].equalsIgnoreCase("Description")){
                panel.add(wrappedValue(data[i+1]));
            }else{
                panel.add(value(data[i+1]));
            }
        }

        return wrapper;
    }

    // ===== ORGANIZATION BASED SECTION =====
    private JPanel extraSection(String[] d){

        String org = d[1];

        if(org.equalsIgnoreCase("Educational")){
            return section("Educational Info",
                    "Institute", d[7],
                    "Student ID", d[8],
                    "Department", d[9],
                    "Academic Year", d[10]
            );
        }
        else if(org.equalsIgnoreCase("Health-care")){
            return section("Healthcare Info",
                    "Hospital", d[7],
                    "Patient ID", d[8],
                    "Department", d[9],
                    "Visit Date", d[10]
            );
        }
        else if(org.equalsIgnoreCase("Municipal")){
            return section("Municipal Info",
                    "Ward", d[7],
                    "Location", d[8],
                    "Landmark", d[9],
                    "Area Type", d[10]
            );
        }
        else{
            return section("Welfare Info",
                    "Scheme", d[7],
                    "Application ID", d[8],
                    "Beneficiary", d[9],
                    "Income Category", d[10]
            );
        }
    }

    // ===== LABEL STYLE =====
    private JLabel label(String text){
        JLabel l = new JLabel(text + " :");
        l.setForeground(Color.LIGHT_GRAY);
        l.setFont(new Font("Segoe UI", Font.BOLD, 13));
        return l;
    }

    // ===== VALUE STYLE =====
    private JLabel value(String text){
        JLabel v = new JLabel(text);
        v.setForeground(Color.WHITE);
        v.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        return v;
    }
    private JComponent wrappedValue(String text){

    JTextArea area = new JTextArea(text);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
    area.setEditable(false);
    area.setForeground(Color.WHITE);
    area.setBackground(new Color(30,41,59));
    area.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    area.setBorder(null);

    return area;
}
}