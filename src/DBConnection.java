import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static final String URL="jdbc:mysql://localhost:3306/Clinic";
    static final String USER="root";
    static final String PASS="";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASS);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
