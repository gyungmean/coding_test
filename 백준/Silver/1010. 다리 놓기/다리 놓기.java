import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count, N, M;
	static int[] select;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[31][31];
		fillDP();
		for(int tc = 1; tc <= T; tc++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb);

	}
	
	static void fillDP() {
		for(int i = 0; i < 31; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
			dp[i][1] = i;
		}
		for(int i = 1; i < 31; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
	}

}
