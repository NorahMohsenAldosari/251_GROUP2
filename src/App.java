import java.util.Random;

public class App {


    
    int id ;
    String customerName ;
    String date ;
    String time ;
    String location ;
    boolean isBooked ; 
    
    
    private int generateRandomId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
  
        public int getId() {
            return id;
        }
    
        public String getCustomerName() {
            return customerName;
        }
    
        public String getDate() {
            return date;
        }
    
        public String getTime() {
            return time;
        }
    
        public String getLocation() {
            return location;
        }
    
        public boolean isBooked() {
            return isBooked;
        }

    

    public void displayAppointment() {
        
        System.out.println("Appointment ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Location: " + location);
        
        System.out.println("Customer: " + (isBooked ? customerName : "Available"));

    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
