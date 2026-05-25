import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] temp = new int[n][n];
        
        int x = -1, y = 0;
        int number = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) {
                    x++;
                }
                else if(i % 3 == 1) {
                    y++;
                }
                else {
                    x--;
                    y--;
                }
                temp[x][y] = number++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer.add(temp[i][j]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}