import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        play(k, 0, dungeons, visited);
        return answer;
    }
    
    void play(int fatigue, int count, int[][] dungeons, boolean[] visited) {
        answer = Math.max(answer, count);
        for(int i = 0; i < dungeons.length; i++) {
            int minimum = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visited[i] && fatigue >= minimum) {
                visited[i] = true;
                play(fatigue - cost, count + 1, dungeons, visited);
                visited[i] = false;
            }
        }
    }

}