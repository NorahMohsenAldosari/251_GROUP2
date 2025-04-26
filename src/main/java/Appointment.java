
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nora
 */
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
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

    public boolean isIsBooked() {
        return isBooked;
    }
     
    public void displayAppointment() {
        System.out.println("Appointment ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Location: " + location);
        System.out.println("customer: " + (isBooked ? customerName : "Available"));
        System.out.println("----------------------");
    }



    public String toFileString() {
        return id + "," + date + "," + time + "," + location + "," + isBooked + "," + customerName;
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


