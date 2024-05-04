import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	final static int MAX = 1000000;
	static int[][] power = {
			{1, 2, 2, 2, 2},
			{2, 1, 3, 4, 3},
			{2, 3, 1, 3, 4},
			{2, 4, 3, 1, 3},
			 {2, 3, 4, 3, 1}};
	static int[][][] DP;
	static List<Integer> direction;
	static int size, answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		direction = new ArrayList<>();
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) break;
			direction.add(num);
		}
		size = direction.size();
		DP = new int[size + 1][5][5];
		for(int t = 0; t <= size; t++) {
			for(int i = 0; i <= 4; i++) {
				for(int j = 0; j <= 4; j++) {
					DP[t][i][j] = MAX; 
				}
			}
		}
		DP[0][0][0] = 0;
		calcPower();
		System.out.println(answer);
	}
	
	static void calcPower() {
		for(int turn = 1; turn <= size; turn++) {
			int next = direction.get(turn - 1); //다음에 위치할 번호
			//왼발 움직일 경우
			for(int r = 0; r <= 4; r++) {
				if(next == r) continue;
				for(int l = 0; l <= 4; l++) { 
					DP[turn][next][r] = Math.min(DP[turn - 1][l][r] + power[l][next], DP[turn][next][r]);
				}
			}
			
			//오른말 움직인 경우
			for(int l = 0; l <= 4; l++) {
				if(next == l) continue;
				for(int r = 0; r <= 4; r++) { 
					DP[turn][l][next] = Math.min(DP[turn - 1][l][r] + power[r][next], DP[turn][l][next]);
				}
			}
		}
		
		for(int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 4; j++) {
				answer = Math.min(answer, DP[size][i][j]);
			}
		}
		
	}

}
