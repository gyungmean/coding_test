import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        int[][] dp = new int[len + 1][len];
        for(int i = 0; i < len; i++) {
            dp[1][i] = elements[i];
            set.add(elements[i]);
        }
        for(int i = 2; i < len + 1; i++) {
            for(int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][j] + elements[(i - 1 + j) % len];
                set.add(dp[i][j]);
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println(set.toString());

        return set.size();
    }
}