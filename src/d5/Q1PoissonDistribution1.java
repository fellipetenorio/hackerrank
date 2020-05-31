package d5;

import java.util.Scanner;

public class Q1PoissonDistribution1 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double prob = Double.parseDouble(scanner.nextLine());
        solve(x, prob);
    }

    private static void solve(double x, double prob) {

        double p = poissonDist(prob, x);
        System.out.printf("%.3f\n", p);
    }

    private static double poissonDist(double k, double ep) {
        return Math.pow(ep, k)*Math.pow(Math.E, -1*ep)/factorial(k);
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
