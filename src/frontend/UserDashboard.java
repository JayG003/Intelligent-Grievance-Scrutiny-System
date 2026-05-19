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

public class UserDashboard extends JFrame{

    public JPanel RPanel;
    public JPanel RlabelP;
    public JLabel Rnamelabel;
    public JLabel Rrolelabel;
    public JLabel Rrole;
    public JPanel counterRow;
    public JPanel c1,c2,c3,c4;
    public JLabel n1,n2,n3,n4;
    public JLabel t1,t2,t3,t4;
    public JLabel Tlabel;
    public JTable table;
    public JScrollPane scrollPane;
    
    String user;
    String role;
    int[] d;

    UserDashboard(String usern, String userRole){
        this.user = usern;
        this.role = userRole;

        d = JDBC.getUserDashboard(user);

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

        UserSideBar sidebar = new UserSideBar(user, role,"dashBtn");
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

        Rnamelabel = new JLabel("Welcome Back, " + user + "!");
        Rnamelabel.setFont(new Font("Times New Roman",Font.PLAIN,35));
        Rnamelabel.setForeground(Color.WHITE);

        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.weightx = 1;
        labelgbc.weighty = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(50,40,0,0);

        RlabelP.add(Rnamelabel,labelgbc);

        Rrolelabel = new JLabel("Role : " + role);
        Rrolelabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        Rrolelabel.setForeground(Color.LIGHT_GRAY);

        labelgbc.gridx = 0;
        labelgbc.gridy = 1;
        labelgbc.weightx = 0;
        labelgbc.anchor = GridBagConstraints.NORTHWEST;
        labelgbc.insets = new Insets(10,40,10,0);
        
        RlabelP.add(Rrolelabel,labelgbc);

        rgbc.gridy = 0;
        rgbc.weightx = 1;
        rgbc.weighty = 0;
        RPanel.add(RlabelP, rgbc);

        counterRow = new JPanel(new GridLayout(1,4,20,0));
        counterRow.setBorder(new EmptyBorder(20,40,20,40));
        counterRow.setOpaque(false);

        c1 = new JPanel();
        n1 = new JLabel(String.valueOf(d[0]));
        t1 = new JLabel("Total Grievances");
        n1.setForeground(new Color(59, 130, 246));
        t1.setForeground(new Color(59, 130, 246));
        
        c2 = new JPanel();
        n2 = new JLabel(String.valueOf(d[2]));
        t2 = new JLabel("Under Scrunity");
        n2.setForeground(new Color(139, 92, 246));
        t2.setForeground(new Color(139, 92, 246));
        
        c3 = new JPanel();
        n3 = new JLabel(String.valueOf(d[1]));
        t3 = new JLabel("Resolved");
        n3.setForeground(new Color(34, 197, 94));
        t3.setForeground(new Color(34, 197, 94));
        
        c4 = new JPanel();
        n4 = new JLabel(String.valueOf(d[4]));
        t4 = new JLabel("Unattended");
        n4.setForeground(new Color(245, 158, 11));
        t4.setForeground(new Color(245, 158, 11));

        ArrayList<JPanel> Cardc = new ArrayList<>(
            Arrays.asList(c1,c2,c3,c4)
        );

        JLabel[] Cardnt = {n1,n2,n3,n4,t1,t2,t3,t4};

        for(int i = 0; i < 4; i++){
            JPanel c = Cardc.get(i);

            c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
            c.setBackground(new Color(31,41,55));
            c.setBorder(new EmptyBorder(20,20,20,20));

            Cardnt[i].setFont(new Font("Segoe UI", Font.BOLD, 28));
            Cardnt[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            Cardnt[i+4].setFont(new Font("Segoe UI", Font.BOLD, 14));
            Cardnt[i+4].setAlignmentX(Component.CENTER_ALIGNMENT);

            c.add(Cardnt[i]);
            c.add(Box.createVerticalStrut(8));
            c.add(Cardnt[i+4]);

            counterRow.add(c);
        }

        rgbc.gridy = 1;
        rgbc.insets = new Insets(10,0,10,0);
        RPanel.add(counterRow, rgbc);

        Tlabel = new JLabel("Recent Grievances");
        Tlabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        Tlabel.setForeground(new Color(0, 102, 204));

        rgbc.gridy = 2;
        rgbc.insets = new Insets(10,40,10,0);
        RPanel.add(Tlabel, rgbc);

        String[] columns = {"GrievanceID","Subject","Status","Priority","Timestamp"};
        JDBC db = new JDBC();
        String[][] data = db.getUserGrievances(user);

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for(int i = 0; i < data.length; i++){

            if(data[i][0] == null) break;

                model.addRow(new Object[]{
                    data[i][0],
                    data[i][2],
                    data[i][11],
                    data[i][12],
                    data[i][13]
            });
        }

        table = new JTable(model);
        table.getTableHeader().setPreferredSize(new Dimension(0,40));
        table.getTableHeader().setBackground(new Color(30, 41, 59));
        table.getTableHeader().setForeground(new Color(248, 250, 252));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        table.setRowHeight(35);
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

        rgbc.gridy = 3;
        rgbc.weightx = 1;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.BOTH;
        rgbc.insets = new Insets(0,40,40,40);
        RPanel.add(scrollPane,rgbc);

        add(RPanel, gbc);
    }
    public static void main(String[] args) {
        String usern = "user";
        new UserDashboard(usern, "Grievancer");
    }
}