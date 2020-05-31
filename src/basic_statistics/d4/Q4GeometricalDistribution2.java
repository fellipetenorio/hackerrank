package basic_statistics.d4;

import java.util.Scanner;

public class Q4GeometricalDistribution2 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");

        double numerator = Double.parseDouble(tokens[0]);
        double denominator = Double.parseDouble(tokens[1]);

        s = scanner.nextLine();
        double ith = Double.parseDouble(s);
        solve(numerator, denominator, ith);
    }

    private static void solve(double num, double den, double ith) {
        double geoDist = 0;

        // 1º on 1th, 2º on 2 attempts, 3º on 3, etc.
        for (double i=1; i<=ith; ++i ) {
            geoDist += negativeBinomial(i, num/den);
        }

        System.out.printf("%.3f\n", geoDist);
    }

    private static double negativeBinomial(double n, double p) {
        return Math.pow(1-p, n-1) * p;
    }

    private static double combination(double n, double x) {
        return factorial(n) / (factorial(x) * factorial(n - x));
    }

    private static double factorial(double n) {
        if (0 == n)
            return 1;

        double result = n;
        for (double i = n - 1; i > 1; --i) {
            result *= i;
        }

        return result;
    }
}
