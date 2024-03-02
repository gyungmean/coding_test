import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {

	static BigDecimal[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] colorStones = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = 0;
		for(int i = 0; i < M; i++) {
			colorStones[i] = Integer.parseInt(st.nextToken());
			N += colorStones[i];
		}
		int K = Integer.parseInt(br.readLine());
		//(colorStones[i]CK들의 합 /NCK
		
		dp = new BigDecimal[N + 1][N + 1];
		fillDP();
		
		BigDecimal sum = new BigDecimal(0);
		for(int colorStone : colorStones) {
			if(colorStone < K) continue;
			sum = sum.add(dp[colorStone][K]);
		}
		BigDecimal answer = sum.divide(dp[N][K], 20, RoundingMode.HALF_UP);
		System.out.println(answer.toString());

	}
	
	static void fillDP() {
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = new BigDecimal(1);
			dp[i][1] = new BigDecimal(i);
			dp[i][i] = new BigDecimal(1);
		}
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
			}
		}
	}

}
