package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import database.JDBC;

public class FormPage extends JFrame{
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
    public JPanel FormP;
    public JLabel Category;
    public JComboBox<String> Categoryl;
    public JLabel info1;
    public JLabel name;
    public JTextField namef;
    public JLabel num;
    public JTextField numf;
    public JLabel mail;
    public JTextField mailf;
    public JLabel info2;
    public JLabel DescripL;
    public JTextArea Descrip;
    public JScrollPane Descripf;
    public JLabel info3;
    public JLabel R1;
    public JTextField R1f;
    public JLabel R2;
    public JTextField R2f;
    public JLabel R3;
    public JTextField R3f;
    public JLabel R4;
    public JTextField R4f;
    public JButton Submit;
    public JButton Clear;
    public JPanel InstrctP;
    public JLabel Instructions;
    public JLabel Error;
    
    public String selected;
    String role;
    String[] catagories;
    String user;
    FormPage(String sel, String usern, String userRole){
        this.selected = sel;
        this.user = usern;
        this.role = userRole;
        initializeFrame();
        AddPanels();
        setVisible(true);
    }
    int grievanceId = -1;

    FormPage(String sel, String usern, String userRole, int grievanceId){
        this.selected = sel;
        this.user = usern;
        this.role = userRole;
        this.grievanceId = grievanceId;

        initializeFrame();
        AddPanels();

        loadGrievanceData();

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

        //__________LEFT PANEL__________//

        UserSideBar sidebar = new UserSideBar(user, role, "grievBtn");
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

        Rnamelabel = new JLabel(selected + " Grievance Form");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.weightx = 1;
        labelgbc.weighty = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(10,400,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("Please Fill the complete form before submitting.");
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridx = 0;
        labelgbc.gridy = 1;
        labelgbc.weightx = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(10,420,10,0);
        
        RlabelP.add(Rrolelabel,labelgbc);

        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;
        RPanel.add(RlabelP, rgbc);

        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 20));
        centerWrapper.setOpaque(false);

        FormP = new GlassPanel(30);
        ((GlassPanel) FormP).setRoundRight(false);
        ((GlassPanel) FormP).setGlassBackground(new Color(128, 159, 255, 20));
        ((GlassPanel) FormP).setGlassBorder(new Color(255, 255, 255, 60));
        FormP.setPreferredSize(new Dimension(700, 650));
        FormP.setLayout(new GridBagLayout());
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.anchor = GridBagConstraints.NORTHWEST;
        fgbc.weightx = 1;

        InstrctP = new GlassPanel(30);
        InstrctP.setPreferredSize(new Dimension(350, 650));
        InstrctP.setLayout(new GridBagLayout());

        centerWrapper.add(FormP);
        centerWrapper.add(InstrctP);

        GridBagConstraints rgbc2 = new GridBagConstraints();
        rgbc2.gridx = 0;
        rgbc2.gridy = 1;
        rgbc2.weightx = 1;
        rgbc2.weighty = 1;
        rgbc2.fill = GridBagConstraints.BOTH;

        RPanel.add(centerWrapper, rgbc2);

        Category = new JLabel("Select Category :");
        Category.setFont(new Font("Segoe UI",Font.BOLD,16));
        Category.setForeground(Color.GRAY);
        fgbc.gridy = 0;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(30,20,10,0);
        FormP.add(Category,fgbc);
        
        if(selected.equals("Educational")){
            catagories = new String[]{
                "Select Category",
                "Examination & Results",
                "Academic Issue",
                "Administration & Documentation",
                "Fee & Accounts",
                "Infrastructure & Facilities"
            };
            Instructions = new JLabel(
                "<html><div style='width:300px;'>" +

                "<h2>Grievance Category Guidelines</h2>" +

                "<b>1] Examination & Results</b><br>" +
                "&nbsp;&nbsp;• Result Correction<br>" +
                "&nbsp;&nbsp;• Hall Ticket Issues<br>" +
                "&nbsp;&nbsp;• Internal Marks Mismatch<br>" +
                "&nbsp;&nbsp;• Exam Timetable Conflicts<br>" +

                "<b>2] Academic Issues</b><br>" +
                "&nbsp;&nbsp;• Faculty Complaints<br>" +
                "&nbsp;&nbsp;• Teaching Quality Concerns<br>" +
                "&nbsp;&nbsp;• Project Evaluation Issues<br>" +
                "&nbsp;&nbsp;• Syllabus Coverage Issues<br>" +

                "<b>3] Administrative & Documentation</b><br>" +
                "&nbsp;&nbsp;• Bonafide Certificate Issues<br>" +
                "&nbsp;&nbsp;• Leaving Certificate Issues<br>" +
                "&nbsp;&nbsp;• ID Card Issues<br>" +
                "&nbsp;&nbsp;• Name Correction Requests<br>" +

                "<b>4] Fees & Accounts</b><br>" +
                "&nbsp;&nbsp;• Fee Refund Requests<br>" +
                "&nbsp;&nbsp;• Payment Not Reflected<br>" +
                "&nbsp;&nbsp;• Scholarship Delays<br>" +
                "&nbsp;&nbsp;• Installment Approval Issues<br>" +

                "<b>5] Infrastructure & Facilities</b><br>" +
                "&nbsp;&nbsp;• Classroom Maintenance<br>" +
                "&nbsp;&nbsp;• Lab Equipment Issues<br>" +
                "&nbsp;&nbsp;• Library Complaints<br>" +
                "&nbsp;&nbsp;• Wi-Fi Problems<br>" +
                "&nbsp;&nbsp;• Hostel Issues<br><br>" +
                "</div></html>",
                SwingConstants.LEFT
            );

            R1 = new JLabel("Enter Institute Name:");
            R2 = new JLabel("Enter Department Name:");
            R4 = new JLabel("Authority Email(HOD/Exam Cell):");
            R3 = new JLabel("Authority Name(HOD/Coordinator):");

        }
        else if(selected.equals("Healthcare")){
            catagories = new String[]{
                "Select Category",
                "Treatment & Medical Care",
                "Staff Beheviour",
                "Billing & Financial Issue",
                "Facilities & Cleanliness",
                "Medicine & Farmacy"
            };
            Instructions = new JLabel(
                "<html><div style='width:300px;'>" +

                "<h2>Healthcare Grievance Category Guidelines</h2>" +

                "<b>1] Treatment & Medical Care</b><br>" +
                "&nbsp;&nbsp;• Delay in Treatment<br>" +
                "&nbsp;&nbsp;• Doctor Availability Issues<br>" +
                "&nbsp;&nbsp;• Incorrect Diagnosis Concern<br>" +
                "&nbsp;&nbsp;• Emergency Response Delay<br>" +

                "<b>2] Staff Behaviour & Conduct</b><br>" +
                "&nbsp;&nbsp;• Rude Behaviour<br>" +
                "&nbsp;&nbsp;• Negligence by Staff<br>" +
                "&nbsp;&nbsp;• Unprofessional Conduct<br>" +
                "&nbsp;&nbsp;• Communication Issues<br>" +

                "<b>3] Billing & Financial Issues</b><br>" +
                "&nbsp;&nbsp;• Incorrect Bill Amount<br>" +
                "&nbsp;&nbsp;• Double Charges<br>" +
                "&nbsp;&nbsp;• Refund Delays<br>" +
                "&nbsp;&nbsp;• Insurance Claim Issues<br>" +

                "<b>4] Facilities & Cleanliness</b><br>" +
                "&nbsp;&nbsp;• Ward Cleanliness Issues<br>" +
                "&nbsp;&nbsp;• Washroom Maintenance<br>" +
                "&nbsp;&nbsp;• Bed Availability Issues<br>" +
                "&nbsp;&nbsp;• Equipment Not Working<br>" +

                "<b>5] Medicine & Pharmacy</b><br>" +
                "&nbsp;&nbsp;• Medicine Not Available<br>" +
                "&nbsp;&nbsp;• Wrong Medicine Issued<br>" +
                "&nbsp;&nbsp;• Expired Medicine Concern<br>" +
                "&nbsp;&nbsp;• Pharmacy Delay<br><br>" +

                "</div></html>",
                SwingConstants.LEFT
            );

            R1 = new JLabel("Enter Hospital Name:");
            R2 = new JLabel("Department (OPD/IPD/etc.):");
            R3 = new JLabel("Doctor Name:");
            R4 = new JLabel("Hospital Email / Contact:");

        }else if(selected.equals("Municipal")){
            catagories = new String[]{
                "Select Category",
                "Roads & Public Transport",
                "Water Supply & drainage",
                "Waste management",
                "Street Lighting",
                "Public Property"
            };
            Instructions = new JLabel(
                "<html><div style='width:300px;'>" +

                "<h2>Municipal / Civic Grievance Category Guidelines</h2>" +

                "<b>1] Roads & Public Infrastructure</b><br>" +
                "&nbsp;&nbsp;• Potholes & Road Damage<br>" +
                "&nbsp;&nbsp;• Broken Footpaths<br>" +
                "&nbsp;&nbsp;• Bridge Maintenance Issues<br>" +
                "&nbsp;&nbsp;• Street Sign Problems<br>" +

                "<b>2] Water Supply & Drainage</b><br>" +
                "&nbsp;&nbsp;• Water Shortage<br>" +
                "&nbsp;&nbsp;• Water Leakage<br>" +
                "&nbsp;&nbsp;• Low Water Pressure<br>" +
                "&nbsp;&nbsp;• Drain Blockage<br>" +

                "<b>3] Sanitation & Waste Management</b><br>" +
                "&nbsp;&nbsp;• Garbage Not Collected<br>" +
                "&nbsp;&nbsp;• Overflowing Dustbins<br>" +
                "&nbsp;&nbsp;• Illegal Waste Dumping<br>" +
                "&nbsp;&nbsp;• Public Toilet Maintenance<br>" +

                "<b>4] Street Lighting</b><br>" +
                "&nbsp;&nbsp;• Street Lights Not Working<br>" +
                "&nbsp;&nbsp;• Broken Light Poles<br>" +
                "&nbsp;&nbsp;• Electrical Safety Issues<br>" +

                "<b>5] Public Property & Encroachment</b><br>" +
                "&nbsp;&nbsp;• Illegal Construction<br>" +
                "&nbsp;&nbsp;• Road Encroachment<br>" +
                "&nbsp;&nbsp;• Park Maintenance Issues<br>" +
                "&nbsp;&nbsp;• Damage to Public Property<br><br>" +

                "</div></html>",
                SwingConstants.LEFT
            );

            R1 = new JLabel("Ward Number / Area:");
            R2 = new JLabel("Exact Location:");
            R3 = new JLabel("Concerned Dept(Water/Road/etc.):");
            R4 = new JLabel("Local Officer / Office Contact:");

        }else if(selected.equals("WellFare")){
            catagories = new String[]{
                "Select Category",
                "Pension Services",
                "Scholarship & Student Assistance",
                "Government Schemes",
                "Special Needs Assistance",
                "Women & Child Welfare"
            };
            Instructions = new JLabel(
                "<html><div style='width:300px;'>" +

                "<h2>Social Welfare Grievance Category<br>Guidelines</h2>" +

                "<b>1] Pension & Senior Citizen Benefits</b><br>" +
                "&nbsp;&nbsp;• Pension Not Received<br>" +
                "&nbsp;&nbsp;• Pension Approval Delay<br>" +
                "&nbsp;&nbsp;• Incorrect Pension Amount<br>" +
                "&nbsp;&nbsp;• Pension Status Issues<br>" +

                "<b>2] Scholarships & Student Assistance</b><br>" +
                "&nbsp;&nbsp;• Scholarship Delay<br>" +
                "&nbsp;&nbsp;• Amount Not Credited<br>" +
                "&nbsp;&nbsp;• Application Rejected Incorrectly<br>" +
                "&nbsp;&nbsp;• Document Verification Issues<br>" +

                "<b>3] Government Schemes & Subsidies</b><br>" +
                "&nbsp;&nbsp;• Ration Card Issues<br>" +
                "&nbsp;&nbsp;• Housing Scheme Delay<br>" +
                "&nbsp;&nbsp;• Subsidy Not Received<br>" +
                "&nbsp;&nbsp;• Eligibility Complaint<br>" +

                "<b>4] Disability & Special Assistance</b><br>" +
                "&nbsp;&nbsp;• Disability Certificate Delay<br>" +
                "&nbsp;&nbsp;• Financial Aid Issues<br>" +
                "&nbsp;&nbsp;• Assistive Device Requests<br>" +
                "&nbsp;&nbsp;• Medical Reimbursement Problems<br>" +

                "<b>5] Women & Child Welfare</b><br>" +
                "&nbsp;&nbsp;• Child Benefit Issues<br>" +
                "&nbsp;&nbsp;• Maternity Benefit Delay<br>" +
                "&nbsp;&nbsp;• Nutrition Scheme Complaint<br>" +
                "&nbsp;&nbsp;• Women Protection Scheme Issues<br><br>" +

                "</div></html>",
                SwingConstants.LEFT
            );

            R1 = new JLabel("Enter Scheme Name:");
            R2 = new JLabel("Enter Application ID:");
            R3 = new JLabel("Department Name:");
            R4 = new JLabel("Authority Email / Office:");

        }

        Categoryl = new JComboBox<>(catagories);
        Categoryl.setBackground(new Color(40, 40, 50));
        Categoryl.setForeground(Color.WHITE);

        fgbc.gridy = 0;
        fgbc.gridx = 1;
        fgbc.insets = new Insets(30,0,10,250);
        FormP.add(Categoryl,fgbc);

        info1 = new JLabel("Applicants Information");
        info1.setFont(new Font("Segoe UI",Font.BOLD,18));
        info1.setForeground(new Color(96,165,250));
        fgbc.gridy = 1;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(30,20,0,0);
        FormP.add(info1,fgbc);

        name = new JLabel("Enter Full Name :");
        name.setFont(new Font("Segoe UI",Font.PLAIN,14));
        name.setForeground(Color.GRAY);
        fgbc.gridy = 2;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(10,20,5,0);
        FormP.add(name,fgbc);

        namef = new JTextField(70);
        namef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        namef.setBackground(new Color(68, 68, 85));
        namef.setForeground(Color.WHITE);
        namef.setCaretColor(Color.WHITE);
        namef.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 2;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(10, 20, 10, 40);
        FormP.add(namef, fgbc);

        num = new JLabel("Enter Mobile no.:");
        num.setFont(new Font("Segoe UI",Font.PLAIN,14));
        num.setForeground(Color.GRAY);
        fgbc.gridy = 3;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0,20,5,0);
        FormP.add(num,fgbc);

        numf = new JTextField(50);
        numf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        numf.setBackground(new Color(68, 68, 85));
        numf.setForeground(Color.WHITE);
        numf.setCaretColor(Color.WHITE);
        numf.setPreferredSize(new Dimension(200, 30));
        numf.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 3;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(numf, fgbc);

        mail = new JLabel("Enter Email ID :");
        mail.setFont(new Font("Segoe UI",Font.PLAIN,14));
        mail.setForeground(Color.GRAY);
        fgbc.gridy = 4;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0,20,5,0);
        FormP.add(mail,fgbc);

        mailf = new JTextField(50);
        mailf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mailf.setBackground(new Color(68, 68, 85));
        mailf.setForeground(Color.WHITE);
        mailf.setCaretColor(Color.WHITE);
        mailf.setPreferredSize(new Dimension(200, 30));
        mailf.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 4;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(mailf, fgbc);
        
        info2 = new JLabel("Grievance Details");
        info2.setFont(new Font("Segoe UI",Font.BOLD,18));
        info2.setForeground(new Color(96,165,250));
        fgbc.gridy = 5;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(20,20,0,0);
        FormP.add(info2,fgbc);
        
        DescripL = new JLabel("Enter Your Grivance Description :");
        DescripL.setFont(new Font("Segoe UI",Font.PLAIN,14));
        DescripL.setForeground(Color.GRAY);
        fgbc.gridy = 6;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(10,20,10,0);
        FormP.add(DescripL,fgbc);

        Descrip = new JTextArea();
        Descrip.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        Descrip.setBackground(new Color(68, 68, 85));
        Descrip.setForeground(Color.WHITE);
        Descrip.setCaretColor(Color.WHITE);
        Descrip.setLineWrap(true);
        Descrip.setWrapStyleWord(true);
        Descrip.setBorder(new EmptyBorder(5, 12, 5, 12));
        Descripf = new JScrollPane(Descrip);
        Descripf.setPreferredSize(new Dimension(600, 100));
        Descripf.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        Descripf.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        Descripf.setBorder(
            new LineBorder(new Color(255,255,255,40), 1, true)
        );

        GridBagConstraints tgbc = new GridBagConstraints();
        tgbc.gridy = 7;
        tgbc.gridx = 0;
        tgbc.gridwidth = 3;
        tgbc.weightx = 1;
        tgbc.weighty = 0.7;
        tgbc.fill = GridBagConstraints.BOTH;
        tgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(Descripf, tgbc);

        info3 = new JLabel(selected + " Information");
        info3.setFont(new Font("Segoe UI",Font.BOLD,18));
        info3.setForeground(new Color(96,165,250));
        fgbc.gridy = 8;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(5,20,0,0);
        FormP.add(info3,fgbc);

        R1.setFont(new Font("Segoe UI",Font.PLAIN,14));
        R1.setForeground(Color.GRAY);
        fgbc.gridy = 9;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0, 20, 5, 0);
        FormP.add(R1,fgbc);

        R1f = new JTextField(70);
        R1f.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        R1f.setBackground(new Color(68, 68, 85));
        R1f.setForeground(Color.WHITE);
        R1f.setCaretColor(Color.WHITE);
        R1f.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 9;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(R1f, fgbc);

        R2.setFont(new Font("Segoe UI",Font.PLAIN,14));
        R2.setForeground(Color.GRAY);
        fgbc.gridy = 10;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0, 20, 5, 0);
        FormP.add(R2,fgbc);

        R2f = new JTextField(50);
        R2f.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        R2f.setBackground(new Color(68, 68, 85));
        R2f.setForeground(Color.WHITE);
        R2f.setCaretColor(Color.WHITE);
        R2f.setPreferredSize(new Dimension(200, 30));
        R2f.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 10;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(R2f, fgbc);

        R3.setFont(new Font("Segoe UI",Font.PLAIN,14));
        R3.setForeground(Color.GRAY);
        fgbc.gridy = 11;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0, 20, 5, 0);
        FormP.add(R3,fgbc);

        R3f = new JTextField(50);
        R3f.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        R3f.setBackground(new Color(68, 68, 85));
        R3f.setForeground(Color.WHITE);
        R3f.setCaretColor(Color.WHITE);
        R3f.setPreferredSize(new Dimension(200, 30));
        R3f.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 11;
        fgbc.gridx = 1;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(R3f, fgbc);

        R4.setFont(new Font("Segoe UI",Font.PLAIN,14));
        R4.setForeground(Color.GRAY);
        fgbc.gridy = 12;
        fgbc.gridx = 0;
        fgbc.insets = new Insets(0, 20, 5, 0);
        FormP.add(R4,fgbc);

        R4f = new JTextField(50);
        R4f.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        R4f.setBackground(new Color(68, 68, 85));
        R4f.setForeground(Color.WHITE);
        R4f.setCaretColor(Color.WHITE);
        R4f.setPreferredSize(new Dimension(200, 30));
        R4f.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255,255,255,40), 1, true),
                new EmptyBorder(3, 12, 2, 12)
            )
        );
        fgbc.gridy = 12;
        fgbc.gridx = 1;
        fgbc.gridwidth = 1;
        fgbc.weightx = 1;
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.insets = new Insets(0, 20, 10, 40);
        FormP.add(R4f, fgbc);

        if(grievanceId == -1){
            Submit = new JButton("Submit");
            Submit.setFont(new Font("Segoe UI", Font.BOLD, 14));
            Submit.setBackground(new Color(0, 180, 0));
            Submit.setForeground(Color.WHITE);
            Submit.setFocusPainted(false);
            Submit.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
            Submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            fgbc.gridy = 13;
            fgbc.gridx = 0;
            fgbc.insets = new Insets(0, 20, 10, 20);
            FormP.add(Submit, fgbc);
        }else{
            Submit = new JButton("Reapply");
            Submit.setFont(new Font("Segoe UI", Font.BOLD, 14));
            Submit.setBackground(new Color(0, 180, 0));
            Submit.setForeground(Color.WHITE);
            Submit.setFocusPainted(false);
            Submit.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
            Submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            fgbc.gridy = 13;
            fgbc.gridx = 0;
            fgbc.insets = new Insets(0, 20, 10, 20);
            FormP.add(Submit, fgbc);
        }

        Clear = new JButton("Clear");
        Clear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Clear.setBackground(new Color(15, 15, 25));
        Clear.setForeground(Color.WHITE);
        Clear.setFocusPainted(false);
        Clear.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
        Clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridy = 13;
        fgbc.gridx = 1;
        fgbc.insets = new Insets(0, 80, 10, 100);
        FormP.add(Clear, fgbc);
        
        Instructions.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Instructions.setForeground(new Color(225, 225,225));

        GridBagConstraints igbc = new GridBagConstraints();
        igbc.gridx = 0;
        igbc.gridy = 0;
        igbc.weightx = 1;
        igbc.weighty = 1;
        igbc.fill = GridBagConstraints.BOTH;
        igbc.insets = new Insets(10,20,0,20);

        InstrctP.add(Instructions, igbc);

        Error = new JLabel("", SwingConstants.CENTER);
        Error.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Error.setForeground(new Color(255, 100, 100));
        igbc.gridy = 1;
        igbc.insets = new Insets(0, 0, 0, 0);
        InstrctP.add(Error, igbc);

        add(RPanel, gbc);

        //================ACTION LISTNERS=================//
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String sub = (String) Categoryl.getSelectedItem();
                String Nm = namef.getText().trim();
                String mob = numf.getText().trim();
                String email = mailf.getText().trim();
                String decs = Descrip.getText().trim();
                String ex1 = R1f.getText().trim();
                String ex2 = R2f.getText().trim();
                String ex3 = R3f.getText().trim();
                String ex4 = R4f.getText().trim();

                if(sub.isEmpty() | Nm.isEmpty() | mob.isEmpty() | email.isEmpty() | decs.isEmpty() | ex1.isEmpty() | ex2.isEmpty() | ex3.isEmpty() | ex4.isEmpty() ){
                    Error.setForeground(new Color(255, 100, 100));
                    Error.setText("Please fill All the fields");
                    clearError(3000);
                }
                else{
                    Error.setForeground(Color.GREEN);
                    String check = JDBC.addGrievance(grievanceId,user,selected,sub,Nm,mob,email,decs,ex1,ex2,ex3,ex4);
                    if(check.equals("0")){
                        Error.setText("Error");
                    }else{
                        Error.setForeground(Color.GREEN);
                        Error.setText("Grievance Form Submitted Successfully");
                        clearError(3000);
                    }
                }
            }
        });
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Categoryl.setSelectedItem("Select Category");
                namef.setText("");
                numf.setText("");
                mailf.setText("");
                Descrip.setText("");
                R1f.setText("");
                R2f.setText("");
                R3f.setText("");
                R4f.setText("");
            }
        });
    }

    private void clearError(int secs) {
        Timer timer = new Timer(secs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Error.setText("");
                Error.setForeground(new Color(255, 100, 100));
                Clear.doClick();
            }
        });
        timer.setRepeats(false); // run only once
        timer.start();
    }
    void loadGrievanceData(){

        if(grievanceId == -1) return;

        String[] data = JDBC.getGrievanceById(String.valueOf(grievanceId));

        if(data == null) return;

        Categoryl.setSelectedItem(data[2]);
        namef.setText(data[3]);
        numf.setText(data[4]);
        mailf.setText(data[5]);
        Descrip.setText(data[6]);

        R1f.setText(data[7]);
        R2f.setText(data[8]);
        R3f.setText(data[9]);
        R4f.setText(data[10]);
    }

    public static void main(String[] args) {
        String sel = "Educational";
        new FormPage(sel, "user", "Grievancer");
    }
}