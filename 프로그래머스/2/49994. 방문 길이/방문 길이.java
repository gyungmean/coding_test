import java.util.*;

class Solution {
    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];
        int answer = 0;
        int nx = 0, ny = 0;
        
        for(char command : dirs.toCharArray()) {
            int nextX = nx;
            int nextY = ny;

            if(command == 'U') {
                nextX--;
            } else if(command == 'D') {
                nextX++;
            } else if(command == 'L') {
                nextY--;
            } else if(command == 'R') {
                nextY++;
            }
            
            if(boundCheck(nextX, nextY)) {
                int curXIdx = nx + 5;
                int curYIdx = ny + 5;
                int nextXIdx = nextX + 5;
                int nextYIdx = nextY + 5;

                if(!visited[curXIdx][curYIdx][nextXIdx][nextYIdx]) {
                    visited[curXIdx][curYIdx][nextXIdx][nextYIdx] = true;
                    visited[nextXIdx][nextYIdx][curXIdx][curYIdx] = true; 
                    answer++;
                }
                
                nx = nextX;
                ny = nextY;
            }
        }
        return answer;
    }
    
    boolean boundCheck(int x, int y) {
        return -5 <= x && x <= 5 && -5 <= y && y <= 5;
    }
}