import java.util.Scanner;
import java.sql.*;
public class Doctor {
    public static void addDoctor(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Doctor name");
        String doc_name=sc.nextLine();
        System.out.println("Enter Specialization");
        String specialization=sc.nextLine();

        try{
            Connection conn=DBConnection.getConnection();
            String sql="INSERT INTO DOCTOR (NAME,SPECIALIZATION) VALUES (?,?) ";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,doc_name);
            pre.setString(2,specialization);
            pre.executeUpdate();

            System.out.println("Doctor added sucessfully");

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
