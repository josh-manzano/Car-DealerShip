package CarDealership;


import java.util.Scanner;

public class SalesContract extends Contract {
    private double  tax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;


    public SalesContract(String date, String name, String email, Vehicle vehicle, double tax, double recordingFee, double processingFee, boolean finance) {
        super(date, name, email, vehicle);
        this.tax= .05;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public boolean finance() {
        Scanner user = new Scanner(System.in);
        System.out.println("Would you like to finance? Y/N");
        String choice = user.nextLine().toLowerCase().trim();
        switch (choice){
            case "y":
                finance = true;
                break;
            case "n":
                finance = false;
                break;
            default:
        }
        return finance;
    }

    @Override
    public double getMonthlyPayment(){
        double interest = 0;
        int months = 0;

        if (!isFinance()) {
            return 0;
        }

        if(getTotalPrice() >= 10000){
            interest = 4.25;
            months = 48;
        }else if (getTotalPrice() < 10000){
            interest = 5.25;
            months = 24;
        }

        double totalPriceWInterest = getTotalPrice() * (1 + interest / 100);
        double monthlyPayment = totalPriceWInterest / months;

        return monthlyPayment;
    }


    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        double taxPrice = vehiclePrice * tax;
        double recFee = 100;


        //  if the price is less than 10k the fee will be 295
        //  and if condition is not met then the fee for every other vehicle will be 495
        //              (condition)? valueIfTrue:valueIfFalse
        processingFee = (vehiclePrice < 10000) ? 295 : 495;
        return vehiclePrice + taxPrice + recFee + processingFee;
    }


    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
