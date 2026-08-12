import java.util.*;
class Solution {
    List<List<Integer>> tree = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        for(int i = 0; i <= n; i++){
            tree.add(new LinkedList<>());
        }
        for(int[] w : wires) {
            tree.get(w[0]).add(w[1]);
            tree.get(w[1]).add(w[0]);
        }
        int answer = Integer.MAX_VALUE;
        for(int[] w : wires) {
            tree.get(w[0]).remove(Integer.valueOf(w[1]));
            tree.get(w[1]).remove(Integer.valueOf(w[0]));
            int sub = count(1, 0, new boolean[n + 1]);
            sub = Math.abs((n - sub) - sub);
            answer = Math.min(sub, answer);
            tree.get(w[0]).add(w[1]);
            tree.get(w[1]).add(w[0]);
        }
        
        return answer;
    }
    int count(int idx, int now, boolean[] visited) {
        visited[idx] = true;
        int nowCount = 1;
        for(int next : tree.get(idx)) {
            if(!visited[next]) {
                nowCount += count(next, now + 1, visited);
            }
        }
        return nowCount;
    }
}