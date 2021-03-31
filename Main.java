package processor;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            choice = scanner.nextInt();

            if (choice == 1 || choice == 3) {
                System.out.print("Enter the size of first matrix: ");
                int rowA = scanner.nextInt();
                int colA = scanner.nextInt();
                System.out.println("Enter first matrix: ");
                double[][] matrixA = MatrixUtil.createMatrix(rowA, colA);
                System.out.print("Enter the size of second matrix: ");
                int rowB = scanner.nextInt();
                int colB = scanner.nextInt();
                System.out.println("Enter second matrix: ");
                double[][] matrixB = MatrixUtil.createMatrix(rowB, colB);
                if (choice == 1) {
                    MatrixUtil.printArray(MatrixOperation.addMatrix(matrixA, matrixB));
                } else {
                    MatrixUtil.printArray(MatrixOperation.multiplyMatrix(matrixA, matrixB));
                }
            } else if (choice == 2) {
                System.out.print("Enter size of matrix: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                System.out.println("Enter matrix: ");
                double[][] matrix = MatrixUtil.createMatrix(row, col);
                System.out.print("Enter constant: ");
                double constant = scanner.nextDouble();
                MatrixUtil.printArray(MatrixOperation.multiplyByConstant(matrix, constant));
            } else if (choice == 4) {
                System.out.println("1. Main diagonal");
                System.out.println("2. Side diagonal");
                System.out.println("3. Vertical line");
                System.out.println("4. Horizontal line");
                System.out.print("Your choice: ");
                int transposeType = scanner.nextInt();
                System.out.print("Enter matrix size: ");
                int numRow = scanner.nextInt();
                int numCol = scanner.nextInt();
                System.out.println("Enter matrix: ");
                double[][] matrix = MatrixUtil.createMatrix(numRow, numCol);
                if (transposeType == 1) {
                    MatrixUtil.printArray(MatrixOperation.transposeMainDiagonal(matrix));
                } else if (transposeType == 2) {
                    MatrixUtil.printArray(MatrixOperation.transposeSideDiagonal(matrix));    
                } else if (transposeType == 3) {
                    MatrixUtil.printArray(MatrixOperation.transposeVertical(matrix));
                } else {
                    MatrixUtil.printArray(MatrixOperation.transposeHorizontal(matrix));
                }
            } else if (choice == 5) {
                System.out.print("Enter matrix size: ");
                int numRow = scanner.nextInt();
                int numCol = scanner.nextInt();
                System.out.println("Enter matrix: ");
                double[][] matrix = MatrixUtil.createMatrix(numRow, numCol);
                System.out.println("The result is: ");
                System.out.println(MatrixOperation.determinant(matrix));
                System.out.println();
            } else if (choice == 6) {
                System.out.print("Enter matrix size: ");
                int numRow = scanner.nextInt();
                int numCol = scanner.nextInt();
                if (numRow + numCol < 4) {
                    System.out.println("This matrix doesn't have an inverse.");
                    continue;
                }
                System.out.println("Enter matrix: ");
                double[][] matrix = MatrixUtil.createMatrix(numRow, numCol);
                MatrixUtil.printArray(MatrixOperation.inverse(matrix));
            }
        } while(choice != 0);
    }
}
