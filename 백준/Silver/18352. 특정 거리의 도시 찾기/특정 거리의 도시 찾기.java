import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점 개수
		int M = Integer.parseInt(st.nextToken()); //간선 개수
		int K = Integer.parseInt(st.nextToken()); //구해야하는 최단 거리
		int X = Integer.parseInt(st.nextToken()); //시작점
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
		}
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		
		dijkstra(X);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) sb.append(i).append("\n");
		}
		if(sb.length() == 0) sb.append(-1);
		System.out.println(sb);

	}
	
	static void dijkstra(int start) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(start);
		visited[start] = true;
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int now = pq.poll();
			for(int next : graph[now]) {
				if(!visited[next]) {
					if(dist[next] > dist[now] + 1) {
						dist[next] = dist[now] + 1;
						pq.add(next);
						visited[next] = true;
					}
				}
			}
		}
	}

}
