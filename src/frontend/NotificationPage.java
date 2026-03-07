package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class NotificationPage extends JFrame{
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
    public JButton filter;
    public JTable table;
    public JScrollPane scrollPane;
    public JButton View;
    public JButton Del;
    
    String user;
    String role;

    NotificationPage(String usern, String userRole){
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/bell.png"));
        JLabel imageLabel = new JLabel();
        Image img = icon.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Notifications");
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
        mygrievBtn = new JButton(" My Grievances", new ImageIcon(img3));
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
        
        ImageIcon btn4 = new ImageIcon(getClass().getResource("/images/bell.png"));
        Image img4 = btn4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        notifyBtn = new JButton(" Notifications", new ImageIcon(img4));
        notifyBtn.setHorizontalAlignment(SwingConstants.LEFT);
        notifyBtn.setIconTextGap(15);
        notifyBtn.setFocusPainted(false);
        notifyBtn.setBorderPainted(true);
        notifyBtn.setContentAreaFilled(false);
        notifyBtn.setOpaque(true);
        notifyBtn.setBackground(new Color(96,165,250));
        notifyBtn.setBorder(new EmptyBorder(8, 15, 8, 10));
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

        Rrolelabel = new JLabel("You can see all the grivnces you have submitted");
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

        Instructions = new JLabel(
            "<html><div style='text-align:left;'>"
            + "<b>Notification Center Guidelines</b><br><br>"
            + "• View updates related to your submitted grievances<br>"
            + "• Track status changes such as <b>Under Scrutiny</b>, <b>Resolved</b>, or <b>Pending Review</b><br>"
            + "• Click <b>View</b> to see complete grievance details<br>"
            + "• Unread notifications will appear highlighted for quick attention<br>"
            + "• Use filters to find specific notifications easily<br>"
            + "• Notifications help you stay informed about grievance progress<br>"
            + "• Regularly check this section for important updates from authorities<br>"
            + "</div></html>",
            SwingConstants.LEFT
        );
        rgbc.gridy = 1;
        rgbc.insets = new Insets(10,40,20,0);
        Instructions.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        Instructions.setForeground(new Color(225, 225,225));
        RPanel.add(Instructions,rgbc);

        FormP = new GlassPanel(30);
        ((GlassPanel) FormP).setRoundRight(false);
        ((GlassPanel) FormP).setGlassBackground(new Color(128, 159, 255, 20));
        ((GlassPanel) FormP).setGlassBorder(new Color(255, 255, 255, 60));
        FormP.setPreferredSize(new Dimension(800, 450));
        FormP.setLayout(new GridBagLayout());
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.anchor = GridBagConstraints.NORTHWEST;

        rgbc.gridx = 0;
        rgbc.gridy = 2;
        rgbc.weightx = 1;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.BOTH;
        rgbc.insets = new Insets(10,40,20,40);

        RPanel.add(FormP, rgbc);

        String[] columns = {"Member ID", "Member Name", "Mobile", "Adress"};
        String[][] data = {
            {"M001", "John Doe", "B102", "Introduction to Java"},
            {"M002", "Jane Smith", "B107", "Database Systems"},
            {"M003", "Robert Brown", "B123", "Algorithms Design"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
            {"M004", "Emily Clark", "B110", "Web Development"},
        };

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

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(17,24,39));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(55,65,81)));
        scrollPane.setBorder(null);

        fgbc.gridy = 0;
        fgbc.gridx = 0;
        fgbc.weightx = 1;
        fgbc.weighty = 1;
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(40,20,10,20);
        FormP.add(scrollPane,fgbc);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,15,0));
        buttonPanel.setOpaque(false);

        GridBagConstraints bgbc = new GridBagConstraints();
        bgbc.weightx = 0;
        bgbc.fill = GridBagConstraints.NONE;
        bgbc.anchor = GridBagConstraints.WEST;

        View = new JButton("View");
        View.setFont(new Font("Segoe UI", Font.BOLD, 14));
        View.setBackground(new Color(96,165,250));
        View.setForeground(Color.WHITE);
        View.setFocusPainted(false);
        View.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        View.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        Del = new JButton("Delete");
        Del.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Del.setBackground(new Color(180, 0, 0));
        Del.setForeground(Color.WHITE);
        Del.setFocusPainted(false);
        Del.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        Del.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        buttonPanel.add(View);
        buttonPanel.add(Del);

        fgbc.gridy = 1;
        fgbc.gridx = 0;
        fgbc.gridwidth = 2;
        fgbc.weightx = 0;
        fgbc.weighty = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(10, 20, 20, 20);

        FormP.add(buttonPanel, fgbc);

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
                grievBtn.setBorderPainted(true);
                grievBtn.setBorder(
                    BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(60,120,200), 2),
                        new EmptyBorder(8, 15, 8, 10)
                    )
                );
            }
            public void mouseExited(MouseEvent e) {
                grievBtn.setBorderPainted(true);
                grievBtn.setBorder(
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
        notifyBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                notifyBtn.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                notifyBtn.setBackground(new Color(96,165,250));
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
                new UserDashboard(user, role);
                dispose();
            }
        });
        grievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectOrg(user, role);
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
    }
    public static void main(String[] args) {
        new NotificationPage("user", "Grievancer");
    }
}