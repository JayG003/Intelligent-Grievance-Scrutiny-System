package database;
import java.sql.*;

public class JDBC {
																
    public static String login(String username, String password) {
        String var1 = "1";
        String var2 = "2";
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbusername = rs.getString("username");
                String dbPass = rs.getString("password");
                String role = rs.getString("role");

                if(dbusername.equals(username)){
                    if(dbPass.equals(password)){
                        con.close();
                        return role;
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
            String insertSql = "Insert into users(username,password,name,emailid,mobileno, role, organization, isactive) values(?,?,?,?,?,'user','Null','t')";
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
}
