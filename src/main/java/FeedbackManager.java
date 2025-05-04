/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.main;

import java.util.ArrayList;
import java.util.List;


public class FeedbackManager {
      public void addFeedback(Appointment appointment, String feedback) {
        if (appointment != null && appointment.isBooked()) {
            appointment.addFeedback(feedback);
        } else {
            System.out.println("Cannot add feedback. Appointment not booked or invalid ID.");
        }
    }

    public void viewFeedback(Appointment appointment) {
        if (appointment != null) {
            System.out.println("Feedback for Appointment ID " + appointment.getId() + ": " + appointment.getFeedback());
        } else {
            System.out.println("Appointment not found.");
        }
    }



}
