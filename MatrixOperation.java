package processor;

public class MatrixOperation {

    public static double[][] addMatrix(double[][] matrixA, double[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("The operation cannot be performed.");
        }

        double[][] newMatrix = new double[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int k = 0; k < matrixA[0].length; k++) {
                newMatrix[i][k] = matrixA[i][k] + matrixB[i][k];
            }
        }
        return newMatrix;
    }

    public static double[][] multiplyByConstant(double[][] matrix, double constant) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[i][k] == 0) {
                    continue;
                }
                newMatrix[i][k] = matrix[i][k] * constant;
            }
        }
        return newMatrix;
    }

    public static double[][] multiplyMatrix(double[][] matrixA, double[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            System.out.println("The operation cannot be performed.");
        }

        double[][] newMatrix = new double[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            double result = 0;
            for(int j = 0; j < matrixB[0].length; j++) {
                result = 0;
                for (int k = 0; k < matrixB.length; k++) {
                    result = result + (matrixA[i][k] * matrixB[k][j]);
                }
                newMatrix[i][j] = result;
            }
        }
        return newMatrix;
    }

    public static double[][] transposeMainDiagonal(double[][] matrix) {
        double[][] newMatrix = new double[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix[0].length; k++) {
                newMatrix[k][i] = matrix[i][k];
            }
        }
        return newMatrix;
    }
    
    public static double[][] transposeSideDiagonal(double[][] matrix) {
        return transposeVertical(transposeMainDiagonal(transposeVertical(matrix)));
    }

    public static double[][] transposeVertical(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix[0].length; k++) {
                newMatrix[i][k] = matrix[i][Math.abs(k - (matrix[0].length - 1))];
            }
        }
        return newMatrix;
    }

    public static double[][] transposeHorizontal(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix[0].length; k++) {
                newMatrix[i][k] = matrix[Math.abs(i - (matrix.length - 1))][k];
            }
        }
        return newMatrix;
    }

    public static double determinant(double[][] matrix) {
        double determinant = 0;
        if (matrix.length == 2) {
            return MatrixUtil.crossMultiply(matrix);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                continue;
            }
            determinant = determinant + (i % 2 == 0 ? matrix[0][i] : -matrix[0][i]) * determinant(MatrixUtil.createSubMatrix(matrix, 0, i));
        }
        return determinant;
    }

    public static double[][] inverse(double[][] matrix) {
        double[][] matrixOfMinors = MatrixUtil.matrixOfMinors(matrix);
        double[][] matrixOfCofactors = MatrixUtil.matrixOfCofactors(matrixOfMinors);
        double[][] transposeOfCofactors = transposeMainDiagonal(matrixOfCofactors);
        double constant = (float) 1 / determinant(matrix);
        return multiplyByConstant(transposeOfCofactors, constant);
    }
}
