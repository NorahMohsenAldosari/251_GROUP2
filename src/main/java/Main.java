/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ass.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 


public class Main {
  
    static Scanner scanner = new Scanner(System.in);
    static List<Appointment> appointments = new ArrayList<>();
    static List<Customer> customersList = new ArrayList<>();
    static List<String> feedbackList = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
         System.out.println("Welcome to Large Waste Collection System!");
       System.out.println("---------------------------------------------");
       System.out.println("---------------------------------------------");

        while (running) {
            System.out.println("\nChoose mode:");
            System.out.println("1. Customer Mode");
            System.out.println("2. Manager Mode");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int mode = scanner.nextInt();
            scanner.nextLine();

            if (mode == 1) {
                customerMode();
            } else if (mode == 2) {
                managerMode();
            } else if (mode == 3) {
                running = false;
                System.out.println("Thank you for using the system!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void customerMode() {
        System.out.println("\nAvailable Appointments:");
        boolean hasAppointments = false;
        for (Appointment appt : appointments) {
            if (!appt.isBooked()) {
                System.out.println(appt);
                hasAppointments = true;
            }
        }
        if (!hasAppointments) {
            System.out.println("No available appointments.");
            return;
        }

        System.out.print("\nDo you want to book an appointment? (yes/no): ");
        String response = scanner.nextLine();
        if (!response.equalsIgnoreCase("yes")) return;

        System.out.print("Enter Appointment ID to book: ");
        int idToBook = scanner.nextInt();
        scanner.nextLine();

        Appointment selected = findAppointmentById(appointments, idToBook);

        if (selected != null && !selected.isBooked()) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String phone = scanner.nextLine();

            selected.bookAppointment(name, phone);
            customersList.add(new Customer(name, phone));
            FileHandler.saveAppointments(appointments);
            FileHandler.saveCustomerInfo(customersList);

            System.out.println("Appointment booked successfully!");

            boolean managing = true;
            while (managing) {
                System.out.println("\n--- Current Appointment ID " + selected.getId() + " ---");
                System.out.println("Choose an option:");
                System.out.println("1. Cancel Appointment");
                System.out.println("2. Reschedule Appointment");
                System.out.println("3. View Appointment State");
                System.out.println("4. Leave Feedback");
                System.out.println("5. Back to Main Menu");
                System.out.print("Your choice: ");
                int option = scanner.nextInt();
                scanner.nextLine();



                if (option == 1) {
                    selected.cancelBooking();
                    FileHandler.saveAppointments(appointments);
                    System.out.println("Appointment canceled.");
                    managing = false;

                } else if (option == 2) {
                    System.out.println("\nAvailable Appointments for Reschedule:");
                    for (Appointment a : appointments) {
                        if (!a.isBooked() && a.getId() != selected.getId()) {
                            System.out.println(a);
                        }
                    }
                    System.out.print("Enter new Appointment ID to reschedule: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();
                    Appointment newAppointment = findAppointmentById(appointments, newId);
                    if (newAppointment != null && !newAppointment.isBooked()) {
                        newAppointment.bookAppointment(selected.getCustomerName(), selected.getPhoneNumber());
                        selected.cancelBooking();
                        selected = newAppointment;
                        FileHandler.saveAppointments(appointments);
                        System.out.println("Appointment rescheduled successfully!");
                    } else {
                        System.out.println("Invalid appointment ID.");
                    }

                } else if (option == 3) {
                    System.out.println(selected);

                } else if (option == 4) {
                    System.out.print("Enter your feedback: ");
                    String feedback = scanner.nextLine();
                    selected.addFeedback(feedback);
                    feedbackList.add(feedback);
                    FileHandler.saveFeedback(feedbackList);
                    System.out.println("Feedback added. Thank you!");

                } else if (option == 5) {
                    managing = false;

                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid appointment ID or already booked.");
        }
    }

    public static void managerMode() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. Remove Appointment");
            System.out.println("3. View All Appointments");
            System.out.println("4. View Feedback");
            System.out.println("5. Back to Main Menu");
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter Time (e.g., 10:00 AM): ");
                String time = scanner.nextLine();
                System.out.print("Enter Location: ");
                String location = scanner.nextLine();

                appointments.add(new Appointment(date, time, location));
                FileHandler.saveAppointments(appointments);
                System.out.println("Appointment added successfully.");

            } else if (option == 2) {
                System.out.print("Enter appointment ID to remove: ");
                int idToRemove = scanner.nextInt();
                scanner.nextLine();
                appointments.removeIf(appt -> appt.getId() == idToRemove);
                FileHandler.saveAppointments(appointments);
                System.out.println("Appointment removed.");

            } else if (option == 3) {
                System.out.println("\n--- All Appointments ---");
                if (appointments.isEmpty()) {
                    System.out.println("No appointments to display.");
                } else {
                    for (Appointment appt : appointments) {
                        System.out.println(appt);
                    }
                }

            } else if (option == 4) {
                System.out.println("\n--- All Feedback ---");
                if (feedbackList.isEmpty()) {
                    System.out.println("No feedback submitted yet.");
                } else {
                    for (String f : feedbackList) {
                        System.out.println(f);
                    }
                }

            } else if (option == 5) {
                managing = false;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static Appointment findAppointmentById(List<Appointment> list, int id) {
        for (Appointment appt : list) {
            if (appt.getId() == id) {
                return appt;
            }
        }
        return null;
    }

}