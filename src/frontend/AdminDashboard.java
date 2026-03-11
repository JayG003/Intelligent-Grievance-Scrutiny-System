package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends JFrame{

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
    public JPanel counterRow;
    public JPanel c1,c2,c3,c4,c5,c6;
    public JLabel n1,n2,n3,n4,n5,n6;
    public JLabel t1,t2,t3,t4,t5,t6;
    public JLabel Tlabel;
    public JTable table;
    public JScrollPane scrollPane;
    
    String user;
    String role;

    AdminDashboard(String usern, String userRole){
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
        GridBagConstraints gbc = new GridBagConstraints();

        LPanel = new JPanel();
        LPanel.setBackground(new Color(2, 6, 23));
        LPanel.setOpaque(true);
        LPanel.setLayout(new BorderLayout());
        LPanel.setPreferredSize(new Dimension(200, 850));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/userprofile.png"));
        JLabel imageLabel = new JLabel();
        Image img = icon.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel(user);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        roleLabel = new JLabel("Role : " + role);
        roleLabel.setForeground(Color.GRAY);
        roleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Profile = new JPanel();
        Profile.setLayout(new BoxLayout(Profile, BoxLayout.Y_AXIS));
        Profile.setOpaque(false);
        Profile.setBorder(new EmptyBorder(40, 0, 20, 0));
        Profile.setBackground(new Color(15,15,25));

        Profile.add(imageLabel);
        Profile.add(Box.createVerticalStrut(10));
        Profile.add(nameLabel);
        Profile.add(roleLabel);

        SideBar = new JPanel();
        SideBar.setLayout(new GridBagLayout());
        SideBar.setOpaque(false);
        GridBagConstraints lgbc = new GridBagConstraints();
        lgbc.weightx = 0;
        lgbc.gridheight = 1;
        lgbc.gridwidth = 1;
        lgbc.gridx = 0;
        lgbc.gridy = 0;

        ImageIcon btn1 = new ImageIcon(getClass().getResource("/images/dashboard icon.png"));
        Image img1 = btn1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        dashBtn = new JButton(" Dashboard", new ImageIcon(img1));
        dashBtn.setHorizontalAlignment(SwingConstants.LEFT);
        dashBtn.setIconTextGap(15);
        dashBtn.setFocusPainted(false);
        dashBtn.setBorderPainted(false);
        dashBtn.setContentAreaFilled(false);
        dashBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        dashBtn.setForeground(Color.WHITE);
        dashBtn.setOpaque(true);
        dashBtn.setBackground(new Color(96,165,250));
        dashBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(10, 10, 2, 10);
        lgbc.anchor = GridBagConstraints.NORTHWEST;
        SideBar.add(dashBtn,lgbc);
        
        ImageIcon btn2 = new ImageIcon(getClass().getResource("/images/manageM.png"));
        Image img2 = btn2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        grievBtn = new JButton(" Manage Users", new ImageIcon(img2));
        grievBtn.setHorizontalAlignment(SwingConstants.LEFT);
        grievBtn.setIconTextGap(15);
        grievBtn.setFocusPainted(false);
        grievBtn.setBorderPainted(false);
        grievBtn.setContentAreaFilled(false);
        grievBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
        grievBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        grievBtn.setForeground(Color.WHITE);
        lgbc.gridy = 1;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(grievBtn,lgbc);
        
        ImageIcon btn3 = new ImageIcon(getClass().getResource("/images/mygrivances.png"));
        Image img3 = btn3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        mygrievBtn = new JButton(" View Grievances", new ImageIcon(img3));
        mygrievBtn.setHorizontalAlignment(SwingConstants.LEFT);
        mygrievBtn.setIconTextGap(15);
        mygrievBtn.setContentAreaFilled(false);
        mygrievBtn.setFocusPainted(false);
        mygrievBtn.setBorderPainted(true);
        mygrievBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
        mygrievBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mygrievBtn.setForeground(Color.WHITE);

        lgbc.gridy = 2;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(mygrievBtn,lgbc);
        
        ImageIcon btn5 = new ImageIcon(getClass().getResource("/images/profile.png"));
        Image img5 = btn5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        profileBtn = new JButton(" Profile", new ImageIcon(img5));
        profileBtn.setHorizontalAlignment(SwingConstants.LEFT);
        profileBtn.setIconTextGap(15);
        profileBtn.setFocusPainted(false);
        profileBtn.setBorderPainted(true);
        profileBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
        profileBtn.setContentAreaFilled(false);
        profileBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        profileBtn.setForeground(Color.WHITE);
        lgbc.gridy = 4;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(profileBtn,lgbc);
        
        ImageIcon btn6 = new ImageIcon(getClass().getResource("/images/logout.png"));
        Image img6 = btn6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        logoutBtn = new JButton(" Logout", new ImageIcon(img6));
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(15);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(true);
        logoutBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        logoutBtn.setForeground(Color.WHITE);
        lgbc.gridy = 6;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 20, 10);
        SideBar.add(logoutBtn,lgbc);

        // to make all buttons go up at the top of the sidebar
        lgbc.gridy = 5;
        lgbc.weighty = 1;
        lgbc.fill = GridBagConstraints.VERTICAL;

        SideBar.add(Box.createVerticalGlue(), lgbc);//leaves the all extra space bellow not above the buttons

        LPanel.add(Profile,BorderLayout.NORTH);
        LPanel.add(SideBar,BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        
        add(LPanel, gbc);

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

        Rnamelabel = new JLabel("Welcome Back, " + user + "!");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.weightx = 1;
        labelgbc.weighty = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(50,40,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("Role : " + role);
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridx = 0;
        labelgbc.gridy = 1;
        labelgbc.weightx = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(10,40,10,0);
        
        RlabelP.add(Rrolelabel,labelgbc);

        // RPanel.add(RlabelP,BorderLayout.NORTH);
        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;
        RPanel.add(RlabelP, rgbc);

        counterRow = new JPanel(new GridLayout(1,4,20,0));
        counterRow.setBorder(new EmptyBorder(20,40,20,40));
        counterRow.setOpaque(false);
        
        c1 = new JPanel();
        c1.setLayout(new BoxLayout(c1, BoxLayout.Y_AXIS));
        c1.setBackground(new Color(31,41,55));
        c1.setBorder(new EmptyBorder(20,20,20,20));
        n1 = new JLabel("20");
        n1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        n1.setForeground(new Color(59, 130, 246));
        n1.setAlignmentX(Component.CENTER_ALIGNMENT);
        t1 = new JLabel("Total Users");
        t1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t1.setForeground(new Color(59, 130, 246));
        t1.setAlignmentX(Component.CENTER_ALIGNMENT);
        c1.add(n1);
        c1.add(Box.createVerticalStrut(8));
        c1.add(t1);
        
        c2 = new JPanel();
        c2.setLayout(new BoxLayout(c2, BoxLayout.Y_AXIS));
        // c2.setBackground(new Color(35,35,50));
        c2.setBackground(new Color(31,41,55));
        c2.setBorder(new EmptyBorder(20,20,20,20));
        n2 = new JLabel("4");
        n2.setFont(new Font("Segoe UI", Font.BOLD, 28));
        // n2.setForeground(Color.WHITE);
        n2.setForeground(new Color(139, 92, 246));
        n2.setAlignmentX(Component.CENTER_ALIGNMENT);
        t2 = new JLabel("Managers");
        // t2.setForeground(Color.LIGHT_GRAY);
        t2.setForeground(new Color(139, 92, 246));
        t2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t2.setAlignmentX(Component.CENTER_ALIGNMENT);
        c2.add(n2);
        c2.add(Box.createVerticalStrut(8));
        c2.add(t2);
        
        c3 = new JPanel();
        c3.setLayout(new BoxLayout(c3, BoxLayout.Y_AXIS));
        // c3.setBackground(new Color(35,35,50));
        c3.setBackground(new Color(31,41,55));
        c3.setBorder(new EmptyBorder(20,20,20,20));
        n3 = new JLabel("30");
        n3.setFont(new Font("Segoe UI", Font.BOLD, 28));
        // n3.setForeground(Color.WHITE);
        n3.setForeground(new Color(34, 197, 94));
        n3.setAlignmentX(Component.CENTER_ALIGNMENT);
        t3 = new JLabel("Total Grievances");
        // t3.setForeground(Color.LIGHT_GRAY);
        t3.setForeground(new Color(34, 197, 94));
        t3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t3.setAlignmentX(Component.CENTER_ALIGNMENT);
        c3.add(n3);
        c3.add(Box.createVerticalStrut(8));
        c3.add(t3);
        
        c4 = new JPanel();
        c4.setLayout(new BoxLayout(c4, BoxLayout.Y_AXIS));
        // c4.setBackground(new Color(35,35,50));
        c4.setBackground(new Color(31,41,55));
        c4.setBorder(new EmptyBorder(20,20,20,20));
        n4 = new JLabel("10");
        n4.setFont(new Font("Segoe UI", Font.BOLD, 28));
        // n4.setForeground(Color.WHITE);
        n4.setForeground(new Color(245, 158, 11));
        n4.setAlignmentX(Component.CENTER_ALIGNMENT);
        t4 = new JLabel("Pending Grievances");
        // t4.setForeground(Color.LIGHT_GRAY);
        t4.setForeground(new Color(245, 158, 11));
        t4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t4.setAlignmentX(Component.CENTER_ALIGNMENT);
        c4.add(n4);
        c4.add(Box.createVerticalStrut(8));
        c4.add(t4);
        
        c5 = new JPanel();
        c5.setLayout(new BoxLayout(c5, BoxLayout.Y_AXIS));
        c5.setBackground(new Color(31,41,55));
        c5.setBorder(new EmptyBorder(20,20,20,20));
        n5 = new JLabel("5");
        n5.setFont(new Font("Segoe UI", Font.BOLD, 28));
        n5.setForeground(new Color(245, 158, 11));
        n5.setAlignmentX(Component.CENTER_ALIGNMENT);
        t5 = new JLabel("Resolved");
        t5.setForeground(new Color(245, 158, 11));
        t5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t5.setAlignmentX(Component.CENTER_ALIGNMENT);
        c5.add(n5);
        c5.add(Box.createVerticalStrut(8));
        c5.add(t5);
        
        c6 = new JPanel();
        c6.setLayout(new BoxLayout(c6, BoxLayout.Y_AXIS));
        c6.setBackground(new Color(31,41,55));
        c6.setBorder(new EmptyBorder(20,20,20,20));
        n6 = new JLabel("5");
        n6.setFont(new Font("Segoe UI", Font.BOLD, 28));
        n6.setForeground(new Color(245, 158, 11));
        n6.setAlignmentX(Component.CENTER_ALIGNMENT);
        t6 = new JLabel("Pending");
        t6.setForeground(new Color(245, 158, 11));
        t6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        t6.setAlignmentX(Component.CENTER_ALIGNMENT);
        c6.add(n6);
        c6.add(Box.createVerticalStrut(8));
        c6.add(t6);

        counterRow.add(c1);
        counterRow.add(c2);
        counterRow.add(c3);
        counterRow.add(c4);
        counterRow.add(c5);
        counterRow.add(c6);

        rgbc.gridy = 1;
        rgbc.insets = new Insets(10,0,10,0);
        RPanel.add(counterRow, rgbc);

        Tlabel = new JLabel("Recent Grievances");
        Tlabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        Tlabel.setForeground(new Color(0, 102, 204));
        // Tlabel.setBorder(new EmptyBorder(10,20,5,0));

        rgbc.gridy = 2;
        rgbc.insets = new Insets(10,40,10,0);
        RPanel.add(Tlabel, rgbc);

        String[] columns = {
            "Grievance ID",
            "User Name",
            "Assigned Manager",
            "Category",
            "Status",
            "Date Submitted"
        };

        String[][] data = {
            {"11", "Jay Ware", "Manager A", "Academic Issue", "Open", "07-03-2026"},
            {"12", "Rohit Sharma", "Manager B", "Result Correction", "Pending", "07-03-2026"},
            {"13", "Priya Patel", "Manager C", "Healthcare Service", "Open", "08-03-2026"},
            {"14", "Amit Verma", "Manager A", "Government Scheme", "Resolved", "08-03-2026"},
            {"15", "Sneha Kulkarni", "Manager B", "Hall Ticket Issue", "Pending", "08-03-2026"},
            {"16", "Arjun Mehta", "Manager C", "Water Supply Issue", "Resolved", "09-03-2026"},
            {"17", "Karan Singh", "Manager A", "Transport Service", "Open", "09-03-2026"},
            {"18", "Neha Joshi", "Manager B", "Internal Marks Issue", "Pending", "09-03-2026"}
        };

        table = new JTable(new DefaultTableModel(data, columns));
        table.getTableHeader().setPreferredSize(new Dimension(0,40));
        table.getTableHeader().setBackground(new Color(30, 41, 59));
        table.getTableHeader().setForeground(new Color(248, 250, 252));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        table.setRowHeight(35);
        table.setBackground(new Color(17, 24, 39));
        table.setForeground(new Color(229, 231, 235));
        table.setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setGridColor(new Color(55, 65, 81, 180));
        table.setSelectionBackground(new Color(59,130,246));
        table.setSelectionForeground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(17,24,39));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(55,65,81)));
        scrollPane.setBorder(null);

        rgbc.gridy = 3;
        rgbc.weightx = 1;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.BOTH;
        rgbc.insets = new Insets(0,40,40,40);
        RPanel.add(scrollPane,rgbc);

        add(RPanel, gbc);

        // ============== Mouse Liatners ==============//
        dashBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                dashBtn.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                dashBtn.setBackground(new Color(96,165,250));
            }
        });

        mygrievBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mygrievBtn.setBorderPainted(true);
                mygrievBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                mygrievBtn.setBorderPainted(true);
                mygrievBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(2, 6, 23), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
        });

        profileBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                profileBtn.setBorderPainted(true);
                profileBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                profileBtn.setBorderPainted(true);
                profileBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(2, 6, 23), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
        });

        logoutBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                logoutBtn.setBorderPainted(true);
                logoutBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                logoutBtn.setBorderPainted(true);
                logoutBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(2, 6, 23), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
        });
        
        //================ACTION LISTNERS=================//

        mygrievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AViewGrievances(user, role);
                dispose();
            }
        });
        grievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageUsers(user, role);
                dispose();
            }
        });
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminProfile(user,role);
                dispose();
            }
        });
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        String usern = "JayG";
        new AdminDashboard(usern, "Manager");
    }
}