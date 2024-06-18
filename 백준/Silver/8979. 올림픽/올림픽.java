import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//금 100 은 10 동 1
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
			
			int score = gold * 100 + silver * 10 + bronze * 1;
			
			
			infoList[i] = new Info(nation, score);
		}
		
		Arrays.sort(infoList);
		
		int[] rank = new int[n + 1];
		rank[infoList[0].nation] = 1;
		int nowRank = 1;
		int nextRank = 2;
		int preScore = infoList[0].score;
		for(int i = 1; i < n; i++) {
			if(preScore == infoList[i].score) {
				rank[infoList[i].nation] = nowRank;
				nextRank++;
			}
			else {
				rank[infoList[i].nation] = nextRank;
				nowRank = nextRank++;
				preScore = infoList[i].score;
			}
		}
		System.out.println(rank[k]);
		

	}
	
	
	static class Info implements Comparable<Info>{
		int nation;
		int score;
		public Info(int nation, int score) {
			super();
			this.nation = nation;
			this.score = score;
		}
		@Override
		public int compareTo(Info o) {
			if(this.score > o.score) {
				return -1;
			}
			return 1;
		}
	}

}
