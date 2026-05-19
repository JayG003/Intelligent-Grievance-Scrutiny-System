package frontend;

import database.JDBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

        //__________LEFT PANEL__________//

        UserSideBar sidebar = new UserSideBar(user, role, "notifyBtn");
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
            "<html><div style='text-align:left;'>"
            + "<b>Notification Center Guidelines</b><br><br>"
            + "• View updates related to your Unattended grievances<br>"
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

        String[] columns = {
            "Notification ID",
            "Grievance ID",
            "Message",
            "Read",
            "Date"
        };
        table = new JTable();
        Object[][] data = JDBC.getUserNotifications(user);

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for(int i=0; i<data.length; i++){
            if(data[i][0] == null) break;

            model.addRow(new Object[]{
                data[i][0],
                data[i][4],
                data[i][1],
                data[i][2],
                data[i][3]
            });
        }

        table.setModel(model);
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
        
        Del = new JButton("Reapply");
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

        //================ACTION LISTNERS=================//
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                // String NID = table.getValueAt(row, 0).toString();
                int GID = Integer.parseInt(table.getValueAt(row, 1).toString());
                String[] d = JDBC.getGrievanceById(String.valueOf(GID));
                new FormPage(d[1], user, role, GID);
                dispose();
            }
        });
        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if(row == -1){
                    JOptionPane.showMessageDialog(null, "Select a row first!");
                    return;
                }

                String NId = table.getValueAt(row, 0).toString();

                String[] selectedData = JDBC.getNotificationById(NId);

                if(selectedData != null){
                    new NotificationDetailFrame(selectedData);
                } else {
                    JOptionPane.showMessageDialog(null, "Grievance not found!");
                }
            }
        });
    }
    public static void main(String[] args) {
        new NotificationPage("user", "Grievancer");
    }
}