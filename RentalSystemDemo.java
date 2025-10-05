import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystemDemo {
    private static Customer currentCustomer = null;
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = VehicleData.getPredefinedVehicles(); 
        List<RentedVehicle> rentedVehicles = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. Register/Login as a Customer");
            System.out.println("2. Show List of Vehicles");
            System.out.println("3. Rent a Vehicle");
            System.out.println("4. Return a Vehicle");
            System.out.println("5. View Rented Vehicles");
            System.out.println("6. Switch Customer");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (mainChoice) {
                case 1:
                    handleCustomerRegistration(scanner);
                    break;
                case 2:
                    handleShowVehicles(scanner, vehicles, rentedVehicles);
                    break;
                case 3:
                    handleRentVehicle(scanner, vehicles, rentedVehicles);
                    break;
                case 4:
                    handleReturnVehicle(scanner, rentedVehicles);
                    break;
                case 5:
                    handleViewRentedVehicles(rentedVehicles);
                    break;
                case 6:
                    switchCustomer(scanner);
                    break;
                case 7:
                    System.out.println("Thank you for using the Vehicle Rental System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void handleCustomerRegistration(Scanner scanner) {
        System.out.println("\n--- Customer Registration/Login ---");
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter License: ");
        String license = scanner.nextLine();

        currentCustomer = new Customer(name, contactNumber, email, address, license);
        customers.add(currentCustomer);

        System.out.println("\nRegistration Successful!");
        System.out.println("Welcome, " + currentCustomer.getName());
    }

    private static void handleShowVehicles(Scanner scanner, List<Vehicle> vehicles, List<RentedVehicle> rentedVehicles) {
        System.out.println("\nDo you want to view the list of vehicles? (Yes/No)");
        String viewListChoice = scanner.next();

        if (viewListChoice.equalsIgnoreCase("Yes")) {
            while (true) {
                System.out.println("\nSelect a Vehicle Type:");
                System.out.println("1. Cars");
                System.out.println("2. Motorbikes");
                System.out.println("3. Trucks");
                System.out.println("4. Return to Main Menu");
                System.out.print("Enter your choice: ");

                int typeChoice = scanner.nextInt();

                switch (typeChoice) {
                    case 1:
                        displayVehiclesByType(vehicles, rentedVehicles, "Car");
                        break;
                    case 2:
                        displayVehiclesByType(vehicles, rentedVehicles, "Motorbike");
                        break;
                    case 3:
                        displayVehiclesByType(vehicles, rentedVehicles, "Truck");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("Returning to Main Menu...");
        }
    }

    private static void displayVehiclesByType(List<Vehicle> vehicles, List<RentedVehicle> rentedVehicles, String type) {
        System.out.println("\n--- List of " + type + "s ---");
        int count = 0;

        for (Vehicle vehicle : vehicles) {
            if ((type.equals("Car") && vehicle instanceof Car) ||
                (type.equals("Motorbike") && vehicle instanceof Motorbike) ||
                (type.equals("Truck") && vehicle instanceof Truck)) {
                
                boolean isRented = isVehicleRented(vehicle, rentedVehicles);

                count++;
                System.out.println(count + ". " + vehicle.getMake() + " " + vehicle.getModel() + 
                                   " (" + vehicle.getYear() + ") - " + 
                                   (isRented ? "Not Available" : "Available") +
                                   " | Daily Rate: $" + vehicle.getDailyRentalRate());
            }
        }

        if (count == 0) {
            System.out.println("No " + type + "s are available at the moment.");
        }
    }

    private static boolean isVehicleRented(Vehicle vehicle, List<RentedVehicle> rentedVehicles) {
        for (RentedVehicle rv : rentedVehicles) {
            if (rv.getVehicle() == vehicle) {
                return true;
            }
        }
        return false;
    }

    private static void handleRentVehicle(Scanner scanner, List<Vehicle> vehicles, List<RentedVehicle> rentedVehicles) {
        System.out.println("\nRental Options:");
        System.out.println("1. Rent by Day");
        System.out.println("2. Rent by Hour");
        System.out.print("Choose rental option: ");
        int rentalOption = scanner.nextInt();

        System.out.println("\nEnter the make and model of the vehicle you want to rent:");
        System.out.print("Company: ");
        String make = scanner.next();
        System.out.print("Model: ");
        String model = scanner.next();

        Vehicle vehicleToRent = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehicleToRent = vehicle;
                break;
            }
        }

        if (vehicleToRent != null) {
            boolean isAlreadyRented = isVehicleRented(vehicleToRent, rentedVehicles);
            
            if (isAlreadyRented) {
                System.out.println("Sorry, the vehicle is currently not available. It has already been rented.");
                return;
            }

            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. Cash");
            System.out.println("4. Digital Wallet");
            System.out.print("Choose payment method: ");
            int paymentChoice = scanner.nextInt();
            RentedVehicle.PaymentMethod paymentMethod;

            switch (paymentChoice) {
                case 1: paymentMethod = RentedVehicle.PaymentMethod.CREDIT_CARD; break;
                case 2: paymentMethod = RentedVehicle.PaymentMethod.DEBIT_CARD; break;
                case 3: paymentMethod = RentedVehicle.PaymentMethod.CASH; break;
                case 4: paymentMethod = RentedVehicle.PaymentMethod.DIGITAL_WALLET; break;
                default: 
                    System.out.println("Invalid payment method. Defaulting to Cash.");
                    paymentMethod = RentedVehicle.PaymentMethod.CASH;
            }

            double totalCost;
            int duration;
            if (rentalOption == 1) {
                System.out.print("Enter the number of days for booking: ");
                duration = scanner.nextInt();
                totalCost = vehicleToRent.getDailyRentalRate() * duration;
            } else if (rentalOption == 2) {
                System.out.print("Enter the number of hours for booking: ");
                duration = scanner.nextInt();
                totalCost = vehicleToRent.getHourlyRentalRate() * duration;
            } else {
                System.out.println("Invalid rental option.");
                return;
            }

            RentedVehicle rentedVehicle = new RentedVehicle(
                vehicleToRent, 
                currentCustomer, 
                duration, 
                totalCost, 
                (rentalOption == 1 ? "daily" : "hourly"),
                paymentMethod
            );

            if (rentedVehicle.processPayment()) {
                rentedVehicles.add(rentedVehicle);

                System.out.println("You have successfully rented: " + vehicleToRent.getMake() + " " + vehicleToRent.getModel());
                System.out.println("Booked under Name: " + currentCustomer.getName());
                System.out.println("Total cost for " + duration + " " + (rentalOption == 1 ? "days" : "hours") + ": $" + totalCost);
            } else {
                System.out.println("Payment failed. Rental unsuccessful.");
            }
        } else {
            System.out.println("The vehicle is not found in our inventory.");
        }
    }

    private static void handleReturnVehicle(Scanner scanner, List<RentedVehicle> rentedVehicles) {
        if (rentedVehicles.isEmpty()) {
            System.out.println("\nNo rented vehicles to return.");
            return;
        }

        System.out.println("\nEnter the make and model of the vehicle you want to return:");
        System.out.print("Company: ");
        String make = scanner.next();
        System.out.print("Model: ");
        String model = scanner.next();

        RentedVehicle vehicleToReturn = null;
        for (RentedVehicle rv : rentedVehicles) {
            if (rv.getVehicle().getMake().equalsIgnoreCase(make) &&
                rv.getVehicle().getModel().equalsIgnoreCase(model) &&
                rv.getCustomer().getCustomerId().equals(currentCustomer.getCustomerId())) {
                vehicleToReturn = rv;
                break;
            }
        }

        if (vehicleToReturn != null) {
            rentedVehicles.remove(vehicleToReturn);
            System.out.println("Vehicle successfully returned!");
            System.out.println("Vehicle: " + vehicleToReturn.getVehicle().getMake() + " " + vehicleToReturn.getVehicle().getModel());
            System.out.println("Returned by: " + currentCustomer.getName());
        } else {
            System.out.println("No matching rental found for this vehicle under your name.");
        }
    }

    private static void handleViewRentedVehicles(List<RentedVehicle> rentedVehicles) {
        if (rentedVehicles.isEmpty()) {
            System.out.println("\nNo vehicles are currently rented.");
            return;
        }

        System.out.println("\n--- Rented Vehicles ---");
        for (RentedVehicle rv : rentedVehicles) {
            System.out.println("Vehicle: " + rv.getVehicle().getMake() + " " + rv.getVehicle().getModel() +
                    ", Year: " + rv.getVehicle().getYear() +
                    ", Rented by: " + rv.getCustomer().getName() +
                    ", Duration: " + rv.getFormattedDuration() +
                    ", Total Cost: $" + rv.getTotalCost());
        }
    }

    private static void switchCustomer(Scanner scanner) {
        if (customers.isEmpty()) {
            System.out.println("\nNo registered customers. Please register first.");
            return;
        }

        System.out.println("\n--- Switch Customer ---");
        System.out.println("Select a customer by ID:");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println((i + 1) + ". " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
        }

        System.out.print("Enter customer number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice >= 1 && choice <= customers.size()) {
            currentCustomer = customers.get(choice - 1);
            System.out.println("Switched to: " + currentCustomer.getName());
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
