package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ManageUsers extends JFrame{
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
    public JPanel FormP;
    public JTextField searchField;
    
    String user;
    String role;

    ManageUsers(String usern, String userRole){
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/profile.png"));
        JLabel imageLabel = new JLabel();
        Image img = icon.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Profile");
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
        grievBtn.setBorderPainted(false);
        grievBtn.setContentAreaFilled(false);
        grievBtn.setOpaque(true);
        grievBtn.setBackground(new Color(96,165,250));
        grievBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
        // grievBtn.setOpaque(false);
        // grievBtn.setBorder(
        //     BorderFactory.createCompoundBorder(
        //         new LineBorder(new Color(2, 6, 23), 2),
        //         new EmptyBorder(8, 15, 8, 10)
        //     )
        // );
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
        mygrievBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
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
        profileBtn.setBorderPainted(false);
        profileBtn.setContentAreaFilled(false);
        // profileBtn.setOpaque(true);
        // profileBtn.setBackground(new Color(96,165,250));
        // profileBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
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
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;
        
        add(LPanel, gbc);

        //__________RIGHT PANEL__________//

        RPanel = new JPanel();
        RPanel.setOpaque(true);
        RPanel.setBackground(new Color(13, 17, 31));
        RPanel.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(RPanel, gbc);

        JLabel titleLabel = new JLabel("Manage users", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.gridx = 0;
        titleGbc.gridy = 0;
        titleGbc.insets = new Insets(40,0,20,0);
        titleGbc.anchor = GridBagConstraints.NORTH;

        RPanel.add(titleLabel, titleGbc);

        FormP = new GlassPanel(20); // Using your custom GlassPanel class
        ((GlassPanel) FormP).setGlassBackground(new Color(30, 41, 59, 150));
        ((GlassPanel) FormP).setGlassBorder(new Color(255, 255, 255, 30));
        FormP.setLayout(new GridBagLayout());
        GridBagConstraints fgbc = new GridBagConstraints();
        
        JPanel filterRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        filterRow.setOpaque(false);

        String[] roles = {"All", "Users", "Managers"};
        JComboBox<String> roleFilter = new JComboBox<>(roles);
        roleFilter.setBackground(new Color(40, 40, 50));
        roleFilter.setForeground(Color.WHITE);
        roleFilter.setPreferredSize(new Dimension(160,28));
        filterRow.add(new JLabel("Filter Role") {{ setForeground(Color.LIGHT_GRAY); }});
        filterRow.add(roleFilter);

        searchField = new JTextField(20);
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
        filterRow.add(searchField);

        // JButton addUserBtn = createStyledButton("+ Search", new Color(59, 130, 246));
        // JButton addMgrBtn = createStyledButton("+ Add Manager", new Color(59, 130, 246));
        JButton search = new JButton("Search");
        search.setBackground(new Color(59, 130, 246));
        search.setForeground(Color.WHITE);
        search.setFocusPainted(false);
        search.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        search.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton addMgrBtn = new JButton("Add Manager");
        addMgrBtn.setBackground(new Color(59, 130, 246));
        addMgrBtn.setForeground(Color.WHITE);
        addMgrBtn.setFocusPainted(false);
        addMgrBtn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        addMgrBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton blockBtn = new JButton("Block");
        blockBtn.setBackground(new Color(239, 68, 68));
        blockBtn.setForeground(Color.WHITE);
        blockBtn.setFocusPainted(false);
        blockBtn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        blockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton unblockBtn = new JButton("Unblock");
        unblockBtn.setBackground(new Color(34, 197, 94));
        unblockBtn.setForeground(Color.WHITE);
        unblockBtn.setFocusPainted(false);
        unblockBtn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        unblockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        filterRow.add(search);
        filterRow.add(blockBtn);
        filterRow.add(unblockBtn);
        filterRow.add(addMgrBtn);

        fgbc.gridx = 0;
        fgbc.gridy = 0;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(20, 20, 10, 20);
        FormP.add(filterRow, fgbc);

        String[] columns = {"User ID", "Name", "Email", "Mobile", "Role", "Status", "Action"};
        Object[][] data = {
            {"USR-001", "John Doe", "john.doe@email.com", "555-0101", "USER", "ACTIVE", "Actions..."},
            {"MGR-002", "Alice Smith", "alice.smith@email.com", "555-0102", "MANAGER", "ACTIVE", "Actions..."},
            {"USR-004", "Eve Williams", "eve.williams@email.com", "555-0104", "USER", "DISABLED", "Actions..."}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table = new JTable(new DefaultTableModel(data, columns));
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

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(17,24,39));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(55,65,81)));
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(0,350));
        
        fgbc.gridy = 1;
        fgbc.weighty = 1;
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.insets = new Insets(10, 20, 10, 20);
        FormP.add(scrollPane, fgbc);

        // 3. Pagination Footer
        JLabel recordsLabel = new JLabel("Showing 1-8 of 120 records");
        recordsLabel.setForeground(Color.GRAY);
        fgbc.gridy = 2;
        fgbc.weighty = 0;
        fgbc.anchor = GridBagConstraints.EAST;
        FormP.add(recordsLabel, fgbc);

        // Add FormP to RPanel
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formGbc.weightx = 1;
        formGbc.weighty = 1;
        formGbc.fill = GridBagConstraints.BOTH;
        formGbc.insets = new Insets(0,40,40,40);

        RPanel.add(FormP, formGbc);
        
        // Finally add RPanel to the Frame
        // GridBagConstraints mainGbc = new GridBagConstraints();
        // mainGbc.gridx = 1;
        // mainGbc.weightx = 1;
        // mainGbc.weighty = 1;
        // mainGbc.fill = GridBagConstraints.BOTH;

        // add(RPanel, mainGbc);

        // add(RPanel, gbc);
        // ============== Mouse Listeners ==============//
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

        grievBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                grievBtn.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                grievBtn.setBackground(new Color(96,165,250));
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

        //================ACTION LISTENERS=================//

        dashBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminDashboard(user,role);
                dispose();
            }
        });
        mygrievBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AViewGrievances(user,role);
                dispose();
            }
        });
        profileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminProfile(user,role);
                dispose();
            }
        });
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
        addMgrBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Registration();
                // dispose();
            }
        });
    }

    // private void clearError(int secs) {
    //     Timer timer = new Timer(secs, new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             Error.setText("");
    //             Error.setForeground(new Color(255, 100, 100));
    //         }
    //     });
    //     timer.setRepeats(false);
    //     timer.start();
    // }
    public static void main(String[] args) {
        String usern = "Jay Ware";
        String rolen = "Member ID: M001";
        new ManageUsers(usern,rolen);
    }
}