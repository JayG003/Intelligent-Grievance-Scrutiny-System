package frontend;

import database.JDBC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ForgetPass extends JFrame{
    
    public JPanel LPanel;
    public JPanel FormPanel;
    public JLabel Ltitle;
    public JLabel NameLable;
    public JLabel UnLable;
    public JLabel PassLable;
    public JLabel ConfPassLable;
    public JLabel CaptchaLable;
    public JLabel MobLable;
    public JTextField NameField;
    public JTextField UnField;
    public JPasswordField PassField;
    public JPasswordField ConfPassField;
    public JTextField CaptchaInput;
    public JTextField MobField;
    public JPanel Passpanel;
    public JButton Reset;
    public JButton Clear;
    public JPanel Buttons;
    private JButton refreshButton;
    private JButton validateButton;
    private JButton Captch;
    private JPanel CaptchPanel;
    public JLabel text;
    public JLabel login;
    public JPanel LoginLink;
    private String currentCaptcha;
    public JPanel Cp1;
    public JPanel Cp2;
    // public JLabel text;

    public JPanel RPanel;
    public JLabel Rtitle1;
    public JLabel Rtitle2;
    public JPanel RtitlePanel;
    public JLabel Instruc;
    public JPanel InstrucPanel;
    public JLabel Rtitle3;
    public JLabel errorLabel;
    public JPanel Footer;
    
    public ForgetPass(){
        InitializeFrame();
        AddPanels();
        refreshButton.doClick();
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
        gbc.insets = new Insets(0, 0, 14, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;

        Ltitle = new JLabel("Secure Credential Reset Portal");
        Ltitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        Ltitle.setForeground(Color.WHITE);
        Ltitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        gbc.insets = new Insets(0, 20, 5, 20);
        gbc.weightx = 0;
        gbc.weighty = 0;
        FormPanel.add(Ltitle, gbc);

        UnLable = new JLabel("User Name");
        UnLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        UnLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 5, 225);
        FormPanel.add(UnLable,gbc);

        UnField = new JTextField(50);
        UnField.setText("Enter Registerd Username");
        UnField.setFont(new Font("Seoge UI",Font.PLAIN,14));
        UnField.setBackground(new Color(40, 40, 50));
        UnField.setForeground(Color.GRAY);
        UnField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        UnField.setCaretColor(Color.WHITE);
        gbc.gridy = 2;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(UnField,gbc);

        PassLable = new JLabel("New Password");
        PassLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        PassLable.setForeground(new Color(100, 213, 254));
        ConfPassLable = new JLabel("Confirem Password");
        ConfPassLable.setFont(new Font("Seoge UI",Font.BOLD,13));
        ConfPassLable.setForeground(new Color(100, 213, 254));

        PassField = new JPasswordField();
        PassField.setText("Enter New Password");
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

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 20, 5, 20);
        FormPanel.add(Passpanel,gbc);
        
        MobLable = new JLabel("Mobile No.");
        MobLable.setFont(new Font("segoe UI",Font.BOLD,13));
        MobLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 20, 5, 0);
        FormPanel.add(MobLable,gbc);

        MobField = new JTextField(50);
        MobField.setText("Enter Registered Mobile No.");
        MobField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        MobField.setBackground(new Color(40, 40, 50));
        MobField.setForeground(Color.gray);
        MobField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        MobField.setCaretColor(Color.WHITE);
        gbc.gridy = 5;
        gbc.insets = new Insets(0,20,0,20);
        FormPanel.add(MobField,gbc);

        JLabel captchaTitle = new JLabel("Security Verification");
        captchaTitle.setForeground(new Color(100, 213, 254));
        captchaTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));

        CaptchaLable = new JLabel();
        
        ImageIcon reloadIcon = new ImageIcon(getClass().getResource("/images/Reload.png"));
        Image scaled = reloadIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        refreshButton = new JButton(new ImageIcon(scaled));
        refreshButton.setBorderPainted(false);
        refreshButton.setContentAreaFilled(false);
        refreshButton.setFocusPainted(false);
        refreshButton.setOpaque(false);
        refreshButton.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        Cp1 = new JPanel(new GridBagLayout());
        Cp1.setOpaque(false);
        GridBagConstraints cgbc = new GridBagConstraints();
        cgbc.insets = new Insets(0, 0, 10, 0);
        cgbc.fill = GridBagConstraints.HORIZONTAL;
        cgbc.anchor = GridBagConstraints.WEST;
        cgbc.weightx = 1.0;
        cgbc.gridy = 0;
        cgbc.gridx = 0;
        cgbc.insets = new Insets(0, 120, 5, 10);
        Cp1.add(captchaTitle,cgbc);
        cgbc.gridy = 1;
        cgbc.gridx = 0;
        cgbc.insets = new Insets(0, 100, 0, 10);
        Cp1.add(CaptchaLable,cgbc);
        cgbc.gridx = 1;
        cgbc.insets = new Insets(0, 0, 0, 0);
        Cp1.add(refreshButton,cgbc);
        gbc.gridy = 6;
        gbc.insets = new Insets(10,20,10,20);
        FormPanel.add(Cp1,gbc);

        CaptchaInput = new JTextField();
        CaptchaInput.setText("Enter Captcha");
        CaptchaInput.setFont(new Font("Segoe UI",Font.PLAIN,14));
        CaptchaInput.setBackground(new Color(40, 40, 50));
        CaptchaInput.setForeground(Color.GRAY);
        CaptchaInput.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        CaptchaInput.setCaretColor(Color.WHITE);

        validateButton = new JButton("VALIDATE");
        validateButton.setFocusPainted(false);
        validateButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        validateButton.setBackground(new Color(0, 160, 255));
        validateButton.setForeground(Color.WHITE);
        validateButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        validateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Cp2 = new JPanel(new GridBagLayout());
        Cp2.setOpaque(false);
        GridBagConstraints cgbc1 = new GridBagConstraints();
        cgbc1.gridy = 0;
        cgbc1.insets = new Insets(0, 20, 10, 20);
        cgbc1.weightx = 1.0;
        cgbc1.gridx = 0;
        cgbc1.fill = GridBagConstraints.HORIZONTAL;
        // cgbc1.anchor = GridBagConstraints.WEST;
        cgbc1.insets = new Insets(0, 50, 10, 5);
        Cp2.add(CaptchaInput,cgbc1);
        cgbc1.gridx = 1;
        cgbc1.weightx = 0;
        cgbc1.fill = GridBagConstraints.NONE;
        cgbc1.insets = new Insets(0, 5, 10, 10);
        Cp2.add(validateButton,cgbc1);
        gbc.gridy = 7;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(Cp2,gbc);

        Reset = new JButton("RESET");
        Reset.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Reset.setBackground(new Color(0, 180, 90));
        Reset.setForeground(Color.WHITE);
        Reset.setFocusPainted(false);
        Reset.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        Reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 8;
        gbc.insets = new Insets(0,20,10,20);
        FormPanel.add(Reset,gbc);

        text = new JLabel("Return to Secure");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("segoe UI",Font.BOLD,12));
        login = new JLabel("Login ");
        login.setFont(new Font("SansSerif",Font.BOLD,12));
        login.setForeground(Color.GREEN);

        LoginLink = new JPanel(new GridBagLayout());
        LoginLink.setOpaque(false);
        GridBagConstraints pgbc2 = new GridBagConstraints();
        pgbc2.fill = GridBagConstraints.LINE_START;
        // pgbc2.anchor = GridBagConstraints.WEST;
        pgbc2.gridy = 0;
        pgbc2.gridx = 0;
        pgbc2.insets = new Insets(0, 0, 0, 5);
        LoginLink.add(text,pgbc2);
        pgbc2.gridx = 1;
        pgbc2.insets = new Insets(0,0,0,0);
        LoginLink.add(login,pgbc2);
        gbc.gridy = 9;
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
        + "• Enter your registered Username<br>"
        + "• Provide your registered Mobile Number<br>"
        + "• Create a strong new password<br>"
        + "• Ensure both password fields match<br>"
        + "• Complete the security verification (CAPTCHA)<br>"
        + "• Click RESET to update your credentials"
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
        errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
                    MobField.requestFocus();
                }
            }
        });
        MobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    CaptchaInput.requestFocus();
                }
            }
        });
        CaptchaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateButton.requestFocus();
                }
            }
        });

        // //=== Focus Listners ===//
        UnField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (UnField.getText().equals("Enter Registerd Username")) {
                    UnField.setText("");
                    UnField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (UnField.getText().isEmpty()) {
                    UnField.setForeground(Color.GRAY);
                    UnField.setText("Enter Registerd Username");
                }
            }
        });
        PassField.addFocusListener(new FocusAdapter() {
            String passText = new String(PassField.getPassword());
            public void focusGained(FocusEvent e) {
                if (new String(PassField.getPassword()).equals("Enter New Password")) {
                    PassField.setText("");
                    PassField.setForeground(Color.WHITE);
                    PassField.setEchoChar('●');
                }
            }
            public void focusLost(FocusEvent e) {
                if (PassField.getPassword().length == 0) {
                    PassField.setForeground(Color.GRAY);
                    PassField.setText("Enter New Password");
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
        MobField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (MobField.getText().equals("Enter Registered Mobile No.")) {
                    MobField.setText("");
                    MobField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (MobField.getText().isEmpty()) {
                    MobField.setForeground(Color.GRAY);
                    MobField.setText("Enter Registered Mobile No.");
                }
            }
        });
        CaptchaInput.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (CaptchaInput.getText().equals("Enter Captcha")) {
                    CaptchaInput.setText("");
                    CaptchaInput.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (CaptchaInput.getText().isEmpty()) {
                    CaptchaInput.setForeground(Color.GRAY);
                    CaptchaInput.setText("Enter Captcha");
                }
            }
        });
        
        //=== Action Listners ===//
        refreshButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                StringBuilder captcha = new StringBuilder();
                Random random = new Random();

                for (int i = 0; i < 6; i++) {
                    captcha.append(chars.charAt(random.nextInt(chars.length())));
                }
                currentCaptcha = captcha.toString();
                BufferedImage image = new BufferedImage(180, 50, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = image.createGraphics();

                g2.setColor(new Color(30, 30, 40));
                g2.fillRect(0, 0, 180, 50);

                for (int i = 0; i < 12; i++) {
                    g2.setColor(new Color(
                            random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255)
                    ));
                    g2.drawLine(
                            random.nextInt(180),
                            random.nextInt(50),
                            random.nextInt(180),
                            random.nextInt(50)
                    );
                }

                g2.setFont(new Font("Arial", Font.ITALIC, 32));
                g2.setColor(Color.WHITE);
                int x = 20;
                for (char c : currentCaptcha.toCharArray()) {
                    int y = 35 + random.nextInt(10);
                    g2.drawString(String.valueOf(c), x, y);
                    x += 25;
                }
                g2.dispose();
                CaptchaLable.setIcon(new ImageIcon(image));
            }
        });
        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (CaptchaInput.getText().trim().equals(currentCaptcha)) {
                    errorLabel.setText("CAPTCHA Verified");
                    errorLabel.setForeground(Color.GREEN);
                    clearError(3000);
                } else {
                    errorLabel.setText("Invalid CAPTCHA ");
                    refreshButton.doClick();
                    clearError(3000);
                }
            }
        });
        Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String Un = UnField.getText().trim();
                String pass = new String(PassField.getPassword());
                String Cpass = new String(ConfPassField.getPassword());
                String mob = MobField.getText().trim();
                String captcha = CaptchaInput.getText().trim();
                if(Un.isEmpty() || Un.equals("Enter Registerd Username")){
                    errorLabel.setText("Please enter correct username");
                    clearError(3000);
                    return;
                }
                if(pass.isEmpty() || pass.equals("Enter New Password")){
                    errorLabel.setText("Please enter password");
                    clearError(3000);
                    return;
                }
                if(!pass.equals(Cpass)){
                    errorLabel.setText("Passwords do not match");
                    clearError(3000);
                    return;
                }
                if(mob.length() != 10){
                    errorLabel.setText("Enter Valid mobile no.");
                    clearError(3000);
                    return;
                }
                if(captcha.isEmpty() || captcha.equals("Enter Captcha")){
                    errorLabel.setText("Enter the captcha");
                    clearError(3000);
                    return;
                }
                if(!captcha.equals(currentCaptcha)){
                    errorLabel.setText("Invalid CAPTCHA");
                    errorLabel.setForeground(Color.RED);
                    refreshButton.doClick();
                    clearError(3000);
                    return;
                }
                String check = JDBC.forgotPassword(Un, mob, pass);
                if(check.equals("1")){
                    errorLabel.setForeground(new Color(0, 200, 100));
                    errorLabel.setText("Password Reset Successfully");
                }
                if(check.equals("2")){
                    errorLabel.setForeground(Color.RED);
                    errorLabel.setText("Enter Valid Mob No.");
                }
                if(check.equals("0")){
                    errorLabel.setForeground(Color.RED);
                    errorLabel.setText("User Not Found");
                }
                clearError(3000);
            }
        });

        //=== Mouse Listner ===//
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                refreshButton.setBorder(BorderFactory.createEmptyBorder(10, 55, 20, 45));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                refreshButton.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
            }
        });
        validateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                validateButton.setBackground(new Color(0, 190, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                validateButton.setBackground(new Color(0, 160, 255));
            }
        });
        Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                Reset.setBackground(new Color(0, 210, 90));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                Reset.setBackground(new Color(0, 180, 90));
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
        new ForgetPass();
    }
}