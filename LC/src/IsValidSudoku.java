/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/11/011
 * @Copyright： https://clearskycpy.cn
 */
public class IsValidSudoku {
    /**
     * 验证数独是否有效
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
//        遍历行
        for(char[] row : board) {
            int i = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '.') continue;
                int num = row[j] - '0';
                if (((i >> num) & 1) == 1) return false;
                i ^= (1 << num);
            }

        }
        System.out.println("1");
//        遍历列
        for (int i1 = 0; i1 < 9; i1++) {
            int i = 0;
            for (int j = 0; j < 9; j++) {
                if(board[j][i1] == '.') continue;
                int num = board[j][i1] - '0';
                if (((i >> num) & 1) == 1) return false;
                i ^= (1 << num);
            }

        }
//        遍历方块
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                int i1 = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if(board[x][y] == '.') continue;
                        int num = board[x][y] - '0';
                        if (((i1 >> num) & 1) == 1) return false;
                        i1 ^= (1 << num);
                    }
                }
            }
        }
        return true;
    }


}
