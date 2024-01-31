import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : T 테케 개수, N 달팽이 배열 크기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N * N 달팽이 배열, visited 배열, 방향배열
		int T = Integer.parseInt(br.readLine());
		int[][] snail;
		boolean[][] visited;
		int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			visited = new boolean[N][N];
			int x = 0;
			int y = 0;
			int d = 0;
			for(int i = 1; i <= N * N; i++) {
				visited[x][y] = true;
				snail[x][y] = i;
				if(check(x + direction[d][0], y + direction[d][1])) {
					if(visited[x + direction[d][0]][y + direction[d][1]]) {
						d = (d + 1) % 4;
					}
					x = x + direction[d][0];
					y = y + direction[d][1];
				}
				else {
					d = (d + 1) % 4;
					x = x + direction[d][0];
					y = y + direction[d][1];
				}
			}
			System.out.println("#" + test_case);
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					System.out.print(snail[j][k] +  " ");
				}
				System.out.println();
			}
		}
		// 출력 : 달팽이
		br.close();
	}
	
	static boolean check(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

}
