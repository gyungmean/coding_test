import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] inCount, outCount;
	static List<Node>[] graph, reverseGraph;
	static int startCity, endCity;
	static int[] sumTime;
	static int maxTime, loadCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		inCount = new int[N + 1]; //진입차수
		outCount = new int[N + 1]; //진출차수
		graph = new ArrayList[N + 1];
		reverseGraph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			outCount[start]++;
			inCount[end]++;
			graph[start].add(new Node(end, time));
			reverseGraph[end].add(new Node(start, time));
		}
		
		st = new StringTokenizer(br.readLine());
		startCity = Integer.parseInt(st.nextToken());
		endCity = Integer.parseInt(st.nextToken());
		
		sumTime = new int[N + 1];
		topologySort(startCity);
		maxTime = sumTime[endCity];
		reverseTopologySort(endCity);
		System.out.println(new StringBuilder().append(maxTime).append("\n").append(loadCount));
	}
	
	static void topologySort(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Node next : graph[now]) {
				inCount[next.city]--;
				if(inCount[next.city] == 0) {
					q.add(next.city);
				}
				sumTime[next.city] = Math.max(sumTime[next.city], sumTime[now] + next.time);
			}
		}
	}
	
	static void reverseTopologySort(int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(end);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Node next : reverseGraph[now]) {
					if(sumTime[now] == sumTime[next.city] + next.time) {
						loadCount++;
						if(!visited[next.city]) {
							visited[next.city] = true;
							q.add(next.city);
						}
					}
				
			}
		}
	}
	
	static class Node{
		int city;
		int time;
		public Node(int city, int time) {
			super();
			this.city = city;
			this.time = time;
		}
	}

}
