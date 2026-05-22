import java.util.*;

class Solution {
    int answer = 0;
    int[][] graph;

    public int solution(int n, int[][] costs) {
        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        
        for(int[] cost : costs) {
            graph[cost[0]][cost[1]] = cost[2];
            graph[cost[1]][cost[0]] = cost[2];
        }
        
        find(n);
        return answer;
    }

    void find(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n];
        
        pq.add(new Node(0, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx]) continue;

            visited[now.idx] = true;
            answer += now.cost;
            
            for(int i = 0; i < n; i++) {
                if(i == now.idx) continue;
                if(graph[now.idx][i] == -1) continue; 
                if(visited[i]) continue;
                
                pq.add(new Node(i, graph[now.idx][i]));
            }
        }
    }
}

class Node {
    int idx;
    int cost;
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}