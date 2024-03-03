import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	final static int[] dates = new int[13];
	static Flower[] flowers;
	static boolean[] isBlossom = new boolean[366];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 12; i++) {
			switch(i) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				dates[i] = 31;
				break;
			case 2:
				dates[i] = 28;
				break;
			case 4: case 6: case 9: case 11:
				dates[i] = 30;
				break;
			}
		}
		flowers = new Flower[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			if(startM == 12) continue; //12월에 피는 꽃은 볼 필요x
			if(endM == 2) continue; //2월에 지는 꽃도 볼필요x
			int startDay = 0, endDay = 0;
			for(int m = 1; m < startM; m++) {
				startDay += dates[m];
			}
			startDay += startD;
			for(int m = 1; m < endM; m++) {
				endDay += dates[m];
			}
			endDay += endD;
			flowers[i] = new Flower(startDay, endDay);
		}
		Arrays.sort(flowers);
		
		int flowerStart = 0, flowerEnd = 0;
		for(int m = 1; m < 3; m++) {
			flowerStart += dates[m];
		}
		flowerStart += 1; //3월 1일
		for(int m = 1; m < 12; m++) {
			flowerEnd += dates[m];
		}
		flowerEnd += 1; //12월 1일
		int count = 0, nextIdx = 0;
		int selectedFlowerEnd = 0;
		boolean newFlower = false;
		while(flowerStart < flowerEnd) {
			for(int i = nextIdx; i < N; i++) {
				//마지막으로 선택된 꽃의 지는 시기 보다 다음 꽃의 피는 시기가 늦어버리면 공백 생겨서 불가능한 경우의 수임
				if(flowers[i].start > flowerStart) break;
				if(selectedFlowerEnd < flowers[i].end) { 
					//선택된 꽃들이 지는 시기가 next에 오는게 더 느리면 next를 선택하는게 맞음
					selectedFlowerEnd = flowers[i].end;
					newFlower = true;
					nextIdx = i + 1;
				}
			}
			if(newFlower) {
				flowerStart = selectedFlowerEnd;
				count++;
				newFlower = false;
			}
			else break;
		}
		
		if(selectedFlowerEnd < flowerEnd) {
			System.out.println(0);
		}
		else {
			System.out.println(count);
		}
	}
	

	static class Flower implements Comparable<Flower>{
		int start;
		int end;
		public Flower(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Flower o) {
			if(this.start > o.start) return 1;
			else if(this.start == o.start) {
				if(this.end > o.end) return -1;
				else if(this.end == o.end) return 0;
				else return 1;
			}
			return -1;
		}
		
	}
}
