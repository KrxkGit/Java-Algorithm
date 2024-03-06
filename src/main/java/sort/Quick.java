package sort;

public class Quick extends SortHelp {
    public void QuickSort(int[] arr, int low, int high) {
        int i = low, j = high;
        int pivot = low + (high - low) / 2;
        // 交换条件
        while (i <= j) {
            // 寻找 i, j
            while (arr[i] < arr[pivot]) {
                i++;
            }
            while (arr[j] > arr[pivot]) {
                j--;
            }
            if (i <= j) {
                // 交换 i,j
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // 递归，while 完成后 i > j 且相邻
        if (low < j) {
            QuickSort(arr, low, j);
        }
        if (i < high) {
            QuickSort(arr, i, high);
        }
    }

    public Quick() {
        int[] arr = {32,7,1,3,5,6,7,66,2,89,12};
        display(arr);
        QuickSort(arr, 0, arr.length - 1);
        display(arr);
    }

}
