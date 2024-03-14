package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * 建构图进行求解
 * 同时因为 题目关系具有传递性，可考虑采用并查集，注意实现路径压缩
 */
public class CalcEquation {
    private class UnionFind {
        public UnionFind(int nodeNum) {
            this.parent = new int[nodeNum];
            this.weight = new double[nodeNum];
            for (int i = 0; i < nodeNum; i++) {
                this.parent[i] = i;
                this.weight[i] = 1.0d; // 自身到自身权重为 1
            }
        }

        /**
         * 父指针
         */
        private int[] parent;
        /**
         * 指向父节点的权重值
         */
        private double[] weight;

        /**
         * 路径压缩
         * @param x 需要查询的结点
         * @return 根结点的 id
         */
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x]; // 保存直接父节点，用于路径压缩后使用
                parent[x] = find(parent[x]); // 调整整条路径
                weight[x] *= weight[origin]; // 调整权重
            }
            return parent[x];
        }

        /**
         * 合并两条路径：选择其中一条路径的根节点作为另一条路径的父节点
         * @param x
         * @param y
         * @param value
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] / weight[x] * value;
        }

        /**
         * 判断两条结点所在路径是否共祖先
         * @param x
         * @param y
         * @return 联通返回倍数关系，非联通返回 -1
         */
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            }
            return -1.0;
        }

    }
    private HashMap<String, Integer> variables;
    private UnionFind unionFind;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values); // 构建图

        // 查询
        int querySize = queries.size();
        double[] result = new double[querySize];

        for (int i = 0; i < querySize; i++) {
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);
            if (!variables.containsKey(var1)) {
                result[i] = -1;
                continue;
            }
            int x = variables.get(var1);

            if (!variables.containsKey(var2)) {
                result[i] = -1;
                continue;
            }

            int y = variables.get(var2);

            result[i] = unionFind.isConnected(x, y);
        }
        return result;
    }
    protected void buildGraph(List<List<String>> equations, double[] values) {
        int equationSize = equations.size();
        variables = new HashMap<>(2 * equationSize);
        unionFind = new UnionFind(2 * equationSize);
        int id = 0;

        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!variables.containsKey(var1)) {
                variables.put(var1, id);
                id++;
            }
            if (!variables.containsKey(var2)) {
                variables.put(var2, id);
                id++;
            }

            unionFind.union(variables.get(var1), variables.get(var2), values[i]);
        }
    }
}
