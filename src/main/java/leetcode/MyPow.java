package leetcode;

/**
 * 通过 305 / 306 个案例
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && Math.abs(x)==1) {
            n = 0;
        }
        if (x == 1 || x == 0) {
            return x;
        }else if (n == Integer.MIN_VALUE) { // 补码转换
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n < 0) {
            return myPow(1 / x, -n);
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
