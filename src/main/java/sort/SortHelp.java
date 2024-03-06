package sort;

public class SortHelp {
    protected void display(int[]arr) {
        System.out.println("-----result-----");
        for(int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
