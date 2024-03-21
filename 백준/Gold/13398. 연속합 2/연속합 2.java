import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int[] leftSum = new int[N];
		int[] rightSum = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		leftSum[0] = nums[0];
		rightSum[N - 1] = nums[N - 1];
		int answer = leftSum[0];
		for(int i = 1; i < N; i++) {
			leftSum[i] = Math.max(leftSum[i - 1] + nums[i], nums[i]);
			answer = Math.max(answer, leftSum[i]);
		}
		for(int i = N - 2; i >= 0; i--) {
			rightSum[i] = Math.max(rightSum[i + 1] + nums[i], nums[i]);
		}
		
		for(int i = 1; i < N - 1; i++) {
			answer = Math.max(answer, leftSum[i - 1] + rightSum[i + 1]);
		}
		System.out.println(answer);
	}
}
