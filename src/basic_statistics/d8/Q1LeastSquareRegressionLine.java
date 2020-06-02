package basic_statistics.d8;

import java.util.Scanner;

public class Q1LeastSquareRegressionLine {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        String[] tokens;
        int size = 5;
        double[] x = new double[size];
        double[] y = new double[size];

        for (int i = 0; i < 5; i++) {
            tokens = scanner.nextLine().split(" ");

            x[i] = Double.parseDouble(tokens[0]);
            y[i] = Double.parseDouble(tokens[1]);
        }

        solve(size, x, y);
    }

    private static void solve(int size, double[] x, double[] y) {
        aF(size, x, y);
    }

    public static void aF(int size, double[] x, double[] y) {
        double b,a,c;
        double sumProd = 0;
        double xSum = 0;
        double x2Sum = 0;
        double ySum = 0;

        for (int i=0; i<size; i++) {
            double xi = x[i];
            double yi = y[i];

            xSum += xi;
            ySum += yi;
            x2Sum += xi * xi;

            sumProd += xi * yi;
        }

        b = (size * sumProd - xSum*ySum)/(size * x2Sum - xSum*xSum);
        a = ySum/size - b*xSum/size;

        c = a + b*80;
        System.out.printf("%.3f\n", c);
    }

    public static double covv(int size, double[] x, double[] y) {
        double covv=0;

        double xM = mean(size, x);
        double sdX = sd(size, x, xM);

        double yM = mean(size, y);
        double sdY = sd (size, y, yM);

        for (int i = 0; i < size; i++) {
            covv += (x[i] - xM)*(y[i] - yM);
        }

        return (covv/size)/(sdX*sdY);
    }

    private static double sd(int size, double[] x, double mean) {
        double sd = 0;
        for(double i: x) {
            sd += Math.pow(i - mean,2);
        }

        sd = Math.sqrt(sd/size);
        return sd;
    }

    private static double mean (int size, double[] x) {
        double mean = 0;
        for (int i=0; i < size; i++) {
            mean += x[i];
        }

        return mean/size;
    }
}
