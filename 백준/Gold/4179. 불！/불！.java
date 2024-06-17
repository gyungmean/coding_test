import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int R, C;
	static Point start;
	static Queue<Point> fireQ = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				char next = line.charAt(j);
				if(next == '#') {
					map[i][j] = -1;
				}
				else if(next == 'J') {
					start = new Point(i, j);
				}
				else if(next == 'F') {
					map[i][j] = 1;
					fireQ.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
	}
	
	static void bfs() {
		//불 번짐
		while(!fireQ.isEmpty()) {
			Point nowFire = fireQ.poll();
			int nowFireTime = map[nowFire.x][nowFire.y];
			for(int i = 0; i < 4; i++) {
				int nx = nowFire.x + dx[i];
				int ny = nowFire.y + dy[i];
				if(boundCheck(nx, ny)) {
					if(map[nx][ny] == 0 && !visited[nx][ny]) {
						map[nx][ny] = nowFireTime + 1;
						fireQ.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		visited = new boolean[R][C];
		
		Queue<Jihoon> jihoonQ = new ArrayDeque<>();
		jihoonQ.add(new Jihoon(start.x, start.y, 1));
		visited[start.x][start.y] = true;
		while(!jihoonQ.isEmpty()) {
			Jihoon now = jihoonQ.poll();
			//탈출 가능 확인
			if(checkEscape(now.x, now.y)) {
				System.out.println(now.time);
				return;
			}
			
			//fireQ = newFireQ;
			//지훈 이동
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(boundCheck(nx, ny) && !visited[nx][ny]) {
					if(map[nx][ny] == 0 || map[nx][ny] > now.time + 1) {
						jihoonQ.add(new Jihoon(nx, ny, now.time + 1));
						visited[nx][ny] = true;
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	
	static boolean checkEscape(int x, int y) {
		if(x == 0 || x == R - 1 || y == 0 || y == C - 1) return true;
		else return false;
	}
	
	static boolean boundCheck(int x, int y) {
		if(x < 0 || x >= R || y < 0 || y >= C) return false;
		return true;
	}
	
	static class Jihoon{
		int x;
		int y;
		int time;
		public Jihoon(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
}
