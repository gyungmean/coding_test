import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//정점의 개수
		int M = Integer.parseInt(st.nextToken());//간선의 개수
		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++){
			A[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s); //양방향 모두 더하기
		}
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	
	static void DFS(int v) {
		if(visited[v]) return;
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) DFS(i);
		}
	}

}