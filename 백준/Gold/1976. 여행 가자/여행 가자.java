import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] plan, connect;
	static boolean flag = true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		connect = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			connect[i] = i;
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				if(connect == 1 && (find(i) != find(j))) {
					union(i, j);
				}
			}
		}
		plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < M; i++) {
			if(find(plan[i - 1]) != find(plan[i])) flag = false;
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static int find(int x) {
		if(connect[x] == x) return x;
		else return connect[x] = find(connect[x]);
	}
	
	static void union(int x, int y) {
		if(find(x) == find(y)) return;
		connect[find(x)] = connect[find(y)];
	}

}
