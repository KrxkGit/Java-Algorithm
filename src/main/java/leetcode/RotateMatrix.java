package leetcode;

public class RotateMatrix {
    public RotateMatrix() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[j][matrix.length - 1 -i] = matrix[i][j];
            }
        }
        display(result);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
    protected void display(int[][] matrix) {
        System.out.printf("[");
        int cur_row = 0;
        for (int[]row : matrix) {
            cur_row++;
            System.out.printf("[");
            int cur = 0;
            for (int item : row) {
                cur++;
                System.out.printf("%d", item);
                if (!(cur == row.length)) {
                    System.out.printf(",");
                }
            }
            System.out.printf("]");
            if (!(cur_row == row.length)) {
                System.out.printf(",");
            }
        }
        System.out.printf("]\n");
    }
}
