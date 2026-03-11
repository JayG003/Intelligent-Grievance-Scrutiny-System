package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ManagerProfile extends JFrame{
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
    public JPanel PersonalP;
    public JPanel ProfileP;
    public JLabel Error;
    
    String user;
    String role;

    ManagerProfile(String usern, String userRole){
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
        profileBtn.setOpaque(true);
        profileBtn.setBackground(new Color(96,165,250));
        profileBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
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

        Rnamelabel = new JLabel("User Profile");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.anchor = GridBagConstraints.NORTH;
        labelgbc.insets = new Insets(30,0,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("Manage your account settings and security.");
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridy = 1;
        labelgbc.insets = new Insets(10,0,20,0);

        RlabelP.add(Rrolelabel,labelgbc);

        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;

        RPanel.add(RlabelP, rgbc);

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        wrapper.setOpaque(false);

        JPanel card = new GlassPanel(30);
        card.setPreferredSize(new Dimension(600,600));
        card.setLayout(new GridBagLayout());

        ((GlassPanel) card).setGlassBackground(new Color(128,159,255,20));
        ((GlassPanel) card).setGlassBorder(new Color(255,255,255,60));

        GridBagConstraints cgbc = new GridBagConstraints();
        cgbc.fill = GridBagConstraints.HORIZONTAL;
        cgbc.anchor = GridBagConstraints.NORTHWEST;
        cgbc.weightx = 1;

        ImageIcon prof = new ImageIcon(getClass().getResource("/images/profile.png"));
        Image img7 = prof.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        JLabel profileIcon = new JLabel(new ImageIcon(img7));
        profileIcon.setHorizontalAlignment(SwingConstants.CENTER);

        cgbc.gridy = 0;
        cgbc.insets = new Insets(30,0,10,0);

        card.add(profileIcon,cgbc);

        JLabel username = new JLabel(user);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setFont(new Font("Segoe UI",Font.BOLD,26));
        username.setForeground(Color.WHITE);

        cgbc.gridy = 1;

        card.add(username,cgbc);

        JLabel memberId = new JLabel("Member ID : M001");
        memberId.setHorizontalAlignment(SwingConstants.CENTER);
        memberId.setFont(new Font("Segoe UI",Font.PLAIN,14));
        memberId.setForeground(Color.LIGHT_GRAY);

        cgbc.gridy = 2;
        cgbc.insets = new Insets(5,0,20,0);

        card.add(memberId,cgbc);

        JSeparator sep1 = new JSeparator();
        sep1.setForeground(new Color(80,80,80));

        cgbc.gridy = 3;
        cgbc.insets = new Insets(10,40,20,40);

        card.add(sep1,cgbc);

        JLabel contact = new JLabel("Contact Information");
        contact.setFont(new Font("Segoe UI",Font.BOLD,16));
        contact.setForeground(Color.WHITE);

        cgbc.gridy = 4;
        cgbc.insets = new Insets(10,40,10,40);

        card.add(contact,cgbc);

        JPanel emailRow = new JPanel(new BorderLayout(10,0));
        emailRow.setOpaque(false);

        JLabel emailLabel = new JLabel("Current Email:");
        emailLabel.setForeground(Color.LIGHT_GRAY);

        JTextField emailField = new JTextField();
        emailField.setBackground(new Color(30,40,60));
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(new LineBorder(new Color(80,80,80)));

        JButton changeEmail = new JButton("Change");
        changeEmail.setFocusPainted(false);
        changeEmail.setBackground(new Color(96,165,250));
        changeEmail.setForeground(Color.WHITE);

        emailRow.add(emailLabel,BorderLayout.WEST);
        emailRow.add(emailField,BorderLayout.CENTER);
        emailRow.add(changeEmail,BorderLayout.EAST);

        cgbc.gridy = 5;
        cgbc.insets = new Insets(10,40,10,40);

        card.add(emailRow,cgbc);

        JPanel mobileRow = new JPanel(new BorderLayout(10,0));
        mobileRow.setOpaque(false);

        JLabel mobileLabel = new JLabel("Current Mobile:");
        mobileLabel.setForeground(Color.LIGHT_GRAY);

        JTextField mobileField = new JTextField();
        mobileField.setBackground(new Color(30,40,60));
        mobileField.setForeground(Color.WHITE);
        mobileField.setBorder(new LineBorder(new Color(80,80,80)));

        JButton changeMobile = new JButton("Change");
        changeMobile.setFocusPainted(false);
        changeMobile.setBackground(new Color(96,165,250));
        changeMobile.setForeground(Color.WHITE);

        mobileRow.add(mobileLabel,BorderLayout.WEST);
        mobileRow.add(mobileField,BorderLayout.CENTER);
        mobileRow.add(changeMobile,BorderLayout.EAST);

        cgbc.gridy = 6;

        card.add(mobileRow,cgbc);

        JSeparator sep2 = new JSeparator();

        cgbc.gridy = 7;
        cgbc.insets = new Insets(20,40,10,40);

        card.add(sep2,cgbc);

        JLabel security = new JLabel("Security");
        security.setFont(new Font("Segoe UI",Font.BOLD,16));
        security.setForeground(Color.WHITE);

        cgbc.gridy = 8;
        cgbc.insets = new Insets(10,40,10,40);

        card.add(security,cgbc);

        JButton changePass = new JButton("Change Password");
        changePass.setFont(new Font("Segoe UI",Font.BOLD,14));
        changePass.setFocusPainted(false);
        changePass.setBackground(new Color(96,165,250));
        changePass.setForeground(Color.WHITE);
        changePass.setPreferredSize(new Dimension(0,40));

        cgbc.gridy = 9;
        cgbc.insets = new Insets(10,40,30,40);

        card.add(changePass,cgbc);

        Error = new JLabel("", SwingConstants.CENTER);
        Error.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Error.setForeground(new Color(255, 100, 100));
        cgbc.gridy = 10;
        cgbc.insets = new Insets(0, 0, 0, 0);
        card.add(Error, cgbc);

        wrapper.add(card);

        rgbc.gridy = 1;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.BOTH;

        RPanel.add(wrapper,rgbc);

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
                profileBtn.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                profileBtn.setBackground(new Color(96,165,250));
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
            public void actionPerformed(ActionEvent e) {
                new ManagerDashboard(user,role);
                dispose();
            }
        });
        mygrievBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewGrievances(user,role);
                dispose();
            }
        });
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
        changeEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = changeEmail.getText().trim();
            }
        });
        changeMobile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mobile = changeMobile.getText().trim();
            }
        });
        changePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ForgetPass();
            }
        });
    }

    private void clearError(int secs) {
        Timer timer = new Timer(secs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Error.setText("");
                Error.setForeground(new Color(255, 100, 100));
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void main(String[] args) {
        String usern = "Jay123";
        String rolen = "user";
        new ManagerProfile(usern,rolen);
    }
}