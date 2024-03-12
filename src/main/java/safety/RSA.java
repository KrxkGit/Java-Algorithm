package safety;

/**
 * 此 类目前存在问题
 */
public class RSA {
    private Integer p;
    private Integer q;
    private Integer N;
    private Integer e;
    private Integer d;
    private Integer r;

    public RSA() {
        Init();
//        System.out.println(p);
//        System.out.println(q);

        Integer[] result = generateKey();
//        System.out.println(result[0]);
//        System.out.println(result[1]);
//        System.out.println(result[2]);
    }
    protected void Init() {
        this.p = getRandomPrime();
        this.q = getRandomPrime();
        this.N = p * q;
        this.r = (p - 1) * (q - 1);
    }

    /**
     * 生成密钥对
     * @return
     */
    public Integer[] generateKey() {
//        System.out.println(r);
        // 选择 e
        int i = 3;
        for (; i < r; i++) {
            if (r % i != 0) {
                break;
            }
        }
        e = i;

        // 求 d
        i = 2;
        for (; i < N; i++) {
            if ((i * e) % r == 1 || r % (i * e) == 1) {
                break;
            }
        }
        d = i;

        return new Integer[]{e, d, N};
    }

    protected Integer getRandomPrime() {
        Integer result = (int) (Math.random() * 999);
        while (isPrime(result)) {
            result++;
        }
        return result;
    }
    protected boolean isPrime(Integer num) {
        Integer end =  (int) Math.ceil(Math.sqrt(num));
        for (int i = 2; i <= end; i++) {
            if (i % num == 0 || num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Integer AttachEKey(Integer num) {
        Integer res = Math.ceilMod((int) Math.pow(num, e), N);
        while (res < 0) {
            res += N;
        }
        return res;
    }
    public Integer AttachDKey(Integer num) {
        Integer res = Math.ceilMod((int) Math.pow(num, d), N);
        while (res < 0) {
            res += N;
        }
        return res;
    }
}
