import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int tmpNum = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = tmpNum++;
            }
        }
        for(int i = 0; i < queries.length; i++) {
            int sx = queries[i][0] - 1, sy = queries[i][1] - 1, ex = queries[i][2] - 1, ey = queries[i][3] - 1;
            int min = Integer.MAX_VALUE;
            int prevNum = arr[sx + 1][sy];
            for(int y = sy; y <= ey; y++) {
                min = Math.min(min, arr[sx][y]);
                tmpNum = arr[sx][y];
                arr[sx][y] = prevNum;
                prevNum = tmpNum;
            }
            for(int x = sx + 1; x <= ex; x++) {
                min = Math.min(min, arr[x][ey]);
                tmpNum = arr[x][ey];
                arr[x][ey] = prevNum;
                prevNum = tmpNum;
            }
            for(int y = ey - 1; y >= sy; y--) {
                min = Math.min(min, arr[ex][y]);
                tmpNum = arr[ex][y];
                arr[ex][y] = prevNum;
                prevNum = tmpNum;
            }
            for(int x = ex - 1; x > sx; x--) {
                min = Math.min(min, arr[x][sy]);
                tmpNum = arr[x][sy];
                arr[x][sy] = prevNum;
                prevNum = tmpNum;
            }
            answer[i] = min;            
        }
        return answer;
    }
}