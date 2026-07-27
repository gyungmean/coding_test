import java.util.*;
class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            find(i, computers);
        }
        return answer;
    }
    
    void find(int com, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(com);
        visited[com] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next = 0; next < computers.length; next++) {
                if(next == now) continue;
                if(computers[now][next] == 0) continue;
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        answer++;
    }
    
}