package frontend;

import database.JDBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Registration extends JFrame{
    
    public JPanel LPanel;
    public JPanel FormPanel;
    public JLabel Ltitle;
    public JLabel NameLable;
    public JLabel UnLable;
    public JLabel PassLable;
    public JLabel ConfPassLable;
    public JLabel EmailLable;
    public JLabel MobLable;
    public JTextField NameField;
    public JTextField UnField;
    public JPasswordField PassField;
    public JPasswordField ConfPassField;
    public JTextField EmailField;
    public JTextField MobField;
    public JPanel Passpanel;
    public JButton Register;
    public JButton Clear;
    public JPanel Buttons;
    public JLabel text;
    public JLabel login;
    public JPanel LoginLink;

    public JPanel RPanel;
    public JLabel Rtitle1;
    public JLabel Rtitle2;
    public JPanel RtitlePanel;
    public JLabel Instruc;
    public JPanel InstrucPanel;
    public JLabel Rtitle3;
    public JLabel errorLabel;
    public JPanel Footer;
    
    public Registration(){
        InitializeFrame();
        AddPanels();
        setVisible(true);
    }

    private void InitializeFrame(){
        setTitle("Intelligent Grievance Scrutiny System");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        if (icon.getIconWidth() > 0) {
            setIconImage(icon.getImage());
        }
        
        FBG bg = new FBG("/images/bg1.png");
        bg.setLayout(new GridBagLayout());
        setContentPane(bg);
    }

    public class FBG extends JPanel {

        private Image backgroundImage;
        private boolean stretch = true;
        private float opacity = 1.0f;
        private float scale = 1.0f;

        public FBG(String imagePaths) {
            backgroundImage = new ImageIcon(getClass().getResource(imagePaths)).getImage();
        }

        public void setStretch(boolean value) {
            this.stretch = value;
        }

        public void setOpacity(float value) {
            this.opacity = value;
        }

        public void setScale(float value) {
            this.scale = value;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage == null) return;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            if (stretch){
                g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }else{
                int imgW = (int)(backgroundImage.getWidth(this) * scale);
                int imgH = (int)(backgroundImage.getHeight(this) * scale);
                int x = (getWidth() - imgW) / 2;
                int y = (getHeight() - imgH) / 2;

                g2.drawImage(backgroundImage, x, y,imgW, imgH, this);
            }
            g2.dispose();
        }
    }

    private void AddPanels(){

        JPanel wrapper = new JPanel(new GridLayout(1, 2, 0, 0));
        wrapper.setOpaque(false);

        //Left Panel here
        LPanel = new GlassPanel(30);
        ((GlassPanel) LPanel).setRoundRight(false);
        ((GlassPanel) LPanel).setGlassBackground(new Color(15, 15, 25, 170));
        ((GlassPanel) LPanel).setGlassBorder(new Color(255, 255, 255, 60));
        LPanel.setPreferredSize(new Dimension(450, 550));
        LPanel.setLayout(new BorderLayout());

        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 0;
        centerGbc.gridy = 0;
        centerGbc.weightx = 1;
        centerGbc.weighty = 1;
        centerGbc.anchor = GridBagConstraints.CENTER;

        FormPanel = new JPanel();
        FormPanel.setLayout(new GridBagLayout());
        FormPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;

        Ltitle = new JLabel("Register for Authorized Access");
        Ltitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        Ltitle.setForeground(Color.WHITE);
        Ltitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        gbc.insets = new Insets(0, 10, 5, 20);
        gbc.weightx = 0;
        gbc.weighty = 0;
        FormPanel.add(Ltitle, gbc);

        NameLable = new JLabel("Applicants Name");
        NameLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        NameLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 1;
        gbc.insets= new Insets(15, 20, 5, 225);
        FormPanel.add(NameLable,gbc);

        NameField = new JTextField(50);
        NameField.setText("Enter Your Full Name here");
        NameField.setFont(new Font("Seoge UI",Font.PLAIN,14));
        NameField.setBackground(new Color(40, 40, 50));
        NameField.setForeground(Color.GRAY);
        NameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        NameField.setCaretColor(Color.WHITE);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 20, 10, 20);
        FormPanel.add(NameField,gbc);

        UnLable = new JLabel("User Name");
        UnLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        UnLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 20, 5, 225);
        FormPanel.add(UnLable,gbc);

        UnField = new JTextField(50);
        UnField.setText("Enter Username");
        UnField.setFont(new Font("Seoge UI",Font.PLAIN,14));
        UnField.setBackground(new Color(40, 40, 50));
        UnField.setForeground(Color.GRAY);
        UnField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        UnField.setCaretColor(Color.WHITE);
        gbc.gridy = 4;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(UnField,gbc);

        PassLable = new JLabel("Password");
        PassLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        PassLable.setForeground(new Color(100, 213, 254));
        ConfPassLable = new JLabel("Confirem Passowrd");
        ConfPassLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        ConfPassLable.setForeground(new Color(100, 213, 254));

        PassField = new JPasswordField();
        PassField.setText("Enter the Password");
        PassField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        PassField.setBackground(new Color(40, 40, 50));
        PassField.setForeground(Color.gray);
        PassField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        PassField.setCaretColor(Color.WHITE);
        PassField.setEchoChar((char) 0);
        
        ConfPassField = new JPasswordField();
        ConfPassField.setText("Confirm the Password");
        ConfPassField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        ConfPassField.setBackground(new Color(40, 40, 50));
        ConfPassField.setForeground(Color.gray);
        ConfPassField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        ConfPassField.setCaretColor(Color.WHITE);
        ConfPassField.setEchoChar((char) 0);

        Passpanel = new JPanel(new GridBagLayout());
        Passpanel.setOpaque(false);
        GridBagConstraints pgbc = new GridBagConstraints();
        pgbc.weightx = 0.5;
        pgbc.fill = GridBagConstraints.HORIZONTAL;

        pgbc.gridy = 0;
        pgbc.gridx = 0;
        pgbc.insets = new Insets(0, 0, 0, 10);
        Passpanel.add(PassLable, pgbc);
        pgbc.gridx = 1;
        pgbc.insets = new Insets(0, 10, 5, 0);
        Passpanel.add(ConfPassLable, pgbc);

        pgbc.gridy = 1;
        pgbc.gridx = 0;
        pgbc.insets = new Insets(0, 0, 0, 10);
        Passpanel.add(PassField,pgbc);
        pgbc.gridx = 1;
        pgbc.insets = new Insets(0, 10, 5, 0);
        Passpanel.add(ConfPassField,pgbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 20, 5, 20);
        FormPanel.add(Passpanel,gbc);
        
        EmailLable = new JLabel("Email");
        EmailLable.setFont(new Font("segoe UI",Font.BOLD,13));
        EmailLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 20, 5, 0);
        FormPanel.add(EmailLable,gbc);

        EmailField = new JTextField(50);
        EmailField.setText("Example : Admin123@gmail.com");
        EmailField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        EmailField.setBackground(new Color(40, 40, 50));
        EmailField.setForeground(Color.gray);
        EmailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        EmailField.setCaretColor(Color.WHITE);
        gbc.gridy = 7;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(EmailField,gbc);
        
        MobLable = new JLabel("Mobile No.");
        MobLable.setFont(new Font("segoe UI",Font.BOLD,13));
        MobLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 20, 5, 0);
        FormPanel.add(MobLable,gbc);

        MobField = new JTextField(50);
        MobField.setText("Enter Your Mobile No.");
        MobField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        MobField.setBackground(new Color(40, 40, 50));
        MobField.setForeground(Color.gray);
        MobField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        MobField.setCaretColor(Color.WHITE);
        gbc.gridy = 9;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(MobField,gbc);

        Register = new JButton("Register");
        Register.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Register.setBackground(new Color(0, 180, 0));
        Register.setForeground(Color.WHITE);
        Register.setFocusPainted(false);
        Register.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        Register.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Clear = new JButton("Clear");
        Clear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Clear.setBackground(new Color(15, 15, 25));
        Clear.setForeground(Color.WHITE);
        Clear.setFocusPainted(false);
        Clear.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        Clear.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Buttons = new JPanel(new GridBagLayout());
        Buttons.setOpaque(false);
        GridBagConstraints pgbc1 = new GridBagConstraints();
        pgbc1.weightx = 0.5;
        pgbc1.fill = GridBagConstraints.HORIZONTAL;
        pgbc1.gridy = 0;
        pgbc1.gridx = 0;
        pgbc1.insets = new Insets(0, 0, 0, 10);
        Buttons.add(Register, pgbc1);
        pgbc1.gridx = 1;
        pgbc1.insets = new Insets(0, 10, 5, 0);
        Buttons.add(Clear, pgbc1);
        gbc.gridy = 10;
        gbc.insets = new Insets(0,20,3,20);
        FormPanel.add(Buttons,gbc);

        text = new JLabel("Already have an Account?");
        text.setFont(new Font("SansSerif",Font.BOLD,12));
        text.setForeground(Color.WHITE);
        login = new JLabel("Login Here");
        login.setFont(new Font("SansSerif",Font.BOLD,12));
        login.setForeground(Color.GREEN);

        LoginLink = new JPanel(new GridBagLayout());
        LoginLink.setOpaque(false);
        GridBagConstraints pgbc2 = new GridBagConstraints();
        pgbc2.fill = GridBagConstraints.HORIZONTAL;
        pgbc2.gridy = 0;
        pgbc2.gridx = 0;
        pgbc2.insets = new Insets(0, 0, 0, 5);
        LoginLink.add(text,pgbc2);
        pgbc2.gridx = 1;
        pgbc2.insets = new Insets(0,0,0,0);
        LoginLink.add(login,pgbc2);
        gbc.gridy = 11;
        FormPanel.add(LoginLink,gbc);

        LPanel.add(FormPanel,BorderLayout.CENTER);

        //RIGHT Panel here
        RPanel = new GlassPanel(30);
        ((GlassPanel) RPanel).setRoundLeft(false);
        ((GlassPanel) RPanel).setGlassBackground(new Color(25, 25, 35, 170));
        RPanel.setPreferredSize(new Dimension(450, 550));
        RPanel.setLayout(new BorderLayout());

        Rtitle1 = new JLabel("Intelligent Grievance", SwingConstants.CENTER);
        Rtitle1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        Rtitle1.setForeground(Color.WHITE);
        
        Rtitle2 = new JLabel("Scrutiny System", SwingConstants.CENTER);
        Rtitle2.setFont(new Font("Segoe UI", Font.BOLD, 32));
        Rtitle2.setForeground(new Color(100, 149, 237));
        
        RtitlePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        RtitlePanel.setOpaque(false);
        RtitlePanel.setBorder(new EmptyBorder(50, 30, 20, 30));
        RtitlePanel.add(Rtitle1);
        RtitlePanel.add(Rtitle2);
        
        Instruc = new JLabel("<html><div style='text-align:left;'>"
        + "• Fill in all required details to create your account<br>"
        + "• Choose a unique Username for system access<br>"
        + "• Password and Confirm Password must match<br>"
        + "• Use a valid Email for communication and recovery<br>"
        + "• Provide an active Mobile Number for verification<br>"
        + "• Ensure all information is accurate before submitting<br>"
        + "• Click Register to complete the account Registration<br>"
        + "• If you Already registered? Click Login Here"
        + "</div></html>",
        SwingConstants.CENTER);
        Instruc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Instruc.setForeground(new Color(225, 225,225));
        
        InstrucPanel = new FBG("/images/logo1.png");
        InstrucPanel.setOpaque(false);
        InstrucPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        InstrucPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        InstrucPanel.setPreferredSize(new Dimension(0, 260));
        ((FBG) InstrucPanel).setStretch(false);
        ((FBG) InstrucPanel).setOpacity(0.5f);
        ((FBG) InstrucPanel).setScale(0.45f);
        InstrucPanel.add(Instruc);

        Rtitle3 = new JLabel("Secure Access Portal", SwingConstants.CENTER);
        Rtitle3.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        Rtitle3.setForeground(new Color(150, 150, 150));

        errorLabel =new JLabel("",SwingConstants.CENTER);
        errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        errorLabel.setForeground(Color.RED);

        Footer = new JPanel(new GridBagLayout());
        Footer.setOpaque(false);
        Footer.setBorder(new EmptyBorder(20, 30, 50, 30));
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.CENTER;
        fgbc.gridy = 0;
        fgbc.insets = new Insets(0, 0, 10, 0);
        Footer.add(errorLabel,fgbc);
        fgbc.gridy = 1;
        fgbc.insets = new Insets(0, 20, 20, 0);
        Footer.add(Rtitle3,fgbc);

        RPanel.add(RtitlePanel,BorderLayout.NORTH);
        RPanel.add(InstrucPanel,BorderLayout.CENTER);
        RPanel.add(Footer,BorderLayout.SOUTH);

        wrapper.add(LPanel);
        wrapper.add(RPanel);

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.weightx = 1;
        frameGbc.weighty = 1;
        frameGbc.anchor = GridBagConstraints.CENTER;
        frameGbc.insets = new Insets(20, 20, 20, 20);
        getContentPane().add(wrapper, frameGbc);

        //==== KeyListners =====//
        NameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    UnField.requestFocus();
                }
            }
        });
        UnField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    PassField.requestFocus();
                }
            }
        });
        PassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    ConfPassField.requestFocus();
                }
            }
        });
        ConfPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    EmailField.requestFocus();
                }
            }
        });
        EmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    MobField.requestFocus();
                }
            }
        });
        MobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    Register.requestFocus();
                }
            }
        });

        //=== Focus Listners ===//
        NameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (NameField.getText().equals("Enter Your Full Name here")) {
                    NameField.setText("");
                    NameField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (NameField.getText().isEmpty()) {
                    NameField.setForeground(Color.GRAY);
                    NameField.setText("Enter Your Full Name here");
                }
            }
        });
        UnField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (UnField.getText().equals("Enter Username")) {
                    UnField.setText("");
                    UnField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (UnField.getText().isEmpty()) {
                    UnField.setForeground(Color.GRAY);
                    UnField.setText("Enter Username");
                }
            }
        });
        PassField.addFocusListener(new FocusAdapter() {
            String passText = new String(PassField.getPassword());
            public void focusGained(FocusEvent e) {
                if (new String(PassField.getPassword()).equals("Enter the Password")) {
                    PassField.setText("");
                    PassField.setForeground(Color.WHITE);
                    PassField.setEchoChar('●');
                }
            }
            public void focusLost(FocusEvent e) {
                if (PassField.getPassword().length == 0) {
                    PassField.setForeground(Color.GRAY);
                    PassField.setText("Enter the Password");
                    PassField.setEchoChar((char) 0);
                }
            }
        });
        ConfPassField.addFocusListener(new FocusAdapter() {

            String ConpassText = new String(ConfPassField.getPassword());
            public void focusGained(FocusEvent e) {
                if (new String(ConfPassField.getPassword()).equals("Confirm the Password")) {
                    ConfPassField.setText("");
                    ConfPassField.setForeground(Color.WHITE);
                    ConfPassField.setEchoChar('●');
                }
            }
            public void focusLost(FocusEvent e) {
                if (ConfPassField.getPassword().length == 0) {
                    ConfPassField.setForeground(Color.GRAY);
                    ConfPassField.setText("Confirm the Password");
                    ConfPassField.setEchoChar((char) 0);
                }
            }
        });
        EmailField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (EmailField.getText().equals("Example : Admin123@gmail.com")) {
                    EmailField.setText("");
                    EmailField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (EmailField.getText().isEmpty()) {
                    EmailField.setForeground(Color.GRAY);
                    EmailField.setText("Example : Admin123@gmail.com");
                }
            }
        });
        MobField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (MobField.getText().equals("Enter Your Mobile No.")) {
                    MobField.setText("");
                    MobField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (MobField.getText().isEmpty()) {
                    MobField.setForeground(Color.GRAY);
                    MobField.setText("Enter Your Mobile No.");
                }
            }
        });

        //=== Action Listners ===//
        Register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String Nm = NameField.getText().trim();
                String Un = UnField.getText().trim();
                String pass = new String(PassField.getPassword());
                String Cpass = new String(ConfPassField.getPassword());
                String mail = EmailField.getText().trim();
                String mob = MobField.getText().trim();

                if(Nm.isEmpty() || Nm.equals("Enter Your Full Name here")){
                    errorLabel.setText("Please enter your name");
                    clearError(3000);
                    return;
                }
                if(Un.isEmpty() || Un.equals("Enter Username")){
                    errorLabel.setText("Please enter your username");
                    clearError(3000);
                    return;
                }
                if(pass.isEmpty() || pass.equals("Enter the Password")){
                    errorLabel.setText("Please enter password");
                    clearError(3000);
                    return;
                }
                if(!pass.equals(Cpass)){
                    errorLabel.setText("Passwords do not match");
                    clearError(3000);
                    return;
                }
                if(mail.isEmpty() || mail.equals("Example : Admin123@gmail.com")){
                    errorLabel.setText("Please enter valid Email");
                    clearError(3000);
                    return;
                }
                if(mob.length() != 10){
                    errorLabel.setText("Mobile number must be 10 digits");
                    clearError(3000);
                    return;
                }
                
                String check = JDBC.registerUser(Nm,Un, pass, mail, mob);

                if(check.equals("1")){
                    errorLabel.setText("User already exist");
                    clearError(3000);
                    return;
                }
                if(check.equals("2")){
                    errorLabel.setText("Email already exist");
                    clearError(3000);
                    return;
                }
                if(check.equals("3")){
                    errorLabel.setText("Mobile no. already exist");
                    clearError(3000);
                    return;
                }
                if(check.equals("0")){
                    errorLabel.setForeground(Color.GREEN);
                    errorLabel.setText("Registration successfully Go back to Login Page");
                    clearError(3000);
                    return;
                }
            }
        });
        Clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NameField.setText("Enter Your Full Name here");
                NameField.setForeground(Color.GRAY);
                UnField.setText("Enter Username");
                UnField.setForeground(Color.GRAY);
                PassField.setText("Enter the Password");
                PassField.setForeground(Color.GRAY);
                ConfPassField.setText("Confirm the Password");
                ConfPassField.setForeground(Color.GRAY);
                EmailField.setText("Example : Admin123@gmail.com");
                EmailField.setForeground(Color.GRAY);
                MobField.setText("Enter Your Mobile No.");
                MobField.setForeground(Color.GRAY);
                errorLabel.setText("");
            }
        });

        //=== Mouse Listner ===//
        Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Register.setBackground(new Color(0, 245, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Register.setBackground(new Color(0, 180, 0));
            }
        });
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Clear.setBackground(new Color(40, 40, 50));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Clear.setBackground(new Color(15, 15, 25));
            }
        });
        login.addMouseListener(new MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setForeground(new Color(0, 225, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginPage();
                dispose();
            }
        });
    }
    private void clearError(int secs) {
        Timer timer = new Timer(secs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");
                errorLabel.setForeground(Color.RED);
            }
        });
        timer.setRepeats(false); // run only once
        timer.start();
    }

    public static void main(String[] args) {
        new Registration();
    }
}