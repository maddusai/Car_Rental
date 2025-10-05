import java.util.ArrayList;
import java.util.List;

public class VehicleData {
    public static List<Vehicle> getPredefinedVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Toyota", "Camry", 2020, 50,8, 4, false, "Petrol"));
        vehicles.add(new Car("Honda", "Civic", 2021, 55, 4,9, false, "Petrol"));
        vehicles.add(new Car("Ford", "Mustang", 2019, 70, 2, 10,true, "Petrol"));
        vehicles.add(new Car("Hyundai", "Elantra", 2020, 45, 4,5, false, "Diesel"));
        vehicles.add(new Car("Chevrolet", "Malibu", 2018, 50, 4,7, false, "Petrol"));
        vehicles.add(new Car("BMW", "3 Series", 2021, 85, 4,7, true, "Petrol"));
        vehicles.add(new Car("Audi", "A4", 2022, 90, 4,11, true, "Diesel"));
        vehicles.add(new Car("Mercedes", "C-Class", 2020, 100, 4,21, true, "Petrol"));
        vehicles.add(new Car("Volkswagen", "Passat", 2019, 60, 4, 10,false, "Diesel"));
        vehicles.add(new Car("Tesla", "Model 3", 2022, 110, 4, 15,true, "Electric"));

        vehicles.add(new Motorbike("Yamaha", "YZF-R3", 2019, 30, "Sport"));
        vehicles.add(new Motorbike("Kawasaki", "Ninja 400", 2020, 35, "Sport"));
        vehicles.add(new Motorbike("Royal Enfield", "Classic 350", 2022, 25, "Cruiser"));
        vehicles.add(new Motorbike("Ducati", "Monster", 2021, 50, "Naked"));
        vehicles.add(new Motorbike("Harley-Davidson", "Iron 883", 2019, 55, "Cruiser"));
        vehicles.add(new Motorbike("KTM", "Duke 390", 2020, 40, "Sport"));
        vehicles.add(new Motorbike("Honda", "CBR500R", 2021, 45, "Sport"));
        vehicles.add(new Motorbike("Suzuki", "GSX-R600", 2018, 50, "Sport"));
        vehicles.add(new Motorbike("Triumph", "Street Triple", 2022, 60, "Naked"));
        vehicles.add(new Motorbike("BMW", "G310R", 2020, 35, "Naked"));

        vehicles.add(new Truck("Ford", "F-150", 2022, 80, 5, true, "Cargo"));
        vehicles.add(new Truck("Chevrolet", "Silverado", 2021, 85, 6, true, "Cargo"));
        vehicles.add(new Truck("Ram", "2500", 2020, 90, 7, true, "Heavy-Duty"));
        vehicles.add(new Truck("Volvo", "FH16", 2022, 120, 8, true, "Heavy-Duty"));
        vehicles.add(new Truck("Scania", "R500", 2021, 115, 10, true, "Cargo"));
        vehicles.add(new Truck("Mercedes-Benz", "Actros", 2020, 110, 8, true, "Heavy-Duty"));
        vehicles.add(new Truck("Mack", "Anthem", 2019, 100, 6, true, "Cargo"));
        vehicles.add(new Truck("Isuzu", "NPR", 2020, 75, 4, true, "Medium-Duty"));
        vehicles.add(new Truck("Kenworth", "T680", 2021, 105, 8, true, "Heavy-Duty"));
        vehicles.add(new Truck("Hino", "500 Series", 2022, 90, 5, true, "Medium-Duty"));

        return vehicles;
    }
}
