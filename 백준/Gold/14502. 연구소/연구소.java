import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	final static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	//0 : 빈칸  1: 벽 2 : 바이러스
	static int N, M, safeZone = 0;
	static int[][] map;
	static List<Point> virus, wallPosition;
	static boolean[][] visited;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<>();
		wallPosition = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new Point(i, j));
				else if(map[i][j] == 0) {
					safeZone++;
					wallPosition.add(new Point(i, j));
				}
			}
		}
		//입력 끝 *************
		int[] p = new int[wallPosition.size()];
		int cnt = 1;
		while(cnt <= 3) p[wallPosition.size() - cnt++] = 1;
		do {
			int[][] tmpMap = new int[N][M];
			for(int i = 0; i < N; i++) {
				tmpMap[i] = map[i].clone();
			}
			for(int i = 0; i < wallPosition.size(); i++) {
				if(p[i] != 0) {
					int x = wallPosition.get(i).x;
					int y = wallPosition.get(i).y;
					tmpMap[x][y] = 1;
				}
			}
			int tmpCount = safeZone - 3;
			visited = new boolean[N][M];
			for(Point v : virus) {
				tmpCount = bfs(v, tmpMap, tmpCount);
			}
			answer = Math.max(answer, tmpCount);
			
		}while(np(p));
		System.out.println(answer);
	}
	
	static int bfs(Point start, int[][] tmpMap, int tmpCount) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(checkBound(nx, ny) && !visited[nx][ny]) {
					if(tmpMap[nx][ny] == 1) {
						visited[nx][ny] = true;
						continue;
					}
					else if(tmpMap[nx][ny] == 0) {
						visited[nx][ny] = true;
						tmpMap[nx][ny] = 2;
						tmpCount--;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		return tmpCount;
	}
	
	static boolean np(int[] p) {
		int i = wallPosition.size() - 1;
		while(i > 0 && p[i - 1] >= p[i]) i--;
		if(i == 0) return false;
		
		int j = wallPosition.size() - 1;
		while(p[i - 1] >= p[j]) j--;
		swap(p, i - 1, j);
		
		int k = wallPosition.size() - 1;
		while(i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	static boolean checkBound(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}

}
