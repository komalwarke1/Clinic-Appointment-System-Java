import java.sql.Date;
import java.util.Scanner;
import java.util.*;
import java.sql.*;
public class Appointment {
    public static void addAppointment(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter doctor id ");
        int doctorid=sc.nextInt();

        System.out.println("Enter patient id ");
        int patientid=sc.nextInt();

        sc.nextLine();

        System.out.println("Enter appointment date yyyy-mm-dd ");
        String date=sc.nextLine().trim();

        System.out.println("Enter appointment time hh-mm-ss ");
        String time=sc.nextLine().trim();

        try{
            Connection conn=DBConnection.getConnection();
            String sql="INSERT INTO APPOINTMENT (doctor_id,patient_id,date,time) VALUES (?,?,?,?)";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,doctorid);
            pre.setInt(2,patientid);
            pre.setDate(3, Date.valueOf(date));
            pre.setTime(4,Time.valueOf(time));

            pre.executeUpdate();

            System.out.println("Appointment booked succesfully");

            pre.close();
            conn.close();

        }catch(Exception e){
            System.out.println("Error at booking appointment");
            e.printStackTrace();
        }


    }

}
