package leetcode;

/**
 * 对于连续区间 逐个按位与 的结果 即为寻找最大公共二进制前缀
 * 因为区间连续，实际上只要比较 区间端点 的公共二进制前缀
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        int m = left, n = right;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
