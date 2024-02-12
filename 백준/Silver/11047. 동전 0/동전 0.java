import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 입력 : N - 동전의 종류, K - 가격의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for(int i = N - 1; i >= 0 && K != 0; i--) {
			if(coins[i] > K) continue;
			count += (K / coins[i]);
			K = K % coins[i];
		}
		System.out.println(count);

	}

}