package basic_statistics.d6;

import java.util.Scanner;

public class Q3TheCentralLimitTheorem3 {
    public static void main(String[] args) {
        // 1.09 1
        Scanner scanner = new Scanner(System.in);

//        String[] s = scanner.nextLine().split(" ");
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        double d = Double.parseDouble(scanner.nextLine());
        double e = Double.parseDouble(scanner.nextLine());
        solve(a, b, c, d, e);
    }

    private static void solve(double size, double mean, double sd, double percentage, double z) {
        double v = z * sd / Math.sqrt(size);
        double a = mean - v;
        double b = mean + v;

        System.out.printf("%.2f\n", a);
        System.out.printf("%.2f\n", b);
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
