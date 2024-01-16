import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static boolean[] visit;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		int[][] edges = new int[n][2];
		visit = new boolean[computer + 1];
		
		for(int i = 0; i < n; i++) {
			String tmp = bf.readLine();
			String[] tmp_arr = tmp.split(" ");
			edges[i][0] = Integer.parseInt(tmp_arr[0]);
			edges[i][1] = Integer.parseInt(tmp_arr[1]);
		}
	
		ArrayList<Integer>[] list = new ArrayList[computer + 1];

		for (int i = 0; i <= computer; i++) list[i] = new ArrayList<>();
		
		for(int[] edge : edges) {
			list[edge[0]].add(edge[1]);
			list[edge[1]].add(edge[0]);
		}
		
		dfs(1, list);
		System.out.println(count - 1);

	}
	
	public static void dfs(int v, ArrayList<Integer>[] list) {
		visit[v] = true;
		count++;
		for(int nextV : list[v]) {
			if(!visit[nextV]) dfs(nextV, list);
		}
	}
}
