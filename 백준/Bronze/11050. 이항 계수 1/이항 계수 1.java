import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];
		fillDP();
		System.out.println(dp[N][K]);
		
	}
	
	static void fillDP(){
		for(int i = 0; i <= N; i++) {
			dp[i][0] = 1; //nC0 = 1개
			dp[i][1] = i; //nC1 = n개
			dp[i][i] = 1; //nCr(n==r) = 1개
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
	}

}