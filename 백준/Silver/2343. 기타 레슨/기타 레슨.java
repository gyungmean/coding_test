import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lectureTime = new int[N];
		st = new StringTokenizer(br.readLine());
		int minTime = Integer.MIN_VALUE, maxTime = 0;
		for(int i = 0; i < N; i++) {
			lectureTime[i] = Integer.parseInt(st.nextToken());
			minTime = Math.max(minTime, lectureTime[i]);
			maxTime += lectureTime[i];
		}
		int answer = 0;
		while(minTime <= maxTime) {
			int bluelayTime = (minTime + maxTime) / 2;
			int sum = 0;
			int bluelayCount = 0;
			for(int time : lectureTime) {
				if(sum + time > bluelayTime) {
					bluelayCount++;
					sum = 0;
				}
				sum += time; 
			}
			if(sum != 0) bluelayCount++;
			if(bluelayCount <= M) {
				maxTime = bluelayTime - 1;
			}
			else {
				minTime = bluelayTime + 1;
			}
		}
		System.out.println(minTime);
	}

}
