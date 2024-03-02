import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<Bus>[] graph;
	static int[] cost;
	static int N, M;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //도시의 개수
		M = Integer.parseInt(br.readLine()); //버스의 개수
		StringTokenizer st;
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int busStart = Integer.parseInt(st.nextToken());
			int busEnd = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[busStart].add(new Bus(busEnd, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		cost[start] = 0;
		find(start);
		System.out.println(cost[end]);
	}
	
	static void find(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start, 0));
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			if(!visited[now.city]) {
				visited[now.city] = true;
				for(Bus next : graph[now.city]) {
					if(cost[next.city] > cost[now.city] + next.cost) {
						cost[next.city] = cost[now.city] + next.cost;
						pq.add(new Bus(next.city, cost[next.city]));
					}
				}
			}
		}
	}
	
	static class Bus implements Comparable<Bus>{
		int city;
		int cost;
		public Bus(int city, int cost) {
			super();
			this.city = city;
			this.cost = cost;
		}
		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}

}
