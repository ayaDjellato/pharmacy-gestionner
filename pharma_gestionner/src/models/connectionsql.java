package models;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class connectionsql{

    public Connection cn;
    public static Connection connectionbd(){
        try{
            
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_jfx", "root", "");
                System.out.println("cnx success");
                  return cn;

        }catch(SQLException e) {
            System.out.println("connection faillure");
            e.printStackTrace();
            return null;
        }
      

    }
    
}
