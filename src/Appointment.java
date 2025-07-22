import java.sql.Date;
import java.util.Scanner;
import java.util.*;
import java.sql.ResultSet;
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
    public static void viewAppointment(){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="SELECT * FROM APPOINTMENT ";
            Statement smt=conn.createStatement();
            ResultSet rs=smt.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                int doctor_id=rs.getInt("doctor_id");
                int patient_id=rs.getInt("patient_id");
                Date date=rs.getDate("date");
                Time time=rs.getTime("time");

                System.out.println(" ID "+ id +
                                   " DOCTOR ID "+ doctor_id+
                                   " PATIENT ID "+ patient_id+
                                   " DATE "+ date+
                                   " TIME "+time);

            }
        } catch (Exception e) {
            System.out.println("Error at fetching appointment ");
            e.printStackTrace();

        }
    }
    public static void deleteAppointment(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Appointment Id to delete");
        int id=sc.nextInt();
        try{
            Connection conn=DBConnection.getConnection();
            String sql="DELETE FROM APPOINTMENT WHERE ID = ?";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);

            int rows=pre.executeUpdate();
            if(rows>0){
                System.out.println("Appointment deleted successfully");
            }else{
                System.out.println("Appointment not found");
            }

        }catch (Exception e){
            System.out.println("Error at delete appointment");
            e.printStackTrace();
        }
    }

}
