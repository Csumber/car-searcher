package hu.sch.csumber;

import javax.print.MultiDocPrintService;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

// első koordináta = magasság
// második koordináta = szélesség

public class faktorizacio {
    public static void printArray(double[][] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array[0].length - 1; ++j) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print(array[i][array[0].length - 1]);
            System.out.println();
        }
        for (int j = 0; j < array[0].length - 1; ++j) {
            System.out.print(array[array.length - 1][j] + "\t");
        }
        System.out.print(array[array.length - 1][array[0].length - 1]);
        System.out.println();
    }

    public static double[][] matrixFactorization(double[][] array) {
        int steps = 5000;
        int MatrixParameter = 2;
        double alpha = 0.0002;
        double beta = 0.02;
        double P[][] = new double[array.length][MatrixParameter];
        double Q[][] = new double[MatrixParameter][array[0].length];

        Random rand = new Random();
        for (int i = 0; i < P.length; ++i)
            for (int j = 0; j < P[0].length; ++j)
                P[i][j] = rand.nextDouble();
        for (int i = 0; i < Q.length; ++i)
            for (int j = 0; j < Q[0].length; ++j)
                Q[i][j] = rand.nextDouble();

        for (int s = 0; s < steps; ++s) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[0].length; ++j) {
                    if (array[i][j] > 0) {
                        double eij = array[i][j] - calculateAt(P, Q, j, i);
                         for (int k = 0; k < MatrixParameter; ++k) {
                            P[i][k] = P[i][k] + alpha * (2 * eij * Q[k][j] - beta * P[i][k]);
                            Q[k][j] = Q[k][j] + alpha * (2 * eij * P[i][k] - beta * Q[k][j]);
                        }
                    }
                }
            }
        }
        return Multiply(P, Q);
    }

    public static double[][] Multiply(double P[][], double Q[][]) {
        double dest[][] = new double[P.length][Q[0].length];
        for (int i = 0; i < dest.length; ++i)
            for (int j = 0; j < dest[0].length; ++j)
                dest[i][j] = calculateAt(P, Q, j, i);
        return dest;
    }

    public static double calculateAt(double P[][], double Q[][], int x, int y) {
        double sumProduct = 0;
        for (int i = 0; i < P[0].length; ++i) {
            for (int j = 0; j < Q.length; ++j) {
                sumProduct += (P[y][i] * Q[j][x]);
            }
        }
        sumProduct = 0;
        for(int i = 0; i<P[0].length;++i)
            sumProduct += (P[y][i] * Q[i][x]);
        return sumProduct;
    }

    static boolean debug = true;
    static double originalArray[][];
    static double destinationArray[][];
    static int numberOfUsers;
    static int numberOfBooks;

    public static void main(String[] args) {
        try {
            File input;
            Scanner sc;

            if (debug) {
                input = new File("input5.txt");
                sc = new Scanner(input);
            } else {
                sc = new Scanner(new InputStreamReader(System.in));
            }
            {
                String line = sc.nextLine();
                String[] cmd = line.split("\t");
                numberOfUsers = Integer.parseInt(cmd[1]);
                numberOfBooks = Integer.parseInt(cmd[2]);
            }

            originalArray = new double[numberOfUsers][numberOfBooks];
            for (int i = 0; i < originalArray.length; ++i)
                for (int j = 0; j < originalArray[0].length; ++j)
                    originalArray[i][j] = 0;


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] cmd = line.split("\t");
                int currentID = Integer.parseInt(cmd[0]);
                int currentBook = Integer.parseInt(cmd[1]);
                int currentReview = Integer.parseInt(cmd[2]);
                originalArray[currentID][currentBook] = currentReview;
            }

            printArray(originalArray);
            System.out.println();
            System.out.println();
            //printArray(matrixFactorization(originalArray));


            double P[][] = new double[5][2];
            double Q[][] = new double[2][4];

            for (int i = 0; i < P.length; ++i)
                for (int j = 0; j < P[0].length; ++j)
                    P[i][j] = 1;
            for (int i = 0; i < Q.length; ++i)
                for (int j = 0; j < Q[0].length; ++j)
                    Q[i][j] = 1;

            printArray(P);
            System.out.println();
            System.out.println();
            printArray(Q);
            System.out.println();
            System.out.println();
            printArray(Multiply(P,Q));
            System.out.println();
            System.out.println();
            printArray(matrixFactorization(originalArray));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
