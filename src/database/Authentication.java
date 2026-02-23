package database;

import java.sql.*;
public class Authentication {
    public static int registerUser(String username,String password,String emailid,String mobile)
    {
        int result = -1;

        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/grievance_db","postgres","PassSQL123");

            String sql = "Select username,emailid,mobile From users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String dbusername = rs.getString("username");
                String dbemail = rs.getString("emailid");
                String dbmobile = rs.getString("mobile");

                if(dbusername.equals("username")){
                    con.close();
                    return 1;
                }
                if(dbemail.equals("emailid")){
                    con.close();
                    return 2;
                }
                if(dbmobile.equals("mobile")){
                    con.close();
                    return 3;
                }

            }

           String insertSql = "Insert into users(username,password,name,emailid,mobile) values(?,?,?,?,?)";
           PreparedStatement psinsert = con.prepareStatement(insertSql);

           psinsert.setString(1,"username");
           psinsert.setString(2,"password");
           psinsert.setString(3,"name");
           psinsert.setString(4,"emailid");
           psinsert.setString(5,"mobile");

           psinsert.executeQuery();
           con.close();
              return 0;

           

        } catch (Exception e) {
             System.out.println("Error: " + e);
        }
        return result;
    }
    
}
