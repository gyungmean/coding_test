import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());	
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {	// 남학생
				int count = 1;
				while(num * count <= N) {	// 스위치 개수 전까지 반복
					sw[num * count] = sw[num * count] == 1 ? 0 : 1;	// 받은 수의 배수를 인덱스로 활용하여 접근, XOR 연산으로 스위치 토글
					count++;
				}
			} else {	// 여학생
				int start = num-1;
				int end = num+1;
				while(start >=1 && end <=N) {	// 스위치 범위 안에서 반복
					if(sw[start] != sw[end]) break;	// 좌우 대칭 아니면 탈출					
					start--;
					end++;
				}
				start++; end--;	// 좌우 대칭이 아니기 바로 전 상태는 좌우 대칭
				
				for(int j = start; j <= end; j++) {
					sw[j] = sw[j] == 1 ? 0 : 1;	// XOR 연산으로 스위치 토글
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			bw.write(sw[i] + " ");
			if(i % 20 == 0) {	// 한 줄에 20개씩 출력
				bw.newLine();	
			}
		}	
		bw.flush();
		bw.close();
		br.close();
	}
}