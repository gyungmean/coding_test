import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(input);
		for(int i = 0; i < M; i++) {
			boolean flag = false;
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				int midValue = input[mid];
				if(midValue == target) {
					flag = true;
					sb.append("1").append("\n");
					break;
				}
				else if(midValue > target) {
					end = --mid;
					continue;
				}
				else if(midValue < target) {
					start = ++mid;
					continue;
				}
			}
			if(!flag) sb.append("0").append("\n");
		}
		System.out.println(sb);

	}
}