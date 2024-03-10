package leetcode;

public class MergeArray {
    private int[] arr1 = new int[]{1,3,4,6,0,0,0,0};
    private int[] arr2 = new int[]{4,5,6,7};
    private int m = 4, n = 4;
    public void Merge() {
        int p = 7, p1 = 3, p2 = 3;
        while (p2 >= 0) {
            if (arr1[p1] >= arr2[p2]) {
                arr1[p] = arr1[p1];
                p1--;
            } else {
                arr1[p] = arr2[p2];
                p2--;
            }
            p--;
        }
    }

    public MergeArray() {
        Merge();
        System.out.println();
        for (int item : arr1) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
}
