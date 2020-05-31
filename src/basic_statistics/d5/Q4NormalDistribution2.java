package basic_statistics.d5;

import java.util.Scanner;

public class Q4NormalDistribution2 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        double mean = Double.parseDouble(s[0]);
        double sd = Double.parseDouble(s[1]);
        double higher = Double.parseDouble(scanner.nextLine());
        double lower = Double.parseDouble(scanner.nextLine());
        solve(mean, sd, higher, lower);
    }

    private static void solve(double mean, double sd, double higher, double lower) {
        double higherThanUpper = 100 * (1 - cDF(mean, sd, higher));
        double greaterEqualLower = 100 * (1 - cDF(mean, sd, lower));
        double smallerLower = 100 * cDF(mean, sd, lower);

        System.out.printf("%.2f\n", higherThanUpper);
        System.out.printf("%.2f\n", greaterEqualLower);
        System.out.printf("%.2f\n", smallerLower);
    }

    private static double cDF(double mean, double sd, double x) {
        return 0.5 * (1 + erf((x - mean) / (sd * Math.sqrt(2))));
    }

    // https://introcs.cs.princeton.edu/java/21function/ErrorFunction.java.html
    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                t * ( 1.00002368 +
                        t * ( 0.37409196 +
                                t * ( 0.09678418 +
                                        t * (-0.18628806 +
                                                t * ( 0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * ( 1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * ( 0.17087277))))))))));

        if (z >= 0) return  ans;
        else        return -ans;
    }

}
