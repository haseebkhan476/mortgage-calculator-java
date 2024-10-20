import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal (Rs1K - Rs1M): ");
            principal = scanner.nextInt();

            if (principal >= 1000 && principal <= 1000_000)
                break;
            System.out.println("Enter a value between 1000 & 1000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate (1% - 30%): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) 
                break;
            System.out.println("Enter a value between 1 & 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 & years <= 30) 
                break;
            System.out.println("Enter a value between 1 & 30");
        }

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }

    public static double calculateMortgage(
                int principal,
                float annualInterest,
                byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal
            * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        
        return mortgage;
    }
}
