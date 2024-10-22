import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println("\n");
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }
    
}
