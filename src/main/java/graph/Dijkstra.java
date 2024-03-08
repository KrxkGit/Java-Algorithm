package graph;

public class Dijkstra {
    static int[] distance;
    static int walk = 0;

    public Dijkstra() {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph, 0);
        displayDistance();
    }

    /**
     * start 为起点索引
     * @param graph
     * @param start
     */
    public static void dijkstra(int[][] graph, int start) {
        // 输出一个表，保存每一个目标节点到出发点的最小距离
        distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = graph[j][i] = Integer.MAX_VALUE;
                }
            }
            if (i == start) {
                distance[i] = 0;
                visited[i] = true;
                continue;
            }
            distance[i] = Integer.MAX_VALUE;
        }
        updateAdjacentRoute(graph, start, visited);

//        int curVertex = start;
        for (;true;) {
            int next =  findMinPointFromOrigin(graph, visited);
            if (next == -1) {
                System.out.println("非连通图");
                return;
            }
            visited[next] = true;

            updateAdjacentRoute(graph, next, visited);

            walk++;
        }

    }
    protected static void updateAdjacentRoute(int[][]graph, int curVertex, boolean[] visited) {
        // 更新该点周围的点
        for (int j = 0; j < distance.length; j++) {
            if (visited[j] || graph[curVertex][j] == Integer.MAX_VALUE || curVertex == j) {
                // 不可达点
                continue;
            }
            int save = distance[curVertex] == Integer.MAX_VALUE ? graph[curVertex][j] :
                    distance[curVertex] + graph[curVertex][j];


            distance[j] = distance[j] < save ? distance[j] : save;

        }


    }
    public void displayDistance() {
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("%d ", distance[i]);
        }
    }

    protected static int findMinPointFromOrigin(int[][]graph, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int save = -1;
        for (int j = 0; j < graph.length; j++) {
            if (visited[j]) {
                continue;
            }
            if (minDistance > distance[j]) {
                minDistance = distance[j];
                save = j;
            }
        }
        return save;
    }
}
