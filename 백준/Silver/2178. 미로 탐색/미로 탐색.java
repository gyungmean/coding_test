import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] maze;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		//입력 : 배열 크기 N, M, 배열 내용 붙어서 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		bfs(0, 0, 1);
		System.out.println(maze[N - 1][M - 1]);
	}
	
	static void bfs(int x, int y, int dept) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				if(check(now[0] + dx[i], now[1] + dy[i])) {
					if(!visited[now[0] + dx[i]][now[1] + dy[i]] && maze[now[0] + dx[i]][now[1] + dy[i]] != 0) {
						visited[now[0] + dx[i]][now[1] + dy[i]] = true;
						maze[now[0] + dx[i]][now[1] + dy[i]] = maze[now[0]][now[1]] + 1;
						q.add(new int[] {now[0] + dx[i], now[1] + dy[i]});
					}
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
		if(x >= N || x < 0 || y >= M || y < 0) return false;
		return true;
	}

}