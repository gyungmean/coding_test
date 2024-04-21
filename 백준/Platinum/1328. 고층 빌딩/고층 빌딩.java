import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int MOD = 1000000007;
	static long[][][] DP;
	static int N, R, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		DP = new long[N + 1][N + 1][N + 1];
		fillDP();
		System.out.println(DP[N][L][R] % MOD);

	}
	static void fillDP() {
		DP[1][1][1] = 1;
		for(int n = 2; n <= N; n++) {
			for(int l = 1; l <= n; l++) {
				for(int r = 1; r <= n; r++) {
					DP[n][l][r] = (DP[n - 1][l - 1][r] + DP[n - 1][l][r - 1] 
							+ DP[n - 1][l][r] * (n - 2)) % MOD;
				}
			}
		}
	}

}
