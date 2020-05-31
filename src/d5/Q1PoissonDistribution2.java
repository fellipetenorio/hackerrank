package d5;

import java.util.Scanner;

public class Q1PoissonDistribution2 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        double a = Double.parseDouble(s[0]);
        double b = Double.parseDouble(s[1]);
        solve(a, b);
    }

    private static void solve(double a, double b) {
        double expASqrt = a + a*a;
        double costA = 160 + 40*expASqrt;

        double expB = b+b*b;
        double costB = 128 + 40*expB;

        System.out.printf("%.3f \n", costA);
        System.out.printf("%.3f \n", costB);
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
