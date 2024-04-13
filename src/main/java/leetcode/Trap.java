package leetcode;

/**
 * 暴力解法
 * 直观解法
 */
class Trap {
    int[] height;
    Color[][] graph;
    enum Color {
        Black, // 容器壁
        Red; // 空
    }
    private int getTop() {
        int max = height[0];
        for (int item : height) {
            max = Math.max(max, item);
        }
        return max;
    }
    private void InitGraph() {
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            Color[] fast = graph[i];
            for (int j = 0; j < graph[0].length; j++) {
                if (j < h) {
                    fast[j] = Color.Black;
                } else {
                    fast[j] = Color.Red;
                }
            }
        }
        height = null; // 释放内存
    }

    protected int SearchGraph() {
        int acWater = 0;
        for (int j = graph[0].length - 1; j >= 0; j--) {
            int start = -1;
            int count = 0;
            int originStart = start;
            for (int i = 0; i < graph.length; i++) {
                Color color = graph[i][j];
                if (color == Color.Black) {
                    originStart = start = i;
                } else if (start >= 0 && color == Color.Red) {
                    count += i - start;
                    start++;
                    if (i == graph.length - 1) {
                        count -= i - originStart;
                    }
                } else {
                    // loop
                }
            }
            System.out.printf("%d 层 %d 水 开始 %d\n", j, count, start);
            acWater += count;
        }

        return acWater;
    }
    public int trap(int[] height) {
        this.height = height;
        int top = getTop();
        graph = new Color[height.length][top];
        InitGraph();

        return SearchGraph();
    }
}