import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //접시 수
		int d = Integer.parseInt(st.nextToken()); //초밥 종류
		int k = Integer.parseInt(st.nextToken()); //연속으로 몇개 먹는지
		int c = Integer.parseInt(st.nextToken()); //쿠폰의 수
		
		int[] sushi = new int[n];
		for(int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		boolean[] eatCheck = new boolean[d + 1];
		int answer = -1;
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				if(!eatCheck[sushi[(i + j) % n]]) {
					eatCheck[sushi[(i + j) % n]] = true;
					count++;
				}
			}
			if(!eatCheck[c]) {
				answer = Math.max(answer, count + 1);
			}
			answer = Math.max(answer, count);
			eatCheck[sushi[i]] = false;
			count--;

		}
		System.out.println(answer);
	}

}
