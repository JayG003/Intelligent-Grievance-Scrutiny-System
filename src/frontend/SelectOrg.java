package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SelectOrg extends JFrame{
    public JPanel LPanel;
    public JPanel Profile;
    public JLabel nameLabel;
    public JLabel roleLabel;
    public JPanel SideBar;
    public JButton dashBtn;
    public JButton grievBtn;
    public JButton mygrievBtn;
    public JButton notifyBtn;
    public JButton profileBtn;
    public JButton logoutBtn;

    public JPanel RPanel;
    public JPanel RlabelP;
    public JLabel Rnamelabel;
    public JLabel Rrolelabel;
    public JLabel Rrole;
    public JButton droplist;
    public JLabel OR;
    public JPanel counterRow;
    public JPanel c1,c2,c3,c4;
    public JLabel n1,n2,n3,n4;
    public JLabel t1,t2,t3,t4;
    public JLabel Tlabel;
    public JTable table;
    public JScrollPane scrollPane;
    
    String user;
    String role;
    String selected;

    SelectOrg(String usern, String userRole){
        this.user = usern;
        this.role = userRole;
        initializeFrame();
        AddPanels();
        setVisible(true);
    }
    void initializeFrame(){
        setTitle("User Dashbord");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 850);
        setLocationRelativeTo(null);
        setResizable(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        if (icon.getIconWidth() > 0) {
            setIconImage(icon.getImage());
        }

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
    }

    void AddPanels(){

        if(user.equals("user")){
           role = "Grievancer";
        }

        GridBagConstraints gbc = new GridBagConstraints();

        //__________LEFT PANEL__________//

        UserSideBar sidebar = new UserSideBar(user, role, "grievBtn");
        add(sidebar.LPanel);
        sidebar.LPanel.setMinimumSize(new Dimension(260, getHeight()));

        //__________RIGHT PANEL__________//

        RPanel = new JPanel();
        RPanel.setOpaque(true);
        RPanel.setBackground(new Color(15, 23, 42));
        RPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        GridBagConstraints rgbc = new GridBagConstraints();
        rgbc.gridx = 0;
        rgbc.fill = GridBagConstraints.HORIZONTAL;
        rgbc.anchor = GridBagConstraints.NORTHWEST;
        
        RlabelP = new JPanel();
        RlabelP.setLayout(new GridBagLayout());
        RlabelP.setOpaque(true);
        RlabelP.setBackground(new Color(17,24,39));

        GridBagConstraints labelgbc = new GridBagConstraints();

        Rnamelabel = new JLabel("Submite New Grievance");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.weightx = 1;
        labelgbc.weighty = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(50,400,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("Please select the department related to your grievance.");
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridx = 0;
        labelgbc.gridy = 1;
        labelgbc.weightx = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(10,370,60,0);
        
        RlabelP.add(Rrolelabel,labelgbc);

        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;
        RPanel.add(RlabelP, rgbc);

        String[] departments = {
                "Select Department",
                "Educational",
                "Healthcare",
                "Municipal",
                "WellFare"
        };

        JComboBox<String> comboBox = new JComboBox<>(departments);
        comboBox.setPreferredSize(new Dimension(250, 40));

        rgbc.gridy = 1;
        rgbc.gridx = 0;
        rgbc.insets = new Insets(10,250,10,250);
        RPanel.add(comboBox, rgbc);

        droplist = new JButton("Submit");
        droplist.setPreferredSize(new Dimension(0, 40));
        droplist.setOpaque(true);
        droplist.setBorderPainted(false);
        droplist.setFocusPainted(false);
        droplist.setForeground(Color.WHITE);
        droplist.setBackground(new Color(96,165,250));

        rgbc.gridy = 2;
        rgbc.gridx = 0;
        rgbc.insets = new Insets(10,400,10,400);
        RPanel.add(droplist, rgbc);

        OR = new JLabel("OR");
        OR.setFont(new Font("Times new Roman",Font.BOLD,20));
        OR.setForeground(Color.WHITE);
        rgbc.gridy = 3;
        rgbc.gridx = 0;
        rgbc.insets = new Insets(30,580,20,300);
        RPanel.add(OR, rgbc);

        counterRow = new JPanel(new GridLayout(2,2,20,20));
        counterRow.setBorder(new EmptyBorder(20,250,20,250));
        counterRow.setOpaque(false);
        
        c1 = new JPanel();
        c1.setLayout(new BoxLayout(c1, BoxLayout.Y_AXIS));
        c1.setBackground(new Color(31,41,55));
        c1.setBorder(new EmptyBorder(20,20,20,20));
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/c1.png"));
        Image g1 = i1.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
        n1 = new JLabel(new ImageIcon(g1));
        n1.setAlignmentX(Component.CENTER_ALIGNMENT);
        t1 = new JLabel("Education");
        t1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        t1.setForeground(new Color(59, 130, 246));
        t1.setAlignmentX(Component.CENTER_ALIGNMENT);
        c1.add(n1);
        c1.add(Box.createVerticalStrut(8));
        c1.add(t1);
        
        c2 = new JPanel();
        c2.setLayout(new BoxLayout(c2, BoxLayout.Y_AXIS));
        c2.setBackground(new Color(31,41,55));
        c2.setBorder(new EmptyBorder(20,20,20,20));
        ImageIcon i2 = new ImageIcon(getClass().getResource("/images/c2.png"));
        Image g2 = i2.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        n2 = new JLabel(new ImageIcon(g2));
        n2.setAlignmentX(Component.CENTER_ALIGNMENT);
        t2 = new JLabel("Healthcare");
        t2.setForeground(new Color(139, 92, 246));
        t2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t2.setAlignmentX(Component.CENTER_ALIGNMENT);
        c2.add(n2);
        c2.add(Box.createVerticalStrut(8));
        c2.add(t2);
        
        c3 = new JPanel();
        c3.setLayout(new BoxLayout(c3, BoxLayout.Y_AXIS));
        c3.setBackground(new Color(31,41,55));
        c3.setBorder(new EmptyBorder(20,20,20,20));
        ImageIcon i3 = new ImageIcon(getClass().getResource("/images/c3.png"));
        Image g3 = i3.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        n3 = new JLabel(new ImageIcon(g3));
        n3.setAlignmentX(Component.CENTER_ALIGNMENT);
        t3 = new JLabel("Municipal");
        t3.setForeground(new Color(34, 197, 94));
        t3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t3.setAlignmentX(Component.CENTER_ALIGNMENT);
        c3.add(n3);
        c3.add(Box.createVerticalStrut(8));
        c3.add(t3);
        
        c4 = new JPanel();
        c4.setLayout(new BoxLayout(c4, BoxLayout.Y_AXIS));
        c4.setBackground(new Color(31,41,55));
        c4.setBorder(new EmptyBorder(20,20,20,20));
        ImageIcon i4 = new ImageIcon(getClass().getResource("/images/c4.png"));
        Image g4 = i4.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        n4 = new JLabel(new ImageIcon(g4));
        n4.setAlignmentX(Component.CENTER_ALIGNMENT);
        t4 = new JLabel("WellFare");
        t4.setForeground(new Color(245, 158, 11));
        t4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t4.setAlignmentX(Component.CENTER_ALIGNMENT);
        c4.add(n4);
        c4.add(Box.createVerticalStrut(8));
        c4.add(t4);

        counterRow.add(c1);
        counterRow.add(c2);
        counterRow.add(c3);
        counterRow.add(c4);

        rgbc.gridy = 4;
        rgbc.insets = new Insets(10,0,10,0);
        RPanel.add(counterRow, rgbc);

        add(RPanel, gbc);

        // ============== Mouse Liatners ==============//
        c1.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                c1.setBackground(new Color(2, 6, 23));
            }
            public void mouseExited(MouseEvent e){
                c1.setBackground(new Color(31,41,55));
            }
            public void mouseClicked(MouseEvent e){
                selected = "Educational";
                new FormPage(selected, user, role);
                dispose();
            }
        });
        c2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                c2.setBackground(new Color(2, 6, 23));
            }
            public void mouseExited(MouseEvent e){
                c2.setBackground(new Color(31,41,55));
            }
            public void mouseClicked(MouseEvent e){
                selected = "Healthcare";
                new FormPage(selected, user, role);
                dispose();
            }
        });
        c3.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                c3.setBackground(new Color(2, 6, 23));
            }
            public void mouseExited(MouseEvent e){
                c3.setBackground(new Color(31,41,55));
            }
            public void mouseClicked(MouseEvent e){
                selected = "Municipal";
                new FormPage(selected, user, role);
                dispose();
            }
        });
        c4.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                c4.setBackground(new Color(2, 6, 23));
            }
            public void mouseExited(MouseEvent e){
                c4.setBackground(new Color(31,41,55));
            }
            public void mouseClicked(MouseEvent e){
                selected = "WellFare";
                new FormPage(selected, user, role);
                dispose();
            }
        });

        //================ACTION LISTNERS=================//
        droplist.addActionListener(e -> {
            selected = (String) comboBox.getSelectedItem();
            new FormPage(selected, user, role);
            dispose();
        });
    }
    public static void main(String[] args) {
        new SelectOrg("User", "Grievancer");
    }
}