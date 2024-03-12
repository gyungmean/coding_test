import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] knowTruth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int knowTruthCount = Integer.parseInt(st.nextToken());
		if(knowTruthCount == 0) {
			System.out.println(M);
		}
		else if(knowTruthCount == N) {
			System.out.println(0);
		}
		else {
			int answer = 0;
			List<Integer>[] partyInfo = new ArrayList[M];
			knowTruth = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				knowTruth[i] = i;
			}
			int firstPerson = Integer.parseInt(st.nextToken());
			for(int i = 1; i < knowTruthCount; i++) {
				union(firstPerson, Integer.parseInt(st.nextToken()));
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int partyPeopleCount = Integer.parseInt(st.nextToken());
				partyInfo[i] = new ArrayList<>();
				for(int j = 0; j < partyPeopleCount; j++) {
					partyInfo[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i < M; i++) {
				for(int person : partyInfo[i]) {
					union(partyInfo[i].get(0), person);
				}
			}
			for(int i = 0; i < M; i++) {
				if(find(firstPerson) != find(partyInfo[i].get(0))) answer++;
			}
			
			System.out.println(answer);
			
		}

	}
	
	static int find(int x) {
		if(knowTruth[x] == x) return x;
		else return knowTruth[x] = find(knowTruth[x]);
	}
	
	static boolean union(int x, int y) {
		if(find(x) == find(y)) return false;
		knowTruth[find(x)] = knowTruth[find(y)];
		return true;
	}

}
