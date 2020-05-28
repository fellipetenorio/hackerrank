// https://www.hackerrank.com/challenges/magic-square-forming/problem
/*
e.g:
4 8 2
4 5 7
6 1 6

output:
4

 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FormingAMagicSquare {

    static int cost(int[][] square, int[][] c) {
        int cost = 0;

        for (int i = 0, j = c.length; i<j; i++) {
            int[] ints = c[i];
            for (int i2 = 0, j2 = ints.length; i2<j2; i2++) {
                cost += Math.abs(ints[i2] - square[i][i2]);
            }
        }

        return cost;
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int cost = 99999;
        int[][][] allSquare = new int[][][]
                {
                        {{8,1,6}, {3,5,7}, {4,9,2}},
                        {{6,1,8}, {7,5,3}, {2,9,4}},
                        {{4,9,2}, {3,5,7}, {8,1,6}},
                        {{2,9,4}, {7,5,3}, {6,1,8}},
                        {{8,3,4}, {1,5,9}, {6,7,2}},
                        {{4,3,8}, {9,5,1}, {2,7,6}},
                        {{6,7,2}, {1,5,9}, {8,3,4}},
                        {{2,7,6}, {9,5,1}, {4,3,8}},
                };

            for (int[][] sq: allSquare) {
                int cost1 = cost(sq, s);
                if (cost1 < cost)
                    cost = cost1;
            }

        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
