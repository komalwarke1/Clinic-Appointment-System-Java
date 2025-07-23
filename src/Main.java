import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int choice;
       do{
           System.out.println("\n----------Clinic Appointment Booking System -----------");
           System.out.println("1. Add Doctor");
           System.out.println("2. View Doctors");
           System.out.println("3. Add Patient");
           System.out.println("4. View Patients");
           System.out.println("5. Book Appointment");
           System.out.println("6. View All Appointments");
           System.out.println("7. View Appointment by Date");
           System.out.println("8. Delete Appointment");
           System.out.println("9. Exit");
           System.out.print("Enter your choice: ");
           choice=sc.nextInt();
           sc.nextLine();

           switch(choice){
               case 1:Doctor.addDoctor();
                   break;
               case 2:Doctor.viewDoctor();
                   break;
               case 3:Patient.addPatient();
                   break;
               case 4:Patient.viewPatient();
                   break;
               case 5:Patient.updatePatient();
               break;
               case 6:Appointment.addAppointment();
                   break;
               case 7:Appointment.viewAppointment();
                   break;
               case 8:Appointment.viewAppointmentByDate();
                   break;
               case 9:Appointment.deleteAppointment();
                   break;
               case 10:System.exit(0);
                   break;
               default:
                   System.out.println("Enter valid choice :) ");

           }
       }while(choice!=10);



    }
}
