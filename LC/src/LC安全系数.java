import java.util.ArrayList;
import java.util.List;

public class LC安全系数 {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 并查集模板
    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }


    /**
     * 求解安全路径，这个题目和机器人走路有所不同，它的每个点可能会从任何地方转移过来，所以不能用动态规划的方式求解、
     * 首先，由于每个点都要求曼哈顿距离，所以可以采用多源bfs的方式给每个点都求一下曼哈顿距离
     * @param grid
     * @return
     */
    public int maximumSafenessFactor1(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] path = new int[n][n];
        List<int[]> grids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 0) {
                    path[i][j] = -1; // 标记为没有小偷的点
                } else {
                    grids.add(new int[] {i, j});
                }
            }
        }
        List<List<int[]>> g = new ArrayList<>();
        g.add(grids);
        while (!grids.isEmpty()) { // 不为空的时候
            List<int[]> temp = grids; // 标记为临时数组
            grids = new ArrayList<>();
            for(int[] po : temp) { // 渲染
                for(int[] po1 : DIRS) {
                    int x = po[0] + po1[0],y = po[1] + po1[1];
                    if (x >=0 && x < n && y >= 0 && y <= n && path[x][y] == -1) {  // 没有遍历过的点
                        grids.add(new int[] {x, y});
                        path[x][y] = g.size();
                    }
                }
            }
            g.add(grids); // 归类
        }
        fa = new int[n * n];  // 点集
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;  // 指向自己
        }
        for (int ans = g.size() - 2; ans >= 0 ; ans--) {  // 遍历分好类的点集
            List<int[]> ints = g.get(ans); // 取出点
            for(int[] po : ints) {
                int x = po[0], y = po[1];
                for(int[] xy : DIRS) {
                    int x1 = xy[0] + x, y1 = xy[1] + y;
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && path[x1][y1] >= path[x][y]) {
                        fa[find(x * n + y)] = find(x1 * n + y1);  // 合并
                    }
                }
                if (find(0) == find(n * n - 1)) return ans;
            }
        }
        return 0;
    }

}
