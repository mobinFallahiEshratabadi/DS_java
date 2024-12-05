package sortedMatrix;

public class Search {
    public void search(int[][] matrix, int x) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("x found at - " + i + ' ' + j);
                return;
            }
            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not found");
    }
}
