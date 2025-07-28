import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BusTicketMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] routes = {"City A to City B", "City A to City C", "City A to City D"};
        String[] busTypes = {"Non-AC", "AC", "Sleeper"};
        int[] fares = {300, 500, 700};

        char continueBooking;

        do {
            System.out.println("==== Welcome to Bus Ticket Tailor Machine ====");

            // Display Routes
            System.out.println("Available Routes:");
            for (int i = 0; i < routes.length; i++) {
                System.out.println((i + 1) + ". " + routes[i]);
            }
            System.out.print("Select route (1-" + routes.length + "): ");
            int routeChoice = sc.nextInt();
            String selectedRoute = routes[routeChoice - 1];

            // Display Bus Types
            System.out.println("\nSelect Bus Type:");
            for (int i = 0; i < busTypes.length; i++) {
                System.out.println((i + 1) + ". " + busTypes[i] + " (₹" + fares[i] + ")");
            }
            System.out.print("Enter choice: ");
            int busChoice = sc.nextInt();
            String selectedBusType = busTypes[busChoice - 1];
            int farePerTicket = fares[busChoice - 1];

            // Number of Passengers
            System.out.print("\nEnter number of passengers: ");
            int passengers = sc.nextInt();
            int totalFare = farePerTicket * passengers;

            // Print Ticket
            System.out.println("\n---- Ticket ----");
            System.out.println("Route: " + selectedRoute);
            System.out.println("Bus Type: " + selectedBusType);
            System.out.println("Passengers: " + passengers);
            System.out.println("Total Fare: ₹" + totalFare);

            // Date & Time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("Date & Time: " + now.format(formatter));
            System.out.println("-----------------\n");

            // Ask to continue
            System.out.print("Do you want to book another ticket? (y/n): ");
            continueBooking = sc.next().charAt(0);

            System.out.println();
        } while (continueBooking == 'y' || continueBooking == 'Y');

        System.out.println("Thank you for using the Bus Ticket Tailor Machine!");
        sc.close();
    }
}
