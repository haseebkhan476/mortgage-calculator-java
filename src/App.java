import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) throws Exception {
        int principal = (int) readNumber("Principal (Rs1K - Rs1M)", 1000, 1000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (1% - 30%)", 1, 30);
        byte years = (byte) readNumber("Period (Years)", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.print("Monthly Payments: " + mortgageFormatted);

        System.out.println("\n");
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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

    public static double calculateBalance(
        int principal,
        float annualInterest,
        byte years,
        short numberOfPaymentsMade
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(
        int principal,
        float annualInterest,
        byte years
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal
            * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        
        return mortgage;
    }
}
