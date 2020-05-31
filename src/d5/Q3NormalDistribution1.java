package d5;

import java.util.Scanner;

public class Q3NormalDistribution1 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        double mean = Double.parseDouble(s[0]);
        double sd = Double.parseDouble(s[1]);
        double c = Double.parseDouble(scanner.nextLine());
        s = scanner.nextLine().split(" ");
        double lower = Double.parseDouble(s[0]);
        double upper = Double.parseDouble(s[1]);
        solve(mean, sd, c, lower, upper);
    }

    private static void solve(double mean, double sd, double lt, double lower, double upper) {
        double q1= cDF(mean, sd, lt);
        double q2= cDF(mean, sd, upper) - cDF(mean, sd, lower);

        System.out.printf("%.3f \n", q1);
        System.out.printf("%.3f \n", q2);
    }

    private static double cDF(double mean, double sd, double x) {
        return (1.0/2) * (1 + erf2((x-mean)/(sd*Math.sqrt(2))));
    }

    // https://introcs.cs.princeton.edu/java/21function/ErrorFunction.java.html
    public static double erf2(double z) {
        double t = 1.0 / (1.0 + 0.47047 * Math.abs(z));
        double poly = t * (0.3480242 + t * (-0.0958798 + t * (0.7478556)));
        double ans = 1.0 - poly * Math.exp(-z*z);
        if (z >= 0) return  ans;
        else        return -ans;
    }
}
