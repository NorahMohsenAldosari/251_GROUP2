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
}
}

