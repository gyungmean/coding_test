import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        //토마토 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { //현재 익은 토마토들 위치 큐에 넣기
                    q.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }
	
	public static int bfs() {
		//큐에서 좌표 poll하고 나온 좌표의 값 + 1해서 상하좌우의 위치에 +로 표시하고
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			for(int i = 0; i < 4; i++) {
				if(check(now_x + dx[i], now_y + dy[i])) {
					if(map[now_x + dx[i]][now_y + dy[i]] == -1)continue; //전진 불가
					if(map[now_x + dx[i]][now_y + dy[i]] == 0) { //안 익은 토마토익히기
						map[now_x + dx[i]][now_y + dy[i]] = map[now_x][now_y] + 1;
						q.add(new int[] {now_x + dx[i],now_y + dy[i]});
					}
				}
					
			}
		}
		//일수 찾기
		int max = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(max < map[i][j]) max = map[i][j];
			}
		}
		if(!ripe()) return -1;
		return max - 1;
	}
	
	public static boolean check(int x, int y) { //범위 확인
		if(x < n && x >= 0 && y < m && y >= 0) return true;
		return false;
	}
	
	public static boolean ripe() { //안 익은 토마토가 있나?
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
}
