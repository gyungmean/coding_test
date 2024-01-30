import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 : n - 스위치 개수 , 스위치 상태, 학생 수, 학생 성별 + 스위치번호
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int student = Integer.parseInt(br.readLine());
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				//학생 성별 1
				//스위치 개수 맞춰서 인덱스 배수들 스위치 모두 바꾸기
				for(int j = num; j <= n; j += num) {
					switches[j] = switches[j] == 1 ? 0 : 1;
				}
			}
			else if(gender == 2) {
				//학생 성별 2
				//해당 스위치 인덱스 i - 1 / i + 1 비교 
				//-> i - j / i + j 값이 다를때까지 두개 비교해서 i-j ~ i+j
				int start = num - 1;
				int end = num + 1;
				
				while(1 <= start && end <= n) {
					if(switches[start] != switches[end]) break;
					else {
						start--;
						end++;
					}
				}
				start++;
				end--;
				for(int j = start; j <= end; j++) {
					switches[j] = switches[j] == 1 ? 0 : 1;
				}
				
			}
		}
		//출력 : 스위치 한줄에 20개씩 한칸씩 띄고 출력
		for(int i = 1; i <= n; i++) {
			System.out.print(switches[i] + " ");
			if(i % 20 == 0) System.out.println();
		}

	}

}
