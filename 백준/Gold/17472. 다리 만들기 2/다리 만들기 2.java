import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	final static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int islandNum = 1;
	
	static int[][] graph;
	static int[] set;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		islandCounting();
		graph = new int[islandNum][islandNum];
		
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					makeBridge(map[i][j], i, j);
				}
			}
		}

		set = new int[islandNum];
		for(int i = 1; i < islandNum; i++) { //set init
			set[i] = i;
		}
		answer = 0;
		kruskal();
		System.out.println(answer);
	}
	
	static void kruskal() {
		int cnt = 1;
		List<Edge> edgeList = new ArrayList<>();
		for(int i = 1; i < islandNum; i++) {
			for(int j = 1; j < islandNum; j++) {
				if(graph[i][j] != 0) {
					edgeList.add(new Edge(i, j, graph[i][j]));
				}
			}
		}
		Collections.sort(edgeList);
		int edgeIdx = 0;
		while(cnt < islandNum) {
			if(edgeIdx >= edgeList.size()) {
				answer = -1;
				return;
			}
			Edge now = edgeList.get(edgeIdx++);
			if(find(now.v1) != find(now.v2)) {
				union(now.v1, now.v2);
				cnt++;
				answer += now.value;
				if(cnt == islandNum - 1) break;
			}
		}
	}
	
	static void union(int x, int y) {
		if(find(x) == find(y)) return;
		set[find(x)] = set[find(y)];
	}
	
	static int find(int x) {
		if(set[x] == x) return x;
		else return set[x] = find(set[x]);
	}
	
	static void makeBridge(int nowIsland, int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int length = 0;
			while(checkBound(nx, ny)) {
				if(map[nx][ny] == 0) {
					length++;
					nx += dx[i];
					ny += dy[i];
					continue;
				}
				else if(map[nx][ny] == nowIsland){
					break;
				}
				else {
					if(length == 1) break; // 1짜리 다리 안됨
					if(graph[nowIsland][map[nx][ny]] == 0) {
						graph[nowIsland][map[nx][ny]] = length;
						graph[map[nx][ny]][nowIsland] = length;
					}
					else {
						graph[nowIsland][map[nx][ny]] = Math.min(length, graph[nowIsland][map[nx][ny]]);
						graph[map[nx][ny]][nowIsland] = graph[nowIsland][map[nx][ny]];
					}
					break;
				}
				
			}
		}
	}
	
	static void islandCounting() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					floodFill(i, j);
				}
			}
		}
	}
	
	static void floodFill(int x, int y) {
		if(visited[x][y]) return;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		map[x][y] = islandNum;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(checkBound(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny] == 1) {
						map[nx][ny] = islandNum;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		islandNum++;
	}
	
	static boolean checkBound(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int value;
		public Edge(int v1, int v2, int value) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.value = value;
		}
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
		
	}
}
