package mortgage.oop;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max) {
//       this method get input of loan information from customer in terminal
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + " to " + max);
        }
        return value;
    }

    public static double readNumber(String prompt){
        return scanner.nextDouble();
    }
}
