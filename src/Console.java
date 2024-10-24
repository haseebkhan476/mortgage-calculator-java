import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(
        String prompt,
        double min,
        double max
    ) {
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
    
}
