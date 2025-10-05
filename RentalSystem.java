import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Vehicle> availableVehicles;
    private List<RentedVehicle> rentedVehicles;

    public RentalSystem() {
        availableVehicles = new ArrayList<>();
        rentedVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }

    // Return list of currently available vehicles
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> available = new ArrayList<>();
        for (Vehicle v : availableVehicles) {
            if (v.isAvailable()) {
                available.add(v);
            }
        }
        return available;
    }

    public void showAvailableVehicles() {
        System.out.println("\nAvailable Vehicles:");
        for (Vehicle v : availableVehicles) {
            if (v.isAvailable())
                System.out.println(v.getDetails());
        }
    }

    public void showRentedVehicles() {
        System.out.println("\nRented Vehicles:");
        for (RentedVehicle rv : rentedVehicles) {
            System.out.println(rv.getReceipt());
        }
    }

    public void rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (vehicle.isAvailable()) {
            RentedVehicle rv = new RentedVehicle(vehicle, customer, days);
            rentedVehicles.add(rv);
            System.out.println("\nVehicle rented: " + rv.getReceipt());
        } else {
            System.out.println("Vehicle is already rented.");
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        RentedVehicle toRemove = null;
        for (RentedVehicle rv : rentedVehicles) {
            if (rv.getVehicle() == vehicle) {
                vehicle.setAvailable(true);
                toRemove = rv;
                System.out.println("\nVehicle returned: " + vehicle.getDetails());
                break;
            }
        }
        if (toRemove != null) rentedVehicles.remove(toRemove);
    }
}
