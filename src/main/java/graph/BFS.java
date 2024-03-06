package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends FS {
    public BFS(int node_count) {
        super(node_count);
        bfs_walk(4);
    }

    @Override
    public void searchPath() {

    }
    protected void bfs_walk(int node) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[distance.length];
        queue.offer(node);
        visited[node] = true;

        System.out.println();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.printf("%d ", i);
            for (int j = 0; j < distance.length; j++) {
                if (j == i) {
                    continue;
                }
                if (!visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }

    }
}
