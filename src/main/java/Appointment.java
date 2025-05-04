/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.main;

import java.util.Random;

public class Appointment {
    private int id;
    private String customerName;
    private String phoneNumber;
    private String date;
    private String time;
    private String location;
    private boolean isBooked;
    private String feedback;

    public Appointment(String date, String time, String location) {
        this.id = generateRandomId();
        this.customerName = "Not booked";
        this.phoneNumber = "None";
        this.date = date;
        this.time = time;
        this.location = location;
        this.isBooked = false;
        this.feedback = "";
    }

    private int generateRandomId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    public int getId() {
        return id;
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


    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookAppointment(String customerName, String phoneNumber) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.isBooked = true;
    }

    public void cancelBooking() {
        this.customerName = "Not booked";
        this.phoneNumber = "None";
        this.isBooked = false;
    }

    public void addFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback.isEmpty() ? "No feedback yet." : feedback;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Date: " + date + ", Time: " + time +
               ", Location: " + location + ", Booked: " + (isBooked ? "Yes" : "No") +
               (isBooked ? (", Customer: " + customerName + ", Phone: " + phoneNumber) : "");
    }

}
