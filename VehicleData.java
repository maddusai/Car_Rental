import java.util.ArrayList;
import java.util.List;

public class VehicleData {
    public static List<Vehicle> getSampleVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota", "Camry", 2022, 60, 5));
        vehicles.add(new Car("Honda", "Civic", 2021, 50, 5));
        vehicles.add(new Motorbike("Yamaha", "R15", 2023, 30, 150));
        vehicles.add(new Truck("Volvo", "FH16", 2020, 200, 10));
        return vehicles;
    }
}
