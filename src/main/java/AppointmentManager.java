package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {


    private static final String AVAILABLE_FILE = "available_appointments.txt";

    public void addAvailableAppointment(String date, String time, String location) {
        Appointment appointment = new Appointment(date, time, location);
        saveAppointmentToFile(appointment, AVAILABLE_FILE);
    }

    public void removeAvailableAppointment(int appointmentId) {
        List<Appointment> appointments = loadAppointmentsFromFile(AVAILABLE_FILE);
        appointments.removeIf(app -> app.getId() == appointmentId);
        overwriteAppointmentsToFile(appointments, AVAILABLE_FILE);
    }

    public List<Appointment> getAvailableAppointments() {
        return loadAppointmentsFromFile(AVAILABLE_FILE);
    }

    private void saveAppointmentToFile(Appointment app, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(app.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void overwriteAppointmentsToFile(List<Appointment> appointments, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Appointment app : appointments) {
                writer.write(app.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Appointment> loadAppointmentsFromFile(String filename) {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Appointment app = Appointment.fromFileString(line);
                if (app != null) {
                    appointments.add(app);
                }
            }
        } catch (IOException e) {
            
        }
        return appointments;
    }
}    
    





