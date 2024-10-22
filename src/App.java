import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int principal = (int) readNumber("Principal (Rs1K - Rs1M)", 1000, 1000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (1% - 30%)", 1, 30);
        byte years = (byte) readNumber("Period (Years)", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(
        String prompt,
        double min,
        double max
    ) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();

            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between "+ min + " & " + max);
        }
        return value;
    }

    public static double calculateMortgage(
        int principal,
        float annualInterest,
        byte years
    ) {
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
