package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

        LPanel = new JPanel();
        LPanel.setBackground(new Color(2, 6, 23));
        LPanel.setOpaque(true);
        LPanel.setLayout(new BorderLayout());
        LPanel.setPreferredSize(new Dimension(200, 850));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/form.png"));
        JLabel imageLabel = new JLabel();
        Image img = icon.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("New Grievance");
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
        
        ImageIcon btn2 = new ImageIcon(getClass().getResource("/images/form.png"));
        Image img2 = btn2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        grievBtn = new JButton(" Submite Grievance", new ImageIcon(img2));
        grievBtn.setHorizontalAlignment(SwingConstants.LEFT);
        grievBtn.setIconTextGap(15);
        grievBtn.setFocusPainted(false);
        grievBtn.setBorderPainted(false);
        grievBtn.setContentAreaFilled(false);
        grievBtn.setOpaque(true);
        grievBtn.setBackground(new Color(96,165,250));
        grievBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        grievBtn.setForeground(Color.WHITE);
        lgbc.gridy = 1;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(grievBtn,lgbc);
        
        ImageIcon btn3 = new ImageIcon(getClass().getResource("/images/mygrivances.png"));
        Image img3 = btn3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        mygrievBtn = new JButton(" My Grievances", new ImageIcon(img3));
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
        
        ImageIcon btn4 = new ImageIcon(getClass().getResource("/images/bell.png"));
        Image img4 = btn4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        notifyBtn = new JButton(" Notifications", new ImageIcon(img4));
        notifyBtn.setHorizontalAlignment(SwingConstants.LEFT);
        notifyBtn.setIconTextGap(15);
        notifyBtn.setFocusPainted(false);
        notifyBtn.setBorderPainted(true);
        notifyBtn.setContentAreaFilled(false);
        notifyBtn.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(2, 6, 23), 2),
                new EmptyBorder(8, 15, 8, 10)
            )
        );
        notifyBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        notifyBtn.setForeground(Color.WHITE);
        lgbc.gridy = 3;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(notifyBtn,lgbc);
        
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
                "Health-care",
                "Municipal",
                "Well-Fare"
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
        t2 = new JLabel("Health-care");
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
        t4 = new JLabel("Well-Fare");
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
        notifyBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                notifyBtn.setBorderPainted(true);
                notifyBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                notifyBtn.setBorderPainted(true);
                notifyBtn.setBorder(
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
                selected = "Health-care";
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
                selected = "Well-Fare";
                new FormPage(selected, user, role);
                dispose();
            }
        });

        //================ACTION LISTNERS=================//

        dashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserDashboard(user, role);
                dispose();
            }
        });
        mygrievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyGrievancePage(user, role);
                dispose();
            }
        });
        notifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NotificationPage(user, role);
                dispose();
            }
        });
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Profile feature is in progress",
                    "messege",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
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