import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Edge> edgeList;
	static long[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList<>();
		distance = new long[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(start, end, value));
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Edge now = edgeList.get(j);
				if(distance[now.start] != Integer.MAX_VALUE
						&& distance[now.end] > distance[now.start] + now.value) {
					distance[now.end] = distance[now.start] + now.value;
				}
			}
		}
		boolean flag = false;
		for(int i = 0; i < M; i++) { //음수 사이클 확인
			Edge now = edgeList.get(i);
			if(distance[now.start] != Integer.MAX_VALUE
					&& distance[now.end] > distance[now.start] + now.value) {
				flag = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(!flag) {
			for(int i = 2; i <= N; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					sb.append("-1\n");
				}
				else {
					sb.append(distance[i]).append("\n");
				}
			}
		}
		else {
			sb.append("-1");
		}
		System.out.println(sb);
	}
	
	static class Edge{
		int start;
		int end;
		int value;
		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}
	}

}
