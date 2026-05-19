package database;

import java.sql.*;

public class JDBC {
																
    public static String login(String username, String password) {
        String var1 = "1";
        String var2 = "2";
        String var3 = "3";
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "SELECT * FROM users WHERE username=?";
            String sql1 = "SELECT isactive from users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbusername = rs.getString("username");
                String dbPass = rs.getString("password");
                String role = rs.getString("role");
                String active = rs.getString("isactive");

                if(dbusername.equals(username)){
                    if(dbPass.equals(password)){
                        if(active.equals("t")){
                            con.close();
                            return role;
                        }
                        else{
                            con.close();
                            return var3;
                        }
                    } else {
                        con.close();
                        return var2;
                    }
                } else {
                    con.close();
                    return var1;
                }
            }
            } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return var1;
    }

    public static String registerUser(String name, String username,String password,String emailid,String mobile)
    {
        int c =0;
        String result = "-1";

        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "Select username,emailid,mobileno From users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                c++;
                String dbusername = rs.getString("username");
                String dbemail = rs.getString("emailid");
                String dbmobile = rs.getString("mobileno");

                if(dbusername.equals(username)){
                    con.close();
                    return "1";
                }
                if(dbemail.equals(emailid)){
                    con.close();
                    return "2";
                }
                if(dbmobile.equals(mobile)){
                    con.close();
                    return "3";
                }

            }
            String insertSql = "Insert into users(username,password,name,emailid,mobileno, role, organization, isactive) values(?,?,?,?,?,'user',Null,true)";
            PreparedStatement psinsert = con.prepareStatement(insertSql);

            // psinsert.setInt(1,c+1);
            psinsert.setString(1,username);
            psinsert.setString(2,password);
            psinsert.setString(3,name);
            psinsert.setString(4,emailid);
            psinsert.setString(5,mobile);
            
            psinsert.executeUpdate();

            con.close();
            return "0";
           

        } catch (Exception e) {
             System.out.println("Error: " + e);
        }
        return result;
    }
    public static String forgotPassword(String username, String mobileno, String newPassword) {

        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "SELECT username, mobileno FROM users WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbusername = rs.getString("username");
                String dbmobile = rs.getString("mobileno");

                if (dbusername.equals(username)) {

                    if (dbmobile.equals(mobileno)) {

                        String updateSql = "UPDATE users SET password=? WHERE username=?";
                        PreparedStatement psUpdate = con.prepareStatement(updateSql);

                        psUpdate.setString(1, newPassword);
                        psUpdate.setString(2, username);

                        psUpdate.executeUpdate();

                        con.close();
                        return "1";

                    } else {
                        con.close();
                        return "2";
                    }

                }

            }else {
                    con.close();
                    return "0";
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "-1";
        
    }

    public static  String addGrievance(int GrievanceId,String username, String organization, String subject,String applicantname, String applicantmobile, String applicantemail,String description, String info1, String info2, String info3, String info4)
    {

        String result = "0";

        try {

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String q1 = "SELECT userid FROM users WHERE username = ?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setString(1, username);

            ResultSet rs = ps1.executeQuery();

            int userId = 0;

            if (rs.next()) {
                userId = rs.getInt("userid");
            }

            String q2;

            if(GrievanceId != -1){
                q2 = "UPDATE grievances SET "
                + "userid=?, organization=?, subject=?, applicantname=?, applicantmobile=?, applicantemail=?, "
                + "description=?, info1=?, info2=?, info3=?, info4=?, "
                + "status='Unattended', priority='Low' "
                + "WHERE grievanceid=?";
            }else{
                q2 = "INSERT INTO grievances "
                    + "(userid, organization, subject, applicantname, applicantmobile, applicantemail, description, info1, info2, info3, info4, status, priority) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Unattended', 'Low')";
            }
                
            PreparedStatement ps2 = con.prepareStatement(q2);

            ps2.setInt(1, userId);
            ps2.setString(2, organization);
            ps2.setString(3, subject);
            ps2.setString(4, applicantname);
            ps2.setString(5, applicantmobile);
            ps2.setString(6, applicantemail);
            ps2.setString(7, description);
            ps2.setString(8, info1);
            ps2.setString(9, info2);
            ps2.setString(10, info3);
            ps2.setString(11, info4);
            if(GrievanceId != -1){
                ps2.setInt(12, GrievanceId);
            }

            int rows = ps2.executeUpdate();

            if (rows > 0) {

                result = "1";

                // ONLY FOR REAPPLY
                if (GrievanceId != -1) {

                    // 1. INSERT INTO grievance_history
                    String historySql = "INSERT INTO grievance_history (grievanceid, status, remarks, updated_at) " +
                                        "VALUES (?, 'Reapplied', ?, CURRENT_TIMESTAMP) RETURNING history_id";

                    PreparedStatement psHistory = con.prepareStatement(historySql);
                    psHistory.setInt(1, GrievanceId);
                    psHistory.setString(2, "User reapplied grievance after correction");

                    ResultSet rsHistory = psHistory.executeQuery();

                    int historyId = -1;
                    if (rsHistory.next()) {
                        historyId = rsHistory.getInt("history_id");
                    }

                    // 2. GET ORGANIZATION
                    String orgSql = "SELECT organization FROM grievances WHERE grievanceid = ?";
                    PreparedStatement psOrg = con.prepareStatement(orgSql);
                    psOrg.setInt(1, GrievanceId);
                    ResultSet rsOrg = psOrg.executeQuery();

                    String org = null;
                    if (rsOrg.next()) {
                        org = rsOrg.getString("organization");
                    }

                    // 3. GET MANAGER USERID
                    String mgrSql = "SELECT userid FROM users WHERE role='manager' AND organization=?";
                    PreparedStatement psMgr = con.prepareStatement(mgrSql);
                    psMgr.setString(1, org);
                    ResultSet rsMgr = psMgr.executeQuery();

                    int managerId = -1;
                    if (rsMgr.next()) {
                        managerId = rsMgr.getInt("userid");
                    }

                    // 4. INSERT NOTIFICATION
                    if (managerId != -1 && historyId != -1) {

                        String msg = "Grievance ID " + GrievanceId +
                                    " has been reapplied by user.";

                        String notifSql = "INSERT INTO notifications (userid, grievanceid, history_id, message, is_read, created_at) " +
                                        "VALUES (?, ?, ?, ?, false, CURRENT_TIMESTAMP)";

                        PreparedStatement psNotif = con.prepareStatement(notifSql);
                        psNotif.setInt(1, managerId);
                        psNotif.setInt(2, GrievanceId);
                        psNotif.setInt(3, historyId);
                        psNotif.setString(4, msg);

                        psNotif.executeUpdate();
                    }
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = "0";
        }

        return result;
    }

public String[][] getUserGrievances(String username){

    String[][] data = new String[1000][23];
    int index = 0;

    try{

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/grievance_db",
                "postgres",
                "PassSQL123"
        );

        String query =
        "SELECT g.grievanceid, g.organization, g.subject, g.applicantname, g.applicantmobile, " +
        "g.applicantemail, g.description, g.info1, g.info2, g.info3, g.info4, g.status, g.priority, g.timestamp, " +
        "u.username, u.password, u.name, u.emailid, u.mobileno, u.role, u.organization, u.isactive, u.userid " +
        "FROM grievances g JOIN users u ON g.userid = u.userid WHERE u.username=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            data[index][0] = String.valueOf(rs.getInt("grievanceid"));
            data[index][1] = rs.getString("organization");
            data[index][2] = rs.getString("subject");
            data[index][3] = rs.getString("applicantname");
            data[index][4] = rs.getString("applicantmobile");
            data[index][5] = rs.getString("applicantemail");
            data[index][6] = rs.getString("description");
            data[index][7] = rs.getString("info1");
            data[index][8] = rs.getString("info2");
            data[index][9] = rs.getString("info3");
            data[index][10] = rs.getString("info4");
            data[index][11] = rs.getString("status");
            data[index][12] = rs.getString("priority");
            data[index][13] = String.valueOf(rs.getTimestamp("timestamp"));

            data[index][14] = rs.getString("username");
            data[index][15] = rs.getString("password");
            data[index][16] = rs.getString("name");
            data[index][17] = rs.getString("emailid");
            data[index][18] = rs.getString("mobileno");
            data[index][19] = rs.getString("role");
            data[index][20] = rs.getString("organization");
            data[index][21] = rs.getString("isactive");
            data[index][22] = rs.getString("userid");

            index++;
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}
public String[] getUserDetails(String username){

    String[] data = new String[10];

    try{
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query = "SELECT name, emailid, mobileno, role, userid, organization FROM users WHERE username=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            data[0] = rs.getString("name");
            data[1] = rs.getString("emailid");
            data[2] = rs.getString("mobileno");
            data[3] = rs.getString("role");
            data[4] = rs.getString("userid");
            data[5] = rs.getString("organization");
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}

public String[][] getAllUsers(){

    String[][] data = new String[1000][10];
    int index = 0;

    try{
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query = "SELECT name, emailid, mobileno, role, userid, username, isactive, organization FROM users";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        while(rs.next()){
            data[index][0] = rs.getString("name");
            data[index][1] = rs.getString("emailid");
            data[index][2] = rs.getString("mobileno");
            data[index][3] = rs.getString("role");
            data[index][4] = rs.getString("userid");
            data[index][5] = rs.getString("username");
            data[index][6] = rs.getString("isactive");
            if(data[index][6].equals("t")){
                data[index][6] = "Active";
            }else if(data[index][6].equals("f")){
                data[index][6] = "Blocked";
            }
            data[index][7] = rs.getString("organization");

            index++;
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}
    // ================= USER METHOD =================
    public static int[] getUserDashboard(String username){

        int[] data = new int[5];
        // [0]=total, [1]=resolved, [2]=under scrutiny, [3]=rejected, [4]=open

        try{
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/grievance_db",
                "postgres",
                "PassSQL123"
            );

            // userid
            String q0 = "SELECT userid FROM users WHERE username=?";
            PreparedStatement ps0 = con.prepareStatement(q0);
            ps0.setString(1, username);
            ResultSet rs0 = ps0.executeQuery();

            int userid = 0;
            if(rs0.next()){
                userid = rs0.getInt(1);
            }

            // total grievances
            String q1 = "SELECT COUNT(*) FROM grievances WHERE userid=?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setInt(1, userid);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()) data[0] = rs1.getInt(1);

            // resolved
            String q2 = "SELECT COUNT(*) FROM grievances WHERE userid=? AND LOWER(status)='resolved'";
            PreparedStatement ps2 = con.prepareStatement(q2);
            ps2.setInt(1, userid);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) data[1] = rs2.getInt(1);

            // under scrutiny
            String q3 = "SELECT COUNT(*) FROM grievances WHERE userid=? AND LOWER(status)='under scrutiny'";
            PreparedStatement ps3 = con.prepareStatement(q3);
            ps3.setInt(1, userid);
            ResultSet rs3 = ps3.executeQuery();
            if(rs3.next()) data[2] = rs3.getInt(1);

            // rejected
            String q4 = "SELECT COUNT(*) FROM grievances WHERE userid=? AND LOWER(status)='rejected'";
            PreparedStatement ps4 = con.prepareStatement(q4);
            ps4.setInt(1, userid);
            ResultSet rs4 = ps4.executeQuery();
            if(rs4.next()) data[3] = rs4.getInt(1);

            // open
            String q5 = "SELECT COUNT(*) FROM grievances WHERE userid=? AND LOWER(status)='unattended'";
            PreparedStatement ps5 = con.prepareStatement(q5);
            ps5.setInt(1, userid);
            ResultSet rs5 = ps5.executeQuery();
            if(rs5.next()) data[4] = rs5.getInt(1);

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }


    // ================= ADMIN METHOD =================
    public static int[] getAdminDashboard(){

        int[] data = new int[6];
        // [0]=total users, [1]=manager, [2]=total grievance, [3]=pending, [4]=resolved, [5]=open

        try{
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/grievance_db",
                "postgres",
                "PassSQL123"
            );

            // total users -1
            String q1 = "SELECT COUNT(userid) FROM users";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()) data[0] = rs1.getInt(1) - 1;

            // manager count
            String q2 = "SELECT COUNT(*) FROM users WHERE LOWER(role)='manager'";
            PreparedStatement ps2 = con.prepareStatement(q2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) data[1] = rs2.getInt(1);

            // total grievances
            String q3 = "SELECT COUNT(*) FROM grievances";
            PreparedStatement ps3 = con.prepareStatement(q3);
            ResultSet rs3 = ps3.executeQuery();
            if(rs3.next()) data[2] = rs3.getInt(1);

            // pending
            String q4 = "SELECT COUNT(*) FROM grievances WHERE LOWER(status)='under scrutiny'";
            PreparedStatement ps4 = con.prepareStatement(q4);
            ResultSet rs4 = ps4.executeQuery();
            if(rs4.next()) data[3] = rs4.getInt(1);

            // resolved
            String q5 = "SELECT COUNT(*) FROM grievances WHERE LOWER(status)='resolved'";
            PreparedStatement ps5 = con.prepareStatement(q5);
            ResultSet rs5 = ps5.executeQuery();
            if(rs5.next()) data[4] = rs5.getInt(1);

            // open
            String q6 = "SELECT COUNT(*) FROM grievances WHERE LOWER(status)='unattended'";
            PreparedStatement ps6 = con.prepareStatement(q6);
            ResultSet rs6 = ps6.executeQuery();
            if(rs6.next()) data[5] = rs6.getInt(1);

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }


    // ================= MANAGER METHOD =================
    public static int[] getManagerDashboard(String username){

        int[] data = new int[20];
        // [0]=total grievance, [1]=pending, [2]=resolved, [3]=high priority

        try{
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/grievance_db",
                "postgres",
                "PassSQL123"
            );

            // get organization
            String q0 = "SELECT organization FROM users WHERE username=?";
            PreparedStatement ps0 = con.prepareStatement(q0);
            ps0.setString(1, username);
            ResultSet rs0 = ps0.executeQuery();

            String org = "";

            if(rs0.next()){
                org = rs0.getString("organization");
            }

            // total grievance by organization
            String q1 = "SELECT COUNT(*) FROM grievances WHERE LOWER(organization)=LOWER(?)";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setString(1, org);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()) data[0] = rs1.getInt(1);

            // pending
            String q2 = "SELECT COUNT(*) FROM grievances WHERE LOWER(organization)=LOWER(?) AND LOWER(status)='unattended'";
            PreparedStatement ps2 = con.prepareStatement(q2);
            ps2.setString(1, org);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) data[1] = rs2.getInt(1);

            // resolved
            String q3 = "SELECT COUNT(*) FROM grievances WHERE LOWER(organization)=LOWER(?) AND LOWER(status)='resolved'";
            PreparedStatement ps3 = con.prepareStatement(q3);
            ps3.setString(1, org);
            ResultSet rs3 = ps3.executeQuery();
            if(rs3.next()) data[2] = rs3.getInt(1);

            // high priority
            String q4 = "SELECT COUNT(*) FROM grievances WHERE LOWER(organization)=LOWER(?) AND LOWER(priority)='high'";
            PreparedStatement ps4 = con.prepareStatement(q4);
            ps4.setString(1, org);
            ResultSet rs4 = ps4.executeQuery();
            if(rs4.next()) data[3] = rs4.getInt(1);

            String q5 = "SELECT * FROM grievances WHERE organization = ?";
            PreparedStatement ps5 = con.prepareStatement(q5);
            ps5.setString(1,org);
            ResultSet rs5 = ps5.executeQuery();
            

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }

public static Object[][] getFilteredGrievances(
        String username,
        String role,
        String category,
        String priority,
        String status) {

    Object[][] data = new Object[0][0];

    try {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/grievance_db",
                "postgres",
                "PassSQL123"
        );

        // BASE QUERY
        StringBuilder query = new StringBuilder(
            "SELECT grievanceid, applicantname, applicantmobile, organization, subject, priority, status, applicantemail " +
            "FROM grievances WHERE 1=1"
        );

        if (role != null && role.equalsIgnoreCase("manager")) {
            query.append(" AND LOWER(organization) = LOWER((SELECT organization FROM users WHERE username=?))");
        } else {
            query.append(" AND userid = (SELECT userid FROM users WHERE username=?)");
        }

        // NORMAL FILTERS
        if(category != null && !category.equals("Filter By category")){
            query.append(" AND organization = ?");
        }

        if(priority != null && !priority.equals("Filter By Priority")){
            query.append(" AND priority = ?");
        }

        if(status != null && !status.equals("Filter By Status")){
            query.append(" AND status = ?");
        }

        PreparedStatement ps = con.prepareStatement(
                query.toString(),
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        int index = 1;
        
        // userid filter (sab ke liye)
        ps.setString(index++, username);

        // FILTER PARAMS
        if(category != null && !category.equals("Filter By category")){
            ps.setString(index++, category);
        }

        if(priority != null && !priority.equals("Filter By Priority")){
            ps.setString(index++, priority);
        }

        if(status != null && !status.equals("Filter By Status")){
            ps.setString(index++, status);
        }

        // System.out.println("QUERY: " + query.toString());
        System.out.println(category);

        ResultSet rs = ps.executeQuery();

        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();

        if(rows == 0){
            return new Object[0][0];
        }

        // FIX: 8 columns
        data = new Object[rows][8];

        int i = 0;
        while(rs.next()){
            data[i][0] = rs.getInt("grievanceid");
            data[i][1] = rs.getString("applicantname");
            data[i][2] = rs.getString("applicantmobile");

            data[i][3] = rs.getString("organization");
            data[i][4] = rs.getString("subject");

            data[i][5] = rs.getString("priority");
            data[i][6] = rs.getString("status");
            data[i][7] = rs.getString("applicantemail");

            i++;
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;
}

public static Object[][] getFilteredUsers(String role) {

    Object[][] data = new Object[0][0];

    try {
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        StringBuilder query = new StringBuilder(
            "SELECT name, emailid, mobileno, role, userid, username, isactive FROM users WHERE 1=1"
        );

        if(role != null && !role.equals("All")){
            query.append(" AND LOWER(role) = LOWER(?)");
        }

        PreparedStatement ps = con.prepareStatement(
            query.toString(),
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        int index = 1;

        if(role != null && !role.equals("All")){
            ps.setString(index++, role);
        }

        ResultSet rs = ps.executeQuery();

        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();

        if(rows == 0){
            return new Object[0][0];
        }

        data = new Object[rows][7];

        int i = 0;
        while(rs.next()){
            data[i][0] = rs.getString("name");
            data[i][1] = rs.getString("emailid");
            data[i][2] = rs.getString("mobileno");
            data[i][3] = rs.getString("role");
            data[i][4] = rs.getString("userid");
            data[i][5] = rs.getString("username");

            String active = rs.getString("isactive");
            data[i][6] = active.equals("t") ? "Active" : "Blocked";

            i++;
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;
}

public static Object[][] searchUsers(String keyword) {

    Object[][] data = new Object[0][0];

    try {
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query =
            "SELECT name, emailid, mobileno, role, userid, username, isactive " +
            "FROM users WHERE " +
            "CAST(userid AS TEXT) ILIKE ? OR " +
            "username ILIKE ? OR " +
            "name ILIKE ? OR " +
            "emailid ILIKE ? OR " +
            "mobileno ILIKE ?";

        PreparedStatement ps = con.prepareStatement(
            query,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        String search = "%" + keyword + "%";

        for(int i = 1; i <= 5; i++){
            ps.setString(i, search);
        }

        ResultSet rs = ps.executeQuery();

        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();

        if(rows == 0){
            return new Object[0][0];
        }

        data = new Object[rows][7];

        int i = 0;

        while(rs.next()){
            data[i][0] = rs.getString("name");
            data[i][1] = rs.getString("emailid");
            data[i][2] = rs.getString("mobileno");
            data[i][3] = rs.getString("role");
            data[i][4] = rs.getString("userid");
            data[i][5] = rs.getString("username");

            String active = rs.getString("isactive");
            data[i][6] = active.equals("t") ? "Active" : "Blocked";

            i++;
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;
}

public static Object[][] searchGrievances(String keyword, String organization) {

    Object[][] data = new Object[0][0];

    try {
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query =
            "SELECT grievanceid, applicantname, applicantmobile, subject, priority, status " +
            "FROM grievances WHERE " +
            "CAST(grievanceid AS TEXT) ILIKE ? " +
            "AND LOWER(organization) = LOWER(?)";

        PreparedStatement ps = con.prepareStatement(
            query,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, organization);

        ResultSet rs = ps.executeQuery();

        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();

        if(rows == 0){
            return new Object[0][0];
        }

        data = new Object[rows][6];

        int i = 0;

        while(rs.next()){
            data[i][0] = rs.getInt("grievanceid");
            data[i][1] = rs.getString("applicantname");
            data[i][2] = rs.getString("applicantmobile");
            data[i][3] = rs.getString("subject");
            data[i][4] = rs.getString("priority");
            data[i][5] = rs.getString("status");
            i++;
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;
}

    public static void Chnage(String usr,String mob, String mail){
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "SELECT mobileno,emailid FROM users WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usr);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                if(mob != null){
                    String updateSql = "UPDATE users SET mobileno=? WHERE username=?";
                    PreparedStatement psUpdate = con.prepareStatement(updateSql);

                    psUpdate.setString(1, mob);
                    psUpdate.setString(2, usr);

                    psUpdate.executeUpdate();
                    con.close();
                }
                if(mail != null){
                    String updateSql = "UPDATE users SET emailid=? WHERE username=?";
                    PreparedStatement psUpdate = con.prepareStatement(updateSql);

                    psUpdate.setString(1, mail);
                    psUpdate.setString(2, usr);
                    psUpdate.executeUpdate();
                    con.close();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] getGrievanceById(String grievanceId){

    String[] data = null;

    try{
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query = "SELECT * FROM grievances WHERE grievanceid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(grievanceId));

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            data = new String[13];

            data[0] = rs.getString("grievanceid");
            data[1] = rs.getString("organization");
            data[2] = rs.getString("subject");
            data[3] = rs.getString("applicantname");
            data[4] = rs.getString("applicantmobile");
            data[5] = rs.getString("applicantemail");
            data[6] = rs.getString("description");
            data[7] = rs.getString("info1");
            data[8] = rs.getString("info2");
            data[9] = rs.getString("info3");
            data[10] = rs.getString("info4");
            data[11] = rs.getString("status");
            data[12] = rs.getString("priority");
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}
public static boolean updateGrievanceStatus(
        int grievanceId,
        String status,
        String reason,
        String notice
) {
    try {
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        // 1. Update grievance table
        String updateQuery = "UPDATE grievances SET status=? WHERE grievanceid=?";
        PreparedStatement ps = con.prepareStatement(updateQuery);
        ps.setString(1, status);
        ps.setInt(2, grievanceId);
        ps.executeUpdate();

        // 2. Insert into history table
        String historyQuery = "INSERT INTO grievance_history(grievanceid, status, remarks) VALUES(?,?,?) RETURNING history_id";
        PreparedStatement ps2 = con.prepareStatement(historyQuery);
        ps2.setInt(1, grievanceId);
        ps2.setString(2, status);
        ps2.setString(3, reason);

        ResultSet rs = ps2.executeQuery();

        int historyId = 0;
        if(rs.next()){
            historyId = rs.getInt("history_id");
        }

        // 3. Get userid
        String getUser = "SELECT userid FROM grievances WHERE grievanceid=?";
        PreparedStatement ps3 = con.prepareStatement(getUser);
        ps3.setInt(1, grievanceId);
        ResultSet rs2 = ps3.executeQuery();

        int userId = 0;
        if(rs2.next()){
            userId = rs2.getInt("userid");
        }

        // 4. Insert notification (IMPORTANT 🔥 history_id use ho raha hai)
        String message = "Grievance ID " + grievanceId +
                " updated to '" + status +
                "'\nReason: " + reason;

        String notifQuery = "INSERT INTO notifications(userid, grievanceid, history_id, message,notice) VALUES(?,?,?,?,?)";
        PreparedStatement ps4 = con.prepareStatement(notifQuery);

        ps4.setInt(1, userId);
        ps4.setInt(2, grievanceId);
        ps4.setInt(3, historyId);
        ps4.setString(4, message);
        ps4.setString(5, notice);

        ps4.executeUpdate();

        con.close();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
public static Object[][] getUserNotifications(String username){

    Object[][] data = new Object[100][5];
    int i = 0;

    try{
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String query =
        "SELECT n.notification_id, n.message, n.is_read, n.created_at, grievanceid " +
        "FROM notifications n " +
        "JOIN users u ON n.userid = u.userid " +
        "WHERE u.username=? ORDER BY n.created_at DESC";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            data[i][0] = rs.getInt("notification_id");
            data[i][1] = rs.getString("message");
            data[i][2] = rs.getBoolean("is_read");
            data[i][3] = rs.getTimestamp("created_at");
            data[i][4] = rs.getInt("grievanceid");
            i++;
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}
public static String[] getNotificationById(String notificationId){

    String[] data = new String[7];

    try{
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/grievance_db",
            "postgres",
            "PassSQL123"
        );

        String sql = "SELECT * FROM notifications WHERE notification_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(notificationId));

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            data[0] = rs.getString("notification_id");
            data[1] = rs.getString("userid");
            data[2] = rs.getString("grievanceid");
            data[3] = rs.getString("history_id");
            data[4] = rs.getString("message");
            data[5] = rs.getString("is_read");
            data[6] = rs.getString("created_at");
        }

        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    return data;
}
}