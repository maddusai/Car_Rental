public class RentalSystemDemo {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        // Add sample vehicles
        for (Vehicle v : VehicleData.getSampleVehicles()) {
            rentalSystem.addVehicle(v);
        }

        // Show all available vehicles
        rentalSystem.showAvailableVehicles();

        // Create customers
        Customer c1 = new Customer("John");
        Customer c2 = new Customer("Alice");

        // Rent vehicles
        rentalSystem.rentVehicle(rentalSystem.getAvailableVehicles().get(0), c1, 3);
        rentalSystem.rentVehicle(rentalSystem.getAvailableVehicles().get(1), c2, 2);

        // Show rented vehicles
        rentalSystem.showRentedVehicles();

        // Show available vehicles after renting
        rentalSystem.showAvailableVehicles();

        // Return a vehicle
        rentalSystem.returnVehicle(rentalSystem.getAvailableVehicles().get(0));

        // Show final state
        rentalSystem.showAvailableVehicles();
        rentalSystem.showRentedVehicles();
    }
}
