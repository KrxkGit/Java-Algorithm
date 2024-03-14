package leetcode;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 展平
        int m = matrix.length;
        int n = matrix[0].length;
        int end = convertCoordinate(m - 1, n - 1, n);

        int l = 0;
        int r = end;
        while (l <= r) {
            int mid = l + r >> 1;
            int[] pos = convertCoordinate(mid, n);
            int midValue = matrix[pos[0]][pos[1]];
            if (target == midValue) {
                return true;
            } else if (target < midValue) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    protected int convertCoordinate(int x, int y, int n) { // 转换为一维坐标
        return x * n + y;
    }
    protected int[] convertCoordinate(int pos, int n) {
        int[] arr = new int[2];
        arr[1] = pos % n;
        arr[0] = (pos - arr[1]) / n;
        return arr;
    }
}
