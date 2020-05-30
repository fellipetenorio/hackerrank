package d4;

import java.util.Scanner;

public class Q1BinomialDistribution1 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");

        double a = Double.parseDouble(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        solve(a, b);
    }

    private static void solve(double a, double b) {
        double result = 0;
        double p = a/(a+b);

        for (int i=3; i<=6; i++) {
            result += binomial(i, 6, p);
        }
        System.out.printf("%.3f\n", result);
    }

    private static double binomial(double x, double n, double p) {
        return combination(n, x)*Math.pow(p, x)*Math.pow(1-p, n-x);
    }

    private static double combination(double n, double x) {
        return factorial(n)/(factorial(x)*factorial(n-x));
    }

    private static double factorial (double n) {
        if (0 == n)
            return 1;

        double result = n;
        for (double i = n-1; i > 1; --i) {
            result *= i;
        }

        return result;
    }
}
