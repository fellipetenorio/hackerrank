package basic_statistics.d7;

import java.util.Arrays;
import java.util.Scanner;

public class Q2SpearmanRankCorrelationCoefficient {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");
        double[] x = new double[size];
        for (int i = 0; i < size; i++) {
            x[i] = Double.parseDouble(tokens[i]);
        }

        s = scanner.nextLine();
        tokens = s.split(" ");
        double[] y = new double[size];
        for (int i=0; i < size; i++) {
            y[i] = Double.parseDouble(tokens[i]);
        }

        solve(size, x, y);
    }

    private static void solve(int size, double[] x, double[] y) {
        double c = spearmanRankUniqueValues (size, x, y);

        System.out.printf("%.3f\n", c);
    }

    public static double spearmanRankUniqueValues(int size, double[] x, double[] y) {
        int[] ranksX = ranks(size, x);
        int[] ranksY = ranks(size, y);

        double rank = 0;

        for (int i=0; i<size; i++ ) {
            rank += Math.pow(ranksX[i]-ranksY[i], 2);
        }

        rank *= 6.0/(size * (size*size - 1));
        rank = 1 - rank;

        return rank;
    }

    private static int[] ranks(int size, double[] e) {
        int[] ranks = new int[size];

        double[] orderedClone = Arrays.copyOf(e, size);
        Arrays.sort(orderedClone);

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (e[i] == orderedClone[j]) {
                    ranks[i] = j+1;
                    break;
                }
            }
        }

        return ranks;
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
