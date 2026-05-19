package frontend;

import database.JDBC;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UserSideBar{

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
    public JButton ActiveBtn;

    String user;
    String role;
    String page;

    UserSideBar(String user, String role, String btn){
        this.user = user;
        this.role = role;
        this.page = btn;

        sidebar();
    }
    
    void sidebar(){
        
        GridBagConstraints gbc = new GridBagConstraints();

        LPanel = new JPanel();
        LPanel.setBackground(new Color(2, 6, 23));
        LPanel.setOpaque(true);
        LPanel.setLayout(new BorderLayout());
        LPanel.setPreferredSize(new Dimension(150, 850));

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
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(10, 10, 2, 10);
        lgbc.anchor = GridBagConstraints.NORTHWEST;
        SideBar.add(dashBtn,lgbc);
        
        ImageIcon btn2 = new ImageIcon(getClass().getResource("/images/form.png"));
        Image img2 = btn2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        grievBtn = new JButton(" Submite Grievance", new ImageIcon(img2));
        lgbc.gridy = 1;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(grievBtn,lgbc);
        
        ImageIcon btn3 = new ImageIcon(getClass().getResource("/images/mygrivances.png"));
        Image img3 = btn3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        mygrievBtn = new JButton(" My Grievances", new ImageIcon(img3));
        lgbc.gridy = 2;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(mygrievBtn,lgbc);
        
        ImageIcon btn4 = new ImageIcon(getClass().getResource("/images/bell.png"));
        Image img4 = btn4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        notifyBtn = new JButton(" Notifications", new ImageIcon(img4));
        lgbc.gridy = 3;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(notifyBtn,lgbc);
        
        ImageIcon btn5 = new ImageIcon(getClass().getResource("/images/profile.png"));
        Image img5 = btn5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        profileBtn = new JButton(" Profile", new ImageIcon(img5));
        lgbc.gridy = 4;
        lgbc.fill = GridBagConstraints.HORIZONTAL;
        lgbc.insets = new Insets(2, 10, 2, 10);
        SideBar.add(profileBtn,lgbc);
        
        ImageIcon btn6 = new ImageIcon(getClass().getResource("/images/logout.png"));
        Image img6 = btn6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        logoutBtn = new JButton(" Logout", new ImageIcon(img6));
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

        ArrayList<JButton> pages = new ArrayList<>(
            Arrays.asList(dashBtn,grievBtn,mygrievBtn,notifyBtn,profileBtn,logoutBtn)
        );

        System.out.println(page);

        ActiveBtn = null;

        switch (page) {
            case "dashBtn":
                ActiveBtn = dashBtn;
                break;
            case "grievBtn":
                ActiveBtn = grievBtn;
                break;
            case "mygrievBtn":
                ActiveBtn = mygrievBtn;
                break;
            case "notifyBtn":
                ActiveBtn = notifyBtn;
                break;
            case "profileBtn":
                ActiveBtn = profileBtn;
                break;
        }

        ArrayList<JButton> temp = new ArrayList<>(pages);
        if(ActiveBtn != null){
            temp.remove(ActiveBtn);
        }

        setActivebtn(ActiveBtn);
        setBtn(temp);

        HoverOver(ActiveBtn, temp); // mouse listner

        //=============== ACTION LISTNERS ================//
        dashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new UserDashboard(user, role);
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
        grievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectOrg(user, role);
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
        mygrievBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyGrievancePage(user, role);
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
        notifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NotificationPage(user, role);
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfilePage(user,role);
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                SwingUtilities.getWindowAncestor(LPanel).dispose();
            }
        });
    }

    private void HoverOver(JButton page, ArrayList<JButton> temp){
        for(JButton btn1 : temp){
            btn1.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    btn1.setBorderPainted(true);
                    btn1.setBorder(
                        BorderFactory.createCompoundBorder(
                            new LineBorder(new Color(60,120,200), 2),
                            new EmptyBorder(8, 15, 8, 10)
                        )
                    );
                }
                public void mouseExited(MouseEvent e) {
                    btn1.setBorderPainted(true);
                    btn1.setBorder(
                        BorderFactory.createCompoundBorder(
                            new LineBorder(new Color(2, 6, 23), 2),
                            new EmptyBorder(8, 15, 8, 10)
                        )
                    );
                }
            });
        }
        page.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                page.setBackground(new Color(110,190,250));
            }
            public void mouseExited(MouseEvent e) {
                page.setBackground(new Color(96,165,250));
            }
        });
    }

    private void setActivebtn(JButton Btn){
        Btn.setHorizontalAlignment(SwingConstants.LEFT);
        Btn.setIconTextGap(15);
        Btn.setFocusPainted(false);
        Btn.setBorderPainted(false);
        Btn.setContentAreaFilled(false);
        Btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Btn.setForeground(Color.WHITE);
        Btn.setOpaque(true);
        Btn.setBackground(new Color(96,165,250));
        Btn.setBorder(new EmptyBorder(8, 15, 8, 10));
    }

    private void setBtn(ArrayList<JButton> temp){
        for(JButton Btn : temp){
            Btn.setHorizontalAlignment(SwingConstants.LEFT);
            Btn.setIconTextGap(15);
            Btn.setFocusPainted(false);
            Btn.setBorderPainted(true);
            Btn.setBorder(
                BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(2, 6, 23), 2),
                    new EmptyBorder(8, 15, 8, 10)
                )
            );
            Btn.setContentAreaFilled(false);
            Btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            Btn.setForeground(Color.WHITE);
        }
    }
}