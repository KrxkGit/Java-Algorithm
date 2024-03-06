package graph;

public class DFS extends FS {
    public DFS(int node_count) {
        super(node_count);
        searchPath();
    }

    @Override
    public void searchPath() {
        System.out.println();
        boolean[] visited = new boolean[distance.length];
        dfs_helper(0, visited);

    }
    public void dfs_helper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.printf("%d ", node);
        for (int neighbor = 0; neighbor < distance.length; neighbor++) {
            if (node == neighbor) {
                continue;
            }
            if (!visited[neighbor]) {
                dfs_helper(neighbor, visited);
            }
        }
    }
}
