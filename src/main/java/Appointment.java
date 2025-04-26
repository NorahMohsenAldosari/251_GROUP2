
package main.java;
import java.util.Random;

public class Appointment {
    
 
    private int id;
    private String customerName;
    private String phoneNumber;
    private String date;
    private String time;
    private String location;
    private boolean isBooked;

    public Appointment(String date, String time, String location) {
        this.id = generateRandomId();
        this.customerName = "Not booked";
        this.phoneNumber = "Not provided";
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

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void book(String customerName, String phoneNumber) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.isBooked = true;
    }

    public void cancel() {
        this.customerName = "Not booked";
        this.phoneNumber = "Not provided";
        this.isBooked = false;
    }

    public void reschedule(String newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
    }

    public String toFileString() {
        return id + "," + customerName + "," + phoneNumber + "," + date + "," + time + "," + location + "," + isBooked;
    }

    public static Appointment fromFileString(String line) {
        try {
            String[] parts = line.split(",");
            Appointment app = new Appointment(parts[3], parts[4], parts[5]);
            app.id = Integer.parseInt(parts[0]);
            app.customerName = parts[1];
            app.phoneNumber = parts[2];
            app.isBooked = Boolean.parseBoolean(parts[6]);
            return app;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + date + " " + time + " @ " + location +
               (isBooked ? " | Booked by: " + customerName + ", " + phoneNumber : " | Available");
    }
}