/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/16/016
 * @Copyright： https://clearskycpy.cn
 */
public class Rotate {
    /**
     * 将二维数组顺时针旋转九十度
     *  对角线对折，再翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                swap(i,j,j,i,matrix);
            }
        }
        for (int i = 0; i < n; i++) {
            int l = 0, r = n -1;
            while (l < r) {
                swap(l,i,r,i,matrix);
                l++;
                r--;
            }
        }
    }

    private void swap(int i, int j, int x, int y, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
