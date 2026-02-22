package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
// import Database.AuthService;

public class LoginPage extends JFrame{
    public JPanel LPanel;
    public JLabel title1;
    public JLabel title2; 
    public JLabel title3; 
    public JLabel title4; 
    public JPanel LP1;
    public JPanel LP2;
    public JPanel LP3;

    public JPanel RPanel;
    public JPanel FormPanel;
    public JLabel Rtitle;
    public JLabel UnLable;
    public JTextField UnField;
    public JLabel PassLable;
    public JPasswordField PassField;
    public JPanel buttons;
    public JButton loginButton;
    public JButton clearButton;
    public JLabel errorLabel;
    public JPanel links;
    public JLabel Register;
    public JLabel ForgetPass;

    public LoginPage(){
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
        
        setContentPane(new FBG("/images/bg1.png"));
        setLayout(new GridBagLayout());
    }

    public class FBG extends JPanel {

        private Image backgroundImage;
        private boolean stretch = true;
        private float opacity = 1.0f;
        private float scale = 1.0f;

        public FBG(String imagePaths) {
            backgroundImage = new ImageIcon(getClass().getResource(imagePaths)).getImage();
            setLayout(new BorderLayout());
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

        title1 = new JLabel("Intelligent Grievance", SwingConstants.CENTER);
        title1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title1.setForeground(Color.WHITE);
        
        title2 = new JLabel("Scrutiny System", SwingConstants.CENTER);
        title2.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title2.setForeground(new Color(100, 149, 237));
        
        LP1 = new JPanel(new GridLayout(2, 1, 0, 5));
        LP1.setOpaque(false);
        LP1.setBorder(new EmptyBorder(50, 30, 20, 30));
        LP1.add(title1);
        LP1.add(title2);

        title3 = new JLabel("<html><div style='text-align:left;'>"
        + "• Enter your registered username<br>"
        + "• Enter your Password<br>"
        + "• Ensure credentials are correct before logging in<br>"
        + "• After ensuring Login Information click on Login button<br>"
        + "• To clear the inputed credentials click on Clear button<br>"
        + "• If Password forgotten click on Forget Password<br>"
        + "• If you are new then click on Register"
        + "</div></html>",
        SwingConstants.CENTER);
        title3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        title3.setForeground(new Color(225, 225,225));

        LP2 = new FBG("/images/logo1.png");
        LP2.setOpaque(false);
        LP2.setBorder(new EmptyBorder(30, 30, 30, 30));
        LP2.setAlignmentX(Component.CENTER_ALIGNMENT);
        LP2.setPreferredSize(new Dimension(0, 260));
        ((FBG) LP2).setStretch(false);
        ((FBG) LP2).setOpacity(0.5f);
        ((FBG) LP2).setScale(0.45f);
        LP2.add(title3,BorderLayout.CENTER);

        title4 = new JLabel("Secure Access Portal", SwingConstants.CENTER);
        title4.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        title4.setForeground(new Color(150, 150, 150));

        LP3 = new JPanel(new BorderLayout());
        LP3.setOpaque(false);
        LP3.setBorder(new EmptyBorder(20, 30, 50, 30));
        LP3.add(title4);

        LPanel.add(LP1, BorderLayout.NORTH);
        LPanel.add(LP2, BorderLayout.CENTER);
        LPanel.add(LP3, BorderLayout.SOUTH);

        //RIGHT Panel here
        RPanel = new GlassPanel(30);
        ((GlassPanel) RPanel).setRoundLeft(false);
        ((GlassPanel) RPanel).setGlassBackground(new Color(25, 25, 35, 170));
        RPanel.setPreferredSize(new Dimension(450, 550));
        RPanel.setLayout(new GridBagLayout());

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

        Rtitle = new JLabel("Authorize Your Login..!");
        Rtitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        Rtitle.setForeground(Color.WHITE);
        gbc.insets = new Insets(0, 5, 5, 20);
        FormPanel.add(Rtitle, gbc);

        UnLable = new JLabel("USERNAME");
        UnLable.setFont(new Font("Segoe UI", Font.BOLD, 12));
        UnLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 5, 225);
        FormPanel.add(UnLable, gbc);

        UnField = new JTextField(20);
        UnField.setText("Enter Unsername");
        UnField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        UnField.setBackground(new Color(40, 40, 50));
        UnField.setForeground(Color.GRAY);
        UnField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        UnField.setCaretColor(Color.WHITE);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        FormPanel.add(UnField, gbc);

        PassLable = new JLabel("PASSWORD");
        PassLable.setFont(new Font("Segoe UI", Font.BOLD, 12));
        PassLable.setForeground(new Color(100, 213, 254));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 5, 0);
        FormPanel.add(PassLable, gbc);

        PassField = new JPasswordField(20);
        PassField.setText("Enter Password");
        PassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        PassField.setBackground(new Color(40, 40, 50));
        PassField.setForeground(Color.GRAY);
        PassField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        PassField.setCaretColor(Color.WHITE);
        PassField.setEchoChar((char) 0);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 20, 0);
        FormPanel.add(PassField, gbc);

        loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(new Color(0, 180, 0));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        clearButton.setBackground(new Color(15, 15, 25));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttons.setOpaque(false);
        buttons.add(loginButton);
        buttons.add(clearButton);
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        FormPanel.add(buttons, gbc);

        Register = new JLabel("<html><u>Register</u></html>");
        Register.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Register.setForeground(new Color(0, 195, 255));
        Register.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ForgetPass = new JLabel("<html><u>Forget Password</u></html>");
        ForgetPass.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ForgetPass.setForeground(new Color(255, 153, 0));
        ForgetPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

        links = new JPanel(new FlowLayout(FlowLayout.CENTER,15,0));
        links.setOpaque(false);
        links.add(Register);
        links.add(ForgetPass);
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        FormPanel.add(links, gbc);


        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        errorLabel.setForeground(new Color(255, 100, 100));
        gbc.gridy = 7;
        gbc.insets = new Insets(0, 0, 0, 0);
        FormPanel.add(errorLabel, gbc);

        RPanel.add(FormPanel,centerGbc);


        wrapper.add(LPanel);
        wrapper.add(RPanel);

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.insets = new Insets(20, 20, 20, 20);
        add(wrapper, frameGbc);

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(0, 245, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(0, 180, 0));
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login button clicked!");
                String UN = UnField.getText().trim();
                String pass = new String(PassField.getPassword());
                System.out.println("Username: " + UN + ", Password: " + pass);

                // int check = AuthService.login(UN, pass);
                boolean usernameCorrect = UN.equals("Admin");
                boolean passwordCorrect = pass.equals("Pass123");
                
                if (usernameCorrect && passwordCorrect) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (!usernameCorrect && !passwordCorrect) {
                    errorLabel.setText("Wrong Username and Password!");
                } else if (!usernameCorrect) {
                    errorLabel.setText("Wrong Username!");
                } else if (!passwordCorrect) {
                    errorLabel.setText("Wrong Password!");
                }
            }
        });
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(new Color(40, 40, 50));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(new Color(15, 15, 25));
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnField.setText("");
                PassField.setText("");
                errorLabel.setText("");
                UnField.requestFocus();
            }
        });
        Register.addMouseListener(new MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Register.setForeground(new Color(0, 225, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Register.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                new Registration();
                dispose();
            }
        });
        ForgetPass.addMouseListener(new MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ForgetPass.setForeground(new Color(255, 175, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ForgetPass.setForeground(new Color(255, 153, 0));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        LoginPage.this,
                        "Forget Password window in progress",
                        "Action",
                        JOptionPane.INFORMATION_MESSAGE
                );
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
                    loginButton.doClick();
                }
            }
        });

        UnField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (UnField.getText().equals("Enter Unsername")) {
                    UnField.setText("");
                    UnField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                if (UnField.getText().isEmpty()) {
                    UnField.setForeground(Color.GRAY);
                    UnField.setText("Enter Unsername");
                }
            }
        });
        PassField.addFocusListener(new FocusAdapter() {
            String passText = new String(PassField.getPassword());
            public void focusGained(FocusEvent e) {
                if (passText.equals("Enter Password")) {
                    PassField.setText("");
                    PassField.setForeground(Color.WHITE);
                    PassField.setEchoChar('●');
                }
            }
            public void focusLost(FocusEvent e) {
                if (PassField.getPassword().length == 0) {
                    PassField.setForeground(Color.GRAY);
                    PassField.setText("Enter Password");
                    PassField.setEchoChar((char) 0);
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}