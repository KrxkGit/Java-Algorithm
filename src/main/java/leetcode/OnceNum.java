package leetcode;

/**
 * 算法目前存在问题
 */
public class OnceNum {
    public int singleNumber(int[] nums) {
        Integer save = 0;
        Integer saveOnceMore = 0;
        for (int item : nums) {
            if ((item & saveOnceMore) == item) {
                // 第二次加入
                if ((item & save) == item) { // 清除 save 中的 item
                    save ^= item;
                }
            } else {
                // 首次加入
                save ^= item;
                saveOnceMore ^= item;
            }
        }
        return save;
    }
}
