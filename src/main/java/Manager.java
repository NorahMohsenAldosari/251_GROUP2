/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ragha
 */
public class Manager {
    
   private List<Appointment> appointments;

    public Manager() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(String date, String time, String location) {
        appointments.add(new Appointment(date, time, location));
    }

    public List<Appointment> getAvailableAppointments() {
        List<Appointment> available = new ArrayList<>();
        for (Appointment app : appointments) {
            if (!app.isBooked()) {
                available.add(app);
            }
        }
        return available;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment findAppointmentById(int id) {
        for (Appointment app : appointments) {
            if (app.getId() == id) {
                return app;
            }
        }
        return null;
    }

    public void removeAppointment(int id) {
        appointments.removeIf(app -> app.getId() == id);
    }
}
