package sort;

import java.util.Arrays;

public class Merge extends SortHelp {
    public Merge() {
        int[] arr = {32,7,1,3,5,6,7,66,2,89,12};
        display(arr);
        MergeSort(arr);
        display(arr);
    }
    public void MergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        MergeSort(left);
        MergeSort(right);

        DoMerge(arr, left, right);
    }
    private void DoMerge(int[] arr, int[] left, int[] right) {
        // 填充到 arr
        int i = 0, j = 0, k = 0;
        while (k < left.length + right.length) {
            // 边界
            if (i >= left.length) {
                arr[k] = right[j];
                j++;
                k++;
                continue;
            }
            if (j >= right.length) {
                arr[k] = left[i];
                i++;
                k++;
                continue;
            }
            // 选择 较小者
            if (left[i] < right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
