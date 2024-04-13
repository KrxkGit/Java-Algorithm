package leetcode;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        R[nums.length  - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >=0 ;j --) {
            R[j] = R[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}
