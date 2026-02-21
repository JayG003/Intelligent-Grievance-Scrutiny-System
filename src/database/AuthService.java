import java.sql.*;
public class AuthService {
    public static void login(String username, String password){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db", "postgres", "PassSQL123");
            con.setAutoCommit(true);

            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String dbPass = rs.getString("password");
                if(dbPass.equals(password))
                    System.out.println("Login Successful...");
                else
                    System.out.println("Wrong Password...");
            } else {
                System.out.println("User not found...");
            }
        
            con.close();

        } catch(Exception e){
            System.out.println("ERROR: " + e);
        }
    }

    public static void main(String username, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");
            con.setAutoCommit(true);
    
            String checkSql = "SELECT * FROM users WHERE username=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setString(1,username);
            ResultSet rs = checkPs.executeQuery();

            if(rs.next()) {
                System.out.println("Username already exists...");
            } else {
                String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";
                PreparedStatement insertPs = con.prepareStatement(insertSql);
                insertPs.setString(1,username);
                insertPs.setString(2,password);
                insertPs.executeUpdate();

            System.out.println("User Registered Successfully...");

            }

            con.close();
        
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
