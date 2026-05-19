package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import database.JDBC;

public class ProfilePage extends JFrame{
    public JButton profileBtn;

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
    String[] fullData;

    ProfilePage(String usern, String userRole){
        this.user = usern;
        this.role = userRole;
        fullData = new database.JDBC().getUserDetails(user);
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
        JDBC db = new JDBC();
        String[][] data = db.getUserGrievances(user);
        GridBagConstraints gbc = new GridBagConstraints();

        //__________LEFT PANEL__________//

        UserSideBar sidebar = new UserSideBar(user, role, "profileBtn");
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
        String ID = fullData[4];
        JLabel memberId = new JLabel("Member ID: "+ID);
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

        String email = fullData[1];
        JTextField emailField = new JTextField();
        emailField.setText(email);
        emailField.setFont(new Font("Times New Roman",Font.BOLD,14));
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

        String mob = fullData[2];
        JTextField mobileField = new JTextField();
        mobileField.setText(mob);
        mobileField.setFont(new Font("Times New Roman",Font.BOLD,14));
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

        cgbc.gridy = 8;
        cgbc.insets = new Insets(20,40,10,40);

        card.add(sep2,cgbc);

        JLabel security = new JLabel("Security");
        security.setFont(new Font("Segoe UI",Font.BOLD,16));
        security.setForeground(Color.WHITE);

        cgbc.gridy = 9;
        cgbc.insets = new Insets(10,40,10,40);

        card.add(security,cgbc);

        JButton changePass = new JButton("Change Password");
        changePass.setFont(new Font("Segoe UI",Font.BOLD,14));
        changePass.setFocusPainted(false);
        changePass.setBackground(new Color(96,165,250));
        changePass.setForeground(Color.WHITE);
        changePass.setPreferredSize(new Dimension(0,40));

        cgbc.gridy = 10;
        cgbc.insets = new Insets(10,40,30,40);

        card.add(changePass,cgbc);

        Error = new JLabel("", SwingConstants.CENTER);
        Error.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Error.setForeground(new Color(255, 100, 100));
        cgbc.gridy = 7;
        cgbc.insets = new Insets(0, 0, 0, 0);
        card.add(Error, cgbc);

        wrapper.add(card);

        rgbc.gridy = 1;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.BOTH;

        RPanel.add(wrapper,rgbc);

        add(RPanel, gbc);


        //================ACTION LISTNERS=================//
        changeEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText().trim();
                JDBC.Chnage(user, null, email);
                Error.setForeground(Color.GREEN);
                Error.setText("Email Upadte");
                clearError(3000);

            }
        });
        changeMobile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mobile = mobileField.getText().trim();
                JDBC.Chnage(user, mobile, null);
                Error.setForeground(Color.GREEN);
                Error.setText("Mobile Upadte");
                clearError(3000);
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
        new ProfilePage(usern,rolen);
    }
}