import java.util.*;
import java.awt.Point;
class Solution {
    int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    int x, y;
    boolean[][] visited;
    char[][] map;
    public int[] solution(String[] maps) {
        x = maps.length;
        y = maps[0].length();
        visited = new boolean[x][y];
        map = new char[x][y];
        for(int i = 0; i < x; i++) {
            map[i] = maps[i].toCharArray();
        }
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                   answer.add(find(i, j)); 
                }
            }
        }
        if(answer.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    int find(int startX, int startY) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;
        int sum = map[startX][startY] - '0';
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if(nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if(!visited[nx][ny] && map[nx][ny] != 'X') {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        sum += (map[nx][ny] - '0');
                    }
                }
            }
        }
        return sum;
    }
}