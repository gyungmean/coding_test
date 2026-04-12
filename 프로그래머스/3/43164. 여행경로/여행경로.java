import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for (String[] t : tickets) {
            graph.putIfAbsent(t[0], new PriorityQueue<>());
            graph.get(t[0]).offer(t[1]);
        }

        dfs("ICN");

        return route.toArray(new String[0]);
    }

    void dfs(String now) {
        PriorityQueue<String> pq = graph.get(now);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        route.addFirst(now); 
    }
}