import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Long> rankScore;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long newScore = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		rankScore = new ArrayList<>();
		rank = new int[P];
		if(N > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				rankScore.add(Long.parseLong(st.nextToken()));
			}
		}
		
		if(N < P) {
			rankScore.add(newScore);
			Collections.sort(rankScore);
			Collections.reverse(rankScore);
			getRank();
			System.out.println(rank[rankScore.indexOf(newScore)]);
		}
		else {
			if(rankScore.get(N - 1) >= newScore) {
				System.out.println(-1);
			}
			else {
				rankScore.add(newScore);
				Collections.sort(rankScore);
				Collections.reverse(rankScore);
				rankScore.remove(P);
				getRank();
				System.out.println(rank[rankScore.indexOf(newScore)]);
			}
		}
	}
	
	static void getRank() {
		int nowRank = 1;
		int nextRank = 2;
		long preScore = rankScore.get(0);
		rank[0] = 1;
		for(int i = 1; i < rankScore.size(); i++) {
			if(preScore == rankScore.get(i)) {
				rank[i] = nowRank;
				nextRank++;
			}
			else {
				rank[i] = nextRank;
				nowRank = nextRank++;
				preScore = rankScore.get(i);
			}
		}
	}

}
