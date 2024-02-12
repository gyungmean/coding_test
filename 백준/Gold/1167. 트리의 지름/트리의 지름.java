import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static int maxDistance = Integer.MIN_VALUE, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : N - 트리의 정점 개수, 간선 정보 : 정점 번호 1, 연결된 정점의 번호, 거리 종료 -1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		StringTokenizer st;
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int nums = Integer.parseInt(st.nextToken());
			tree[nums] = new ArrayList<>();
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1) break;
				int e = Integer.parseInt(st.nextToken());
				tree[nums].add(new Node(v, e));
			}
		}
		int maxNodeIndex = bfs(1);
		visited = new boolean[N + 1];
		bfs(maxNodeIndex);
		// 출력 : 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것
		System.out.println(maxDistance);
		
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] distanceFromStart = new int[N + 1];
		q.add(start);
		visited[start] = true;
		int now = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i = 0; i < tree[now].size(); i++) {
				if(!visited[tree[now].get(i).v]) {
					q.add(tree[now].get(i).v);
					visited[tree[now].get(i).v] = true;
					distanceFromStart[tree[now].get(i).v] = distanceFromStart[now] + tree[now].get(i).e;
				}
			}
		}
		int maxIndex = 0;
		for(int i = 1; i <= N; i++) {
			if(distanceFromStart[maxIndex] <= distanceFromStart[i]) maxIndex = i;
		}
		maxDistance = distanceFromStart[maxIndex];
		return maxIndex;
	}

}
class Node{
	int v;
	int e;
	Node(int v, int e){
		this.v = v;
		this.e = e;
	}
}
