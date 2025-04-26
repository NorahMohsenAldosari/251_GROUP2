
package main.java;
import java.util.Random;

public class Appointment {
    
 
        private int id;
        private String customerName;
        private String date;
        private String time;
        private String location;
        private boolean isBooked;
    
        public Appointment(String date, String time, String location) {
            this.id = generateRandomId();
            this.customerName = "Not booked";
            this.date = date;
            this.time = time;
            this.location = location;
            this.isBooked = false;
        }
    
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
            System.out.println("----------------------");
            }

            public static Appointment fromFileString(String line) {
            try {
            String[] parts = line.split(",");
            if (parts.length < 6) return null;
                Appointment appointment = new Appointment(parts[1], parts[2], parts[3]);
                appointment.id = Integer.parseInt(parts[0]);
                appointment.isBooked = Boolean.parseBoolean(parts[4]);
                appointment.customerName = parts[5];
                return appointment;
            } catch (Exception e) {
                return null;
               }
            }
        }
    

