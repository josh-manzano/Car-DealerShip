package CarDealership;

public class Program {
    public static void main(String[] args) {

        // creating an object to get access to a Class methods or information

        UserInterface ui = new UserInterface();
        // When you have a static you can access by Class name (UserInterface)
        // When you don't have static you need to create an object (UserInterface- object) to access methods or information
        ui.displayMenu();
    }

}
