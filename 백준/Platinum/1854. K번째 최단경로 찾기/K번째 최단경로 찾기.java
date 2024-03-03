import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int value;

        public Node(int idx, int value) {
            super();
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static List<Node>[] graph;
    static PriorityQueue<Integer>[] dist;
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
        	public int compare(Integer o1, Integer o2) {
        		return o1 < o2 ? 1 : -1;
        	}
        };
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, value));
        }
        dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(k, cp);
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // k찾기
            if (dist[i].size() == k) {
                sb.append(dist[i].peek()).append("\n");
            }
            else {
            	sb.append(-1).append("\n");
            }
            //sb.append(dist[i].get(k - 1)).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : graph[now.idx]) {
            	if(dist[next.idx].size() < k) {
            		dist[next.idx].add(now.value + next.value);
            		pq.add(new Node(next.idx, now.value + next.value));
            	}
            	else if(dist[next.idx].peek() > now.value + next.value) {
            		dist[next.idx].poll();
            		dist[next.idx].add(now.value + next.value);
            		pq.add(new Node(next.idx, now.value + next.value));
            	}
            }
        }
    }
}

