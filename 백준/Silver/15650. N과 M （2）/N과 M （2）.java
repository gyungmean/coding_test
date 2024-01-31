import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		rec(0, 0, N, M);
		System.out.println(sb.toString());
	}
	
	static void rec(int start, int d, int n, int m) {
		if(d == m) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[d] = i + 1;
				rec(i + 1, d + 1, n, m);
				visited[i] = false;
			}
		}
	}
}
