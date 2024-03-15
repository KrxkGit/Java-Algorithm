package leetcode;

/**
 * 通过 305 / 306 个案例
 * 考虑边界问题， 可以 令 long N = n 再进一步处理
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && Math.abs(x)==1) {
            n = 0;
        }
        if (x == 1 || x == 0) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (Math.abs(x) > 1 && n == Integer.MIN_VALUE) { // 负指数很大，趋近 0
            return 0;
        }
        else if (n < 0) { // 如果 n 直接转换，可能涉及溢出，通过 long 先存储再转换
            long new_n = -n;
            if (n == Integer.MIN_VALUE) {
                new_n = 0;
            }
            return myPow(1 / x, (int) new_n);
        }
        if (n % 4 == 0) {
            double res = myPow(x, n / 4);
            return res * res * res * res;
        }else if (n % 2 == 0) {
            double res = myPow(x, n / 2);
            return res * res;
        } else { // 奇数
            return x * myPow(x, n - 1);
        }
    }

}
