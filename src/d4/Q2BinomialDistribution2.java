package d4;

import java.util.Scanner;

public class Q2BinomialDistribution2 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");

        double a = Double.parseDouble(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        solve(a, b);
    }

    private static void solve(double defectPercentage, double size) {
        double noMoreThan2 = 0;
        double atLeast2 = 0;
        double p = defectPercentage / 100.0;

        // No more than 2 (0, 1, 2)
        for (int i = 0; i <= 2; i++) {
            noMoreThan2 += binomial(i, size, p);
        }


        // At least 2 (2, 3 ... size)
        for (int i = 2; i <= size; i++) {
            atLeast2 += binomial(i, size, p);
        }

        System.out.printf("%.3f\n", noMoreThan2);
        System.out.printf("%.3f\n", atLeast2);
    }

    private static double binomial(double x, double n, double p) {
        return combination(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
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
