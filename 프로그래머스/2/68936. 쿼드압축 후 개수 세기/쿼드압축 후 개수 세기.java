import java.util.*;
class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        find(0, 0, arr.length, arr);
        return answer;
    }
    
    void find(int x, int y, int size, int[][] arr) {
        int first = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    int half = size / 2;

                    find(x, y, half, arr);
                    find(x + half, y, half, arr);
                    find(x, y + half, half, arr);
                    find(x + half, y + half, half, arr);

                    return;
                }
            }
        }

        answer[first]++;
    }
    
}