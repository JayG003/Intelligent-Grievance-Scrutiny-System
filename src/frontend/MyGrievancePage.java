package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MyGrievancePage extends JFrame{
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
    
    public JPanel detailPanel;
    public JTextArea detailArea;
    // String selected = "Educational";
    String user;
    String role;
    String[][] fullData;

    MyGrievancePage(String usern, String userRole){
        this.user = usern;
        this.role = userRole;
        fullData = new database.JDBC().getUserGrievances(user);
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
           role = "user";
        }
        GridBagConstraints gbc = new GridBagConstraints();

        UserSideBar sidebar = new UserSideBar(user, role, "mygrievBtn");
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

        Rrolelabel = new JLabel("You can see all the grivnces you have Unattended");
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
            "<html><div style='text-align:left; width:400px;'>"

            + "<b style='font-size:16px;'>My Grievances Instructions</b><br><br>"

            + "• View all grievances Unattended by you<br>"
            + "• Use filters to find specific complaints<br>"
            + "• Click <b>View Details</b> to see complete grievance information<br>"
            + "• Track grievance status updates here<br>"

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
        FormP.setPreferredSize(new Dimension(400, 450));
        FormP.setLayout(new GridBagLayout());
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.anchor = GridBagConstraints.NORTHWEST;
        fgbc.weightx = 0;

        rgbc.gridx = 0;
        rgbc.gridy = 2;
        rgbc.insets = new Insets(10,40,10,40);

        RPanel.add(FormP, rgbc);

        // detailPanel = new JPanel(new BorderLayout());
        // detailPanel.setBackground(new Color(15, 23, 42));

        // detailArea = new JTextArea();
        // detailArea.setEditable(false);
        // detailArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        // detailArea.setForeground(Color.WHITE);
        // detailArea.setBackground(new Color(15, 23, 42));
        // detailArea.setLineWrap(true);
        // detailArea.setWrapStyleWord(true);

        // JScrollPane detailScroll = new JScrollPane(detailArea);
        // detailScroll.setBorder(null);

        // detailPanel.add(detailScroll, BorderLayout.CENTER);
        
        String[] catagories2 = {
                "Filter By Status",
                "Unattended",
                "Under Scrutiny",
                "Resolved",
                "Rejected",
                "Canceled"
        };

        Categoryl = new JComboBox<>(catagories2);
        Categoryl.setBackground(new Color(40, 40, 50));
        Categoryl.setForeground(Color.WHITE);

        fgbc.gridy = 0;
        fgbc.gridx = 0;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(30,20,50,10);
        FormP.add(Categoryl,fgbc);

        filter = new JButton("Filter");
        filter.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filter.setBackground(new Color(96,165,250));
        filter.setForeground(Color.WHITE);
        filter.setFocusPainted(false);
        filter.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        filter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridx = 1;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(30, 0, 50, 20);
        FormP.add(filter,fgbc);

        String[] columns = {
            "Grievance ID",
            "Applicant Name",
            "Mobile",
            "Organization",
            "Subject",
            "Priority",
            "Status"
        };

        Object[][] data = database.JDBC.getFilteredGrievances(user, role, null, null, null);

        DefaultTableModel model = new DefaultTableModel(data, columns){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        table = new JTable(model);
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

        fgbc.gridy = 1;
        fgbc.gridx = 0;
        fgbc.gridwidth = 2;
        fgbc.weightx = 1;
        fgbc.weighty = 1;
        fgbc.fill = GridBagConstraints.BOTH;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(0,20,10,40);
        FormP.add(scrollPane,fgbc);

        View = new JButton("View");
        View.setFont(new Font("Segoe UI", Font.BOLD, 14));
        View.setBackground(new Color(96,165,250));
        View.setForeground(Color.WHITE);
        View.setFocusPainted(false);
        View.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        View.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fgbc.gridy = 2;
        fgbc.gridx = 0;
        fgbc.weightx = 0;
        fgbc.fill = GridBagConstraints.NONE;
        fgbc.anchor = GridBagConstraints.WEST;
        fgbc.insets = new Insets(10, 40, 10, 0);
        FormP.add(View,fgbc);

        rgbc.gridy = 99;
        rgbc.weighty = 1;
        rgbc.fill = GridBagConstraints.VERTICAL;

        RPanel.add(Box.createVerticalGlue(), rgbc);

        add(RPanel, gbc);

        //================ACTION LISTNERS=================//
        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String status = Categoryl.getSelectedItem().toString();
                if(status.equals("Filter By Status")){
                    status = null;
                }

                // 🔥 DAO call
                Object[][] data = database.JDBC.getFilteredGrievances(user,role,null, null, status);

                // 🔥 Table columns (same order hona chahiye)
                String[] columns = {
                    "Grievance ID",
                    "Applicant Name",
                    "Mobile",
                    "Organization",
                    "Subject",
                    "Priority",
                    "Status"
                };

                // 🔥 Table update
                DefaultTableModel model = new DefaultTableModel(data, columns);
                table.setModel(model);
            }
        });
        filter.doClick();
        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if(row == -1){
                    JOptionPane.showMessageDialog(null, "Select a row first!");
                    return;
                }

                String grievanceId = table.getValueAt(row, 0).toString();

                String[] selectedData = null;

                for(int i = 0; i < fullData.length; i++){
                    if(fullData[i][0] != null && fullData[i][0].equals(grievanceId)){
                        selectedData = fullData[i];
                        break;
                    }
                }

                if(selectedData != null){
                    new ViewGrievanceFrame(selectedData);
                }
            }
        });
    }
    // public static void main(String[] args) {
    //     new MyGrievancePage("user", "user");
    // }
}