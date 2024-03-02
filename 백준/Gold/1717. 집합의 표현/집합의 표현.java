import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		set = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			set[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(op == 0) {
				union(a, b);
			}
			else if(op == 1) {
				if(findSet(a) == findSet(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);

	}
	
	static int findSet(int x) {
		if(set[x] == x) return x;
		else return set[x] = findSet(set[x]);
	}
	
	static void union(int x, int y) {
		if(findSet(x) == findSet(y)) return;
		set[findSet(x)] = set[findSet(y)];
	}

}
