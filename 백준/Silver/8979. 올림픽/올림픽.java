import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Info[] infoList = new Info[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int nation = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			infoList[i] = new Info(nation, gold, silver, bronze);
		}
		
		Arrays.sort(infoList);
		
		int[] rank = new int[n + 1];
		rank[infoList[0].nation] = 1;
		int nowRank = 1;
		int nextRank = 2;
		Info preInfo = infoList[0];
		for(int i = 1; i < n; i++) {
			if(infoList[i].gold == preInfo.gold &&
					infoList[i].silver == preInfo.silver &&
					infoList[i].bronze == preInfo.bronze) {
				rank[infoList[i].nation] = nowRank;
				nextRank++;
			}
			else {
				rank[infoList[i].nation] = nextRank;
				nowRank = nextRank++;
				preInfo = infoList[i];
			}
		}
		System.out.println(rank[k]);
	}
	
	static class Info implements Comparable<Info>{
		int nation;
		int gold;
		int silver;
		int bronze;
		
		public Info(int nation, int gold, int silver, int bronze) {
			super();
			this.nation = nation;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Info o) {
			if(this.gold > o.gold) {
				return -1;
			}
			else if(this.gold == o.gold && this.silver > o.silver) {
				return -1;
			}
			else if(this.gold == o.gold && this.silver == o.silver && this.bronze > o.bronze) {
				return -1;
			}
			return 1;
		}
	}

}
