import java.util.Scanner;

public class FutureValue {
    public static double futureValue(double presentValue, double rate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return futureValue(presentValue, rate, periods - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter present value: ");
        double pv = scanner.nextDouble();
        System.out.print("Enter growth rate (e.g., 0.05 for 5%): ");
        double r = scanner.nextDouble();
        System.out.print("Enter number of periods: ");
        int n = scanner.nextInt();
        double fv = futureValue(pv, r, n);
        System.out.printf("Future Value after %d periods: %.2f\n", n, fv);
        scanner.close();
    }
} 