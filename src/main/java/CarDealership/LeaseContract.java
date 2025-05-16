package CarDealership;

public class LeaseContract extends Contract{

    private double eev;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicle, double eev, double leaseFee) {
        super(date, name, email, vehicle);
        this.eev = eev;
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        eev =  vehiclePrice / 2;
        leaseFee = vehiclePrice * (7 / 100.0);
        double totalWFee = vehiclePrice - eev + leaseFee;

        return totalWFee;
    }

    @Override
    public double getMonthlyPayment() {
        double priceWInterest = getTotalPrice() * (1 + 4.0 / 100);
        return priceWInterest / 36;
    }

}
