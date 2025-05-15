package CarDealership;

import java.util.List;
import java.util.Scanner;

import static CarDealership.DealershipFileManager.getDealership;


public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    private Dealership dealership;

    // Access info from DealershipFileManager
    public void init (){
        dealership = getDealership();
    }
    // display method to show the user their choices
    public void displayMenu(){
        //initialize init
        init();
        // Welcome the user
        System.out.println("\n      *****  Welcome to your Car Dealership *****       \n");

        // How the application will continue to run until the user decides to exit
        boolean displayMenuRunning = true;

        /* Create while loop to repeat a block of code until the condition is met */
        while (displayMenuRunning) {
            // Ask the user what they'd like to do/ Give prompts
            System.out.println(""" 
                    ------------  What would you like to do today? ------------\n
                    (1) - Find vehicles within a price range
                    (2) - Find vehicles by make / model
                    (3) - Find vehicles by year range
                    (4) - Find vehicles by color
                    (5) - Find vehicles by mileage range
                    (6) - Find vehicles by type (car, truck, SUV, van)
                    (7) - List ALL vehicles
                    (8) - Add a vehicle
                    (9) - Remove a vehicle
                    (0) - Quit""");

            // How the user makes their selection

            // in case a user input anything other than a number use try catch method
            try {
                String userInput = scanner.nextLine().trim().toUpperCase();

                // Create switch statement to allow user to choose between options
                switch (userInput) {
                    case "1":
                        processGetByPriceRequest();
                        break;
                    case "2":
                        processGetByMakeModelRequest();
                        break;
                    case "3":
                        processGetByYearRequest();
                        break;
                    case "4":
                        processGetByColorRequest();
                        break;
                    case "5":
                        processGetByMileageRequest();
                        break;
                    case "6":
                        processGetByVehicleTypeRequest();
                        break;
                    case "7":
                        processGetAllVehicleRequest();
                        break;
                    case "8":
                        addVehicleRequest();
                        break;
                    case "9":
                        removeVehicleRequest();
                        break;
                    case "0":
                        System.out.println("Are you sure you want to exit? (Y/N)");
                        String userChoice = scanner.nextLine().trim().toUpperCase();

                        if (userChoice.equalsIgnoreCase("Y")) {
                            System.out.println("Thank you. ");
                            displayMenuRunning = false;
                        }    else {
                            displayMenuRunning = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid entry.");

                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());;
            }

        }
    }

    public void processGetByPriceRequest(){
        System.out.println("Please enter the minimum price: ");
        int minPrice = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Please enter the maximum price: ");
        int maxPrice = Integer.parseInt(scanner.nextLine().trim());

        displayVehiclesList(dealership.getVehiclesByPrice(minPrice,maxPrice));
    }

    public void processGetByMakeModelRequest(){
        System.out.println("Please enter the make of the vehicle: ");
        String make = scanner.nextLine().trim();
        System.out.println("Pleas enter the model of the vehicle: ");
        String model = scanner.nextLine().trim();

        displayVehiclesList(dealership.getVehiclesByMakeModel(make,model));
    }

    public void processGetByYearRequest(){
        System.out.println("Please enter the starting year of the vehicle: ");
        int minYear = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Please enter the ending year of the vehicle: ");
        int maxYear = Integer.parseInt(scanner.nextLine().trim());

        displayVehiclesList(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest(){
        System.out.println("Please enter the color of the vehicle: ");
        String color = scanner.nextLine().trim();

        displayVehiclesList(dealership.getVehiclesByColor(color));

    }

    public void processGetByMileageRequest(){
        System.out.println("Please enter how minimum mileage: ");
        int minMiles = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Please enter the maximum mileage");
        int maxMiles = Integer.parseInt(scanner.nextLine().trim());

        displayVehiclesList(dealership.getVehiclesByMileage(minMiles, maxMiles));
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("What type of vehicle are you looking for? e.g (car, truck, SUV, van)");
        String type = scanner.nextLine().trim();

        displayVehiclesList(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehicleRequest(){
        System.out.println("Listing all vehicles: ");

        displayVehiclesList(dealership.getAllVehicles());

    }
    public void addVehicleRequest(){
        System.out.println("Please enter the vin number: ");
        String vin = scanner.nextLine().trim().toUpperCase();

        System.out.println("Please enter the year: ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Please enter the make: ");
        String make = scanner.nextLine().trim();

        System.out.println("Please enter the model: ");
        String model = scanner.nextLine().trim();

        System.out.println("Please enter the vehicle type e.g : (car, truck, SUV, van)");
        String type = scanner.nextLine().trim();

        System.out.println("Please enter the color of the vehicle: ");
        String color = scanner.nextLine().trim();

        System.out.println("Please enter the mileage number: ");
        double mileage = Double.parseDouble( scanner.nextLine().trim());

        System.out.println("Please enter the price of the vehicle: ");
        double price = Double.parseDouble( scanner.nextLine().trim());

        // create constructor
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        System.out.println("Your vehicle has been added! ");
        // getting access from UserInterface to Dealership class "dealership." gives me that access
        dealership.addVehicle(vehicle);


    }

    public void removeVehicleRequest(){
        System.out.println(" Please enter the vin number of the vehicle you want to remove: ");
        String userVin = scanner.nextLine().trim().toUpperCase();

        dealership.removeVehicle(userVin);

    }

    public void displayVehiclesList(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            // printing the list in a certain format %s for strings,%.2f%$%n for two numbers after '.'
            System.out.printf("%s | %s | %s | %s | %s | %s | %.2f | %.2f%n", vehicle.getVinNum(), vehicle.getYear(), vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

        }
    }

}