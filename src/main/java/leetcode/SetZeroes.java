package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 算法是基于 某元素 所在行列 替换
 * 更优的方案是 将 存在 0 所在的行列 作为整体，以减少替换次数
 */
public class SetZeroes {
    class Position {
        public int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[][] matrix;
    /**
     * 原地算法的一个问题便是 新产生 的零 可能与 原来 的 0 混合
     * 解决的方案是 替换扫描 时 对原来的 0 入列进行记录
     *
     * 令一个问题是如何高效寻找 0 , 拟采用 遍历法
     *
     * 为了避免 替换 对 扫描 造成影响， 先完成扫描再替换
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        Queue<Position> zeroQueue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroQueue.offer(new Position(i, j));
                }
            }
        }

        while (!zeroQueue.isEmpty()) {
            Position position = zeroQueue.poll();
            doSetZero(position);
        }
    }

    /**
     * 替换 该位置 所在行列的所有格
     * @param position
     */
    protected void doSetZero(Position position) {
        // 替换所在行
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[position.x][j] = 0;
        }
        // 替换所在列
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][position.y] = 0;
        }
    }
}
