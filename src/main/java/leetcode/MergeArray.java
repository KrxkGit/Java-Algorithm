package leetcode;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, pres = m + n - 1;
        while (true) {
            if (pres < 0) {
                break;
            }
            if (p1 < 0) {
                nums1[pres] = nums2[p2];
                p2--;
                pres--;
                continue;
            }
            if (p2 < 0) {
                break;
            }

            if (nums1[p1] >= nums2[p2]) {
                nums1[pres] = nums1[p1];
                p1--;
            } else {
                nums1[pres] = nums2[p2];
                p2--;
            }
            pres--;
        }
    }
}
