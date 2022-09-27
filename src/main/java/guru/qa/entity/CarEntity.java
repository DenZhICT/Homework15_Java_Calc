package guru.qa.entity;

public class CarEntity {
    private String name;
    private double fuelEconomy;
    private int fuelCapacity;

    public String getName() {
        return name;
    }

    public CarEntity setName(String name) {
        this.name = name;
        return this;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public CarEntity setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
        return this;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public CarEntity setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }
}
