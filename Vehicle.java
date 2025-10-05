public class Vehicle {
    private String make;
    private String model;
    private int year;
    private double dailyRentalRate;
    private double hourlyRentalRate;

    public Vehicle(String make, String model, int year, double dailyRentalRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRentalRate = dailyRentalRate;
        this.hourlyRentalRate = dailyRentalRate / 24;
    }

    public Vehicle(String make, String model, int year, double dailyRentalRate, double hourlyRentalRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRentalRate = dailyRentalRate;
        this.hourlyRentalRate = hourlyRentalRate;
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Daily Rental Rate: $" + dailyRentalRate + " per day");
        System.out.println("Hourly Rental Rate: $" + hourlyRentalRate + " per hour");
    }

    public double getDailyRentalRate() {
        return dailyRentalRate;
    }

    public double getHourlyRentalRate() {
        return hourlyRentalRate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}