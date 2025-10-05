import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Vehicle> availableVehicles;
    private List<Vehicle> rentedVehicles;

    public RentalSystem() {
        availableVehicles = new ArrayList<>();
        rentedVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void rentVehicle(Vehicle vehicle) {
        if (availableVehicles.contains(vehicle)) {
            availableVehicles.remove(vehicle);
            rentedVehicles.add(vehicle);
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        if (rentedVehicles.contains(vehicle)) {
            rentedVehicles.remove(vehicle);
            availableVehicles.add(vehicle);
        }
    }

    public void displayRentalInfo() {
        System.out.println("Available Vehicles:");
        for (Vehicle v : availableVehicles) {
            v.displayInfo();
            System.out.println();
        }

        System.out.println("Rented Vehicles:");
        for (Vehicle v : rentedVehicles) {
            v.displayInfo();
            System.out.println();
        }
    }

    public double calculateRentalCost(Vehicle vehicle, int rentalDuration) {
        return vehicle.getDailyRentalRate() * rentalDuration;
    }
}
