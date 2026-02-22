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
}
