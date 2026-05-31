import java.util.*;
class Solution {
    int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        for(int[] p : puddles) {
            map[p[0] - 1][p[1] - 1] = -1;
        }
        map[0][0] = 1;
        boolean blocked = false;
        for (int i = 0; i < m; i++) {
            if (map[i][0] == -1) {
                blocked = true;
                continue;
            }
            map[i][0] = blocked ? 0 : 1;
        }
        blocked = false;
        for (int i = 0; i < n; i++) {
            if (map[0][i] == -1) {
                blocked = true;
                continue;
            }
            map[0][i] = blocked ? 0 : 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(map[i][j] == -1) continue;
                if(map[i - 1][j] == -1 && map[i][j - 1] == -1) {
                    map[i][j] = -1;
                }
                else if(map[i][j - 1] == -1) {
                    map[i][j] = map[i - 1][j];
                }
                else if(map[i - 1][j] == -1) {
                    map[i][j] = map[i][j - 1];
                }
                else {
                    map[i][j] = map[i - 1][j] % 1000000007 + map[i][j - 1] % 1000000007;
                }
            }
        }
        
        return map[m - 1][n - 1] % 1000000007;
    }
    
}
