package processor;
import java.util.Scanner;

public class MatrixUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static double[][] createMatrix(int numRow, int numCol) {
        double[][] array = new double[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            for (int k = 0; k < numCol; k++) {
                array[i][k] = scanner.nextDouble();
            }
        }
        return array;
    }

    public static double[][] createSubMatrix(double[][] matrix, int row, int col) {
        double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
        int rowIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            int colIndex = 0;
            if (i == row) {
                continue;
            }
            for (int k = 0; k < matrix[0].length; k++) {
                if (k == col) {
                    continue;
                }
                subMatrix[rowIndex][colIndex] = matrix[i][k];
                colIndex++;
            }
            rowIndex++;

        }
        return subMatrix;
    }

    public static double crossMultiply(double[][] matrix) {
        double result = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        return result == 0 ? Math.abs(result) : result;
    }

    public static void printArray(double[][] matrix) {
        if (matrix == null) {
            System.out.println("The operation cannot be performed.");
        }
        System.out.println("The result is:");
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
//                System.out.printf("%6.2f ", matrix[i][k]);
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] matrixOfMinors(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                newMatrix[i][k] = MatrixOperation.determinant(createSubMatrix(matrix, i, k));
            }
        }

        return newMatrix;
    }

    public static double[][] matrixOfCofactors(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix.length];


        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                boolean positive = (i + k) % 2 == 0;
                if (matrix[i][k] == (double) 0) {
                    continue;
                }
                newMatrix[i][k] = (positive ? 1 : -1) * matrix[i][k];
            }
        }
        return newMatrix;
    }
}
