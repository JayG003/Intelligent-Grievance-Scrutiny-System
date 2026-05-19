package frontend;

import database.JDBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class AViewGrievances extends JFrame{
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
    public JLabel Instructions;
    public JPanel FormP;
    public JLabel Category;
    public JComboBox<String> Categoryl;
    public JComboBox<String> Categoryl1;
    public JComboBox<String> Categoryl2;
    public JButton filter1;
    public JTable table;
    public JScrollPane scrollPane;
    public JButton View;
    public JButton Update;
    public JTextField searchField;
    public JButton searcBtn;
    
    String user;
    String role;

    AViewGrievances(String usern, String userRole){
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

        LPanel = new JPanel();
        LPanel.setBackground(new Color(2, 6, 23));
        LPanel.setOpaque(true);
        LPanel.setLayout(new BorderLayout());
        LPanel.setPreferredSize(new Dimension(200, 850));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/mygrivances.png"));
        JLabel imageLabel = new JLabel();
        Image img = icon.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel(" Grievances");
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
        dashBtn.setOpaque(false);
        dashBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
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
        grievBtn.setBorderPainted(true);
        grievBtn.setContentAreaFilled(false);
        grievBtn.setOpaque(false);
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
        mygrievBtn.setFocusPainted(false);
        mygrievBtn.setBorderPainted(false);
        mygrievBtn.setContentAreaFilled(false);
        mygrievBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mygrievBtn.setOpaque(true);
        mygrievBtn.setBackground(new Color(96,165,250));
        mygrievBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
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

        Rnamelabel = new JLabel("All Grievances");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.weightx = 1;
        labelgbc.weighty = 0;
        labelgbc.anchor = GridBagConstraints.NORTH;
        labelgbc.insets = new Insets(10,0,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("You can see all the Grievance to be solve");
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridx = 0;
        labelgbc.gridy = 1;
        labelgbc.weightx = 0;
        labelgbc.anchor = GridBagConstraints.NORTH;
        labelgbc.insets = new Insets(10,0,40,0);
        
        RlabelP.add(Rrolelabel,labelgbc);

        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;
        RPanel.add(RlabelP, rgbc);

        FormP = new GlassPanel(30);
        ((GlassPanel) FormP).setRoundRight(false);
        ((GlassPanel) FormP).setGlassBackground(new Color(128, 159, 255, 20));
        ((GlassPanel) FormP).setGlassBorder(new Color(255, 255, 255, 60));
        FormP.setLayout(new GridBagLayout());
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.anchor = GridBagConstraints.NORTHWEST;
        rgbc.weightx = 1;
        rgbc.weighty = 1;
        rgbc.gridx = 0;
        rgbc.gridy = 2;
        rgbc.fill = GridBagConstraints.BOTH;
        rgbc.insets = new Insets(10,40,10,40);

        RPanel.add(FormP, rgbc);

        searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBackground(new Color(68, 68, 85));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 0;
        fgbc.gridx = 0;
        fgbc.gridwidth = 4;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(30,20,30,10);
        FormP.add(searchField, fgbc);

        searcBtn = new JButton("Search");
        searcBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searcBtn.setBackground(new Color(96,165,250));
        searcBtn.setForeground(Color.WHITE);
        searcBtn.setFocusPainted(false);
        searcBtn.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        searcBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridx = 4;
        fgbc.gridwidth = 1;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.insets = new Insets(30,0,30,20);
        FormP.add(searcBtn, fgbc);
        
        String[] catagories = {
                "Filter By category",
                "Educational",
                "Health-care",
                "Municipal",
                "Well-Fare"
        };
        
        Categoryl = new JComboBox<>(catagories);
        Categoryl.setBackground(new Color(40, 40, 50));
        Categoryl.setForeground(Color.WHITE);
        Categoryl.setPreferredSize(new Dimension(160,28));
        fgbc.gridy = 1;
        fgbc.gridx = 0;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(0,20,30,10);
        FormP.add(Categoryl, fgbc);
        
        String[] catagories1 = {
                "Filter By Priority",
                "High",
                "Low"
        };

        Categoryl1 = new JComboBox<>(catagories1);
        Categoryl1.setBackground(new Color(40, 40, 50));
        Categoryl1.setForeground(Color.WHITE);
        Categoryl1.setPreferredSize(new Dimension(160,28));
        fgbc.gridx = 1;
        fgbc.insets = new Insets(0,10,30,10);
        FormP.add(Categoryl1, fgbc);
        
        String[] catagories2 = {
                "Filter By Status",
                "Unattended",
                "Under Scrutiny",
                "Resolved",
                "Rejected",
                "Canceled"
        };

        Categoryl2 = new JComboBox<>(catagories2);
        Categoryl2.setBackground(new Color(40, 40, 50));
        Categoryl2.setForeground(Color.WHITE);
        Categoryl2.setPreferredSize(new Dimension(160,28));
        fgbc.gridx = 2;
        fgbc.insets = new Insets(0,10,30,10);
        FormP.add(Categoryl2, fgbc);

        filter1 = new JButton("Filter");
        filter1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filter1.setBackground(new Color(96,165,250));
        filter1.setForeground(Color.WHITE);
        filter1.setFocusPainted(false);
        filter1.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        filter1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridx = 3;
        fgbc.insets = new Insets(0,10,30,20);
        FormP.add(filter1, fgbc);

        String[] columns = {
            "Grievance ID",
            "Applicant Name",
            "Mobile",
            "Organization",
            "Subject",
            "Priority",
            "Status"
        };

        JDBC db = new JDBC();
        String[][] data = db.getUserGrievances(user);

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for(int i = 0; i < data.length; i++){

            if(data[i][0] == null) break;

                model.addRow(new Object[]{
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    data[i][3],
                    data[i][4],
                    data[i][5],
                    data[i][6]
            });
        }
        table = new JTable(model);
        table.getTableHeader().setPreferredSize(new Dimension(0,40));
        table.getTableHeader().setBackground(new Color(30, 41, 59));
        table.getTableHeader().setForeground(new Color(248, 250, 252));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        table.setRowHeight(30);
        table.setBackground(new Color(17, 24, 39));
        table.setForeground(new Color(229, 231, 235));
        table.setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setGridColor(new Color(55, 65, 81, 180));
        table.setSelectionBackground(new Color(59,130,246));
        table.setSelectionForeground(Color.WHITE);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(17,24,39));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(55,65,81)));
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(0,350));


        fgbc.gridy = 2;
        fgbc.gridx = 0;
        fgbc.gridwidth = 5;
        fgbc.weightx = 1;
        fgbc.weighty = 1;
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.insets = new Insets(0,20,10,40);
        FormP.add(scrollPane,fgbc);

        View = new JButton("View");
        View.setFont(new Font("Segoe UI", Font.BOLD, 14));
        View.setBackground(new Color(96,165,250));
        View.setForeground(Color.WHITE);
        View.setFocusPainted(false);
        View.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        View.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridy = 3;
        fgbc.gridx = 0;
        fgbc.gridwidth = 1;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(10,20,20,0);
        FormP.add(View, fgbc);
        add(RPanel, gbc);

        // ============== Mouse Liatners ==============//
        dashBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                dashBtn.setBorderPainted(true);
                dashBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                dashBtn.setBorderPainted(true);
                dashBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(2, 6, 23), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
        });

        mygrievBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mygrievBtn.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                mygrievBtn.setBackground(new Color(96,165,250));
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

        dashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDashboard(user, role);
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
        filter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String category = Categoryl.getSelectedItem().toString();
                String priority = Categoryl1.getSelectedItem().toString();
                String status = Categoryl2.getSelectedItem().toString();

                // 🔥 DAO call
                Object[][] data = database.JDBC.getFilteredGrievances(user,role,category, priority, status);

                // 🔥 Table columns (same order hona chahiye)
                String[] columns = {
                    "Grievance ID",
                    "Applicant Name",
                    "Mobile",
                    "Subject",
                    "Organization",
                    "Status",
                    "Priority"
                };

                // 🔥 Table update
                DefaultTableModel model = new DefaultTableModel(data, columns);
                table.setModel(model);
            }
        });
        filter1.doClick();
    }
    public static void main(String[] args) {
        new AViewGrievances("user", "Grievancer");
    }
}