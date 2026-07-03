import java.util.*;
import java.io.*;

class Solution {
    int[][] map = new int[102][102];
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        fillMap(rectangle);
        
        int answer = bfs(characterX, characterY, itemX, itemY);
        return answer;
    }
    
    int bfs(int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[102][102];
        Queue<Point> q = new ArrayDeque<>();

        q.add(new Point(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;

        int targetX = itemX * 2;
        int targetY = itemY * 2;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!boundCheck(nx, ny)) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1) {

                    if (nx == targetX && ny == targetY) {
                        return (now.count + 1) / 2;
                    }

                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, now.count + 1));
                }
            }
        }
        return 0;
    }
    
    boolean boundCheck(int x, int y){
        if(x < 0 || x >= 102 || y < 0 || y >= 102) return false;
        return true;
    }
    
    void fillMap(int[][] rectangle){
        for(int[] r : rectangle) {
            int startX = r[0] * 2;
            int startY = r[1] * 2;
            int endX = r[2] * 2;
            int endY = r[3] * 2;
            
            for(int i = startX; i <= endX; i++) {
                for(int j = startY; j <= endY; j++) {
                    if(map[i][j] == 2) continue; 
                    
                    if(i == startX || i == endX || j == startY || j == endY) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    int count;
    public Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}