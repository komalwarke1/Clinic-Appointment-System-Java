import java.sql.*;
import java.util.Scanner;

public class Patient {
    public static void addPatient(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter patient name");
        String name=sc.nextLine();

        System.out.println("Enter age");
        int age=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter gender");
        String gender=sc.nextLine();

        try{
            Connection conn= DBConnection.getConnection();
            String sql="INSERT INTO PATIENT (NAME,AGE,GENDER) VALUES (?,?,?)";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,name);
            pre.setInt(2,age);
            pre.setString(3,gender);
            pre.executeUpdate();

            System.out.println("Patient added successfully");
            pre.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void viewPatient(){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="SELECT * FROM PATIENT ";
            Statement smt=conn.createStatement();
            ResultSet rs=smt.executeQuery(sql);
            while(rs.next()){
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String gender=rs.getString("gender");
                System.out.println(" Name "+name+
                                   " Age "+age+
                                   " Gender "+gender);
            }

        }catch(Exception e){
            System.out.println("Error at fetching patient data");
            e.printStackTrace();
        }
    }

    public static void deletePatient(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter patient id to delete");
        int id=sc.nextInt();

        try{
            Connection conn=DBConnection.getConnection();
            String sql="DELETE FROM PATIENT WHERE ID=?";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);
            int rows=pre.executeUpdate();
            if(rows>0){
                System.out.println("Patient deleted successfully");
            }else{
                System.out.println("No patient found of the ID");
            }

        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Cannot delete patient. Appointment exists for this patient.");
        }catch(Exception e){
            System.out.println("Error at delete patient");
            e.printStackTrace();

        }
    }
}
