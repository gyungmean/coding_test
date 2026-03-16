import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] nowServer = new int[24];
        for(int i = 0; i < 24; i++) {
            if(players[i] < ((nowServer[i] + 1) * m)) continue;
            while(players[i] >= ((nowServer[i] + 1) * m)) {
                for(int j = i; j < i + k && j < 24; j++) {
                nowServer[j]++;
                }
                answer++;
            }
        }
        //System.out.println(Arrays.toString(nowServer));
        return answer;
    }
}