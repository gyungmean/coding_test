import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer = Integer.MAX_VALUE, n;
	static int[] s, b;
	static boolean[] is_selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 : n - 재료의 개수 , s - 신맛, b - 쓴맛
		//신맛과 쓴맛의 차이를 작게
		//s : 곱 b - 합
		//재료는 적어도 하나 사용 (모두 사용x)
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];
		is_selected = new boolean[n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(0, 1, 0); //신맛은 곱해야하니까
		//출력 : 신맛과 쓴맛의 차이
		System.out.println(answer);
	}
	
	static void calc(int cnt, int s_sum, int b_sum) {
		//선택된 원소들의 합
		if(cnt == n) { 
			int count = 0;
			for(int i = 0; i < n; i++) {
				if(is_selected[i] == false) count++;
			}
			if(count == n) return; // 공집합 거르기
			if(Math.abs(s_sum - b_sum) < answer) answer = Math.abs(s_sum - b_sum);
			return;
		}
		
		is_selected[cnt] = true; //부분집합에 포함
		calc(cnt + 1, s_sum * s[cnt], b_sum + b[cnt]);
		is_selected[cnt] = false; //부분집합에 비포함
		calc(cnt + 1, s_sum, b_sum);
	}
}
