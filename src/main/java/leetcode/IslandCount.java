package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {
    private int m,n;
    private class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public IslandCount() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        numIslands(grid);
    }
    protected boolean isValid(Point point) {
        return !(point.i < 0 || point.i >= m || point.j < 0 || point.j>= n);
    }

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        Queue<Point> points = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        // 随机搜索一个初始点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    points.offer(new Point(i, j));
                    count++;

                    while (!points.isEmpty()) {
                        Point cur = points.poll();
                        if (!isValid(cur)) {
                            continue;
                        }
                        if (visited[cur.i][cur.j]) {
                            continue;
                        }
                        visited[cur.i][cur.j] = true;
                        if (grid[cur.i][cur.j] == '0') {
                            continue;
                        }
                        // 四个方向
                        points.offer(new Point(cur.i, cur.j - 1));
                        points.offer(new Point(cur.i, cur.j + 1));
                        points.offer(new Point(cur.i - 1, cur.j));
                        points.offer(new Point(cur.i + 1, cur.j));
                    }
                }
            }
        }
        return count;
    }
}
