package sortedMatrix;

public class Print {
    public void printInSpiral(int[][] matrix, int row, int col) {
        int k = 0, l = 0;

        while (k < row && l < col) {
            for (int j = k; j < col; j++) {
                System.out.print(matrix[k][j] + " ");
            }
            k++;

            for (int i = k; i < row; i++) {
                System.out.print(matrix[i][col - 1] + " ");
            }
            col--;

            if (k < row) {
                for (int j = col - 1; j >= l; j--) {
                    System.out.print(matrix[row - 1][j] + " ");
                }
                row--;
            }

            if (l < col) {
                for (int i = row - 1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }
}
