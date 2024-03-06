package graph;

public abstract class FS {
    protected int node_count;
    protected int[][] distance;
    private int[] path;

    public FS(int node_count) {
        this.node_count = node_count;
        this.distance = new int[node_count][node_count];
        Init();
        display();
    }
    protected void Init() {
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < i; j++) { // 限定 j，i 是横扫，j是纵扫，分析可知此限定不会重复
                if (i == j) {
                    distance[i][j] = 0; // 对角线为 0
                } else {
                    distance[i][j] = distance[j][i] = (int) Math.ceil(Math.random() * 50);
                }
            }
        }
    }
    public void display() {
        for (int[] row : distance) {
            for (int item : row) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }
    protected int findMinDistanceNode(int node) {
        int index = 0, save_dis = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (distance[node][i] < save_dis) {
                save_dis = distance[node][i];
                index = i;
            }
        }
        return index;
    }
    abstract public void searchPath();
}
