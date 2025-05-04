/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    
         public static void saveAppointments(List<Appointment> appointments) {
        try (FileWriter writer = new FileWriter("appointments.txt", false)) {
            for (Appointment appt : appointments) {
                writer.write("ID: " + appt.getId() + ", Date: " + appt.getDate() + ", Time: " + appt.getTime() + ", Location: " + appt.getLocation() + ", Booked: " + appt.isBooked() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      public static void saveFeedback(List<String> feedbackList) {
        try (FileWriter writer = new FileWriter("feedback.txt", false)) {
            for (String feedback : feedbackList) {
                writer.write(feedback + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      public static void saveCustomerInfo(List<Customer> customers) {
        try (FileWriter writer = new FileWriter("customers.txt", false)) {
            for (Customer customer : customers) {
                writer.write("Name: " + customer.getName() + ", Phone: " + customer.getPhone() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static List<String> readAppointments() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
public static List<String> readFeedback() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
 public static List<String> readCustomerInfo() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


}
