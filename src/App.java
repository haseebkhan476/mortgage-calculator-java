public class App {
    public static void main(String[] args) throws Exception {
        int principal = (int) Console.readNumber("Principal (Rs1K - Rs1M)", 1000, 1000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate (1% - 30%)", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}