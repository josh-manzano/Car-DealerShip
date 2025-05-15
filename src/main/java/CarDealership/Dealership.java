package CarDealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){
        List<Vehicle> vehiclePrice = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                vehiclePrice.add(vehicle);
            }
        }
        return vehiclePrice;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicleMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory)

            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehicleMakeModel.add(vehicle);
            }
        return vehicleMakeModel;
    }
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear){
        List<Vehicle> vehicleYear = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getYear()>= minYear && vehicle.getYear() <=maxYear){
                vehicleYear.add(vehicle);
            }
        }
        return vehicleYear;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        // call out a new list to store the vehicle
        List<Vehicle> vehicleColor = new ArrayList<>();

        for (Vehicle vehicle : inventory){

            if (vehicle.getColor().equalsIgnoreCase(color)){
                vehicleColor.add(vehicle);
            }
        }
        return vehicleColor;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> vehicleMileage = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                vehicleMileage.add(vehicle);
            }
        }
        return vehicleMileage;
    }
    public List<Vehicle> getVehiclesByType(String type){
        List<Vehicle> vehicleType = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(type)){
                vehicleType.add(vehicle);
            }
        }
        return vehicleType;
    }
    public List<Vehicle> getAllVehicles (){

        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        // add to the vehicle list when user chooses to add car
        inventory.add(vehicle);
    }
    public void removeVehicle(String vinNumber){
        List<Vehicle> vehicles = inventory;
        for (Vehicle vehicle : vehicles){
            if (vehicle.getVinNum().equalsIgnoreCase(vinNumber)){
                vehicles.remove(vehicle);
            }
        }

    }

}