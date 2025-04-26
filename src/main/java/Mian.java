/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nora
 */

    import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        AppointmentManager manager = new AppointmentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Menu ======");
            System.out.println("0. Add Appointment (Manager)");
            System.out.println("1. View Appointments");
            System.out.println("2. Book");
            System.out.println("3. Current Appointment Options");
            System.out.println("4. Exit");
            System.out.println("9. Remove Appointment (Manager)");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter time (HH:MM): ");
                String time = scanner.nextLine();
                System.out.print("Enter location: ");
                String location = scanner.nextLine();
                manager.addAvailableAppointment(date, time, location);
                System.out.println("✅ Appointment added by manager.");
            } else if (choice == 1) {
                List<Appointment> list = manager.getAvailableAppointments();
                if (list.isEmpty()) {
                    System.out.println("No appointments found.");
                } else {
                    list.forEach(System.out::println);
                }
            } else if (choice == 2) {
                int weekOffset = 0;
                while (true) {
                    LocalDate today = LocalDate.now().plusWeeks(weekOffset);
                    LocalDate startOfWeek = today.with(java.time.DayOfWeek.SUNDAY);
                    LocalDate endOfWeek = startOfWeek.plusDays(6);

                    System.out.println("\nAvailable Appointments (Week of " + startOfWeek + " to " + endOfWeek + "):");
                    List<Appointment> appointments = manager.getAvailableAppointments();
                    boolean found = false;
                    for (Appointment app : appointments) {
                        LocalDate appDate = LocalDate.parse(app.getDate(), DATE_FORMAT);
                        if (!app.isBooked() && (appDate.isEqual(startOfWeek) || (appDate.isAfter(startOfWeek) && appDate.isBefore(endOfWeek.plusDays(1))))) {
                            System.out.println(app);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No available appointments this week.");
                    }

                    System.out.println("\nN: Next week, P: Previous week, B: Book, Q: Quit booking");
                    System.out.print("Choice: ");
                    String nav = scanner.nextLine().toUpperCase();
                    if (nav.equals("N")) weekOffset++;
                    else if (nav.equals("P")) weekOffset--;
                    else if (nav.equals("B")) {
                        System.out.print("Enter appointment ID to book: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phone = scanner.nextLine();

                        boolean booked = manager.bookAppointment(bookId, name, phone);
                        System.out.println(booked ? "✅ Booked successfully." : "❌ Booking failed.");
                        break;
                    } else if (nav.equals("Q")) {
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter your current appointment ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                Appointment app = manager.findAppointmentById(id);
                if (app == null || !app.isBooked()) {
                    System.out.println("❌ Not found or not booked.");
                    continue;
                }

                System.out.println("📌 Found: " + app);
                System.out.println("1. Cancel\n2. Reschedule\n3. View Status");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    boolean canceled = manager.cancelAppointment(id);
                    System.out.println(canceled ? "✅ Canceled." : "❌ Cancel failed.");
                } else if (action == 2) {
                    System.out.print("New date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("New time: ");
                    String newTime = scanner.nextLine();
                    boolean updated = manager.rescheduleAppointment(id, newDate, newTime);
                    System.out.println(updated ? "✅ Rescheduled." : "❌ Reschedule failed.");
                } else if (action == 3) {
                    System.out.println("👤 Booked by " + app.getCustomerName() + ", phone: " + app.getPhoneNumber());
                }
            } else if (choice == 9) {
                System.out.print("Enter appointment ID to remove: ");
                int removeId = scanner.nextInt();
                scanner.nextLine();
                manager.removeAvailableAppointment(removeId);
                System.out.println("🗑️ Appointment removed by manager.");
            } else if (choice == 4) {
                System.out.println("👋 Exiting...");
                break;
            }
        }

        scanner.close();
    }
}

