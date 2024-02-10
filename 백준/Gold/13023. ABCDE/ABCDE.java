import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] friends;
	static boolean[] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		// 입력 : N - 사람의 수 , M - 친구 관계의 수, a랑 b는 칭구칭긔
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		for(int i = 0; i < N; i++) {
			flag = false;
			dfs(i, 1);
			if(flag) break;
		}
		if(flag) System.out.println(1);
		else System.out.println(0);

	}
	
	static void dfs(int now, int dept) {
		if(dept == 5) {
			flag = true;
			return;
		}
		visited[now] = true;
		for(int i : friends[now]) {
			if(!visited[i]) dfs(i, dept + 1);
		}
		visited[now] = false; //다른 시작점에서 다시 탐색해야하므로
	}

}
