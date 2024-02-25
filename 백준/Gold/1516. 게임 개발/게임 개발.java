import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] time, needBuildingCount, answer;
	static List<Integer>[] nextBuilding;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //건물의 종류
		time = new int[N + 1]; //건물을 짓는데 필요한 시간
		nextBuilding = new ArrayList[N + 1]; //조건에 따라 지어야하는 건물
		for(int i = 1; i <= N; i++) {
			nextBuilding[i] = new ArrayList<>();
		}
		needBuildingCount = new int[N + 1]; //진입차수
		answer = new int[N + 1]; //정답 배열
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int building;
			while((building = Integer.parseInt(st.nextToken())) != -1) {
				nextBuilding[building].add(i);
				needBuildingCount[i]++; //진입 차수 증가
			}
		}
		//위상정렬
		Queue<Integer> buildingQueue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(needBuildingCount[i] == 0) { //건물을 짓는데 필요한 조건이 없는 건물들 큐에 추가
				buildingQueue.add(i);
				visited[i] = true;
			}
		}
		while(!buildingQueue.isEmpty()) {
			int now = buildingQueue.poll();
			for(int next : nextBuilding[now]) {
				needBuildingCount[next]--;
				answer[next] = Math.max(answer[next], answer[now] + time[now]);
			}
			for(int i = 1; i <= N; i++) {
				if(needBuildingCount[i] == 0 && !visited[i]) {
					buildingQueue.add(i);
					visited[i] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {;
			sb.append(answer[i] + time[i]).append("\n");
		}
		System.out.println(sb);

	}

}
