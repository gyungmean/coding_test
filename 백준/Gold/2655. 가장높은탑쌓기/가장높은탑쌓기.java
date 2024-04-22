import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, max = Integer.MIN_VALUE;
	static Box[] box;
	static int[] DP;//DP[i] = 바닥이 i일때 최대 높이
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new Box[N];
		DP = new int[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			box[i] = new Box(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(box); //바닥 작은 순으로 정렬됨
		for(int i = 0; i < N; i++) {
			DP[i] = box[i].height;
		}
		fillDP();
		//System.out.println(Arrays.toString(DP));
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(DP[i] > max) {
				max = DP[i];
			}
		}
		int count = 0;
		Stack<Integer> temp = new Stack<>();
		for(int i = N - 1; i >= 0; i--) {
			if(DP[i] == max) {
				temp.add(box[i].num);
				max -= box[i].height;
				count++;
			}
			if(max == 0) break;
		}
		sb.append(count).append("\n");
		while(!temp.isEmpty()) {
			sb.append(temp.pop()).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	static void fillDP() {
		for(int i = 0; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(box[i].weight > box[j].weight) {
					DP[i] = Math.max(DP[i], DP[j] + box[i].height);
				}
			}
		}
	}
	
	static class Box implements Comparable<Box>{
		int num;
		int bottom;
		int height;
		int weight;
		public Box(int num, int bottom, int height, int weight) {
			super();
			this.num = num;
			this.bottom = bottom;
			this.height = height;
			this.weight = weight;
		}
		@Override
		public int compareTo(Box o) {
			if(o.bottom < this.bottom) return 1;
			else if(o.bottom == this.bottom) return 0;
			return -1;
		}
	}

}