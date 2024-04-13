package leetcode;

/**
 * 对 每一位进行操作，出现 3 次 表明 所有数 该位 的和必为 3 的倍数
 */
public class OnceNum {
    public int singleNumber(int[] nums) {
        int save = 0;
        for (int i = 0; i < 32; i++) { // 整型 32 位
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            total %= 3;
            save |= (total << i);
        }
        return save;
    }
}
