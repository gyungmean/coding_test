import java.util.*;
import java.awt.Point;

class Solution {
    final char VOID = '0';
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        char[][] warehouse = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(warehouse[i], VOID);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                warehouse[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for (String req : requests) {
            char target = req.charAt(0);
            boolean[][] outside = new boolean[n + 2][m + 2];
            Queue<Point> q = new ArrayDeque<>();
            q.add(new Point(0, 0));
            outside[0][0] = true;
            
            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    
                    if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                    if (outside[nx][ny]) continue;
                    
                    if (warehouse[nx][ny] == VOID) {
                        outside[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            
            if (req.length() == 1) {
                List<Point> remove = new ArrayList<>();
                
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (warehouse[i][j] == target) {
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];
                                
                                if (outside[ni][nj]) {
                                    remove.add(new Point(i, j));
                                    break;
                                }
                            }
                        }
                    }
                }
                
                for (Point p : remove) {
                    warehouse[p.x][p.y] = VOID;
                }
                
            } else {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (warehouse[i][j] == target) {
                            warehouse[i][j] = VOID;
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (warehouse[i][j] != VOID) answer++;
            }
        }
        
        return answer;
    }
}