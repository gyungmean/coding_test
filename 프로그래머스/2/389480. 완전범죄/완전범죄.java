import java.util.*;
class Solution {
    final int MAX = 121;
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length + 1][m];
        for(int[] line : dp) {
            Arrays.fill(line, MAX);
        }
        dp[0][0] = 0;
        //dp[0][0] = 아무것도 고려되지 않은상태
        
        for(int i = 1; i <= info.length; i++) {
            int a흔적 = info[i - 1][0];
            int b흔적 = info[i - 1][1];
            
            //만약 a가 i번째 물건을 가져갔다면??
            //b는 그대로 a만 증가
            for(int b = 0; b < m; b++) {
                //A가 물건 가져감
                //B는 그대로 A만 늘어남    
                int a가가져갔을때값 = dp[i - 1][b] != MAX ? dp[i - 1][b] + a흔적 : MAX;
                //A는 그대로 B만 늘어남 (b-b흔적 값이 곧 이번값과 동일)
                int b가가져갔을때값 = b - b흔적 >= 0 ? dp[i - 1][b - b흔적] : MAX;
                
                dp[i][b] = Math.min(a가가져갔을때값, b가가져갔을때값);
            }
            
        }
        
        int answer = MAX;
        for(int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[info.length][b]);
        }

        return (answer >= n || answer == MAX) ? -1 : answer;
    }
}